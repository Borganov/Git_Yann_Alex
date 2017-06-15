package frameGraphique;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

public class FrameWalker extends FrameGeneral{
	
	private JLabel labelCenter = new JLabel(new ImageIcon(getClass().getResource("/wallpaper.jpg")));
	
	private JLabel soft;
	private String list[] = new String[16];
	private Font start = new Font("Verdanan", Font.BOLD, 24);
	
	FrameWalker(int i){
		//ajout du panel central
		add(labelCenter, BorderLayout.CENTER);
		labelCenter.setLayout(null);
		labelCenter.setBounds(10, 10, 380, 650);
		
		list[0]="C";
		list[1]="Cl";
		list[2]="Cla";
		list[3]="Cla-";
		list[4]="Cla-B";
		list[5]="Cla-Be";
		list[6]="Cla-Ber";
		list[7]="Cla-Ber ";
		list[8]="Cla-Ber S";
		list[9]="Cla-Ber So";
		list[10]="Cla-Ber Sof";
		list[11]="Cla-Ber Soft";
		list[12]="Cla-Ber Softw";
		list[13]="Cla-Ber Softwa";
		list[14]="Cla-Ber Softwar";
		list[15]="Cla-Ber Software";
		
		soft = new JLabel(list[i]);
		labelCenter.add(soft);
		soft.setBounds(100, 230, 380, 100);
		soft.setBackground(null);
		soft.setFont(start);
		soft.setForeground(Color.white);
		
		getLabelHeure().setVisible(false);
	}	

}
