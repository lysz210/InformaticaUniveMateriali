import javax.swing.*;
import java.awt.event.*;
import java.awt.*;

class BankGUI extends JFrame 
{
    private Bank bank;

    final int FIELD_WIDTH = 10;
    JTextArea output = new JTextArea(FIELD_WIDTH, 30);
    JButton newacct  = new JButton("Crea un nuovo conto");
    JButton login    = new JButton("Accedi ad un conto");

    JPanel mainPanel = new JPanel(new BorderLayout());
    JPanel buttonPanel = new JPanel(new GridLayout(2,2));
    JPanel loginInputs = new JPanel();
    JPanel createInputs = new JPanel();

    public BankGUI(Bank b) 
    {
	bank = b;
	output.setEditable(false);
	output.setFont(new Font("Verdana",Font.BOLD,14));
	//	loginInputs.add(new JLabel("numero del conto"));
	//	loginInputs.add(uid);
	// loginInputs.add(new JLabel("password"));
	//	loginInputs.add(pwd);
	//	createInputs.add(new JLabel("scegli una password"));
	//	createInputs.add(newpwd);
	buttonPanel.add(newacct);
	//	buttonPanel.add(createInputs);
	buttonPanel.add(login);
	//	buttonPanel.add(loginInputs);
	mainPanel.add(buttonPanel,BorderLayout.NORTH);
	mainPanel.add(new JScrollPane(output),BorderLayout.CENTER);

	add(mainPanel);
	newacct.addActionListener(
                new ActionListener()
		{ 
		    public void actionPerformed(ActionEvent e)
		    {
			String pwd = JOptionPane.showInputDialog("Scegli una password");
			// String pwd = newpwd.getText();
			if (pwd.length() < 2) 
			    output.append("Errore: scegli una una password piu' lunga\n");
			else {
			    int uid = bank.newAccount(pwd,0.0);
			    output.append("Creato un conto con numero "); 
			    output.append(uid + "\n");
			}
		    }
		});    
	login.addActionListener(
                new ActionListener()
		{ 
		    public void actionPerformed(ActionEvent e)
		    {
			try { 
			    int uid = Integer.parseInt(JOptionPane.showInputDialog("Numero di Conto"));
			    String pwd = JOptionPane.showInputDialog("Password"); 
			    Session s = bank.login(uid, pwd); 
			    if (s !=null) {
				SessionGUI sgui = new SessionGUI(s); 
				sgui.setTitle("Conto numero "+uid);
				sgui.setSize(500,300);
				sgui.setVisible(true);
			    }
			    else {
				output.append("Errore: assicurarsi che\n"); 
				output.append("tutte le sessioni del conto siano chiuse\n");
				output.append("numero conto e password siano corrette\n");
			    }
			}
			catch (NumberFormatException exc) {
			    output.append("Errore: numero di conto non valido\n");
			}
			catch (IndexOutOfBoundsException exc) {
			    output.append("Errore: numero di conto non valido\n");
			}
		    }
		});    
   }
}    