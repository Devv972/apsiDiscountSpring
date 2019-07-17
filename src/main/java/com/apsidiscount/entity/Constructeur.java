package com.apsidiscount.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name="CONSTRUCTEUR")
@SequenceGenerator(name="constructeur_seq", allocationSize=1)
public class Constructeur {
	
	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="constructeur_seq")
	@Column(name="ID")
	private Long id;
	
	@Column(name="NOM")
	private String nom;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}
	
	@Override
	public String toString() {
		return this.nom;
	}
}
