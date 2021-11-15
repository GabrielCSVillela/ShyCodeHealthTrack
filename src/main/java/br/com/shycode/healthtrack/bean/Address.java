package br.com.shycode.healthtrack.bean;

import java.util.Calendar;

public class Address {
	
	// Propriedades
	/**
	 * Id Endere�o
	 */
    private int IdAddress;
    
    /**
     *Id Cliente 
     */
    private int IdClient;
    
    /**
     *N�mero 
     */
    private int Number;
    
    /**
     *CEP 
     */
    private int ZipCode;
    
    /**
     * Rua
     */
    private String Street;
    
    /**
     *Cidade
     */
    private String City;
    
    /**
     *Bairro
     */
    private String Neighborhood;
    
    /**
     *Estado
     */
    private String State;
    
    /**
     *Pa�s
     */
    private String Country;

    /**
     * Data
     */
    private Calendar DateRecord;
    
	// Construtores
	/**
	 * Construtor Endere�o
     * @param idAddress
     * @param idClient
     * @param number
     * @param zipCode
     * @param street 
     * @param city
     * @param neighborhood
     * @param state
     * @param country
	 * @param dateRecord
	 */
    public Address(int idAddress, int idClient, int number, int zipCode, String street, String city, String neighborhood,
			String state, String country, Calendar dateRecord) {
		super();
		IdAddress = idAddress;
		IdClient = idClient;
		Number = number;
		ZipCode = zipCode;
		Street = street;
		City = city;
		Neighborhood = neighborhood;
		State = state;
		Country = country;
		DateRecord = dateRecord;
	}
	    
	public Calendar getDateRecord() {
		return DateRecord;
	}

	public void setDateRecord(Calendar dateRecord) {
		DateRecord = dateRecord;
	}

	public Address() {
		super();
	}

	// M�todos
    /**
     * Registra Endere�o
     */
    public void register() {
    	IdAddress = 2;
    }
    
	/**
	 *Remove Endere�o 
	 */
    
	@SuppressWarnings("null")
	public void remove() {
		IdAddress = 0;
		IdClient = 0;
		Number = 0;
		ZipCode = 0;
		Street = null;
		City = null;
		Neighborhood = null;
		State = null;
		Country = null;
	}
    
    /**
     * Atualiza Endere�o
     * @param idAddress
     * @param idClient
     * @param number
     * @param zipCode
     * @param street 
     * @param city
     * @param neighborhood
     * @param state
     * @param country
     * @param dateRecord
     */
    public void update(int idAddress, int idClient, int number, int zipCode, String street, String city, String neighborhood,
			String state, String country, Calendar dateRecord) {
		IdAddress = idAddress;
		IdClient = idClient;
		Number = number;
		ZipCode = zipCode;
		Street = street;
		City = city;
		Neighborhood = neighborhood;
		State = state;
		Country = country;
		DateRecord = dateRecord;
    }


    //Getters e Setters
    public int getIdAddress() {
        return IdAddress;
    }
    
    public void setIdAddress(int idAddress) {
        IdAddress = idAddress;
    }

    public int getIdClient() {
        return IdClient;
    }

    public void setIdClient(int idClient) {
        IdClient = idClient;
    }

    public String getStreet() {
        return Street;
    }

    public void setStreet(String street) {
        Street = street;
    }

    public String getCity() {
        return City;
    }

    public void setCity(String city) {
        City = city;
    }

    public String getNeighborhood() {
        return Neighborhood;
    }

    public void setNeighborhood(String neighborhood) {
        Neighborhood = neighborhood;
    }

    public String getState() {
        return State;
    }

    public void setState(String state) {
        State = state;
    }

    public String getCountry() {
        return Country;
    }

    public void setCountry(String country) {
        Country = country;
    }

    public int getNumber() {
        return Number;
    }

    public void setNumber(int number) {
        Number = number;
    }

    public int getZipCode() {
        return ZipCode;
    }

    public void setZipCode(int zipCode) {
        ZipCode = zipCode;
    }
}