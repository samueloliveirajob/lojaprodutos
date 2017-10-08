package br.com.loja.domain.maquininha.service;

import java.util.List;

import br.com.loja.domain.maquininha.Maquininha;

public interface MaquininhaService {

    List<Maquininha> findBy(Long idVendedor);
}
