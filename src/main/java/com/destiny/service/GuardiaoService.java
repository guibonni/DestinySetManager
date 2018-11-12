package com.destiny.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.destiny.model.Guardiao;
import com.destiny.repository.GuardiaoRepository;

@Service
public class GuardiaoService {

	@Autowired
	private GuardiaoRepository repository;

	public List<Guardiao> findAll() {
		return repository.findAll();
	}

	public Guardiao findOne(int id) {
		return repository.findOne(id);
	}

	public Guardiao save(Guardiao post) {
		return repository.saveAndFlush(post);
	}

	public void delete(int id) {
		repository.delete(id);
	}
}