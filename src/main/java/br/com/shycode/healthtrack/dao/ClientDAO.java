package br.com.shycode.healthtrack.dao;

import java.util.List;

import br.com.shycode.healthtrack.bean.Client;
import br.com.shycode.healthtrack.exception.DBException;

public interface ClientDAO {

	void insert(Client client) throws DBException;

	List<Client> select();

	void update(Client client) throws DBException;

	void delete(int id) throws DBException;

	Client selectById(int idSearch);
	
	Client selectByEmail(String emailSearch);
	
	boolean validateClient(Client client);

}


	
	
