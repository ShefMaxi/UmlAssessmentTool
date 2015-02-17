import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class DrawFrame2 extends CentreFrame
{

    public DrawFrame2()
    {
        setTitle("Draw Frame2");
        getContentPane().add(new DrawPanel2());
    }

    public static void main(String[] args)
    {
        JFrame frm = new DrawFrame2();
        frm.setVisible(true);
    }

}
