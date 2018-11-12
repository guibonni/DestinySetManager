package com.destiny.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.destiny.model.Guardiao;

@Repository
public interface GuardiaoRepository extends JpaRepository<Guardiao, Integer> { }