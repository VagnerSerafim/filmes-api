package com.vagner.filmesapi.dto;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;

public class FilmeRequest {

    @NotBlank
    private String titulo;

    @NotBlank
    private String diretor;

    @Min(1900)
    private int ano;

    @NotBlank
    private String genero;

    // ✅ Construtor padrão necessário para serialização e compatibilidade com Swagger
    public FilmeRequest() {
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getDiretor() {
        return diretor;
    }

    public void setDiretor(String diretor) {
        this.diretor = diretor;
    }

    public int getAno() {
        return ano;
    }

    public void setAno(int ano) {
        this.ano = ano;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }
}