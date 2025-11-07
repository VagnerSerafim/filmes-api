package com.vagner.filmesapi.repository;

import com.vagner.filmesapi.model.Filme;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface FilmeRepository extends JpaRepository<Filme, Long> {
    List<Filme> findByGeneroIgnoreCase(String genero);
}