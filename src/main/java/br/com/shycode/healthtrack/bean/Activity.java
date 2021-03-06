package br.com.shycode.healthtrack.bean;

import java.util.Calendar;

public class Activity {

	// Propriedades
	/**
	 * Id Atividade
	 */
	private int IdActivity;

	/**
	 * Nome
	 */
	private String Name;

	/**
	 * Caloria
	 */
	private int Calorie;

	/**
	 * Tempo Inicial
	 */
	private Calendar StartTime;

	/**
	 * Tempo Final
	 */
	private Calendar EndTime;

	/**
	 * Data Registro
	 */
	private Calendar DateRecord;

	/**
	 * Data Atualiza��o
	 */
	private Calendar DateUpdate;

	// Construtores
	public Activity(int id, String name, int calorie, Calendar startTime, Calendar endTime, Calendar dateRecord) {
		IdActivity = id;
		Name = name;
		Calorie = calorie;
		StartTime = startTime;
		EndTime = endTime;
		DateRecord = dateRecord;
	}

	/**
	 * Construtor para atualização do servlet
	 * 
	 * @param id
	 * @param name
	 * @param calorie
	 * @param startTime
	 * @param endTime
	 * @param dateUpdate
	 */

	public Activity(int id, String name, int calorie, Calendar startTime, Calendar endTime, Calendar dateRecord,
			Calendar dateUpdate) {
		IdActivity = id;
		Name = name;
		Calorie = calorie;
		StartTime = startTime;
		EndTime = endTime;
		DateRecord = dateRecord;
		DateUpdate = dateUpdate;
	}

	public Activity() {
		super();
	}

	// Getters e Setters
	public Calendar getStartTime() {
		return StartTime;
	}

	public void setStartTime(Calendar startTime) {
		StartTime = startTime;
	}

	public Calendar getEndTime() {
		return EndTime;
	}

	public void setEndTime(Calendar endTime) {
		EndTime = endTime;
	}

	public Calendar getDateRecord() {
		return DateRecord;
	}

	public void setDateRecord(Calendar dateRecord) {
		DateRecord = dateRecord;
	}

	public String getName() {
		return Name;
	}

	public void setName(String name) {
		Name = name;
	}

	public int getId() {
		return IdActivity;
	}

	public int getCalorie() {
		return Calorie;
	}

	public void setCalorie(int calorie) {
		this.Calorie = calorie;
	}

	public Calendar getDateUpdate() {
		return DateUpdate;
	}

	public void setDateUpdate(Calendar dateUpdate) {
		DateUpdate = dateUpdate;
	}

}
