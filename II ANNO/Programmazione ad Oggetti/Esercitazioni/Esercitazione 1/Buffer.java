import java.util.*;
/** 
  Un buffer di n caratteri, con una operazione di undo().
*/ 
class Buffer 
{ 

    private class BackupPair
    {
	int position;
	char character;
	BackupPair(int position, char character) 
	{
	    this.position = position;
	    this.character = character;
	}
    }

    private ArrayList<BackupPair> undoStack = new ArrayList<BackupPair>();
    private char[] contents; 

    /** 
      crea il buffer
    */
    public Buffer(int n) 
    { 
	contents = new char[n];
    }       

    /** 
      scrive il carattere c sulla posizione i
    */
    public void set(int i, char c) throws ArrayIndexOutOfBoundsException
    { 
	undoStack.add(0,new BackupPair(i, contents[i]));
	contents[i] = c;
    }

    /** 
      legge il carattere in posizione i 
    */
    public char get(int i) throws ArrayIndexOutOfBoundsException
    { 
	return contents[i];
    }

    /** 
       annulla l'effetto delle operazioni set. In particolare 
       annulla l'effetto dell'ultima set() che non sia stata gia'
       annullata; se non ci sono set() da annullare, non ha effetto
       Esempio:
        // OPERAZIONE           // STATO DEL BUFFER (_ = carattere nullo)
        b = new Buffer(4);      // _::_::_::_
        b.set(1,'a');	        // _::a::_::_
        b.set(1,'b');           // _::b::_::_
        b.undo();               // _::a::_::_
        b.set(3,'c');           // _::a::_::c
        b.undo();   	        // _::a::_::_
        b.undo();   	        // _::_::_::_
        b.undo();   	        // _::_::_::_
     */

    public void undo() 
    {
	if (undoStack.size()  <= 0) return;
	BackupPair p = undoStack.remove(0);
	contents[p.position] = p.character;
    }

    public String toString()
    {
	String out = "";
	for (int i = 0; i < contents.length - 1; i++) 
	    out += ((contents[i] == '\0') ? '_': contents[i]) +"::";
	out += (contents[contents.length-1] == '\0') ? '_'
	    : contents[contents.length-1];
	return out;
    }
}