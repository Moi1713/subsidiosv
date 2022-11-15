package com.igf.subsidiosv;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.core.env.Environment;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.sql.DataSource;
import java.util.HashMap;
import java.util.Map;

@Configuration
@EnableTransactionManagement
@EnableJpaRepositories(entityManagerFactoryRef = "subsidioEntityManagerFactory", transactionManagerRef = "subsidioTransactionManager",
        basePackages = { "com.igf.subsidiosv.rol", "com.igf.subsidiosv.usuarios", "com.igf.subsidiosv.beneficiario", "com.igf.subsidiosv.beneficio",
                "com.igf.subsidiosv.categoria", "com.igf.subsidiosv.producto", "com.igf.subsidiosv.solicitud", "com.igf.subsidiosv.subsidio", "com.igf.subsidiosv.subsidioaplicado" })
public class SubsidioSVConf {

    @Autowired
    private Environment env;

    @Bean(name = "subsidioDataSource")
    public DataSource subsidioDataSource() {
        DriverManagerDataSource dataSource = new DriverManagerDataSource();
        dataSource.setUrl(env.getProperty("spring.datasource.url"));
        dataSource.setUsername(env.getProperty("spring.datasource.username"));
        dataSource.setPassword(env.getProperty("spring.datasource.password"));

        return dataSource;
    }

    @Primary
    @Bean(name = "subsidioEntityManagerFactory")
    public LocalContainerEntityManagerFactoryBean entityManagerFactory() {
        LocalContainerEntityManagerFactoryBean em = new LocalContainerEntityManagerFactoryBean();
        em.setDataSource(subsidioDataSource());
        em.setPackagesToScan("com.igf.subsidiosv.rol", "com.igf.subsidiosv.usuarios", "com.igf.subsidiosv.beneficiario", "com.igf.subsidiosv.beneficio",
                 "com.igf.subsidiosv.categoria", "com.igf.subsidiosv.producto", "com.igf.subsidiosv.solicitud", "com.igf.subsidiosv.subsidio", "com.igf.subsidiosv.subsidioaplicado");

        HibernateJpaVendorAdapter vendorAdapter = new HibernateJpaVendorAdapter();
        em.setJpaVendorAdapter(vendorAdapter);

        Map<String, Object> properties = new HashMap<>();
        properties.put("hibernate.hbm2ddl.auto", env.getProperty("spring.jpa.hibernate.ddl-auto"));
        properties.put("hibernate.show-sql", env.getProperty("spring.jpa.show-sql"));
        properties.put("hibernate.dialect", env.getProperty("spring.jpa.database-platform"));

        em.setJpaPropertyMap(properties);

        return em;
    }

    @Primary
    @Bean(name = "subsidioTransactionManager")
    public PlatformTransactionManager transactionManager() {
        JpaTransactionManager transactionManager = new JpaTransactionManager();
        transactionManager.setEntityManagerFactory(entityManagerFactory().getObject());

        return transactionManager;
    }

}
