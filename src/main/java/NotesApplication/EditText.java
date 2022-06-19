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
public class EditText extends JFrame implements ItemListener, ActionListener{
    
    public String text ; 
    private JLabel l1 ; 
    private JCheckBox c1;
    private JRadioButton r1, r2;
    private JPanel optPanel; 
    private ButtonGroup group ;
    private JButton b1 ; 
    
    public EditText(String t){ 
      
    super("Edit text");     
    
    text = t; 
    
    
    setLayout(new FlowLayout()); 
    
    l1 = new JLabel("Edit text :");
    r1 = new JRadioButton("Uppercase"); 
    r2 = new JRadioButton("Lowercase");
    
    c1 = new JCheckBox("Bold"); 
    
    b1 = new JButton("Text Size"); 
    
    group = new ButtonGroup();

    group.add(r1);
    group.add(r2);
    
    add(l1); 
    add(c1); 
    add(r1); 
    add(r2); 
    add(b1);
        
    r1.addItemListener(this);
    r2.addItemListener(this);
    c1.addItemListener(this);
    b1.addActionListener(this);
    }

    @Override
    public void itemStateChanged(ItemEvent e) {
        
         if (e.getSource() == r1){ 
            String textnew = "" ;   
            textnew =text ;
            textnew = textnew.toUpperCase();
            text = textnew;
            NotesFrame text = new NotesFrame(textnew);
            text.t.setText(textnew);
        }else if (e.getSource() == r2){ 
            String textnew = "" ;   
            textnew =text ;
            textnew = textnew.toLowerCase();
            text = textnew;
            NotesFrame text = new NotesFrame(textnew);
            text.t.setText(textnew);
        }
        else if(e.getSource() == c1){ 
            if (c1.isSelected()){ 
                Font bold = new Font("Serif" , Font.BOLD, 14); 
                String textnew = "" ;   
                textnew =text ;
                NotesFrame text = new NotesFrame(textnew);
                text.t.setFont(bold);
            }
            else { 
                Font plain = new Font("Serif" , Font.PLAIN, 14);
                String textnew = "" ;   
                textnew =text ;
                NotesFrame text = new NotesFrame(textnew);
                text.t.setFont(plain);
                
            }
        }
       
    }

    @Override
    public void actionPerformed(ActionEvent e) {
         if(e.getSource() == b1){ 
             
            SliderSize a = new SliderSize(text);
            a.setSize(400 , 100); 
            a.setVisible(true); 
         }
    }
}
