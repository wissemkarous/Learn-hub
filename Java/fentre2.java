import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class fentre2 extends JFrame {
    public static void main(String args[]) {
        JFrame f = new JFrame("gestion de produits ");
        JLabel JF1 = new JLabel("ID");
        JLabel JF3 = new JLabel("Libelle");
        JLabel JF2 = new JLabel("Prix");
        JTextField JTF1 = new JTextField("");
        JTextField JTF2 = new JTextField("");
        JTextField JTF3 = new JTextField("");
        JButton b1 = new JButton("Ajouter");
        JButton b2 = new JButton("Supprimer");
        JButton b3 = new JButton("Annuler");
        JButton b4 = new JButton("Quitter");
        JPanel p1 = new JPanel();
        JPanel p2 = new JPanel();

        p1.setLayout(new GridLayout(3, 2));
        p1.add(JF1);
        p1.add(JTF1);
        p1.add(JF2);
        p1.add(JTF2);
        p1.add(JF3);
        p1.add(JTF3);
        f.add(p1,BorderLayout.CENTER);

        p2.setLayout(new GridLayout(4, 1));
        p2.add(b1);
        p2.add(b2);
        p2.add(b3);
        p2.add(b4);
        f.add(p2,BorderLayout.EAST);

        ActionListener buttonListener = new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                JButton button = (JButton) e.getSource();
                System.out.println(button.getText());
            }
        };

        b1.addActionListener(buttonListener);
        b2.addActionListener(buttonListener);
        b3.addActionListener(buttonListener);
        b4.addActionListener(buttonListener);

        f.setSize(400, 200);
        f.setVisible(true);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}