// SUPPRIMER SUPPRIMER SUPPRIMER
package frameGraphique;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JPanel;

public class FrameGallerieSelect extends FrameGeneral {
	  
	  //stocker le nombre de photos
	 private int nombrePhotos;
	 private File folder = new File("./ImagesGallerie/");
	  
	  //Boutton avancer et reculer
	  private JButton next = new JButton(new ImageIcon(getClass().getResource("/next.png")));
	  private JButton preview = new JButton(new ImageIcon(getClass().getResource("/previous.png")));
	  private JButton addPhoto = new JButton("+");

	 private JPanel gallerie = new JPanel();

	  private ArrayList<JButton> listePhoto = new ArrayList<JButton>();
	  
	  //1 = 15 premi�re photo, 2 photo 16 � 30...
	  private int noPage;
	  private int t;
	  
	  public FrameGallerieSelect(int n){
		  this.noPage = n;
		  add(gallerie);
		  gallerie.setLayout(null);
		  gallerie.setBounds(40, 40, 350, 550);

		  //compte le nombre de photos dans ImagesGallerie
		  File[] list = folder.listFiles();
		  nombrePhotos = list.length;
		  
		  //Ajout �couteurs
		  Ecouteurs ecouteur = new Ecouteurs();
		  getBoutonHome().addActionListener(ecouteur);
		  getBoutonOff().addActionListener(ecouteur);
		  //teste pour d�terminer le nombre de pages
		  t=nombrePhotos/15;
		  //ajout du bouton suivant
		  //si les pages sont compl�tes
		  if(t*15==nombrePhotos){
			  if(noPage<t){
				  add(next);
				  next.setContentAreaFilled(false);
				  next.setBorder(null);
				  next.addActionListener(ecouteur);
				  next.setBounds(300, 590, 70, 40);
			  }
		  }
		  
		  //ajout du bouton suivant et pr�c�dent
		  if(t*15!=nombrePhotos){
			  if(noPage<t+1){
				  add(next);
				  next.setContentAreaFilled(false);
				  next.setBorder(null);
				  next.addActionListener(ecouteur);
				  next.setBounds(300, 590, 70, 40);
			  } else{
				  add(preview);
				  preview.setContentAreaFilled(false);
				  preview.setBorder(null);
				  preview.addActionListener(ecouteur);
				  preview.setBounds(30, 590, 70, 40);
			  }
		  }
		  
		  add(addPhoto);
		  addPhoto.addActionListener(ecouteur);
		  addPhoto.setBounds(150,590,70,40);
		  
		  //instancie les photos de ImagesGallerie et les mets dans la grille
		int k=(noPage-1)*15;
		int y =0;
		 
		for(int j = 0; j< 5 ;j++){
		  for (int i = 0; i < 3; i++) {
			  if(k<nombrePhotos){
			  listePhoto.add(new JButton(new ImageIcon(list[k].getPath())));
			  listePhoto.get(y).setBounds(5+i*105, 5+j*105, 100, 100);
			  Ecouteur ecouteur_photo = new Ecouteur(list, k);
			  listePhoto.get(y).addActionListener(ecouteur_photo);
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
					FrameGallerie gallerie = new FrameGallerie(noPage+1,1);
					gallerie.setVisible(true);
					dispose();
				}
				
				if (e.getSource()==preview){
					FrameGallerie gallerie = new FrameGallerie(noPage-1,1);
					gallerie.setVisible(true);
					dispose();
				}
				
				if(e.getSource()==addPhoto){
					JFileChooser chooser = new JFileChooser(); 
					chooser.setCurrentDirectory(new File("/")); 
					chooser.changeToParentDirectory(); 
					chooser.showOpenDialog(null);
					int valeuretour = chooser.showSaveDialog(gallerie);
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
		
		public class Ecouteur implements ActionListener{
			public Ecouteur(File [] list, int k){// int k ){//, path ?, File ?) {
				
			}
			@Override
			public void actionPerformed(ActionEvent e) {
				FrameDefile defile ;
				//defile.setVisible(true);
				System.out.println();
				dispose();
			}
			
		}
}
