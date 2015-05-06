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
       // passo un l'actionlistener creato dalla classe anonima
       btn.addActionListener(listener);
    }

    public JLabel getLabel() { return label; }
    private JButton btn;
    private JLabel label;

    // creo un action listener come classe anonima
    ActionListener listener = new ActionListener(){
        public void actionPerformed(ActionEvent evt) {

            int current = Integer.parseInt(label.getText());
            label.setText(""+(current+1)); 
            label.repaint();
        }
    };
}
