package com.destiny.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

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
	
	@Column(nullable = false)
	@NotNull
	private int poder;
	
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
	
	public int getPoder() {
		return poder;
	}
	
	public void setPoder(int poder) {
		this.poder = poder;
	}
	
	public void gerarPoder() {
		int poder = 0;

		poder += this.getCinetica().getPoder();
		poder += this.getEnergetica().getPoder();
		poder += this.getPoderosa().getPoder();
		poder += this.getElmo().getPoder();
		poder += this.getPeito().getPoder();
		poder += this.getBraco().getPoder();
		poder += this.getPerna().getPoder();
		poder += this.getItemDeClasse().getPoder();
		
		poder = poder / 8;
		
		this.poder = poder;
	}
	
	private int contarExoticos(int tipo) {
		int quantidade = 0;
		
		if (tipo == 1) {
			quantidade += this.getCinetica().getRaridade().equals("Exótico") ? 1 : 0;
			quantidade += this.getEnergetica().getRaridade().equals("Exótico") ? 1 : 0;
			quantidade += this.getPoderosa().getRaridade().equals("Exótico") ? 1 : 0;
		} else {
			quantidade += this.getElmo().getRaridade().equals("Exótico") ? 1 : 0;
			quantidade += this.getPeito().getRaridade().equals("Exótico") ? 1 : 0;
			quantidade += this.getBraco().getRaridade().equals("Exótico") ? 1 : 0;
			quantidade += this.getPerna().getRaridade().equals("Exótico") ? 1 : 0;
			quantidade += this.getItemDeClasse().getRaridade().equals("Exótico") ? 1 : 0;
		}
		
		return quantidade;
	}
	
	public boolean validar() {
		try {
			boolean vCinetica = this.getCinetica().getElemento().equals("Cinético") && this.getCinetica().getCategoria().equals("Primária");
			boolean vEnergetica = !this.getEnergetica().getElemento().equals("Cinética") && !this.getEnergetica().getCategoria().equals("Pesada");
			boolean vPoderosa = !this.getPoderosa().getElemento().equals("Cinética") && this.getPoderosa().getCategoria().equals("Pesada");
			boolean vElmo = this.getElmo().getCategoria().equals("Elmo");
			boolean vPeito = this.getPeito().getCategoria().equals("Peito");
			boolean vBraco = this.getBraco().getCategoria().equals("Braço");
			boolean vPerna = this.getPerna().getCategoria().equals("Perna");
			boolean vItemClasse = this.getItemDeClasse().getCategoria().equals("Item de Classe");
			boolean vArmaE = this.contarExoticos(1) <= 1;
			boolean vArmaduraE = this.contarExoticos(2) <= 1;
			
			return vCinetica && vEnergetica && vPoderosa && vElmo && vPeito && vBraco && vPerna && vItemClasse && vArmaE && vArmaduraE;
		} catch (Exception e) {
			return false;
		}
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
}