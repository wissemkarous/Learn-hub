import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import javax.swing.undo.UndoManager;
import java.awt.*;
import java.awt.event.*;
import java.io.*;
import java.text.SimpleDateFormat;
import java.util.*;

public class HotelReviewApp extends JFrame {
    private Map<String, Integer> criteriaScores;
    private JTextArea commentTextArea;
    private JTextField hotelNameField;
    private JButton submitButton;
    private UndoManager undoManager;

    public HotelReviewApp() {
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
    final JSlider finalRatingSlider = ratingSlider;

    ratingSlider.addChangeListener(new ChangeListener() {
        @Override
        public void stateChanged(ChangeEvent e) {
            criteriaScores.put(currentCriterion, finalRatingSlider.getValue());
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

            // Save data to CSV
            saveDataToCSV(hotelName);

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

    private void saveDataToCSV(String hotelName) {
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String date = dateFormat.format(new Date());

        String fileName = "data.csv";
        File file = new File(fileName);
        boolean fileExists = file.exists();

        try (PrintWriter writer = new PrintWriter(new FileWriter(fileName, true))) {
            if (!fileExists) {
                StringBuilder header = new StringBuilder("Date,HotelName");
                for (String criterion : criteriaScores.keySet()) {
                    header.append(",").append(criterion);
                }
                header.append(",Comment");
                writer.println(header.toString());
            }

            StringBuilder csvLine = new StringBuilder(date + "," + hotelName);
            for (String criterion : criteriaScores.keySet()) {
                csvLine.append(",").append(criteriaScores.get(criterion));
            }
            csvLine.append(",").append(commentTextArea.getText());
            writer.println(csvLine.toString());
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    private void updateSummary() {
        // Update summary (to be implemented)
        // Use data from the CSV file to generate histograms and curves over time.
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
        System.setProperty("java.version", "1.8");
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new HotelReviewApp();
            }
        });
    }
}

