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
     * Data de Nascimento
     */
    private Calendar DateMeasurement;
	
	/**
	 * Data criacao
	 */
	private Calendar DateRecord;
	/**
	 * Data atualiza��o
	 */
	private Calendar DateUpdate;
	
	// Construtores
	public Weight(int id, float value, Calendar DateMeasurement, Calendar dateRecord, Calendar dateUpdate) {
		Id = id;
		Value = value;
		this.DateMeasurement = DateMeasurement;
		DateRecord = dateRecord;
		DateUpdate = dateUpdate;
	}

	public Weight(int id, float value, Calendar DateMeasurement, Calendar dateUpdate) {
		super();
		Id = id;
		Value = value;
		this.DateMeasurement = DateMeasurement;
		DateUpdate = dateUpdate;
	}
	


	public Weight() {
		super();
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
	
	public Calendar getDateMeasurement() {
		return DateMeasurement;
	}

	public void setDateMeasurement(Calendar dateMeasurement) {
		DateMeasurement = dateMeasurement;
	}
	
}
