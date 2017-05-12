package contact;

import java.util.*;
import galerie.Galerie;

public class Contact {
	//Variables
	private String lastName;
	private String firstName;
	private Date bithdate;
	private String phoneNumber;
	private String email;
	private String internet;
	private Galerie photoProfil;


	//Constructeur
	public Contact(String lastName, String firstName, String phoneNumber) {
		this.lastName = lastName;
		this.firstName = firstName;
		this.phoneNumber = phoneNumber;
	}
	
	//Getters and Setters

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


	public Galerie getPhotoProfil() {
		return photoProfil;
	}


	public void setPhotoProfil(Galerie photoProfil) {
		this.photoProfil = photoProfil;
	}
	

	
}
