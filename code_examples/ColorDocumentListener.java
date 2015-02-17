import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.*;
import javax.swing.text.*;

public class ColorDocumentListener implements DocumentListener
{

    public ColorDocumentListener(JTextComponent rComp, JTextComponent gComp,
            JTextComponent bComp, Component comp)
    {
        red = rComp;
        green = gComp;
        blue = bComp;
        target = comp;
    }

    public void insertUpdate(DocumentEvent e)
    {
        setTargetColor();
    }

    public void removeUpdate(DocumentEvent e)
    {
        setTargetColor();
    }

    public void changedUpdate(DocumentEvent e)
    {
    }

    private void setTargetColor()
    {
        float r = 0.0f, g = 0.0f, b = 0.0f;
        try
        {
            r = Float.parseFloat(red.getText().trim());
            g = Float.parseFloat(green.getText().trim());
            b = Float.parseFloat(blue.getText().trim());
        } catch (NumberFormatException nfe)
        { // do nowt
        };
        if (validRGB(r, g, b))
        {
            target.setBackground(new Color(r, g, b));
            target.repaint();
        }

    }

    private boolean validRGB(float r, float g, float b)
    {
        return (r >= 0.0) && (g >= 0.0) && (b >= 0.0) && (r <= 1.0)
                && (g <= 1.0) && (b <= 1.0);
    }

    private Component target;
    private JTextComponent red;
    private JTextComponent green;
    private JTextComponent blue;
}
