import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.*;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

public class HotelReviewApp extends JFrame {
    private Map<String, Integer> criteriaScores;
    private JTextArea commentTextArea;
    private JTextField hotelNameField;
    private JButton submitButton;

    public HotelReviewApp() {
        criteriaScores = new HashMap<>();

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
    }

    private JPanel createInputPanel() {
        JPanel inputPanel = new JPanel(new GridLayout(6, 2));

        JLabel hotelNameLabel = new JLabel("Nom de l'hôtel:");
        hotelNameField = new JTextField();

        inputPanel.add(hotelNameLabel);
        inputPanel.add(hotelNameField);

        for (String criterion : new String[]{"Confort", "Securite", "Animation", "Proprete"}) {
            JLabel criteriaLabel = new JLabel(criterion + ":");
            JSlider ratingSlider = new JSlider(0, 5);
            ratingSlider.setPaintTicks(true);
            ratingSlider.setPaintLabels(true);
            ratingSlider.setMajorTickSpacing(1);
            inputPanel.add(criteriaLabel);
            inputPanel.add(ratingSlider);
            criteriaScores.put(criterion, 0);
        }

        JLabel commentLabel = new JLabel("Commentaire:");
        commentTextArea = new JTextArea();

        inputPanel.add(commentLabel);
        inputPanel.add(new JScrollPane(commentTextArea));

        return inputPanel;
    }

    private JPanel createButtonPanel() {
        JPanel buttonPanel = new JPanel();

        submitButton = new JButton("Soumettre");
        submitButton.addActionListener(new SubmitButtonListener());

        JButton cancelButton = new JButton("Annuler");
        cancelButton.addActionListener(new CancelButtonListener());

        buttonPanel.add(submitButton);
        buttonPanel.add(cancelButton);

        return buttonPanel;
    }

    private class SubmitButtonListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            String hotelName = hotelNameField.getText();

            // Enregistrement des données dans le fichier CSV
            saveDataToCSV(hotelName);

            // Mise à jour du récapitulatif des notes
            updateSummary();

            // Réinitialisation des champs
            resetFields();
        }
    }

    private class CancelButtonListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            // Annulation des saisies avec Ctrl-z
            resetFields();
        }
    }

    private void saveDataToCSV(String hotelName) {
        // Format de la date
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String date = dateFormat.format(new Date());

        // Enregistrement des données dans un fichier CSV
        try (PrintWriter writer = new PrintWriter(new FileWriter("hotel_reviews.csv", true))) {
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
        // Mise à jour du récapitulatif des notes (à implémenter)
        // Vous pouvez utiliser les données du fichier CSV pour générer des histogrammes et des courbes par année.
    }

    private void resetFields() {
        hotelNameField.setText("");

        for (String criterion : criteriaScores.keySet()) {
            criteriaScores.put(criterion, 0);
        }

        commentTextArea.setText("");
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new HotelReviewApp());
    }
}
