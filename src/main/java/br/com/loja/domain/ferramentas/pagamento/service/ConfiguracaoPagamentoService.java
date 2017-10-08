package br.com.loja.domain.ferramentas.pagamento.service;

import br.com.loja.domain.ferramentas.pagamento.ConfiguracaoPagamento;

public interface ConfiguracaoPagamentoService {

    ConfiguracaoPagamento findBy(Long idVendedor);
}
