package com.destiny.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.validator.constraints.NotBlank;

@Entity
@Table(name="conjunto")
public class Conjunto implements Serializable{
	
	private static final long serialVersionUID = 5819058386682238602L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int id;
	
	@Column(nullable = false, length = 100)
	@NotBlank(message = "Nome é uma informação obrigatória.")
	private String nome;
	
	@ManyToOne
	private Guardiao guardiao;
	
	@ManyToOne
	private Arma cinetica;
	
	@ManyToOne
	private Arma energetica;
	
	@ManyToOne
	private Arma poderosa;
	
	@ManyToOne
	private Armadura elmo;
	
	@ManyToOne
	private Armadura peito;
	
	@ManyToOne
	private Armadura braco;
	
	@ManyToOne
	private Armadura perna;
	
	@ManyToOne
	private Armadura itemDeClasse;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Guardiao getGuardiao() {
		return guardiao;
	}

	public void setGuardiao(Guardiao guardiao) {
		this.guardiao = guardiao;
	}

	public Arma getCinetica() {
		return cinetica;
	}

	public void setCinetica(Arma cinetica) {
		this.cinetica = cinetica;
	}

	public Arma getEnergetica() {
		return energetica;
	}

	public void setEnergetica(Arma energetica) {
		this.energetica = energetica;
	}

	public Arma getPoderosa() {
		return poderosa;
	}

	public void setPoderosa(Arma poderosa) {
		this.poderosa = poderosa;
	}

	public Armadura getElmo() {
		return elmo;
	}

	public void setElmo(Armadura elmo) {
		this.elmo = elmo;
	}

	public Armadura getPeito() {
		return peito;
	}

	public void setPeito(Armadura peito) {
		this.peito = peito;
	}

	public Armadura getBraco() {
		return braco;
	}

	public void setBraco(Armadura braco) {
		this.braco = braco;
	}

	public Armadura getPerna() {
		return perna;
	}

	public void setPerna(Armadura perna) {
		this.perna = perna;
	}

	public Armadura getItemDeClasse() {
		return itemDeClasse;
	}

	public void setItemDeClasse(Armadura itemDeClasse) {
		this.itemDeClasse = itemDeClasse;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
}