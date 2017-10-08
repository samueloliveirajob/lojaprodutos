package br.com.loja.infrastructure.repository.trng.loja.entity;

import br.com.loja.domain.loja.Documento;

public class DocumentoEntity implements Documento {

    private String tipo;
    private String valor;

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public void setValor(String valor) {
        this.valor = valor;
    }

    @Override
    public String tipo() {
        return this.tipo;
    }

    @Override
    public String valor() {
        return this.valor;
    }
}
