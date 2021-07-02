package gov.senasa.agenda;

import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import gov.senasa.agenda.database.dao.AddressDAO;
import gov.senasa.agenda.database.dao.PersonDAO;
import gov.senasa.agenda.database.dao.hib.AddressDAOHib;
import gov.senasa.agenda.database.dao.hib.PersonDAOHib;
import gov.senasa.agenda.modelo.Address;
import gov.senasa.agenda.modelo.Person;

public class Main {

	public static void main(String[] args) throws ParseException {
		// TODO Auto-generated method stub
		System.out.println("Hi Polaco!");
		PersonDAO personaDAO = new PersonDAOHib();
		
		java.util.Date d = new SimpleDateFormat("yyyy-MM-dd")
				.parse("1973-12-12");

		/** Pedro **/
		Person p = new Person("Picapiedras","Pedro",1111111L,
				"pedropica@yopmail.com","+54789689578",new Date(d.getTime()));
		
		Address aa = new Address("Rocamora","325 1/2", p);
		p.getDirecciones().add(aa);
		personaDAO.create(p);
		
		/** Wilma **/
		d = new SimpleDateFormat("yyyy-MM-dd").parse("1977-09-12");
		p = new Person("Picapiedras","Vilma",2222222L,
				"vilmapica@yopmail.com","+54783334445",new Date(d.getTime()));
		aa = new Address("Rocamora","325 1/2", p);
 		p.getDirecciones().add(aa);
		aa = new Address("Caliza","428 1/2", p);
 		p.getDirecciones().add(aa);
		personaDAO.create(p);
		
		/** Pablo **/
		d = new SimpleDateFormat("yyyy-MM-dd").parse("1975-01-12");
		p = new Person("Marmol","Pablo",3333333L,
				"pmarmol@yopmail.com","+5423432345",new Date(d.getTime()));
		aa = new Address("Rocamora","326 1/2", p);
 		p.getDirecciones().add(aa);
		personaDAO.create(p);

		/** Betty **/
		d = new SimpleDateFormat("yyyy-MM-dd").parse("1980-01-12");
		p = new Person("Marmol","Betty",4444444L,
				"labetty@yopmail.com","+545655654",new Date(d.getTime()));
		aa = new Address("Rocamora","326 1/2", p);
 		p.getDirecciones().add(aa);
		personaDAO.create(p);

		/** Thor **/
		d = new SimpleDateFormat("yyyy-MM-dd").parse("1990-05-14");
		p = new Person("Thor","De Asgard",555555L,
				"thor@yopmail.com","+54435435435",new Date(d.getTime()));
		aa = new Address("5th Street","445", p);
 		p.getDirecciones().add(aa);
		aa = new Address("4th Street","335", p);
 		p.getDirecciones().add(aa);
		personaDAO.create(p);
		Long idThor = p.getId();

		System.out.println("TODOS ####################################");
		for(Person pe : personaDAO.getAll()) {
			System.out.println("-------------------------------");
			System.out.println(pe);
			System.out.println("Direcciones:");
			for(Address a : pe.getDirecciones()) {
				System.out.println(a);
			}
		}

		Person pp = personaDAO.findById(idThor);
		pp.setCellphone("0303456");
		personaDAO.update(pp);
		
		AddressDAO addressDao = new AddressDAOHib();
		Address aaa = addressDao.findByPersonId(idThor).get(0);
		aaa.setStreet("OTRA CALLE");
		addressDao.update(aaa);
		
		System.out.println("THOR UPDATED ####################################");
		Person pe = personaDAO.findById(idThor);
		System.out.println("-------------------------------");
		System.out.println(pe);
		System.out.println("Direcciones:");
		
		Integer borrarDir = 0;
		for(Address a : addressDao.findByPersonId(idThor)) {
			System.out.println(a);
			borrarDir = a.getId(); 
		}
		
		addressDao.deleteById(borrarDir);
		
		System.out.println("THOR DIRECCION DELETED ##########################");
		pe = personaDAO.findById(idThor);
		System.out.println("-------------------------------");
		System.out.println(pe);
		System.out.println("Direcciones:");
		for(Address a : addressDao.findByPersonId(idThor)) {
			System.out.println(a);
		}

		System.out.println("THOR DELETED ####################################");
		personaDAO.deleteById(idThor);
		for(Person per : personaDAO.getAll()) {
			System.out.println("-------------------------------");
			System.out.println(per);
			System.out.println("Direcciones:");
			for(Address a : per.getDirecciones()) {
				System.out.println(a);
			}
		}
	}

}
