package swing;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class RegistrationFrame extends JFrame {
    private JTextField lastNameField, firstNameField;
    private JRadioButton maleRadioButton, femaleRadioButton;
    private JComboBox<String> regionComboBox;
    private JCheckBox sportCheckBox, roboticsCheckBox, musicCheckBox, danceCheckBox;
    private JButton submitButton, cancelButton;
    private Frame recapFrame;

    public RegistrationFrame() {
        setTitle("Registration");
        setSize(450, 350);
        JPanel mainPanel = new JPanel();
        mainPanel.setLayout(new GridLayout(7, 2));
        mainPanel.add(new JLabel("Last Name:"));
        lastNameField = new JTextField();
        mainPanel.add(lastNameField);

        mainPanel.add(new JLabel("First Name:"));
        firstNameField = new JTextField();
        mainPanel.add(firstNameField);

        mainPanel.add(new JLabel("Gender:"));
        maleRadioButton = new JRadioButton("M");
        femaleRadioButton = new JRadioButton("F");
        ButtonGroup genderGroup = new ButtonGroup();
        genderGroup.add(maleRadioButton);
        genderGroup.add(femaleRadioButton);
        JPanel genderPanel = new JPanel();
        genderPanel.add(maleRadioButton);
        genderPanel.add(femaleRadioButton);
        mainPanel.add(genderPanel);

        mainPanel.add(new JLabel("Region:"));
        String[] regions = {"Select", "Tunis", "Le Kef", "Sousse", "Sfax", "Gabes"};
        regionComboBox = new JComboBox<>(regions);
        mainPanel.add(regionComboBox);

        mainPanel.add(new JLabel("Hobbies:"));
        sportCheckBox = new JCheckBox("Sport");
        roboticsCheckBox = new JCheckBox("Robotics");
        musicCheckBox = new JCheckBox("Music");
        danceCheckBox = new JCheckBox("Dance");
        JPanel hobbiesPanel = new JPanel();
        hobbiesPanel.setLayout(new GridLayout(1, 4));
        hobbiesPanel.add(sportCheckBox);
        hobbiesPanel.add(roboticsCheckBox);
        hobbiesPanel.add(musicCheckBox);
        hobbiesPanel.add(danceCheckBox);
        mainPanel.add(hobbiesPanel);

        mainPanel.add(new JLabel(""));

        submitButton = new JButton("Submit");
        cancelButton = new JButton("Cancel");

        mainPanel.add(submitButton);
        mainPanel.add(cancelButton);

        submitButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                System.out.println("Last Name: " + lastNameField.getText());
                System.out.println("First Name: " + firstNameField.getText());
                System.out.println("Gender: " + (maleRadioButton.isSelected() ? "Male" : "Female"));
                System.out.println("Region: " + regionComboBox.getSelectedItem());
                System.out.print("Hobbies: ");
                if (sportCheckBox.isSelected()) System.out.print("Sport ");
                if (roboticsCheckBox.isSelected()) System.out.print("Robotics ");
                if (musicCheckBox.isSelected()) System.out.print("Music ");
                if (danceCheckBox.isSelected()) System.out.print("Dance ");
                System.out.println();
            }
        });

        cancelButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                lastNameField.setText("");
                firstNameField.setText("");
                genderGroup.clearSelection();
                regionComboBox.setSelectedIndex(0);
                sportCheckBox.setSelected(false);
                roboticsCheckBox.setSelected(false);
                musicCheckBox.setSelected(false);
                danceCheckBox.setSelected(false);
            }
        });

        add(mainPanel);

        setLocationRelativeTo(null);

        setVisible(true);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new RegistrationFrame();
            }
        });
    }
}
