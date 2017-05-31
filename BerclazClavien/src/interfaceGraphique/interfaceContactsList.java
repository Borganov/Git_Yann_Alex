package interfaceGraphique;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.ArrayList;

import javax.swing.JList;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import contact.Contact;
import interfaceGraphique.menuPrincipal.Ecouteurs;

public class interfaceContactsList extends interfaceGeneral{

	//Cr�ation de l'array list de contact
	private ArrayList<Contact> contactList = new ArrayList<Contact>();
	//Cr�ation de la listeContact	
	private JList listContact ;
	
	
	interfaceContactsList() throws ClassNotFoundException, IOException{
		//Importation des donn�es de BDD_Contact dans l'arrayList
		DownloadDataContact("./BDD_Contact",contactList);
		
		listContact = new JList(contactList.toArray()) ;

		
		add(listContact);	//placement du bouton sur l'�cran
		listContact.setBounds(10,10, 380, 660); //axe x, axe y, largeur, hauteur
		
		//ajout des listener
		Ecouteurs ecouteur = new Ecouteurs();
		listContact.addListSelectionListener(ecouteur);
		
		
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
	
	public class Ecouteurs implements ListSelectionListener{

		@Override
		public void valueChanged(ListSelectionEvent e) {
			int contactSelected = (e.getFirstIndex());
			//instantiation nouvelle fen�tre
			FrameContactModify frameContactModify = new FrameContactModify(contactSelected, contactList);
			frameContactModify.setVisible(true);
			//fermeture de la f�netre actuelle
			dispose();
			
		}
		
	}
	
	

	

}


