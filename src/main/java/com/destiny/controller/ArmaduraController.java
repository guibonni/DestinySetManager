package com.destiny.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;
import com.destiny.model.Armadura;
import com.destiny.service.ModificadorService;
import com.destiny.service.VantagemService;
import com.destiny.service.ArmaduraService;

@Controller
public class ArmaduraController {

	@Autowired
	private ArmaduraService service;
	@Autowired
	private VantagemService serviceVantagem;
	@Autowired
	private ModificadorService serviceModificador;

	@GetMapping("/armadura/")
	public ModelAndView findAll() {

		ModelAndView mv = new ModelAndView("/armadura");
		mv.addObject("armaduras", service.findAll());
		return mv;
	}

	@GetMapping("/armadura/elmo/")
	public ModelAndView findAllElmo() {

		ModelAndView mv = new ModelAndView("/armadura");
		mv.addObject("armaduras", service.findByCategoria("Elmo"));
		return mv;
	}

	@GetMapping("/armadura/peito/")
	public ModelAndView findAllPeito() {

		ModelAndView mv = new ModelAndView("/armadura");
		mv.addObject("armaduras", service.findByCategoria("Peito"));
		return mv;
	}

	@GetMapping("/armadura/braco/")
	public ModelAndView findAllBraco() {

		ModelAndView mv = new ModelAndView("/armadura");
		mv.addObject("armaduras", service.findByCategoria("Braço"));
		return mv;
	}

	@GetMapping("/armadura/perna/")
	public ModelAndView findAllPerna() {

		ModelAndView mv = new ModelAndView("/armadura");
		mv.addObject("armaduras", service.findByCategoria("Perna"));
		return mv;
	}

	@GetMapping("/armadura/classe/")
	public ModelAndView findAllClasse() {

		ModelAndView mv = new ModelAndView("/armadura");
		mv.addObject("armaduras", service.findByCategoria("Item de Classe"));
		return mv;
	}

	@GetMapping("/armadura/add")
	public ModelAndView add(Armadura armadura) {

		ModelAndView mv = new ModelAndView("/armaduraAdd");
		mv.addObject("armadura", armadura);
		mv.addObject("vantagens", serviceVantagem.findByTipo("AR"));
		mv.addObject("modificadores", serviceModificador.findByTipo("A"));

		return mv;
	}
	
	public ModelAndView add(Armadura armadura, String mensagem) {

		ModelAndView mv = new ModelAndView("/armaduraAdd");
		mv.addObject("armadura", armadura);
		mv.addObject("mensagem", mensagem);
		mv.addObject("temMensagem", true);
		mv.addObject("vantagens", serviceVantagem.findByTipo("AR"));
		mv.addObject("modificadores", serviceModificador.findByTipo("A"));

		return mv;
	}

	@GetMapping("/armadura/edit/{id}")
	public ModelAndView edit(@PathVariable("id") int id) {

		return add(service.findOne(id));
	}

	@GetMapping("/armadura/delete/{id}")
	public ModelAndView delete(@PathVariable("id") int id) {

		service.delete(id);

		return findAll();
	}

	@PostMapping("/armadura/save")
	public ModelAndView save(@Valid Armadura armadura, BindingResult result) {

		if (armadura.validar()) {
			if (result.hasErrors()) {
				return add(armadura);
			}

			service.save(armadura);

			if (armadura.getCategoria().equals("Elmo")) {
				return findAllElmo();
			} else if (armadura.getCategoria().equals("Peito")) {
				return findAllPeito();
			} else if (armadura.getCategoria().equals("Braço")) {
				return findAllBraco();
			} else if (armadura.getCategoria().equals("Perna")) {
				return findAllPerna();
			} else {
				return findAllClasse();
			}
		} else {
			return add(armadura, "Falha na validação dos dados. Verifique se as informações estão corretas.");
		}
		
	}
}