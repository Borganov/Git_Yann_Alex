package interfaceGraphique;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
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
	
	private ArrayList<Contact> list;
	private int ind;
	
	FrameContactModify(int i, ArrayList<Contact> l){
		list = l;
		ind = i;
		//Ajout label prénom
		add(firstnameL);
		firstnameL.setBounds(20	,20, 100, 30); //axe x, axe y, largeur, hauteur
		//Ajout label nom
		add(lastnameL);
		lastnameL.setBounds(20	,50, 100, 30); //axe x, axe y, largeur, hauteur
		//Ajout label phone
		add(phoneL);
		phoneL.setBounds(20	,80, 100, 30); //axe x, axe y, largeur, hauteur
		
		//Ajout field prénom
		add(firstnameF);
		firstnameF.setBounds(130,20, 100, 30); //axe x, axe y, largeur, hauteur
		firstnameF.setText(list.get(ind).getFirstName());
		//Ajout field nom
		add(lastnameF);
		lastnameF.setBounds(130,50, 100, 30); //axe x, axe y, largeur, hauteur
		lastnameF.setText(list.get(ind).getLastName());
		//Ajout field téléphone
		add(phoneF);
		phoneF.setBounds(130,80, 100, 30); //axe x, axe y, largeur, hauteur
		phoneF.setText(list.get(ind).getPhoneNumber());
		
		//Ajout boutton sauvegarder
		add(save);
		save.setBounds(140, 600, 120, 20);
		Ecouteurs ecouteur = new Ecouteurs();
		save.addActionListener(ecouteur);
		
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
			
		}
		
	}
	
	
}
