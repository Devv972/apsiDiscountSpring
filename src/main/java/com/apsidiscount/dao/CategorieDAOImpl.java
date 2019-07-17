package com.apsidiscount.dao;

import java.math.BigDecimal;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;

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

}
