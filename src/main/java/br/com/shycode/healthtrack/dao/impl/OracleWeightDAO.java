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
import br.com.shycode.healthtrack.singleton.ConnectionDB;

public class OracleWeightDAO implements WeightDAO {	    
      private Connection connection;
    
      public void insert(Weight weight) {
        PreparedStatement stmt = null;
    
        try {
          connection = ConnectionDB.obtainConnection();
          String sql = "INSERT INTO TAB_WEIGHT(ID_WEIGHT, VALUE, DATERECORD) VALUES (SQ_WEIGHT.NEXTVAL, ?, ?)";
          stmt = connection.prepareStatement(sql);
          stmt.setFloat(1, weight.getValue());
          java.sql.Date date = new java.sql.Date(weight.getDate().getTimeInMillis());
          stmt.setDate(2, date);
    
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
	    	connection = ConnectionDB.obtainConnection();
	        stmt = connection.prepareStatement("SELECT * FROM TAB_WEIGHT");
	        rs = stmt.executeQuery();
	    
	        while (rs.next()) {
	          int idWeight = rs.getInt("ID_WEIGHT");
	          float value = rs.getFloat("VALUE");
	          java.sql.Date date = rs.getDate("DATE_RECORD");
	          Calendar dateRecord = Calendar.getInstance();
	          dateRecord.setTimeInMillis(date.getTime());
	          
	          Weight weight = new Weight(idWeight, value, dateRecord);
	          
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
        	connection = ConnectionDB.obtainConnection();
            String sql = "UPDATE TAB_WEIGHT SET VALUE = ?, DATE_RECORD = ? WHERE ID_WEIGHT = ?";
            stmt = connection.prepareStatement(sql);
            stmt.setFloat(1, weight.getValue());
            java.sql.Date dateRecord = new java.sql.Date(weight.getDate().getTimeInMillis());
            stmt.setDate(2, dateRecord);
            stmt.setInt(5, weight.getId());
        
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
        	connection = ConnectionDB.obtainConnection();
            stmt = connection.prepareStatement("SELECT * FROM TAB_WEIGHT WHERE ID_WEIGHT = ?");
            stmt.setInt(1, idSearch);
            rs = stmt.executeQuery();
        
            if (rs.next()){
              int idWeight = rs.getInt("ID_WEIGHT");
              Float value = rs.getFloat("VALUE");
              java.sql.Date date = rs.getDate("DATE_RECORD");
              Calendar dateRecord = Calendar.getInstance();
              dateRecord.setTimeInMillis(date.getTime());
              weight = new Weight(idWeight, value, dateRecord);
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
