package gov.senasa.agenda.database.dao.hib;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

import org.springframework.stereotype.Component;

import gov.senasa.agenda.database.dao.AddressDAO;
import gov.senasa.agenda.modelo.Address;

@Component
public class AddressDAOHib implements AddressDAO {
	private EntityManagerFactory entityManagerFactory;
	
	public AddressDAOHib() {
		EntityManagerFactory emf = Persistence
			.createEntityManagerFactory("agenda");
		setEntityManagerFactory(emf);
	}
	
	@Override
	public Address findById(Long id) {
		// TODO Auto-generated method stub
		EntityManager em = getEntityManagerFactory().createEntityManager();
		try {
			return em.find(Address.class, id);
		}catch (Exception e) {
			System.out.println("Falló al buscar persona por id.");
			throw e;
		} finally {
			em.close();
		}
	}

	@Override
	public List<Address> getAll() {
		// TODO Auto-generated method stub
		EntityManager em = getEntityManagerFactory().createEntityManager();
		try {
			Query q = em.createQuery("select a from Address");
			return q.getResultList();
		}catch (Exception e) {
			System.out.println("Falló al buscar todas las personas.");
			throw e;
		} finally {
			em.close();
		}
			
	}

	@Override
	public void deleteById(Integer id) {
		EntityManager em = getEntityManagerFactory().createEntityManager();
		try {
			Address person = em.find(Address.class, id);
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
	public Address create(Address address) {
		EntityManager em = getEntityManagerFactory().createEntityManager();
		try {
			em.getTransaction().begin();
			em.persist(address);
			em.getTransaction().commit();
			return address;
		}catch (Exception e) {
			System.out.println("Falló al crear persona.");
			throw e;
		} finally {
			em.close();
		}
	}

	@Override
	public Address update(Address address) {
		EntityManager em = getEntityManagerFactory().createEntityManager();
		try {
			em.getTransaction().begin();
			em.merge(address);
			em.getTransaction().commit();
			return address;
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
	public Address findById(Integer id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Address> findByPersonId(Long id) {
		EntityManager em = getEntityManagerFactory().createEntityManager();
		try {
			Query q = em.createQuery("select a from Address a where a.persona.id="+id);
			return q.getResultList();
		}catch (Exception e) {
			System.out.println("Falló al buscar todas las personas.");
			throw e;
		} finally {
			em.close();
		}
	}

}
