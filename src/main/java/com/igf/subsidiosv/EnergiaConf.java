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
@EnableJpaRepositories(entityManagerFactoryRef = "energiaEntityManagerFactory", transactionManagerRef = "energiaTransactionManager",
        basePackages = { "com.igf.subsidiosv.consumo", "com.igf.subsidiosv.empresa" })
public class EnergiaConf {

    @Autowired
    private Environment env;

    @Bean(name = "energiaDataSource")
    public DataSource energiaDataSource() {
        DriverManagerDataSource dataSource = new DriverManagerDataSource();
        dataSource.setUrl(env.getProperty("spring2.datasource.url"));
        dataSource.setUsername(env.getProperty("spring2.datasource.username"));
        dataSource.setPassword(env.getProperty("spring2.datasource.password"));

        return dataSource;
    }

    @Primary
    @Bean(name = "energiaEntityManagerFactory")
    public LocalContainerEntityManagerFactoryBean entityManagerFactory() {
        LocalContainerEntityManagerFactoryBean em = new LocalContainerEntityManagerFactoryBean();
        em.setDataSource(energiaDataSource());
        em.setPackagesToScan("com.igf.subsidiosv.consumo", "com.igf.subsidiosv.empresa");

        HibernateJpaVendorAdapter vendorAdapter = new HibernateJpaVendorAdapter();
        em.setJpaVendorAdapter(vendorAdapter);

        Map<String, Object> properties = new HashMap<>();
        properties.put("hibernate.hbm2ddl.auto", env.getProperty("spring2.jpa.hibernate.ddl-auto"));
        properties.put("hibernate.show-sql", env.getProperty("spring2.jpa.show-sql"));
        properties.put("hibernate.dialect", env.getProperty("spring2.jpa.database-platform"));

        em.setJpaPropertyMap(properties);

        return em;
    }

    @Primary
    @Bean(name = "energiaTransactionManager")
    public PlatformTransactionManager transactionManager() {
        JpaTransactionManager transactionManager = new JpaTransactionManager();
        transactionManager.setEntityManagerFactory(entityManagerFactory().getObject());

        return transactionManager;
    }

}