package br.com.zupacademy.peter.casadocodigo.localizacao.estado;

import br.com.zupacademy.peter.casadocodigo.localizacao.pais.PaisRepository;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.transaction.Transactional;
import javax.validation.Valid;

@RestController
public class EstadoController {

    private EstadoRepository estadoRepository;
    private PaisRepository paisRepository;

    public EstadoController(EstadoRepository estadoRepository, PaisRepository paisRepository) {
        this.estadoRepository = estadoRepository;
        this.paisRepository = paisRepository;
    }

    @PostMapping(value = "/estados")
    @Transactional
    public void cadastraEstado(@RequestBody @Valid EstadoRequest estadoRequest){
        Estado estado = estadoRequest.toModel(paisRepository);

        estadoRepository.save(estado);
    }
}
