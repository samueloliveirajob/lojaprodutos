package br.com.loja.view.endpoint.maquininha;

import com.fasterxml.jackson.annotation.JsonProperty;

import br.com.loja.domain.maquininha.Maquininha;

import java.util.Date;

public class MaquininhaDTO {

    @JsonProperty("model")
    private String modelo;
    @JsonProperty("activation_code")
    private String cogigoAtivacao;
    @JsonProperty("serial_number")
    private String numeroSerie;
    @JsonProperty("purchase_date")
    private Date dataCompra;
    @JsonProperty("value")
    private Double valor;
    @JsonProperty("status")
    private String status;

    public MaquininhaDTO(Maquininha maquininha) {
        this.modelo = maquininha.modelo();
        this.cogigoAtivacao = maquininha.cogigoAtivacao();
        this.numeroSerie = maquininha.numeroSerie();
        this.dataCompra = maquininha.dataCompra();
        this.valor = maquininha.valor();
        this.status = maquininha.status();
    }

    public String getModelo() {
        return modelo;
    }

    public String getCogigoAtivacao() {
        return cogigoAtivacao;
    }

    public String getNumeroSerie() {
        return numeroSerie;
    }

    public Date getDataCompra() {
        return dataCompra;
    }

    public Double getValor() {
        return valor;
    }

    public String getStatus() {
        return status;
    }
}
