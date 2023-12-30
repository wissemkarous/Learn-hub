// package net.codejava.swing.jpanel;
 
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
 
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;
import javax.swing.UIManager;
 
/**
 * This program demonstrates how to use JPanel in Swing.
 * @author www.codejava.net
 */
public class Login extends JFrame {
     
    private JLabel labelUsername = new JLabel("Enter username: ");
    private JLabel labelPassword = new JLabel("Enter password: ");
    private JTextField textUsername = new JTextField(20);
    private JPasswordField fieldPassword = new JPasswordField(20);
    private JButton buttonLogin = new JButton("Login");
     
    public Login() {
        super("JPanel Demo Program");
         
        // create a new panel with GridBagLayout manager
        JPanel newPanel = new JPanel(new GridBagLayout());
         
        GridBagConstraints constraints = new GridBagConstraints();
        constraints.anchor = GridBagConstraints.WEST;
        constraints.insets = new Insets(10, 10, 10, 10);
         
        // add components to the panel
        constraints.gridx = 0;
        constraints.gridy = 0;     
        newPanel.add(labelUsername, constraints);
 
        constraints.gridx = 1;
        newPanel.add(textUsername, constraints);
         
        constraints.gridx = 0;
        constraints.gridy = 1;     
        newPanel.add(labelPassword, constraints);
         
        constraints.gridx = 1;
        newPanel.add(fieldPassword, constraints);
         
        constraints.gridx = 0;
        constraints.gridy = 3;
        constraints.gridwidth = 2;
        constraints.anchor = GridBagConstraints.CENTER;
        newPanel.add(buttonLogin, constraints);
         //expliquer gridx et gridy et gridwidth        
        // set border for the panel
        newPanel.setBorder(BorderFactory.createTitledBorder(
                BorderFactory.createEtchedBorder(), "Login Panel"));
         
        // add the panel to this frame
        add(newPanel);
         
        pack();
        setLocationRelativeTo(null);
    }
     
    public static void main(String[] args) {
        // set look and feel to the system look and feel
        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        } catch (Exception ex) {
            ex.printStackTrace();
        }
         
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new Login().setVisible(true);
            }
        });
    }
}