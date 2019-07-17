package com.apsidiscount.service;

public class ArticleInconnuException extends ApsiDiscountException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public ArticleInconnuException(long idArticle) {
		super("L'article avec l'ID " + idArticle + " n'existe pas !");
	}

}
