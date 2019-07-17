package com.apsidiscount.service;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.apsidiscount.dao.ArticleDAO;
import com.apsidiscount.dao.ClientDAO;
import com.apsidiscount.dao.PanierDAO;
import com.apsidiscount.entity.Article;
import com.apsidiscount.entity.Client;
import com.apsidiscount.entity.Panier;

@Service
public class ClientServiceImpl implements ClientService {
	
	private ClientDAO clientDAO;
	private ArticleDAO articleDAO;
	private PanierDAO panierDAO;

	public ClientServiceImpl(@Autowired ClientDAO clientDAO, @Autowired ArticleDAO articleDAO, @Autowired PanierDAO panierDAO) {
		this.clientDAO = clientDAO;
		this.articleDAO = articleDAO;
		this.panierDAO = panierDAO;
	}

	@Override
	@Transactional(rollbackOn = ApsiDiscountException.class)
	public void ajouterArticlesDansPanier(long idClient, long... idArticles) throws ClientInconnuException, ArticleInconnuException, StockInsuffisantException {

		Client client = clientDAO.getById(idClient);
		if (client == null) {
			throw new ClientInconnuException(idClient);
		}

		if (!client.hasPanier()) {
			Panier panier = new Panier();
			panierDAO.create(panier);
			client.setPanier(panier);
		}

		for (long idArticle : idArticles) {
			Article article = articleDAO.getById(idArticle);
			if (article == null) {
				throw new ArticleInconnuException(idArticle);
			}
			if(! client.getPanier().contient(article)) {
				client.getPanier().addArticle(article);
			}
		}
	}

}
