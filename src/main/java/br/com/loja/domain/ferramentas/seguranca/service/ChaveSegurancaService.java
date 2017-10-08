package br.com.loja.domain.ferramentas.seguranca.service;

import br.com.loja.domain.ferramentas.seguranca.ChaveSeguranca;

public interface ChaveSegurancaService {

    ChaveSeguranca findBy(Long idVendedor);
}
