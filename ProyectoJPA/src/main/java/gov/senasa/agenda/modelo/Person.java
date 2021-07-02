package gov.senasa.agenda.modelo;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Person {
	Long id;
	Date birthDate;
	String cellphone;
	Long dni;
	String email;
	String lastName;
	String name;
	List<Address> direcciones = new ArrayList<Address>();
	
	public Person(String last, String name, Long dni, String email, 
			String cellphone, Date birth) {
		this.setLastName(last);
		this.setName(name);
		this.setDni(dni);
		this.setEmail(email);
		this.setCellphone(cellphone);
		this.setBirthDate(birth);
	}

	public Person() {
		// TODO Auto-generated constructor stub
	}
	
	@OneToMany(mappedBy = "persona", cascade = CascadeType.ALL)
	public List<Address> getDirecciones() {
		return direcciones;
	}
	public void setDirecciones(List<Address> direcciones) {
		this.direcciones = direcciones;
	}
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	
	@Column(name = "birth_date")
	public Date getBirthDate() {
		return birthDate;
	}
	public void setBirthDate(Date birthDate) {
		this.birthDate = birthDate;
	}
	
	@Column(name = "cellphone")
	public String getCellphone() {
		return cellphone;
	}
	public void setCellphone(String cellphone) {
		this.cellphone = cellphone;
	}
	
	@Column(name = "dni")
	public Long getDni() {
		return dni;
	}
	public void setDni(Long dni) {
		this.dni = dni;
	}
	
	@Column(name = "email")
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	
	@Column(name = "last_name")
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	
	@Column(name = "name")
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return "Person [id=" + id + ", birthDate=" + birthDate + ", cellphone=" + cellphone + ", dni=" + dni
				+ ", email=" + email + ", lastName=" + lastName + ", name=" + name + "]";
	}

}
