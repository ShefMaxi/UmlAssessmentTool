import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class ColorAction2 implements ActionListener
{

    public ColorAction2(Color c, JComponent comp)
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
