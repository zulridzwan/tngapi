package com.plusmilesdev.tngapi;


import javax.annotation.PostConstruct;
import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.jdbc.DataSourceProperties;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.core.io.ClassPathResource;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.init.DataSourceInitializer;
import org.springframework.jdbc.datasource.init.ResourceDatabasePopulator;

@Configuration
public class DBConfig {
	
	@Value("${primary.init-sql-script}")
	private String initDatabase;

	@PostConstruct
	public void init() {
		System.out.println("ZB: Loading DB config");
	}
	
	
	@Bean(name="primaryDSConfig")
	@Primary
	@ConfigurationProperties(prefix="primary.datasource")
	public DataSourceProperties primaryDataSourceProperties() {
		return new DataSourceProperties();
	}
	
	@Bean(name="secondaryDSConfig")
	@ConfigurationProperties(prefix="secondary.datasource")
	public DataSourceProperties secondaryDataSourceProperties() {
		return new DataSourceProperties();
	}
	
	
	@Bean(name="primaryDS")
	@Primary
	public DataSource primaryDS() {
		try {
			return primaryDataSourceProperties().initializeDataSourceBuilder().build();
		} catch(Exception e) {
			System.out.println("ZB: primaryDS error: "+e.getMessage());
			return null;
		}
	}
	
	@Bean(name="secondaryDS")
	public DataSource secondaryDS(@Qualifier("secondaryDSConfig") DataSourceProperties config) {
		try {
			return secondaryDataSourceProperties().initializeDataSourceBuilder().build();
		} catch(Exception e) {
			System.out.println("ZB: secondaryDS error: "+e.getMessage());
			return null;
		}
	}
	
	//Bean to load initial schema
	@Bean
    public DataSourceInitializer dataSourceInitializer(@Qualifier("primaryDS") DataSource dataSource)
    {
        DataSourceInitializer dataSourceInitializer = new DataSourceInitializer();    
        dataSourceInitializer.setDataSource(dataSource);
        ResourceDatabasePopulator databasePopulator = new ResourceDatabasePopulator();
        databasePopulator.addScript(new ClassPathResource("data.sql"));
        dataSourceInitializer.setDatabasePopulator(databasePopulator);
        dataSourceInitializer.setEnabled(Boolean.parseBoolean(initDatabase));
        return dataSourceInitializer;
    }
	
	@Bean(name="primaryJdbcTemplate")
	public JdbcTemplate primaryJdbcTemplate(@Qualifier("primaryDS") DataSource ds) {
		try {
			return new JdbcTemplate(ds);
		} catch(Exception e) {
			System.out.println("ZB: primaryJdbcTemplate error: "+e.getMessage());
			return null;
		}
		
	}
	
	
	@Bean(name="secondaryJdbcTemplate")
	public JdbcTemplate secondaryJdbcTemplate(@Qualifier("secondaryDS") DataSource ds) {
		try {
			return new JdbcTemplate(ds);
		} catch(Exception e) {
			System.out.println("ZB: secondaryJdbcTemplate error: "+e.getMessage());
			return null;
		}
		
	}
	
}
