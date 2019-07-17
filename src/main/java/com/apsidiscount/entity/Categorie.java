package com.apsidiscount.entity;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name="CATEGORIE")
@SequenceGenerator(name="categorie_seq", allocationSize=1)
public class Categorie {
	
	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="categorie_seq")
	@Column(name="ID")
	private Long id;
	
	@Column(name="NOM")
	private String nom;
	
	@OneToMany(mappedBy="categorie")
	private List<Article> articles;

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
