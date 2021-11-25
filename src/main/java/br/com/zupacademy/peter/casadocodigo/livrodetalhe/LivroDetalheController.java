package br.com.zupacademy.peter.casadocodigo.livrodetalhe;

import br.com.zupacademy.peter.casadocodigo.livro.Livro;
import br.com.zupacademy.peter.casadocodigo.livro.LivroRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController
@RequestMapping("/livros")
public class LivroDetalheController {

    private LivroRepository livroRepository;

    public LivroDetalheController(LivroRepository livroRepository) {

        this.livroRepository = livroRepository;
    }

    @GetMapping("/{id}")
    public ResponseEntity<LivroDetalheResponse> detalhar(@PathVariable Long id) {
        Optional<Livro> livro = livroRepository.findById(id);

        if (livro.isPresent()) {
            return ResponseEntity.ok(new LivroDetalheResponse(livro.get()));
        }

        return ResponseEntity.notFound().build();
    }

}