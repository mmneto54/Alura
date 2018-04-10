package br.casadocodigo.loja.conf;

import org.springframework.context.annotation.Bean;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.JpaVendorAdapter;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.persistence.EntityManagerFactory;
import java.util.Properties;

@EnableTransactionManagement
public class JpaConfiguration {

    /**
     * @Bean
     * Anotação utilizada em cima dos métodos de uma classe, geralmente marcada com @Configuration,
     * indicando que o Spring deve invocar aquele método e gerenciar o objeto retornado por ele.
     * Quando digo gerenciar é que agora este objeto pode ser injetado em qualquer ponto da sua aplicação.
     *
     */

    @Bean
    public LocalContainerEntityManagerFactoryBean entityManagerFactoy(){

       LocalContainerEntityManagerFactoryBean factoryBean = new LocalContainerEntityManagerFactoryBean();

        JpaVendorAdapter  jpaVendorAdapter = new HibernateJpaVendorAdapter();

        factoryBean.setJpaVendorAdapter(jpaVendorAdapter);

        DriverManagerDataSource  managerDataSource  = new DriverManagerDataSource();

        managerDataSource.setUsername("root");
        managerDataSource.setPassword("1234");
        managerDataSource.setUrl("jdbc:mysql://localhost:3306/casadocodigo");
        managerDataSource.setDriverClassName("com.mysql.jdbc.Driver");


        Properties properties = new Properties();

        properties.setProperty("hibernate.dialect","org.hibernate.dialect.MySQL5Dialect");
        properties.setProperty("hibernate.show_sql","true");
        properties.setProperty("hibernate.hbm2ddl.auto","update");

        factoryBean.setDataSource(managerDataSource);
        factoryBean.setJpaProperties(properties);
        factoryBean.setPackagesToScan("br.casadocodigo.loja.models");

        return factoryBean;
    }

    @Bean
    public JpaTransactionManager transactionManager(EntityManagerFactory emf){
        return new JpaTransactionManager(emf);
    }
}

