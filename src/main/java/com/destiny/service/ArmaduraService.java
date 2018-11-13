package com.destiny.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.destiny.model.Armadura;
import com.destiny.repository.ArmaduraRepository;

@Service
public class ArmaduraService {

	@Autowired
	private ArmaduraRepository repository;

	public List<Armadura> findAll() {
		return repository.findAll();
	}

	public Armadura findOne(int id) {
		return repository.findOne(id);
	}
	
	public List<Armadura> findByCategoria(String categoria) {
		return repository.findByCategoria(categoria);
	}

	public Armadura save(Armadura post) {
		return repository.saveAndFlush(post);
	}

	public void delete(int id) {
		repository.delete(id);
	}
}