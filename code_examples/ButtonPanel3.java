import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class ButtonPanel3 extends JPanel
{

    // Here, the separate class is declared as a local inner class
    // to prevent a profusion of small classes in separate files
    public ButtonPanel3()
    {

        greenButton = new JButton("Green");
        blueButton = new JButton("Blue");
        redButton = new JButton("Red");

        add(greenButton);
        add(blueButton);
        add(redButton);

        ColorAction greenAction = new ColorAction(Color.GREEN, this);
        ColorAction blueAction = new ColorAction(Color.BLUE, this);
        ColorAction redAction = new ColorAction(Color.RED, this);

        greenButton.addActionListener(greenAction);
        blueButton.addActionListener(blueAction);
        redButton.addActionListener(redAction);
    }

    private class ColorAction implements ActionListener
    {

        public ColorAction(Color c, JComponent comp)
        {
            theColor = c;
            theComponent = comp;
        }

        public void actionPerformed(ActionEvent e)
        {
            theComponent.setBackground(theColor);
        }

        private JComponent theComponent;
        private Color theColor;
    }

    private JButton greenButton;
    private JButton blueButton;
    private JButton redButton;

    public static void main(String[] args)
    {
        JFrame cf = new CentreFrame();
        JPanel bp = new ButtonPanel3();
        cf.getContentPane().add(bp);
        cf.setVisible(true);
    }

}
