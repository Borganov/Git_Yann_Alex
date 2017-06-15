package frameGraphique;

import java.awt.Dimension;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import javax.swing.ImageIcon;
import javax.swing.JButton;
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

	  private JPanel gallerie = new JPanel();

	  private ArrayList<JButton> listePhoto = new ArrayList<JButton>();
	  
	  //1 = 15 première photo, 2 photo 16 à 30...
	  private int noPage;
	  private int t;
	  
	  /**
	   * Constructeur de la galerie FrameGallerie
	   * @param n retourne le numéro de la page
	   * @param source 
	   */
	  
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
			  
			  }
			  
			  if(noPage!=1){
				add(previous);
				previous.setContentAreaFilled(false);
				previous.setBorder(null);
				previous.addActionListener(ecouteur);
				previous.setBounds(30, 590, 70, 40);
			  }
		  }
		  
		  //instancie les photos de ImagesGallerie et les mets dans la grille
		 int k=(noPage-1)*15;
		 int y =0;

		for(int j = 0; j< 5 ;j++){
		  for (int i = 0; i < 3; i++) {
			  if(k<nombrePhotos){
				  JButton pic = new JButton(new ImageIcon(new ImageIcon(list[k].getPath()).getImage().getScaledInstance(-1, 110, Image.SCALE_FAST)));
				  pic.setPreferredSize(new Dimension(150 ,150));
				  pic.setOpaque(false);
				  pic.setContentAreaFilled(false);
				  pic.setBorderPainted(false);
				  listePhoto.add(pic);
				  listePhoto.get(y).setBounds(5+i*105, 5+j*105, 100, 100);
				  Ecouteur ecouteur_photo = new Ecouteur(list, k, nombrePhotos, noPage);
				  listePhoto.get(y).addActionListener(ecouteur_photo);
				  gallerie.add(listePhoto.get(y));
				  k++;
				  y++;
			  }
		  }
		}
		
	}
	  /**
	   * Constructeur de la galerie FrameContactModify. Ajout d'une photo à un contact
	   * @param n
	   * @param source
	   * @param ind
	   * @param contactList
	   */
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
			  } 
			  
			  if(noPage!=1){
				  add(previous);
				  previous.setContentAreaFilled(false);
				  previous.setBorder(null);
				  previous.addActionListener(ecouteur);
				  previous.setBounds(30, 590, 70, 40);
			  }
		  }
		  
		  //instancie les photos de ImagesGallerie et les mets dans la grille
		 int k=(noPage-1)*15;
		 int y =0;
		 
		for(int j = 0; j< 5 ;j++){
		  for (int i = 0; i < 3; i++) {
			  if(k<nombrePhotos){
				  JButton pic = new JButton(new ImageIcon(new ImageIcon(list[k].getPath()).getImage().getScaledInstance(-1, 110, Image.SCALE_FAST)));
				  pic.setPreferredSize(new Dimension(150 ,150));
				  pic.setOpaque(false);
				  pic.setContentAreaFilled(false);
				  pic.setBorderPainted(false);
				  listePhoto.add(pic);
				  listePhoto.get(y).setBounds(5+i*105, 5+j*105, 100, 100);
				  Ecouteur ecouteur_photo = new Ecouteur(list, k, nombrePhotos, noPage);
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
					if(source==1){
					FrameGallerie gallerie = new FrameGallerie(noPage+1,source);
					gallerie.setVisible(true);
					dispose();
					}
					if(source==2){
						FrameGallerie gallerie = new FrameGallerie(noPage+1,source,index,contactList);
						gallerie.setVisible(true);
						dispose();
					}
				}
				
				if (e.getSource()==previous){
					if(source==1){
					FrameGallerie gallerie = new FrameGallerie(noPage-1,source);
					gallerie.setVisible(true);
					dispose();
					}
					if(source==2){
					FrameGallerie gallerie = new FrameGallerie(noPage-1,source,index,contactList);
					gallerie.setVisible(true);
					dispose();
					}
				}
				

				if (e.getSource()==getBoutonHome()){
					if(source==2){
						try {
							UploadDataContact(contactList);
						} catch (IOException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
					}
					//instantiation nouvelle fenêtre
					FramePrincipal menuPrincipal = new FramePrincipal();
					menuPrincipal.setVisible(true);
					//fermeture de la fênetre actuelle
					dispose();
				}
				
				if (e.getSource()==getBoutonOff()){
					if(source==2){
						try {
							UploadDataContact(contactList);
						} catch (IOException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
					}
					//éteindre le téléphone
					dispose();
				}
		}
			
	}

		public class Ecouteur implements ActionListener{
			File[] list;
			int k;
			int nombrePhotos;
			
			/**
			 * 
			 * @param list
			 * @param k
			 * @param nombrePhotos
			 * @param noPage
			 */
			public Ecouteur(File [] list, int k, int nombrePhotos, int noPage)
			{
				this.list = list;
				this.k = k;
				this.nombrePhotos=nombrePhotos;
			}

			public void actionPerformed(ActionEvent e) {
				if(source==1){
					FrameDefile defile = new FrameDefile(list, k, nombrePhotos, noPage);
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
		
		
		/**
		 * Méthode de sérialisation des contacts
		 * @param listcontact
		 * @throws IOException
		 */
		private static void UploadDataContact(ArrayList<Contact> listcontact) throws IOException {
			
			for (int i = 0; i < listcontact.size(); i++) {
				 FileOutputStream out = new FileOutputStream("./BDD_Contact/" + listcontact.get(i).getLastName()+listcontact.get(i).getFirstName()+".ser");
				 ObjectOutputStream oos = new ObjectOutputStream( out );
				 oos.writeObject(listcontact.get(i));
				 oos.close(); 
			}
									
		}
}
