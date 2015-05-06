/** 
 *  Un account e' caratterizzato da un user id, una password
 *  ed un saldo, ed un campo che informa se l'account ha una 
 *  sessione attiva. Invariante: 
 *      a) un account ha una sessione attiva, sse session >=0
 *      b) un account ha al piu' una sessione attiva
 */

class Account
{
    /**
     * costruttore: crea un nuovo account. Inizialmente il conto
     *  non ha sessioni attive
     *  @param uid = user id
     *  @param pwd = password
     *  @param balance = saldo iniziale
     */

    public Account(int _uid, String _pwd, double _balance)
    {
	uid = _uid;
	pwd = _pwd;
	balance = (_balance < 0) ? 0 : _balance;
	session = -1.0;
    }

    /**
     * metodi di autenticazione
     */

    /**
     *  Attiva una una sessione se l'autenticazione ha successo e non
     *  vi sono sessioni attive associate al conto. 
     *  @param uid = user id
     *  @param pwd = password
     *  @return nuova sessione se autenticazione ha successo; null altrimenti
     *  @post session = id associato alla sessione creata;
     *          
     */
    public Session login(int uid, String pwd)
    {
	if (session < 0 && this.uid == uid && this.pwd.equals(pwd)) {
	    session = Math.abs(Math.random())+1;
	    return new Session(session, this); 
	}
	else return null;
    }

    /**
     *  Chiude una sessione, se la richiesta ha successo; 
     *  @return true sse la richiesta ha avuto successo
     *  @param sid= id della sessione da chiudere 
     *  @post session < 0 sse sid == session@pre 
     */
    public boolean logout(double sid)
    {

	if (sid == session)
	    {
		session = -1;
		return true;
	    }
	return false;
    }

    /**
     * metodi per operazioni
     */

    /**
     * deposita l'importo, se la richiesta e' per la sessione corrente
     * @return sid == session
     * @post (sid == session)  ==> balance = balance@pre + amount
     */

    public boolean deposit(double amount, double sid)
    {
	boolean ok = (sid == session);
	if (ok) balance += amount;
	return ok;
    }

    /**
     * preleva  l'importo, se la richiesta e' per la sessione corrente
     * @return sid == session
     * @post (sid == session)  ==> balance = balance@pre - amount
     */

    public boolean withdraw(double amount, double sid)
    {
	boolean ok = (sid == session);
	if (ok) balance -= amount;
	return ok;
    }

    /**
     * restituisce il saldo, se la richiesta e' per la sessione corrente
     * @return (sid == session) ? balance : NaN
     */
    public double balance(double sid)
    {
	boolean ok = (sid == session);
	if (ok) return balance; 
	else return Double.NaN;
    }

    /**
     * rappresentazione: il conto e' attivo in una sessione
     * sse session > 0;  session > 0 e' l'identificatore di sessione
     */
    
    private double balance; 
    private int uid;	      
    private String pwd;
    private double session;
}
