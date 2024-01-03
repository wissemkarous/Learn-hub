package swing;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MyWindow extends JFrame {
    private String lastName;
    private String firstName;
    private String gender;
    private String region;
    private String hobbies;

    public MyWindow() {
        setTitle("Swing Example");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JButton insertButton = new JButton("Insert");
        insertButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                openRegistrationFrame();
            }
        });

        JButton searchButton = new JButton("Search");
        JButton okButton = new JButton("OK");

        okButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                showRecap();
            }
        });

        setLayout(new FlowLayout());
        add(insertButton);
        add(searchButton);
        add(okButton);
    }

    private void openRegistrationFrame() {
        JFrame registrationFrame = new JFrame("Registration Frame");
        registrationFrame.setSize(300, 200);

        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(7, 2));

        panel.add(new JLabel("Last Name:"));
        JTextField lastNameField = new JTextField();
        panel.add(lastNameField);

        panel.add(new JLabel("First Name:"));
        JTextField firstNameField = new JTextField();
        panel.add(firstNameField);

        panel.add(new JLabel("Gender:"));
        JRadioButton maleRadioButton = new JRadioButton("Male");
        JRadioButton femaleRadioButton = new JRadioButton("Female");
        ButtonGroup genderGroup = new ButtonGroup();
        genderGroup.add(maleRadioButton);
        genderGroup.add(femaleRadioButton);
        panel.add(maleRadioButton);
        panel.add(femaleRadioButton);

        panel.add(new JLabel("Region:"));
        JTextField regionField = new JTextField();
        panel.add(regionField);

        panel.add(new JLabel("Hobbies:"));
        JCheckBox sportCheckBox = new JCheckBox("Sport");
        JCheckBox musicCheckBox = new JCheckBox("Music");
        JCheckBox readingCheckBox = new JCheckBox("Reading");
        JCheckBox travelCheckBox = new JCheckBox("Travel");
        panel.add(sportCheckBox);
        panel.add(musicCheckBox);
        panel.add(readingCheckBox);
        panel.add(travelCheckBox);

        JButton okButton = new JButton("OK");
        okButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Store data in class variables
                lastName = lastNameField.getText();
                firstName = firstNameField.getText();
                gender = maleRadioButton.isSelected() ? "Male" : "Female";
                region = regionField.getText();
                hobbies = "";
                if (sportCheckBox.isSelected()) hobbies += "Sport ";
                if (musicCheckBox.isSelected()) hobbies += "Music ";
                if (readingCheckBox.isSelected()) hobbies += "Reading ";
                if (travelCheckBox.isSelected()) hobbies += "Travel ";

                registrationFrame.dispose();
            }
        });

        registrationFrame.setLayout(new BorderLayout());
        registrationFrame.add(panel, BorderLayout.CENTER);
        registrationFrame.add(okButton, BorderLayout.SOUTH);

        registrationFrame.setVisible(true);
    }

    private void showRecap() {
        // Display data in a dialog box
        String recapMessage = "Last Name: " + lastName + "\n" +
                              "First Name: " + firstName + "\n" +
                              "Gender: " + gender + "\n" +
                              "Region: " + region + "\n" +
                              "Hobbies: " + hobbies;

        JOptionPane.showMessageDialog(this, recapMessage, "Recap", JOptionPane.INFORMATION_MESSAGE);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new MyWindow().setVisible(true);
            }
        });
    }
}
