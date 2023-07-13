package com.sap.refapps.espm.config;

import javax.sql.DataSource;


import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.context.annotation.PropertySource;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.transaction.annotation.EnableTransactionManagement;

/**
 * This is the h2 database configuration class for test profile which reads the
 * database properties from the test-db.properties file.
 *
 */
@Configuration
@Profile("test")
@EnableJpaRepositories(basePackages = "com.sap.refapps.espm")
@PropertySource("classpath:test-db.properties")
@EnableTransactionManagement
@EnableAutoConfiguration
public class H2JPAConfig {

    @Value("${jdbc.driverClassName}")
    private String driverClassName;

    @Value("${jdbc.url}")
    private String url;

    @Value("${jdbc.username}")
    private String userName;

    @Value("${jdbc.password}")
    private String password;

    /**
     * Returns h2 datasource
     * 
     * @return datasource
     */
    @Bean
    public DataSource dataSource() {

        DriverManagerDataSource dataSource = new DriverManagerDataSource();
        dataSource.setDriverClassName(driverClassName);
        dataSource.setUrl(url);
        dataSource.setUsername(userName);
        dataSource.setPassword(password);

        return dataSource;
    }

}
