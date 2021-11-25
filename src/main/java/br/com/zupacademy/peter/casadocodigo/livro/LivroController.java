package br.com.zupacademy.peter.casadocodigo.livro;

import br.com.zupacademy.peter.casadocodigo.autor.AutorRepository;
import br.com.zupacademy.peter.casadocodigo.categoria.CategoriaRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.transaction.Transactional;
import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping(value = "/livros")
public class LivroController {

    private LivroRepository livroRepository;
    private AutorRepository autorRepository;
    private CategoriaRepository categoriaRepository;

    public LivroController(LivroRepository livroRepository, AutorRepository autorRepository,
                           CategoriaRepository categoriaRepository) {
        this.livroRepository = livroRepository;
        this.autorRepository = autorRepository;
        this.categoriaRepository = categoriaRepository;
    }

    @PostMapping
    @Transactional
    public ResponseEntity<?> cadastroLivro(@RequestBody @Valid LivroRequest livroRequest) {
        Livro livro = livroRequest.toModel(autorRepository, categoriaRepository);
        livroRepository.save(livro);
        return ResponseEntity.ok().build();
    }

    @GetMapping
    public List<LivroResponse> listaTudo() {
        List<Livro> livros = livroRepository.findAll();
        return new LivroResponse().converte(livros);
    }
}
