package br.com.shycode.healthtrack.bean;

import java.util.Calendar;

public class Client {
	
	//Propriedades
    /**
     * Número Id
     */
    private int IdClient;
    
    /**
     * Nome
     */
    private String  Name;
    
    /**
     * Sobrenome 
     */
    private String LastName;
    
    /**
     * Email 
     */
    private String Email;
    
    /**
     * Senha 
     */
    private String Password;
    
    /**
     * Telefone 
     */
    private String Phone;
    
    /**
     * Data de Nascimento
     */
    private Calendar DateOfBirth;
    
    /**
     * Altura
     */
    private int height;
    
    /**
     * Data
     */
    private Calendar DateRecord;
    
    // Construtor
    /**
     * Construtor Cliente
     * @param idClient
     * @param name
     * @param lastName
     * @param email
     * @param password
     * @param phone
     * @param dateOfBirth
     * @param height
     */
    public Client(int idClient, String name, String lastName, String email, String password, String phone, Calendar dateOfBirth,
			int height, Calendar dateRecord) {
		super();
		IdClient = idClient;
		Name = name;
		LastName = lastName;
		Email = email;
		Password = password;
		Phone = phone;
		DateOfBirth = dateOfBirth;
		this.height = height;
		DateRecord = dateRecord;
	}

	//Gets - Sets
    public int getId() {
        return IdClient;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public String getLastName() {
        return LastName;
    }

    public void setLastName(String lastName) {
        LastName = lastName;
    }
    public Calendar getDateOfBirth() {
        return DateOfBirth;
    }

    public void setDateOfBirth(Calendar dateOfBirth) {
        DateOfBirth = dateOfBirth;
    }

    public String getEmail() {
        return Email;
    }

    public void setEmail(String email) {
        Email = email;
    }

    public String getPassword() {
        return Password;
    }

    public void setPassword(String password) {
        Password = password;
    }

    public String getPhone() {
        return Phone;
    }
    
    public void setPhone(String phone) {
    	Phone = phone;
    }
    
    public int getHeight() {
        return height;
    }
    
    public void setHeight(int height) {
        this.height = height;
    }
    
    public Calendar getDateRecord() {
		return DateRecord;
	}

	public void setDateRecord(Calendar dateRecord) {
		DateRecord = dateRecord;
	}
}