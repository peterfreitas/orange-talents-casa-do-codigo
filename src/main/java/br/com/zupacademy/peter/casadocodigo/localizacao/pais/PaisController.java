package br.com.zupacademy.peter.casadocodigo.localizacao.pais;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.transaction.Transactional;
import javax.validation.Valid;

@RestController
public class PaisController {

    private PaisRepository paisRepository;

    public PaisController(PaisRepository paisRepository) {
        this.paisRepository = paisRepository;
    }

    @PostMapping(value = "/paises")
    @Transactional
    public void cadastraPais(@Valid @RequestBody PaisRequest paisRequest){
        Pais pais = paisRequest.toModel();
        paisRepository.save(pais);
    }
}