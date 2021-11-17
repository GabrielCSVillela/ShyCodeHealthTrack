package br.com.shycode.healthtrack.dao;

import java.util.List;
import br.com.shycode.healthtrack.bean.Weight;
import br.com.shycode.healthtrack.exception.DBException;

public interface WeightDAO {

	void insert(Weight weight) throws DBException;

	List<Weight> select();

	void update(Weight weight) throws DBException;

	void delete(int id) throws DBException;

	Weight selectById(int idSearch);
}
