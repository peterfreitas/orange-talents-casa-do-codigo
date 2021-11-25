package br.com.zupacademy.peter.casadocodigo.autor;

import br.com.zupacademy.peter.casadocodigo.validator.UniqueValue;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

public class AutorRequest {
    @NotBlank
    private String nome;
    @Email
    @NotBlank
    @UniqueValue(domainClass = Autor.class, fieldName = "email")
    private String email;
    @NotBlank
    @Size(max = 400)
    private String descricao;

    public AutorRequest(String nome, String email, String descricao) {
        this.nome = nome;
        this.email = email;
        this.descricao = descricao;
    }

    public Autor toModel () {
        return new Autor(this.nome, this.email, this.descricao);
    }
}
