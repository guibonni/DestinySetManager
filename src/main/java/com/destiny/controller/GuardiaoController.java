package com.destiny.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import com.destiny.model.Guardiao;
import com.destiny.service.GuardiaoService;

@Controller
public class GuardiaoController {

	@Autowired
	private GuardiaoService service;

	@GetMapping("/guardiao/")
	public ModelAndView findAll() {

		ModelAndView mv = new ModelAndView("/guardiao");
		mv.addObject("guardioes", service.findAll());

		return mv;
	}

	@GetMapping("/guardiao/add")
	public ModelAndView add(Guardiao guardiao) {

		ModelAndView mv = new ModelAndView("/guardiaoAdd");
		mv.addObject("guardiao", guardiao);

		return mv;
	}

	@GetMapping("/guardiao/edit/{id}")
	public ModelAndView edit(@PathVariable("id") int id) {

		return add(service.findOne(id));
	}

	@GetMapping("/guardiao/delete/{id}")
	public ModelAndView delete(@PathVariable("id") int id) {

		service.delete(id);

		return findAll();
	}

	@PostMapping("/guardiao/save")
	public ModelAndView save(@Valid Guardiao guardiao, BindingResult result) {

		if (result.hasErrors()) {
			return add(guardiao);
		}

		service.save(guardiao);

		return findAll();
	}
}