package com.destiny.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.destiny.model.Arma;

@Repository
public interface ArmaRepository extends JpaRepository<Arma, Integer> {
	
	List<Arma> findByCategoriaInAndElementoIn(List<String> categorias, List<String> elementos);
}