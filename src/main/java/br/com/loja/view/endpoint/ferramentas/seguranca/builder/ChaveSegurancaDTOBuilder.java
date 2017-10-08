package br.com.loja.view.endpoint.ferramentas.seguranca.builder;

import br.com.loja.view.endpoint.ferramentas.seguranca.ChaveSegurancaDTO;

public final class ChaveSegurancaDTOBuilder {
    private String idCliente;
    private String chaveSeguranca;
    private String urlCallback;

    private ChaveSegurancaDTOBuilder() {
    }

    public static ChaveSegurancaDTOBuilder aChaveSegurancaDTO() {
        return new ChaveSegurancaDTOBuilder();
    }

    public ChaveSegurancaDTOBuilder withIdCliente(String idCliente) {
        this.idCliente = idCliente;
        return this;
    }

    public ChaveSegurancaDTOBuilder withChaveSeguranca(String chaveSeguranca) {
        this.chaveSeguranca = chaveSeguranca;
        return this;
    }

    public ChaveSegurancaDTOBuilder withUrlCallback(String urlCallback) {
        this.urlCallback = urlCallback;
        return this;
    }

    public ChaveSegurancaDTO build() {
        ChaveSegurancaDTO chaveSegurancaDTO = new ChaveSegurancaDTO();
        chaveSegurancaDTO.setIdCliente(idCliente);
        chaveSegurancaDTO.setChaveSeguranca(chaveSeguranca);
        chaveSegurancaDTO.setUrlCallback(urlCallback);
        return chaveSegurancaDTO;
    }
}
