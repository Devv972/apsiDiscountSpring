package com.apsidiscount.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.apsidiscount.dao.ArticleDAO;
import com.apsidiscount.entity.Article;

@Service
public class ArticleServiceImpl implements ArticleService {
	
	private ArticleDAO articleDAO;
	
	public ArticleServiceImpl(@Autowired ArticleDAO articleDAO) {
		this.articleDAO = articleDAO;
	}

	@Override
	public Article getById(long id) throws ArticleInconnuException {
		Article article = articleDAO.getById(id);
		if (article == null) {
			throw new ArticleInconnuException(id);
		}
 		return article;
	}

	@Override
	@Transactional(rollbackOn = ArticleInconnuException.class)
	public Article modifier(long id, String designation, String description) throws ArticleInconnuException {
		Article article = getById(id);
		article.setDescription(description);
		article.setDesignation(designation);
		return article;
	}

	@Override
	public List<Article> getAll()  {
		return articleDAO.getAll();
	}

	@Override
	@Transactional
	public Article create(Article a)  {
		Article article = articleDAO.create(a);
		return article;
		
	}
	

}
