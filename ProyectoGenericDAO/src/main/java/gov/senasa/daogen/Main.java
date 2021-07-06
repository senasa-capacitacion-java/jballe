package gov.senasa.daogen;

import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;

import gov.senasa.daogen.model.Contact;
import gov.senasa.daogen.model.ContactType;
import gov.senasa.daogen.model.Document;
import gov.senasa.daogen.model.Person;
import gov.senasa.daogen.model.Training;
import gov.senasa.daogen.model.dao.FactoryDAO;
import gov.senasa.daogen.model.dao.PersonDAO;

public class Main {

	public static void main(String[] args) throws ParseException {
		// TODO Auto-generated method stub
		System.out.println("Hi! Polaco");
		PersonDAO personDAO = FactoryDAO.getPersonDAO();
		
		java.util.Date d = new SimpleDateFormat("yyyy-MM-dd")
				.parse("1973-12-12");
		
		Person nito = new Person("NITO","Elena",111111L,"nitoelena@yopmail.com",
				"+54114567890",new Date(d.getTime()));
		Contact contact = new Contact(ContactType.EMAIL,"nitoelena@gmail.com",nito);
		nito.getContactMethods().add(contact);
		
		LocalDate dExpire = LocalDate.of(2022,12,12);
		Document document = new Document("2222222","3333333",'F',dExpire,nito);
		nito.setDocument(document);
		
		Training tt = new Training("10 Ventajas de la virtualidad",120,"Presencial");
		nito.getTrainings().add(tt);
		tt = new Training("El camino Buda",420,"Virtual");
		nito.getTrainings().add(tt);
		
		personDAO.persistir(nito);
		
		for(Person pp : personDAO.recuperarTodos("id")){
			System.out.println(pp);
			System.out.println(pp.getDocument());
			for(Contact cont : pp.getContactMethods()) {
				System.out.println(cont);
			}
			for(Training tr : pp.getTrainings()) {
				System.out.println(tr);
			}
		}
		
	}

}
