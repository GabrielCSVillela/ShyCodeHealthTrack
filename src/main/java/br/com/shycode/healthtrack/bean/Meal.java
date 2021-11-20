package br.com.shycode.healthtrack.bean;

import java.util.Calendar;

public class Meal {
	
	//Propriedades
	/**
	 * Id Refei��o
	 */
	private int Id;
	
	/**
	 * Nome Refei��o
	 */
	private String NameMeal;
	
	/**
	 * Total Calorias
	 */
	private int TotalCalorie;

	/**
	 * Data record
	 */
	private Calendar DateRecord;
	
	/**
	 * Data record
	 */
	private Calendar DateUpdate;
	
	// Construtores
	public Meal(int id, String nameMeal, int totalCalorie, Calendar dateRecord, Calendar dateUpdate) {
		Id = id;
		NameMeal = nameMeal;
		TotalCalorie = totalCalorie;
		DateRecord = dateRecord;
		DateUpdate = dateUpdate;
	}

	public Meal(int id, String nameMeal, int totalCalorie, Calendar dateUpdate) {
		super();
		Id = id;
		NameMeal = nameMeal;
		TotalCalorie = totalCalorie;
		DateUpdate = dateUpdate;
	}



	public Meal() {
		super();
	}

	//M�todos
	public void Register() {
		Id = 1;
	}
	
	//Gets e Sets
	public int getId() {
		return Id;
	}
	
	public String getNameMeal() {
		return NameMeal;
	}

	public void setNameMeal(String nameMeal) {
		NameMeal = nameMeal;
	}

	public int getTotalCalorie() {
		return TotalCalorie;
	}

	public void setTotalCalorie(int totalCalorie) {
		TotalCalorie = totalCalorie;
	}

	public Calendar getDateRecord() {
		return DateRecord;
	}

	public void setDateRecord(Calendar dateRecord) {
		DateRecord = dateRecord;
	}

	public Calendar getDateUpdate() {
		return DateUpdate;
	}

	public void setDateUpdate(Calendar dateUpdate) {
		DateUpdate = dateUpdate;
	}
	
}
