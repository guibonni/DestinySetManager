package com.destiny.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import com.destiny.model.Vantagem;
import com.destiny.service.VantagemService;

@Controller
public class VantagemController {

	@Autowired
	private VantagemService service;

	@GetMapping("/vantagem/")
	public ModelAndView findAll() {

		ModelAndView mv = new ModelAndView("/vantagem");
		mv.addObject("vantagens", service.findAll());

		return mv;
	}

	@GetMapping("/vantagem/add")
	public ModelAndView add(Vantagem vantagem) {

		ModelAndView mv = new ModelAndView("/vantagemAdd");
		mv.addObject("vantagem", vantagem);

		return mv;
	}

	@GetMapping("/vantagem/edit/{id}")
	public ModelAndView edit(@PathVariable("id") int id) {

		return add(service.findOne(id));
	}

	@GetMapping("/vantagem/delete/{id}")
	public ModelAndView delete(@PathVariable("id") int id) {

		service.delete(id);

		return findAll();
	}

	@PostMapping("/vantagem/save")
	public ModelAndView save(@Valid Vantagem vantagem, BindingResult result) {

		if (result.hasErrors()) {
			return add(vantagem);
		}

		service.save(vantagem);

		return findAll();
	}
}