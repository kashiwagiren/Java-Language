/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package window;

import main.FrameUtils;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class Option extends javax.swing.JPanel {
    
    private static final String JDBC_URL = "jdbc:mysql://localhost:3306/cafe_db";
    private static final String USERNAME = "root";
    private static final String PASSWORD = "Kashiwagi13!";
    
    public Option() {
        initComponents();
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        UpdateInfo = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        jTextField2 = new javax.swing.JTextField();
        Search = new javax.swing.JButton();
        Show = new javax.swing.JButton();
        Delete = new javax.swing.JButton();
        Clear = new javax.swing.JButton();
        Back = new javax.swing.JButton();

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Coffee", "Price"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.Integer.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        jScrollPane1.setViewportView(jTable1);

        UpdateInfo.setText("Update Information");
        UpdateInfo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                UpdateInfoActionPerformed(evt);
            }
        });

        jLabel2.setText("Search");

        Search.setText("Search");
        Search.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SearchActionPerformed(evt);
            }
        });

        Show.setText("Show");
        Show.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ShowActionPerformed(evt);
            }
        });

        Delete.setText("Delete Records from Database");
        Delete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                DeleteActionPerformed(evt);
            }
        });

        Clear.setText("Clear Table");
        Clear.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ClearActionPerformed(evt);
            }
        });

        Back.setText("Back");
        Back.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BackActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 375, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addGap(18, 18, 18)
                        .addComponent(jTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(43, 43, 43)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(Show)
                            .addComponent(Search)))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(UpdateInfo)
                            .addComponent(Clear))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(Back)
                            .addComponent(Delete))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(jTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Search))
                .addGap(18, 18, 18)
                .addComponent(Show)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 275, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(UpdateInfo)
                    .addComponent(Delete))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(Clear)
                    .addComponent(Back))
                .addContainerGap(23, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void SearchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SearchActionPerformed
        try {
            String searchKeyword = jTextField2.getText();

            // Establish a database connection
            try (Connection connection = DriverManager.getConnection(JDBC_URL, USERNAME, PASSWORD)) {
                // Create a prepared statement for the search query
                String searchQuery = "SELECT * FROM cafe_db_records WHERE coffee LIKE ?";
                try (PreparedStatement preparedStatement = connection.prepareStatement(searchQuery)) {
                    preparedStatement.setString(1, "%" + searchKeyword + "%");

                    // Execute the query and get the result set
                    try (ResultSet resultSet = preparedStatement.executeQuery()) {
                        // Clear existing table data
                        DefaultTableModel model = (DefaultTableModel) jTable1.getModel();
                        model.setRowCount(0);

                        // Populate the table with the search results
                        while (resultSet.next()) {
                            String coffee = resultSet.getString("coffee");
                            int price = resultSet.getInt("price");

                            // Add a new row to the table
                            model.addRow(new Object[]{coffee, price});
                        }
                    }
                }
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(this, "Error: " + e.getMessage());
            e.printStackTrace();
        }
    }//GEN-LAST:event_SearchActionPerformed

    private void ShowActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ShowActionPerformed
        try {
            // Establish a database connection
            try (Connection connection = DriverManager.getConnection(JDBC_URL, USERNAME, PASSWORD)) {
                // Create a statement to fetch all records
                String showQuery = "SELECT * FROM cafe_db_records";
                try (PreparedStatement preparedStatement = connection.prepareStatement(showQuery)) {
                    // Execute the query and get the result set
                    try (ResultSet resultSet = preparedStatement.executeQuery()) {
                        // Clear existing table data
                        DefaultTableModel model = (DefaultTableModel) jTable1.getModel();
                        model.setRowCount(0);

                        // Populate the table with all records
                        while (resultSet.next()) {
                            String coffee = resultSet.getString("coffee");
                            int price = resultSet.getInt("price");

                            // Add a new row to the table
                            model.addRow(new Object[]{coffee, price});
                        }
                    }
                }
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(this, "Error: " + e.getMessage());
            e.printStackTrace();
        }
    }//GEN-LAST:event_ShowActionPerformed

    private void UpdateInfoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_UpdateInfoActionPerformed
        // Get the selected row index from jTable1
        int selectedRow = jTable1.getSelectedRow();

        if (selectedRow != -1) {
            // Get the values from the selected row
            String selectedCoffee = jTable1.getValueAt(selectedRow, 0).toString();
            int selectedPrice = (int) jTable1.getValueAt(selectedRow, 1);

            // Create an instance of UpdateInfo panel with the selected values
            var updateInfoPanel = new UpdateInfo(selectedCoffee, selectedPrice);

            // Display the UpdateInfo panel
            FrameUtils.displayFrameWithPanel(updateInfoPanel, "Update Information");
        } else {
            JOptionPane.showMessageDialog(this, "Please select a record to update.");
        }
    }//GEN-LAST:event_UpdateInfoActionPerformed

    private void DeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_DeleteActionPerformed
        try {
            // Get the selected row index from jTable1
            int selectedRow = jTable1.getSelectedRow();

            if (selectedRow != -1) {
                // Get the values from the selected row
                String coffeeToDelete = jTable1.getValueAt(selectedRow, 0).toString();

                // Show a confirmation dialog to confirm the deletion
                int option = JOptionPane.showConfirmDialog(this, "Are you sure you want to delete the selected record?",
                        "Confirmation", JOptionPane.YES_NO_OPTION);

                if (option == JOptionPane.YES_OPTION) {
                    // Establish a connection to the database
                    try (Connection connection = DriverManager.getConnection(JDBC_URL, USERNAME, PASSWORD)) {
                        // Execute a DELETE query to remove the record from the cafe_db_records table
                        String deleteQuery = "DELETE FROM cafe_db_records WHERE coffee = ?";
                        try (PreparedStatement preparedStatement = connection.prepareStatement(deleteQuery)) {
                            preparedStatement.setString(1, coffeeToDelete);

                            // Execute the update
                            int rowsAffected = preparedStatement.executeUpdate();

                            if (rowsAffected > 0) {
                                // Data deleted successfully
                                JOptionPane.showMessageDialog(this, "Record deleted successfully");
                                // Refresh the table
                                ShowActionPerformed(evt);
                            } else {
                                // Failed to delete data
                                JOptionPane.showMessageDialog(this, "Failed to delete record");
                            }
                        }
                    }
                }
            } else {
                JOptionPane.showMessageDialog(this, "Please select a record to delete.");
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Error: " + e.getMessage());
            e.printStackTrace();
        }
    }//GEN-LAST:event_DeleteActionPerformed

    private void ClearActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ClearActionPerformed
        // Create a DefaultTableModel to store the data for the JTable
        DefaultTableModel model = (DefaultTableModel) jTable1.getModel();

        // Clear existing data in the table
        model.setRowCount(0);
    }//GEN-LAST:event_ClearActionPerformed

    private void BackActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BackActionPerformed
        var screen = new CafeManagementSystem();
        FrameUtils.displayFrameWithPanel(screen, "");
        FrameUtils.disposeParentFrame(this);
    }//GEN-LAST:event_BackActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton Back;
    private javax.swing.JButton Clear;
    private javax.swing.JButton Delete;
    private javax.swing.JButton Search;
    private javax.swing.JButton Show;
    private javax.swing.JButton UpdateInfo;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JTextField jTextField2;
    // End of variables declaration//GEN-END:variables
}
