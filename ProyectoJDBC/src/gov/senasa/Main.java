package gov.senasa;

import java.util.List;

import gov.senasa.database.dao.AddressDAO;
import gov.senasa.database.dao.AddressDAOImpl;
import gov.senasa.database.dao.PersonDAO;
import gov.senasa.database.dao.PersonDAOImpl;
import gov.senasa.modelo.Address;
import gov.senasa.modelo.Person;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try {
			PersonDAO personaDAO = new PersonDAOImpl();
			AddressDAO addressDAO = new AddressDAOImpl();
			for(Person p : personaDAO.getAll()) {
				System.out.println("-------------------------------");
				List<Address> addresDePersona = addressDAO.findByPersonId(p.getId());
				System.out.println(p);
				System.out.println("Direcciones:");
				for(Address a : addresDePersona) {
					System.out.println(a);
				}
			}
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
