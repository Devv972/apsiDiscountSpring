package com.apsidiscount.service;

import java.util.List;

import com.apsidiscount.entity.Article;
import com.apsidiscount.entity.Categorie;

public interface CategorieService {
	
	List<Categorie> getAllCategorie();
	List<Article> getArticleByCategorie(long id);
}
