package es.jcf.configuration;

import java.util.Properties;

import javax.sql.DataSource;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
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

	@Bean(name = "entityManagerFactory")
	public LocalContainerEntityManagerFactoryBean entityManagerFactoryTest() {

		HibernateJpaVendorAdapter vendorAdapter = new HibernateJpaVendorAdapter();
		vendorAdapter.setDatabase(Database.H2);
		vendorAdapter.setGenerateDdl(true);

		LocalContainerEntityManagerFactoryBean em = new LocalContainerEntityManagerFactoryBean();
		em.setDataSource(dataSourceTest());
		em.setPackagesToScan("es.jcf.app.persistence");
		em.setJpaVendorAdapter(vendorAdapter);
		em.setJpaProperties(hibernatePropertiesH2());

		return em;
	}

//	@Bean
//	@Profile("des")
//	public LocalContainerEntityManagerFactoryBean entityManagerFactoryDes() {
//
//		HibernateJpaVendorAdapter vendorAdapter = new HibernateJpaVendorAdapter();
//		vendorAdapter.setDatabase(Database.POSTGRESQL);
//		vendorAdapter.setGenerateDdl(true);
//
//		LocalContainerEntityManagerFactoryBean em = new LocalContainerEntityManagerFactoryBean();
//		em.setDataSource(dataSourceDes());
//		em.setPackagesToScan("es.jcf.app.persistence");
//		em.setJpaVendorAdapter(vendorAdapter);
//		em.setJpaProperties(hibernatePropertiesPostgre());
//
//		return em;
//	}

	@Bean
	public DataSource dataSourceTest() {
		DriverManagerDataSource dataSource = new DriverManagerDataSource();
		dataSource.setDriverClassName("org.h2.Driver");
		dataSource.setUrl("jdbc:h2:mem:db;DB_CLOSE_DELAY=-1");
		dataSource.setUsername("sa");
		dataSource.setPassword("");
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
		properties.setProperty("hibernate.hbm2ddl.auto", "create-drop");
		properties.setProperty("hibernate.dialect", "org.hibernate.dialect.PostgreSQLDialect");
		properties.setProperty("hibernate.show_sql", "true");
		properties.setProperty("hibernate.format_sql", "true");
		return properties;
	}

	private Properties hibernatePropertiesH2() {
		Properties properties = new Properties();
		properties.setProperty("hibernate.hbm2ddl.auto", "create-drop");
		properties.setProperty("hibernate.dialect", "org.hibernate.dialect.H2Dialect");
		properties.setProperty("hibernate.show_sql", "true");
		properties.setProperty("hibernate.format_sql", "true");
		return properties;
	}

	// configure entityManagerFactory
	// configure transactionManager
	// configure additional Hibernate properties
}