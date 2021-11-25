package br.com.zupacademy.peter.casadocodigo.livro;

import br.com.zupacademy.peter.casadocodigo.autor.Autor;
import br.com.zupacademy.peter.casadocodigo.autor.AutorRepository;
import br.com.zupacademy.peter.casadocodigo.categoria.Categoria;
import br.com.zupacademy.peter.casadocodigo.categoria.CategoriaRepository;
import br.com.zupacademy.peter.casadocodigo.validator.ExistsId;
import br.com.zupacademy.peter.casadocodigo.validator.UniqueValue;

import javax.validation.constraints.*;
import java.math.BigDecimal;
import java.time.LocalDate;

public class LivroRequest {

    @NotBlank
    @UniqueValue(domainClass = Livro.class, fieldName = "titulo")
    private String titulo;
    @NotBlank
    @Size(max = 500)
    private String resumo;
    private String sumario;
    @NotNull
    @Min(20)
    private BigDecimal preco;
    @NotNull
    private Integer paginas;
    @NotBlank
    @UniqueValue(domainClass = Livro.class, fieldName = "isbn")
    private String isbn;
    @Future
    private LocalDate dataPublicacao;
    @NotNull
    @ExistsId(domainClass = Categoria.class, fieldName = "idCategoria")
    private Long idCategoria;
    @NotNull
    @ExistsId(domainClass = Autor.class, fieldName = "idAutor")
    private Long idAutor;

    public LivroRequest(@NotBlank String titulo, @NotBlank @Size(max = 500) String resumo, String sumario,
                        @NotBlank @Size(min = 20) BigDecimal preco, @NotBlank Integer paginas, @NotBlank String isbn,
                        @NotBlank LocalDate dataPublicacao, @NotBlank Long idCategoria, @NotBlank Long idAutor) {
        this.titulo = titulo;
        this.resumo = resumo;
        this.sumario = sumario;
        this.preco = preco;
        this.paginas = paginas;
        this.isbn = isbn;
        this.dataPublicacao = dataPublicacao;
        this.idCategoria = idCategoria;
        this.idAutor = idAutor;
    }

    public Livro toModel(AutorRepository autorRepository, CategoriaRepository categoriaRepository) {

        Categoria categoria = categoriaRepository.findById(idCategoria).get();
        Autor autor = autorRepository.findById(idAutor).get();

        return new Livro(this.titulo, this.resumo, this.sumario, this.preco, this.paginas, this.isbn,
                this.dataPublicacao, autor, categoria);
    }
}