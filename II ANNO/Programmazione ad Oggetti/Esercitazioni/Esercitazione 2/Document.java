import java.util.*;

abstract class Document
{
    // autori
    private List<String> authors; 

    // titolo
    private String title; 

    // lista delle pagine
    private List<Page> pages; 

    /** crea una pagina con numero n e testo text */
    public abstract Page createPage(int n, String text);

    /**
       costruisce un documento con authors come autori, title come titolo
       titolo ed una lista di pagine che corrisponde alla lista dei testi ts
    */
    public Document(List<String> authors, String title, List<String> ts)
    {
	pages = new ArrayList<Page>();
	this.authors = authors; 
	this.title = title; 
	int p = 1; 
	for (String t : ts) 
	    pages.add(createPage(p++, t));
    }
		      

    /**
       restituisce la stringa ottenuta concatenando il layout della 
       lista di pagine 
    */
    public String print() 
    { 
	String doc = "";
	for (Page p : pages) doc += p.layout();
	return doc;
    }
	
    protected List<String> getAuthors()
    {
	return authors;
    }

    protected String getTitle()
    {
	return title;
    }
}
