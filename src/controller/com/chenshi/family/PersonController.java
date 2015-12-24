package com.chenshi.family;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.logging.Logger;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.chenshi.spring.ViewFactory;

@Controller
@RequestMapping("/person")
public class PersonController
{
	private final String personModel = "personModel";
	private final Logger log = Logger.getLogger(getClass().getSimpleName());

	@Autowired
	private PersonService personService;

	@RequestMapping(value = "/add", method = RequestMethod.GET)
	public ModelAndView edit(Model model)
	{
		if (!model.containsAttribute(personModel))
			model.addAttribute(personModel, new PersonVo());

		List<Person> personList = personService.findValidList();
		List<LifeStatus> statusList = Stream.of(LifeStatus.values()).collect(Collectors.toList());
		Map<String, Object> map = new HashMap<>();
		map.put("personList", personList);
		map.put("statusList", statusList);

		return ViewFactory.render("family/person", map);
	}

	@RequestMapping(value = "/add", method = RequestMethod.POST)
	public ModelAndView save(@Valid @ModelAttribute(personModel) PersonVo person,
			BindingResult result, HttpServletRequest request, Model model, RedirectAttributes attr)
	{
		if (result.hasErrors())
		{
			return edit(model);
		}

		System.out.println(person.getLifeStatus());
		Person entity = person.toEntity();
		entity.setOperator("admin");
		System.out.println(entity);
		personService.save(entity);
		return ViewFactory.render("redirect:/person/list");
	}

	@RequestMapping("/list")
	public ModelAndView list()
	{
		List<Person> list = personService.findValidList();
		log.info("list size: " + list.size());
		Map<String, Object> map = new HashMap<>();
		map.put("personList", list);
		return ViewFactory.render("family/list", map);
	}
}
