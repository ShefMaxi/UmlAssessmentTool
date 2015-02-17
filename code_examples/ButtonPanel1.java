import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class ButtonPanel1 extends JPanel implements ActionListener
{

    // here, the panel itself acts as an action listener
    // note that this is not generally recommended since a
    // panel typically contains many events to listen for
    // and hence would need extra code to decide which GUI element
    // actually generated the event
    public ButtonPanel1()
    {

        greenButton = new JButton("Green");
        blueButton = new JButton("Blue");
        redButton = new JButton("Red");

        add(greenButton);
        add(blueButton);
        add(redButton);

        greenButton.addActionListener(this);
        blueButton.addActionListener(this);
        redButton.addActionListener(this);
    }

    public void actionPerformed(ActionEvent evt)
    {
        Object source = evt.getSource();

        System.out.println(evt.getActionCommand());

        Color c = getBackground();
        if (source == greenButton)
            c = Color.green;
        else if (source == blueButton)
            c = Color.blue;
        else if (source == redButton)
            c = Color.red;

        setBackground(c);
        repaint();

    }

    private JButton greenButton;
    private JButton blueButton;
    private JButton redButton;

    public static void main(String[] args)
    {
        JFrame cf = new CentreFrame();
        JPanel bp = new ButtonPanel1();
        cf.getContentPane().add(bp);
        cf.setVisible(true);
    }
}
