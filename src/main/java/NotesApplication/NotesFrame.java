
package NotesApplication ; 
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
class NotesFrame extends JFrame{
    // Text component
    public static JTextArea t = new JTextArea();
 
    // Frame
    JFrame f;
    
    // Constructor
    NotesFrame(String text){
        System.out.print(text); 
       // t.setText(text);
        
        
    }
    NotesFrame()
    {
        // Create a frame
        f = new JFrame("Notepad");
        
      // Text component
        
        // Create a menubar
        JMenuBar mb = new JMenuBar();
 
        // Create amenu for menu
        JMenu m1 = new JMenu("File");
         
        // Create menu items
        JMenuItem mi1 = new JMenuItem("New");
        JMenuItem mi2 = new JMenuItem("Open");
        JMenuItem mi3 = new JMenuItem("Save");
        
 
        NotesHandler handler = new NotesHandler(); 
        
        // Add action listener
        mi1.addActionListener(handler);
        mi2.addActionListener(handler);
        mi3.addActionListener(handler);
       
 
        m1.add(mi1);
        m1.add(mi2);
        m1.add(mi3);
       
 
        // Create amenu for menu
        JMenu m2 = new JMenu("Edit");
 
        // Create menu items
        JMenuItem mi4 = new JMenuItem("cut");
        JMenuItem mi5 = new JMenuItem("copy");
        JMenuItem mi6 = new JMenuItem("paste");
        JMenuItem mi7 = new JMenuItem("edit"); 
 
        // Add action listener
        mi4.addActionListener(handler);
        mi5.addActionListener(handler);
        mi6.addActionListener(handler);
        mi7.addActionListener(handler);
 
        m2.add(mi4);
        m2.add(mi5);
        m2.add(mi6);
        m2.add(mi7);
        
        JMenuItem mc = new JMenuItem("about");
        
        mc.addActionListener(handler);
 
        mb.add(m1);
        mb.add(m2);
        mb.add(mc);
 
        f.setJMenuBar(mb);
        f.add(t);
        f.setSize(500, 500);
        f.setVisible(true);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
       
    }
 
  private class NotesHandler implements ActionListener
  { 
      
    public void actionPerformed(ActionEvent e)
    {
        String s = e.getActionCommand();
 
        if (s.equals("cut")) {
            t.cut();
        }
        else if (s.equals("copy")) {
            t.copy();
        }
        else if (s.equals("paste")) {
            t.paste();
        }
        else if(s.equals("edit")){ 
            String text = t.getText(); 
           
            EditText eText = new EditText(text);
            eText.setSize(400 , 100); 
            eText.setVisible(true); 
        }
        else if (s.equals("Save")) {
            // I made the program using a file chooser I believe its easier for the user and its an interesting feature
            JFileChooser j = new JFileChooser("f:");
 
            // Invoke the showsSaveDialog function to show the save dialog
            int r = j.showSaveDialog(null);
 
            if (r == JFileChooser.APPROVE_OPTION) {
 
                File fi = new File(j.getSelectedFile().getAbsolutePath()); // finds the abosulute path of the file
 
                try {
                    // Create a file writer
                    FileWriter wr = new FileWriter(fi, false);
 
                    // Create buffered writer to write
                    BufferedWriter w = new BufferedWriter(wr);
 
                    // Write
                    w.write(t.getText());
 
                    w.flush();
                    w.close();
                }
                catch (Exception evt) {
                    JOptionPane.showMessageDialog(f, evt.getMessage());
                }
            }
            // If the user cancelled the operation
            else
                JOptionPane.showMessageDialog(f, "Operation cancelled" ,"Notice Messgae" , JOptionPane.INFORMATION_MESSAGE);
        }
        else if (s.equals("Open")) {
            // Create an object of JFileChooser class
            JFileChooser j = new JFileChooser("f:");
 
            // Invoke the showsOpenDialog function to show the save dialog
            int r = j.showOpenDialog(null);
 
            // If the user selects a file
            if (r == JFileChooser.APPROVE_OPTION) {
                // Set the label to the path of the selected directory
                File fi = new File(j.getSelectedFile().getAbsolutePath());
 
                try {
                    // String
                    String s1 = "", sl = "";
 
                    // File reader
                    FileReader fr = new FileReader(fi);
 
                    // Buffered reader
                    BufferedReader br = new BufferedReader(fr);
 
                    // Initialize sl
                    sl = br.readLine();
 
                    // Take the input from the file
                    while ((s1 = br.readLine()) != null) {
                        sl = sl + "\n" + s1;
                    }
 
                    // Set the text
                    t.setText(sl);
                }
                catch (Exception evt) {
                    JOptionPane.showMessageDialog(f, evt.getMessage());
                }
            }
            // If the user cancelled the operation
            else
                JOptionPane.showMessageDialog(f, "Operation cancelled","Notice Messgae" , JOptionPane.INFORMATION_MESSAGE);
        }
        else if (s.equals("New")) {
            t.setText("");
        }
        else if (s.equals("about")) {
           
            About a = new About();
            a.setSize(400 , 100); 
            a.setVisible(true); 
            
            }
    }
    }
}