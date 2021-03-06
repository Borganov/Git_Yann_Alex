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
import javax.swing.SwingConstants;
import contact.Contact;

public class FrameContactAdd extends FrameGeneral{
	
	private JLabel civiliteL = new JLabel("Civilit� :");
	private JLabel firstnameL = new JLabel("Pr�nom :");
	private JLabel lastnameL = new JLabel("Nom :");
	private JLabel phoneL = new JLabel("N� de t�l�phone :");
	private JLabel title = new JLabel("Nouveau contact");
	
	private JTextField firstnameF = new JTextField();
	private JTextField lastnameF = new JTextField();
	private JTextField phoneF = new JTextField();
	private String[] civiliteList = {"Monsieur", "Madame"};
	private JComboBox<String> civiliteC = new JComboBox<String>(civiliteList);
	
	private JButton save = new JButton(new ImageIcon(getClass().getResource("/save.png")));
	private JButton cancel = new JButton(new ImageIcon(getClass().getResource("/cancel.png")));
	private JButton photoMod = new JButton(new ImageIcon(getClass().getResource("/modify.png")));
	
	private ArrayList<Contact> list;
	private Contact futurContact = new Contact();
	
	/**
	 * Constructeur principal permettant cr�er l'interface de gestion des nouveaux contacts
	 * @param l
	 */
	FrameContactAdd( ArrayList<Contact> l){
		list = l;
		Font titleFont = new Font("Verdanan", Font.BOLD, 24);
		Font subtitleFont= new Font("Verdana",Font.BOLD,13);
		Font contentFont = new Font("Verdana",Font.BOLD,12);
		
		//Ajout du titre de la fen�tre
		add(title);
		title.setBounds(100,30,300,20);
		title.setFont(titleFont);
		title.setHorizontalTextPosition(SwingConstants.CENTER);
		title.setVerticalTextPosition(SwingConstants.BOTTOM);
				
		//Ajout label Civilit�
		add(civiliteL);
		civiliteL.setBounds(25	,245, 150, 30); //axe x, axe y, largeur, hauteur
		civiliteL.setFont(subtitleFont);
				
		//Ajout label pr�nom
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
		
		//Ajout de la photo de profil et redimensionnement de la photo pour qu'elle s'int�gre parfaitement au boutton
		JButton btnpic = new JButton(new ImageIcon(new ImageIcon("./Icones/profil.jpg").getImage().getScaledInstance(-1, 110, Image.SCALE_FAST)));
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
			
		//Ajout field pr�nom
		add(firstnameF);
		firstnameF.setBounds(170,275, 200, 30); //axe x, axe y, largeur, hauteur
		firstnameF.setFont(contentFont);
		//Ajout field nom
		add(lastnameF);
		lastnameF.setBounds(170,305, 200, 30); //axe x, axe y, largeur, hauteur
		lastnameF.setFont(contentFont);
		//Ajout field t�l�phone
		add(phoneF);
		phoneF.setBounds(170,335, 200, 30); //axe x, axe y, largeur, hauteur
		phoneF.setFont(contentFont);
				
		//Ajout ComboBox Civilit�
		add(civiliteC);
		civiliteC.setBounds(170,245, 200, 27); //axe x, axe y, largeur, hauteur
		civiliteC.setFont(contentFont);
		civiliteC.setSelectedItem(null);
		
		//Ajout boutton sauvegarder
		add(save);
		save.setBounds(100, 580, 80, 80);
		save.addActionListener(ecouteur);
		save.setContentAreaFilled(false);
		save.setBorderPainted(false);
		
		//Ajout boutton annuler
		add(cancel);
		cancel.setBounds(220, 580, 80, 80);
		cancel.addActionListener(ecouteur);
		cancel.setContentAreaFilled(false);
		cancel.setBorderPainted(false);
		
		//Ajout �couteurs
		getBoutonHome().addActionListener(ecouteur);
		getBoutonOff().addActionListener(ecouteur);
		
	}
	
	
	public class Ecouteurs implements ActionListener{
		/**
		 * Ecouteur permettant de g�rer les diff�rents bouttons pr�sents sur la fen�tre Contact Add
		 * 
		 * Save = ecouteur du boutton sauvegarder
		 * Cancel = ecouteur du boutton annuler
		 * PhotoMod = ecouteur du boutton modification de photo d'un contact
		 * BouttonOFF = ecouteur g�rant le boutton off du smartphone
		 * BouttonHome = ecouteur g�rant le boutton Home en bas du smartphone
		 */
		@Override
		public void actionPerformed(ActionEvent e) {
			//si clique sur sauvegarder
			
			if (e.getSource()==save){
				boolean controlIsEquals;
				boolean controlIsEmpty;
				
				futurContact.setprofilPath("./Icones/profil.jpg");
				futurContact.setFirstName(firstnameF.getText());
				futurContact.setLastName(lastnameF.getText());
				futurContact.setPhoneNumber(phoneF.getText());
				futurContact.setCivilite((String)civiliteC.getSelectedItem());
				
				//Contr�le de s�curit�
				controlIsEquals = futurContact.contactControl(list);
				controlIsEmpty = futurContact.contactIsEmpty();
				
				if(controlIsEquals == true && controlIsEmpty == true){

					list.add(futurContact);
				
					FrameContactList interfaceContacts = null;
					try {
						interfaceContacts = new FrameContactList(list);
					} catch (ClassNotFoundException | IOException e1) {
						//TODO Auto-generated catch block
						e1.printStackTrace();
					}
					interfaceContacts.setVisible(true);
					//fermeture fen�tre actuelle
					dispose();
				
				}
				else
				{
					//Message d'erreur en cas de probl�me de contact d�j� existant.
					JOptionPane.showMessageDialog(null, "Contact vide ou identique. \n Veuillez corriger votre enregistrement", "Erreur", JOptionPane.ERROR_MESSAGE);
				}

				
			}
			
			//Boutton annuler
			if (e.getSource()==cancel){
				
				FrameContactList interfaceContacts = null;
				try {
					interfaceContacts = new FrameContactList(list);
				} catch (ClassNotFoundException | IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				interfaceContacts.setVisible(true);
				//fermeture fen�tre actuelle
				dispose();
				
			}
			
			//Boutton modifier photo
			if (e.getSource()==photoMod){
				try {
					Contact contactToControl = new Contact(lastnameF.getText(),firstnameF.getText(),phoneF.getText());
					boolean controlIsEquals;
					boolean controlIsEmpty;
					controlIsEquals = contactToControl.contactControl(list);
					controlIsEmpty = contactToControl.contactIsEmpty();
					if(controlIsEquals == true && controlIsEmpty == true){
						
						//System.out.println(list.lastIndexOf(list)+1);
						futurContact.setprofilPath("./Icones/profil.jpg");
						futurContact.setFirstName(firstnameF.getText());
						futurContact.setLastName(lastnameF.getText());
						futurContact.setPhoneNumber(phoneF.getText());
						futurContact.setCivilite((String)civiliteC.getSelectedItem());
						
						list.add(futurContact);
						int ind  =list.size()-1;
										
						FrameGallerie selectPicture = null;
						selectPicture = new FrameGallerie(1,2,ind,list);
						selectPicture.setVisible(true);
						//fermeture fen�tre actuelle
						dispose();
						
					}else
					{
						//Message d'erreur en cas de probl�me de contact d�j� existant.
						JOptionPane.showMessageDialog(null, "Contact vide ou identique. \n Veuillez corriger votre enregistrement", "Erreur", JOptionPane.ERROR_MESSAGE);
					}
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}

				
			}
			
			//Boutton home du frame interfaceContactModify
			if (e.getSource()==getBoutonHome()){
				//S�rialisation des contacts pr�sents dans la liste
				try {
					UploadDataContact(list);
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				//instantiation nouvelle fen�tre
				FramePrincipal menuPrincipal = new FramePrincipal();
				menuPrincipal.setVisible(true);
				//fermeture de la f�netre actuelle
				dispose();
			}
			
			if (e.getSource()==getBoutonOff()){
				//S�rialisation des contacts pr�sents dans la liste
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
	
	
	/**
	 * M�thode de s�rialisation des contacts permettant de s�rialiser les enregistrements de contact dans le smartphone
	 * @param listcontact
	 * @throws IOException
	 */
		private static void UploadDataContact(ArrayList<Contact> listcontact) throws IOException {
			
			for (int i = 0; i < listcontact.size(); i++) {
				 FileOutputStream out = new FileOutputStream("./BDD_Contact/" + listcontact.get(i).getLastName()+listcontact.get(i).getFirstName()+".ser");
				 ObjectOutputStream oos = new ObjectOutputStream( out );
				 oos.writeObject(listcontact.get(i));
				 oos.close(); 
			}
			
				
		}
	
	
}
