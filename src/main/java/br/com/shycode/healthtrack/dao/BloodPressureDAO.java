package br.com.shycode.healthtrack.dao;

import java.util.List;
import br.com.shycode.healthtrack.bean.BloodPressure;
import br.com.shycode.healthtrack.exception.DBException;

public interface BloodPressureDAO {

	void insert(BloodPressure bloodPressure) throws DBException;
	void update(BloodPressure bloodPressure) throws DBException;
	void delete(int id) throws DBException;
	List<BloodPressure> select();
	BloodPressure selectById(int idSearch);
}
