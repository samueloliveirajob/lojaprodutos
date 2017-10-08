package br.com.loja.infrastructure.repository.trng.maquininha.entity;

import java.util.Date;

import br.com.loja.domain.maquininha.Maquininha;

public class MaquininhaEntity implements Maquininha {

    private String modelo;
    private String cogigoAtivacao;
    private String numeroSerie;
    private Date dataCompra;
    private Double valor;
    private String status;

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public void setCogigoAtivacao(String cogigoAtivacao) {
        this.cogigoAtivacao = cogigoAtivacao;
    }

    public void setNumeroSerie(String numeroSerie) {
        this.numeroSerie = numeroSerie;
    }

    public void setDataCompra(Date dataCompra) {
        this.dataCompra = dataCompra;
    }

    public void setValor(Double valor) {
        this.valor = valor;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @Override
    public String modelo() {
        return this.modelo;
    }

    @Override
    public String cogigoAtivacao() {
        return this.cogigoAtivacao;
    }

    @Override
    public String numeroSerie() {
        return this.numeroSerie;
    }

    @Override
    public Date dataCompra() {
        return this.dataCompra;
    }

    @Override
    public Double valor() {
        return this.valor;
    }

    @Override
    public String status() {
        return this.status;
    }
}
