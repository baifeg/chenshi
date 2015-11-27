package com.chenshi.family;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.logging.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.chenshi.spring.ViewFactory;

@RestController
public class HomeController
{
	private final Logger log = Logger.getLogger(getClass().getSimpleName());

	@Autowired
	private PersonService personService;

	@RequestMapping("/")
	public ModelAndView index()
	{
		return ViewFactory.render("index");
	}

	@RequestMapping("/list")
	public ModelAndView list()
	{
		List<Person> list = personService.queryAll();
		log.info("list size: " + list.size());
		Map<String, Object> map = new HashMap<>();
		map.put("personList", list);
		return ViewFactory.render("list", map);
	}
}
