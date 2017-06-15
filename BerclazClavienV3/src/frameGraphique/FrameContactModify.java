package frameGraphique;

import java.awt.Dimension;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import contact.Contact;
import frameGraphique.FrameGallerie.Ecouteurs;

public class FrameContactModify extends FrameGeneral{
	
	
	private JLabel civiliteL = new JLabel("Civilité :");
	private JLabel firstnameL = new JLabel("Prénom :");
	private JLabel lastnameL = new JLabel("Nom :");
	private JLabel phoneL = new JLabel("N° de téléphone :");
	private JLabel title = new JLabel("Modifier un contact");
	
	private JTextField firstnameF = new JTextField();
	private JTextField lastnameF = new JTextField();
	private JTextField phoneF = new JTextField();
	
	private String[] civiliteList = {"Monsieur", "Madame"};
	private JComboBox<String> civiliteC = new JComboBox<String>(civiliteList);	
	
	private JButton save = new JButton(new ImageIcon(getClass().getResource("/save.png")));
	private JButton delete = new JButton(new ImageIcon(getClass().getResource("/delete.png")));
	private JButton photoMod = new JButton(new ImageIcon(getClass().getResource("/modify.png")));
	
	private ArrayList<Contact> list;
	private int ind;
	
	FrameContactModify(int i, ArrayList<Contact> l) throws IOException{
		list = l;
		ind = i;
		Font titleFont = new Font("Verdanan", Font.BOLD, 24);
		Font subtitleFont= new Font("Verdana",Font.BOLD,13);
		Font contentFont = new Font("Verdana",Font.BOLD,12);
		
		
		//Ajout du titre de la fenêtre
		add(title);
		title.setBounds(75,30,300,20);
		title.setFont(titleFont);
		
		//Ajout label Civilité
		add(civiliteL);
		civiliteL.setBounds(25	,245, 150, 30); //axe x, axe y, largeur, hauteur
		civiliteL.setFont(subtitleFont);
		
		//Ajout label prénom
		add(firstnameL);
		firstnameL.setBounds(25	,275, 150, 30); //axe x, axe y, largeur, hauteur
		firstnameL.setFont(subtitleFont);
		
		//Ajout label nom
		add(lastnameL);
		lastnameL.setBounds(25 ,305, 150, 30); //axe x, axe y, largeur, hauteur
		lastnameL.setFont(subtitleFont);
		
		//Ajout label phone
		add(phoneL);
		phoneL.setBounds(25	,335, 350, 30); //axe x, axe y, largeur, hauteur
		phoneL.setFont(subtitleFont);
		
		//Ajout de la photo de profil et redimensionnement de la photo pour qu'elle s'intègre parfaitement au boutton
		JButton btnpic = new JButton(new ImageIcon(new ImageIcon(list.get(ind).getprofilPath()).getImage().getScaledInstance(-1, 110, Image.SCALE_FAST)));
		btnpic.setPreferredSize(new Dimension(150 ,150));
		btnpic.setOpaque(false);
		btnpic.setContentAreaFilled(false);
		btnpic.setBorderPainted(false);
		add(btnpic);
		btnpic.setBounds(25,75,150,150);
		
		//Ajout du boutton modifier image de profil
		add(photoMod);
		photoMod.setBounds(200, 145, 80, 80);
		photoMod.setContentAreaFilled(false);
		photoMod.setBorderPainted(false);
		Ecouteurs ecouteur = new Ecouteurs();
		photoMod.addActionListener(ecouteur);

		
		//Ajout field prénom
		add(firstnameF);
		firstnameF.setBounds(170,275, 200, 30); //axe x, axe y, largeur, hauteur
		firstnameF.setText(list.get(ind).getFirstName());
		firstnameF.setFont(contentFont);
		//Ajout field nom
		add(lastnameF);
		lastnameF.setBounds(170,305, 200, 30); //axe x, axe y, largeur, hauteur
		lastnameF.setText(list.get(ind).getLastName());
		lastnameF.setFont(contentFont);
		//Ajout field téléphone
		add(phoneF);
		phoneF.setBounds(170,335, 200, 30); //axe x, axe y, largeur, hauteur
		phoneF.setText(list.get(ind).getPhoneNumber());
		phoneF.setFont(contentFont);
		
		//Ajout ComboBox Civilité
		add(civiliteC);
		civiliteC.setBounds(170,245, 200, 27); //axe x, axe y, largeur, hauteur
		civiliteC.setSelectedItem(list.get(ind).getCivilite());
		civiliteC.setFont(contentFont);
		
		//Ajout boutton sauvegarder
		add(save);
		save.setBounds(100, 580, 80, 80);
		save.setContentAreaFilled(false);
		save.setBorderPainted(false);
		save.addActionListener(ecouteur);
		
		//Ajout boutton supprimer
		add(delete);
		delete.setBounds(220, 580, 80, 80);
		delete.setContentAreaFilled(false);
		delete.setBorderPainted(false);
		delete.addActionListener(ecouteur);
		
		//Ajout écouteurs
		getBoutonHome().addActionListener(ecouteur);
		getBoutonOff().addActionListener(ecouteur);
		
	}
	
