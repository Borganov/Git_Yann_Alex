package frameGraphique;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JPanel;

import frameGraphique.FrameGallerie.Ecouteurs;

public class FrameDefile extends FrameGeneral{
	JPanel panelCenter = new JPanel();

	
	public FrameDefile(File [] list, int k, int noPage){
		
		JButton photo = new JButton((new ImageIcon(list[k].getPath())));
		
		add(panelCenter, BorderLayout.CENTER);
		panelCenter.setBounds(20, 20, 350, 600);

		panelCenter.add(photo);
		photo.setBounds(20,20,350,600);
		//panelCenter.setBackground(Color.RED);
		
		  Ecouteurs ecouteur = new Ecouteurs();
		  getBoutonHome().addActionListener(ecouteur);
		  getBoutonOff().addActionListener(ecouteur);
	}

	public class Ecouteurs implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			
		if (e.getSource()==getBoutonHome()){
			//instantiation nouvelle fenêtre
			FramePrincipal menuPrincipal = new FramePrincipal();
			menuPrincipal.setVisible(true);
			//fermeture de la fênetre actuelle
			dispose();
		}
		
		if (e.getSource()==getBoutonOff()){
			//éteindre le téléphone
			dispose();
			}
		}
	}
}


