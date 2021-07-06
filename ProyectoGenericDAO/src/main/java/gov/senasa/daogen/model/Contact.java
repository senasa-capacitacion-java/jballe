package gov.senasa.daogen.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity

public class Contact {
	private Long id;
	private ContactType type;
	private String info;
	private Person persona;
	
	public Contact(ContactType ct,String info, Person persona) {
		this.setType(ct);
		this.setInfo(info);
		this.setPersona(persona);
	}
	
	public Contact() {
		// TODO Auto-generated constructor stub
	}
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	
	@Column(name = "tipo")
	public ContactType getType() {
		return type;
	}
	public void setType(ContactType type) {
		this.type = type;
	}
	
	@Column(name = "info")
	public String getInfo() {
		return info;
	}
	public void setInfo(String info) {
		this.info = info;
	}
	
	@Override
	public String toString() {
		return "Contact [id=" + id + ", type=" + type + ", info=" + info + "]";
	}

	@ManyToOne
	@JoinColumn(name = "person_id", nullable = false, updatable= false)
	public Person getPersona() {
		return persona;
	}
	public void setPersona(Person persona) {
		this.persona = persona;
	}

}
