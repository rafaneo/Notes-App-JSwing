/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package NotesApplication;
import java.awt.*;
import javax.swing.*;
import java.io.*;
import java.awt.event.*;
import javax.swing.plaf.metal.*;
import javax.swing.text.*;
/**
 *
 * @author rafai
 */
public class About extends JFrame{
    private JButton b ; 
    
    
    public About(){ 
        super("About"); 
        b = new JButton("About this application"); 
        
        
        AboutHandler handler = new AboutHandler();
        add(b); 
        b.addActionListener(handler);
    }
    public class AboutHandler implements ActionListener{ 

        
        public void actionPerformed(ActionEvent e) {
                
                if (e.getSource() == b){ 
                    
                    JOptionPane.showMessageDialog(null, "This Applicating was made by Rafael Neocleous thank you for your time :)" , "About" ,JOptionPane.NO_OPTION);
                    
                }
        }
        
        
        
    } 
    
    
}
