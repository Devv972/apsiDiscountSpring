package com.apsidiscount.service;

import static org.mockito.Mockito.*;
import static org.junit.Assert.*;

import org.junit.Test;

import com.apsidiscount.dao.ArticleDAO;
import com.apsidiscount.dao.ClientDAO;
import com.apsidiscount.dao.PanierDAO;
import com.apsidiscount.entity.Article;
import com.apsidiscount.entity.Client;
import com.apsidiscount.entity.Panier;

public class ClientServiceTest {
	
	@Test
	public void canAjouterUnProduitDansLePanier() throws Exception {
		ClientDAO clientDAO = mock(ClientDAO.class);
		ArticleDAO articleDAO = mock(ArticleDAO.class);
		PanierDAO panierDAO = mock(PanierDAO.class);
		ClientService clientService = new ClientServiceImpl(clientDAO, articleDAO, panierDAO);
		
		Client client = new Client();
		client.setPanier(new Panier());
		Article article = new Article();
		article.setStock(1);

		when(clientDAO.getById(1)).thenReturn(client);
		when(articleDAO.getById(2)).thenReturn(article);
		
		clientService.ajouterArticlesDansPanier(1, 2);

		verify(clientDAO).getById(1);
		verify(articleDAO).getById(2);
		assertEquals(article, client.getPanier().getArticles().get(0));
	}

	@Test
	public void ajouterUnProduitExistantDansLePanier() throws Exception {
		ClientDAO clientDAO = mock(ClientDAO.class);
		ArticleDAO articleDAO = mock(ArticleDAO.class);
		PanierDAO panierDAO = mock(PanierDAO.class);
		ClientService clientService = new ClientServiceImpl(clientDAO, articleDAO, panierDAO);
		
		Client client = new Client();
		client.setPanier(new Panier());
		Article article = new Article();
		client.getPanier().getArticles().add(article);

		when(clientDAO.getById(1)).thenReturn(client);
		when(articleDAO.getById(2)).thenReturn(article);
		
		clientService.ajouterArticlesDansPanier(1, 2);

		verify(clientDAO).getById(1);
		verify(articleDAO).getById(2);
		assertEquals(1, client.getPanier().getArticles().size());
	}
}
