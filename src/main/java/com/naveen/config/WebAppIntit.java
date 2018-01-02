package com.naveen.config;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRegistration;

import org.springframework.web.WebApplicationInitializer;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.servlet.DispatcherServlet;

public class WebAppIntit implements WebApplicationInitializer {

	public void onStartup(ServletContext context) throws ServletException 
	{
		AnnotationConfigWebApplicationContext  aw = new AnnotationConfigWebApplicationContext();
		aw.register(DatabaseConfig.class);
		aw.setServletContext(context);
		ServletRegistration.Dynamic servlet = context.addServlet("dispatcher", new DispatcherServlet(aw));
		servlet.setLoadOnStartup(1);
	    servlet.addMapping("*.html");
	}

}
