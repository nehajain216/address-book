package com.nj.addressbook.utils;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.nj.addressbook.config.AppConfig;

public class SpringContext 
{
	private static ApplicationContext ctx;
	
	private SpringContext() {
		// TODO Auto-generated constructor stub
	}
	
	public static ApplicationContext getApplicationContext()
	{
		if(ctx == null)
		{
			//ctx = new ClassPathXmlApplicationContext("applicationcontext.xml");
			ctx = new AnnotationConfigApplicationContext(AppConfig.class);
		}
		return ctx;
	}
	
	public static <T> T getBean(Class<T> cls)
	{
		return getApplicationContext().getBean(cls);
	}

}
