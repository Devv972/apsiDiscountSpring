package com.apsidiscount.entity;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;

import java.util.List;

import org.junit.Test;

import com.apsidiscount.dao.ArticleDAO;
import com.apsidiscount.dao.ArticleDAOImpl;
import com.apsidiscount.dao.ClientDAO;
import com.apsidiscount.dao.ClientDAOImpl;

public class ArticleDAOTest extends AbstractBaseTest {

	@Test
	public void canGetById() throws Exception {
		ArticleDAO articleDAO = new ArticleDAOImpl(this.em);
		
		Article article = articleDAO.getById(1L);
		
		assertNotNull(article);
	}
	
	@Test
	public void canGetByNomCategorie() throws Exception {
		ArticleDAO articleDAO = new ArticleDAOImpl(this.em);
		
		List<Article> articles = articleDAO.getByCategorie("écran");
		
		assertFalse(articles.isEmpty());
	}

	@Test
	public void canGetByCategorie() throws Exception {
		ArticleDAO articleDAO = new ArticleDAOImpl(this.em);
		Categorie categorie = new Categorie();
		categorie.setId(1L);
		
		List<Article> articles = articleDAO.getByCategorie(categorie);
		
		assertFalse(articles.isEmpty());
	}

	@Test
	public void canAddArticleDansPanier() throws Exception {
		ClientDAO clientDAO = new ClientDAOImpl(this.em);
		Client client = createClient(clientDAO);
		ArticleDAO articleDAO = new ArticleDAOImpl(this.em);
		
		this.em.getTransaction().begin();
		Article article = articleDAO.getById(1L);
		client.getPanier().getArticles().add(article);
		this.em.getTransaction().commit();
		
		this.em.clear();
		client = clientDAO.getById(client.getId());
		
		assertEquals(1, client.getPanier().getArticles().size());
	}

	private Client createClient(ClientDAO clientDAO) {
		Client client = new Client();
		client.setNom("Dummy nom");
		client.setPrenom("Dummy prenom");
		client.setMotDePasse("dummy");
		Panier panier = new Panier();
		client.setPanier(panier);
		
		this.em.getTransaction().begin();
		clientDAO.create(client);
		this.em.getTransaction().commit();
		return client;
	}
	
}



















