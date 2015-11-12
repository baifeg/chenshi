package com.chenshi.spring;

import java.util.Collection;
import java.util.List;
import java.util.Locale;
import java.util.Map;

import javax.servlet.http.Cookie;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.web.savedrequest.SavedRequest;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

@Configuration
public class AfterLogin implements SavedRequest
{
	private static final long serialVersionUID = -2242313577481647352L;

	@Override
	public List<Cookie> getCookies()
	{
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Collection<String> getHeaderNames()
	{
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<String> getHeaderValues(String arg0)
	{
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Locale> getLocales()
	{
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getMethod()
	{
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Map<String, String[]> getParameterMap()
	{
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String[] getParameterValues(String arg0)
	{
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getRedirectUrl()
	{
		ServletRequestAttributes attr = (ServletRequestAttributes) RequestContextHolder
				.currentRequestAttributes();
		return (String) attr.getRequest().getSession().getAttribute("url_prior_login");
	}

}
