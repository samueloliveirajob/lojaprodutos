package br.com.loja.domain.loja.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.loja.domain.loja.Loja;
import br.com.loja.domain.loja.LojaNotFound;
import br.com.loja.infrastructure.repository.trng.loja.LojaRepository;

@Service
public class LojaServiceImpl implements LojaService {

    @Autowired
    LojaRepository repository;

    @Override
    public Loja findBy(Long idVendedor) {

        Loja loja = repository.findBy(idVendedor);
        if (loja == null) {
            throw new LojaNotFound();
        }
        return loja;
    }
}
