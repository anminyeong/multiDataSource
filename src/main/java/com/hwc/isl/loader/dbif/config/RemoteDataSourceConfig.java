package com.hwc.isl.loader.dbif.config;

import java.io.IOException;
import java.io.InputStream;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.persistence.EntityManagerFactory;
import javax.sql.DataSource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.autoconfigure.jdbc.DataSourceProperties;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.orm.jpa.EntityManagerFactoryBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import com.zaxxer.hikari.HikariDataSource;


@Configuration
@EnableTransactionManagement
@EnableJpaRepositories(entityManagerFactoryRef = "remoteEntityManagerFactory", transactionManagerRef = "remoteTransactionManager", basePackages = {
		"com.hwc.isl.loader.dbif.repository" })
public class RemoteDataSourceConfig {
	private final Logger logger = LoggerFactory.getLogger("repositStationLogger");

	@Bean(name = "remoteDataSourceProperties")
	@ConfigurationProperties(prefix = "spring.remote.datasource")
	public DataSourceProperties remoteDataSourceProperties() throws SQLException {

		return new DataSourceProperties();
	}

	@Bean(name = "remoteDataSource")
	@ConfigurationProperties("spring.remote.datasource")
	public DataSource remoteDataSource(
			@Qualifier("remoteDataSourceProperties") final DataSourceProperties remoteDataSourceProperties) {
		HikariDataSource dataSource = remoteDataSourceProperties.initializeDataSourceBuilder().type(HikariDataSource.class).build();
		dataSource.setConnectionTimeout(1000);
		return dataSource;
	}

	@Bean(name = "remoteEntityManagerFactory")
	public LocalContainerEntityManagerFactoryBean remoteEntityManagerFactory(
			final EntityManagerFactoryBuilder remoteEntityManagerFactoryBuilder,
			@Qualifier("remoteDataSource") final DataSource remoteDataSource) {

		final Map<String, String> remoteJpaProperties = new HashMap<>();
		remoteJpaProperties.put("hibernate.dialect", "org.hibernate.dialect.OracleDialect");
		remoteJpaProperties.put("hibernate.hbm2ddl.auto", "none");

		final LocalContainerEntityManagerFactoryBean entityManagerFactoryBean = remoteEntityManagerFactoryBuilder
				.dataSource(remoteDataSource).packages("com.hwc.isl.loader.dbif.entity")
				.persistenceUnit("remoteDataSource").properties(remoteJpaProperties).build();

		// 매핑 파일 경로를 배열로 전달합니다.
		//final String[] mappingResources = { "META-INF/loader/nativeQuery/AgentInfo.xml" };

		List<String> relativePaths = new ArrayList<>();
		relativePaths.add("META-INF/loader/nativeQuery/AgentInfo.xml");
		relativePaths.add("META-INF/loader/nativeQuery/UserInfo.xml");
		
		// Add more file paths here

		List<Resource> relativeResources = new ArrayList<>();
		for (String relativePath : relativePaths) {
		    Resource resource = new ClassPathResource(relativePath);
		    relativeResources.add(resource);
		}

		List<String> mappingResources = new ArrayList<>();
		for (Resource resource : relativeResources) {
		    try (InputStream inputStream = resource.getInputStream()) {
		        mappingResources.add(resource.getURL().toString());
		    } catch (IOException e) {
		        // Handle the exception as needed
		    }
		}

		// LocalContainerEntityManagerFactoryBean에 매핑 파일을 등록합니다.
		entityManagerFactoryBean.setMappingResources(mappingResources.toArray(new String[0]));
		
		
		return entityManagerFactoryBean;
	}

	@Bean(name = "remoteTransactionManager")
	public PlatformTransactionManager remoteTransactionManager(
			@Qualifier("remoteEntityManagerFactory") final EntityManagerFactory remoteEntityManagerFactory) {

		return new JpaTransactionManager(remoteEntityManagerFactory);
	}
}
