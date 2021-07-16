package gov.senasa.agenda.ws.rest.entities.dao;

import java.util.List;

import gov.senasa.agenda.ws.rest.entities.Person;

public interface PersonDAO {
	public Person findById(Long id);
	public List<Person> getAll();
	public void deleteById(Long id);
	Person create(Person person);
	Person update(Person person);
	public boolean isPersonExist(Person person);
}
