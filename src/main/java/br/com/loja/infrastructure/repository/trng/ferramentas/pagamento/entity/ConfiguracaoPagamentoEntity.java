package br.com.loja.infrastructure.repository.trng.ferramentas.pagamento.entity;

import br.com.loja.domain.ferramentas.pagamento.ConfiguracaoPagamento;

public class ConfiguracaoPagamentoEntity implements ConfiguracaoPagamento {

    private Double valorMinimoDaParcela;
    private int numeroMaximoDeParcelas;

    public void setValorMinimoDaParcela(Double valorMinimoDaParcela) {
        this.valorMinimoDaParcela = valorMinimoDaParcela;
    }

    public void setNumeroMaximoDeParcelas(int numeroMaximoDeParcelas) {
        this.numeroMaximoDeParcelas = numeroMaximoDeParcelas;
    }

    @Override
    public Double valorMinimoDaParcela() {
        return this.valorMinimoDaParcela;
    }

    @Override
    public int numeroMaximoDeParcelas() {
        return this.numeroMaximoDeParcelas;
    }
}
