package org.itstep.vinokurov.web;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

public class ApplicationInitializer implements ServletContextListener{

	@Override
	public void contextInitialized(ServletContextEvent sce) {
		try {
			Class.forName("org.postgresql.Driver");
		} catch (ClassNotFoundException e) {
System.out.println("hello2");
			e.printStackTrace();
		}
	}
}
