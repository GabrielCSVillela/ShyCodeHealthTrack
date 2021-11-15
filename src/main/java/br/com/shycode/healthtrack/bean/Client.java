package br.com.shycode.healthtrack.bean;

import java.util.Date;

public class Client {
	//Props
    /**
     * N�mero Id
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
    private String Fone;
    
    /**
     * Data de Nascimento
     */
    private Date DateOfBirth;
    
    /**
     * Altura
     */
    private Float height;
    
    // Construtor
    /**
     * Construtor Cliente
     * @param name
     * @param lastName
     * @param email
     * @param password
     * @param fone
     * @param dateOfBirth
     * @param height
     */
    public Client(String name, String lastName, String email, String password, String fone, Date dateOfBirth,
			Float height) {
		super();
		Name = name;
		LastName = lastName;
		Email = email;
		Password = password;
		Fone = fone;
		DateOfBirth = dateOfBirth;
		this.height = height;
	}

    //Methods
    /**
     * Registra Cliente
     */
    public void register() {
    	Id = 1;
    }
    
    /**
     * Remove cliente
     */
    public void remove() {
    	Id = 0;
		Name = null;
		LastName = null;
		Email = null;
		Password = null;
		Fone = null;
		DateOfBirth = null;
		this.height = null;
    }
    
	/**
	 * Atualiza Cliente
	 * @param name2
	 * @param lastName2
	 * @param email2
	 * @param password2
	 * @param fone2
	 * @param dateOfBirth2
	 * @param height2
	 */
    public void update(String name2, String lastName2, String email2, String password2, String fone2, Date dateOfBirth2,
			Float height2) {
		Name = name2;
		LastName = lastName2;
		Email = email2;
		Password = password2;
		Fone = fone2;
		DateOfBirth = dateOfBirth2;
		this.height = height2;
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

    public String getFone() {
        return Fone;
    }
    public void setFone(String fone) {
        Fone = fone;
    }
    
    public float getHeight() {
        return height;
    }
    public void setHeight(float height) {
        this.height = height;
    }
}