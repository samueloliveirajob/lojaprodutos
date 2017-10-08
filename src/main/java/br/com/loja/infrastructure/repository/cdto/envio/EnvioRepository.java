package br.com.loja.infrastructure.repository.cdto.envio;

import br.com.loja.infrastructure.repository.cdto.envio.entity.ControleEnvioEntity;
import br.com.loja.view.endpoint.envio.dto.EnvioDTO;

public interface EnvioRepository {

	Boolean save(ControleEnvioEntity entity);

	ControleEnvioEntity saveURI(ControleEnvioEntity entity);
	
	ControleEnvioEntity findControleEnvio(EnvioDTO requestEnvioDTO);

	ControleEnvioEntity findControleEnvioByCodeUrl(String encode);

	void saveURIEnviado(String identificacao, String celEnviado, String email, Boolean status);
    
}
