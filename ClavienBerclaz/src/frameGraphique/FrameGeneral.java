package frameGraphique;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.LayoutManager;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;


//squelette du t�l�phone

public abstract class FrameGeneral extends JFrame{
	
	private JPanel panelNorth = new JPanel();
	private JPanel panelSouth = new JPanel();
	private JPanel panelEast = new JPanel();
	private JPanel panelWest = new JPanel();
	
	private JButton boutonHome = new JButton("");
	private JButton boutonOff = new JButton("");
	
	// getters et setters pour les boutons Home et Off
	public JButton getBoutonHome() {
		return boutonHome;
	}

	public void setBoutonHome(JButton boutonHome) {
		this.boutonHome = boutonHome;
	}

	public JButton getBoutonOff() {
		return boutonOff;
	}

	public void setBoutonOff(JButton boutonOff) {
		this.boutonOff = boutonOff;
	}


	public FrameGeneral(){
	
		//enl�ve les boutons de contr�le
		setUndecorated(true);
		//dimentionne la fen�tre
		setSize(400,700);
		//la fen�tre appara�t au centre de l'�cran
		setLocationRelativeTo(null);
		//pour pouvoir ajuster nous m�me les dimentions des JPanel
		setLayout(null);
		
		//ajout de bordur noir pour simuler un smartphone	

		add(panelEast, BorderLayout.EAST);
		panelEast.setBounds(390, 10, 10, 680);
		panelEast.setBackground( Color.BLACK);
		
		add(panelWest, BorderLayout.WEST);
		panelWest.setBounds(0, 10, 10, 680);
		panelWest.setBackground( Color.BLACK);
		
		add(panelNorth, BorderLayout.NORTH);
		panelNorth.setBounds(0, 0, 400, 10);
		panelNorth.setBackground( Color.BLACK);
		panelNorth.setLayout(null);
		
		add(panelSouth, BorderLayout.SOUTH);
		panelSouth.setBounds(0, 660, 400, 40);
		panelSouth.setBackground(Color.BLACK);
		
		
		//ajout du bouton home
		panelSouth.add(boutonHome);
		//dimensionner le bouton home
		boutonHome.setPreferredSize(new Dimension (75, 30));
		//couleur du bouton home
		boutonHome.setBackground(Color.BLACK);
		

		//ajout du bouton off
		panelNorth.add(boutonOff);
		//couleur du bouton off
		boutonOff.setBackground(Color.BLACK);
		//placement du bouton
		boutonOff.setBounds(320, 3, 50, 5);
	}
	
}



