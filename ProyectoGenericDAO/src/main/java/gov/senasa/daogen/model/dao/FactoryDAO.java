package gov.senasa.daogen.model.dao;

public class FactoryDAO {
	public static PersonDAO getPersonDAO() {
		return new PersonDAOHibernateJPA();
	}
}
