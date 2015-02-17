import javax.swing.*;
import java.awt.*;

public class ContentPane extends CentreFrame
{

    public ContentPane()
    {
        setTitle("Centred frame with 2 buttons");
        Container contentPane = getContentPane();
        JButton jb = new JButton("Go on, press me!");
        contentPane.add(jb);
        contentPane.add(new JButton("No, ME!"));
    }

    public static void main(String[] args)
    {
        JFrame frm = new ContentPane();
        frm.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frm.setVisible(true);
    }
}
