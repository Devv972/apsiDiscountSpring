package com.apsidiscount.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.apsidiscount.dao.CategorieDAO;
import com.apsidiscount.entity.Categorie;
@Service
public class CategorieServiceImpl implements CategorieService{

private CategorieDAO categorieDAO;
	
	public CategorieServiceImpl(@Autowired CategorieDAO categorieDAO) {
		this.categorieDAO = categorieDAO;
	}
	@Override
	public List<Categorie> getAllCategorie() {
		return categorieDAO.getAllCategorie();
		
	}

}
