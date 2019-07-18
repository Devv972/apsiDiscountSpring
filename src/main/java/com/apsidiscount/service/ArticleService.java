package com.apsidiscount.service;

import java.util.List;

import com.apsidiscount.entity.Article;

public interface ArticleService {
	
	Article getById(long id) throws ArticleInconnuException;

	Article modifier(long id, String designation, String description) throws ArticleInconnuException;

	Article create(Article a) ;

	List<Article> getAll() ;
	
	
}
