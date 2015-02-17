import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class DrawFrame extends CentreFrame
{

    public DrawFrame()
    {
        setTitle("Draw Frame");
        getContentPane().add(new DrawPanel());
    }

    public static void main(String[] args)
    {
        JFrame frm = new DrawFrame();
        frm.setVisible(true);
    }

}
