package br.com.loja.domain.maquininha;

import java.util.Date;

public interface Maquininha {

    String modelo();

    String cogigoAtivacao();

    String numeroSerie();

    Date dataCompra();

    Double valor();

    String status();
}
