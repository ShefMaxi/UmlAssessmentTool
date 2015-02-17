import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class ButtonPanel4 extends JPanel
{

    // as for version 3, except we're using a helper method to
    // avoid repetitive code
    public ButtonPanel4()
    {
        makeButton("green", Color.GREEN);
        makeButton("red", Color.RED);
        makeButton("blue", Color.BLUE);
    }

    private void makeButton(String name, Color col)
    {
        JButton button = new JButton(name);
        add(button);
        button.addActionListener(new ColorAction(col, this));
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

    public static void main(String[] args)
    {
        JFrame cf = new CentreFrame();
        JPanel bp = new ButtonPanel4();
        cf.getContentPane().add(bp);
        cf.setVisible(true);
    }

}
