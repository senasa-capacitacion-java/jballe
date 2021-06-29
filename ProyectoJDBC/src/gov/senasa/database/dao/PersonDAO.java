package gov.senasa.database.dao;

import java.util.List;

import gov.senasa.modelo.Person;

public interface PersonDAO {
	public Person findById(Long id);
	public List<Person> getAll();
}
