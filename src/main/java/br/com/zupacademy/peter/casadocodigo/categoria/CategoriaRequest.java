package br.com.zupacademy.peter.casadocodigo.categoria;

import javax.validation.constraints.NotBlank;

import br.com.zupacademy.peter.casadocodigo.validator.UniqueValue;

public class CategoriaRequest {

    @NotBlank
    @UniqueValue(domainClass = Categoria.class, fieldName = "nome")
    private String nome;

    public String getNome() {
        return nome;
    }

    public Categoria toModel() {
        return new Categoria(nome);
    }
}