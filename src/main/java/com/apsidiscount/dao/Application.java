package com.apsidiscount.dao;

import org.springframework.context.support.GenericXmlApplicationContext;

import com.apsidiscount.service.ApsiDiscountException;
import com.apsidiscount.service.ClientService;

public class Application {

	public static void main(String[] args) {
		try (GenericXmlApplicationContext appCtx = new GenericXmlApplicationContext("classpath:application-context.xml")) {

			ClientService clientService = appCtx.getBean(ClientService.class);
			
			clientService.ajouterArticlesDansPanier(128, 1);
		} catch (ApsiDiscountException e) {
			e.printStackTrace();
		}
	}
	
}
