package frameGraphique;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JPanel;

public class FrameGallerie extends FrameGeneral {
	  
	  //stocker le nombre de photos
	  int nombrePhotos;
	  File folder = new File("./ImagesGallerie/");
	  
	  //Boutton avancer et reculer
	  JButton next = new JButton("Suivant");
	  JButton preview = new JButton("Précédent");
	  

	  JPanel gallerie = new JPanel();

	  private ArrayList<JButton> listePhoto = new ArrayList<JButton>();
	  
	  //1 = 15 première photo, 2 photo 16 à 30...
	  private int noPage;

	  public FrameGallerie(int n){
		  this.noPage = n;
		  add(gallerie);
		  gallerie.setLayout(null);
		  gallerie.setBounds(10, 10, 350, 550);

		  //compte le nombre de photos dans ImagesGallerie
		  File[] list = folder.listFiles();
		  nombrePhotos = list.length;
		  
		  //Ajout Boutton avancer et reculer
		  Ecouteurs ecouteur = new Ecouteurs();
		  add(next);
		  next.addActionListener(ecouteur);
		  next.setBounds(150, 590, 100, 20);
		  
		  add(preview);
		  preview.addActionListener(ecouteur);
		  preview.setBounds(20, 590, 120, 20);
		  
		  
		  
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
	  
		public class Ecouteurs implements ActionListener{

			@Override
			public void actionPerformed(ActionEvent e) {
				//si clique sur gallerie
				if (e.getSource()==next){
					FrameGallerie gallerie = new FrameGallerie(noPage+1);
					gallerie.setVisible(true);
					dispose();
				}
				
				if (e.getSource()==preview){
					FrameGallerie gallerie = new FrameGallerie(noPage-1);
					gallerie.setVisible(true);
					dispose();
				}
				
			}
			
		}

}
