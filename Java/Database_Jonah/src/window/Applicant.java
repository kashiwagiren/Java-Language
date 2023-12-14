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
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class Applicant extends javax.swing.JPanel {
    
    private static final String JDBC_URL = "jdbc:mysql://localhost:3306/applicant_db";
    private static final String USERNAME = "root";
    private static final String PASSWORD = "Kashiwagi13!";
    
    public Applicant() {
        initComponents();
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jComboBox1 = new javax.swing.JComboBox<>();
        jTextField1 = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jTextField2 = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        jTextField3 = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        jTextField4 = new javax.swing.JTextField();
        Add = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        Show = new javax.swing.JButton();
        Clear = new javax.swing.JButton();
        Exit = new javax.swing.JButton();
        jLabel7 = new javax.swing.JLabel();
        jTextField5 = new javax.swing.JTextField();
        Search = new javax.swing.JButton();
        Edit = new javax.swing.JButton();
        Delete = new javax.swing.JButton();

        jLabel1.setFont(new java.awt.Font("Arial", 3, 24)); // NOI18N
        jLabel1.setText("Applicant Database Management ");

        jLabel2.setText("Applicant:");

        jLabel3.setText("Gender:");

        jComboBox1.setBackground(new java.awt.Color(254, 254, 254));
        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Male", "Female" }));

        jLabel4.setText("Address:");

        jLabel5.setText("Contact:");

        jLabel6.setText("Position:");

        Add.setBackground(new java.awt.Color(254, 254, 254));
        Add.setText("Add");
        Add.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                AddActionPerformed(evt);
            }
        });

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Applicant", "Gender", "Address", "Contact", "Position"
            }
        ));
        jScrollPane1.setViewportView(jTable1);

        Show.setBackground(new java.awt.Color(254, 254, 254));
        Show.setText("Show");
        Show.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ShowActionPerformed(evt);
            }
        });

        Clear.setBackground(new java.awt.Color(254, 254, 254));
        Clear.setText("Clear Table");
        Clear.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ClearActionPerformed(evt);
            }
        });

        Exit.setBackground(new java.awt.Color(254, 254, 254));
        Exit.setText("Exit");
        Exit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ExitActionPerformed(evt);
            }
        });

        jLabel7.setText("Search:");

        Search.setBackground(new java.awt.Color(254, 254, 254));
        Search.setText("Search");
        Search.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SearchActionPerformed(evt);
            }
        });

        Edit.setBackground(new java.awt.Color(254, 254, 254));
        Edit.setText("Edit Information");
        Edit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                EditActionPerformed(evt);
            }
        });

        Delete.setBackground(new java.awt.Color(254, 254, 254));
        Delete.setText("Delete");
        Delete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                DeleteActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel7)
                        .addGap(18, 18, 18)
                        .addComponent(jTextField5, javax.swing.GroupLayout.PREFERRED_SIZE, 199, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(Search)
                        .addGap(18, 18, 18)
                        .addComponent(Delete)
                        .addContainerGap(50, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(49, 49, 49)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel2)
                            .addComponent(jLabel3)
                            .addComponent(jLabel4)
                            .addComponent(jLabel5)
                            .addComponent(jLabel6))
                        .addGap(39, 39, 39)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(jTextField2, javax.swing.GroupLayout.DEFAULT_SIZE, 210, Short.MAX_VALUE)
                                .addComponent(jTextField1)
                                .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jTextField3)
                                .addComponent(jTextField4))
                            .addComponent(Add))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(Show)
                                .addGap(18, 18, 18)
                                .addComponent(Clear)
                                .addGap(18, 18, 18)
                                .addComponent(Edit)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(Exit))
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 452, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(33, 33, 33))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(9, 9, 9)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jTextField5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(Search)
                            .addComponent(Delete))))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2)
                            .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel3)
                            .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel4)
                            .addComponent(jTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel5)
                            .addComponent(jTextField3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel6)
                            .addComponent(jTextField4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 182, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(Add)
                    .addComponent(Show)
                    .addComponent(Clear)
                    .addComponent(Exit)
                    .addComponent(Edit))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void AddActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_AddActionPerformed
        try {
            String applicantName = jTextField1.getText();
            String gender = jComboBox1.getSelectedItem().toString();
            String address = jTextField2.getText();
            String contact = jTextField3.getText();
            String position = jTextField4.getText();

            try (Connection connection = DriverManager.getConnection(JDBC_URL, USERNAME, PASSWORD)) {
                String insertQuery = "INSERT INTO applicants (applicant_name, gender, address, contact, position) VALUES (?, ?, ?, ?, ?)";
                try (PreparedStatement preparedStatement = connection.prepareStatement(insertQuery)) {
                    preparedStatement.setString(1, applicantName);
                    preparedStatement.setString(2, gender);
                    preparedStatement.setString(3, address);
                    preparedStatement.setString(4, contact);
                    preparedStatement.setString(5, position);

                    int rowsAffected = preparedStatement.executeUpdate();

                    if (rowsAffected > 0) {
                        JOptionPane.showMessageDialog(this, "Applicant added successfully");
                        ClearFields();
                    } else {
                        JOptionPane.showMessageDialog(this, "Failed to add applicant");
                    }
                }
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(this, "Error: " + e.getMessage());
            e.printStackTrace();
        }
    }//GEN-LAST:event_AddActionPerformed

    private void SearchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SearchActionPerformed
        try {
            String searchKeyword = jTextField5.getText();

            try (Connection connection = DriverManager.getConnection(JDBC_URL, USERNAME, PASSWORD)) {
                String searchQuery = "SELECT * FROM applicants WHERE applicant_name LIKE ?";
                try (PreparedStatement preparedStatement = connection.prepareStatement(searchQuery)) {
                    preparedStatement.setString(1, "%" + searchKeyword + "%");

                    try (ResultSet resultSet = preparedStatement.executeQuery()) {
                        DefaultTableModel model = (DefaultTableModel) jTable1.getModel();
                        model.setRowCount(0);

                        while (resultSet.next()) {
                            String applicantName = resultSet.getString("applicant_name");
                            String gender = resultSet.getString("gender");
                            String address = resultSet.getString("address");
                            String contact = resultSet.getString("contact");
                            String position = resultSet.getString("position");

                            model.addRow(new Object[]{applicantName, gender, address, contact, position});
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
            try (Connection connection = DriverManager.getConnection(JDBC_URL, USERNAME, PASSWORD)) {
                String showQuery = "SELECT * FROM applicants";
                try (PreparedStatement preparedStatement = connection.prepareStatement(showQuery)) {
                    try (ResultSet resultSet = preparedStatement.executeQuery()) {
                        DefaultTableModel model = (DefaultTableModel) jTable1.getModel();
                        model.setRowCount(0);

                        while (resultSet.next()) {
                            String applicantName = resultSet.getString("applicant_name");
                            String gender = resultSet.getString("gender");
                            String address = resultSet.getString("address");
                            String contact = resultSet.getString("contact");
                            String position = resultSet.getString("position");

                            model.addRow(new Object[]{applicantName, gender, address, contact, position});
                        }
                    }
                }
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(this, "Error: " + e.getMessage());
            e.printStackTrace();
        }
    }//GEN-LAST:event_ShowActionPerformed

    private void ClearActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ClearActionPerformed
        DefaultTableModel model = (DefaultTableModel) jTable1.getModel();
        model.setRowCount(0);
    }//GEN-LAST:event_ClearActionPerformed

    private void ExitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ExitActionPerformed
        FrameUtils.disposeParentFrame(this);
    }//GEN-LAST:event_ExitActionPerformed

    
    private void EditActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_EditActionPerformed
        int selectedRow = jTable1.getSelectedRow();

        if (selectedRow == -1) {
            JOptionPane.showMessageDialog(this, "Please select a record to edit.");
            return;
        }

        // Get the values of the selected row
        String applicantName = jTable1.getValueAt(selectedRow, 0).toString();
        String gender = jTable1.getValueAt(selectedRow, 1).toString();
        String address = jTable1.getValueAt(selectedRow, 2).toString();
        String contact = jTable1.getValueAt(selectedRow, 3).toString();
        String position = jTable1.getValueAt(selectedRow, 4).toString();

        // Open the Edit window with the selected record's values
        Edit editWindow = new Edit(new String[]{applicantName, gender, address, contact, position});
        JFrame frame = new JFrame();
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.getContentPane().add(editWindow);
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }//GEN-LAST:event_EditActionPerformed

    private void DeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_DeleteActionPerformed
        try {
            int selectedRow = jTable1.getSelectedRow();

            if (selectedRow == -1) {
                JOptionPane.showMessageDialog(this, "Please select a record to delete.");
                return;
            }

            String applicantName = jTable1.getValueAt(selectedRow, 0).toString();

            int confirmDialog = JOptionPane.showConfirmDialog(this, "Are you sure you want to delete the selected record?", "Confirm Delete", JOptionPane.YES_NO_OPTION);

            if (confirmDialog == JOptionPane.YES_OPTION) {
                try (Connection connection = DriverManager.getConnection(JDBC_URL, USERNAME, PASSWORD)) {
                    String deleteQuery = "DELETE FROM applicants WHERE applicant_name=?";
                    try (PreparedStatement preparedStatement = connection.prepareStatement(deleteQuery)) {
                        preparedStatement.setString(1, applicantName);

                        int rowsAffected = preparedStatement.executeUpdate();

                        if (rowsAffected > 0) {
                            JOptionPane.showMessageDialog(this, "Record deleted successfully");
                            ClearFields();
                            ShowActionPerformed(evt);
                        } else {
                            JOptionPane.showMessageDialog(this, "Failed to delete record");
                        }
                    }
                }
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(this, "Error: " + e.getMessage());
            e.printStackTrace();
        }
    }//GEN-LAST:event_DeleteActionPerformed

    private void ClearFields() {
        jTextField1.setText("");
        jComboBox1.setSelectedIndex(0);
        jTextField2.setText("");
        jTextField3.setText("");
        jTextField4.setText("");
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton Add;
    private javax.swing.JButton Clear;
    private javax.swing.JButton Delete;
    private javax.swing.JButton Edit;
    private javax.swing.JButton Exit;
    private javax.swing.JButton Search;
    private javax.swing.JButton Show;
    private javax.swing.JComboBox<String> jComboBox1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTextField jTextField2;
    private javax.swing.JTextField jTextField3;
    private javax.swing.JTextField jTextField4;
    private javax.swing.JTextField jTextField5;
    // End of variables declaration//GEN-END:variables
}
