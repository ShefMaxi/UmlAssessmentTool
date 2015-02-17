import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class BoxLayoutFrame extends CentreFrame
{

    public BoxLayoutFrame()
    {
        Box b = Box.createHorizontalBox();
        b.add(new JButton("button 1"));
        b.add(Box.createHorizontalStrut(10));
        b.add(new JButton("button 2"));
        b.add(Box.createGlue());
        b.add(new JButton("keep your distance"));
        getContentPane().add(b); // add box to frame
    }

    public static void main(String[] args)
    {
        JFrame cf = new BoxLayoutFrame();
        cf.setVisible(true);
    }

}
