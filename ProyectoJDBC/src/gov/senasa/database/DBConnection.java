package gov.senasa.database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;

public class DBConnection {
	Connection con;
	
	public void getConnection() {
		try {
			String usuario = "curso";
			String clave = "1234";
			String url = "jdbc:postgresql://localhost/cursojava";
			//Class.forName("com.postgresql.jdbc.Driver").getDeclaredConstructor().newInstance();
			con = DriverManager.getConnection("jdbc:postgresql://localhost/cursojava","curso","1234");
			System.out.println("PUM: Conectado a la base de datos.");
		} catch (Exception e) {
			System.out.println("PUM: Error al conectar a la base de datos.");
		}
	}
	
	public ResultSet execute(String query) {
		try {
			return con.createStatement().executeQuery(query);
		}catch (Exception e) {
			System.out.println("PUM: Error en query.");
		}
		return null;
	}
}
