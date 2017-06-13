package frameGraphique;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JLabel;
import javax.swing.JTextArea;
import javax.swing.SwingConstants;

import contact.Question;

public class FrameGame extends FrameGeneral {

	Question [] questions = new Question[10];
	
	JLabel titre = new JLabel("Quizz");
	
	JTextArea question;
	
	JLabel responseTrue = new JLabel("Bravo, prochaine question!");
	JLabel responseFalse = new JLabel("Oulalalalala, suite!");
	
	JCheckBox choice1;
	JCheckBox choice2; 
	JCheckBox choice3;
	
	JButton validate = new JButton("Valider");
	
	
	
	public FrameGame(){
		Font titleFont = new Font("Verdanan", Font.BOLD, 24);
		Font subtitleFont= new Font("Verdana",Font.BOLD,13);
		Font contentFont = new Font("Verdana",Font.BOLD,12);
		
		//Instanciation des questions
		questions[0] = new Question("Quel est le code postal du village de Venth�ne qui est un petit village se situant sur les hauts de Sierre?", "3973", "3960", "1950", 1);
		questions[1] = new Question("Combien font 2 + 2 ?", "6", "0", "2", 3);
		questions[2] = new Question("Quel est le nom de l'acteur jouant Harry Potter ?", "Sean Connery", "Tommy Lee Jones", "Daniel Radcliffe", 3);
		questions[3] = new Question("Quel est la capital de la Suisse", "Bern", "Sion", "Paris", 1);
		questions[4] = new Question("Combien font 8 / 4 + 4", "8", "6", "5", 2);
		questions[5] = new Question("Quel est la combinaison chimique du sel", "NaCl", "H2O", "O2", 1);
		questions[6] = new Question("Quel est le code postal du village de Venth�ne", "3973", "3960", "1950", 1);
		questions[7] = new Question("Quel est le code postal du village de Venth�ne", "3973", "3960", "1950", 1);
		questions[8] = new Question("Quel est le code postal du village de Venth�ne", "3973", "3960", "1950", 1);
		questions[9] = new Question("Quel est le code postal du village de Venth�ne", "3973", "3960", "1950", 1);
		
		int alea = (int)(Math.random()*(0+10));
		
		question = new JTextArea(questions[alea].getQuestion());
		choice1 = new JCheckBox("    " + questions[alea].getResponse1());
		choice2 = new JCheckBox("    " + questions[alea].getResponse2());
		choice3 = new JCheckBox("    " + questions[alea].getResponse3());
		
		//Ajout du titre du jeux
		add(titre);
		titre.setBounds(170,30,200,40);
		titre.setFont(titleFont);
		
		//Ajout de la question
		add(question);
		question.setBounds(50,100,300,40);
		question.setLineWrap(true);
		
		//ajout des checks box servant � la selection de la r�ponse
		Ecouteur ecouteur = new Ecouteur();
		add(choice1);
		choice1.setBounds(60, 180, 250, 20);
		add(choice2);
		choice2.setBounds(60, 240, 250, 20);
		add(choice3);
		choice3.setBounds(60, 300, 250, 20);
		
		
	}
	
	public class Ecouteur implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
		
			
		}
		
	}
	
	
}
