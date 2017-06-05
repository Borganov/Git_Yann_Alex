package interfaceGraphique;

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

public class FrameContactModify extends interfaceGeneral{
	
	
	JLabel firstnameL = new JLabel("Prénom :");
	JLabel lastnameL = new JLabel("Nom :");
	JLabel phoneL = new JLabel("N° de téléphone :");
	
	JTextField firstnameF = new JTextField();
	JTextField lastnameF = new JTextField();
	JTextField phoneF = new JTextField();
	
	JButton save = new JButton("Sauvegarder");
	JButton delete = new JButton("Supprimer");
	
	private ArrayList<Contact> list;
	private int ind;
	
	FrameContactModify(int i, ArrayList<Contact> l){
		list = l;
		ind = i;
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
		firstnameF.setText(list.get(ind).getFirstName());
		firstnameF.setFont(content);
		//Ajout field nom
		add(lastnameF);
		lastnameF.setBounds(165,50, 200, 30); //axe x, axe y, largeur, hauteur
		lastnameF.setText(list.get(ind).getLastName());
		//Ajout field téléphone
		add(phoneF);
		phoneF.setBounds(165,80, 200, 30); //axe x, axe y, largeur, hauteur
		phoneF.setText(list.get(ind).getPhoneNumber());
		
		//Ajout boutton sauvegarder
		add(save);
		save.setBounds(140, 600, 120, 20);
		Ecouteurs ecouteur = new Ecouteurs();
		save.addActionListener(ecouteur);
		
		//Ajout boutton supprimer
		add(delete);
		delete.setBounds(140, 570, 120, 20);
		delete.addActionListener(ecouteur);
		
	}
	
	public class Ecouteurs implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			//si clique sur gallerie
			if (e.getSource()==save){
				
				list.get(ind).setFirstName(firstnameF.getText());
				list.get(ind).setLastName(lastnameF.getText());
				list.get(ind).setPhoneNumber(phoneF.getText());
				
				interfaceContactsList interfaceContacts = null;
				try {
					interfaceContacts = new interfaceContactsList(list);
				} catch (ClassNotFoundException | IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				interfaceContacts.setVisible(true);
				//fermeture fenêtre actuelle
				dispose();
				
				
				
			}
			
			//Boutton supprimer contact
			if (e.getSource()==delete){
				
				list.remove(ind);
				
				interfaceContactsList interfaceContacts = null;
				try {
					interfaceContacts = new interfaceContactsList(list);
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
				menuPrincipal menuPrincipal = new menuPrincipal();
				menuPrincipal.setVisible(true);
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
