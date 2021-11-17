package br.com.shycode.healthtrack.dao;

import java.util.List;
import br.com.shycode.healthtrack.bean.Meal;
import br.com.shycode.healthtrack.exception.DBException;

public interface MealDAO {

	void insert(Meal meal) throws DBException;

	List<Meal> select();

	void update(Meal meal) throws DBException;

	void delete(int id) throws DBException;

	Meal selectById(int idSearch);
}
