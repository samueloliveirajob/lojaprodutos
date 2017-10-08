package br.com.loja.infrastructure.repository.trng.ferramentas.seguranca;

import br.com.loja.domain.ferramentas.seguranca.ChaveSeguranca;

public interface ChaveSegurancaRepository {

    ChaveSeguranca findBy(Long idVendedor);
}
