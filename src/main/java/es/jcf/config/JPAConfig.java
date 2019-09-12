package es.jcf.config;

import java.util.Properties;

import javax.annotation.Resource;
import javax.sql.DataSource;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.core.env.Environment;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.Database;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
@EnableJpaRepositories(basePackages = { "es.jcf.app.persistence" })
@EnableTransactionManagement
public class JPAConfig {

	@Resource
	public Environment env;

	@Bean
	public LocalContainerEntityManagerFactoryBean entityManagerFactory() {

		HibernateJpaVendorAdapter vendorAdapter = new HibernateJpaVendorAdapter();
		vendorAdapter.setDatabase(Database.POSTGRESQL);
		vendorAdapter.setGenerateDdl(true);

		LocalContainerEntityManagerFactoryBean em = new LocalContainerEntityManagerFactoryBean();
		em.setDataSource(dataSourceDes());
		em.setPackagesToScan("es.jcf.app.persistence");
		em.setJpaVendorAdapter(vendorAdapter);
		em.setJpaProperties(hibernatePropertiesPostgre());

		return em;
	}

	@Bean
	@Profile("test")
	public DataSource dataSourceTest() {
		DriverManagerDataSource dataSource = new DriverManagerDataSource();
		dataSource.setDriverClassName("org.h2.Driver");
		dataSource.setUrl("jdbc:h2:mem:db;");
		dataSource.setUsername("sa");
		dataSource.setPassword("sa");
		System.out.println("Cargada base de datos de test -- h2 bbdd 'jdbc:h2:mem:db;'");
		return dataSource;
	}

	@Bean
	@Profile("des")
	public DataSource dataSourceDes() {
		DriverManagerDataSource dataSource = new DriverManagerDataSource();
		dataSource.setDriverClassName("org.hibernate.dialect.PostgreSQLDialect");
		dataSource.setUrl("jdbc:postgresql://localhost:5432/gestion");
		dataSource.setUsername("postgres");
		dataSource.setPassword("JC4nt4l3j0");
		System.out.println("Cargada base de datos de test -- h2 bbdd 'jdbc:postgresql://localhost:5432/gestion'");

		return dataSource;
	}

	private Properties hibernatePropertiesPostgre() {
		Properties properties = new Properties();
		properties.setProperty("hibernate.hbm2ddl.auto", env.getProperty("spring.jpa.hibernate.ddl-auto"));
		properties.setProperty("hibernate.dialect", env.getProperty("spring.jpa.properties.hibernate.dialect"));
		properties.setProperty("hibernate.current_session_context_class",
				env.getProperty("spring.jpa.properties.hibernate.current_session_context_class"));
		properties.setProperty("hibernate.jdbc.lob.non_contextual_creation",
				env.getProperty("spring.jpa.properties.hibernate.jdbc.lob.non_contextual_creation"));
		properties.setProperty("hibernate.show_sql", env.getProperty("spring.jpa.show-sql"));
		properties.setProperty("hibernate.format_sql", env.getProperty("spring.jpa.properties.hibernate.format_sql"));
		return properties;
	}

	// configure entityManagerFactory
	// configure transactionManager
	// configure additional Hibernate properties
}