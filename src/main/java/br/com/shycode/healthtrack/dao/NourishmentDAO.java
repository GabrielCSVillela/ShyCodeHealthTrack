package br.com.shycode.healthtrack.dao;

import java.util.List;
import br.com.shycode.healthtrack.bean.Nourishment;
import br.com.shycode.healthtrack.exception.DBException;

public interface NourishmentDAO {

	void insert(Nourishment nourishment) throws DBException;

	List<Nourishment> select();

	void update(Nourishment nourishment) throws DBException;

	void delete(int id) throws DBException;

	Nourishment selectById(int idSearch);
}
