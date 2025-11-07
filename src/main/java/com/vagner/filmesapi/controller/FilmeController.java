package com.vagner.filmesapi.controller;

import com.vagner.filmesapi.dto.FilmePatchRequest;
import com.vagner.filmesapi.model.Filme;
import com.vagner.filmesapi.dto.FilmeRequest;
import com.vagner.filmesapi.dto.FilmeResponse;
import com.vagner.filmesapi.service.FilmeService;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;

import jakarta.validation.Valid;
import java.util.List;
import java.util.Map;

@Tag(name = "Filmes", description = "Operações de CRUD e filtro por gênero")

@RestController
@RequestMapping("/filmes")
public class FilmeController {
    @Autowired
    private FilmeService service;

    @GetMapping
    public List<FilmeResponse> listar() {
        return service.listarTodos().stream().map(FilmeResponse::new).toList();
    }

    @GetMapping("/{id}")
    public FilmeResponse buscar(@PathVariable Long id) {
        return new FilmeResponse(service.buscarPorId(id));
    }

    @PostMapping
    public ResponseEntity<FilmeResponse> criar(@RequestBody @Valid FilmeRequest request) {
        Filme filme = service.salvar(request);
        return ResponseEntity.status(HttpStatus.CREATED).body(new FilmeResponse(filme));
    }

    @PutMapping("/{id}")
    public FilmeResponse atualizar(@PathVariable Long id, @RequestBody @Valid FilmeRequest request) {
        return new FilmeResponse(service.atualizar(id, request));
    }

    @PatchMapping("/{id}")
    public FilmeResponse atualizarParcial(@PathVariable Long id, @RequestBody FilmePatchRequest patch) {
        Map<String, Object> campos = new java.util.HashMap<>();
        if (patch.getTitulo() != null) campos.put("titulo", patch.getTitulo());
        if (patch.getDiretor() != null) campos.put("diretor", patch.getDiretor());
        if (patch.getAno() != null) campos.put("ano", patch.getAno());
        if (patch.getGenero() != null) campos.put("genero", patch.getGenero());
        return new FilmeResponse(service.atualizarParcial(id, campos));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletar(@PathVariable Long id) {
        service.deletar(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/genero/{genero}")
    public List<FilmeResponse> buscarPorGenero(@PathVariable String genero) {
        return service.buscarPorGenero(genero).stream().map(FilmeResponse::new).toList();
    }
}