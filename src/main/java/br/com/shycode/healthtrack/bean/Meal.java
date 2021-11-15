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
	 * Data 
	 */
	private Calendar Date;
	
	// Construtores
	public Meal(int id, String nameMeal, int totalCalorie, Calendar date) {
		Id = id;
		NameMeal = nameMeal;
		TotalCalorie = totalCalorie;
		Date = date;
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

	public Calendar getDate() {
		return Date;
	}

	public void setDate(Calendar date) {
		Date = date;
	}

	
}
