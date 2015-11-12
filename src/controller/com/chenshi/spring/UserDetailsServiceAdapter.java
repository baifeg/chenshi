package com.chenshi.spring;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Qualifier("userDetailsService")
@Service
public class UserDetailsServiceAdapter implements UserDetailsService
{

	@Override
	public UserDetails loadUserByUsername(String arg0) throws UsernameNotFoundException
	{
		// TODO find Admin by username
		return new UserDetailsAdapter(arg0);
	}

}
