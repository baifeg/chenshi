package com.chenshi.database;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.criterion.Criterion;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate3.HibernateTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.chenshi.spring.SpringHelper;

@Repository
@Transactional
public class CommonDao<T>
{
	private final Class<T> clazz;
	private static HibernateTemplate template;

	@Autowired
	private SessionFactory sessionFactory;

	public CommonDao()
	{
		clazz = null;
	}

	public CommonDao(Class<T> clazz)
	{
		this.clazz = clazz;
		sessionFactory = SpringHelper.getSessionFactory();
		// template = new HibernateTemplate(SpringHelper.getSessionFactory());
		template = new HibernateTemplate(sessionFactory);
	}

	private Session getSession()
	{
		return sessionFactory.getCurrentSession();
	}

	@SuppressWarnings("unchecked")
	public List<T> findAll()
	{
		String name = clazz.getSimpleName();
		return (List<T>) template.find("from " + name);
	}

	public List<T> queryAll()
	{
		return query(new Criterion[] {});
	}

	public List<T> query(Criterion... criterions)
	{
		Session session = getSession();
		Transaction tx = session.beginTransaction();
		Criteria criteria = session.createCriteria(clazz);
		for (Criterion criterion : criterions)
		{
			criteria.add(criterion);
		}
		@SuppressWarnings("unchecked")
		List<T> list = criteria.list();
		tx.commit();
		return list;
	}

	public void add(T t)
	{
		template.save(t);
	}

	public void delete(T t)
	{
		template.delete(t);
	}
}
