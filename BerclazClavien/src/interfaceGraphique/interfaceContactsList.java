package interfaceGraphique;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JList;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import contact.Contact;
import interfaceGraphique.menuPrincipal.Ecouteurs;

public class interfaceContactsList extends interfaceGeneral{

	//Création de l'array list de contact
	private ArrayList<Contact> contactList = new ArrayList<Contact>();
	//Création de la listeContact	
	private JList listContact ;
	
	//Ajout du boutton nouveau contact
	JButton newContact = new JButton("Ajouter un contact");
	
	//Font de la liste
	Font fontList = new Font("Verdana",Font.BOLD,19);
	
	
	interfaceContactsList() throws ClassNotFoundException, IOException{
		//Importation des données de BDD_Contact dans l'arrayList
		DownloadDataContact("./BDD_Contacts",contactList);
		
		listContact = new JList(contactList.toArray()) ;

		
		add(listContact);	//placement du bouton sur l'écran
		listContact.setBounds(10,10, 380, 400); //axe x, axe y, largeur, hauteur
		listContact.setFont(fontList);
		
		//ajout des listener
		Ecouteurs ecouteur = new Ecouteurs();
		listContact.addListSelectionListener(ecouteur);
		getBoutonHome().addActionListener(ecouteur);
		
		//Ajout boutton nouveau contact
		add(newContact);
		newContact.setBounds(140, 600, 180, 20);
		newContact.addActionListener(ecouteur);
		
		
	}
	
	interfaceContactsList(ArrayList<Contact> l) throws ClassNotFoundException, IOException{
		//Importation des données de BDD_Contact dans l'arrayList
		contactList = l;
		
		listContact = new JList(contactList.toArray()) ;

		
		add(listContact);	//placement du bouton sur l'écran
		listContact.setBounds(10,10, 380, 400); //axe x, axe y, largeur, hauteur
		listContact.setFont(fontList);
		
		//ajout des listener
		Ecouteurs ecouteur = new Ecouteurs();
		listContact.addListSelectionListener(ecouteur);
		getBoutonHome().addActionListener(ecouteur);
		
		//Ajout boutton nouveau contact
		add(newContact);
		newContact.setBounds(140, 600, 180, 20);
		newContact.addActionListener(ecouteur);
		
		
	}
	
	//Méthode de désérialisation des fichiers présent dans le fichier BDD_Contact
	private static void DownloadDataContact(String path, ArrayList<Contact> listcontact) throws IOException, ClassNotFoundException {
		File folder = new File(path);
		if(folder.isDirectory()==true){
			File[] list = folder.listFiles();
			
			for (int i = 0; i < list.length; i++) {
				
				FileInputStream in = new FileInputStream( "./BDD_Contacts/" + list[i].getName());
				ObjectInputStream ois = new ObjectInputStream( in );
				listcontact.add( (Contact) ois.readObject());
				ois.close(); 	
			}
			
			for (int i = 0; i < list.length; i++) {
				
				list[i].delete();	
			}
		}
		
	}
	
	public class Ecouteurs implements ListSelectionListener, ActionListener{

		@Override
		public void valueChanged(ListSelectionEvent e) {
			int contactSelected = (e.getFirstIndex());
			//instantiation nouvelle fenêtre
			FrameContactModify frameContactModify = new FrameContactModify(contactSelected, contactList);
			frameContactModify.setVisible(true);
			//fermeture de la fênetre actuelle
			dispose();
			
		}

		@Override
		public void actionPerformed(ActionEvent e) {
			if (e.getSource()==getBoutonHome()){
				//Sérialisation des contacts présents dans la liste
				try {
					UploadDataContact(contactList);
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				//instantiation nouvelle fenêtre
				menuPrincipal menuPrincipal = new menuPrincipal();
				menuPrincipal.setVisible(true);
				//fermeture de la fênetre actuelle
				dispose();
			}
			
			if (e.getSource()== newContact){
				//instantiation nouvelle fenêtre
				FrameContactAdd frameContactAdd = new FrameContactAdd(contactList);
				frameContactAdd.setVisible(true);
				//fermeture de la fênetre actuelle
				dispose();
			}
			
		}
		
	}
	//Méthode de sérialisation des contacts
	private static void UploadDataContact(ArrayList<Contact> listcontact) throws IOException {
		
		for (int i = 0; i < listcontact.size(); i++) {
			 FileOutputStream out = new FileOutputStream("./BDD_Contacts/" + listcontact.get(i).getLastName()+listcontact.get(i).getFirstName()+".ser");
			 ObjectOutputStream oos = new ObjectOutputStream( out );
			 oos.writeObject(listcontact.get(i));
			 oos.close(); 
		}
		
			
	}

}


