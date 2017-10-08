package br.com.loja.domain.bandeira.service;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import br.com.loja.infrastructure.repository.cdto.bandeira.BandeiraRepository;
import br.com.loja.infrastructure.repository.cdto.bandeira.entity.BandeiraEntity;

import java.util.List;

@Service
@CacheConfig(cacheNames = "bandeira")
public class BandeiraServiceImpl implements BandeiraService {

    private static final Logger LOGGER = LogManager.getLogger();

    @Autowired
    private BandeiraRepository repository;

    @Override
    @Cacheable("bandeira")
    public List<BandeiraEntity> findAll() {
        LOGGER.info("Consulta cacheada para BANDEIRAS");

        List<BandeiraEntity> entities = repository.findAll();

        return entities;
    }

    @Override
    @CacheEvict(value = "bandeira", allEntries = true)
    public void delete() {
        LOGGER.info("Removendo o cache para BANDEIRAS");
    }
}
