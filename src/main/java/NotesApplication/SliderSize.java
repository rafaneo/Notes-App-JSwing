/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package NotesApplication;
import java.awt.*;
import javax.swing.*;
import java.io.*;
import java.awt.event.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import javax.swing.plaf.metal.*;
import javax.swing.text.*;


/**
 *
 * @author rafai
 */
public class SliderSize extends JFrame {
    private JSlider slider ;
    public  String text1 ;  
    SliderSize(String t){ 
        super("Text Size"); 
        text1 = t ; 
        slider = new JSlider(SwingConstants.HORIZONTAL, 0, 200 ,10); 
        slider.setMajorTickSpacing(10);
        slider.setPaintTicks(true );
        
        add(slider, BorderLayout.SOUTH); 
        
        
        slider.addChangeListener(
        
                new ChangeListener(){ 
                    @Override
                    public void stateChanged(ChangeEvent e) {
                            
                            NotesFrame text = new NotesFrame(text1); 
                            int fontSize = slider.getValue();
                            Font font = new Font("Serif" , Font.PLAIN , fontSize);
                            text.t.setFont(font);
                            text.t.setText(text1);
                           
                    }
                }
        );
    }
    
}
