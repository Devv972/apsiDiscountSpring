package com.apsidiscount.entity;

import java.math.BigDecimal;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "ARTICLE")
@SequenceGenerator(name = "article_seq", allocationSize = 1)
public class Article {

	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="article_seq")
	@Column(name="ID")
	private Long id;
	
	@Column(name="DESIGNATION")
	private String designation;

	@Column(name="IMAGE")
	private String image;

	@Column(name="PRIX")
	private BigDecimal prix;

	@Column(name="CONTENT")
	private String description;
	
	@ManyToOne
	@JoinColumn(name="categorie_id")
	private Categorie categorie;
	
	@ManyToOne
	@JoinColumn(name="constructeur_id")
	private Constructeur constructeur;
	
	@Column(name="DATEMISEENLIGNE")
	@Temporal(TemporalType.DATE)
	private Date miseEnLigne;
	
	@Column(name="STOCK")
	private long stock;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getDesignation() {
		return designation;
	}

	public void setDesignation(String designation) {
		this.designation = designation;
	}

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	public BigDecimal getPrix() {
		return prix;
	}

	public void setPrix(BigDecimal prix) {
		this.prix = prix;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Categorie getCategorie() {
		return categorie;
	}

	public void setCategorie(Categorie categorie) {
		this.categorie = categorie;
	}

	public Constructeur getConstructeur() {
		return constructeur;
	}

	public void setConstructeur(Constructeur constructeur) {
		this.constructeur = constructeur;
	}

	public Date getMiseEnLigne() {
		return miseEnLigne;
	}

	public void setMiseEnLigne(Date miseEnLigne) {
		this.miseEnLigne = miseEnLigne;
	}

	public long getStock() {
		return stock;
	}

	public void setStock(long stock) {
		this.stock = stock;
	}
	
}
