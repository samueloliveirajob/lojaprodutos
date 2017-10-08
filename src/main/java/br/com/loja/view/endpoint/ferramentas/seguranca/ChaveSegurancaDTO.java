package br.com.loja.view.endpoint.ferramentas.seguranca;

import com.fasterxml.jackson.annotation.JsonProperty;

import br.com.loja.domain.ferramentas.seguranca.ChaveSeguranca;

public class ChaveSegurancaDTO {

    @JsonProperty("client_id")
    private String idCliente;
    @JsonProperty("client_secret")
    private String chaveSeguranca;
    @JsonProperty("callback_url")
    private String urlCallback;

    public ChaveSegurancaDTO() {

        this.idCliente = "2c0f919fc0ed02cec1290e2f9fe107ff";
        this.chaveSeguranca = "ec5ec4a06301e0e342e45a4cbdc5ed35";
        this.urlCallback = "http://www.nasp.com.br";
    }

    public ChaveSegurancaDTO(ChaveSeguranca chaveSeguranca) {
        this.idCliente = chaveSeguranca.idCliente();
        this.chaveSeguranca = chaveSeguranca.chaveSeguranca();
        this.urlCallback = chaveSeguranca.urlCallback();
    }

    public String getIdCliente() {
        return idCliente;
    }

    public String getChaveSeguranca() {
        return chaveSeguranca;
    }

    public String getUrlCallback() {
        return urlCallback;
    }

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
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ChaveSegurancaDTO that = (ChaveSegurancaDTO) o;

        if (idCliente != null ? !idCliente.equals(that.idCliente) : that.idCliente != null) return false;
        if (chaveSeguranca != null ? !chaveSeguranca.equals(that.chaveSeguranca) : that.chaveSeguranca != null)
            return false;
        return urlCallback != null ? urlCallback.equals(that.urlCallback) : that.urlCallback == null;
    }

    @Override
    public int hashCode() {
        int result = idCliente != null ? idCliente.hashCode() : 0;
        result = 31 * result + (chaveSeguranca != null ? chaveSeguranca.hashCode() : 0);
        result = 31 * result + (urlCallback != null ? urlCallback.hashCode() : 0);
        return result;
    }
}
