import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class ButtonPanel5 extends JPanel
{

    // makeButton uses an anonymous inner class as the action listener
    // note that any local variable accessed in an inner class has
    // to be declared as final ie as a constant

    public ButtonPanel5()
    {
        makeButton("green", Color.GREEN);
        makeButton("red", Color.RED);
        makeButton("blue", Color.BLUE);
    }

    private void makeButton(String name, final Color col)
    {
        JButton button = new JButton(name);
        add(button);
        button.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent e)
            {
                setBackground(col);
            }
        });
    }

    public static void main(String[] args)
    {
        JFrame cf = new CentreFrame();
        JPanel bp = new ButtonPanel5();
        cf.getContentPane().add(bp);
        cf.setVisible(true);
    }

}
