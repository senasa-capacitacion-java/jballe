package gov.senasa.daogen.model.dao;

import gov.senasa.daogen.gen.GenericDAO;
import gov.senasa.daogen.model.Person;

public interface PersonDAO extends GenericDAO<Person> {
	public Person recuperarPersona(String usuario);
}
