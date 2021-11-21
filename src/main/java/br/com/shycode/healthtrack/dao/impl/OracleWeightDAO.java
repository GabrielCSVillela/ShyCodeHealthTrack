package br.com.shycode.healthtrack.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import br.com.shycode.healthtrack.bean.Weight;
import br.com.shycode.healthtrack.dao.WeightDAO;
import br.com.shycode.healthtrack.singleton.ConnectionManager;

public class OracleWeightDAO implements WeightDAO {	    
      private Connection connection;
    
      public void insert(Weight weight) {
        PreparedStatement stmt = null;
    
        try {
          connection = ConnectionManager.getInstance().getConnection();
          String sql = "INSERT INTO TAB_WEIGHT(ID_WEIGHT, VALUE, DATE_MEASUREMENT, DATE_RECORD, DATE_UPDATE) VALUES (SQ_WEIGHT.NEXTVAL, ?, ?, ?, ?)";
          stmt = connection.prepareStatement(sql);
          stmt.setFloat(1, weight.getValue());
          java.sql.Date dateMeasurement = new java.sql.Date(weight.getDateMeasurement().getTimeInMillis());
			stmt.setDate(2, dateMeasurement);
          java.sql.Date dateRecord = new java.sql.Date(weight.getDateRecord().getTimeInMillis());
          stmt.setDate(3, dateRecord);
          java.sql.Date dateUpdate = new java.sql.Date(weight.getDateUpdate().getTimeInMillis());
          stmt.setDate(4, dateUpdate);
    
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
        
	    public List<Weight> select() {
	      List<Weight> list = new ArrayList<Weight>();
	      PreparedStatement stmt = null;
	      ResultSet rs = null;
	      try {
	    	connection = ConnectionManager.getInstance().getConnection();
	        stmt = connection.prepareStatement("SELECT * FROM TAB_WEIGHT");
	        rs = stmt.executeQuery();
	    
	        while (rs.next()) {
	          int idWeight = rs.getInt("ID_WEIGHT");
	          float value = rs.getFloat("VALUE");
	          
	          java.sql.Date timeMeasurement = rs.getDate("DATE_MEASUREMENT");
	          Calendar dateMeasurement = Calendar.getInstance();
	          dateMeasurement.setTimeInMillis(timeMeasurement.getTime());
	          
	          java.sql.Date timeRecord = rs.getDate("DATE_RECORD");
	          Calendar dateRecord = Calendar.getInstance();
	          dateRecord.setTimeInMillis(timeRecord.getTime());
	          
	          java.sql.Date timeUpdate = rs.getDate("DATE_UPDATE");
	          Calendar dateUpdate = Calendar.getInstance();
	          dateUpdate.setTimeInMillis(timeUpdate.getTime());
	          
	          Weight weight = new Weight(idWeight, value, dateMeasurement,dateRecord, dateUpdate);
	          
	          list.add(weight);
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
	    
        public void update(Weight weight){
          PreparedStatement stmt = null;
        
          try {
        	connection = ConnectionManager.getInstance().getConnection();
            String sql = "UPDATE TAB_WEIGHT SET VALUE = ?, DATE_MEASUREMENT = ?, DATE_UPDATE = ? WHERE ID_WEIGHT = ?";
            stmt = connection.prepareStatement(sql);
            stmt.setFloat(1, weight.getValue());
            java.sql.Date dateMeasurement = new java.sql.Date(weight.getDateMeasurement().getTimeInMillis());
            stmt.setDate(2, dateMeasurement);
            java.sql.Date dateUpdate = new java.sql.Date(weight.getDateUpdate().getTimeInMillis());
            stmt.setDate(3, dateUpdate);
            
            stmt.setInt(4, weight.getId());
        
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
        	connection = ConnectionManager.getInstance().getConnection();
            String sql = "DELETE FROM TAB_WEIGHT WHERE ID_WEIGHT = ?";
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
        
        public Weight selectById(int idSearch){
          Weight weight = null;
          PreparedStatement stmt = null;
          ResultSet rs = null;
          try {
        	connection = ConnectionManager.getInstance().getConnection();
            stmt = connection.prepareStatement("SELECT * FROM TAB_WEIGHT WHERE ID_WEIGHT = ?");
            stmt.setInt(1, idSearch);
            rs = stmt.executeQuery();
        
            if (rs.next()){
              int idWeight = rs.getInt("ID_WEIGHT");
              Float value = rs.getFloat("VALUE");
              
              java.sql.Date timeMeasurement = rs.getDate("DATE_MEASUREMENT");
	          Calendar dateMeasurement = Calendar.getInstance();
	          dateMeasurement.setTimeInMillis(timeMeasurement.getTime());
              
              java.sql.Date timeRecord = rs.getDate("DATE_RECORD");
              Calendar dateRecord = Calendar.getInstance();
              dateRecord.setTimeInMillis(timeRecord.getTime());
              
              java.sql.Date timeUpdate = rs.getDate("DATE_UPDATE");
              Calendar dateUpdate = Calendar.getInstance();
              dateRecord.setTimeInMillis(timeUpdate.getTime());
              weight = new Weight(idWeight, value, dateMeasurement, dateRecord, dateUpdate);
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
          return weight;
        }
        
}
