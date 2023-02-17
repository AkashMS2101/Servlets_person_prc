package com.ty.person_info.dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

import com.ty.person_info.dto.PersonSignIn;

public class PersonSignInDAO {
	public EntityManager get_EntityManager() {
		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("akash");
		return entityManagerFactory.createEntityManager();
	}

	public void savePerson(PersonSignIn person) {
		EntityManager entityManager = get_EntityManager();
		EntityTransaction entityTransaction = entityManager.getTransaction();

		entityTransaction.begin();
		entityManager.persist(person);
		entityTransaction.commit();
	}

	public void updatePerson(String mail,String firstName) {
		EntityManager entityManager = get_EntityManager();
		EntityTransaction entityTransaction = entityManager.getTransaction();

		PersonSignIn personSignIn2 = entityManager.find(PersonSignIn.class, mail);
		personSignIn2.setFirst_name(firstName);
		if (personSignIn2 != null) {
			entityTransaction.begin();
			entityManager.merge(personSignIn2);
			entityTransaction.commit();
			System.out.println(personSignIn2.getFirst_name());
		} else {
			System.out.println("person doesnt exist");
		}
	}

	public String loginPerson(String mail) {
		EntityManager entityManager = get_EntityManager();

		String jpql = "select p from PersonSignIn p where p.email=?1";
		Query query = entityManager.createQuery(jpql);
		query.setParameter(1, mail);
		PersonSignIn personSignIn = (PersonSignIn)query.getSingleResult();
		return personSignIn.getPassword();
	}
	
//	public String getPassword(String email) {
//		EntityManager entityManager = getEntityManager();
//		String jpql = "SELECT p FROM Person p WHERE p.email=?1";
//		Query query = entityManager.createQuery(jpql);
//		query.setParameter(1, email);
//		Person person = (Person) query.getSingleResult();
//		return person.getPassword();
//	}
}
