package br.com.loja.service.impl;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.loja.infrastructure.repository.cdto.maquina.MaquinaCompraRepository;
import br.com.loja.infrastructure.repository.cdto.maquina.entity.MaquinaCompraEntity;
import br.com.loja.service.MaquinaService;
import br.com.loja.view.endpoint.maquininha.MaquinaCompraDTO;

@Service
public class MaquinaServiceImpl implements MaquinaService {

    private static final Logger LOGGER = LogManager.getLogger();

    @Autowired
    private MaquinaCompraRepository repository;

    @Override
    public Boolean saveAndFLush(MaquinaCompraEntity entity) {
        LOGGER.info("saveAndFLush MaquinaCompraEntity");
        return repository.save(entity);
    }
    
    @Override
	public List<MaquinaCompraDTO> carregaMaqEC(Long idStelo) {
		LOGGER.info("Consulta carregaMaqEC");
		return repository.findAllMaqEC(idStelo);
	}
    

	@Override
	public MaquinaCompraEntity convertMaquinaDTOEntity(MaquinaCompraDTO maquinaDTO) {
		return new MaquinaCompraEntity(maquinaDTO);
	}

	@Override
	public MaquinaCompraDTO convertMaquinaEntityDTO(MaquinaCompraEntity entity) {
		return new MaquinaCompraDTO(entity);
	}

}
