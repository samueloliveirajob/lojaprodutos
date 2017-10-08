package br.com.loja.infrastructure.repository.trng.venda.entity;

import br.com.loja.domain.venda.Entrega;

public class EntregaEntity implements Entrega {

    private Double valor;
    private EnderecoEntregaEntity endereco;

    @Override
    public Double valor() {
        return this.valor;
    }

    @Override
    public EnderecoEntregaEntity endereco() {
        return this.endereco;
    }

    public void setValor(Double valor) {
        this.valor = valor;
    }

    public void setEndereco(EnderecoEntregaEntity endereco) {
        this.endereco = endereco;
    }
}
