import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class fenetre2 extends JFrame {
    private JLabel idLabel = new JLabel("ID");
    private JLabel nameLabel = new JLabel("Libelle");
    private JLabel priceLabel = new JLabel("Prix");

    private JTextField idField = new JTextField(20);
    private JTextField nameField = new JTextField(20);
    private JTextField priceField = new JTextField(20);

    private JButton addButton = new JButton("Ajouter");
    private JButton deleteButton = new JButton("Supprimer");
    private JButton cancelButton = new JButton("Annuler");
    private JButton quitButton = new JButton("Quitter");

    private JPanel inputPanel = new JPanel();
    private JPanel buttonPanel = new JPanel();

    private String[] columnNames = {"ID", "Libelle", "Prix"};
    private Object[][] data = {{1, "prod1", 28}, {2, "prod2", 228}, {3, "prod3", 18}};
    private DefaultTableModel model = new DefaultTableModel(data, columnNames);

    private JTable table = new JTable(model);

    public fenetre2() {
        inputPanel.setLayout(new GridLayout(3, 2));
        inputPanel.add(idLabel);
        inputPanel.add(idField);
        inputPanel.add(nameLabel);
        inputPanel.add(nameField);
        inputPanel.add(priceLabel);
        inputPanel.add(priceField);

        buttonPanel.setLayout(new GridLayout(4, 1));
        buttonPanel.add(addButton);
        buttonPanel.add(deleteButton);
        buttonPanel.add(cancelButton);
        buttonPanel.add(quitButton);

        JScrollPane scrollPane = new JScrollPane(table);

        this.add(inputPanel, BorderLayout.CENTER);
        this.add(buttonPanel, BorderLayout.EAST);
        this.add(scrollPane, BorderLayout.SOUTH);

        setSize(400, 200);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(false);
        pack();
        setVisible(true);

        addButton.addActionListener(new AddAction());
        deleteButton.addActionListener(new DeleteAction());
    }

    private class AddAction implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            Object[] row = {idField.getText(), nameField.getText(), priceField.getText()};
            model.addRow(row);
        }
    }

    private class DeleteAction implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            int selectedRow = table.getSelectedRow();
            if (selectedRow != -1) {
                model.removeRow(selectedRow);
            }
        }
    }

    public static void main(String[] args) {
        new fenetre2();
    }
}