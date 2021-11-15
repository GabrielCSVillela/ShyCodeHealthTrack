package br.com.shycode.healthtrack.dao;

import java.util.List;
import br.com.shycode.healthtrack.bean.Nourishment;

public interface NourishmentDAO {

	public void insert(Nourishment nourishment);

	public List<Nourishment> select();

	public void update(Nourishment nourishment);

	public void delete(int id);

	public Nourishment selectById(int idSearch);
}
