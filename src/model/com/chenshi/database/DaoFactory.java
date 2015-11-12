package com.chenshi.database;

public class DaoFactory
{
	private DaoFactory()
	{
		throw new IllegalAccessError();
	}

	public static <T> CommonDao<T> getDao(Class<T> clazz)
	{
		return new CommonDao<T>(clazz);
	}
}
