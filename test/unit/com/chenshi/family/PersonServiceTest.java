package com.chenshi.family;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class PersonServiceTest
{
	private static ApplicationContext context;

	@BeforeClass
	public static void init()
	{
		context = new ClassPathXmlApplicationContext("spring-*.xml");
	}

	@Test
	public void test()
	{
		PersonService personService = context.getBean(PersonService.class);
		Person parent = personService.getById(1);
		System.out.println(parent);

		Person person = new Person();
		person.setParent(parent);
		parent.getChildren().add(person);
		person.setLifeStatus(LifeStatus.ALIVE);
		person.setName("hhhh");
		person.setOperator("admin");
		personService.save(person);
	}

	@Test
	public void testFindValidList()
	{
		PersonService personService = context.getBean(PersonService.class);
		List<Person> list = personService.findValidList();
		System.out.println(list);
	}

}
