package contact;


import java.io.IOException;
import java.io.Serializable;
import java.util.*;

public class Contact implements Serializable {
	private static final long serialVersionUID = -3092856711586557318L;

	//Variables
	private int id;
	private String lastName;
	private String firstName;
	private Date bithdate;
	private String phoneNumber;
	private String email;
	private String internet;


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


	public Date getBithdate() {
		return bithdate;
	}


	public void setBithdate(Date bithdate) {
		this.bithdate = bithdate;
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


	public String getInternet() {
		return internet;
	}


	public void setInternet(String internet) {
		this.internet = internet;
	}

	

	public String toString()
	{
		String toList = this.getFirstName()+" "+this.getLastName();
		return toList;
	}
	
}
