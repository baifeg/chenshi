package com.chenshi.spring;

import org.hibernate.SessionFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class SpringHelper
{
	private final static ApplicationContext context;
	private final static SessionFactory sessionFactory;

	static
	{
		context = new ClassPathXmlApplicationContext("spring-jdbc.xml");
		sessionFactory = context.getBean("sessionFactory", SessionFactory.class);
	}
	
	private SpringHelper()
	{
		throw new IllegalAccessError();
	}
	
	public static ApplicationContext getApplicationContext()
	{
		return context;
	}

	public static SessionFactory getSessionFactory()
	{
		return sessionFactory;
	}
}
