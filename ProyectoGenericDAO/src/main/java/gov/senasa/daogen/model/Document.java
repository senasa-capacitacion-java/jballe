package gov.senasa.daogen.model;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

@Entity
public class Document {
	private Long id;
	private String number;
	private String transactionNumber;
	private Character Sex;
	private LocalDate expiryDate;
	private Person persona;
	
	public Document(String number, String transNro, Character sex, 
			LocalDate expireDate, Person persona) {
		this.setNumber(number);
		this.setTransactionNumber(transNro);
		this.setSex(sex);
		this.setExpiryDate(expireDate);
		this.setPersona(persona);
	}
	
	public Document() {
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
	
	@Column(name = "number")
	public String getNumber() {
		return number;
	}
	public void setNumber(String number) {
		this.number = number;
	}
	
	@Column
	public String getTransactionNumber() {
		return transactionNumber;
	}
	public void setTransactionNumber(String transactionNumber) {
		this.transactionNumber = transactionNumber;
	}

	@Column
	public Character getSex() {
		return Sex;
	}
	public void setSex(Character sex) {
		Sex = sex;
	}

	@Column
	public LocalDate getExpiryDate() {
		return expiryDate;
	}
	public void setExpiryDate(LocalDate expiryDate) {
		this.expiryDate = expiryDate;
	}

    @OneToOne
    @JoinColumn(name = "persona_id", updatable = false, nullable = false)
    public Person getPersona() {
		return persona;
	}
	public void setPersona(Person persona) {
		this.persona = persona;
	}
	
	@Override
	public String toString() {
		return "Document [id=" + id + ", number=" + number + ", transactionNumber=" + transactionNumber + ", Sex=" + Sex
				+ ", expiryDate=" + expiryDate + ", person=" + persona + "]";
	}
	
}
