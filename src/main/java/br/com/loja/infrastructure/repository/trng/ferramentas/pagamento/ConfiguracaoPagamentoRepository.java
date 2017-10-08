package br.com.loja.infrastructure.repository.trng.ferramentas.pagamento;

import br.com.loja.domain.ferramentas.pagamento.ConfiguracaoPagamento;

public interface ConfiguracaoPagamentoRepository {

    ConfiguracaoPagamento findBy(Long idVendedor);
}
