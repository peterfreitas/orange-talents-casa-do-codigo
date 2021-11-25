package br.com.zupacademy.peter.casadocodigo.localizacao.estado;

import br.com.zupacademy.peter.casadocodigo.localizacao.pais.Pais;
import br.com.zupacademy.peter.casadocodigo.localizacao.pais.PaisRepository;
import br.com.zupacademy.peter.casadocodigo.validator.EstadoUnico;
import br.com.zupacademy.peter.casadocodigo.validator.ExistsId;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@EstadoUnico
public class EstadoRequest {

    @NotBlank
    private String nome;
    @NotNull @ExistsId(domainClass = Pais.class, fieldName = "id")
    private Long paisId;

    public Estado toModel(PaisRepository paisRepository) {
        Pais pais = paisRepository.getById(paisId);

        return new Estado(this.nome, pais);
    }

    public String getNome() {
        return nome;
    }

    public Long getPaisId() {
        return paisId;
    }
}
