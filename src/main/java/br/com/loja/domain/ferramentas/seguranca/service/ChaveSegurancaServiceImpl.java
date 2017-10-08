package br.com.loja.domain.ferramentas.seguranca.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.loja.domain.ferramentas.seguranca.ChaveSeguranca;
import br.com.loja.domain.ferramentas.seguranca.ChaveSegurancaNotFound;
import br.com.loja.infrastructure.repository.trng.ferramentas.seguranca.ChaveSegurancaRepository;

@Service
public class ChaveSegurancaServiceImpl implements ChaveSegurancaService {

    @Autowired
    private ChaveSegurancaRepository repository;

    @Override
    public ChaveSeguranca findBy(Long idVendedor) {
        ChaveSeguranca chaveSeguranca = repository.findBy(idVendedor);
        if (chaveSeguranca == null) {
            throw new ChaveSegurancaNotFound();
        }
        return chaveSeguranca;
    }

}
