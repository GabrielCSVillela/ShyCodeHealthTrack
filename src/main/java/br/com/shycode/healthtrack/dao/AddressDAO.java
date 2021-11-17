package br.com.shycode.healthtrack.dao;

import java.util.List;
import br.com.shycode.healthtrack.bean.Address;
import br.com.shycode.healthtrack.exception.DBException;

public interface AddressDAO {

	void insert(Address address) throws DBException;

	List<Address> select();

	void update(Address address) throws DBException;

	void delete(int id) throws DBException;

	Address selectById(int idSearch);
}
