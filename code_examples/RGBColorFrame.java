import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.*;

public class RGBColorFrame extends CentreFrame
{

    public RGBColorFrame()
    {

        Container cpane = getContentPane();
        JPanel panel = new JPanel(); // for the colour change
        cpane.add(panel, BorderLayout.CENTER);
        JPanel textPanel = new JPanel(); // for the textfields
        cpane.add(textPanel, BorderLayout.NORTH);

        // A text field for each of the RGB values
        JTextField RField = new JTextField("0.5", 5);
        JTextField GField = new JTextField("0.5", 5);
        JTextField BField = new JTextField("0.5", 5);
        panel.setBackground(new Color((float) 0.5, (float) 0.5, (float) 0.5));

        ColorDocumentListener RGBListener = new ColorDocumentListener(RField,
                GField, BField, panel);

        RField.getDocument().addDocumentListener(RGBListener);
        GField.getDocument().addDocumentListener(RGBListener);
        BField.getDocument().addDocumentListener(RGBListener);

        textPanel.add(RField);
        textPanel.add(GField);
        textPanel.add(BField);

        cpane.setVisible(true);

    }
    public static void main(String[] args)
    {
        JFrame cf = new RGBColorFrame();
        cf.setVisible(true);
    }

}
