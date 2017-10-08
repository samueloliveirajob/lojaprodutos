package br.com.loja.service;

import java.util.List;

import br.com.loja.infrastructure.repository.cdto.maquina.entity.MaquinaCompraEntity;
import br.com.loja.view.endpoint.maquininha.MaquinaCompraDTO;

public interface MaquinaService {


	Boolean saveAndFLush(MaquinaCompraEntity entity);

	List<MaquinaCompraDTO> carregaMaqEC(Long idStelo);

	MaquinaCompraEntity convertMaquinaDTOEntity(MaquinaCompraDTO maquinaDTO);
	
	MaquinaCompraDTO convertMaquinaEntityDTO(MaquinaCompraEntity entity);

}
