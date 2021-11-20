package br.com.shycode.healthtrack.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import br.com.shycode.healthtrack.bean.Meal;
import br.com.shycode.healthtrack.dao.MealDAO;
import br.com.shycode.healthtrack.singleton.ConnectionManager;

public class OracleMealDAO implements MealDAO {
	private Connection connection;
    
    public void insert(Meal meal) {
      PreparedStatement stmt = null;
  
      try {
        connection = ConnectionManager.getInstance().getConnection();
        String sql = "INSERT INTO TAB_MEAL(ID_MEAL, NAME_MEAL, TOTAL_CALORIE, DATE_RECORD, DATE_UPDATE) VALUES (SQ_MEAL.NEXTVAL, ?, ?, ?, ?)";
        stmt = connection.prepareStatement(sql);
        stmt.setString(1, meal.getNameMeal());
        stmt.setInt(2, meal.getTotalCalorie());
        java.sql.Date dateRecord = new java.sql.Date(meal.getDateRecord().getTimeInMillis());
        stmt.setDate(3, dateRecord);
        java.sql.Date dateUpdate = new java.sql.Date(meal.getDateUpdate().getTimeInMillis());
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
      
	    public List<Meal> select() {
	      List<Meal> list = new ArrayList<Meal>();
	      PreparedStatement stmt = null;
	      ResultSet rs = null;
	      try {
	    	connection = ConnectionManager.getInstance().getConnection();
	        stmt = connection.prepareStatement("SELECT * FROM TAB_MEAL");
	        rs = stmt.executeQuery();
	    
	        while (rs.next()) {
	          int idMeal = rs.getInt("ID_MEAL");
	          String nameMeal = rs.getString("NAME_MEAL");
	          int totalCalorie = rs.getInt("TOTAL_CALORIE");
	          java.sql.Date timeRecord = rs.getDate("DATE_RECORD");
	          Calendar dateRecord = Calendar.getInstance();
	          dateRecord.setTimeInMillis(timeRecord.getTime());
	          
	          java.sql.Date timeUpdate = rs.getDate("DATE_RECORD");
	          Calendar dateUpdate = Calendar.getInstance();
	          dateUpdate.setTimeInMillis(timeUpdate.getTime());
	          
	          Meal meal = new Meal(idMeal, nameMeal, totalCalorie, dateRecord, dateUpdate);
	          
	          list.add(meal);
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
	    
      public void update(Meal meal){
        PreparedStatement stmt = null;
      
        try {
      	connection = ConnectionManager.getInstance().getConnection();
          String sql = "UPDATE TAB_MEAL SET NAME_MEAL = ?, TOTAL_CALORIE = ?, DATE_UPDATE = ? WHERE ID_MEAL = ?";
          stmt = connection.prepareStatement(sql);
          stmt.setString(1, meal.getNameMeal());
          stmt.setInt(2, meal.getTotalCalorie());
          java.sql.Date dateUpdate = new java.sql.Date(meal.getDateUpdate().getTimeInMillis());
          stmt.setDate(3, dateUpdate);
      
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
          String sql = "DELETE FROM TAB_MEAL WHERE ID_MEAL = ?";
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
      
      public Meal selectById(int idSearch){
        Meal meal = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        try {
      	connection = ConnectionManager.getInstance().getConnection();
          stmt = connection.prepareStatement("SELECT * FROM TAB_MEAL WHERE ID_MEAL = ?");
          stmt.setInt(1, idSearch);
          rs = stmt.executeQuery();
      
          if (rs.next()){
            int idMeal = rs.getInt("ID_MEAL");
            String nameMeal = rs.getString("NAME_MEAL");
            int totalCalorie = rs.getInt("TOTAL_CALORIE");
            
	          java.sql.Date timeRecord = rs.getDate("DATE_RECORD");
	          Calendar dateRecord = Calendar.getInstance();
	          dateRecord.setTimeInMillis(timeRecord.getTime());
	          
	          java.sql.Date timeUpdate = rs.getDate("DATE_RECORD");
	          Calendar dateUpdate = Calendar.getInstance();
	          dateUpdate.setTimeInMillis(timeUpdate.getTime());
	          
            meal = new Meal(idMeal, nameMeal, totalCalorie, dateRecord, dateUpdate);
          }
          
        } catch (SQLException e) {
          e.printStackTrace();
        } finally {
          try {
            stmt.close();
            rs.close();
            connection.close();
          } catch (SQLException e) {
            e.printStackTrace();
          }
        }
        return meal;
      }

      
}
