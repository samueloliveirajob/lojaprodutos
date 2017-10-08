package br.com.loja.boot.environment;

import java.util.Properties;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;
import org.springframework.core.env.Environment;
import org.springframework.dao.annotation.PersistenceExceptionTranslationPostProcessor;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
@EnableCaching
@ComponentScan("br.com.stelo.portal")
@EnableJpaRepositories(
        entityManagerFactoryRef = "cdtoEntityManagerFactory",
        transactionManagerRef = "cdtoTransactionManager",
        basePackages = {"br.com.stelo.portal.infrastructure.repository.cdto"}
)
@EnableTransactionManagement
public class ApplicationInitializerCDTO {

    private static final Logger LOGGER = LogManager.getLogger();
    private static final String PACKAGES = "br.com.stelo.portal.infrastructure.repository.cdto";

    @Value("${jdbc.cdto.driver}")
    private String jdbcDriver;

    @Value("${jdbc.cdto.url}")
    private String jdbcUrl;

    @Value("${jdbc.cdto.user}")
    private String jdbcUser;

    @Value("${jdbc.cdto.pass}")
    private String jdbcPass;

    @Value("${jdbc.cdto.dialect}")
    private String jdbcDialect;

    public ApplicationInitializerCDTO() throws Exception {
        LOGGER.info("Inicializando aplicacao");
    }

    @Autowired
    private Environment env;

    @Bean
    public PersistenceExceptionTranslationPostProcessor exceptionTranslation() {
        return new PersistenceExceptionTranslationPostProcessor();
    }

    @Bean(name = "cdtoDataSource")
    public DriverManagerDataSource cdtoDataSource() {
        LOGGER.info("Configurando [dataSource]...");
        DriverManagerDataSource ds = new DriverManagerDataSource();
        ds.setDriverClassName(jdbcDriver);
        ds.setUrl(jdbcUrl);
        ds.setUsername(jdbcUser);
        ds.setPassword(jdbcPass);
        LOGGER.info("Datasource configurado: " + ds.toString());
        return ds;
    }

    @Bean(name = "cdtoEntityManagerFactory")
    public LocalContainerEntityManagerFactoryBean cdtoEntityManagerFactory() {
        LOGGER.info("Configurando [entityManagerFactory]...");
        LocalContainerEntityManagerFactoryBean entityManagerFactoryBean = new LocalContainerEntityManagerFactoryBean();
        entityManagerFactoryBean.setDataSource(cdtoDataSource());
        entityManagerFactoryBean.setPackagesToScan(PACKAGES);
        HibernateJpaVendorAdapter vendorAdapter = new HibernateJpaVendorAdapter();
        vendorAdapter.setDatabasePlatform("org.hibernate.dialect.OracleDialect");
        vendorAdapter.setShowSql(true);
        entityManagerFactoryBean.setJpaVendorAdapter(vendorAdapter);
//        entityManagerFactoryBean.setPersistenceUnitName("cdto");
        entityManagerFactoryBean.setJpaProperties(hibernateProperties());
        LOGGER.info(entityManagerFactoryBean);
        return entityManagerFactoryBean;
    }

    private Properties hibernateProperties() {
        return new Properties() {
            {
                setProperty("hibernate.hbm2ddl.auto", "validate");
                setProperty("hibernate.dialect", jdbcDialect);
                setProperty("hibernate.format_sql", "true");
                setProperty("hibernate.show_sql", "true");
            }
        };
    }

    @Bean(name = "cdtoTransactionManager")
    public JpaTransactionManager transactionManager() {
        JpaTransactionManager transactionManager = new JpaTransactionManager();
        transactionManager.setEntityManagerFactory(cdtoEntityManagerFactory().getObject());
        return transactionManager;
    }

    //To resolve ${} in @Value
    @Bean
    public static PropertySourcesPlaceholderConfigurer propertyConfigInDev() {
        return new PropertySourcesPlaceholderConfigurer();
    }
}
