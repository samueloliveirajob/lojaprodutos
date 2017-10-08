package br.com.loja.domain.pagamento;

import java.util.List;

import br.com.loja.infrastructure.repository.cdto.pagamento.entity.DescricaoMeioPagamentoEntity;

public interface DescricaoMeioPagamentoService {

    List<DescricaoMeioPagamentoEntity> findAll();

    void delete();
}
