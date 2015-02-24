package compareUML;

import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.MouseAdapter;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;

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
		
		}
	}

