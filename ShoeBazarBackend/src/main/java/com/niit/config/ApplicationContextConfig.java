package com.niit.config;


import javax.sql.DataSource;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.hibernate5.HibernateTransactionManager;
import org.springframework.orm.hibernate5.LocalSessionFactoryBuilder;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import com.niit.model.Category;
import com.niit.model.Product;
import com.niit.model.Supplier;
import com.niit.model.UserDetail;

import java.util.Properties;

@Configuration
@ComponentScan("com.niit")
@EnableTransactionManagement
public class ApplicationContextConfig 
{

	@Bean(name = "h2DataSource")
	public DataSource getH2DataSource()
	{
		System.out.println("getH2DataSource() started...");
		DriverManagerDataSource dataSource = new DriverManagerDataSource();
		dataSource.setDriverClassName("org.h2.Driver");
		dataSource.setUrl("jdbc:h2:tcp://localhost/~/ShoeBazarDBMS");

		dataSource.setUsername("sa");
		dataSource.setPassword("");

	
		return dataSource;
	}
	
	private Properties getHibernateProperties() {
		System.out.println("getHibernateProperties() started...");
    	Properties properties = new Properties();
    	properties.put("hibernate.show_sql", "true");
    	properties.setProperty("hibernate.hbm2ddl.auto", "update");
    	
    	properties.put("hibernate.dialect", "org.hibernate.dialect.H2Dialect");
    	return properties;
    }
    

	@Autowired
	@Bean(name = "sessionFactory")
	public SessionFactory getSessionFactory(DataSource DataSource)
	{
		System.out.println("getSessionFactory() started...");
		LocalSessionFactoryBuilder sessionBuilder = new LocalSessionFactoryBuilder(DataSource);
		System.out.println("session....."+sessionBuilder);
		sessionBuilder.addProperties(getHibernateProperties());
		sessionBuilder.addAnnotatedClass(UserDetail.class);
		sessionBuilder.addAnnotatedClass(Category.class);
		sessionBuilder.addAnnotatedClass(Supplier.class);
		sessionBuilder.addAnnotatedClass(Product.class);
		
		return sessionBuilder.buildSessionFactory();
		
	}

	@Autowired
	@Bean(name = "transactionManager")
	public HibernateTransactionManager getTransactionManager(SessionFactory sessionFactory)	
	{
		System.out.println("getTransactionManager() started..."+sessionFactory);
		HibernateTransactionManager transactionManager = new HibernateTransactionManager(sessionFactory);
		System.out.println("........"+transactionManager);
		return transactionManager;
	}
	

	
}
