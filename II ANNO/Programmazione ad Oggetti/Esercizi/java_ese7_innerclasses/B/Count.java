import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

class Count
{
    public static void main(String[] args)
    {
        JFrame f = new CountFrame();
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.pack(); 
        f.setLocation(300,300);
        f.setSize(200,70);
        f.setVisible(true);
    }
}
