import java.util.*;

class ArticlePage extends Page 
{
    
    private String header = "";

    public ArticlePage(String title, List<String> authors, 
		       int np, List<String> text)
    {
	super(np,text);
	if ((np % 2) == 0) 
	    header = title;
        else
	    for (String a : authors) 
		header += a + " ";
    }


    public String layout() 
    { 
	return header + "\n" + super.layout();
    }
}
