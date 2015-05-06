import java.util.*;

class DraftPage extends Page 
{
    
    private String header = "Draft: do not circulate";

    public DraftPage(int np, List<String> text)
    {
	super(np,text);
    }

    public String layout() 
    { 
	return header + "\n" + super.layout();
    }
}
