package gov.senasa.daogen.gen;

import java.io.Serializable;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;

import gov.senasa.daogen.EMF;

public class GenericDAOHibernateJPA<T> implements GenericDAO<T> {

	private Class<T> persistenceClass;
	
	public GenericDAOHibernateJPA(Class<T> clase) {
		persistenceClass = clase;
	}
	
	@Override
	public T persistir(T entity) {
		EntityManager em = EMF.getEMF().createEntityManager();
		EntityTransaction tx = null;
		try {
			tx = em.getTransaction();
			tx.begin();
			em.persist(entity);
			tx.commit();
		}
		catch (RuntimeException e) {
			if ( tx != null && tx.isActive() ) tx.rollback();
			throw e; // escribir en un log o mostrar un mensaje
		}
		finally {
			em.close();
		}
		return entity;		
	}

	@Override
	public T actualizar(T entity) {
		EntityManager em = EMF.getEMF().createEntityManager();
		EntityTransaction tx = null;
		try {
			tx = em.getTransaction();
			tx.begin();
			entity = em.merge(entity);
			tx.commit();
		}
		catch (RuntimeException e) {
			if ( tx != null && tx.isActive() ) tx.rollback();
			throw e; // escribir en un log o mostrar un mensaje
		}
		finally {
			em.close();
		}
		return entity;		
	}

	@Override
	public void borrar(T entity) {
		EntityManager em = EMF.getEMF().createEntityManager();
		EntityTransaction tx = null;
		try {
			tx = em.getTransaction();
			tx.begin();
			em.remove(entity);
			tx.commit();
		} catch (RuntimeException e) {
			if ( tx != null && tx.isActive() ) tx.rollback();
			throw e; // escribir en un log o mostrar un mensaje
		}
		finally {
			em.close();
		}
	}

	@Override
	public T borrar(Serializable id) {
		T entity = recuperar(id);
		if(entity!=null) {
			EntityManager em = EMF.getEMF().createEntityManager();
			EntityTransaction tx = null;
			try {
				tx = em.getTransaction();
				tx.begin();
				em.remove(entity);
				tx.commit();
				return entity;
			} catch (RuntimeException e) {
				if ( tx != null && tx.isActive() ) tx.rollback();
				throw e; // escribir en un log o mostrar un mensaje
			}
			finally {
				em.close();
				return entity;
			}
		}
		return entity;
	}

	@Override
	public T recuperar(Serializable id) {
		return EMF.getEMF().createEntityManager()
				.find(getPersistentClass(), id);
	}

	@Override
	public List<T> recuperarTodos(String columnOrder) {
		Query consulta = EMF.getEMF().createEntityManager()
				.createQuery("select e from " 
						+ getPersistentClass().getSimpleName() 
						+ " e order by e." + columnOrder );
		@SuppressWarnings("unchecked")
		List<T> resultado = (List<T>) consulta.getResultList();
		return resultado;
	}
	
	private Class<T> getPersistentClass(){
		return this.persistenceClass;
	}
	
}