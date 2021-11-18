package br.com.shycode.healthtrack.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import br.com.shycode.healthtrack.bean.Nourishment;
import br.com.shycode.healthtrack.dao.NourishmentDAO;
import br.com.shycode.healthtrack.singleton.ConnectionManager;

public class OracleNourishmentDAO implements NourishmentDAO {
	private Connection connection;
    
    public void insert(Nourishment nourishment) {
      PreparedStatement stmt = null;
  
      try {
        connection = ConnectionManager.getInstance().getConnection();
        String sql = "INSERT INTO TAB_NOURISHMENT(ID_NOURISHMENT, DESCRIPTION, CALORIE_FOOD, DATERECORD) VALUES (SQ_NOURISHMENT.NEXTVAL, ?, ?, ?)";
        stmt = connection.prepareStatement(sql);
        stmt.setString(1, nourishment.getDescription());
        stmt.setInt(2, nourishment.getCalorie());
        java.sql.Date data = new java.sql.Date(nourishment.getDate().getTimeInMillis());
        stmt.setDate(3, data);
  
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
      
	    public List<Nourishment> select() {
	      List<Nourishment> list = new ArrayList<Nourishment>();
	      PreparedStatement stmt = null;
	      ResultSet rs = null;
	      try {
	    	connection = ConnectionManager.getInstance().getConnection();
	        stmt = connection.prepareStatement("SELECT * FROM TAB_NOURISHMENT");
	        rs = stmt.executeQuery();
	    
	        while (rs.next()) {
	          int idNourishment = rs.getInt("ID_NOURISHMENT");
	          String description = rs.getString("DESCRIPTION");
	          int calorieFood = rs.getInt("CALORIE_FOOD");
	          java.sql.Date data = rs.getDate("DATE_RECORD");
	          Calendar dateRecord = Calendar.getInstance();
	          dateRecord.setTimeInMillis(data.getTime());
	          
	          Nourishment nourishment = new Nourishment(idNourishment, description, calorieFood, dateRecord);
	          
	          list.add(nourishment);
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
	    
      public void update(Nourishment nourishment){
        PreparedStatement stmt = null;
      
        try {
      	connection = ConnectionManager.getInstance().getConnection();
          String sql = "UPDATE TAB_NOURISHMENT SET DESCRIPTION = ?, CALORIE_FOOD = ?, DATE_RECORD = ? WHERE ID_NOURISHMENT = ?";
          stmt = connection.prepareStatement(sql);
          stmt.setString(1, nourishment.getDescription());
          stmt.setInt(2, nourishment.getCalorie());
          java.sql.Date date = new java.sql.Date(nourishment.getDate().getTimeInMillis());
          stmt.setDate(3, date);
      
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
          String sql = "DELETE FROM TAB_NOURISHMENT WHERE ID_NOURISHMENT = ?";
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
      
      public Nourishment selectById(int idSearch){
    	  Nourishment nourishment = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        try {
          connection = ConnectionManager.getInstance().getConnection();
          stmt = connection.prepareStatement("SELECT * FROM TAB_NOURISHMENT WHERE ID_NOURISHMENT = ?");
          stmt.setInt(1, idSearch);
          rs = stmt.executeQuery();
      
          if (rs.next()){
            int idNourishment = rs.getInt("ID_NOURISHMENT");
            String description = rs.getString("DESCRIPTION");
            int calorieFood = rs.getInt("CALORIE_FOOD");
            java.sql.Date date = rs.getDate("DATE_RECORD");
            Calendar dateRecord = Calendar.getInstance();
            dateRecord.setTimeInMillis(date.getTime());
            nourishment = new Nourishment(idNourishment, description, calorieFood, dateRecord);
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
        return nourishment;
      }
	
	
}
