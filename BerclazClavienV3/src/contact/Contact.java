package contact;


import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;

public class Contact implements Serializable {
	private static final long serialVersionUID = -3092856711586557318L;

	//Variables
	private int id;
	private String lastName;
	private String firstName;
	private String phoneNumber;
	private String profilPath;
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


	public String getprofilPath() {
		return profilPath;
	}


	public void setprofilPath(String profilPath) {
		this.profilPath = profilPath;
	}

	public String toString()
	{
		String toList = this.getFirstName()+" "+this.getLastName();
		return toList;
	}
	
	//M�thode de contr�le. Savoir si le contact en question est pr�sent dans l'arrayList envoy�.
	public boolean contactControl(ArrayList<Contact> list){
		boolean response = true;
		for (int i = 0; i < list.size(); i++) {
			String control1 = this.firstName+this.lastName;
			String control2 = list.get(i).firstName+list.get(i).lastName;
			if(control1.equals(control2)){
				response = false;
			}
			 
		}
		
		return response;
	}
	
}
