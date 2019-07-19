package com.apsidiscount.entity;

import static org.junit.Assert.*;

import java.math.BigDecimal;
import java.util.List;

import org.junit.Test;

import com.apsidiscount.dao.CategorieDAO;
import com.apsidiscount.dao.CategorieDAOImpl;

public class CategorieDAOTest extends AbstractBaseTest {
	
	@Test
	public void canGetCategorieBasedOnArticlePrix() throws Exception {
		CategorieDAO categorieDAO = new CategorieDAOImpl(this.em);
		BigDecimal prix = BigDecimal.valueOf(20);
		
		List<Categorie> categories = categorieDAO.getForPrixArticleInferieurA(prix);
		
		assertFalse(categories.isEmpty());
	}
	@Test
	public void canGetAllCategorie() throws Exception {
		CategorieDAO categorieDAO = new CategorieDAOImpl(this.em);

		List<Categorie> categories = categorieDAO.getAllCategorie();
		
		assertFalse(categories.isEmpty());
	}

}
