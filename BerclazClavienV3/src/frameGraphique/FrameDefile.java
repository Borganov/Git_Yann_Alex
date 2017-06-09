package frameGraphique;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JPanel;

import frameGraphique.FrameGallerie.Ecouteur;
import frameGraphique.FrameGallerie.Ecouteurs;

public class FrameDefile extends FrameGeneral{
	
	private JPanel panelPhoto = new JPanel();
	private JPanel panelBoutons = new JPanel();

	private JButton next = new JButton(new ImageIcon(getClass().getResource("/next.png")));
	private JButton previous = new JButton(new ImageIcon(getClass().getResource("/previous.png"))); 
	private JButton delete = new JButton(new ImageIcon(getClass().getResource("/delete.png")));

	
	public FrameDefile(File [] list, int k, int nombrePhotos){
		
		//JButton photo = new JButton((new ImageIcon(list[k].getPath())));
		
		  JButton photo = new JButton(new ImageIcon(new ImageIcon(list[k].getPath()).getImage().getScaledInstance(-1, 300, Image.SCALE_FAST)));
		  photo.setPreferredSize(new Dimension(150 ,150));
		  photo.setOpaque(false);
		  photo.setContentAreaFilled(false);
		  photo.setBorderPainted(false);
	
		add(panelPhoto, BorderLayout.CENTER);
		panelPhoto.setLayout(null);
		panelPhoto.setBounds(25, 20, 350, 550);

		add(panelBoutons, BorderLayout.CENTER);
		panelBoutons.setLayout(null);
		panelBoutons.setBounds(25,550,350,100);
	
		panelPhoto.add(photo);
		photo.setBounds(0, 0, 350, 550);
		photo.setBorder(null);
		photo.setContentAreaFilled(false);
		
		panelBoutons.add(delete);
		delete.setLayout(null);
		delete.setBounds(135, 40, 70, 40);
		delete.setBorder(null);
		delete.setContentAreaFilled(false);
		
		if(k>0){
			panelBoutons.add(previous);
			previous.setLayout(null);
			previous.setBounds(25, 40, 70, 40);
			previous.setBorder(null);
			previous.setContentAreaFilled(false);
		}

		if(k<nombrePhotos-1){
			panelBoutons.add(next);
			next.setLayout(null);
			next.setBounds(250, 40, 70, 40);
			next.setBorder(null);
			next.setContentAreaFilled(false);
		}


		Ecouteurs ecouteur = new Ecouteurs(list, k, nombrePhotos);
		getBoutonHome().addActionListener(ecouteur);
		getBoutonOff().addActionListener(ecouteur);
		next.addActionListener(ecouteur);
		previous.addActionListener(ecouteur);
		delete.addActionListener(ecouteur);
	}

	public class Ecouteurs implements ActionListener{

		File[] list;
		int k;
		int nombrePhotos;
		public Ecouteurs(File [] list, int k, int nombrePhotos){
			
			this.list = list;
			this.k = k;
			this.nombrePhotos=nombrePhotos;
		}
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
		if(e.getSource()==next){
			FrameDefile defile = new FrameDefile(list, k+1, nombrePhotos);
			defile.setVisible(true);
			dispose();
			}
		if(e.getSource()==previous){
			FrameDefile defile = new FrameDefile(list, k-1, nombrePhotos);
			defile.setVisible(true);
			dispose();
			}
		}
	}
}


