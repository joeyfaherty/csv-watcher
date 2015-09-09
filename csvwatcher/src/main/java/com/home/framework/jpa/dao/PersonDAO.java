package com.home.framework.jpa.dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import com.home.framework.jpa.model.Person;


public class PersonDAO {

     private static final String PERSISTENCE_UNIT_NAME = "Person";
     private static EntityManagerFactory factory;

     public void savePerson(Person person) {
    	 
          factory = Persistence.createEntityManagerFactory(PERSISTENCE_UNIT_NAME);
          EntityManager em = factory.createEntityManager();
          
          em.getTransaction().begin();
          em.persist(person);
          em.getTransaction().commit();

          em.close();
     }
		

}
