package br.com.shycode.healthtrack.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import br.com.shycode.healthtrack.bean.Client;
import br.com.shycode.healthtrack.dao.ClientDAO;
import br.com.shycode.healthtrack.exception.DBException;
import br.com.shycode.healthtrack.singleton.ConnectionManager;

public class OracleClientDAO implements ClientDAO {
	private Connection connection;

	public void insert(Client client) throws DBException {
		PreparedStatement stmt = null;

		try {
			connection = ConnectionManager.getInstance().getConnection();
			String sql = "INSERT INTO TAB_CLIENT(ID_CLIENT, NAME, LAST_NAME, EMAIL, PASSWORD, PHONE, DATE_OF_BIRTH, HEIGHT, DATE_RECORD) VALUES (SQ_CLIENT.NEXTVAL, ?, ?, ?, ?, ?, ?, ?, ?)";
			stmt = connection.prepareStatement(sql);
			stmt.setString(1, client.getName());
			stmt.setString(2, client.getLastName());
			stmt.setString(3, client.getEmail());
			stmt.setString(4, client.getPassword());
			stmt.setString(5, client.getPhone());
			java.sql.Date dateBirth = new java.sql.Date(client.getDateOfBirth().getTimeInMillis());
			stmt.setDate(6, dateBirth);
			stmt.setInt(7, client.getHeight());

			Calendar timeRecord = Calendar.getInstance();
			timeRecord = client.getDateRecord();
			java.sql.Date dateRecord = new java.sql.Date(timeRecord.getTimeInMillis());

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
			connection = ConnectionManager.getInstance().getConnection();
			stmt = connection.prepareStatement("SELECT * FROM TAB_CLIENT");
			rs = stmt.executeQuery();

			while (rs.next()) {
				int idClient = rs.getInt("ID_CLIENT");
				String name = rs.getString("NAME");
				String lastName = rs.getString("LAST_NAME");
				String email = rs.getString("EMAIL");
				String password = rs.getString("PASSWORD");
				String phone = rs.getString("PHONE");

				java.sql.Date dateBirth = rs.getDate("DATE_OF_BIRTH");
				Calendar timeBirth = Calendar.getInstance();
				timeBirth.setTimeInMillis(dateBirth.getTime());

				int height = rs.getInt("HEIGHT");

				java.sql.Date dateRecord = rs.getDate("DATE_RECORD");
				Calendar timeRecord = Calendar.getInstance();
				timeRecord.setTimeInMillis(dateRecord.getTime());

//          java.sql.Date dateUpdate = rs.getDate("DATE_UPDATE");
//          Calendar timeUpdate = Calendar.getInstance();
//          timeUpdate.setTimeInMillis(dateUpdate.getTime());

				Client client = new Client(idClient, name, lastName, email, password, phone, timeBirth, height,
						timeRecord);

				list.add(client);
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
		return list;
	}

	public void update(Client client) throws DBException {
		PreparedStatement stmt = null;

		try {
			connection = ConnectionManager.getInstance().getConnection();
			String sql = "UPDATE TAB_CLIENT SET NAME = ?, LAST_NAME = ?, EMAIL = ?, PASSWORD = ?, PHONE = ?, DATE_OF_BIRTH = ?, HEIGHT = ?, DATE_RECORD = ? WHERE ID_CLIENT = ?";
			stmt = connection.prepareStatement(sql);
			stmt.setString(1, client.getName());
			stmt.setString(2, client.getLastName());
			stmt.setString(3, client.getEmail());
			stmt.setString(4, client.getPassword());
			stmt.setString(5, client.getPhone());

			java.sql.Date dateBirth = new java.sql.Date(client.getDateOfBirth().getTimeInMillis());
			stmt.setDate(6, dateBirth);

			stmt.setInt(7, client.getHeight());

			java.sql.Date dateRecord = new java.sql.Date(client.getDateRecord().getTimeInMillis());
			stmt.setDate(8, dateRecord);

			// ID Client
			stmt.setInt(9, client.getId());

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

	public void delete(int id) throws DBException {
		PreparedStatement stmt = null;

		try {
			connection = ConnectionManager.getInstance().getConnection();
			String sql = "DELETE FROM TAB_CLIENT WHERE ID_CLIENT = ?";
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

	public Client selectById(int idSearch) {
		Client client = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		try {
			connection = ConnectionManager.getInstance().getConnection();
			stmt = connection.prepareStatement("SELECT * FROM TAB_CLIENT WHERE ID_CLIENT = ?");
			stmt.setInt(1, idSearch);
			rs = stmt.executeQuery();

			if (rs.next()) {
				int idClient = rs.getInt("ID_CLIENT");
				String name = rs.getString("NAME");
				String lastName = rs.getString("LAST_NAME");
				String email = rs.getString("EMAIL");
				String password = rs.getString("PASSWORD");
				String phone = rs.getString("PHONE");

				java.sql.Date dateBirth = rs.getDate("DATE_OF_BIRTH");
				Calendar timeBirth = Calendar.getInstance();
				timeBirth.setTimeInMillis(dateBirth.getTime());

				int height = rs.getInt("HEIGHT");

				java.sql.Date dateRecord = rs.getDate("DATE_RECORD");
				Calendar timeRecord = Calendar.getInstance();
				timeRecord.setTimeInMillis(dateRecord.getTime());

//        java.sql.Date dateUpdate = rs.getDate("DATE_UPDATE");
//        Calendar timeUpdate = Calendar.getInstance();
//        timeUpdate.setTimeInMillis(dateUpdate.getTime());

				client = new Client(idClient, name, lastName, email, password, phone, timeBirth, height, timeRecord);
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
		return client;
	}

	public boolean validateClient(Client client) {
		PreparedStatement stmt = null;
		ResultSet rs = null;
		try {
			connection = ConnectionManager.getInstance().getConnection();
			stmt = connection.prepareStatement("SELECT * FROM TAB_CLIENT WHERE EMAIL = ? AND PASSWORD = ?");
			stmt.setString(1, client.getEmail());
			stmt.setString(2, client.getPassword());
			rs = stmt.executeQuery();

			if (rs.next()) {
				return true;
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
		return false;
	}

}
