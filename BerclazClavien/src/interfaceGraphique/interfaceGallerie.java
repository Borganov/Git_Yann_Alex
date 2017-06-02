package interfaceGraphique;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.Insets;
import java.awt.image.BufferedImage;
import java.util.ArrayList;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

public class interfaceGallerie extends interfaceGeneral {

	
	
	  JPanel gallerie = new JPanel(new GridBagLayout());
	 // JScrollPane scroll = new JScrollPane(panel);
	  
	  ///Le gridBagConstraints va définir la position et la taille des éléments
	  GridBagConstraints gc = new GridBagConstraints();
	 
	  JButton a = new JButton(new ImageIcon(getClass().getResource("/1.jpg")));
	  JButton b = new JButton(new ImageIcon(getClass().getResource("/1.jpg")));
	  JButton c = new JButton(new ImageIcon(getClass().getResource("/1.jpg")));
	  JButton d = new JButton(new ImageIcon(getClass().getResource("/1.jpg")));
	  JButton e = new JButton(new ImageIcon(getClass().getResource("/1.jpg")));
	  JButton f = new JButton(new ImageIcon(getClass().getResource("/1.jpg")));
	  JButton g = new JButton(new ImageIcon(getClass().getResource("/1.jpg")));
	  JButton h = new JButton(new ImageIcon(getClass().getResource("/1.jpg")));
	
	  public interfaceGallerie(){
		  
		  // remplir en horizontal
		  gc.fill = GridBagConstraints.HORIZONTAL;
		  //marge entre les composants
		  gc.insets = new Insets(5,5,5,5);
		  // nombre de lignes
		  gc.weightx = 3;
		  // nombre de colonnes
		  gc.weighty = 3;
		  
		  a.setMaximumSize(new Dimension(100,100));
		  a.setMinimumSize(new Dimension(100,100));
		  
		  
		  b.setMaximumSize(new Dimension(100,100));
		  b.setMinimumSize(new Dimension(100,100));
		  
		 // ImageIcon("tonImage.jpg").getImage().getScaledInstance(20, 20, Image.SCALE_DEFAULT));
		  
		  
		  gallerie.add(a);
		  gallerie.add(b);


		  add(gallerie);

	  
		 //placement de la gallerie
		 gallerie.setBounds(30, 30, 340, 610);

	}
}
