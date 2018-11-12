package com.destiny.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import com.destiny.model.Modificador;
import com.destiny.service.ModificadorService;

@Controller
public class ModificadorController {

	@Autowired
	private ModificadorService service;

	@GetMapping("/modificador/")
	public ModelAndView findAll() {

		ModelAndView mv = new ModelAndView("/modificador");
		mv.addObject("modificadores", service.findAll());

		return mv;
	}

	@GetMapping("/modificador/add")
	public ModelAndView add(Modificador modificador) {

		ModelAndView mv = new ModelAndView("/modificadorAdd");
		mv.addObject("modificador", modificador);

		return mv;
	}

	@GetMapping("/modificador/edit/{id}")
	public ModelAndView edit(@PathVariable("id") int id) {

		return add(service.findOne(id));
	}

	@GetMapping("/modificador/delete/{id}")
	public ModelAndView delete(@PathVariable("id") int id) {

		service.delete(id);

		return findAll();
	}

	@PostMapping("/modificador/save")
	public ModelAndView save(@Valid Modificador modificador, BindingResult result) {

		if (result.hasErrors()) {
			return add(modificador);
		}

		service.save(modificador);

		return findAll();
	}
}