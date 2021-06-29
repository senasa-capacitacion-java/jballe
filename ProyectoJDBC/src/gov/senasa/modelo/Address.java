package gov.senasa.modelo;

public class Address {
	private Integer id;       
	private String street;
	private String number;
	private Long personId;
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getStreet() {
		return street;
	}
	public void setStreet(String street) {
		this.street = street;
	}
	public String getNumber() {
		return number;
	}
	public void setNumber(String number) {
		this.number = number;
	}
	public Long getPersonId() {
		return personId;
	}
	public void setPersonId(Long personId) {
		this.personId = personId;
	}
	
	@Override
	public String toString() {
		return String.format("[%d, %s, %s]", this.getId(), this.getStreet(), this.getNumber());
	}
}
