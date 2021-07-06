package gov.senasa.agenda.database.dao;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import gov.senasa.agenda.database.DBConnection;
import gov.senasa.agenda.modelo.Address;

public class AddressDAOImpl implements AddressDAO {

	private DBConnection dbCon;
	
	public AddressDAOImpl() {
		dbCon = new DBConnection(); 
		dbCon.getConnection();
	}
	
	@Override
	public Address findById(Integer id) {
		ResultSet rs = dbCon.execute("SELECT * FROM address WHERE ID="+id);
		try {
			if(rs.next()) {
				Address a = new Address();
				a.setId(id);
				a.setStreet(rs.getString("street"));
				a.setNumber(rs.getString("number"));
//				a.setPersona(rs.getLong("person_id"));
				return a;
			}
			
		}catch (Exception e) {
			// TODO: handle exception
		}
		return null;
	}

	@Override
	public List<Address> findByPersonId(Long personId) {
		ResultSet rs = dbCon.execute("SELECT * FROM address WHERE person_id="+personId);
		List<Address> listAddress = new ArrayList<Address>();
		try {
			while(rs.next()) {
				Address a = new Address();
				a.setId(rs.getInt("id"));
				a.setStreet(rs.getString("street"));
				a.setNumber(rs.getString("number"));
				//a.setPersonId(rs.getLong("person_id"));
				listAddress.add(a);
			}
		}catch (Exception e) {
			// TODO: handle exception
		}
		return listAddress;
	}

	@Override
	public List<Address> getAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Address create(Address address) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Address update(Address address) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Address findById(Long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void deleteById(Integer id) {
		// TODO Auto-generated method stub
		
	}

}
