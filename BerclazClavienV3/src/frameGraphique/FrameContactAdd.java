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
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import contact.Contact;
import frameGraphique.FrameContactModify.Ecouteurs;

public class FrameContactAdd extends FrameGeneral{
	
	JLabel civiliteL = new JLabel("Civilité :");
	JLabel firstnameL = new JLabel("Prénom :");
	JLabel lastnameL = new JLabel("Nom :");
	JLabel phoneL = new JLabel("N° de téléphone :");
	JLabel title = new JLabel("Nouveau contact");
	
	JTextField firstnameF = new JTextField();
	JTextField lastnameF = new JTextField();
	JTextField phoneF = new JTextField();
	String[] civiliteList = {"Monsieur", "Madame"};
	JComboBox<String> civiliteC = new JComboBox<String>(civiliteList);
	
	JButton save = new JButton("Sauvegarder");
	JButton cancel = new JButton("Annuler");
	JButton photoMod = new JButton(new ImageIcon(getClass().getResource("/modify.png")));
	
	private ArrayList<Contact> list;
	private Contact futurContact = new Contact();
	
	FrameContactAdd( ArrayList<Contact> l){
		list = l;
		Font titleFont = new Font("Verdanan", Font.BOLD, 24);
		Font subtitleFont= new Font("Verdana",Font.BOLD,13);
		Font contentFont = new Font("Verdana",Font.BOLD,12);
		
		
		Font subtitle= new Font("Verdana",Font.BOLD,13);//SUP
		Font content = new Font("Verdana",Font.BOLD,12);//SUP
		//Ajout du titre de la fenêtre
		add(title);
		title.setBounds(100,30,300,20);
		title.setFont(titleFont);
		title.setHorizontalTextPosition(SwingConstants.CENTER);
		title.setVerticalTextPosition(SwingConstants.BOTTOM);
				
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
		JButton btnpic = new JButton(new ImageIcon(new ImageIcon("/profil.jpg").getImage().getScaledInstance(-1, 110, Image.SCALE_FAST)));
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
		firstnameF.setFont(contentFont);
		//Ajout field nom
		add(lastnameF);
		lastnameF.setBounds(170,305, 200, 30); //axe x, axe y, largeur, hauteur
		lastnameF.setFont(contentFont);
		//Ajout field téléphone
		add(phoneF);
		phoneF.setBounds(170,335, 200, 30); //axe x, axe y, largeur, hauteur
		phoneF.setFont(contentFont);
				
		//Ajout ComboBox Civilité
		add(civiliteC);
		civiliteC.setBounds(170,245, 200, 27); //axe x, axe y, largeur, hauteur
		civiliteC.setFont(contentFont);
		civiliteC.setSelectedItem(null);
		
		//Ajout boutton sauvegarder
		add(save);
		save.setBounds(50, 600, 120, 20);
		save.addActionListener(ecouteur);
		
		//Ajout boutton annuler
		add(cancel);
		cancel.setBounds(200, 600, 120, 20);
		cancel.addActionListener(ecouteur);
		
		//Ajout écouteurs
		getBoutonHome().addActionListener(ecouteur);
		getBoutonOff().addActionListener(ecouteur);
		
	}
	
	public class Ecouteurs implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			//si clique sur sauvegarder
			if (e.getSource()==save){
				boolean controlResponse;
				
				futurContact.setprofilPath("./ImagesGallerie/27.jpg");
				futurContact.setFirstName(firstnameF.getText());
				futurContact.setLastName(lastnameF.getText());
				futurContact.setPhoneNumber(phoneF.getText());
				futurContact.setCivilite((String)civiliteC.getSelectedItem());
				
				controlResponse = futurContact.contactControl(list);
				
				if(controlResponse == true){

					list.add(futurContact);
				
					FrameContactList interfaceContacts = null;
					try {
						interfaceContacts = new FrameContactList(list);
					} catch (ClassNotFoundException | IOException e1) {
						//TODO Auto-generated catch block
						e1.printStackTrace();
					}
					interfaceContacts.setVisible(true);
					//fermeture fenêtre actuelle
					dispose();
				
				}
				else
				{
					//Message d'erreur en cas de problème de contact déjà existant.
					JOptionPane.showMessageDialog(null, "Deux contacts portent le même nom. \n Veuillez corriger votre enregistrement", "Erreur", JOptionPane.ERROR_MESSAGE);
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
				//fermeture fenêtre actuelle
				dispose();
				
			}
			
			//Boutton modifier photo
			if (e.getSource()==photoMod){
				
				//System.out.println(list.lastIndexOf(list)+1);
				futurContact.setprofilPath("./ImagesGallerie/27.jpg");
				futurContact.setFirstName(firstnameF.getText());
				futurContact.setLastName(lastnameF.getText());
				futurContact.setPhoneNumber(phoneF.getText());
				futurContact.setCivilite((String)civiliteC.getSelectedItem());
				
				list.add(futurContact);
				int ind  = list.lastIndexOf(list)+1;
				
				
				FrameGallerie selectPicture = null;
				selectPicture = new FrameGallerie(1,2,ind,list);
				selectPicture.setVisible(true);
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
