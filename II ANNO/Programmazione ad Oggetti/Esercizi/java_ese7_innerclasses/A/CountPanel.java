import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

class CountPanel extends JPanel
{
    public CountPanel()
    {
       btn = new JButton("Click me");
       label = new JLabel("0"); 
       add(btn); add(label);
       // Counter utilizza label di tipo JLabel
       // passo a Counter label
       btn.addActionListener(new Counter(label));
    }

    public JLabel getLabel() { return label; }
    private JButton btn;
    private JLabel label;
}
