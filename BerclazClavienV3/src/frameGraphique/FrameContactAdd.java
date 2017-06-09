package frameGraphique;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import contact.Contact;

public class FrameContactAdd extends FrameGeneral{
	
	
	JLabel firstnameL = new JLabel("Prénom :");
	JLabel lastnameL = new JLabel("Nom :");
	JLabel phoneL = new JLabel("N° de téléphone :");
	
	JTextField firstnameF = new JTextField();
	JTextField lastnameF = new JTextField();
	JTextField phoneF = new JTextField();
	
	JButton save = new JButton("Sauvegarder");
	JButton cancel = new JButton("Annuler");
	
	private ArrayList<Contact> list;
	private Contact futurContact = new Contact();
	
	FrameContactAdd( ArrayList<Contact> l){
		list = l;
		Font subtitle= new Font("Verdana",Font.BOLD,13);
		Font content = new Font("Verdana",Font.BOLD,12);
		//Ajout label prénom
		add(firstnameL);
		firstnameL.setBounds(20	,20, 150, 30); //axe x, axe y, largeur, hauteur
		firstnameL.setFont(subtitle);
		//Ajout label nom
		add(lastnameL);
		lastnameL.setBounds(20	,50, 150, 30); //axe x, axe y, largeur, hauteur
		lastnameL.setFont(subtitle);
		//Ajout label phone
		add(phoneL);
		phoneL.setBounds(20	,80, 150, 30); //axe x, axe y, largeur, hauteur
		phoneL.setFont(subtitle);
		
		//Ajout field prénom
		add(firstnameF);
		firstnameF.setBounds(165,20, 200, 30); //axe x, axe y, largeur, hauteur
		firstnameF.setFont(content);
		//Ajout field nom
		add(lastnameF);
		lastnameF.setBounds(165,50, 200, 30); //axe x, axe y, largeur, hauteur
		//Ajout field téléphone
		add(phoneF);
		phoneF.setBounds(165,80, 200, 30); //axe x, axe y, largeur, hauteur
				
		//Ajout boutton sauvegarder
		add(save);
		save.setBounds(50, 600, 120, 20);
		Ecouteurs ecouteur = new Ecouteurs();
		save.addActionListener(ecouteur);
		
		//Ajout boutton annuler
		add(cancel);
		cancel.setBounds(200, 600, 120, 20);
		cancel.addActionListener(ecouteur);
		
	}
	
	public class Ecouteurs implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			//si clique sur sauvegarder
			if (e.getSource()==save){
				
				futurContact.setFirstName(firstnameF.getText());
				futurContact.setLastName(lastnameF.getText());
				futurContact.setPhoneNumber(phoneF.getText());
				
				list.add(futurContact);
				
				FrameContactList interfaceContacts = null;
				try {
					interfaceContacts = new FrameContactList(list);
				} catch (ClassNotFoundException | IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				interfaceContacts.setVisible(true);
				//fermeture fenêtre actuelle
				dispose();
				
				
				
			}
			
			//Boutton supprimer contact
			if (e.getSource()==cancel){
				
				FrameContactList interfaceContacts = null;
				try {
					interfaceContacts = new FrameContactList(list);
				} catch (ClassNotFoundException | IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				interfaceContacts.setVisible(true);
				//fermeture fenêtre actuelle
				dispose();
				
			}
			
			//Boutton home du frame interfaceContactModify
			if (e.getSource()==getBoutonHome()){
				//Sérialisation des contacts présents dans la liste
				try {
					UploadDataContact(list);
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				//instantiation nouvelle fenêtre
				FramePrincipal menuPrincipal = new FramePrincipal();
				menuPrincipal.setVisible(true);
				//fermeture de la fênetre actuelle
				dispose();
			}
			
		}
		
	}
	
	//Méthode de sérialisation des contacts
		private static void UploadDataContact(ArrayList<Contact> listcontact) throws IOException {
			
			for (int i = 0; i < listcontact.size(); i++) {
				 FileOutputStream out = new FileOutputStream("./BDD_Contact/" + listcontact.get(i).getLastName()+listcontact.get(i).getFirstName()+".ser");
				 ObjectOutputStream oos = new ObjectOutputStream( out );
				 oos.writeObject(listcontact.get(i));
				 oos.close(); 
			}
			
				
		}
	
	
}
