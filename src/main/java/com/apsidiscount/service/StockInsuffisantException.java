package com.apsidiscount.service;

import com.apsidiscount.entity.Article;

public class StockInsuffisantException extends ApsiDiscountException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public StockInsuffisantException(Article article) {
		super("L'article " + article.getDesignation() + " n'est plus en stock !");
	}

}
