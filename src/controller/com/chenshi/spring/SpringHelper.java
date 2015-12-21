package com.chenshi.spring;

import org.hibernate.SessionFactory;
import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;

@Component
public class SpringHelper implements ApplicationContextAware
{
	private static ApplicationContext context;
	
	public static ApplicationContext getApplicationContext()
	{
		return context;
	}

	public static SessionFactory getSessionFactory()
	{
		return context.getBean("sessionFactory", SessionFactory.class);
	}

	@Override
	public void setApplicationContext(ApplicationContext context) throws BeansException
	{
		SpringHelper.context = context;
	}
}
