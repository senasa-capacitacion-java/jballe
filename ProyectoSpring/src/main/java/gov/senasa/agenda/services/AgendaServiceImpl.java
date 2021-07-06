package gov.senasa.agenda.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import gov.senasa.agenda.database.dao.AddressDAO;
import gov.senasa.agenda.database.dao.PersonDAO;
import gov.senasa.agenda.modelo.Address;
import gov.senasa.agenda.modelo.Person;

@Component
public class AgendaServiceImpl implements AgendaService {

	private PersonDAO personDAO;
	private AddressDAO addressDAO;
	
	@Autowired
	public AgendaServiceImpl(PersonDAO personDAO, AddressDAO addressDAO) {
		this.personDAO = personDAO;
		this.addressDAO = addressDAO;
	}
	
	@Override
	public List<Person> obtenerPersonas() {
		// TODO Auto-generated method stub
		return personDAO.getAll();
	}

	@Override
	public List<Address> obtenerDirecciones() {
		// TODO Auto-generated method stub
		return addressDAO.getAll();
	}

}
