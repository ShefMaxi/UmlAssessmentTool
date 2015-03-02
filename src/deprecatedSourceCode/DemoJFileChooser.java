package deprecatedSourceCode;
import javax.swing.*;
import java.awt.event.*;
import java.awt.*;
import java.util.*;


public class DemoJFileChooser extends JPanel
   implements ActionListener {
   JButton go;
   JButton lxmi;
   
   JFileChooser chooser;
   String choosertitle;
   
  public DemoJFileChooser() {
    go = new JButton("Upload student file");
    lxmi=new JButton("upload lexturer's xmi");
    
    go.addActionListener(this);
    add(go);
    lxmi.addActionListener(this);
    add(lxmi);
   }
  public void interface1(){
	  JButton button=new JButton("Compare");
	  button.setLocation(50,50);
	  button.setSize(10, 10);
  }

  public void actionPerformed(ActionEvent e) {
    int result;
        
    chooser = new JFileChooser(); 
    chooser.setCurrentDirectory(new java.io.File("."));
    chooser.setDialogTitle(choosertitle);
    //chooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
    chooser.setFileSelectionMode(JFileChooser.FILES_ONLY);
    //
    // disable the "All files" option.
    //
    chooser.setAcceptAllFileFilterUsed(false);
    //    
    if (chooser.showOpenDialog(this) == JFileChooser.APPROVE_OPTION) { 
      System.out.println("getCurrentDirectory(): " 
         +  chooser.getCurrentDirectory());
      System.out.println("getSelectedFile() : " 
         +  chooser.getSelectedFile());
      }
    else {
        System.out.println("No Selection ");
        }
       }
     
    public Dimension getPreferredSize(){
      return new Dimension(200, 200);
      }
      
    public static void main(String s[]) {
      JFrame frame = new JFrame("");
      DemoJFileChooser panel = new DemoJFileChooser();
      frame.addWindowListener(
        new WindowAdapter() {
          public void windowClosing(WindowEvent e) {
            System.exit(0);
            }
          }
        );
      frame.getContentPane().add(panel,"Center");
      frame.setSize(panel.getPreferredSize());
      frame.setVisible(true);
      }
  }
