package question2;

//import java.awt.event. // à compléter
//import java.awt.event. // à compléter
import java.awt.TextArea;
import java.awt.event.*;
import javax.swing.JButton;

/**
 * Décrivez votre classe JButtonObserver ici.
 * 
 * @author (votre nom)
 * @version (un numéro de version ou une date)
 */
public class JButtonObserver implements ActionListener{ // à compléter

    private String nom;
    private TextArea contenu;

    /**
     * Constructeur d'objets de classe JButtonObserver
     * 
     * @param nom
     *            le nom du bouton, jbo1, jbo2, jbo3, jmo1, jmo2, jmo3
     * @param contenu
     *            la zone de texte de l'applette
     */
    public JButtonObserver(String nom, TextArea contenu) {
        this.nom = nom;
        this.contenu = contenu;
    }

    /**
     * affichage d'un message dans la zone de texte ce message est de la forme
     * observateur this.nom : clic du bouton nom_du_bouton exemple : observateur
     * jbo1 : clic du bouton A, voir la méthode getActionCommand()
     * 
     * @param à
     *            compléter
     */
    public void actionPerformed(ActionEvent ae ){
       String command = ae.getActionCommand();
       String message ="clic du bouton "+command+" observateur "+this.nom; 
       contenu.append(message + "\n");
   
    }
       
      // if (ae.getSource() == boutonA) {
        //String message ="clic du "+((JButton) ae.getSource()).getName()+" observateur "+this.nom+"\n";
               //contenu.append(message + "\n");}
        //methode1:unpractical and wrongly 
       //if(ae.getSource()=="boutonA"){
       //String message = "observateur jbo1: clic du boutonA"+"\n"+
       //"observateur jbo2: clic du boutonA"+"\n"+"observateur jbo3: clic du boutonA";
       //else if(ae.getSource()=="boutonB"){
       // String message = "observateur jmo1: clic du boutonB"+"\n"+
       //"observateur jmo2: clic du boutonB";
       // contenu.append(message + "\n");}
       // else if(ae.getSource()=="boutonC"){
       // String message = "observateur jmo3: clic du boutonC";
       // contenu.append(message + "\n");
    }


