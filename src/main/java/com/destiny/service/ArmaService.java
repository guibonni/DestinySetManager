package com.destiny.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.destiny.model.Arma;
import com.destiny.repository.ArmaRepository;

@Service
public class ArmaService {

	@Autowired
	private ArmaRepository repository;

	public List<Arma> findAll() {
		return repository.findAll();
	}

	public Arma findOne(int id) {
		return repository.findOne(id);
	}
	
	public List<Arma> findByCategoriaInAndElementoIn(List<String> categorias, List<String> elementos) {
		return repository.findByCategoriaInAndElementoIn(categorias, elementos);
	}

	public Arma save(Arma post) {
		return repository.saveAndFlush(post);
	}

	public void delete(int id) {
		repository.delete(id);
	}
}