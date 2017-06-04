package interfaceGraphique;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Container;
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
	  
	  JPanel panelCenter = new JPanel();

	  // grille pour afficher les photos
	  JPanel gallerie = new JPanel(new GridBagLayout());

	  private ArrayList<JButton> listePhoto = new ArrayList<JButton>();
	  
	  
	  JScrollPane scroll = new JScrollPane(panelCenter);
	 
	  
	  ///Le gridBagConstraints va d�finir la position et la taille des �l�ments
	  GridBagConstraints gc = new GridBagConstraints();

	  
	  public interfaceGallerie(){
		
		add(panelCenter, BorderLayout.CENTER);
		panelCenter.setBounds(10,10,380,650);
		panelCenter.setLayout(null);
		  //ajout de la gallerie
		panelCenter.add(gallerie);
		gallerie.setLayout(null);
		 //placement de la gallerie
		gallerie.setBounds(30, 30, 340, 610);
		panelCenter.add(scroll);
		scroll.setBounds(10, 10, 10, 630);
		scroll.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
		  //compte le nombre de photos dans ImagesGallerie
		  File[] list = folder.listFiles();
		  nombrePhotos = list.length;
		  
		  //instancie les photos de ImagesGallerie et les mets dans la grille
		 int k=0;
		for(int j = 0; j<nombrePhotos/3;j++){
		  for (int i = 0; i < 3; i++) {	  
			  listePhoto.add(new JButton(new ImageIcon(list[k].getPath())));
			  listePhoto.get(k).setBounds(5+i*105, 5+j*105, 100, 100);
			  gallerie.add(listePhoto.get(k));
			  k++;
		  }
		}
		

	}
}
