package com.destiny.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class MenuController {

	@GetMapping("/home/")
	public ModelAndView findAll() {

		ModelAndView mv = new ModelAndView("/home");
		return mv;
	}
}