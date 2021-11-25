package br.com.zupacademy.peter.casadocodigo.autor;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.transaction.Transactional;
import javax.validation.Valid;

@RestController
public class AutorController {

    private AutorRepository autorRepository;
    public AutorController(AutorRepository autorRepository) {
        this.autorRepository = autorRepository;
    }

    @PostMapping(value = "/autores")
    @Transactional
    public ResponseEntity<?> cadastroAutor(@RequestBody @Valid AutorRequest autorRequest) {
        Autor autor = autorRequest.toModel();
        autorRepository.save(autor);
        return ResponseEntity.ok().build();
    }
}