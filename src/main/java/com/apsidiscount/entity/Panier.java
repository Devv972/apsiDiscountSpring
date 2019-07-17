package com.apsidiscount.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import com.apsidiscount.service.StockInsuffisantException;

@Entity
@Table(name = "PANIER")
@SequenceGenerator(name = "panier_seq", allocationSize = 1)
public class Panier {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "panier_seq")
	private long id;
	
	@ManyToMany
	@JoinTable(name = "PANIERARTICLE", 
	           joinColumns = @JoinColumn(name="panier_id"), 
	           inverseJoinColumns = @JoinColumn(name="article_id"))
	private List<Article> articles = new ArrayList<Article>();

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public List<Article> getArticles() {
		return articles;
	}

	public void setArticles(List<Article> articles) {
		this.articles = articles;
	}

	public void addArticle(Article article) throws StockInsuffisantException {
		if (article.getStock() == 0) {
			throw new StockInsuffisantException(article);
		}
		this.articles.add(article);
	}

	public boolean contient(Article articleAVerifier) {
		for (Article article : articles) {
			if(article.getId() == articleAVerifier.getId()) {
				return true;
			}
		}
		return false;
	}

}