	public class Ecouteurs implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			//si clique sur gallerie
			if (e.getSource()==save){
				
				try {
					Contact contactToControl = new Contact(lastnameF.getText(),firstnameF.getText(),phoneF.getText());
					boolean controlIsEquals;
					boolean controlIsEmpty;
					controlIsEquals = contactToControl.contactControl(list,ind);

					controlIsEmpty = contactToControl.contactIsEmpty();
					if(controlIsEquals == true && controlIsEmpty == true){
						list.get(ind).setCivilite((String)civiliteC.getSelectedItem());;
						list.get(ind).setFirstName(firstnameF.getText());
						list.get(ind).setLastName(lastnameF.getText());
						list.get(ind).setPhoneNumber(phoneF.getText());
						
						
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
							
					}else
					{
						//Message d'erreur en cas de problème de contact déjà existant.
						JOptionPane.showMessageDialog(null, "Contact vide ou identique. \n Veuillez corriger votre enregistrement", "Erreur", JOptionPane.ERROR_MESSAGE);
					}
						
				} catch (IOException e2) {
					// TODO Auto-generated catch block
					e2.printStackTrace();
				}
					
			}
			
			if (e.getSource()==photoMod){
				
				try {
					Contact contactToControl = new Contact(lastnameF.getText(),firstnameF.getText(),phoneF.getText());
					boolean controlIsEquals;
					boolean controlIsEmpty;
					controlIsEquals = contactToControl.contactControl(list, ind);
					controlIsEmpty = contactToControl.contactIsEmpty();
					if(controlIsEquals == true && controlIsEmpty == true){
					
						list.get(ind).setCivilite((String)civiliteC.getSelectedItem());;
						list.get(ind).setFirstName(firstnameF.getText());
						list.get(ind).setLastName(lastnameF.getText());
						list.get(ind).setPhoneNumber(phoneF.getText());
						
						FrameGallerie selectPicture = null;
						selectPicture = new FrameGallerie(1,2,ind,list);
						selectPicture.setVisible(true);
						//fermeture fenêtre actuelle
						dispose();
					
					}else
					{
						//Message d'erreur en cas de problème de contact déjà existant.
						JOptionPane.showMessageDialog(null, "Contact vide ou identique. \n Veuillez corriger votre enregistrement", "Erreur", JOptionPane.ERROR_MESSAGE);
					}
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}	
			}
			
			//Boutton supprimer contact
			if (e.getSource()==delete){
				
				list.remove(ind);
				
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
			if (e.getSource()==getBoutonOff()){
				//Sérialisation des contacts présents dans la liste
				try {
					UploadDataContact(list);
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
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
