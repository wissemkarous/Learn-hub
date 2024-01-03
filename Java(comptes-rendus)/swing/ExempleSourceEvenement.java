package swing;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ExempleSourceEvenement {
    public static void main(String[] args) {
        Frame fenetre = new Frame("Exemple de Source d'Événement");

        Button bouton = new Button("Cliquez-moi");

        bouton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // Obtenir la source de l'événement
                Object source = e.getSource();

                if (source == bouton) {
                    System.out.println("Bouton cliqué !");
                }
            }
        });

        fenetre.add(bouton);
        fenetre.setSize(300, 200);
        fenetre.setVisible(true);

        fenetre.addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent windowEvent) {
                System.exit(0);
            }
        });
    }
}
