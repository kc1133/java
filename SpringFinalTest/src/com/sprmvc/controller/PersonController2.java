package com.sprmvc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;

import com.sprmvc.bean.Person;

@Controller
@SessionAttributes("personObj")
public class PersonController2 {

	@RequestMapping(value="/person-form")
	public ModelAndView personPage() {
		return new ModelAndView("person-page", "person-entity", new Person());
	}
	
	@RequestMapping(value="/process-person")
	public ModelAndView processPerson(@ModelAttribute Person person) {
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("person-result-page");
		
		modelAndView.addObject("pers", person);
		modelAndView.addObject("personObj", person);
		
		return modelAndView;
	}
	
}
