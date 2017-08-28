package com.nj.addressbook.utils;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

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
			ctx = new ClassPathXmlApplicationContext("applicationcontext.xml");
		}
		return ctx;
	}
	
	public static <T> T getBean(Class<T> cls)
	{
		return getApplicationContext().getBean(cls);
	}

}
