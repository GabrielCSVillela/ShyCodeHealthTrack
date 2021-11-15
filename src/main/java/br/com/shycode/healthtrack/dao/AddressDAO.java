package br.com.shycode.healthtrack.dao;

import java.util.List;
import br.com.shycode.healthtrack.bean.Address;

public interface AddressDAO {

	public void insert(Address address);

	public List<Address> select();

	public void update(Address address);

	public void delete(int id);

	public Address selectById(int idSearch);
}
