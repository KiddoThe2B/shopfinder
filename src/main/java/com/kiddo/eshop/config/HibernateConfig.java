/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.kiddo.eshop.config;

import java.util.Properties;
import javax.sql.DataSource;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.hibernate4.HibernateTransactionManager;
import org.springframework.orm.hibernate4.LocalSessionFactoryBean;
import org.springframework.transaction.annotation.EnableTransactionManagement;

/**
 *
 * @author kiddo
 */
@EnableTransactionManagement
@Configuration
@ComponentScan({ "com.kiddo.eshop.dao" })
public class HibernateConfig {
    @Autowired
        private Environment environment;

        @Bean
        public LocalSessionFactoryBean sessionFactory() {
            LocalSessionFactoryBean sessionFactory = new LocalSessionFactoryBean();
            sessionFactory.setDataSource(dataSource());
            sessionFactory.setPackagesToScan(new String[] { "com.kiddo.eshop.model" });
            sessionFactory.setHibernateProperties(hibernateProperties());
            return sessionFactory;
        }

        @Bean(name = "dataSource")
        public DataSource dataSource() {
            DriverManagerDataSource dataSource = new DriverManagerDataSource();
            dataSource.setDriverClassName("com.mysql.jdbc.Driver");
            dataSource.setUrl("jdbc:mysql://localhost:3306/eshopdb2");
            dataSource.setUsername("root");
            dataSource.setPassword("root");
            return dataSource;
        }

        private Properties hibernateProperties() {
            Properties properties = new Properties();
            properties.put("hibernate.dialect", "org.hibernate.dialect.MySQLDialect");
            properties.put("hibernate.show_sql", "true");
            properties.put("hibernate.enable_lazy_load_no_trans", "true");
            return properties;
        }

        @Bean
        @Autowired
        public HibernateTransactionManager transactionManager(SessionFactory s) {
            HibernateTransactionManager txManager = new HibernateTransactionManager();
            txManager.setSessionFactory(s);
            return txManager;
        }
}
