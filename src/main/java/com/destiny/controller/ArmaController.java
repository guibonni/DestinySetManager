package com.destiny.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;
import com.destiny.model.Arma;
import com.destiny.service.ModificadorService;
import com.destiny.service.VantagemService;
import com.destiny.service.ArmaService;

@Controller
public class ArmaController {

	@Autowired
	private ArmaService service;
	@Autowired
	private VantagemService serviceVantagem;
	@Autowired
	private ModificadorService serviceModificador;

	@GetMapping("/arma/")
	public ModelAndView findAll() {

		ModelAndView mv = new ModelAndView("/arma");
		mv.addObject("armas", service.findAll());
		return mv;
	}

	@GetMapping("/arma/add")
	public ModelAndView add(Arma arma) {

		ModelAndView mv = new ModelAndView("/armaAdd");
		mv.addObject("arma", arma);
		mv.addObject("canos", serviceVantagem.findByTipo("BA"));
		mv.addObject("miras", serviceVantagem.findByTipo("SI"));
		mv.addObject("municoes", serviceVantagem.findByTipo("AM"));
		mv.addObject("carregadores", serviceVantagem.findByTipo("CL"));
		mv.addObject("vantagens", serviceVantagem.findByTipo("WE"));
		mv.addObject("modificadores", serviceModificador.findByTipo("W"));

		return mv;
	}

	@GetMapping("/arma/edit/{id}")
	public ModelAndView edit(@PathVariable("id") int id) {

		return add(service.findOne(id));
	}

	@GetMapping("/arma/delete/{id}")
	public ModelAndView delete(@PathVariable("id") int id) {

		service.delete(id);

		return findAll();
	}

	@PostMapping("/arma/save")
	public ModelAndView save(@Valid Arma arma, BindingResult result) {

		if (result.hasErrors()) {
			return add(arma);
		}

		service.save(arma);

		return findAll();
	}
}