import javax.swing.*;
import java.awt.event.*;
import java.awt.*;

class SessionGUI extends JFrame 
{
    private Session session;

    final int FIELD_WIDTH = 10;
    final JTextField amount = new JTextField(FIELD_WIDTH);
    JTextArea output = new JTextArea(FIELD_WIDTH, 30);
    JButton deposit  = new JButton("Deposita");
    JButton withdraw = new JButton("Preleva");
    JButton balance  = new JButton("Saldo");
    JButton logout   = new JButton("Esci");

    JPanel mainPanel = new JPanel(new BorderLayout());
    JPanel buttonPanel = new JPanel(new BorderLayout());
    JPanel buttons = new JPanel();

    public SessionGUI(Session s) 
    {
	session = s;
	output.setEditable(false);
	output.setFont(new Font("Verdana",Font.BOLD,18));
	amount.setFont(new Font("Verdana",Font.BOLD,18));
	buttons.add(deposit);
	buttons.add(withdraw);
	buttons.add(balance);
	buttons.add(logout);

	buttonPanel.add(buttons,BorderLayout.NORTH);
	buttonPanel.add(amount,BorderLayout.CENTER);
	mainPanel.add(buttonPanel,BorderLayout.NORTH);
	mainPanel.add(new JScrollPane(output),BorderLayout.CENTER);
	add(mainPanel);
	deposit.addActionListener(
                new ActionListener()
		{ 
		    public void actionPerformed(ActionEvent e)
		    {
			try {
			    double amnt = Double.parseDouble(amount.getText());
			    output.append(session.deposit(amnt) + "\n");
			} 
			catch (NumberFormatException exc) {
			    output.append("importo non valido\n");
			}
		    }
		});    
	withdraw.addActionListener(
                new ActionListener()
		{ 
		    public void actionPerformed(ActionEvent e)
		    {
			try {
			    double amnt = Double.parseDouble(amount.getText());
			    output.append(session.withdraw(amnt) + "\n");
			}
			catch (NumberFormatException exc) {
			    output.append("importo non valido\n"); 
			}
		    }
		});    

	logout.addActionListener(
                new ActionListener()
		{ 
		    public void actionPerformed(ActionEvent e)
		    {
			session.logout();
			SessionGUI.this.setVisible(false);
		    }
		});    


	balance.addActionListener(
                new ActionListener()
		{ 
		    public void actionPerformed(ActionEvent e)
		    {
			output.append(session.balance() + "\n");
		    } 
		});    

   }
}    