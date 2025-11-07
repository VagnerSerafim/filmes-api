package com.vagner.filmesapi.dto;
import com.vagner.filmesapi.model.Filme;


public class FilmeResponse {

    private Long id;
    private String titulo;
    private String diretor;
    private int ano;
    private String genero;

    public FilmeResponse() {
    }

    public FilmeResponse(Filme filme) {
        this.id = filme.getId();
        this.titulo = filme.getTitulo();
        this.diretor = filme.getDiretor();
        this.ano = filme.getAno();
        this.genero = filme.getGenero();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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