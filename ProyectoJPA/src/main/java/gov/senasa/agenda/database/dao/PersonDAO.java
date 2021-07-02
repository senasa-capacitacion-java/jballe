package gov.senasa.agenda.database.dao;

import java.util.List;

import gov.senasa.agenda.modelo.Person;

public interface PersonDAO {
	public Person findById(Long id);
	public List<Person> getAll();
	public void deleteById(Long id);
	Person create(Person person);
	Person update(Person person);
}
