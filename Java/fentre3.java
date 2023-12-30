import javax.swing.*;
import java.awt.*;

public class fentre3 {
    public static void main(String[] args) {
        JFrame ayoub = new JFrame("ayoub");

        // create a menubar
        JMenuBar mb = new JMenuBar();

        // create a menu for menu and add to the frame
        JMenu m1 = new JMenu("File");
        JMenu m2 = new JMenu("Help");
        mb.add(m1);
        mb.add(m2);
        ayoub.setJMenuBar(mb);

        JButton N1 = new JButton("click me");

        JPanel p1 = new JPanel();
        JLabel l1 = new JLabel("Price");
        JTextField t1 = new JTextField(60);
        p1.setLayout(new GridLayout(1,2));
        p1.add(l1);
        p1.add(t1);

        JPanel p2 = new JPanel();
        p2.add(N1);

        ayoub.add(p1,BorderLayout.NORTH);
        ayoub.add(p2,BorderLayout.CENTER);

        ayoub.setSize(400,400);
        ayoub.setVisible(true);
        ayoub.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}