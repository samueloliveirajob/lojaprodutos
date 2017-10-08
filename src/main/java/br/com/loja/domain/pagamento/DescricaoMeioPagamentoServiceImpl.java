package br.com.loja.domain.pagamento;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import br.com.loja.infrastructure.repository.cdto.pagamento.DescricaoMeioPagamentoRepository;
import br.com.loja.infrastructure.repository.cdto.pagamento.entity.DescricaoMeioPagamentoEntity;

import java.util.List;

@Service
@CacheConfig(cacheNames = "meioPagamento")
public class DescricaoMeioPagamentoServiceImpl implements DescricaoMeioPagamentoService {

    private static final Logger LOGGER = LogManager.getLogger();

    @Autowired
    private DescricaoMeioPagamentoRepository repository;

    @Override
    @Cacheable("meioPagamento")
    public List<DescricaoMeioPagamentoEntity> findAll() {
        LOGGER.info("Consulta cacheada para MEIO DE PAGAMENTO");

        List<DescricaoMeioPagamentoEntity> entities = repository.findAll();

        return entities;
    }

    @Override
    @CacheEvict(value = "meioPagamento", allEntries = true)
    public void delete() {
        LOGGER.info("Removendo o cache para MEIO DE PAGAMENTO");
    }
}
