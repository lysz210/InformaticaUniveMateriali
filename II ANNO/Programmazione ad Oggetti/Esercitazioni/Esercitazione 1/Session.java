public class Session 
{
    public Session(double sid, Account acct)
    {
	this.sid = sid;
	this.acct = acct;
    }

    public String deposit(double amount)
    {
	boolean status = acct.deposit(amount, sid);
	return notify("deposito effettuato:  " +amount, status);
    }

    public String withdraw(double amount)
    {
	boolean status = acct.withdraw(amount, sid);
	return notify("prelievo effettuato: " +amount, status);
    }

    public String balance()
    {
	double bal = acct.balance(sid);
	return notify("saldo: " + bal, bal != Double.NaN);
    }
    
    public String logout()
    {
	boolean status = acct.logout(sid);
	return notify("logout", status);
    }

    private String notify(String operation, boolean status)
    {
	if (status) return operation;
	else return operation+": errore: sessione non attiva"; 
    }

    private double sid;
    private Account acct;
}
    