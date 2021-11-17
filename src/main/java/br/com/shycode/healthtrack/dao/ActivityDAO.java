package br.com.shycode.healthtrack.dao;

import java.util.List;

import br.com.shycode.healthtrack.bean.Activity;
import br.com.shycode.healthtrack.exception.DBException;

public interface ActivityDAO {

	void insert(Activity activity) throws DBException;
	List<Activity> select();
	void update(Activity activity) throws DBException;
	void delete(int id) throws DBException;
	Activity selectById(int idSearch);

}
