package br.com.shycode.healthtrack.bean;

import java.util.Calendar;

public class BloodPressure {

	//Propriedades
	/**
	 * Id Press�o Arterial
	 */
	private int Id;
	/**
	 * Press�o Arterial M�xima
	 */
	private float MaxPressure;
	/**
	 * Press�o Arterial M�nima
	 */
	private float MinPressure;
	/**
	 * Data medi��o press�o
	 */
	private Calendar TimeMeasurement;
	/**
	 * Data cria��o
	 */
	private Calendar DateRecord;
	/**
	 * Data atualiza��o
	 */
	private Calendar DateUpdate;


	
	// Construtores
	/**
	 * 
	 * @param id
	 * @param maxPressure
	 * @param minPressure
	 * @param timeMeasurement
	 * @param dateRecord
	 * @param dateUpdate
	 */
	public BloodPressure(int id, float maxPressure, float minPressure, Calendar timeMeasurement, Calendar dateRecord,
			Calendar dateUpdate) {
		super();
		Id = id;
		MaxPressure = maxPressure;
		MinPressure = minPressure;
		TimeMeasurement = timeMeasurement;
		DateRecord = dateRecord;
		DateUpdate = dateUpdate;
	}
	
	public BloodPressure() {
		super();
	}
	
	// M�todos
	
	
	// Getters e Setters
	
	public int getId() {
		return Id;
	}

	public void setId(int id) {
		Id = id;
	}

	public float getMaxPressure() {
		return MaxPressure;
	}

	public void setMaxPressure(float maxPressure) {
		MaxPressure = maxPressure;
	}

	public float getMinPressure() {
		return MinPressure;
	}

	public void setMinPressure(float minPressure) {
		MinPressure = minPressure;
	}

	public Calendar getTimeMeasurement() {
		return TimeMeasurement;
	}

	public void setTimeMeasurement(Calendar timeMeasurement) {
		TimeMeasurement = timeMeasurement;
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

	public void setDateUpdated(Calendar dateUpdate) {
		DateUpdate = dateUpdate;
	}
	
	
}
