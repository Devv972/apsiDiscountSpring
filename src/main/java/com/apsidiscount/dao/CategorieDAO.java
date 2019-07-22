package com.apsidiscount.dao;

import java.math.BigDecimal;
import java.util.List;

import com.apsidiscount.entity.Article;
import com.apsidiscount.entity.Categorie;

public interface CategorieDAO {

	List<Categorie> getForPrixArticleInferieurA(BigDecimal prix);
	
	List<Categorie> getAllCategorie();
	List<Article> getArticleByCategorie(long id);

}
