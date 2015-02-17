import javax.swing.*;
import java.awt.*;

public class HelloWorldFrame extends CentreFrame
{

    public HelloWorldFrame()
    {
        setTitle("Hello World frame");

        // get the content pane of the frame and add a panel to it
        Container cpane = getContentPane();
        cpane.add(new HelloWorldPanel());
    }

    public static void main(String[] args)
    {
        JFrame frm = new HelloWorldFrame();
        frm.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frm.setVisible(true);
    }
}
