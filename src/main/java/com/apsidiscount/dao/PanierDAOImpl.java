package com.apsidiscount.dao;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;

import com.apsidiscount.entity.Panier;

@Repository
public class PanierDAOImpl implements PanierDAO {
	
	@PersistenceContext
	private EntityManager em;
	
	public PanierDAOImpl() {
	}
	
	public PanierDAOImpl(EntityManager em) {
		this.em = em;
	}

	@Override
	public void create(Panier panier) {
		this.em.persist(panier);
	}

}
