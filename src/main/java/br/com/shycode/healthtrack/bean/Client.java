package br.com.shycode.healthtrack.bean;

import java.util.Calendar;
import java.util.Date;

public class Client {
	
	//Propriedades
    /**
     * Número Id
     */
    private int Id;
    
    /**
     * Nome
     */
    private String  Name;
    
    /**
     *Sobrenome 
     */
    private String LastName;
    
    /**
     *Email 
     */
    private String Email;
    
    /**
     *Senha 
     */
    private String Password;
    
    /**
     *Telefone 
     */
    private String Phone;
    
    /**
     * Data de Nascimento
     */
    private Date DateOfBirth;
    
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
     * @param name
     * @param lastName
     * @param email
     * @param password
     * @param phone
     * @param dateOfBirth
     * @param height
     */
    public Client(String name, String lastName, String email, String password, String phone, Date dateOfBirth,
			int height, Calendar dateRecord) {
		super();
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
        return Id;
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
    public Date getDateOfBirth() {
        return DateOfBirth;
    }

    public void setDateOfBirth(Date dateOfBirth) {
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