package gov.senasa.daogen.model.dao;

import javax.persistence.Query;

import gov.senasa.daogen.EMF;
import gov.senasa.daogen.gen.GenericDAOHibernateJPA;
import gov.senasa.daogen.model.Person;

public class PersonDAOHibernateJPA extends GenericDAOHibernateJPA<Person> implements PersonDAO {

	public PersonDAOHibernateJPA() {
		super(Person.class);
	}

	@Override
	public Person recuperarPersona(String usuario) {
		Query consulta = EMF.getEMF().createEntityManager()
				 .createQuery("select p from Person p where p.nombre =?");
		consulta.setParameter(1, usuario);
		Person resultado = (Person) consulta.getSingleResult();
		return resultado;
	}

}
