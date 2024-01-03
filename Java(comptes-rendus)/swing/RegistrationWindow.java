package swing;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class RegistrationWindow extends JFrame {

    private String firstName;
    private String lastName;
    private String gender;
    private String region;
    private String hobbies;

    public RegistrationWindow() {
        setTitle("Registration Window");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JTabbedPane tabbedPane = new JTabbedPane();

        // Create tabs
        JPanel generalPanel = createGeneralPanel();
        JPanel projectPanel = createProjectPanel();
        JPanel certificatePanel = createCertificatePanel();

        // Add tabs to the tabbedPane
        tabbedPane.addTab("General", generalPanel);
        tabbedPane.addTab("Project", projectPanel);
        tabbedPane.addTab("Certificate", certificatePanel);

        // Add the tabbedPane to the frame
        add(tabbedPane);

        setJMenuBar(createMenuBar());
    }

    private JPanel createGeneralPanel() {
        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(5, 2));

        // Your general panel components here...

        return panel;
    }

    private JPanel createProjectPanel() {
        JPanel panel = new JPanel();
        // Create components for the "Project" tab here...

        return panel;
    }

    private JPanel createCertificatePanel() {
        JPanel panel = new JPanel();
        // Create components for the "Certificate" tab here...

        return panel;
    }

    private JMenuBar createMenuBar() {
        JMenuBar menuBar = new JMenuBar();
        JMenu operationsMenu = new JMenu("Menu");

        JMenuItem insertMenuItem = new JMenuItem("Insert");
        insertMenuItem.addActionListener(e -> openIframe());

        JMenuItem searchMenuItem = new JMenuItem("Search");

        JMenuItem okMenuItem = new JMenuItem("OK");
        okMenuItem.addActionListener(e -> showRecap());

        operationsMenu.add(insertMenuItem);
        operationsMenu.add(searchMenuItem);
        operationsMenu.add(okMenuItem);

        menuBar.add(operationsMenu);

        return menuBar;
    }

    private void openIframe() {
        // Your existing openIframe method...
    }

    private void showRecap() {
        // Your existing showRecap method...
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new RegistrationWindow().setVisible(true));
    }
}
