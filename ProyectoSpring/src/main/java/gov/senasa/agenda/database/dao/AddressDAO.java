package gov.senasa.agenda.database.dao;

import java.util.List;

import gov.senasa.agenda.modelo.Address;

public interface AddressDAO {
	public Address findById(Integer id);

	public List<Address> findByPersonId(Long id);
	public List<Address> getAll();
	public Address create(Address address);
	public Address update(Address address);
	public Address findById(Long id);
	public void deleteById(Integer id);
}
