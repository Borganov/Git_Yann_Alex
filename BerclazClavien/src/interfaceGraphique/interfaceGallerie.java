package interfaceGraphique;

import java.awt.Component;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.util.ArrayList;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class interfaceGallerie extends interfaceGeneral {

	
	
	  JPanel panel = new JPanel(new GridLayout(0,1));

	  JButton a = new JButton(new ImageIcon(getClass().getResource("/1.jpg")));

	 
	
	  public interfaceGallerie(){
		 
		
		  add(panel);

		  panel.add(a);

		  panel.setBounds(30, 30, 340, 610);
	}
}
