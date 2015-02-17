import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class ButtonPanel2 extends JPanel
{

    // Here, we employ a separate class to act as the ActionListener
    public ButtonPanel2()
    {

        greenButton = new JButton("Green");
        blueButton = new JButton("Blue");
        redButton = new JButton("Red");

        add(greenButton);
        add(blueButton);
        add(redButton);

        ColorAction2 greenAction = new ColorAction2(Color.GREEN, this);
        ColorAction2 blueAction = new ColorAction2(Color.BLUE, this);
        ColorAction2 redAction = new ColorAction2(Color.RED, this);

        greenButton.addActionListener(greenAction);
        blueButton.addActionListener(blueAction);
        redButton.addActionListener(redAction);
    }

    private JButton greenButton;
    private JButton blueButton;
    private JButton redButton;

    public static void main(String[] args)
    {
        JFrame cf = new CentreFrame();
        JPanel bp = new ButtonPanel2();
        cf.getContentPane().add(bp);
        cf.setVisible(true);
    }

}
