package frameGraphique;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.SwingConstants;



public class FramePrincipal extends FrameGeneral {
	
	//cr�ation du bouton contact avec image
	private JButton contacts = new JButton(new ImageIcon(getClass().getResource("/contacts.png")));
	//cr�ation du bouton gallerie avec image
	private JButton gallerie = new JButton(new ImageIcon(getClass().getResource("/GalleriePhoto.png")));


	public FramePrincipal(){
		
		//ajout du bouton contact
		add(contacts);
		//placement du bouton sur l'�cran
		contacts.setBounds(30, 30, 100, 120); //axe x, axe y, largeur, hauteur
		//enlever le fond opaque du bouton
		contacts.setContentAreaFilled(false);
		//enlever les bordures du boutton
		contacts.setBorder(null);
		//ajout de l'intitul� du boutton
		contacts.setText("Contacts");
		//placement de l'intitul� sous le bouton
		contacts.setVerticalTextPosition(SwingConstants.BOTTOM); 
		contacts.setHorizontalTextPosition(SwingConstants.CENTER);


		//ajout du bouton gallerie
		add(gallerie);
		//placement du bouton sur l'�cran
		gallerie.setBounds(170, 30, 100, 120); //axe x, axe y, largeur, hauteur
		//enlever le fond opaque du bouton
		gallerie.setContentAreaFilled(false);
		//enlever les bordures du boutton
		gallerie.setBorder(null);
		//ajout de l'intitul� du boutton
		gallerie.setText("Gallerie");
		//placement de l'intitul� sous le bouton
		gallerie.setVerticalTextPosition(SwingConstants.BOTTOM); 
		gallerie.setHorizontalTextPosition(SwingConstants.CENTER);
		
		//ajout des listener
		Ecouteurs ecouteur = new Ecouteurs();
		contacts.addActionListener(ecouteur);
		gallerie.addActionListener(ecouteur);
		getBoutonHome().addActionListener(ecouteur);
		getBoutonOff().addActionListener(ecouteur);
	}
	
	public class Ecouteurs implements ActionListener{
		//d�finition du clique sur les bouton contacts et gallerie
		public void actionPerformed(ActionEvent e){
			//si clique sur contacts
			if (e.getSource()==contacts){
				//instantiation fen�tre contacts
				FrameContactList interfaceContacts = null;
				try {
					interfaceContacts = new FrameContactList();
				} catch (ClassNotFoundException | IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				interfaceContacts.setVisible(true);
				//fermeture fen�tre actuelle
				dispose();
			}
			//si clique sur gallerie
			if (e.getSource()==gallerie){
				//instantiation fen�tre gallerie
				FrameGallerie interfaceGallerie = new FrameGallerie(1,1);
				interfaceGallerie.setVisible(true);
				//fermeture fen�tre actuelle
				dispose();

			}
			
			if (e.getSource()==getBoutonHome()){
				//instantiation nouvelle fen�tre
				FramePrincipal menuPrincipal = new FramePrincipal();
				menuPrincipal.setVisible(true);
				//fermeture de la f�netre actuelle
				dispose();
			}
			
			if (e.getSource()==getBoutonOff()){
				//�teindre le t�l�phone
				dispose();
			}
		
		}
	}

}