package br.com.shycode.healthtrack.factory;

import br.com.shycode.healthtrack.dao.ActivityDAO;
import br.com.shycode.healthtrack.dao.AddressDAO;
import br.com.shycode.healthtrack.dao.BloodPressureDAO;
import br.com.shycode.healthtrack.dao.ClientDAO;
import br.com.shycode.healthtrack.dao.MealDAO;
import br.com.shycode.healthtrack.dao.NourishmentDAO;
import br.com.shycode.healthtrack.dao.WeightDAO;
import br.com.shycode.healthtrack.dao.impl.OracleActivityDAO;
import br.com.shycode.healthtrack.dao.impl.OracleAddressDAO;
import br.com.shycode.healthtrack.dao.impl.OracleBloodPressureDAO;
import br.com.shycode.healthtrack.dao.impl.OracleClientDAO;
import br.com.shycode.healthtrack.dao.impl.OracleMealDAO;
import br.com.shycode.healthtrack.dao.impl.OracleNourishmentDAO;
import br.com.shycode.healthtrack.dao.impl.OracleWeightDAO;

public class DAOFactory {

	public static ActivityDAO getActivityDAO() {
		return new OracleActivityDAO();
	}

	public static AddressDAO getAddressDAO() {
		return new OracleAddressDAO();
	}

	public static BloodPressureDAO getBloodPressureDAO() {
		return new OracleBloodPressureDAO();
	}

	public static ClientDAO getClientDAO() {
		return new OracleClientDAO();
	}

	public static MealDAO getMealDAO() {
		return new OracleMealDAO();
	}

	public static NourishmentDAO getNourishmentDAO() {
		return new OracleNourishmentDAO();
	}

	public static WeightDAO getWeightDAO() {
		return new OracleWeightDAO();
	}

}
