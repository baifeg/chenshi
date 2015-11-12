package com.chenshi.admin;

import java.util.List;

import org.hibernate.criterion.Restrictions;
import org.hibernate.criterion.SimpleExpression;
import org.springframework.stereotype.Service;

import com.chenshi.database.CommonDao;
import com.chenshi.database.DaoFactory;

@Service
public class AdminService
{
	private final CommonDao<Admin> dao;

	public AdminService()
	{
		dao = DaoFactory.getDao(Admin.class);
	}
	public boolean authenticate(Admin admin)
	{
		List<Admin> list = dao.findAll();
		for (Admin tempAdmin : list)
		{
			if (tempAdmin.getUsername().equals(admin.getUsername())
					&& tempAdmin.getPassword().equals(admin.getPassword()))
				return true;
		}
		return false;
	}

	public Admin getAdminByUsername(String username)
	{
		SimpleExpression re = Restrictions.eq("username", username);
		return dao.query(re).get(0);
	}
}
