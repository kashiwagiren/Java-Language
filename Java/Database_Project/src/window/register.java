/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package window;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingUtilities;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import main.FrameUtils;

public class register extends javax.swing.JPanel {
    
    private static final String URL = "jdbc:mysql://localhost:3306/login";
    private static final String DB_USER = "root";
    private static final String DB_PASS = "Kashiwagi13!";
    private JLabel passwordStrengthLabel = new JLabel("");
    
    public register() {
        initComponents();
        postInitComponents();
    }
    
    private void postInitComponents() {
        passwordStrengthLabel.setFont(new Font("Arial", Font.PLAIN, 12));
        passwordStrengthLabel.setForeground(Color.RED);
        passwordStrengthLabel.setOpaque(true);
        
        Dimension labelSize = passwordStrengthLabel.getPreferredSize();
        passwordStrengthLabel.setBounds(250, 420, labelSize.width, labelSize.height);
        
        add(passwordStrengthLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 420, labelSize.width, labelSize.height));
        
        passTF.getDocument().addDocumentListener(new PasswordStrengthListener());
    }
    
    private class PasswordStrengthListener implements DocumentListener {

        @Override
        public void changedUpdate(DocumentEvent e) {
            update();
        }

        @Override
        public void removeUpdate(DocumentEvent e) {
            update();
        }

        @Override
        public void insertUpdate(DocumentEvent e) {
            update();
        }

        private void update() {
            SwingUtilities.invokeLater(() -> {
                String password = new String(passTF.getPassword());
                if (isStrongPassword(password)) {
                    passwordStrengthLabel.setText("Strong Password");
                    passwordStrengthLabel.setForeground(Color.GREEN);
                } else {
                    passwordStrengthLabel.setText("Weak Password - Use 8 characters, mix of upper, lower, digits, & special");
                    passwordStrengthLabel.setForeground(Color.RED);
                }

                Dimension labelSize = passwordStrengthLabel.getPreferredSize();
                passwordStrengthLabel.setBounds(250, 420, labelSize.width, labelSize.height);

                passwordStrengthLabel.setVisible(true);
            });
        }
    }
    
    public boolean isStrongPassword(String password) {
        boolean hasUppercase = !password.equals(password.toLowerCase());
        boolean hasLowercase = !password.equals(password.toUpperCase());
        boolean hasDigit = password.matches(".*[0-9].*");
        boolean hasSpecial = password.matches(".*[^a-zA-Z0-9 ].*");
        boolean isLongEnough = password.length() >= 8;

        return hasUppercase && hasLowercase && hasDigit && hasSpecial && isLongEnough;
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        title = new javax.swing.JLabel();
        user = new javax.swing.JLabel();
        userTF = new javax.swing.JTextField();
        pass = new javax.swing.JLabel();
        passTF = new javax.swing.JPasswordField();
        confirm = new javax.swing.JLabel();
        confirmTF = new javax.swing.JPasswordField();
        done = new javax.swing.JButton();
        img = new javax.swing.JLabel();

        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        title.setFont(new java.awt.Font("Arial", 2, 36)); // NOI18N
        title.setText("Registration");
        add(title, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 30, -1, -1));

        user.setFont(new java.awt.Font("Arial", 1, 24)); // NOI18N
        user.setText("Username");
        add(user, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 200, -1, -1));

        userTF.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        add(userTF, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 190, 290, 50));

        pass.setFont(new java.awt.Font("Arial", 1, 24)); // NOI18N
        pass.setText("Password");
        add(pass, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 280, -1, -1));

        passTF.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        add(passTF, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 270, 290, 50));

        confirm.setFont(new java.awt.Font("Arial", 1, 24)); // NOI18N
        confirm.setText("Confirm");
        add(confirm, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 360, -1, -1));

        confirmTF.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        add(confirmTF, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 350, 290, 50));

        done.setBackground(new java.awt.Color(254, 254, 254));
        done.setFont(new java.awt.Font("Arial", 1, 24)); // NOI18N
        done.setText("Done");
        done.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        done.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                doneActionPerformed(evt);
            }
        });
        add(done, new org.netbeans.lib.awtextra.AbsoluteConstraints(644, 512, 90, 50));

        img.setIcon(new javax.swing.ImageIcon("C:\\Users\\kieth\\Documents\\NetbeansProjects\\Database_Project\\resources\\6.jpg")); // NOI18N
        add(img, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));
    }// </editor-fold>//GEN-END:initComponents
    
    private boolean registerNewUser(String username, String password) {
        if (username.trim().isEmpty() || password.trim().isEmpty()) {
            JOptionPane.showMessageDialog(this, "Username and password cannot be empty.", "Registration Error", JOptionPane.ERROR_MESSAGE);
            return false;
        }

        String hashedPassword = hashPassword(password);

        try (Connection connection = DriverManager.getConnection(URL, DB_USER, DB_PASS); PreparedStatement checkUserExists = connection.prepareStatement("SELECT * FROM users WHERE username = ?"); PreparedStatement insertNewUser = connection.prepareStatement("INSERT INTO users (username, password_hash) VALUES (?, ?)")) {
            
            checkUserExists.setString(1, username);
            ResultSet resultSet = checkUserExists.executeQuery();
            if (resultSet.next()) {
                JOptionPane.showMessageDialog(this, "User already exists.", "Registration Error", JOptionPane.ERROR_MESSAGE);
                return false;
            } else {
                insertNewUser.setString(1, username);
                insertNewUser.setString(2, hashedPassword);
                int result = insertNewUser.executeUpdate();
                return result > 0;
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(this, "Unable to perform the operation. Please check your connection and try again.", "Error", JOptionPane.ERROR_MESSAGE);
            return false;
        }
    }
    
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
            JOptionPane.showMessageDialog(this, "An error occurred while creating a password hash.", "Registration Error", JOptionPane.ERROR_MESSAGE);
            return null;
        }
    }
    
    private void doneActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_doneActionPerformed
        String username = sanitizeUsername(userTF.getText());
        String password = new String(passTF.getPassword());
        String confirmPassword = new String(confirmTF.getPassword());

        if (username.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Username cannot be empty.", "Registration Error", JOptionPane.ERROR_MESSAGE);
            userTF.requestFocusInWindow();
            return;
        }

        if (password.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Password cannot be empty.", "Registration Error", JOptionPane.ERROR_MESSAGE);
            passTF.requestFocusInWindow();
            return;
        }

        if (!password.equals(confirmPassword)) {
            JOptionPane.showMessageDialog(this, "Passwords do not match.", "Registration Error", JOptionPane.ERROR_MESSAGE);
            confirmTF.requestFocusInWindow();
            return;
        }

        if (!isStrongPassword(password)) {
            JOptionPane.showMessageDialog(this, "The password is not strong enough.", "Registration Error", JOptionPane.ERROR_MESSAGE);
            passTF.requestFocusInWindow();
            return;
        }

        boolean isRegistered = registerNewUser(username, password);
        if (isRegistered) {
            JOptionPane.showMessageDialog(this, "Registration successful!", "Success", JOptionPane.INFORMATION_MESSAGE);
            resetForm();
            login screen = new login();
            FrameUtils.displayFrameWithPanel(screen, "login");
            FrameUtils.disposeParentFrame(this);
        } else {
            JOptionPane.showMessageDialog(this, "Registration failed. Please try again.", "Registration Error", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_doneActionPerformed
    
    private String sanitizeUsername(String username) {
        return username.replaceAll("[\\s'\";=]+", "");
    }
    
    private void resetForm() {
        userTF.setText("");
        passTF.setText("");
        confirmTF.setText("");
        passwordStrengthLabel.setText("Password Strength: ");
        passwordStrengthLabel.setForeground(Color.RED);
    }
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel confirm;
    private javax.swing.JPasswordField confirmTF;
    private javax.swing.JButton done;
    private javax.swing.JLabel img;
    private javax.swing.JLabel pass;
    private javax.swing.JPasswordField passTF;
    private javax.swing.JLabel title;
    private javax.swing.JLabel user;
    private javax.swing.JTextField userTF;
    // End of variables declaration//GEN-END:variables
}
