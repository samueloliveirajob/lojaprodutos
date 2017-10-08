package br.com.loja.boot.environment;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;
import org.springframework.core.env.Environment;
import org.springframework.dao.annotation.PersistenceExceptionTranslationPostProcessor;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

@Configuration
@EnableCaching
@ComponentScan("br.com.stelo.portal")
@EnableJpaRepositories(
        entityManagerFactoryRef = "entityManagerFactory",
        basePackages = {"br.com.stelo.portal.infrastructure.repository.trng"}
)
@EnableTransactionManagement
@EnableWebMvc
public class ApplicationInitializerTRNG {

    private static final Logger LOGGER = LogManager.getLogger();
    private static final String PACKAGES = "br.com.stelo.portal.infrastructure.repository.trng";

    @Value("${jdbc.driver}")
    private String jdbcDriver;

    @Value("${jdbc.url}")
    private String jdbcUrl;

    @Value("${jdbc.user}")
    private String jdbcUser;

    @Value("${jdbc.pass}")
    private String jdbcPass;

    @Value("${jdbc.dialect}")
    private String jdbcDialect;

    public ApplicationInitializerTRNG() throws Exception {
        LOGGER.info("Inicializando aplicacao");
    }

    @Autowired
    private Environment env;

    @Bean
    public PersistenceExceptionTranslationPostProcessor exceptionTranslation() {
        return new PersistenceExceptionTranslationPostProcessor();
    }

    @Primary
    @Bean(name = "dataSource")
    public DriverManagerDataSource dataSource() {
        LOGGER.info("Configurando [dataSource]...");
        DriverManagerDataSource ds = new DriverManagerDataSource();
        ds.setDriverClassName(jdbcDriver);
        ds.setUrl(jdbcUrl);
        ds.setUsername(jdbcUser);
        ds.setPassword(jdbcPass);
        LOGGER.info("Datasource configurado: " + ds.toString());
        return ds;
    }


    @Bean(name = "entityManagerFactory")
    public LocalContainerEntityManagerFactoryBean entityManagerFactory() {
        LOGGER.info("Configurando [entityManagerFactory]...");
        LocalContainerEntityManagerFactoryBean entityManagerFactoryBean = new LocalContainerEntityManagerFactoryBean();
        entityManagerFactoryBean.setDataSource(dataSource());
        entityManagerFactoryBean.setPackagesToScan(PACKAGES);
        HibernateJpaVendorAdapter vendorAdapter = new HibernateJpaVendorAdapter();
        vendorAdapter.setDatabasePlatform("org.hibernate.dialect.OracleDialect");
        vendorAdapter.setShowSql(true);
        entityManagerFactoryBean.setJpaVendorAdapter(vendorAdapter);
        //   entityManagerFactoryBean.setJpaProperties(hibernateProperties());
        entityManagerFactoryBean.setPersistenceUnitName("trng");
        LOGGER.info(entityManagerFactoryBean);
        return entityManagerFactoryBean;
    }




    @Primary
    @Bean(name = "transactionManager")
    public JpaTransactionManager transactionManager() {
        JpaTransactionManager transactionManager = new JpaTransactionManager();
        transactionManager.setEntityManagerFactory(entityManagerFactory().getObject());
        return transactionManager;
    }

    //To resolve ${} in @Value
    @Bean
    public static PropertySourcesPlaceholderConfigurer propertyConfigInDev() {
        return new PropertySourcesPlaceholderConfigurer();
    }
}
