package com.chenshi.family;

import org.springframework.stereotype.Service;

import com.chenshi.database.CommonDao;

@Service
public class PersonService extends CommonDao<Person>
{
	public PersonService()
	{
		super(Person.class);
	}
}
