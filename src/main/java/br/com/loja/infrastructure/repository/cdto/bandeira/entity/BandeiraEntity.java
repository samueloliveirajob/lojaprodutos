package br.com.loja.infrastructure.repository.cdto.bandeira.entity;

import javax.persistence.*;

@Entity
@Table(name = "TB_PPRIE", schema = "USR_ICOR")
public class BandeiraEntity {

    @Id
    @GeneratedValue
    @Column(name = "ID_PPRIE", unique = true, nullable = false)
    private Long id;
    @Column(name = "DS_PPRIE")
    private String descricao;

    public Long getId() {
        return id;
    }

    public String getDescricao() {
        return descricao;
    }

    @Override
    public String toString() {
        return "BandeiraEntity{" +
                "id=" + id +
                ", descricao='" + descricao + '\'' +
                '}';
    }
}
