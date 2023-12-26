package javaproject;
import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import javax.swing.undo.UndoManager;
import java.awt.*;
import java.awt.event.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.LinkedHashMap;
import java.util.Map;

public class hotelreview extends JFrame {
    private Map<String, Integer> criteriaScores;
    private JTextArea commentTextArea;
    private JTextField hotelNameField;
    private JButton submitButton;
    private UndoManager undoManager;

    public hotelreview() {
        criteriaScores = new LinkedHashMap<>();
        undoManager = new UndoManager();

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setTitle("Hotel Review App");
        setSize(400, 300);
        setLayout(new BorderLayout());

        JPanel inputPanel = createInputPanel();
        JPanel buttonPanel = createButtonPanel();

        add(inputPanel, BorderLayout.CENTER);
        add(buttonPanel, BorderLayout.SOUTH);

        pack();
        setLocationRelativeTo(null);
        setVisible(true);

        // Add undo functionality
        addUndoRedoFunctionality();
    }

    private void addUndoRedoFunctionality() {
        InputMap inputMap = commentTextArea.getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW);
        ActionMap actionMap = commentTextArea.getActionMap();

        KeyStroke undoKeyStroke = KeyStroke.getKeyStroke(KeyEvent.VK_Z, Toolkit.getDefaultToolkit().getMenuShortcutKeyMask());
        KeyStroke redoKeyStroke = KeyStroke.getKeyStroke(KeyEvent.VK_Z, Toolkit.getDefaultToolkit().getMenuShortcutKeyMask() | InputEvent.SHIFT_DOWN_MASK);

        inputMap.put(undoKeyStroke, "undo");
        inputMap.put(redoKeyStroke, "redo");

        actionMap.put("undo", new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (undoManager.canUndo()) {
                    undoManager.undo();
                }
            }
        });

        actionMap.put("redo", new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (undoManager.canRedo()) {
                    undoManager.redo();
                }
            }
        });
    }

    private JPanel createInputPanel() {
        JPanel inputPanel = new JPanel(new GridLayout(6, 2));

        JLabel hotelNameLabel = new JLabel("Hotel Name:");
        hotelNameField = new JTextField();

        inputPanel.add(hotelNameLabel);
        inputPanel.add(hotelNameField);

        for (String criterion : new String[]{"Confort", "Securite", "Animation", "Proprete"}) {
            JLabel criteriaLabel = new JLabel(criterion + ":");
            JSlider ratingSlider = new JSlider(0, 5);
            ratingSlider.setPaintTicks(true);
            ratingSlider.setPaintLabels(true);
            ratingSlider.setMajorTickSpacing(1);

            // Use a final variable for the criterion to make it accessible inside the listener
            final String currentCriterion = criterion;

            ratingSlider.addChangeListener(new ChangeListener() {
                @Override
                public void stateChanged(ChangeEvent e) {
                    criteriaScores.put(currentCriterion, ratingSlider.getValue());
                }
            });

            inputPanel.add(criteriaLabel);
            inputPanel.add(ratingSlider);
            criteriaScores.put(criterion, 0);
        }

        JLabel commentLabel = new JLabel("Comment:");
        commentTextArea = new JTextArea();
        commentTextArea.getDocument().addUndoableEditListener(undoManager);

        inputPanel.add(commentLabel);
        inputPanel.add(new JScrollPane(commentTextArea));

        return inputPanel;
    }

    private JPanel createButtonPanel() {
        JPanel buttonPanel = new JPanel();

        submitButton = new JButton("Submit");
        submitButton.addActionListener(new SubmitButtonListener());

        JButton cancelButton = new JButton("Cancel");
        cancelButton.addActionListener(new CancelButtonListener());

        buttonPanel.add(submitButton);
        buttonPanel.add(cancelButton);

        return buttonPanel;
    }

    private class SubmitButtonListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            String hotelName = hotelNameField.getText();

            // Save data to the database
            saveDataToDatabase(hotelName);

            // Update summary
            updateSummary();

            // Reset fields
            resetFields();
        }
    }

    private class CancelButtonListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            // Undo changes with Ctrl-Z
            if (undoManager.canUndo()) {
                undoManager.undo();
            }
        }
    }

    private void saveDataToDatabase(String hotelName) {
        Connection connection = Connect.getConnection();
        if (connection != null) {
            String insertQuery = "INSERT INTO hotel_reviews (Date, HotelName, Confort, Securite, Animation, Proprete, Comment) VALUES (?, ?, ?, ?, ?, ?, ?)";

            try (PreparedStatement preparedStatement = connection.prepareStatement(insertQuery)) {
                SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
                String date = dateFormat.format(new Date());

                preparedStatement.setString(1, date);
                preparedStatement.setString(2, hotelName);

                // Set ratings for each criterion
                preparedStatement.setInt(3, criteriaScores.get("Confort"));
                preparedStatement.setInt(4, criteriaScores.get("Securite"));
                preparedStatement.setInt(5, criteriaScores.get("Animation"));
                preparedStatement.setInt(6, criteriaScores.get("Proprete"));

                // Set comment
                preparedStatement.setString(7, commentTextArea.getText());

                // Execute the query
                preparedStatement.executeUpdate();

                System.out.println("Data inserted into the database.");
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        } else {
            System.out.println("Database connection not available.");
        }
    }

    private void updateSummary() {
        // Update summary (to be implemented)
        // Use data from the database to generate histograms and curves over time.
    }

    private void resetFields() {
        hotelNameField.setText("");

        for (String criterion : criteriaScores.keySet()) {
            criteriaScores.put(criterion, 0);
        }

        commentTextArea.setText("");
        undoManager.discardAllEdits();
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(hotelreview::new);
    }
}
