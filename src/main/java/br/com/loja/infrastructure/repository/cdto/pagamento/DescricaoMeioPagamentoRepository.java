package br.com.loja.infrastructure.repository.cdto.pagamento;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.loja.infrastructure.repository.cdto.pagamento.entity.DescricaoMeioPagamentoEntity;

import java.util.List;

public interface DescricaoMeioPagamentoRepository extends JpaRepository<DescricaoMeioPagamentoEntity, Long> {

    @Override
    List<DescricaoMeioPagamentoEntity> findAll();
}
