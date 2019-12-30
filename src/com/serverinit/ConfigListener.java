package com.serverinit;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

public class ConfigListener implements ServletContextListener {

	private static String realPath=null;
	private static Properties prop=null;
	
	@Override
	public void contextInitialized(ServletContextEvent sce) {
		ServletContext context=sce.getServletContext();
		realPath=context.getRealPath("/WEB-INF/NiyoginProps.xml");	
		System.out.println("realPath=="+realPath);
		getResourceProperties(realPath);
	}

	@Override
	public void contextDestroyed(ServletContextEvent sce) {
		// TODO Auto-generated method stub
	}
	
	private static void getResourceProperties(String str) {
		System.out.println("Context Path==" + str);
		try {
			File file = new File(str);
			FileInputStream fis = new FileInputStream(file);
			prop = new Properties();
			prop.loadFromXML(fis);
		} catch (FileNotFoundException ex) {
			ex.printStackTrace();
		} catch (IOException ex) {
			ex.printStackTrace();
		}
	}
	
	public static String getProperty(String key) {
		return prop.getProperty(key);
	}
	
	public static String getRealXMLPath() {
		return realPath;
	}
	
}
