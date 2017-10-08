package br.com.loja.infrastructure.repository.trng.venda.entity;

import br.com.loja.domain.venda.Status;

public class StatusEntity implements Status {

    private String codigo;
    private String descricao;

    @Override
    public String codigo() {
        return this.codigo;
    }

    @Override
    public String descricao() {
        return this.descricao;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }
}
