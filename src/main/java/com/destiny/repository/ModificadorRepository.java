package com.destiny.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.destiny.model.Modificador;

@Repository
public interface ModificadorRepository extends JpaRepository<Modificador, Integer> {
	
	List<Modificador> findByTipo(String tipo);
}