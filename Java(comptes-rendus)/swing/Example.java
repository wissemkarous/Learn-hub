package swing;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Example extends JFrame {
    public Example() {
        setTitle("My First Example");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Creating an intermediate JPanel
        JPanel panel = new JPanel();
        panel.setLayout(new FlowLayout());
        // new JSplitPane();

        JButton button1 = new JButton("Button 1");
        JButton button2 = new JButton("Button 2");

        // Adding an ActionListener for the buttons
        button1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("Button 1 clicked");
            }
        });

        button2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("Button 2 clicked");
            }
        });

        panel.add(button1);
        panel.add(button2);

        add(panel);
        pack();
        setLocationRelativeTo(null);
        setVisible(true);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new Example());
    }
}
