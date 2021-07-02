package gov.senasa.agenda.database.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import gov.senasa.agenda.database.DBConnection;
import gov.senasa.agenda.modelo.Person;

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

	@Override
	public void deleteById(Long id) {
		try {
			PreparedStatement stm = 
					dbCon.createStm("DELETE FROM person WHERE id= ?");
			stm.setFloat(1, id);
			stm.execute();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public Person create(Person person) {
		String query = "INSERT INTO person (birth_date,cellphone,dni,email,"
				+ "last_name,name) VALUES (?,?,?,?,?,?)";
		try {
			PreparedStatement stm = 
					dbCon.createStm(query);
			stm.setDate(1, person.getBirthDate());
			stm.setString(2, person.getCellphone());
			stm.setLong(3, person.getDni());
			stm.setString(4, person.getEmail());
			stm.setString(5, person.getLastName());
			stm.setString(6, person.getName());
			stm.execute();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public Person update(Person person) {
		// TODO Auto-generated method stub
		return null;
	}

}
