package com.destiny.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.MappedSuperclass;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.NotBlank;

@MappedSuperclass
public abstract class Equipamento implements Serializable {

	private static final long serialVersionUID = -9213676058537370096L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int id;
	
	@Column(nullable = false, length = 100)
	@NotBlank(message = "Nome é uma informação obrigatória.")
	private String nome;
	
	@Column(nullable = false)
	@NotNull(message = "Poder é uma informação obrigatória")
	private int poder;
	
	@Column(nullable = false, length = 8)
	@NotBlank(message = "Raridade é uma informação obrigatória.")
	private String raridade;
	
	@Column(nullable = false, length = 15)
	@NotBlank(message = "Categoria é uma informação obrigatória.")
	private String categoria;
	
	@ManyToOne
	private Vantagem vantagem1;
	
	@ManyToOne
	private Vantagem vantagem2;
	
	@ManyToOne
	private Vantagem vantagem3;
	
	@ManyToOne
	private Vantagem vantagem4;
	
	@ManyToOne
	private Modificador mod;
	
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

	public int getPoder() {
		return poder;
	}

	public void setPoder(int poder) {
		this.poder = poder;
	}

	public String getRaridade() {
		return raridade;
	}

	public void setRaridade(String raridade) {
		this.raridade = raridade;
	}

	public String getCategoria() {
		return categoria;
	}

	public void setCategoria(String categoria) {
		this.categoria = categoria;
	}

	public Vantagem getVantagem1() {
		return vantagem1;
	}

	public void setVantagem1(Vantagem vantagem1) {
		this.vantagem1 = vantagem1;
	}

	public Vantagem getVantagem2() {
		return vantagem2;
	}

	public void setVantagem2(Vantagem vantagem2) {
		this.vantagem2 = vantagem2;
	}

	public Vantagem getVantagem3() {
		return vantagem3;
	}

	public void setVantagem3(Vantagem vantagem3) {
		this.vantagem3 = vantagem3;
	}

	public Vantagem getVantagem4() {
		return vantagem4;
	}

	public void setVantagem4(Vantagem vantagem4) {
		this.vantagem4 = vantagem4;
	}

	public Modificador getMod() {
		return mod;
	}

	public void setMod(Modificador mod) {
		this.mod = mod;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

}