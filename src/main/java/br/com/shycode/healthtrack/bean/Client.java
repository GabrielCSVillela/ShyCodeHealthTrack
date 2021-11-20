package br.com.shycode.healthtrack.bean;

import java.util.Calendar;

import br.com.shycode.healthtrack.util.CriptografiaUtils;

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
		this.Email = email;
		setSenha(password);
		Phone = phone;
		DateOfBirth = dateOfBirth;
		this.height = height;
		DateRecord = dateRecord;
	}
    

    public Client(String email, String password) {
		super();
		this.Email = email;
		setSenha(password);
	}


	/**
     *  Construtor para edição. Não pode ter a edição do dia de criação
     * @param idClient2
     * @param name2
     * @param lastName2
     * @param email2
     * @param password2
     * @param phone2
     * @param dateBirth
     * @param height2
     */
	public Client(int idClient2, String name2, String lastName2, String email2, String password2, String phone2,
			Calendar dateBirth, int height2) {
		// TODO Auto-generated constructor stub
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
	
  	public void setSenha(String password) {
		try {
			this.Password = CriptografiaUtils.criptografar(password);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}