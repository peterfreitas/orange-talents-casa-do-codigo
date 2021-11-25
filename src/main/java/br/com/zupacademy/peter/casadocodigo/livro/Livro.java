package br.com.zupacademy.peter.casadocodigo.livro;

import br.com.zupacademy.peter.casadocodigo.autor.Autor;
import br.com.zupacademy.peter.casadocodigo.categoria.Categoria;

import javax.persistence.*;
import javax.validation.constraints.*;
import java.math.BigDecimal;
import java.time.LocalDate;

@Entity
public class Livro {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotBlank
    private String titulo;
    @NotBlank
    @Size(max = 500)
    private String resumo;
    @NotBlank
    private String sumario;
    @NotNull
    @Min(20)
    private BigDecimal preco;
    @Min(100)
    private int paginas;
    @NotBlank
    private String isbn;
    @NotNull
    @Future
    private LocalDate dataPublicacao;
    @ManyToOne
    @NotNull
    private Autor idAutor;
    @ManyToOne
    @NotNull
    private Categoria idCategoria;

    @Deprecated
    public Livro() {

    }

    public Livro(@NotBlank String titulo, @NotBlank @Size(max = 500) String resumo, @NotBlank String sumario,
                 @NotNull @Min(20) BigDecimal preco, @Min(100) int paginas, @NotBlank String isbn,
                 @Future @NotNull LocalDate dataPublicacao, @NotNull Autor idAutor,
                 @NotNull Categoria idCategoria) {
        this.titulo = titulo;
        this.resumo = resumo;
        this.sumario = sumario;
        this.preco = preco;
        this.paginas = paginas;
        this.isbn = isbn;
        this.dataPublicacao = dataPublicacao;
        this.idAutor = idAutor;
        this.idCategoria = idCategoria;
    }

    public Long getId() {
        return id;
    }

    public String getTitulo() {
        return titulo;
    }

    public String getResumo() {
        return resumo;
    }

    public String getSumario() {
        return sumario;
    }

    public BigDecimal getPreco() {
        return preco;
    }

    public String getIsbn() {
        return isbn;
    }

    public Livro(int paginas) {
        this.paginas = paginas;
    }

    public Autor getIdAutor() {
        return idAutor;
    }

    public Integer getPaginas() {
        return paginas;
    }

}