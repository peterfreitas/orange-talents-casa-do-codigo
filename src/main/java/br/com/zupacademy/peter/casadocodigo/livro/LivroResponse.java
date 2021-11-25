package br.com.zupacademy.peter.casadocodigo.livro;

import java.util.List;
import java.util.stream.Collectors;

public class LivroResponse {

    private Long id;
    private String titulo;

    public LivroResponse(Livro livro) {
        this.id = livro.getId();
        this.titulo = livro.getTitulo();
    }

    public LivroResponse() {
    }

    public Long getId() {
        return id;
    }

    public String getTitulo() {
        return titulo;
    }

    public static List<LivroResponse> converte(List<Livro> livros) {
        return livros.stream().map(LivroResponse::new).collect(Collectors.toList());
    }

}