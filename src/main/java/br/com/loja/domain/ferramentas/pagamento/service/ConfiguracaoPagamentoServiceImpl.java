package br.com.loja.domain.ferramentas.pagamento.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.loja.domain.ferramentas.pagamento.ConfiguracaoPagamento;
import br.com.loja.infrastructure.repository.trng.ferramentas.pagamento.ConfiguracaoPagamentoRepository;

@Service
public class ConfiguracaoPagamentoServiceImpl implements ConfiguracaoPagamentoService {

    @Autowired
    ConfiguracaoPagamentoRepository repository;

    @Override
    public ConfiguracaoPagamento findBy(Long idVendedor) {

        ConfiguracaoPagamento pagamento = repository.findBy(idVendedor);
        if (pagamento == null) {
            throw new ConfiguracaoPagamentoNotFound();
        }

        return pagamento;
    }
}
