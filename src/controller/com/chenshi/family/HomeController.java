package com.chenshi.family;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.chenshi.spring.ViewFactory;

@RestController
public class HomeController
{
	@RequestMapping("/chenshi/")
	public ModelAndView index()
	{
		return ViewFactory.render("index");
	}
}
