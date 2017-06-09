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
	
	private JPanel panelPhoto = new JPanel();
	private JPanel panelBoutons = new JPanel();

	private JButton next = new JButton(new ImageIcon(getClass().getResource("/next.png")));
	private JButton previous = new JButton(new ImageIcon(getClass().getResource("/previous.png"))); 

	
	public FrameDefile(File [] list, int k, int nombrePhotos){
		
		JButton photo = new JButton((new ImageIcon(list[k].getPath())));
	
		add(panelPhoto, BorderLayout.CENTER);
		panelPhoto.setLayout(null);
		panelPhoto.setBounds(25, 20, 350, 550);

		
		add(panelBoutons, BorderLayout.CENTER);
		panelBoutons.setLayout(null);
		panelBoutons.setBounds(25,550,350,100);


		panelPhoto.add(photo);
		photo.setBounds(0, 0, 350, 550);
		
		panelBoutons.add(previous);
		previous.setLayout(null);
		previous.setBounds(25, 40, 70, 40);
		
		panelBoutons.add(next);
		next.setLayout(null);
		next.setBounds(250, 40, 70, 40);

		Ecouteurs ecouteur = new Ecouteurs(list, k, nombrePhotos);
		getBoutonHome().addActionListener(ecouteur);
		getBoutonOff().addActionListener(ecouteur);
		next.addActionListener(ecouteur);
		previous.addActionListener(ecouteur);
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


