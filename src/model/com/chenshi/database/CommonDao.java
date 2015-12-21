package com.chenshi.database;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.criterion.Criterion;
import org.springframework.orm.hibernate3.HibernateTemplate;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.chenshi.spring.SpringHelper;

public class CommonDao<T> extends HibernateDaoSupport
{
	private final Class<T> clazz;
	private static HibernateTemplate template;

	private SessionFactory sessionFactory;

	public CommonDao(Class<T> clazz)
	{
		this.clazz = clazz;
		sessionFactory = SpringHelper.getSessionFactory();
		setSessionFactory(sessionFactory);
		template = getHibernateTemplate();
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

	public void saveOrUpdate(T t)
	{
		template.saveOrUpdate(t);
	}

	/**
	 * @param t
	 * @return primary key of the entity
	 */
	public Long save(T t)
	{
		return (Long) template.save(t);
	}

	public void delete(T t)
	{
		template.delete(t);
	}

	public T getById(long id)
	{
		return template.get(clazz, id);
	}
}
