package com.naveen.config;

import java.util.Properties;

import javax.sql.DataSource;

import org.hibernate.SessionFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.hibernate3.HibernateTemplate;
import org.springframework.orm.hibernate3.annotation.AnnotationSessionFactoryBean;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

import com.naveen.model.User;

@Configuration
@EnableWebMvc
@ComponentScan(basePackages={"com.naveen"})
public class DatabaseConfig 
{
	@Bean
	public DataSource dataSource()
	{
		DriverManagerDataSource ds = new DriverManagerDataSource();
		ds.setDriverClassName("com.mysql.jdbc.Driver");
		ds.setUrl("jdbc:mysql://localhost:3306/demo");
		ds.setUsername("root");
		ds.setPassword("root");
		return ds;
	}
	
	@Bean
	public ViewResolver viewResolver()
	{
		InternalResourceViewResolver view = new InternalResourceViewResolver();
		view.setPrefix("/");
		view.setSuffix(".jsp");
		return view;
	}
	@Bean
	public Properties hibernateProperties()
	{
		Properties props = new Properties();
		props.put("hibernate.dialect", "org.hibernate.dialect.MySQLDialect");
		props.put("hibernate.show_sql",true);
		props.put("hibernate.hbm2ddl.auto", "update");
		return props;
	}
	
	@Bean
	public AnnotationSessionFactoryBean getSessionFactory()
	{
		AnnotationSessionFactoryBean aw = new AnnotationSessionFactoryBean();
		aw.setHibernateProperties(hibernateProperties());
		aw.setDataSource(dataSource());
		aw.setAnnotatedClasses(User.class);
		return aw;
		
	}
	@Bean
	public HibernateTemplate getHibernateTemplate(SessionFactory sessionFactory)
	{
		HibernateTemplate ht = new HibernateTemplate(sessionFactory);
		ht.setSessionFactory(sessionFactory);
		return ht;
	}
	
}
