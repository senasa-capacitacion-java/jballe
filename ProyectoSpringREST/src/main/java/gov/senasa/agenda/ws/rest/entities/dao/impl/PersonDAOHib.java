package gov.senasa.agenda.ws.rest.entities.dao.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

import org.springframework.stereotype.Component;

import gov.senasa.agenda.ws.rest.entities.Person;
import gov.senasa.agenda.ws.rest.entities.dao.PersonDAO;

@Component
public class PersonDAOHib implements PersonDAO {
	private EntityManagerFactory entityManagerFactory;
	
	public PersonDAOHib() {
		EntityManagerFactory emf = Persistence
			.createEntityManagerFactory("agenda");
		setEntityManagerFactory(emf);
	}
	
	@Override
	public Person findById(Long id) {
		// TODO Auto-generated method stub
		EntityManager em = getEntityManagerFactory().createEntityManager();
		try {
			return em.find(Person.class, id);
		}catch (Exception e) {
			System.out.println("Falló al buscar persona por id.");
			throw e;
		} finally {
			em.close();
		}
	}

	@Override
	public List<Person> getAll() {
		// TODO Auto-generated method stub
		EntityManager em = getEntityManagerFactory().createEntityManager();
		try {
			Query q = em.createQuery("select p from Person p LEFT JOIN FETCH p.direcciones");
			return q.getResultList();
		}catch (Exception e) {
			System.out.println("Falló al buscar todas las personas.");
			throw e;
		} finally {
			em.close();
		}
			
	}

	@Override
	public void deleteById(Long id) {
		EntityManager em = getEntityManagerFactory().createEntityManager();
		try {
			Person person = em.find(Person.class, id);
			if(person!=null) {
				em.getTransaction().begin();
				em.remove(person);
				em.getTransaction().commit();
			}
		}catch (Exception e) {
			System.out.println("Falló al borrar persona por id.");
			throw e;
		} finally {
			em.close();
		}
	}

	@Override
	public Person create(Person person) {
		EntityManager em = getEntityManagerFactory().createEntityManager();
		try {
			em.getTransaction().begin();
			em.persist(person);
			em.getTransaction().commit();
			return person;
		}catch (Exception e) {
			System.out.println("Falló al crear persona.");
			throw e;
		} finally {
			em.close();
		}
	}

	@Override
	public Person update(Person person) {
		EntityManager em = getEntityManagerFactory().createEntityManager();
		try {
			em.getTransaction().begin();
			em.merge(person);
			em.getTransaction().commit();
			return person;
		}catch (Exception e) {
			System.out.println("Falló al actualizar la persona.");
			throw e;
		} finally {
			em.close();
		}
	}

	public EntityManagerFactory getEntityManagerFactory() {
		return entityManagerFactory;
	}

	public void setEntityManagerFactory(EntityManagerFactory entityManagerFactory) {
		this.entityManagerFactory = entityManagerFactory;
	}

	@Override
	public boolean isPersonExist(Person person) {
		if(person.getId()!=null) {
			Person otraPersona = this.findById(person.getId());
			if(otraPersona!=null) {
				return true;
			}
		}
		return false;
	}

}
