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
       btn.addActionListener(new Counter());
    }

    public JLabel getLabel() { return label; }
    private JButton btn;
    private JLabel label;

    private class Counter implements ActionListener
    {
        public void actionPerformed(ActionEvent e)
        {
            int current = Integer.parseInt(label.getText());
            label.setText(""+(current+1)); 
            label.repaint();
        }
    }
}
