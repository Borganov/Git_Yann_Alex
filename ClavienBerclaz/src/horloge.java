/* HORLOGE , par yassine_java*/
/* Remarque :
  Quand le programme est en cours d'execution,�vitez de jouer avec la souris dans la fen�tre 
  car ca pose certains probl�mes d'affichage qu'on appelle : des probl�mes de "rafra�chissement"
  enfin ... je pense ke c'est ca le terme exacte */

import javax.swing.*;
import java.awt.event.*;
import java.awt.*;
import java.lang.*;


public class horloge extends JFrame implements Runnable{  
/* deux fa�ons de cr�er un thread:
  - Cr�ation d'un objet qui h�rite de la classe Thread
  - Execution de la primitive new Thread() sur un objet qui impl�mente l'interface Runnable
    (et c'est ce k'on a fait dans ce programme)  */
   
       
       //- L'ecouteur de la fen�tre
     class EF extends WindowAdapter //qd on quitte la fenetre
      {
        public void windowClosing(WindowEvent e)
        {JOptionPane.showMessageDialog(null,"Merci pour votre petite visite - yassine_java");}
      }//-------------------------
   
    Thread h;          //d�claration du thread h 
    public void run()  //la m�thode vertuelle run() est obligatoire (voir cours "les threads" !!!) 
   {
       while(true)
       {
         try{h.sleep(1000);} //vous pouvez essayer avec "h.sleep(1)" pour bien tester le prog
         //try{h.sleep(1);}  <----------------------------------------------------------------|
         //m�thode sleep de la classe Thread : sleep (en milli-secondes)
      catch(InterruptedException e){}
      repaint();
    } 
    //repaint() : fait appel � la m�thode paint()
  
   }
   //------------------------------
   //------------------------------ 
   int x1=500,y1=200,x0=500,y0=400,x11=500,y11=200,v1,v2,i=0,j=0,heure=00,minute=00;
   int x2=500,y2=300,x22=500,y22=300,v3,v4;
   int x3=500,y3=350,x33=500,y33=350,v5,v6;
   double tm=(java.lang.Math.PI)/30;  
   /* -- "tm" c'est l'angle avec lequel les aiguilles bougent,il est calcul� en radian.
          cet angle est �gale � 6 degr�s -- */
   double y=tm;
   double tm2=tm;
   double tm3=tm;
   
   //- d�but de paint() : la m�thode qui dessine tout
   public void paint(Graphics g){
    
    //---- police et type et size du texte ----
    Font font1=new Font("Verdana",Font.PLAIN,12);
    g.setFont(font1);
    g.setColor(Color.white);
    g.drawString("horloge : yassine_java",10,50); 
    // Rq : drawString("texte",position_x,position_y);
    //----------------------------------------------
    
    //----------------------------------------------
    Font font2=new Font("Verdana",Font.PLAIN,18);
    g.setFont(font2);
    g.setColor(Color.white);        
    g.drawString("12",492,220);   
    g.drawString("3",680,405);
    g.drawString("6",495,595); 
    g.drawString("9",305,405); 
    //-----------------------------------------------
    
    //--- dessin des cercles de l'horloge
    g.setColor(Color.white);
    g.drawOval(300,200,400,400);
    g.setColor(Color.white);
    g.drawOval(325,223,350,350);
    
    //--- dessin des aiguilles -- 
    g.setColor(Color.green);  
    g.drawLine(x0,y0,x22,y22); 
     g.setColor(Color.red);  
    g.drawLine(x0,y0,x33,y33); 
    //------------------------

    //--- mouvement des aiguilles --
    g.setColor(Color.black);// pour effacer la derni�re position de l'aiguille
    g.drawLine(x0,y0,v1,v2);// et donc elle apparait comme si elle s'�tait deplac�
    
    
     x11=x1+(int)(200*(java.lang.Math.sin(tm)));
    y11=y1+(int)(200*(1-java.lang.Math.cos(tm)));
    v1=x11;v2=y11;
    g.setColor(Color.white);  
    g.drawLine(x0,y0,x11,y11); 
    i++;
    tm+=y;
    //A chaque fois l'angle de l'aiguille est chang� -- 
    //Et on calcule la nouvelle position --
     if(i==60)       //si l aiguille des secondes atteind 60 secondes  
     {               //celui des minutes doit bouger et meme chose quand 
                     // on atteind 60 minutes
    g.setColor(Color.black);  
    g.drawLine(x0,y0,v3,v4); 
    x22=x2+(int)(100*(java.lang.Math.sin(tm2)));
    y22=y2+(int)(100*(1-java.lang.Math.cos(tm2)));
    v3=x22;v4=y22;
    g.setColor(Color.green);  
    g.drawLine(x0,y0,x22,y22); 
    tm2+=y;
    i=0;
    j++;
    minute++;
     }
    
    if(j==12) 
     {
    g.setColor(Color.black);  
    g.drawLine(x0,y0,v5,v6); 
    x33=x3+(int)(50*(java.lang.Math.sin(tm3)));
    y33=y3+(int)(50*(1-java.lang.Math.cos(tm3)));
    v5=x33;v6=y33;
    g.setColor(Color.red);  
    g.drawLine(x0,y0,x33,y33); 
    tm3+=y;
    j=0;      
   }
  
   if(minute==60)           // 
   {
   heure++;
   minute=0;
   }
  
   if(heure==24) heure=0;   //retour au cas initial
   
    g.setColor(Color.BLACK);
    g.fillRect(410,70,200,60);  
    /* -- NB:j ai utilis� le r�ctangle pour pouvoir afficher correctement  
    l horloge num�rique,
    � chaque dessin du rectangle il efface le dernier affichage num�rique et donc �vite un 
    un entassemnt de chiffres les uns sur les autres -- */
                                
    g.setColor(Color.white);
    g.drawString(heure+" : "+minute+" : "+i,460,100);   //Affichage Num�rique
     
  }  
   //------------fin de la fonction paint()-------------------------------------
   
 
    public horloge(){     //constructeur
        
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);  
        /*
        le but de cette instruction est :
        lorsqu'on ferme la fen�tre graphique     
        le message suivant apparait sur la fenetre DOS :
        "Press any key to continue ..." 
        permettant ainsi de quitter facilement la fen�tre DOS
        */
    
        addWindowListener(new EF());//
        setVisible(true);   //pour que la fen�tre divienne visible !
        setSize(1024,768);  //dimensions de la fen�tre
        setBackground(Color.black);//couleur du fond(noir)
        
        h=new Thread(this);   //cr�ation
        h.start();            //m�thode de la classe Thread,pour lancer la m�thode run()
       
           }         
           
     public static void main(String [] args){
       horloge HORLOGE=new horloge();
         }
    
}