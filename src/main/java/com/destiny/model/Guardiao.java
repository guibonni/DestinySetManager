package com.destiny.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.NotBlank;

@Entity
@Table(name = "guardiao")
public class Guardiao implements Serializable {

	private static final long serialVersionUID = -9213676058537370096L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int id;
	
	@Column(nullable = false, length = 50)
	@NotBlank(message = "Nome é uma informação obrigatória.")
	private String nome;
	
	@Column(nullable = false, length = 7)
	@NotBlank(message = "Classe é uma informação obrigatória.")
	private String classe;
	
	@Column(nullable = false)
	@NotNull(message = "Nível é uma informação obrigatória.")
	private String nivel;

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

	public String getClasse() {
		return classe;
	}

	public void setClasse(String classe) {
		this.classe = classe;
	}

	public String getNivel() {
		return nivel;
	}

	public void setNivel(String nivel) {
		this.nivel = nivel;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
	public boolean validar() {
		try {
			boolean vNome = this.getNome().length() <= 50;
			boolean vNivel = Integer.parseInt(this.getNivel()) <= 50;
			boolean vClasse = this.getClasse().equals("Caçador") || this.getClasse().equals("Titã") || this.getClasse().equals("Arcano");
			
			return vNome && vNivel && vClasse;
		} catch (Exception e) {
			return false;
		}
	}

}
