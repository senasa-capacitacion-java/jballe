package gov.senasa.database.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import gov.senasa.database.DBConnection;
import gov.senasa.modelo.Person;

public class PersonDAOImpl implements PersonDAO {
	private DBConnection dbCon;
	
	public PersonDAOImpl() {
		dbCon = new DBConnection(); 
		dbCon.getConnection();
	}
	
	@Override
	public Person findById(Long id) {
		ResultSet rs = dbCon.execute("SELECT * FROM person WHERE ID="+id);
		try {
			if(rs.next()) {
				Person p = new Person();
				p.setId(id);
				p.setDni(rs.getLong("dni"));
				p.setBirthDate(rs.getDate("birth_date"));
				p.setCellphone(rs.getString("cellphone"));
				p.setEmail(rs.getString("email"));
				p.setLastName(rs.getString("last_name"));
				p.setName(rs.getString("name"));
				return p;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public List<Person> getAll() {
		ResultSet rs = dbCon.execute("SELECT * FROM person");
		List<Person> listPersons = new ArrayList<Person>();
		try {
			while(rs.next()) {
				Person p = new Person();
				p.setId(rs.getLong("id"));
				p.setDni(rs.getLong("dni"));
				p.setBirthDate(rs.getDate("birth_date"));
				p.setCellphone(rs.getString("cellphone"));
				p.setEmail(rs.getString("email"));
				p.setLastName(rs.getString("last_name"));
				p.setName(rs.getString("name"));
				listPersons.add(p);
			}
		}catch (Exception e) {
			// TODO: handle exception
		}
		return listPersons;
	}

}
