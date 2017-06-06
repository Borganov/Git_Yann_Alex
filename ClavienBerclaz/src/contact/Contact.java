package contact;


import java.io.IOException;
import java.io.Serializable;

public class Contact implements Serializable {
	private static final long serialVersionUID = -3092856711586557318L;

	//Variables
	private int id;
	private String lastName;
	private String firstName;
	private String phoneNumber;
	private String email;
	private String civilite;


	//Constructeur
	public Contact(String lastName, String firstName, String phoneNumber) throws IOException {
		this.lastName = lastName;
		this.firstName = firstName;
		this.phoneNumber = phoneNumber;

	}
	
	public Contact() {
		
	}
	
	//Getters and Setters
	
	public int getId() {
		return id;
	}

	
	public void setId(int id) {
		this.id = id;
	}

	
	public String getLastName() {
		return lastName;
	}


	public void setLastName(String lastName) {
		this.lastName = lastName;
	}


	public String getFirstName() {
		return firstName;
	}


	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	
	public String getCivilite() {
		return civilite;
	}


	public void setCivilite(String civilite) {
		this.civilite = civilite;
	}


	public String getPhoneNumber() {
		return phoneNumber;
	}


	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}


	public String getEmail() {
		return email;
	}


	public void setEmail(String email) {
		this.email = email;
	}

	public String toString()
	{
		String toList = this.getFirstName()+" "+this.getLastName();
		return toList;
	}
	
}
