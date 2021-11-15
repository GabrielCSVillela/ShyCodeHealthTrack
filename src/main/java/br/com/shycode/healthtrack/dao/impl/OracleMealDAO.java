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
import br.com.shycode.healthtrack.singleton.ConnectionDB;

public class OracleMealDAO implements MealDAO {
	private Connection connection;
    
    public void insert(Meal meal) {
      PreparedStatement stmt = null;
  
      try {
        connection = ConnectionDB.obtainConnection();
        String sql = "INSERT INTO TAB_MEAL(ID_MEAL, NAME_MEAL, TOTAL_CALORIE, DATE_RECORD) VALUES (SQ_MEAL.NEXTVAL, ?, ?, ?)";
        stmt = connection.prepareStatement(sql);
        stmt.setString(1, meal.getNameMeal());
        stmt.setInt(2, meal.getTotalCalorie());
        java.sql.Date date = new java.sql.Date(meal.getDate().getTimeInMillis());
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
      
	    public List<Meal> select() {
	      List<Meal> list = new ArrayList<Meal>();
	      PreparedStatement stmt = null;
	      ResultSet rs = null;
	      try {
	    	connection = ConnectionDB.obtainConnection();
	        stmt = connection.prepareStatement("SELECT * FROM TAB_MEAL");
	        rs = stmt.executeQuery();
	    
	        while (rs.next()) {
	          int idMeal = rs.getInt("ID_MEAL");
	          String nameMeal = rs.getString("NAME_MEAL");
	          int totalCalorie = rs.getInt("TOTAL_CALORIE");
	          java.sql.Date data = rs.getDate("DATE_RECORD");
	          Calendar dateRecord = Calendar.getInstance();
	          dateRecord.setTimeInMillis(data.getTime());
	          
	          Meal meal = new Meal(idMeal, nameMeal, totalCalorie, dateRecord);
	          
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
      	connection = ConnectionDB.obtainConnection();
          String sql = "UPDATE TAB_MEAL SET NAME_MEAL = ?, TOTAL_CALORIE = ?, DATE_RECORD = ? WHERE ID_MEAL = ?";
          stmt = connection.prepareStatement(sql);
          stmt.setString(1, meal.getNameMeal());
          stmt.setInt(2, meal.getTotalCalorie());
          java.sql.Date dateRecord = new java.sql.Date(meal.getDate().getTimeInMillis());
          stmt.setDate(3, dateRecord);
      
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
      	connection = ConnectionDB.obtainConnection();
          stmt = connection.prepareStatement("SELECT * FROM TAB_MEAL WHERE ID_MEAL = ?");
          stmt.setInt(1, idSearch);
          rs = stmt.executeQuery();
      
          if (rs.next()){
            int idMeal = rs.getInt("ID_MEAL");
            String nameMeal = rs.getString("NAME_MEAL");
            int totalCalorie = rs.getInt("TOTAL_CALORIE");
            java.sql.Date date = rs.getDate("DATE_RECORD");
            Calendar dateRecord = Calendar.getInstance();
            dateRecord.setTimeInMillis(date.getTime());
            meal = new Meal(idMeal, nameMeal, totalCalorie, dateRecord);
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
