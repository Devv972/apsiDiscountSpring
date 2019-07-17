package com.apsidiscount.service;

public class ClientInconnuException extends ApsiDiscountException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public ClientInconnuException(long idClient) {
		super("Le client avec l'ID " + idClient + " n'existe pas !");
	}

}
