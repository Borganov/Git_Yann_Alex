package frameGraphique;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.List;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JPanel;

import contact.Contact;

public class FrameGallerie extends FrameGeneral {
	  
	  //stocker le nombre de photos
	 private int nombrePhotos;
	 private File folder = new File("./ImagesGallerie/");
	 private int source ; // 1 pour Gallerie, 2 pour Contact
	 private int index;
	 private ArrayList<Contact> contactList = new ArrayList<Contact>();
	  
	  //Boutton avancer et reculer
	  private JButton next = new JButton(new ImageIcon(getClass().getResource("/next.png")));
	  private JButton previous = new JButton(new ImageIcon(getClass().getResource("/previous.png")));
	  private JButton addPhoto = new JButton("+");

	  private JPanel gallerie = new JPanel();

	  private ArrayList<JButton> listePhoto = new ArrayList<JButton>();
	  
	  //1 = 15 première photo, 2 photo 16 à 30...
	  private int noPage;
	  private int t;
	  
	  public FrameGallerie(int n, int source){
		  this.source = source;
		  this.noPage = n;
		  add(gallerie);
		  gallerie.setLayout(null);
		  gallerie.setBounds(40, 40, 350, 550);

		  //compte le nombre de photos dans ImagesGallerie
		  File[] list = folder.listFiles();
		  nombrePhotos = list.length;
		  
		  //Ajout écouteurs
		  Ecouteurs ecouteur = new Ecouteurs();
		  getBoutonHome().addActionListener(ecouteur);
		  getBoutonOff().addActionListener(ecouteur);
		  //teste pour déterminer le nombre de pages
		  t=nombrePhotos/15;
		  //ajout du bouton suivant
		  //si les pages sont complètes
		  if(t*15==nombrePhotos){
			  if(noPage<t){
				  add(next);
				  next.setContentAreaFilled(false);
				  next.setBorder(null);
				  next.addActionListener(ecouteur);
				  next.setBounds(300, 590, 70, 40);
			  }
		  }
		  //ajout du bouton suivant et précédent
		  if(t*15!=nombrePhotos){
			  if(noPage<t+1){
				  add(next);
				  next.setContentAreaFilled(false);
				  next.setBorder(null);
				  next.addActionListener(ecouteur);
				  next.setBounds(300, 590, 70, 40);
			  } else{
				  add(previous);
				  previous.setContentAreaFilled(false);
				  previous.setBorder(null);
				  previous.addActionListener(ecouteur);
				  previous.setBounds(30, 590, 70, 40);
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
			  Ecouteur ecouteur_photo = new Ecouteur(list, k, noPage);
			  listePhoto.get(y).addActionListener(ecouteur_photo);
			  gallerie.add(listePhoto.get(y));
			  k++;
			  y++;
			  }
		  }
		}
		
	}
	  
	  public FrameGallerie(int n, int source, int ind, ArrayList<Contact> contactList){
		  this.source = source;
		  this.noPage = n;
		  this.contactList=contactList;
		  this.index = ind;
		  
		  add(gallerie);
		  gallerie.setLayout(null);
		  gallerie.setBounds(40, 40, 350, 550);

		  //compte le nombre de photos dans ImagesGallerie
		  File[] list = folder.listFiles();
		  nombrePhotos = list.length;
		  
		  //Ajout écouteurs
		  Ecouteurs ecouteur = new Ecouteurs();
		  getBoutonHome().addActionListener(ecouteur);
		  getBoutonOff().addActionListener(ecouteur);
		  //teste pour déterminer le nombre de pages
		  t=nombrePhotos/15;
		  //ajout du bouton suivant
		  //si les pages sont complètes
		  if(t*15==nombrePhotos){
			  if(noPage<t){
				  add(next);
				  next.setContentAreaFilled(false);
				  next.setBorder(null);
				  next.addActionListener(ecouteur);
				  next.setBounds(300, 590, 70, 40);
			  }
		  }
		  //ajout du bouton suivant et précédent
		  if(t*15!=nombrePhotos){
			  if(noPage<t+1){
				  add(next);
				  next.setContentAreaFilled(false);
				  next.setBorder(null);
				  next.addActionListener(ecouteur);
				  next.setBounds(300, 590, 70, 40);
			  } else{
				  add(previous);
				  previous.setContentAreaFilled(false);
				  previous.setBorder(null);
				  previous.addActionListener(ecouteur);
				  previous.setBounds(30, 590, 70, 40);
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
			  Ecouteur ecouteur_photo = new Ecouteur(list, k, noPage);
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
					FrameGallerie gallerie = new FrameGallerie(noPage+1,source);
					gallerie.setVisible(true);
					dispose();
				}
				
				if (e.getSource()==previous){
					FrameGallerie gallerie = new FrameGallerie(noPage-1,source);
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
		
		public class Ecouteur implements ActionListener{
			File[] list;
			int k;
			int noPage;
			
			public Ecouteur(File [] list, int k, int noPage)
			{
				this.list = list;
				this.k = k;
				this.noPage=noPage;
				
			}
			
			public void actionPerformed(ActionEvent e) {
				if(source==1){
					FrameDefile defile = new FrameDefile(list, k, noPage);
					defile.setVisible(true);
					dispose();
				}
				
				if(source==2){
					
					contactList.get(index).setprofilPath(list[k].getPath());
					FrameContactModify contactMod = null;
					try {
						contactMod = new FrameContactModify(index, contactList);
						
					} catch (IOException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					contactMod.setVisible(true);
					dispose();	
				}
			}
			
		}
}
