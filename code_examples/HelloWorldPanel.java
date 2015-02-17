import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class HelloWorldPanel extends JPanel
{

    public void paintComponent(Graphics g)
    {

        // make sure the superclass does its job
        super.paintComponent(g);

        String s = "Hello World";

        // write in 18 point bold Sans Serif
        Font ssb18 = new Font("SansSerif", Font.BOLD, 18);
        FontMetrics ssb18Metric = g.getFontMetrics(ssb18);
        g.setFont(ssb18);

        // place the string in the middle of the screen
        Dimension dim = getSize(); // size of this panel
        int ws = ssb18Metric.stringWidth(s);
        int fontHeight = ssb18Metric.getHeight();
        int x = (dim.width - ws) / 2;
        int y = (dim.height - fontHeight) / 2;

        g.drawString(s, x, y);
    }
}
