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
	 * Data criacao
	 */
	private Calendar DateRecord;
	/**
	 * Data atualiza��o
	 */
	private Calendar DateUpdate;
	
	// Construtores
	public Weight(int id, float value, Calendar dateRecord, Calendar dateUpdate) {
		Id = 0;
		Value = value;
		DateRecord = dateRecord;
		DateUpdate = dateUpdate;
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
		DateRecord = null;
		DateUpdate = null;
	}
	
	public float CalcIMC(float height){
		return  Value / (height * Value);
	}
	
	public float ConsultIMC(){
		return Value;
	}

	// Getters e Setters
	public int getId() {
		return Id;
	}

	public void setId(int id) {
		Id = id;
	}

	public float getValue() {
		return Value;
	}

	public void setValue(float value) {
		Value = value;
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
