package br.com.shycode.healthtrack.dao;

import java.util.List;
import br.com.shycode.healthtrack.bean.Weight;

public interface WeightDAO {

	public void insert(Weight weight);

	public List<Weight> select();

	public void update(Weight weight);

	public void delete(int id);

	public Weight selectById(int idSearch);
}
