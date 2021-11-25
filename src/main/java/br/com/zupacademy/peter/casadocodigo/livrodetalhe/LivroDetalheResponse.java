package br.com.zupacademy.peter.casadocodigo.livrodetalhe;

import br.com.zupacademy.peter.casadocodigo.livro.Livro;

import java.math.BigDecimal;

public class LivroDetalheResponse {

        private String titulo;
        private String resumo;
        private String sumario;
        private BigDecimal preco;
        private Integer Paginas;
        private String isbn;
        private String nomeAutor;
        private String descricaoAutor;

        public LivroDetalheResponse(Livro livro) {
            this.titulo = livro.getTitulo();
            this.resumo = livro.getResumo();
            this.sumario = livro.getSumario();
            this.preco = livro.getPreco();
            this.Paginas = livro.getPaginas();
            this.isbn = livro.getIsbn();
            this.nomeAutor = livro.getIdAutor().getNome();
            this.descricaoAutor = livro.getIdAutor().getDescricao();
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

        public Integer getNumeroPaginas() {
            return Paginas;
        }

        public String getIsbn() {
            return isbn;
        }

        public String getNomeAutor() {
            return nomeAutor;
        }
    }