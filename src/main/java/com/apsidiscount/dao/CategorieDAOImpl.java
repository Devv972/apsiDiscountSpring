package com.apsidiscount.dao;

import java.math.BigDecimal;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;

import com.apsidiscount.entity.Article;
import com.apsidiscount.entity.Categorie;



@Repository
public class CategorieDAOImpl implements CategorieDAO {

	@PersistenceContext
	private EntityManager em;

	public CategorieDAOImpl() {
	}
	
	public CategorieDAOImpl(EntityManager em) {
		this.em = em;
	}
	
	@Override
	public List<Categorie> getForPrixArticleInferieurA(BigDecimal prix) {
		return em.createQuery("select distinct c from Categorie c join c.articles a where a.prix < :prix", Categorie.class)
				 .setParameter("prix", prix)
				 .getResultList();
	}

//	@Override
//	public List<Categorie> getCategorie(Long id, String nom) {
//		 	return em.createQuery("select distinct c from Categorie c ", Categorie.class)
//				 .setParameter("categorie", categorie)
//				 .getResultList();
//	}
	@Override
	public List<Categorie> getAllCategorie() {
		return this.em.createQuery("select new Categorie (c.id, c.nom) from Categorie c ", Categorie.class).getResultList();
	}

	@Override
	public List<Article> getArticleByCategorie(long id) {
		return this.em.createQuery("select new Article (a.id, a.designation, a.image, a.prix, a.stock) from Article a where a.categorie.id = :id", Article.class)
			      .setParameter("id", id)
			      .getResultList();
	}

}
