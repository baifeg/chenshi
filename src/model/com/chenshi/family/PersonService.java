package com.chenshi.family;

import java.util.List;
import java.util.logging.Logger;

import org.springframework.stereotype.Service;

import com.chenshi.database.CommonDao;
import com.chenshi.database.DaoFactory;

@Service
public class PersonService
{
	private final CommonDao<Person> dao;
	private final Logger log = Logger.getLogger(getClass().getSimpleName());
	
	public PersonService()
	{
		dao = DaoFactory.getDao(Person.class);
	}

	public List<Person> queryAll()
	{
		log.info("query all persons");
		return dao.findAll();
	}
}
