package com.fdmgroup.dbconnection;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class DatabaseConnection {
	
	public EntityManager connect() {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("testblog");
		EntityManager em = emf.createEntityManager();
		return em;
	}
	
}
