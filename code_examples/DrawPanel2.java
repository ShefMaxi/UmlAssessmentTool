import javax.swing.*;
import java.awt.*;
import java.awt.geom.*;

public class DrawPanel2 extends JPanel
{

    public void paintComponent(Graphics g)
    {
        super.paintComponent(g);
        Graphics2D g2 = (Graphics2D) g;

        Dimension dim = getSize(null);
        double leftX = dim.width / 4.0;
        double topY = dim.height / 4.0;
        double width = dim.width / 2.0;
        double height = dim.height / 2.0;

        // set up a shape
        Rectangle2D aRect = new Rectangle2D.Double(leftX, topY, width, height);
        g2.setPaint(Color.RED); // change colour
        g2.draw(aRect);

        // and another one
        Ellipse2D anEllipse = new Ellipse2D.Double();
        anEllipse.setFrame(aRect);
        g2.setStroke(new BasicStroke(10.0F)); // 10 pixel thick line
        g2.setPaint(Color.GREEN); // change colour again
        g2.draw(anEllipse);

        // now change transformation and redraw
        g2.scale(0.5, 0.5);
        g2.draw(anEllipse);

        // finally, a line
        Line2D aLine = new Line2D.Double(leftX, topY, leftX + width, topY
                + height);
        g2.draw(aLine);

        // set background colour
        setBackground(new Color(200, 255, 255));
    }

}
