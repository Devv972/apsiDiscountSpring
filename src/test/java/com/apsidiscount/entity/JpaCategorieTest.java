package com.apsidiscount.entity;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;

import java.util.List;

import org.junit.Test;

public class JpaCategorieTest extends AbstractBaseTest {
	
	@Test
	public void canFindCategorie() throws Exception {
		Categorie categorie = em.find(Categorie.class, 1L);

		assertNotNull(categorie);
	}

	@Test
	public void canPersistAndRemoveCategorie() throws Exception {
		Categorie categorie = new Categorie();
		categorie.setNom("dummy");
		
		em.getTransaction().begin();
		em.persist(categorie);
		em.getTransaction().commit();
		
		assertNotNull(categorie.getId());
		
		em.getTransaction().begin();
		em.remove(categorie);
		em.getTransaction().commit();
		
		assertNull(em.find(Categorie.class, categorie.getId()));
	}
	
	@Test
	public void canGetAllCategorie() throws Exception {
		List<Categorie> categories = em.createNativeQuery("select * from CATEGORIE", Categorie.class)
				                       .getResultList();
	
		assertFalse(categories.isEmpty());
	}

	@Test
	public void canGetAllCategorieWithJPQL() throws Exception {
		List<Categorie> categories = em.createQuery("select c from Categorie c", Categorie.class)
				                       .getResultList();
	
		assertFalse(categories.isEmpty());
	}
}
