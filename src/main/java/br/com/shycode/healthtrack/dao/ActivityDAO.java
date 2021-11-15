package br.com.shycode.healthtrack.dao;

import java.util.List;

import br.com.shycode.healthtrack.bean.Activity;

public interface ActivityDAO {

	public void insert(Activity activity);

	public List<Activity> select();

	public void update(Activity activity);

	public void delete(int id);

	public Activity selectById(int idSearch);

}
