/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package PayrollDB;

import javax.swing.JOptionPane;
import java.sql.*;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.math.BigInteger;
import main.FrameUtils;

public class Employee extends javax.swing.JPanel {
    
    private static final String URL = "jdbc:mysql://localhost:3306/payroll";
    private static final String DB_USER = "root";
    private static final String DB_PASS = "Kashiwagi13!";
    
    public Employee() {
        initComponents();
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        Title = new javax.swing.JLabel();
        userTextField = new javax.swing.JTextField();
        user = new javax.swing.JLabel();
        pass = new javax.swing.JLabel();
        passTextField = new javax.swing.JPasswordField();
        login = new javax.swing.JButton();
        back = new javax.swing.JButton();

        Title.setFont(new java.awt.Font("Arial", 3, 24)); // NOI18N
        Title.setText("Payroll (Employee)");

        user.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        user.setText("Username");

        pass.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        pass.setText("Password");

        login.setBackground(new java.awt.Color(254, 254, 254));
        login.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        login.setText("LOG IN");
        login.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        login.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                loginActionPerformed(evt);
            }
        });

        back.setBackground(new java.awt.Color(254, 254, 254));
        back.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        back.setText("BACK");
        back.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        back.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                backActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(17, 17, 17)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(Title)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(user)
                            .addComponent(pass))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addComponent(back, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 38, Short.MAX_VALUE)
                                .addComponent(login, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(userTextField)
                            .addComponent(passTextField))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(Title)
                .addGap(59, 59, 59)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(userTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(user))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(passTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(pass))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(login, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(back, javax.swing.GroupLayout.DEFAULT_SIZE, 38, Short.MAX_VALUE))
                .addGap(15, 15, 15))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void loginActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_loginActionPerformed
        String userN = userTextField.getText();
        String passW = new String(passTextField.getPassword());

        if (userN.trim().isEmpty() || passW.trim().isEmpty()) {
            JOptionPane.showMessageDialog(this, "Username and password cannot be empty.", "Login Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        try (Connection connection = DriverManager.getConnection(URL, DB_USER, DB_PASS); PreparedStatement statement = connection.prepareStatement("SELECT passcode FROM employee_info WHERE username = ?")) {

            statement.setString(1, userN);
            try (ResultSet resultSet = statement.executeQuery()) {
                if (resultSet.next()) {
                    String storedPassword = resultSet.getString("passcode");

                    if (passW.equals(storedPassword)) {
                        JOptionPane.showMessageDialog(this, "Login successful!", "Success", JOptionPane.INFORMATION_MESSAGE);
                        EmployeeMenu screen = new EmployeeMenu();
                        FrameUtils.displayFrameWithPanel(screen, "Menu");
                        FrameUtils.disposeParentFrame(this);
                    } else {
                        JOptionPane.showMessageDialog(this, "Invalid username or password.", "Login Error", JOptionPane.ERROR_MESSAGE);
                    }
                } else {
                    int response = JOptionPane.showConfirmDialog(this, "User does not exist. Would you like to register?", "Register", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
                    if (response == JOptionPane.YES_OPTION) {
                        EmployeeRegistration screen = new EmployeeRegistration();
                        FrameUtils.displayFrameWithPanel(screen, "Register");
                        FrameUtils.disposeParentFrame(this);
                    }
                }
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(this, "Unable to perform the operation. Please check your connection and try again.", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_loginActionPerformed

    private void backActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_backActionPerformed
        Payroll window = new Payroll();
        FrameUtils.displayFrameWithPanel(window, "Payroll Management System");
        FrameUtils.disposeParentFrame(this);
    }//GEN-LAST:event_backActionPerformed
    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel Title;
    private javax.swing.JButton back;
    private javax.swing.JButton login;
    private javax.swing.JLabel pass;
    private javax.swing.JPasswordField passTextField;
    private javax.swing.JLabel user;
    private javax.swing.JTextField userTextField;
    // End of variables declaration//GEN-END:variables
}
