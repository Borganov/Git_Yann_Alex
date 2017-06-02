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
import java.io.File;
import java.util.ArrayList;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

public class interfaceGallerie extends interfaceGeneral {
	  
	  //stocker le nombre de photos
	  int nombrePhotos;
	  File folder = new File("./ImagesGallerie/");
	  
	  // grille pour afficher les photos
	  JPanel gallerie = new JPanel(new GridBagLayout());
	  
	  
	 // JScrollPane scroll = new JScrollPane(panel);
	  
	  ///Le gridBagConstraints va définir la position et la taille des éléments
	  GridBagConstraints gc = new GridBagConstraints();

	  
	  public interfaceGallerie(){
		  
		  //compte le nombre de photos dans ImagesGallerie
		  File[] list = folder.listFiles();
		  nombrePhotos = list.length;
		  JButton[] listePhoto = new JButton[nombrePhotos];
			
		  for (int i = 0; i < listePhoto.length; i++) {
			  listePhoto[i] = new JButton(new ImageIcon(getClass().getResource("/1.jpg")));	
			  listePhoto[i].setBounds(10+10*i, 10+10*i, 20, 20);
			  gallerie.add(listePhoto[i]);
		}
		  

		  add(gallerie);
		  gallerie.setLayout(null);
		  
		  
		 //placement de la gallerie
		 gallerie.setBounds(30, 30, 340, 610);

	}
}
