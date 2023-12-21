/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package PayrollDB;

import main.FrameUtils;
import java.sql.*;
import javax.swing.JOptionPane;

public class EmployeeRegistration extends javax.swing.JPanel {
    
    public EmployeeRegistration() {
        initComponents();
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        Title = new javax.swing.JLabel();
        EmployeeName = new javax.swing.JLabel();
        EmployeeNameTF = new javax.swing.JTextField();
        Username = new javax.swing.JLabel();
        UsernameTF = new javax.swing.JTextField();
        Passcode = new javax.swing.JLabel();
        Gender = new javax.swing.JLabel();
        GenderCB = new javax.swing.JComboBox<>();
        Address = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        AddressTA = new javax.swing.JTextArea();
        Position = new javax.swing.JLabel();
        PositionTF = new javax.swing.JTextField();
        CreateAccount = new javax.swing.JButton();
        Back = new javax.swing.JButton();
        PasscodePF = new javax.swing.JPasswordField();

        Title.setFont(new java.awt.Font("Arial", 3, 24)); // NOI18N
        Title.setText("Employee Registration");

        EmployeeName.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        EmployeeName.setText("EMPLOYEE NAME:");

        Username.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        Username.setText("USERNAME:");

        Passcode.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        Passcode.setText("PASSCODE:");

        Gender.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        Gender.setText("GENDER:");

        GenderCB.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        GenderCB.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Male", "Female" }));

        Address.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        Address.setText("ADDRESS:");

        AddressTA.setColumns(20);
        AddressTA.setRows(5);
        jScrollPane1.setViewportView(AddressTA);

        Position.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        Position.setText("POSITION:");

        CreateAccount.setBackground(new java.awt.Color(254, 254, 254));
        CreateAccount.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        CreateAccount.setText("Create Account");
        CreateAccount.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        CreateAccount.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CreateAccountActionPerformed(evt);
            }
        });

        Back.setBackground(new java.awt.Color(254, 254, 254));
        Back.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        Back.setText("Back");
        Back.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
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
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(CreateAccount, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(Title)
                        .addGroup(layout.createSequentialGroup()
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addComponent(Username)
                                .addComponent(EmployeeName)
                                .addComponent(Passcode)
                                .addComponent(Gender)
                                .addComponent(Address)
                                .addComponent(Position))
                            .addGap(18, 18, 18)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(EmployeeNameTF)
                                .addComponent(UsernameTF)
                                .addComponent(GenderCB, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jScrollPane1)
                                .addComponent(PositionTF)
                                .addComponent(PasscodePF))))
                    .addComponent(Back, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(18, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(26, 26, 26)
                .addComponent(Title)
                .addGap(46, 46, 46)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(EmployeeName)
                    .addComponent(EmployeeNameTF, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(Username)
                    .addComponent(UsernameTF, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(21, 21, 21)
                        .addComponent(Passcode)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED, 23, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(PasscodePF)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(GenderCB, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Gender))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(Address)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(20, 20, 20)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(Position)
                    .addComponent(PositionTF, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(CreateAccount, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(Back, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(15, 15, 15))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void CreateAccountActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CreateAccountActionPerformed
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/payroll", "root", "Kashiwagi13!");

            String employeeName = EmployeeNameTF.getText();
            String username = UsernameTF.getText();
            String passcode = new String(PasscodePF.getPassword());
            String gender = (String) GenderCB.getSelectedItem();
            String address = AddressTA.getText();
            String position = PositionTF.getText();

            if (employeeName.isEmpty() || username.isEmpty() || passcode.isEmpty() || address.isEmpty() || position.isEmpty()) {
                JOptionPane.showMessageDialog(this, "Please fill in all fields.");
                return;
            }

            String insertQuery = "INSERT INTO employee_info (employee_name, username, passcode, gender, address, position) VALUES (?, ?, ?, ?, ?, ?)";
            try (PreparedStatement preparedStatement = con.prepareStatement(insertQuery)) {
                preparedStatement.setString(1, employeeName);
                preparedStatement.setString(2, username);
                preparedStatement.setString(3, passcode);
                preparedStatement.setString(4, gender);
                preparedStatement.setString(5, address);
                preparedStatement.setString(6, position);

                preparedStatement.executeUpdate();
            }

            JOptionPane.showMessageDialog(this, "Employee account created successfully.");

            EmployeeNameTF.setText("");
            UsernameTF.setText("");
            PasscodePF.setText("");
            GenderCB.setSelectedIndex(0);
            AddressTA.setText("");
            PositionTF.setText("");

        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Error in Connectivity");
            e.printStackTrace();
        }
    }//GEN-LAST:event_CreateAccountActionPerformed

    private void BackActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BackActionPerformed
        Employee screen = new Employee();
        FrameUtils.displayFrameWithPanel(screen, "Employee");
        FrameUtils.disposeParentFrame(this);
    }//GEN-LAST:event_BackActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel Address;
    private javax.swing.JTextArea AddressTA;
    private javax.swing.JButton Back;
    private javax.swing.JButton CreateAccount;
    private javax.swing.JLabel EmployeeName;
    private javax.swing.JTextField EmployeeNameTF;
    private javax.swing.JLabel Gender;
    private javax.swing.JComboBox<String> GenderCB;
    private javax.swing.JLabel Passcode;
    private javax.swing.JPasswordField PasscodePF;
    private javax.swing.JLabel Position;
    private javax.swing.JTextField PositionTF;
    private javax.swing.JLabel Title;
    private javax.swing.JLabel Username;
    private javax.swing.JTextField UsernameTF;
    private javax.swing.JScrollPane jScrollPane1;
    // End of variables declaration//GEN-END:variables
}
