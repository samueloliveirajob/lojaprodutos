package br.com.loja.view.endpoint.ferramentas.pagamento;

import com.fasterxml.jackson.annotation.JsonProperty;

import br.com.loja.domain.ferramentas.pagamento.ConfiguracaoPagamento;

public class ConfiguracaoPagamentoDTO {

    @JsonProperty("minimum_installment_amount")
    private Double valorMinimoDaParcela;
    @JsonProperty("maximum_number_installments")
    private int numeroMaximoDeParcelas;

    public ConfiguracaoPagamentoDTO(ConfiguracaoPagamento pagamento) {
        this.valorMinimoDaParcela = pagamento.valorMinimoDaParcela();
        this.numeroMaximoDeParcelas = pagamento.numeroMaximoDeParcelas();
    }

    public Double getValorMinimoDaParcela() {
        return valorMinimoDaParcela;
    }

    public int getNumeroMaximoDeParcelas() {
        return numeroMaximoDeParcelas;
    }
}
