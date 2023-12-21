/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package main;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;

public class FrameUtils {
    
    public static void displayFrameWithPanel(JPanel panel, String titleText) {
        JFrame frame = new JFrame(titleText);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setResizable(false);
        frame.add(panel);
        frame.pack();
        frame.setTitle("Coffee Management System");
        frame.setLocationRelativeTo(null);
        frame.setFocusable(true);
        frame.setVisible(true);
    }

    public static void disposeParentFrame(JPanel childPanel) {
        SwingUtilities.getWindowAncestor(childPanel).dispose();
    }
    
}
