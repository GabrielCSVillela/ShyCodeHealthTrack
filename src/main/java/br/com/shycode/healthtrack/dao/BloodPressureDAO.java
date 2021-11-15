package br.com.shycode.healthtrack.dao;

import java.util.List;
import br.com.shycode.healthtrack.bean.BloodPressure;

public interface BloodPressureDAO {

	public void insert(BloodPressure bloodPressure);

	public List<BloodPressure> select();

	public void update(BloodPressure bloodPressure);

	public void delete(int id);

	public BloodPressure selectById(int idSearch);
}
