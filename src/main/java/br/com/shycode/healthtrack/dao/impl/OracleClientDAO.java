package br.com.shycode.healthtrack.dao.impl;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import br.com.shycode.healthtrack.bean.Client;
import br.com.shycode.healthtrack.singleton.ConnectionDB;

public class OracleClientDAO {
private Connection connection;
    
    public void insert(Client client) {
      PreparedStatement stmt = null;
  
      try {
    	connection = ConnectionDB.obtainConnection();
        String sql = "INSERT INTO TAB_CLIENT(ID_CLIENT, NAME, LAST_NAME, EMAIL, PASSWORD, PHONE, DATE_OF_BIRTH, HEIGHT, DATE_RECORD) VALUES (SQ_CLIENT.NEXTVAL, ?, ?, ?, ?, ?, ?, ?, ?)";
        stmt = connection.prepareStatement(sql);
        stmt.setString(1, client.getName());
        stmt.setString(2, client.getLastName());
        stmt.setString(3, client.getEmail());
        stmt.setString(4, client.getPassword());
        stmt.setString(5, client.getPhone());
        java.sql.Date dateBirth = new java.sql.Date(client.getDateOfBirth().getTime());
        stmt.setDate(6, dateBirth);
        stmt.setInt(7, client.getHeight());
        java.sql.Date dateRecord = new java.sql.Date(client.getDateRecord().getTimeInMillis());
        stmt.setDate(8, dateRecord);
  
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
  
    public List<Client> select() {
	  List<Client> list = new ArrayList<Client>();
	  PreparedStatement stmt = null;
	  ResultSet rs = null;
	  try {
		connection = ConnectionDB.obtainConnection();
	    stmt = connection.prepareStatement("SELECT * FROM TAB_CLIENT");
	    rs = stmt.executeQuery();
	
	    while (rs.next()) {
	      int idClient = rs.getInt("ID_CLIENT");
	      String name = rs.getString("NAME");
	      String lastName = rs.getString("LAST_NAME");
	      String email = rs.getString("EMAIL");
	      String password = rs.getString("PASSWORD");
	      String phone = rs.getString("PHONE");
	      
          Date dateBirth = rs.getDate("DATE_OF_BIRTH");
          Calendar timeBirth = Calendar.getInstance();
          timeBirth.setTimeInMillis(dateBirth.getTime());
          
	      int height = rs.getInt("HEIGHT");
	      
          Calendar dateRecord = rs.getDate("DATE_RECORD");
          Calendar timeRecord = Calendar.getInstance();
          timeRecord.setTimeInMillis(dateRecord.getTime());
         
//          java.sql.Date dateUpdate = rs.getDate("DATE_UPDATE");
//          Calendar timeUpdate = Calendar.getInstance();
//          timeUpdate.setTimeInMillis(dateUpdate.getTime());
	      
          Client client = new Client(idClient, name, lastName, email, password, phone, dateBirth, height, dateRecord);
	      
	      list.add(client);
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
      String sql = "UPDATE TAB_CLIENT SET MAX_PRESSURE = ?, MIN_PRESSURE = ?, TIME_MEASUREMENT = ?, DATE_UPDATE = ? WHERE ID_BLOOD_PRESSURE = ?";
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
      String sql = "DELETE FROM TAB_CLIENT WHERE ID_BLOOD_PRESSURE = ?";
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
      stmt = connection.prepareStatement("SELECT * FROM TAB_CLIENT WHERE ID_BLOOD_PRESSURE = ?");
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
