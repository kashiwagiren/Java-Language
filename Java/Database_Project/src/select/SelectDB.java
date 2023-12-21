/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package select;

import main.FrameUtils;
import StudentDB.Student;
import PayrollDB.Payroll;

public class SelectDB extends javax.swing.JPanel {
    
    public SelectDB() {
        initComponents();
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        Student = new javax.swing.JButton();
        Payroll = new javax.swing.JButton();
        Exit = new javax.swing.JButton();
        img = new javax.swing.JLabel();

        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        Student.setBackground(new java.awt.Color(254, 254, 254));
        Student.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        Student.setText("Student Record Database Management");
        Student.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        Student.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                StudentActionPerformed(evt);
            }
        });
        add(Student, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 260, 260, 70));

        Payroll.setBackground(new java.awt.Color(254, 254, 254));
        Payroll.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        Payroll.setText("Payroll Management Database System");
        Payroll.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        Payroll.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                PayrollActionPerformed(evt);
            }
        });
        add(Payroll, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 260, 260, 70));

        Exit.setBackground(new java.awt.Color(254, 254, 254));
        Exit.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        Exit.setText("Exit");
        Exit.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        Exit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ExitActionPerformed(evt);
            }
        });
        add(Exit, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 460, 60, 40));

        img.setIcon(new javax.swing.ImageIcon("C:\\Users\\kieth\\Documents\\NetbeansProjects\\Database_Project\\resources\\7.png")); // NOI18N
        add(img, new org.netbeans.lib.awtextra.AbsoluteConstraints(6, 6, -1, -1));
    }// </editor-fold>//GEN-END:initComponents

    private void StudentActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_StudentActionPerformed
        Student window = new Student();
        FrameUtils.displayFrameWithPanel(window, "School Database Management");
        FrameUtils.disposeParentFrame(this);
    }//GEN-LAST:event_StudentActionPerformed

    private void PayrollActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_PayrollActionPerformed
        Payroll window = new Payroll();
        FrameUtils.displayFrameWithPanel(window, "Payroll Management System");
        FrameUtils.disposeParentFrame(this);
    }//GEN-LAST:event_PayrollActionPerformed

    private void ExitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ExitActionPerformed
        System.exit(0);
    }//GEN-LAST:event_ExitActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton Exit;
    private javax.swing.JButton Payroll;
    private javax.swing.JButton Student;
    private javax.swing.JLabel img;
    // End of variables declaration//GEN-END:variables
}
