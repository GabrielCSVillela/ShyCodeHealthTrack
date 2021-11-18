package br.com.shycode.healthtrack.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import br.com.shycode.healthtrack.bean.Address;
import br.com.shycode.healthtrack.dao.AddressDAO;
import br.com.shycode.healthtrack.singleton.ConnectionManager;

public class OracleAddressDAO implements AddressDAO {
	private Connection connection;
    
    public void insert(Address address) {
      PreparedStatement stmt = null;
  
      try {
        connection = ConnectionManager.getInstance().getConnection();
        String sql = "INSERT INTO TAB_ADDRESS(ID_ADDRESS, ID_CLIENT, HOME_NUMBER, ZIP_CODE, STREET, CITY, NEIGHBORHOOD, STATE, COUNTRY, DATE_RECORD) VALUES (SQ_ADDRESS.NEXTVAL, SQ_CLIENT.NEXTVAL, ?, ?, ?, ?, ?, ?, ?, ?)";
        stmt = connection.prepareStatement(sql);
        stmt.setInt(1, address.getNumber());
        stmt.setInt(2, address.getZipCode());
        stmt.setString(3, address.getStreet());
        stmt.setString(4, address.getCity());
        stmt.setString(5, address.getNeighborhood());
        stmt.setString(6, address.getState());
        stmt.setString(7, address.getCountry());
        java.sql.Date dateRecord = new java.sql.Date(address.getDateRecord().getTimeInMillis());
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
  
    public List<Address> select() {
      List<Address> list = new ArrayList<Address>();
      PreparedStatement stmt = null;
      ResultSet rs = null;
      try {
    	connection = ConnectionManager.getInstance().getConnection();
        stmt = connection.prepareStatement("SELECT * FROM TAB_ADDRESS");
        rs = stmt.executeQuery();
    
        while (rs.next()) {
          int idAddress = rs.getInt("ID_ADDRESS");
          int idClient = rs.getInt("ID_CLIENT");
          int homeNumber = rs.getInt("HOME_NUMBER");
          int zipCode = rs.getInt("ZIP_CODE");
          String street = rs.getString("STREET");
          String city = rs.getString("CITY");
          String neighborhood = rs.getString("NEIGHBORHOOD");
          String state = rs.getString("STATE");
          String country = rs.getString("COUNTRY");
          java.sql.Date date = rs.getDate("DATE_RECORD");
          Calendar dateRecord = Calendar.getInstance();
          dateRecord.setTimeInMillis(date.getTime());
          
          Address address = new Address(idAddress, idClient, homeNumber, zipCode, street, city, neighborhood, state, country, dateRecord);
          
          list.add(address);
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
    
  public void update(Address address){
    PreparedStatement stmt = null;
  
    try {
  	connection = ConnectionManager.getInstance().getConnection();
      String sql = "UPDATE TAB_ADDRESS SET HOME_NUMBER = ?, ZIP_CODE = ?, STREET = ?, CITY = ?, NEIGHBORHOOD = ?, STATE = ?, COUNTRY = ?, DATE_RECORD = ? WHERE ID_ADDRESS = ?";
      stmt = connection.prepareStatement(sql);
      stmt.setInt(1, address.getNumber());
      stmt.setInt(2, address.getZipCode());
      stmt.setString(3, address.getStreet());
      stmt.setString(4, address.getCity());
      stmt.setString(5, address.getNeighborhood());
      stmt.setString(6, address.getState());
      stmt.setString(7, address.getCountry());
      java.sql.Date dateRecord = new java.sql.Date(address.getDateRecord().getTimeInMillis());
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
  
  public void delete(int id){
    PreparedStatement stmt = null;
  
    try {
  	connection = ConnectionManager.getInstance().getConnection();
      String sql = "DELETE FROM TAB_ADDRESS WHERE ID_ADDRESS = ?";
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
  
  public Address selectById(int idSearch){
    Address address = null;
    PreparedStatement stmt = null;
    ResultSet rs = null;
    try {
      connection = ConnectionManager.getInstance().getConnection();
      stmt = connection.prepareStatement("SELECT * FROM TAB_ADDRESS WHERE ID_ADDRESS = ?");
      stmt.setInt(1, idSearch);
      rs = stmt.executeQuery();
  
      if (rs.next()){
        int idAddress = rs.getInt("ID_ADDRESS");
        int idClient = rs.getInt("ID_CLIENT");
        int homeNumber = rs.getInt("HOME_NUMBER");
        int zipCode = rs.getInt("ZIP_CODE");
        String street = rs.getString("STREET");
        String city = rs.getString("CITY");
        String neighborhood = rs.getString("NEIGHBORHOOD");
        String state = rs.getString("STATE");
        String country = rs.getString("COUNTRY");
        java.sql.Date date = rs.getDate("DATE_RECORD");
        Calendar dateRecord = Calendar.getInstance();
        dateRecord.setTimeInMillis(date.getTime());
        address = new Address(idAddress, idClient, homeNumber, zipCode, street, city, neighborhood, state, country, dateRecord);
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
    return address;
  }

  
}
