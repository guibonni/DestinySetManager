package com.destiny.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.destiny.model.Vantagem;
import com.destiny.repository.VantagemRepository;

@Service
public class VantagemService {

	@Autowired
	private VantagemRepository repository;

	public List<Vantagem> findAll() {
		return repository.findAll();
	}

	public List<Vantagem> findByTipoIn(List<String> tipos) {
		return repository.findByTipoIn(tipos);
	}

	public Vantagem findOne(int id) {
		return repository.findOne(id);
	}
	
	public List<Vantagem> findByTipo(String tipo) {
		return repository.findByTipo(tipo);
	}

	public Vantagem save(Vantagem post) {
		return repository.saveAndFlush(post);
	}

	public void delete(int id) {
		repository.delete(id);
	}
}