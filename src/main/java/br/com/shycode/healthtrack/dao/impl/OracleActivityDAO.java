package br.com.shycode.healthtrack.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import br.com.shycode.healthtrack.bean.Activity;
import br.com.shycode.healthtrack.dao.ActivityDAO;
import br.com.shycode.healthtrack.singleton.ConnectionManager;

public class OracleActivityDAO implements ActivityDAO {

	private Connection connection;

	public void insert(Activity activity) {
		PreparedStatement stmt = null;

		try {
			connection = ConnectionManager.getInstance().getConnection();
			String sql = "INSERT INTO TAB_ACTIVITY(ID_ACTIVITY, NAME_ACTIVITY, CALORIE_ACTIVITY, START_TIME, END_TIME, DATE_RECORD) VALUES (SQ_ACTIVITY.NEXTVAL, ?, ?, ?, ?, ?)";
			stmt = connection.prepareStatement(sql);
			stmt.setString(1, activity.getName());
			stmt.setInt(2, activity.getCalorie());
			java.sql.Date startTime = new java.sql.Date(activity.getStartTime().getTimeInMillis());
			stmt.setDate(3, startTime);
			java.sql.Date endTime = new java.sql.Date(activity.getEndTime().getTimeInMillis());
			stmt.setDate(4, endTime);
			java.sql.Date dateRecord = new java.sql.Date(activity.getDateRecord().getTimeInMillis());
			stmt.setDate(5, dateRecord);

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

	public List<Activity> select() {
		List<Activity> list = new ArrayList<Activity>();
		PreparedStatement stmt = null;
		ResultSet rs = null;
		try {
			connection = ConnectionManager.getInstance().getConnection();
			stmt = connection.prepareStatement("SELECT * FROM TAB_ACTIVITY");
			rs = stmt.executeQuery();

			while (rs.next()) {
				int idActivity = rs.getInt("ID_ACTIVITY");
				String name = rs.getString("NAME_ACTIVITY");
				int calorie = rs.getInt("CALORIE_ACTIVITY");
				java.sql.Date startDate = rs.getDate("START_TIME");
				Calendar startTime = Calendar.getInstance();
				startTime.setTimeInMillis(startDate.getTime());

				java.sql.Date endDate = rs.getDate("END_TIME");
				Calendar endTime = Calendar.getInstance();
				endTime.setTimeInMillis(endDate.getTime());

				java.sql.Date timeRecord = rs.getDate("DATE_RECORD");
				Calendar dateRecord = Calendar.getInstance();
				dateRecord.setTimeInMillis(timeRecord.getTime());

				java.sql.Date timeUpdate = rs.getDate("DATE_UPDATE");
				Calendar dateUpdate = Calendar.getInstance();
				dateUpdate.setTimeInMillis(timeUpdate.getTime());

				Activity activity = new Activity(idActivity, name, calorie, startTime, endTime, dateRecord, dateUpdate);

				list.add(activity);
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

	public void update(Activity activity) {
		PreparedStatement stmt = null;

		try {
			connection = ConnectionManager.getInstance().getConnection();
			String sql = "UPDATE TAB_ACTIVITY SET NAME_ACTIVITY = ?, CALORIE_ACTIVITY = ?, START_TIME = ?, END_TIME = ?, DATE_UPDATE = ? WHERE ID_ACTIVITY = ?";
			stmt = connection.prepareStatement(sql);
			stmt.setString(1, activity.getName());
			stmt.setInt(2, activity.getCalorie());
			java.sql.Date startTime = new java.sql.Date(activity.getStartTime().getTimeInMillis());
			stmt.setDate(3, startTime);
			java.sql.Date endTime = new java.sql.Date(activity.getEndTime().getTimeInMillis());
			stmt.setDate(4, endTime);
			java.sql.Date dateUpdate = new java.sql.Date(activity.getDateUpdate().getTimeInMillis());
			stmt.setDate(5, dateUpdate);

			stmt.setInt(6, activity.getId());

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

	public void delete(int id) {
		PreparedStatement stmt = null;

		try {
			connection = ConnectionManager.getInstance().getConnection();
			String sql = "DELETE FROM TAB_ACTIVITY WHERE ID_ACTIVITY = ?";
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

	public Activity selectById(int idSearch) {
		Activity activity = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		try {
			connection = ConnectionManager.getInstance().getConnection();
			stmt = connection.prepareStatement("SELECT * FROM TAB_ACTIVITY WHERE ID_ACTIVITY = ?");
			stmt.setInt(1, idSearch);
			rs = stmt.executeQuery();

			if (rs.next()) {
				int idActivity = rs.getInt("ID_ACTIVITY");
				String name = rs.getString("NAME_ACTIVITY");
				int calorie = rs.getInt("CALORIE_ACTIVITY");
				java.sql.Date startDate = rs.getDate("START_TIME");
				Calendar startTime = Calendar.getInstance();
				startTime.setTimeInMillis(startDate.getTime());

				java.sql.Date endDate = rs.getDate("END_TIME");
				Calendar endTime = Calendar.getInstance();
				endTime.setTimeInMillis(endDate.getTime());

				java.sql.Date timeRecord = rs.getDate("DATE_RECORD");
				Calendar dateRecord = Calendar.getInstance();
				dateRecord.setTimeInMillis(timeRecord.getTime());

				java.sql.Date timeUpdate = rs.getDate("DATE_UPDATE");
				Calendar dateUpdate = Calendar.getInstance();
				dateUpdate.setTimeInMillis(timeUpdate.getTime());

				activity = new Activity(idActivity, name, calorie, startTime, endTime, dateRecord, dateUpdate);
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
		return activity;
	}

}
