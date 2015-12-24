package com.chenshi.database;

import java.util.List;

import org.hibernate.SessionFactory;
import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.DetachedCriteria;
import org.springframework.orm.hibernate3.HibernateTemplate;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.chenshi.spring.SpringHelper;

public class CommonDao<T> extends HibernateDaoSupport
{
	private final Class<T> clazz;
	protected static HibernateTemplate template;

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

	@SuppressWarnings("unchecked")
	public List<T> query(Criterion... criterions)
	{
		DetachedCriteria criteria = DetachedCriteria.forClass(clazz);
		for (Criterion criterion : criterions)
		{
			criteria.add(criterion);
		}
		return (List<T>) template.findByCriteria(criteria);
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
