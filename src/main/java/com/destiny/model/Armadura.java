package com.destiny.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.NotBlank;

@Entity
@Table(name="armadura")
public class Armadura extends Equipamento implements Serializable{
	
	private static final long serialVersionUID = 5819058386682238602L;

	@Column(nullable = false, length = 7)
	@NotBlank(message = "Classe é uma informação obrigatória.")
	private String classe;
	
	@Column(nullable = false)
	@NotNull
	private int resiliencia;
	
	@Column(nullable = false)
	@NotNull
	private int mobilidade;
	
	@Column(nullable = false)
	@NotNull
	private int recuperacao;

	public String getClasse() {
		return classe;
	}

	public void setClasse(String classe) {
		this.classe = classe;
	}

	public int getResiliencia() {
		return resiliencia;
	}

	public void setResiliencia(int resiliencia) {
		this.resiliencia = resiliencia;
	}

	public int getMobilidade() {
		return mobilidade;
	}

	public void setMobilidade(int mobilidade) {
		this.mobilidade = mobilidade;
	}

	public int getRecuperacao() {
		return recuperacao;
	}

	public void setRecuperacao(int recuperacao) {
		this.recuperacao = recuperacao;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
}