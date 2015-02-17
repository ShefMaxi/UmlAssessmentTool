import javax.swing.*;

public class SimpleFrame extends JFrame
{

    public SimpleFrame()
    {
        setTitle("A simple frame");
        setSize(300, 200);
    }

    public static void main(String[] args)
    {
        JFrame frm = new SimpleFrame();
        frm.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frm.setVisible(true);
    }
}
