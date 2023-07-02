package com.hwc.isl.reposit.dbif.config;

import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

import javax.persistence.EntityManagerFactory;
import javax.sql.DataSource;

import org.h2.tools.Server;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.jdbc.DataSourceProperties;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.orm.jpa.EntityManagerFactoryBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.core.io.ClassPathResource;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.init.DataSourceInitializer;
import org.springframework.jdbc.datasource.init.ResourceDatabasePopulator;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import com.zaxxer.hikari.HikariDataSource;

@Configuration
@EnableTransactionManagement
@EnableJpaRepositories(entityManagerFactoryRef = "localEntityManagerFactory", transactionManagerRef = "localTransactionManager", basePackages = {
		"com.hwc.isl.reposit.dbif.repository" })
public class LocalDataSourceConfig {
	private final Logger logger = LoggerFactory.getLogger("repositStationLogger");

	@Value("${local.h2.server.port}")
	private int localServerPort;

	@Primary
	@Bean(name = "localDataSourceProperties")
	@ConfigurationProperties("spring.local.datasource")
	public DataSourceProperties localDataSourceProperties() throws SQLException {

		final Server server = Server.createTcpServer("-tcp", "-tcpAllowOthers", "-tcpPort", this.localServerPort + "")
				.start();

		if (server.isRunning(true)) {
			this.logger.info("########################################Running....Tcp Server ");
		}

		return new DataSourceProperties();
	}

	@Primary
	@Bean(name = "localDataSource")
	@ConfigurationProperties("spring.local.datasource")
	public DataSource localDataSource(
			@Qualifier("localDataSourceProperties") final DataSourceProperties localDataSourceProperties) {
		return localDataSourceProperties.initializeDataSourceBuilder().type(HikariDataSource.class).build();
	}

	@Bean
	public DataSourceInitializer dataSourceInitializer(@Qualifier("localDataSource") final DataSource localDataSource) {

		final DataSourceInitializer initializer = new DataSourceInitializer();
		initializer.setDataSource(localDataSource);

		try {
			// JdbcTemplate을 사용하여 SQL 쿼리 실행
			final JdbcTemplate jdbcTemplate = new JdbcTemplate(localDataSource);

			// 테이블 존재 여부 확인
			final String tableName = "TB_SERVER_INFO";
			final String sql = "SELECT COUNT(*) FROM information_schema.tables WHERE table_name = ?";
			final int count = jdbcTemplate.queryForObject(sql, Integer.class, tableName);

			if (count > 0) {

				this.logger.info("########################################  Already exists database schema");

			} else {
				// 초기 데이터 script setting
				final ResourceDatabasePopulator databasePopulator = new ResourceDatabasePopulator();
				databasePopulator.addScript(new ClassPathResource("initSql/schema.sql"));
				databasePopulator.addScript(new ClassPathResource("initSql/data.sql"));
				initializer.setDatabasePopulator(databasePopulator);
			}

		} catch (final Exception e) {
			e.printStackTrace();
		}

		return initializer;
	}

	@Primary
	@Bean(name = "localEntityManagerFactory")
	public LocalContainerEntityManagerFactoryBean localEntityManagerFactory(
			final EntityManagerFactoryBuilder localEntityManagerFactoryBuilder,
			@Qualifier("localDataSource") final DataSource localDataSource) {

		final Map<String, String> localJpaProperties = new HashMap<>();
		localJpaProperties.put("hibernate.dialect", "org.hibernate.dialect.H2Dialect");
		localJpaProperties.put("hibernate.hbm2ddl.auto", "none");

		return localEntityManagerFactoryBuilder.dataSource(localDataSource).packages("com.hwc.isl.reposit.dbif.entity")
				.persistenceUnit("localDataSource").properties(localJpaProperties).build();
	}

	@Primary
	@Bean(name = "localTransactionManager")
	public PlatformTransactionManager localTransactionManager(
			@Qualifier("localEntityManagerFactory") final EntityManagerFactory localEntityManagerFactory) {

		return new JpaTransactionManager(localEntityManagerFactory);
	}
}
