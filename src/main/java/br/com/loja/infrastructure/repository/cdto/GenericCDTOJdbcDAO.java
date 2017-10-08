package br.com.loja.infrastructure.repository.cdto;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;

public class GenericCDTOJdbcDAO {

    protected NamedParameterJdbcTemplate namedParameterJdbcTemplate;

    @Autowired
    @Qualifier("cdtoDataSource")
    public void setDataSource(DataSource dataSource) {
        this.namedParameterJdbcTemplate = new NamedParameterJdbcTemplate(dataSource);
    }
}
