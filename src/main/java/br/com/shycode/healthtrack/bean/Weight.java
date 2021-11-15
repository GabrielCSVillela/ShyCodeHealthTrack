package br.com.shycode.healthtrack.bean;

import java.util.Calendar;

public class Weight {
	
	// Propriedades
	/**
	 * Id Peso
	 */
	private int Id;
	
	/**
	 * Valor
	 */
	private float Value;
	
	/**
	 * Data
	 */
	private Calendar Date;
	
	// Construtores
	public Weight(int id, float value, Calendar date) {
		Id = 0;
		Value = value;
		Date = date;
	}
	
	public Weight() {
		super();
	}


	// M�todos
	public void Register(){
		Id = 1;
	}
	
	public void Remove(){
		Id = 0;
		Value = 0;
		Date = null;
	}
	
	public float CalcIMC(float height){
		return  Value / (height * Value);
	}
	
	public float ConsultIMC(){
		return Value;
	}
		
	// Getters e Setters
	public float getValue() {
		return Value;
	}

	public void setValue(float value) {
		Value = value;
	}

	public Calendar getDate() {
		return Date;
	}

	public void setDate(Calendar date) {
		Date = date;
	}

	public int getId() {
		return Id;
	}
	
	
}
