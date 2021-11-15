package br.com.shycode.healthtrack.bean;

import java.util.Calendar;

public class Nourishment {
	
	// Propriedades
	/**
	 * Id Nourishment
	 */
	private int Id;
	
	/**
	 * Descri��o
	 */
	private String Description;
	
	/**
	 * Caloria Comida
	 */
	private int Calorie;
	
	/**
	 * Data
	 */
	private Calendar Date;
	
	// Construtores
	/**
	 * 
	 * @param id
	 * @param description
	 * @param calorie
	 * @param Date
	 */
	public Nourishment(int id, String description, int calorie, Calendar date) {
		super();
		Id = id;
		Description = description;
		Calorie = calorie;
		Date = date;
	}
	
	/**
	 * ??
	 */
	public Nourishment() {
		super();
	}
	
	// M�todos
	public void Register() {
		Id = 1;
	}
	
	public void Remove() {
		Id = 0;
		Description = null;
		Calorie = 0;
	}
	
	// Getters e Setters
	public int getId() {
		return Id;
	}
	
	public String getDescription() {
		return Description;
	}
	
	public void setDescription(String description) {
		Description = description;
	}
	
	public int getCalorie() {
		return Calorie;
	}
	
	public void setCalorie(int calorie) {
		Calorie = calorie;
	}

	public Calendar getDate() {
		return Date;
	}

	public void setDate(Calendar date) {
		Date = date;
	}
	
	
}
