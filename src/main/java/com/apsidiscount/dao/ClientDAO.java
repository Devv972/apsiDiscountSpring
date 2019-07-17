package com.apsidiscount.dao;

import java.util.List;

import com.apsidiscount.entity.Client;

public interface ClientDAO {

	void create(Client c);

	Client getById(long id);

	List<Client> getAll();

	List<Client> getAllByNom(String nom);

	List<Client> getAllByAnneDeNaissance(int annee);

	void delete(long id);

	long getNbClientByCodePostal(String codePostal);

	Client getByIdWithPanier(long id);

}