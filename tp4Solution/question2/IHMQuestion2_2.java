package question2;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class IHMQuestion2_2 extends JFrame {

    private JButton boutonA = new JButton("A");
    private JButton boutonB = new JButton("B");
    private JButton boutonC = new JButton("C");

    private TextArea contenu = new TextArea(30, 80);

 
    public IHMQuestion2_2() {
        super("IHM Question2_2");
        JPanel enHaut = new JPanel();
        enHaut.add(boutonA,BorderLayout.WEST);
        enHaut.add(boutonB,BorderLayout.CENTER);
        enHaut.add(boutonC,BorderLayout.EAST);
        setLayout(new BorderLayout(5, 5));
        add("North", enHaut);
        add("Center", contenu); // contenu sera transmis aux observateurs, voir
                                // la description des constructeurs
        setLocation(150,150);pack();show();
        enHaut.setBackground(Color.magenta);
        
        JButtonObserver jbo1=new JButtonObserver("jbo1",contenu);
        boutonA.addActionListener(jbo1);
        boutonA.setActionCommand( "A" );
        JButtonObserver jbo2=new JButtonObserver("jbo2",contenu);
        boutonA.addActionListener(jbo2);
        JButtonObserver jbo3=new JButtonObserver("jbo3",contenu);
        boutonA.addActionListener(jbo3);
       
       
        JButtonObserver jbo4=new JButtonObserver("jbo4",contenu);
        boutonB.addActionListener(jbo4);
        boutonB.setActionCommand( "B" );
        JButtonObserver jbo5=new JButtonObserver("jbo5",contenu);
        boutonB.addActionListener(jbo5);
       
        JButtonObserver jbo6=new JButtonObserver("jbo6",contenu); 
        boutonC.addActionListener(jbo6);
        boutonC.setActionCommand( "C" );
        
        // Ãpour la question 2_2 (JMouseObserver)
        JMouseObserver jmo1=new JMouseObserver("jmo1",contenu);   // le bouton A a 1 observateur jmo1
        boutonA.addMouseListener(jmo1);
        
        JMouseObserver jmo2=new JMouseObserver("jmo2",contenu);   // le bouton B a 1 observateur jmo2
        boutonB.addMouseListener(jmo2);
        
        JMouseObserver jmo3=new JMouseObserver("jmo3",contenu);      // le bouton C a 1 observateur jmo3
        boutonC.addMouseListener(jmo3);
       
    }
    
     public static void main(String[] args){
        new IHMQuestion2_1();
        new IHMQuestion2_2();
    }


}
