package com.apsidiscount.entity;

import static org.junit.Assert.*;

import java.util.Date;
import java.util.List;

import org.junit.Test;

import com.apsidiscount.dao.ClientDAO;
import com.apsidiscount.dao.ClientDAOImpl;

public class ClientDAOTest extends AbstractBaseTest {
	
	@Test
	public void canCreateAndDelete() throws Exception {
		ClientDAO clientDAO = new ClientDAOImpl(em);
		Client client = new Client();
		
		client.setNom("Dummy nom");
		client.setPrenom("Dummy prenom");
		client.setMotDePasse("123465789");
		client.setDateNaissance(new Date());
		client.setCodePostal("33000");
		
		em.getTransaction().begin();
		clientDAO.create(client);
		em.getTransaction().commit();
		
		assertNotNull(client.getId());

		em.getTransaction().begin();
		clientDAO.delete(client.getId());
		em.getTransaction().commit();
		em.detach(client);

		assertNull(clientDAO.getById(client.getId()));
	}
	
	@Test
	public void canGetAll() throws Exception {
		ClientDAO clientDAO = new ClientDAOImpl(em);
		
		List<Client> clients = clientDAO.getAll();
		
		assertFalse(clients.isEmpty());
	}

	@Test
	public void canGetAllByNom() throws Exception {
		ClientDAO clientDAO = new ClientDAOImpl(em);
		
		List<Client> clients = clientDAO.getAllByNom("Dupont");
		
		assertFalse(clients.isEmpty());
	}

	@Test
	public void canGetByAnneeNaissance() throws Exception {
		ClientDAO clientDAO = new ClientDAOImpl(em);
		
		List<Client> clients = clientDAO.getAllByAnneDeNaissance(2019);
		
		assertFalse(clients.isEmpty());
	}

	@Test
	public void canGetNbClientByCodePostal() throws Exception {
		ClientDAO clientDAO = new ClientDAOImpl(em);
		
		long nb = clientDAO.getNbClientByCodePostal("33000");
		
		assertTrue(nb > 0);
	}
	
	@Test
	public void canCreateClientWithPanier() throws Exception {
		ClientDAO clientDAO = new ClientDAOImpl(this.em);
		Client client = new Client();
		client.setNom("Dummy nom");
		client.setPrenom("Dummy prenom");
		client.setMotDePasse("dummy");
		Panier panier = new Panier();
		client.setPanier(panier);
		
		this.em.getTransaction().begin();
		clientDAO.create(client);
		this.em.getTransaction().commit();
		
		assertNotNull(client.getId());
		assertNotNull(client.getPanier().getId());
	}
	
	@Test
	public void canGetClientWithPanier() throws Exception {
		ClientDAO clientDAO = new ClientDAOImpl(this.em);

		Client client = clientDAO.getByIdWithPanier(1);
		
		assertNotNull(client);
	}
}







