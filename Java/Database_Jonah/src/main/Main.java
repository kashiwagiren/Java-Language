/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package main;

import javax.swing.*;
import window.Applicant;

public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        JFrame frame = new JFrame("Application Database Management");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setResizable(false);
        var screen = new Applicant();
        frame.add(screen);
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setFocusable(true);
        frame.setVisible(true);
    }
    
}
