package br.com.loja.infrastructure.repository.trng.venda.entity;

import br.com.loja.domain.venda.Produto;

public class ProdutoEntity implements Produto {

    private String nome;
    private Double valor;

    @Override
    public String nome() {
        return this.nome;
    }

    @Override
    public Double valor() {
        return this.valor;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setValor(Double valor) {
        this.valor = valor;
    }
}
