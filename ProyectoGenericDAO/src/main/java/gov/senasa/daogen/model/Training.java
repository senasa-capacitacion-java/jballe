package gov.senasa.daogen.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;

@Entity
public class Training {
	private long id;
	private String nombre;
	private int horas;
	private String modalidad;
	private List<Person> persons;

	public Training(String nombre, int horas, String modalidad) {
		this.setNombre(nombre);
		this.setHoras(horas);
		this.setModalidad(modalidad);
	}
	
	public Training() {
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
	
	@Column(name = "nombre")
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
	@Column
	public int getHoras() {
		return horas;
	}
	public void setHoras(int horas) {
		this.horas = horas;
	}

	@Column
	public String getModalidad() {
		return modalidad;
	}
	public void setModalidad(String modalidad) {
		this.modalidad = modalidad;
	}
	
    @ManyToMany(mappedBy = "trainings", cascade = CascadeType.ALL)
    public List<Person> getPersons() {
		return persons;
	}
	public void setPersons(List<Person> persons) {
		this.persons = persons;
	}
	@Override
	public String toString() {
		return "Training [nombre=" + nombre + ", horas=" + horas + ", modalidad=" + modalidad + ", persons=" + persons
				+ "]";
	}
	
}
