package com.destiny.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.destiny.model.Conjunto;
import com.destiny.repository.ConjuntoRepository;

@Service
public class ConjuntoService {

	@Autowired
	private ConjuntoRepository repository;

	public List<Conjunto> findAll() {
		return repository.findAll();
	}

	public Conjunto findOne(int id) {
		return repository.findOne(id);
	}

	public Conjunto save(Conjunto post) {
		return repository.saveAndFlush(post);
	}

	public void delete(int id) {
		repository.delete(id);
	}
}