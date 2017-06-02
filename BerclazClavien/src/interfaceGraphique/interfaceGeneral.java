package interfaceGraphique;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.LayoutManager;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;


//squelette du téléphone

public abstract class interfaceGeneral extends JFrame{
	
	private JPanel panelNorth = new JPanel();
	private JPanel panelSouth = new JPanel();
	private JPanel panelEast = new JPanel();
	private JPanel panelWest = new JPanel();
	
	private JButton boutonHome = new JButton("");
	
	
	
	public JButton getBoutonHome() {
		return boutonHome;
	}


	public void setBoutonHome(JButton boutonHome) {
		this.boutonHome = boutonHome;
	}


	public interfaceGeneral(){
	
		//enlève les boutons de contrôle
		setUndecorated(true);
		//dimentionne la fenêtre
		setSize(400,700);
		//la fenêtre apparaît au centre de l'écran
		setLocationRelativeTo(null);
		//pour pouvoir ajuster nous même les dimentions des JPanel
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
		
		add(panelSouth, BorderLayout.SOUTH);
		panelSouth.setBounds(0, 660, 400, 40);
		panelSouth.setBackground(Color.BLACK);
		
		//ajout du bouton home
		panelSouth.add(boutonHome);
		//dimensionner un bouton
		boutonHome.setPreferredSize(new Dimension (75, 30));
		//couleur du bouton home
		boutonHome.setBackground(Color.BLACK);
		
	}
	
}


