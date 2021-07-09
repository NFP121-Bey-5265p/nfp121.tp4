package question2;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

import java.awt.TextComponent;
public class IHMQuestion2_1 extends JFrame{

    private JButton boutonA = new JButton("A");
    private JButton boutonB = new JButton("B");
    private JButton boutonC = new JButton("C");
   
    private TextArea contenu = new TextArea(30, 80);
       
    
    public IHMQuestion2_1() {
        super("IHM Question2_1");
        JPanel enHaut = new JPanel();
        
        setLayout(new BorderLayout(5, 5));
        add("North", enHaut);
        add("Center", contenu); // contenu sera transmis aux observateurs, voir la description des constructeurs
                            
        enHaut.add(boutonA,BorderLayout.WEST);
        enHaut.add(boutonB,BorderLayout.CENTER);
        enHaut.add(boutonC,BorderLayout.EAST);
        
        enHaut.setBackground(Color.blue);
        setLocation(100,100);
        pack();show();
        
       
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
       //mehode1: without using JButtonObserver class; only creating 3 instances of 3 inner classes implementing ActionListener.
       // ButtonHandlerA jbo1 = new  ButtonHandlerA();
       // ButtonHandlerB jmo1 = new ButtonHandlerB();
       // ButtonHandlerC jmo2 = new ButtonHandlerC();
       }
      
    /* mehode1: 3 inner classes implementing ActionListener.
     * private class ButtonHandlerA implements ActionListener{
        public void actionPerformed(ActionEvent event){
        contenu.appendText("observateur jbo1: clic du boutonA"+"\n");
        contenu.appendText("observateur jbo2: clic du boutonA"+"\n");
        contenu.appendText("observateur jbo3: clic du boutonA"+"\n");
    }
    }  
    private class ButtonHandlerB implements ActionListener{
    public void actionPerformed(ActionEvent event){
    contenu.appendText("observateur jbo1: clic du boutonB"+"\n");
    contenu.appendText("observateur jbo2: clic du boutonB"+"\n");
       }
    }
    private class ButtonHandlerC implements ActionListener{
    public void actionPerformed(ActionEvent event){
    contenu.appendText("observateur jbo1: clic du boutonC"+"\n");
       }
    }
 */

    public static void main(String[] args){
        new IHMQuestion2_1();
    }

}
