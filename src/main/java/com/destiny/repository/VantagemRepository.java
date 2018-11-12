package com.destiny.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.destiny.model.Vantagem;

@Repository
public interface VantagemRepository extends JpaRepository<Vantagem, Integer> {
	
	List<Vantagem> findByTipo(String tipo);
}