package com.apsidiscount.service;

import com.apsidiscount.entity.Article;

public interface ArticleService {
	
	Article getById(long id) throws ArticleInconnuException;

	Article modifier(long id, String designation, String description) throws ArticleInconnuException;

	Article create(Article a) throws ArticleInconnuException;

	Article getAll(Article a) throws ArticleInconnuException;
	
	
}
