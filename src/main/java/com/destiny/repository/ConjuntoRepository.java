package com.destiny.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.destiny.model.Conjunto;

@Repository
public interface ConjuntoRepository extends JpaRepository<Conjunto, Integer> { }