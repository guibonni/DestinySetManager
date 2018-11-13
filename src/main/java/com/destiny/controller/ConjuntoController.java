package com.destiny.controller;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;
import com.destiny.model.Conjunto;
import com.destiny.service.ArmaService;
import com.destiny.service.ArmaduraService;
import com.destiny.service.GuardiaoService;
import com.destiny.service.ConjuntoService;

@Controller
public class ConjuntoController {

	@Autowired
	private ConjuntoService service;
	@Autowired
	private ArmaService serviceArma;
	@Autowired
	private ArmaduraService serviceArmadura;
	@Autowired
	private GuardiaoService serviceGuardiao;

	@GetMapping("/conjunto/")
	public ModelAndView findAll() {

		ModelAndView mv = new ModelAndView("/conjunto");
		mv.addObject("conjuntos", service.findAll());
		return mv;
	}

	@GetMapping("/conjunto/add")
	public ModelAndView add(Conjunto conjunto) {

		ModelAndView mv = new ModelAndView("/conjuntoAdd");
		
		List<String> cinetica = Collections.singletonList("Cinética");
		List<String> elemental = Arrays.asList("Solar", "Vácuo", "Arco");
		List<String> pesada = Collections.singletonList("Pesada");
		List<String> normais = Arrays.asList("Primária", "Especial");
		
		mv.addObject("conjunto", conjunto);
		mv.addObject("cineticas", serviceArma.findByCategoriaInAndElementoIn(normais, cinetica));
		mv.addObject("energeticas", serviceArma.findByCategoriaInAndElementoIn(normais, elemental));
		mv.addObject("poderosas", serviceArma.findByCategoriaInAndElementoIn(pesada, elemental));
		mv.addObject("elmos", serviceArmadura.findByCategoria("Elmo"));
		mv.addObject("bracos", serviceArmadura.findByCategoria("Braço"));
		mv.addObject("peitos", serviceArmadura.findByCategoria("Peito"));
		mv.addObject("pernas", serviceArmadura.findByCategoria("Perna"));
		mv.addObject("itensDeClasse", serviceArmadura.findByCategoria("Item de Classe"));
		mv.addObject("guardioes", serviceGuardiao.findAll());

		return mv;
	}

	@GetMapping("/conjunto/edit/{id}")
	public ModelAndView edit(@PathVariable("id") int id) {

		return add(service.findOne(id));
	}

	@GetMapping("/conjunto/delete/{id}")
	public ModelAndView delete(@PathVariable("id") int id) {

		service.delete(id);

		return findAll();
	}

	@PostMapping("/conjunto/save")
	public ModelAndView save(@Valid Conjunto conjunto, BindingResult result) {

		if (result.hasErrors()) {
			return add(conjunto);
		}

		service.save(conjunto);

		return findAll();
	}
}