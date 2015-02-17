import javax.swing.*;
import java.awt.*;

public class ButtonInPanel extends CentreFrame
{

    public ButtonInPanel()
    {
        setTitle("Centred frame with a panel and two buttons");
        Container contentPane = getContentPane();
        JPanel p = new JPanel();
        contentPane.add(p);
        JButton jb = new JButton("Go on, press me!");
        p.add(jb);
        p.add(new JButton("no, press me instead!"));
    }

    public static void main(String[] args)
    {
        JFrame frm = new ButtonInPanel();
        frm.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frm.setVisible(true);
    }
}
