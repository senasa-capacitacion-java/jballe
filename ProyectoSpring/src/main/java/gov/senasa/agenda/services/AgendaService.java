package gov.senasa.agenda.services;

import java.util.List;

import gov.senasa.agenda.modelo.Address;
import gov.senasa.agenda.modelo.Person;

public interface AgendaService {
	List<Person> obtenerPersonas();
	List<Address> obtenerDirecciones();
	
}
