package br.com.loja.infrastructure.repository.trng.ferramentas.seguranca.entity;

import br.com.loja.domain.ferramentas.seguranca.ChaveSeguranca;

public class ChaveSegurancaEntity implements ChaveSeguranca {

    private String idCliente;
    private String chaveSeguranca;
    private String urlCallback;

    public void setIdCliente(String idCliente) {
        this.idCliente = idCliente;
    }

    public void setChaveSeguranca(String chaveSeguranca) {
        this.chaveSeguranca = chaveSeguranca;
    }

    public void setUrlCallback(String urlCallback) {
        this.urlCallback = urlCallback;
    }

    @Override
    public String idCliente() {
        return this.idCliente;
    }

    @Override
    public String chaveSeguranca() {
        return this.chaveSeguranca;
    }

    @Override
    public String urlCallback() {
        return this.urlCallback;
    }
}
