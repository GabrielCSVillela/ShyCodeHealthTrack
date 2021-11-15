package br.com.shycode.healthtrack.dao;

import java.util.List;
import br.com.shycode.healthtrack.bean.Meal;

public interface MealDAO {

	public void insert(Meal meal);

	public List<Meal> select();

	public void update(Meal meal);

	public void delete(int id);

	public Meal selectById(int idSearch);
}
