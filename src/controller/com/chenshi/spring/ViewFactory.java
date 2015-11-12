package com.chenshi.spring;

import java.util.HashMap;
import java.util.Map;

import org.springframework.web.servlet.ModelAndView;

public class ViewFactory
{
	public static ModelAndView render(String viewName)
	{
		return render(viewName, new HashMap<String, Object>());
	}

	public static ModelAndView render(String viewName, Map<String, Object> model)
	{
		return new ModelAndView(viewName, model);
	}
}
