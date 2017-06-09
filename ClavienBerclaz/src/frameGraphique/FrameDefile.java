package frameGraphique;

import java.awt.BorderLayout;
import java.awt.Color;

import javax.swing.JPanel;

public class FrameDefile extends FrameGeneral{
	JPanel panelCenter = new JPanel();
	
	public FrameDefile(){
		add(panelCenter, BorderLayout.CENTER);
		panelCenter.setBounds(20, 20, 350, 600);
		//panelCenter.setBackground(Color.RED);
	}

	


}
