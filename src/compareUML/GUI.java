package compareUML;

import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;
//Interface written by Shupeng
public class GUI extends JFrame{
		private JPanel panel1=new JPanel();
		private JPanel panel2=new JPanel();
		public GUI(){
			setSize(500,250);
			setLocation(400,400);
			setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			layoutPanel1();
			layoutPanel2();
			setLayout(new GridLayout(1,1));
			add(panel1);
			add(panel2);	
		}
		private void layoutPanel1(){
			JFileChooser chooser = new JFileChooser();
			JButton button1=new JButton("upload lecuturer's XMI files");
			JButton button2=new JButton("upload student's XMI files");
			JButton button3=new JButton("compare");
			JButton button4=new JButton("reset");
			JButton button5=new JButton("help");
			panel1.setLayout(new FlowLayout());
			panel1.add(button1);
			panel1.add(button2);
			panel1.add(button3);
			panel1.add(button4);
			panel1.add(button5);
			// upload function
			button1.addMouseListener(new MouseAdapter(){
				public void mouseClicked(MouseEvent event){
			int i = chooser.showOpenDialog(button1);	
		    if(i== chooser.APPROVE_OPTION){  // open file
		        String path = chooser.getSelectedFile().getAbsolutePath();
		        String name = chooser.getSelectedFile().getName();
		        System.out.println("get current path£º"+path+";\n get current name£º"+name);
		    }else{
		        System.out.println("There is no Selection");
		    }
				   
			}
		});
			button2.addMouseListener(new MouseAdapter(){
				public void mouseClicked(MouseEvent event){
			int i = chooser.showOpenDialog(button1);	
		    if(i== chooser.APPROVE_OPTION){ 
		        String path = chooser.getSelectedFile().getAbsolutePath();
		        String name = chooser.getSelectedFile().getName();
		        System.out.println("get current path£º"+path+";\n get current name£º"+name);
		    }else{
		        System.out.println("There is no Selection");
		    }
				   
			}
		});
		}
		private void layoutPanel2(){
			JButton button=new JButton("score");
			JTextField textField=new JTextField();
			panel2.setLayout(null);
			button.setLocation(20,20);
			button.setSize(100,20);
			textField.setBounds(20, 50, 200, 100);
			panel2.add(textField);
			panel2.add(button);
			button.addMouseListener(new MouseAdapter(){
				public void mouseClicked(MouseEvent event){
					textField.setText("waiting");
				}
			});
		}
	}

