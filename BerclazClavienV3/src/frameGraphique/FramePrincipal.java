package frameGraphique;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.SwingConstants;



public class FramePrincipal extends FrameGeneral {

	//cr�ation du panel central
	private JLabel labelCenter = new JLabel(new ImageIcon(getClass().getResource("/wallpaper.jpg")));
	
	//cr�ation du bouton contact avec image
	private JButton contacts = new JButton(new ImageIcon(getClass().getResource("/contacts.png")));
	//cr�ation du bouton gallerie avec image
	private JButton gallerie = new JButton(new ImageIcon(getClass().getResource("/GalleriePhoto.png")));

	private JButton game = new JButton(new ImageIcon(getClass().getResource("/game.png")));


	public FramePrincipal(){

		
		//ajout du panel central
		add(labelCenter, BorderLayout.CENTER);
		labelCenter.setLayout(null);
		labelCenter.setBounds(10, 10, 380, 650);

		
		//ajout du bouton contact
		labelCenter.add(contacts);
		//placement du bouton sur l'�cran
		contacts.setBounds(50, 30, 100, 120); //axe x, axe y, largeur, hauteur
		//enlever le fond opaque du bouton
		contacts.setContentAreaFilled(false);
		//enlever les bordures du boutton
		contacts.setBorder(null);
		//ajout de l'intitul� du boutton
		contacts.setText("Contacts");
		//couleur du texte du bouton
		contacts.setForeground(Color.WHITE);
		//placement de l'intitul� sous le bouton
		contacts.setVerticalTextPosition(SwingConstants.BOTTOM); 
		contacts.setHorizontalTextPosition(SwingConstants.CENTER);


		//ajout du bouton gallerie
		labelCenter.add(gallerie);
		//placement du bouton sur l'�cran
		gallerie.setBounds(220, 30, 100, 120); //axe x, axe y, largeur, hauteur
		//enlever le fond opaque du bouton
		gallerie.setContentAreaFilled(false);
		//enlever les bordures du boutton
		gallerie.setBorder(null);
		//ajout de l'intitul� du boutton
		gallerie.setText("Gallerie");
		//couleur du texte du bouton
		gallerie.setForeground(Color.WHITE);
		//placement de l'intitul� sous le bouton
		gallerie.setVerticalTextPosition(SwingConstants.BOTTOM); 
		gallerie.setHorizontalTextPosition(SwingConstants.CENTER);
		
		//ajout du bouton gallerie
		labelCenter.add(game);
		//placement du bouton sur l'�cran
		game.setBounds(50, 170, 100, 120); //axe x, axe y, largeur, hauteur
		//enlever le fond opaque du bouton
		game.setContentAreaFilled(false);
		//enlever les bordures du boutton
		game.setBorder(null);
		//ajout de l'intitul� du boutton
		game.setText("Jeux");
		//couleur du texte du bouton
		game.setForeground(Color.WHITE);
		//placement de l'intitul� sous le bouton
		game.setVerticalTextPosition(SwingConstants.BOTTOM); 
		game.setHorizontalTextPosition(SwingConstants.CENTER);
		
		//ajout des listener
		Ecouteurs ecouteur = new Ecouteurs();
		contacts.addActionListener(ecouteur);
		gallerie.addActionListener(ecouteur);
		game.addActionListener(ecouteur);
		getBoutonHome().addActionListener(ecouteur);
		getBoutonOff().addActionListener(ecouteur);
		
		//Modification couleur heure
		getLabelHeure().setForeground(Color.white);

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
			
			if(e.getSource()==game){
				FrameGame game = new FrameGame(0);
				game.setVisible(true);
				dispose();

			}
		}
	}
}