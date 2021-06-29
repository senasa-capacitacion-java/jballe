package gov.senasa.database.dao;

import java.util.List;

import gov.senasa.modelo.Address;

public interface AddressDAO {
	public Address findById(Integer id);

	public List<Address> findByPersonId(Long id);
}
