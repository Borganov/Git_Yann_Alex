package interfaceGraphique;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.ArrayList;

import contact.Contact;

public class interfaceContactsList extends interfaceGeneral{
	//Cr�ation de l'array list de contact
	ArrayList<Contact> contactList = new ArrayList<Contact>();
	
	interfaceContactsList() throws ClassNotFoundException, IOException{
		//Importation des donn�es de BDD_Contact dans l'arrayList
		DownloadDataContact("./BDD_Contact",contactList);
		
	}
	
	//M�thode de d�s�rialisation des fichiers pr�sent dans le fichier BDD_Contact
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
	
	

	

}


