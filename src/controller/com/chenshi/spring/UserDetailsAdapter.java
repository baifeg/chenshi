package com.chenshi.spring;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.UserDetails;

import com.chenshi.admin.Admin;
import com.chenshi.admin.AdminService;

public class UserDetailsAdapter implements UserDetails
{
	private static final long serialVersionUID = -1256349742709651571L;

	private Admin admin;

	@Autowired
	private AdminService adminService;

	public UserDetailsAdapter(String username)
	{
		this.admin = adminService.getAdminByUsername(username);
	}

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities()
	{
		return AuthorityUtils.createAuthorityList("ROLE_PRE_AUTH_USER");
	}

	@Override
	public String getPassword()
	{
		return admin.getPassword();
	}

	@Override
	public String getUsername()
	{
		return admin.getUsername();
	}

	@Override
	public boolean isAccountNonExpired()
	{
		return true;
	}

	@Override
	public boolean isAccountNonLocked()
	{
		return true;
	}

	@Override
	public boolean isCredentialsNonExpired()
	{
		return true;
	}

	@Override
	public boolean isEnabled()
	{
		return true;
	}

}
