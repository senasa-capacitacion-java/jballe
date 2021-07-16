package gov.senasa.agenda.ws.rest.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "address")
public class Address {
	private Integer id;       
	private String street;
	private String number;
	private Long personId;
	private Person persona;
	
	public Address() {
		
	}
	
	public Address(String street, String number, Person pers) {
		this.setStreet(street);
		this.setNumber(number);
		this.setPersona(pers);
	}
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	
	@Column(name = "street")
	public String getStreet() {
		return street;
	}
	public void setStreet(String street) {
		this.street = street;
	}
	
	@Column(name = "number")
	public String getNumber() {
		return number;
	}
	public void setNumber(String number) {
		this.number = number;
	}
	
//	@Column(name = "person_id")
//	public Long getPersonId() {
//		return personId;
//	}
//	public void setPersonId(Long personId) {
//		this.personId = personId;
//	}

	@ManyToOne
	@JoinColumn(name = "person_id", nullable = false, updatable= false)
	public Person getPersona() {
		return persona;
	}
	public void setPersona(Person persona) {
		this.persona = persona;
	}

	@Override
	public String toString() {
		return "Address [id=" + id + ", street=" + street + ", number=" + number + ", personId=" + personId
				+ ", persona=" + persona + "]";
	}
	
}
