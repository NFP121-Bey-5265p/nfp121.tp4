package question3;

import question3.tp3.PileI;
import question3.tp3.PilePleineException;
import question3.tp3.PileVideException;

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import javax.swing.JButton;
/**
 * Décrivez votre classe Controleur ici.
 * 
 * @author (votre nom)
 * @version (un numéro de version ou une date)
 */
public class Controleur extends JPanel {

    private JButton push, add, sub, mul, div, clear;
    private PileModele<Integer> pile;
    private JTextField donnee;
    String s0,s1,s2;
    
    public Controleur(PileModele<Integer> pile) {
        super();
        this.pile = pile;
        this.donnee = new JTextField(8);
        
        this.push = new JButton("push");
        this.add = new JButton("+");
        this.sub = new JButton("-");
        this.mul = new JButton("*");
        this.div = new JButton("/");
        this.clear = new JButton("[]");
         
        
        setLayout(new GridLayout(2, 1));
        add(donnee);
        JPanel boutons = new JPanel();
        boutons.setLayout(new FlowLayout());
        boutons.add(push);  
        boutons.add(add);   
        boutons.add(sub);   
        boutons.add(mul);   
        boutons.add(div);   
        boutons.add(clear); 
        
        boutons.setBackground(Color.red);
     
        PushOperation P = new PushOperation();
        push.addActionListener(P);
        push.setActionCommand( "push" );
        
        Addition A= new Addition();
        add.addActionListener(A);
        add.setActionCommand( "+" );
        
        Substraction St= new Substraction();
        sub.addActionListener(St);
        sub.setActionCommand( "-" );
        
        Multiplication M= new Multiplication();
        mul.addActionListener(M);
        mul.setActionCommand( "*" );
        
        Division D= new Division(); 
        div.addActionListener(D);
        div.setActionCommand( "/" );
        
        Clearing C= new Clearing();
        clear.addActionListener(C);
        clear.setActionCommand( "[]" );
        
        Texte tex= new Texte();
        donnee.addActionListener(tex);
        
        add(boutons);
        actualiserInterface();
    }
    
    private class Texte implements ActionListener{
       public void actionPerformed(ActionEvent ae){
       String s = ae.getActionCommand();
       actualiserInterface();
      }
     }
     
    private class PushOperation implements ActionListener{
       public void actionPerformed(ActionEvent ae){
        try{
            pile.empiler(operande());
           }
        catch(NumberFormatException nfe){}
        catch(PilePleineException e){}
        actualiserInterface();
      }
     }
    
    private class Addition implements ActionListener{
       public void actionPerformed(ActionEvent ae){
        try{ 
            int a= pile.depiler()+pile.depiler();
            pile.empiler(a);
        }
        catch(NumberFormatException nfe){}
        catch(PilePleineException e){}
        catch (question3.tp3.PileVideException pve){}
        actualiserInterface();
       }
    }
    
     private class Substraction implements ActionListener{
       public void actionPerformed(ActionEvent ae){
        try{ 
           // int a= pile.depiler()-pile.depiler();
           // pile.empiler(a);
            int o = pile.sommet();
            pile.depiler();
            pile.empiler(pile.depiler() - o);
        }
        catch(NumberFormatException nfe){}
        catch(PilePleineException e){}
        catch (question3.tp3.PileVideException pve){}
        actualiserInterface();
      }
    }
    
    private class Multiplication implements ActionListener{
       public void actionPerformed(ActionEvent ae){
        try{
            int a= pile.depiler()*pile.depiler();
            pile.empiler(a);
        }
        catch(NumberFormatException nfe){}
        catch(PilePleineException e){}
        catch (question3.tp3.PileVideException pve){}
        actualiserInterface();
      }
    }
    
    private class Division implements ActionListener{
       public void actionPerformed(ActionEvent ae){
         try{
            int o = pile.sommet();
            if(o != 0){
                pile.depiler();
                pile.empiler(pile.depiler() / o);
            }
            if(o == 0){//on ne fait rien
                      }
                    }
        catch(NumberFormatException nfe){}
        catch(PilePleineException e){}
        catch (question3.tp3.PileVideException pve){}
        actualiserInterface();
      }
    }
    
     private class Clearing implements ActionListener{
       public void actionPerformed(ActionEvent ae){
      
        for(int i = pile.taille(); i >=0 ; i--){
            try{
                pile.depiler();
            }catch(Exception e){
            }
        }
        actualiserInterface();
      }
    }
    
       public void actualiserInterface() {
           if(pile.estVide()){
          add.setEnabled(false);
          sub.setEnabled(false);
          mul.setEnabled(false);
          div.setEnabled(false);
          clear.setEnabled(false);
          push.setEnabled(true);
       }
       else if(pile.taille()== 1){
          add.setEnabled(false);
          sub.setEnabled(false);
          mul.setEnabled(false);
          div.setEnabled(false);
          clear.setEnabled(true);
          push.setEnabled(true);
        }
        else if(pile.taille()> 1){
          add.setEnabled(true);
          sub.setEnabled(true);
          mul.setEnabled(true);
          div.setEnabled(true);
          clear.setEnabled(true);
          push.setEnabled(true);
        }
        else if(pile.estPleine()) {
          push.setEnabled(false);
          add.setEnabled(true);
          sub.setEnabled(true);
          mul.setEnabled(true);
          div.setEnabled(true);
          clear.setEnabled(true);
        }
    }

    private Integer operande() throws NumberFormatException {
    return Integer.parseInt(donnee.getText());
    }
}

    