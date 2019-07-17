package com.apsidiscount.service;

public interface ClientService {

	void ajouterArticlesDansPanier(long idClient, long ... idArticles) throws ClientInconnuException, ArticleInconnuException, StockInsuffisantException;

}