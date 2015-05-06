import javax.swing.*;
import java.awt.event.*;
import java.awt.*;

public class Banking 
{
    public static void main(String[] args)
    {
	JFrame mainw = new BankGUI(new Bank());
	mainw.setSize(500,400);
	mainw.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	mainw.setVisible(true);
    }
}