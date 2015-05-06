import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Counter implements ActionListener
{
    // aggiungo a counter label, un oggetto di tipo JLabel
    private JLabel label;

    // e il relativo costruttore per iniziallizare questo campo
    public Counter (JLabel _label) {
        label = _label;
    }

    // lascio come prima, il label utilizzato è quello di Counter che è uguale a quello di CounterPanel
    // perché gli è stato passato dal costruttore
    public void actionPerformed(ActionEvent e)
    {
        int current = Integer.parseInt(label.getText());
        label.setText(""+(current+1)); 
        label.repaint();
    }
}
