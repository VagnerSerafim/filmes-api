package com.vagner.filmesapi.service;

import com.vagner.filmesapi.dto.FilmeRequest;
import com.vagner.filmesapi.exception.ResourceNotFoundException;
import com.vagner.filmesapi.model.Filme;
import com.vagner.filmesapi.repository.FilmeRepository;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.ReflectionUtils;

import java.lang.reflect.Field;
import java.util.List;
import java.util.Map;
@Service
public class FilmeService {
    @Autowired
    private FilmeRepository repo;

    public List<Filme> listarTodos() {
        return repo.findAll();
    }

    public Filme buscarPorId(Long id) {
        return repo.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Filme não encontrado com ID: " + id));
    }

    public Filme salvar(FilmeRequest request) {
        Filme filme = new Filme();
        BeanUtils.copyProperties(request, filme);
        return repo.save(filme);
    }

    public Filme atualizar(Long id, FilmeRequest request) {
        Filme filme = buscarPorId(id);
        BeanUtils.copyProperties(request, filme);
        filme.setId(id);
        return repo.save(filme);
    }

    public Filme atualizarParcial(Long id, Map<String, Object> campos) {
        Filme filme = buscarPorId(id);
        campos.forEach((k, v) -> {
            Field field = ReflectionUtils.findField(Filme.class, k);
            if (field != null) {
                field.setAccessible(true);
                ReflectionUtils.setField(field, filme, v);
            }
        });
        return repo.save(filme);
    }

    public void deletar(Long id) {
        repo.delete(buscarPorId(id));
    }

    public List<Filme> buscarPorGenero(String genero) {
        return repo.findByGeneroIgnoreCase(genero);
    }
}
