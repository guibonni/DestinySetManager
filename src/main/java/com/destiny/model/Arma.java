package com.destiny.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.validator.constraints.NotBlank;

@Entity
@Table(name="arma")
public class Arma extends Equipamento implements Serializable{
	
	private static final long serialVersionUID = 5819058386682238602L;

	@Column(nullable = false, length = 8)
	@NotBlank(message = "Elemento é uma informação obrigatória.")
	private String elemento;
	
	@Column(nullable = false, length = 50)
	@NotBlank(message = "Tipo é uma informação obrigatória.")
	private String tipo;
	
	@ManyToOne
	private Vantagem mira;
	
	@ManyToOne
	private Vantagem cano;
	
	@ManyToOne
	private Vantagem municao;
	
	@ManyToOne
	private Vantagem carregador;

	public String getElemento() {
		return elemento;
	}

	public void setElemento(String elemento) {
		this.elemento = elemento;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public Vantagem getMira() {
		return mira;
	}

	public void setMira(Vantagem mira) {
		this.mira = mira;
	}

	public Vantagem getCano() {
		return cano;
	}

	public void setCano(Vantagem cano) {
		this.cano = cano;
	}

	public Vantagem getMunicao() {
		return municao;
	}

	public void setMunicao(Vantagem municao) {
		this.municao = municao;
	}

	public Vantagem getCarregador() {
		return carregador;
	}

	public void setCarregador(Vantagem carregador) {
		this.carregador = carregador;
	}	
	
}