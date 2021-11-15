package br.com.shycode.healthtrack.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import br.com.shycode.healthtrack.bean.BloodPressure;
import br.com.shycode.healthtrack.dao.BloodPressureDAO;
import br.com.shycode.healthtrack.singleton.ConnectionDB;

public class OracleBloodPressureDAO implements BloodPressureDAO {
	
private Connection connection;
    
    public void insert(BloodPressure bloodPressure) {
      PreparedStatement stmt = null;
  
      try {
    	connection = ConnectionDB.obtainConnection();
        String sql = "INSERT INTO TAB_BLOOD_PRESSURE(ID_BLOOD_PRESSURE, MAX_PRESSURE, MIN_PRESSURE, TIME_MEASUREMENT, DATE_RECORD) VALUES (SQ_ACTIVITY.NEXTVAL, ?, ?, ?, ?)";
        stmt = connection.prepareStatement(sql);
        stmt.setFloat(1, bloodPressure.getMaxPressure());
        stmt.setFloat(2, bloodPressure.getMinPressure());
        java.sql.Date timeMeasurement = new java.sql.Date(bloodPressure.getTimeMeasurement().getTimeInMillis());
        stmt.setDate(3, timeMeasurement);
        java.sql.Date dateRecord = new java.sql.Date(bloodPressure.getDateRecord().getTimeInMillis());
        stmt.setDate(4, dateRecord);
  
        stmt.executeUpdate();
      } catch (SQLException e) {
        e.printStackTrace();
      } finally {
        try {
          stmt.close();
          connection.close();
        } catch (SQLException e) {
          e.printStackTrace();
        }
      }
    }	
  
    public List<BloodPressure> select() {
	  List<BloodPressure> list = new ArrayList<BloodPressure>();
	  PreparedStatement stmt = null;
	  ResultSet rs = null;
	  try {
		connection = ConnectionDB.obtainConnection();
	    stmt = connection.prepareStatement("SELECT * FROM TAB_BLOOD_PRESSURE");
	    rs = stmt.executeQuery();
	
	    while (rs.next()) {
	      int idActivity = rs.getInt("ID_BLOOD_PRESSURE");
	      float maxPressure = rs.getFloat("MAX_PRESSURE");
	      float minPressure = rs.getFloat("MIN_PRESSURE");
          java.sql.Date dateMeasurement = rs.getDate("TIME_MEASUREMENT");
          Calendar timeMeasurement = Calendar.getInstance();
          timeMeasurement.setTimeInMillis(dateMeasurement.getTime());

          java.sql.Date dateRecord = rs.getDate("DATE_RECORD");
          Calendar timeRecord = Calendar.getInstance();
          timeRecord.setTimeInMillis(dateRecord.getTime());
          
//          java.sql.Date dateUpdate = rs.getDate("DATE_UPDATE");
//          Calendar timeUpdate = Calendar.getInstance();
//          timeUpdate.setTimeInMillis(dateUpdate.getTime());
	      
          BloodPressure bloodPressure = new BloodPressure(idActivity, maxPressure, minPressure, timeMeasurement, timeRecord, null);
	      
	      list.add(bloodPressure);
	    }
	  } catch (SQLException e) {
	    e.printStackTrace();
	    
	  }finally {
	    try {
	      stmt.close();
	      rs.close();
	      connection.close();
	    } catch (SQLException e) {
	      e.printStackTrace();
	    }
	  }
	  return list;
	}
    
   public void update(BloodPressure bloodPressure){
    PreparedStatement stmt = null;
  
    try {
  	connection = ConnectionDB.obtainConnection();
      String sql = "UPDATE TAB_BLOOD_PRESSURE SET MAX_PRESSURE = ?, MIN_PRESSURE = ?, TIME_MEASUREMENT = ?, DATE_UPDATE = ? WHERE ID_BLOOD_PRESSURE = ?";
      stmt = connection.prepareStatement(sql);
      stmt.setFloat(1, bloodPressure.getMaxPressure());
      stmt.setFloat(2, bloodPressure.getMinPressure());
      java.sql.Date timeMeasurement = new java.sql.Date(bloodPressure.getTimeMeasurement().getTimeInMillis());
      stmt.setDate(3, timeMeasurement);
      java.sql.Date dateUpdate = new java.sql.Date(bloodPressure.getDateUpdate().getTimeInMillis());
      stmt.setDate(4, dateUpdate);
      stmt.setInt(5, bloodPressure.getId());
  
      stmt.executeUpdate();
    } catch (SQLException e) {
      e.printStackTrace();
    } finally {
      try {
        stmt.close();
        connection.close();
      } catch (SQLException e) {
        e.printStackTrace();
      }
    }
  }
  
  public void delete(int id){
    PreparedStatement stmt = null;
  
    try {
  	connection = ConnectionDB.obtainConnection();
      String sql = "DELETE FROM TAB_BLOOD_PRESSURE WHERE ID_BLOOD_PRESSURE = ?";
      stmt = connection.prepareStatement(sql);
      stmt.setInt(1, id);
      stmt.executeUpdate();
    } catch (SQLException e) {
      e.printStackTrace();
    } finally {
      try {
        stmt.close();
        connection.close();
      } catch (SQLException e) {
        e.printStackTrace();
      }
    }
  }
  
  public BloodPressure selectById(int idSearch){
	BloodPressure bloodPressure = null;
    PreparedStatement stmt = null;
    ResultSet rs = null;
    try {
  	connection = ConnectionDB.obtainConnection();
      stmt = connection.prepareStatement("SELECT * FROM TAB_BLOOD_PRESSURE WHERE ID_BLOOD_PRESSURE = ?");
      stmt.setInt(1, idSearch);
      rs = stmt.executeQuery();
  
      if (rs.next()){
        int idBloodPressure = rs.getInt("ID_BLOOD_PRESSURE");
        float maxPressure = rs.getFloat("MAX_PRESSURE");
        float minPressure = rs.getFloat("MIN_PRESSURE");
        java.sql.Date dateMeasurement = rs.getDate("TIME_MEASUREMENT");
        Calendar timeMeasurement = Calendar.getInstance();
        timeMeasurement.setTimeInMillis(dateMeasurement.getTime());
        
        java.sql.Date dateRecord = rs.getDate("DATE_RECORD");
        Calendar timeRecord = Calendar.getInstance();
        timeRecord.setTimeInMillis(dateRecord.getTime());
        
//        java.sql.Date dateUpdate = rs.getDate("DATE_UPDATE");
//        Calendar timeUpdate = Calendar.getInstance();
//        timeUpdate.setTimeInMillis(dateUpdate.getTime());
        
        bloodPressure = new BloodPressure(idBloodPressure, maxPressure, minPressure, timeMeasurement, timeRecord, null);
      }
	  
	 } catch (SQLException e) {
	      e.printStackTrace();
	    }finally {
	      try {
	        stmt.close();
	        rs.close();
	        connection.close();
	      } catch (SQLException e) {
	        e.printStackTrace();
	      }
	    }
	    return bloodPressure;
	  }
  
	
	
}
