package gov.senasa.daogen;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class EMF {
	private static EntityManagerFactory emf = null;
	static {
		try {
			emf = Persistence.createEntityManagerFactory("agenda");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	public static EntityManagerFactory getEMF() {
		return emf;
	}
}
