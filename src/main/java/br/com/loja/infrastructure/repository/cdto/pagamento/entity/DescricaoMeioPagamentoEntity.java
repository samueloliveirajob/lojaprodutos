package br.com.loja.infrastructure.repository.cdto.pagamento.entity;

import javax.persistence.*;

@Entity
@Table(name = "tb_tpo_pgto", schema = "usr_prsv")
public class DescricaoMeioPagamentoEntity {

    @Id
    @GeneratedValue
    @Column(name = "ID_TP_PGTO", unique = true, nullable = false)
    private Long id;
    @Column(name = "DS_TP_PGTO")
    private String descricao;

    public Long getId() {
        return id;
    }

    public String getDescricao() {
        return descricao;
    }

    @Override
    public String toString() {
        return "MeioPagamentoEntity{" +
                "id=" + id +
                ", descricao='" + descricao + '\'' +
                '}';
    }
}
