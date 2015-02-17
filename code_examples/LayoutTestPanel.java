import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class LayoutTestPanel extends JPanel
{

    public LayoutTestPanel()
    {

        // uncomment the one you want, or leave all commented to get the
        // default, which is a flow layout
        // setLayout(new BorderLayout());
        // setLayout(new GridLayout(3,2));
        setLayout(new BoxLayout(this, BoxLayout.X_AXIS));
        add(new JButton("north"), BorderLayout.NORTH);
        add(new JButton("south"), BorderLayout.SOUTH);
        add(new JButton("east"), BorderLayout.EAST);
        add(new JButton("west"), BorderLayout.WEST);
        add(new JButton("centre"), BorderLayout.CENTER);

    }

    public static void main(String[] args)
    {
        JFrame cf = new CentreFrame();
        JPanel bp = new LayoutTestPanel();
        cf.getContentPane().add(bp);
        cf.setVisible(true);
    }

}
