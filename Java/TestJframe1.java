// import javax.swing.*;
// public class TestJframe1{
//     public static void main (String args[]){
//         JFrame  f =new JFrame("ma fenetre");
//         f.setSize(400,100);
//         f.setVisible(true);
//     }
// }
// creation de fenetre avec un bouton
// Path: Java/TestJframe2.java
import javax.swing.*;
import java.awt.event.*;;
public class TestJframe1{
    public static void main (String args[]){
        JFrame  f =new JFrame("ma fenetre");
        JPanel p = new JPanel();
        f.setSize(800,500);
        JButton b = new JButton("mon bouton");
        //ajouter actionlistener et class actionperfurmed pour le bouton b
        b.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                System.out.println("bouton cliqué");
            }
        });

      
JMenuBar mb = new JMenuBar();
        JMenu m1 = new JMenu("fichier");
        JMenu m2 = new JMenu("edition");
        JMenu m3 = new JMenu("aide");
        mb.add(m1);
        mb.add(m2);
        mb.add(m3);
        f.setJMenuBar(mb);
        p.add(b);
        f.getContentPane().add(p);
        f.setVisible(true);
        // ajouter de jtext field et j combobox 
        JTextField tf = new JTextField("mon text field");
        JComboBox cb = new JComboBox();
        cb.addItem("item1");
        cb.addItem("item2");
        cb.addItem("item3");
        JPasswordField pf = new JPasswordField("mon password field");
        JScrollBar sb = new JScrollBar();
        // ajouter jList 
        String[] data = {"item1","item2","item3"};
        JList l = new JList(data);
        // ajouter Jlabel  et JimageIcon 
        JLabel label = new JLabel("mon label");
        ImageIcon img = new ImageIcon("pfa image.jpg"); 
        // ajouter Jpanel
        JPanel p22 = new JPanel();
        p22.add(label);
        p22.add(l);

        JPanel p5 = new JPanel();
        p5.add(tf);
        p5.add(cb);
        p5.add(pf);
        // separer les panel
        JSeparator sep = new JSeparator();
        sep.setOrientation(SwingConstants.VERTICAL);
        p5.add(sep);
        p5.add(p22);
        p5.add(sb);
        f.getContentPane().add(p5);
        f.setVisible(true);

        // afficher l'image dans le label
        label.setIcon(img);
        p.add(label);
        p.add(l);
        p.add(sb);
        p.add(tf);
        p.add(cb);
        p.add(pf);
        f.getContentPane().add(p);
        f.setVisible(true);
    }

}
// quelle est le role de Jframe et role de Jpanel
// Jframe est une fenetre et Jpanel est un conteneur
// et role de contentPane() est de retourner le conteneur de la fenetre
// cree Jmenubar 
// Path: Java/TestJframe3.java
// import javax.swing.*;
// import java.awt.event.*;;
// public class TestJframe1{
//     public static void main (String args[]){
//         JFrame  f =new JFrame("ma fenetre");
//         JPanel p = new JPanel();
//         f.setSize(800,500);
//         JButton b = new JButton("mon bouton");
//         //ajouter actionlistener et class actionperfurmed pour le bouton b
//         b.addActionListener(new ActionListener(){
//             public void actionPerformed(ActionEvent e){
//                 System.out.println("bouton cliqué");
//             }
//         });

//         
//     }

