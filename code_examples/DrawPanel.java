import javax.swing.*;
import java.awt.*;
import java.awt.geom.*;

public class DrawPanel extends JPanel
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
        Rectangle2D aRect = new Rectangle2D.Double(leftX, topY, width, height);
        g2.draw(aRect);
        Ellipse2D anEllipse = new Ellipse2D.Double();
        anEllipse.setFrame(aRect);
        g2.draw(anEllipse);
        g2.draw(new Line2D.Double(leftX, topY, leftX + width, topY + height));
    }

}
