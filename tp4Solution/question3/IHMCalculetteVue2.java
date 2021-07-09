package question3;

import question3.tp3.*;

import java.awt.*;
import javax.swing.*;
import java.util.Observer;
import java.util.Observable;

public class IHMCalculetteVue2 extends JFrame {
    public IHMCalculetteVue2() {
        super("IHM Calculette2");
        PileModele<Integer> modele = new PileModele<Integer>(new Pile2<Integer>(5));
        Controleur controle = new Controleur(modele);
        Vue2 vue2 = new Vue2(modele);

        setLayout(new GridLayout(2, 1));
        add(vue2);
        add(controle);
        pack();
        setLocation(200,200);
        setVisible(true);

    }

    public static void main(String[] args){
        new IHMCalculetteVue2();
    }
}
