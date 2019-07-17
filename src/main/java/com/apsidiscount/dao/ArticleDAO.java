package com.apsidiscount.dao;

import java.util.List;

import com.apsidiscount.entity.Article;
import com.apsidiscount.entity.Categorie;

public interface ArticleDAO {

	Article getById(long id);

	List<Article> getByCategorie(String nomCategorie);

	List<Article> getByCategorie(Categorie categorie);
	
	Article create(Article a);

	List<Article> getAll();
}
