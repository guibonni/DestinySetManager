package com.destiny.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.destiny.model.Armadura;

@Repository
public interface ArmaduraRepository extends JpaRepository<Armadura, Integer> { }