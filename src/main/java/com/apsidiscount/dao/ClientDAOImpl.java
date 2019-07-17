package com.apsidiscount.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;

import com.apsidiscount.entity.Client;

@Repository
public class ClientDAOImpl implements ClientDAO {

	@PersistenceContext
	private EntityManager em;
	
	public ClientDAOImpl() {
	}

	public ClientDAOImpl(EntityManager entityManager) {
		this.em = entityManager;
	}
	
	@Override
	public void create(Client c) {
		this.em.persist(c);
	}
	
	@Override
	public Client getById(long id) {
		return this.em.find(Client.class, id);
	}

	@Override
	public Client getByIdWithPanier(long id) {
		return this.em.createQuery("select c from Client c "
				                 + "left join fetch c.panier p "
				                 + "left join fetch p.articles a "
				                 + "left join fetch a.categorie "
				                 + "where c.id = :id", Client.class)
				      .setParameter("id", id)
				      .getSingleResult();
	}

	@Override
	public List<Client> getAll() {
		return this.em.createQuery("select c from Client c order by c.nom", Client.class).getResultList();
	}

	@Override
	public List<Client> getAllByNom(String nom) {
		return this.em.createQuery("select c from Client c where c.nom = :nom", Client.class)
				      .setParameter("nom", nom)
				      .getResultList();
	}

	@Override
	public List<Client> getAllByAnneDeNaissance(int annee) {
		return this.em.createQuery("select c from Client c where year(c.dateNaissance) = :annee order by c.nom", Client.class)
				      .setParameter("annee", annee)
				      .getResultList();
	}
	
	@Override
	public void delete(long id) {
		this.em.createQuery("delete from Client c where c.id = :id")
		       .setParameter("id", id)
		       .executeUpdate();
	}
	
	@Override
	public long getNbClientByCodePostal(String codePostal) {
		return (long) this.em.createQuery("select count(c) from Client c where c.codePostal = :codePostal")
				             .setParameter("codePostal", codePostal)
				             .getSingleResult();
	}
}
