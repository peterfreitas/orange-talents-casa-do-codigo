package br.com.zupacademy.peter.casadocodigo.autor;

import br.com.zupacademy.peter.casadocodigo.validator.UniqueValue;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.time.LocalDateTime;

@Entity
public class Autor {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idAutor;
    @Column(nullable = false)
    @NotBlank
    private String nome;
    @Email
    @NotBlank
    @Column(nullable = false)
    private String email;
    @NotBlank
    @Size(max = 400)
    @Column(nullable = false, length = 400)
    private String descricao;
    @Column(nullable = false)
    private LocalDateTime instanteCriacao = LocalDateTime.now();

    @Deprecated
    public Autor() {
    }

    public Autor(String nome, String email, String descricao) {
        this.nome = nome;
        this.email = email;
        this.descricao = descricao;
    }

    public String getNome() {
        return nome;
    }

    public String getDescricao() {
        return descricao;
    }
}
