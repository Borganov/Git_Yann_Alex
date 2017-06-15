package contact;


import java.io.IOException;
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
	/**
	 * C'est le constructeur principal de l'objet Contact
	 * @param lastName
	 * @param firstName
	 * @param phoneNumber
	 * @throws IOException
	 */
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
	
	
	/**
	 * Méthode de contrôle. Savoir si le contact en question est présent dans l'arrayList envoyé.
	 * @param list
	 * @return
	 */
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
	

	
	/**
	 * Méthode de contrôle. Savoir si le contact en question est présent 
	 * dans l'arrayList envoyé dans le cas d'une modification de contact donc l'Id ne doit pas être identique
	 * @param list
	 * @param ind
	 * @return
	 */
		public boolean contactControl(ArrayList<Contact> list, int ind){
			boolean response = true;
			for (int i = 0; i < list.size(); i++) {
				String control1 = this.firstName+this.lastName;
				String control2 = list.get(i).firstName+list.get(i).lastName;
				if(control1.equals(control2) && ind != i){
						response = false;
				}
				 
			}
			
			return response;
		}


	
	
		/**
		 * Méthode pour contrôler qu'un contact n'est pas vide (Lastname and firstname)
		 * @return
		 */
	public boolean contactIsEmpty(){
		boolean response = true;
		if(lastName.isEmpty()==true || firstName.isEmpty()==true){
			response = false;
		}
		
		
		return response;
	}
	
}
