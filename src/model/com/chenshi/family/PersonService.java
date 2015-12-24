package com.chenshi.family;

import java.util.List;

import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Service;

import com.chenshi.database.CommonDao;

@Service
public class PersonService extends CommonDao<Person>
{
	public PersonService()
	{
		super(Person.class);
	}

	public List<Person> findValidList()
	{
		return query(Restrictions.ne("id", 1l));
	}
}
