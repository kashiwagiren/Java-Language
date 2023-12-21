/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package window;

import javax.swing.JOptionPane;
import java.sql.*;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.math.BigInteger;
import main.FrameUtils;
import select.SelectDB;

public class login extends javax.swing.JPanel {
    
    private static final String URL = "jdbc:mysql://localhost:3306/login";
    private static final String DB_USER = "root";
    private static final String DB_PASS = "Kashiwagi13!";
    
    public login() {
        initComponents();
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        icn = new javax.swing.JLabel();
        title = new javax.swing.JLabel();
        username = new javax.swing.JLabel();
        userTextField = new javax.swing.JTextField();
        password = new javax.swing.JLabel();
        passTextField = new javax.swing.JPasswordField();
        login = new javax.swing.JButton();
        exit = new javax.swing.JButton();
        img = new javax.swing.JLabel();

        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        icn.setIcon(new javax.swing.ImageIcon("C:\\Users\\kieth\\Documents\\NetbeansProjects\\Database_Project\\resources\\2.png")); // NOI18N
        add(icn, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 40, -1, -1));

        title.setFont(new java.awt.Font("Arial", 3, 24)); // NOI18N
        title.setText("DATABASE MANAGEMENT PROJECT ");
        add(title, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 140, -1, -1));

        username.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        username.setText("Username");
        add(username, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 240, -1, -1));

        userTextField.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        add(userTextField, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 230, 180, 40));

        password.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        password.setText("Password");
        add(password, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 310, -1, -1));

        passTextField.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        add(passTextField, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 302, 180, 40));

        login.setBackground(new java.awt.Color(254, 254, 254));
        login.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        login.setText("login");
        login.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        login.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                loginActionPerformed(evt);
            }
        });
        add(login, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 390, 90, 40));

        exit.setBackground(new java.awt.Color(254, 254, 254));
        exit.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        exit.setText("exit");
        exit.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        exit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                exitActionPerformed(evt);
            }
        });
        add(exit, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 450, 90, 40));

        img.setIcon(new javax.swing.ImageIcon("C:\\Users\\kieth\\Documents\\NetbeansProjects\\Database_Project\\resources\\1.jpg")); // NOI18N
        add(img, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));
    }// </editor-fold>//GEN-END:initComponents
    
    private void loginActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_loginActionPerformed
        String user = userTextField.getText();
        String pass = new String(passTextField.getPassword());

        if (user.trim().isEmpty() || pass.trim().isEmpty()) {
            JOptionPane.showMessageDialog(this, "Username and password cannot be empty.", "Login Error", JOptionPane.ERROR_MESSAGE);
            return;
        }
        
        try (Connection connection = DriverManager.getConnection(URL, DB_USER, DB_PASS); PreparedStatement statement = connection.prepareStatement("SELECT password_hash FROM users WHERE username = ?")) {

            statement.setString(1, user);
            try (ResultSet resultSet = statement.executeQuery()) {
                if (resultSet.next()) {
                    String storedPasswordHash = resultSet.getString("password_hash");
                    String enteredPasswordHash = hashPassword(pass);

                    if (enteredPasswordHash.equals(storedPasswordHash)) {
                        JOptionPane.showMessageDialog(this, "Login successful!", "Success", JOptionPane.INFORMATION_MESSAGE);
                        SelectDB window = new SelectDB();
                        FrameUtils.displayFrameWithPanel(window, "Select a Database");
                        FrameUtils.disposeParentFrame(this);
                    } else {
                        JOptionPane.showMessageDialog(this, "Invalid username or password.", "Login Error", JOptionPane.ERROR_MESSAGE);
                    }
                } else {
                    int response = JOptionPane.showConfirmDialog(this, "User does not exist. Would you like to register?", "Register", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
                    if (response == JOptionPane.YES_OPTION) {
                        register screen = new register();
                        FrameUtils.displayFrameWithPanel(screen, "register");
                        FrameUtils.disposeParentFrame(this);
                    }
                }
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(this, "Unable to perform the operation. Please check your connection and try again.", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_loginActionPerformed
    
    private String hashPassword(String password) {
        try {
            MessageDigest md = MessageDigest.getInstance("SHA-256");
            byte[] messageDigest = md.digest(password.getBytes());
            BigInteger no = new BigInteger(1, messageDigest);
            String hashedPassword = no.toString(16);

            while (hashedPassword.length() < 32) {
                hashedPassword = "0" + hashedPassword;
            }

            return hashedPassword;
        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException(e);
        }
    }
    
    private void exitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_exitActionPerformed
        System.exit(0);
    }//GEN-LAST:event_exitActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton exit;
    private javax.swing.JLabel icn;
    private javax.swing.JLabel img;
    private javax.swing.JButton login;
    private javax.swing.JPasswordField passTextField;
    private javax.swing.JLabel password;
    private javax.swing.JLabel title;
    private javax.swing.JTextField userTextField;
    private javax.swing.JLabel username;
    // End of variables declaration//GEN-END:variables
}
