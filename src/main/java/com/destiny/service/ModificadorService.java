package com.destiny.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.destiny.model.Modificador;
import com.destiny.repository.ModificadorRepository;

@Service
public class ModificadorService {

	@Autowired
	private ModificadorRepository repository;

	public List<Modificador> findAll() {
		return repository.findAll();
	}

	public Modificador findOne(int id) {
		return repository.findOne(id);
	}
	
	public List<Modificador> findByTipo(String tipo) {
		return repository.findByTipo(tipo);
	}

	public Modificador save(Modificador post) {
		return repository.saveAndFlush(post);
	}

	public void delete(int id) {
		repository.delete(id);
	}
}