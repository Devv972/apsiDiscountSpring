package com.apsidiscount.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;

import com.apsidiscount.entity.Article;
import com.apsidiscount.entity.Categorie;

@Repository
public class ArticleDAOImpl implements ArticleDAO {

	@PersistenceContext
	private EntityManager em;
	
	public ArticleDAOImpl() {
	}

	public ArticleDAOImpl(EntityManager em) {
		this.em = em;
	}

	@Override
	public Article getById(long id) {
		return this.em.find(Article.class, id);
	}

	@Override
	public List<Article> getByCategorie(String nomCategorie) {
		return this.em.createQuery("select a from Article a where a.categorie.nom = :nomCategorie", Article.class)
				      .setParameter("nomCategorie", nomCategorie)
				      .getResultList();
	}
	@Override
	public List<Article> getCategorieById(Long idCategorie) {
		return this.em.createQuery("select a from Article a where a.categorie.id = :id", Article.class)
				      .setParameter("idCategorie", idCategorie)
				      .getResultList();
	}

	@Override
	public List<Article> getByCategorie(Categorie categorie) {
		return this.em.createQuery("select a from Article a where a.categorie = :categorie", Article.class)
				      .setParameter("categorie", categorie)
			          .getResultList();
	}

	@Override
	public Article create(Article a) {
		this.em.persist(a);
		return a;
	}

	@Override
	public List<Article> getAll() {
		return this.em.createQuery("select  Article from Article a ", Article.class).getResultList();
	}

	
	

}
