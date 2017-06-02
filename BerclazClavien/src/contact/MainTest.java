package contact;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

public class MainTest {

	public static void main(String[] args) throws IOException, ClassNotFoundException{
		
		ArrayList<Contact> contactList = new ArrayList<Contact>();
		
		


//		contactList.add(new Contact("Clavien", "Yann", "046 548 98 58"));
//		contactList.add(new Contact("Berclaz", "Alex", "079 463 65 15"));
//		contactList.add(new Contact("Bornatici", "Valentin", "079 485 25 56"));
//		
//		
//		UploadDataContact(contactList);
		
		DownloadDataContact("./BDD_Contact",contactList);
		
		System.out.println(contactList.get(0).getFirstName());
		System.out.println(contactList.get(1).getFirstName());
		
		
		

	}
	
	private static void DownloadDataContact(String path, ArrayList<Contact> listcontact) throws IOException, ClassNotFoundException {
		File folder = new File(path);
		if(folder.isDirectory()==true){
			File[] list = folder.listFiles();
			
			for (int i = 0; i < list.length; i++) {
				
				FileInputStream in = new FileInputStream( "./BDD_Contact/" + list[i].getName());
				ObjectInputStream ois = new ObjectInputStream( in );
				listcontact.add( (Contact) ois.readObject());
				ois.close(); 				
			}
		}
		
	}
	
	private static void UploadDataContact(ArrayList<Contact> listcontact) throws IOException {

		
		for (int i = 0; i < listcontact.size(); i++) {
			 FileOutputStream out = new FileOutputStream("./BDD_Contact/" + listcontact.get(i).getLastName()+listcontact.get(i).getFirstName()+".ser");
			 ObjectOutputStream oos = new ObjectOutputStream( out );
			 oos.writeObject(listcontact.get(i));
			 oos.close(); 
		}
		
			
	}


}
