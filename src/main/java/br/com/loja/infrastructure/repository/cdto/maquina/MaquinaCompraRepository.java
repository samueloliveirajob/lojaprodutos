package br.com.loja.infrastructure.repository.cdto.maquina;

import java.util.List;

import br.com.loja.infrastructure.repository.cdto.maquina.entity.MaquinaCompraEntity;
import br.com.loja.view.endpoint.maquininha.MaquinaCompraDTO;

public interface MaquinaCompraRepository {

    
    Boolean save(MaquinaCompraEntity entity);

	List<MaquinaCompraDTO> findAllMaqEC(Long idStelo);
    
    
}
