import javax.swing.*;
import java.awt.*;

public class CentreFrame extends JFrame
{

    public CentreFrame()
    {
        setTitle("A centred frame");
        // use a toolkit to get system dependent info
        Toolkit tk = Toolkit.getDefaultToolkit();
        // Dimension encapsulates width and height
        Dimension dim = tk.getScreenSize();
        // window should have same h:w ratio as screen and 1/4 the area
        setSize(dim.width / 2, dim.height / 2);
        // centre window on screen
        setLocation(new Point(dim.width / 4, dim.height / 4));
    }

    public static void main(String[] args)
    {
        JFrame frm = new CentreFrame();
        frm.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frm.setVisible(true);
    }
}
