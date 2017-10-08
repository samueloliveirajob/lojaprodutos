package br.com.loja.infrastructure.repository.trng.loja.entity;

import br.com.loja.domain.loja.Telefone;

public class TelefoneEntity implements Telefone {

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
