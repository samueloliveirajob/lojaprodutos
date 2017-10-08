package br.com.loja.controller;


import java.util.Date;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import br.com.loja.service.MaquinaService;
import br.com.loja.view.endpoint.maquininha.MaquinaCompraDTO;

@Controller
public class MaquinaController {
		
	private static final Logger LOGGER = LogManager.getLogger();
		
    @Autowired
    private MaquinaService maquinaService;	 
    
    
    public Boolean addStoreEC(MaquinaCompraDTO maquinaDTO){
    	maquinaDTO.setDtIncl(new Date());
    	return maquinaService.saveAndFLush(
    			maquinaService.convertMaquinaDTOEntity(maquinaDTO));
    }
    
    public List<MaquinaCompraDTO> carregaMaqEC(String idStelo){
    	return maquinaService.carregaMaqEC(new Long(idStelo)) ;
    }
	
}

