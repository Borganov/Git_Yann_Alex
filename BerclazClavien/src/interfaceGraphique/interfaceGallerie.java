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
import java.awt.Rectangle;
import java.awt.image.BufferedImage;
import java.io.File;
import java.util.ArrayList;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.Scrollable;

public class interfaceGallerie extends interfaceGeneral {
	  
	  //stocker le nombre de photos
	  int nombrePhotos;
	  File folder = new File("./ImagesGallerie/");
	  

	  JPanel gallerie = new JPanel();

	  private ArrayList<JButton> listePhoto = new ArrayList<JButton>();
	  
	  //1 = 15 première photo, 2 photo 16 à 30...
	  private int noPage;

	  public interfaceGallerie(int n){
		  this.noPage = n;
		  add(gallerie);
		  gallerie.setLayout(null);
		  gallerie.setBounds(10, 10, 350, 600);

		  //compte le nombre de photos dans ImagesGallerie
		  File[] list = folder.listFiles();
		  nombrePhotos = list.length;
		  
		  
		  //instancie les photos de ImagesGallerie et les mets dans la grille
		 int k=(noPage-1)*15;
		 int y =0;
		 
		for(int j = 0; j< 5 ;j++){
		  for (int i = 0; i < 3; i++) {
			  if(k<nombrePhotos){
			  listePhoto.add(new JButton(new ImageIcon(list[k].getPath())));
			  listePhoto.get(y).setBounds(5+i*105, 5+j*105, 100, 100);
			  gallerie.add(listePhoto.get(y));
			  k++;
			  y++;
			  }
		  }
		}
		
	}

}
