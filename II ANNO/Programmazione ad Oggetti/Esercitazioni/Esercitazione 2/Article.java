import java.util.*;
import java.io.*;

class Article extends Document
{
    /** crea una pagina con numero n e testo text */
    public Page createPage(int n, String text)
    {

	StringReader sr = new StringReader(text);
	Scanner in = new Scanner(sr); 

	ArrayList<String> lines = new ArrayList<String>();
	while (in.hasNextLine())
	    lines.add(in.nextLine());

	return new ArticlePage(getTitle(), getAuthors(), n, lines);
    }

    /**
       costruisce un documento con authors come autori, title come titolo
       titolo ed una lista di pagine che corrisponde alla lista dei testi ts
    */
    public Article(List<String> authors, String title, List<String> ts)
    {
	super(authors, title, ts); 
    }
}
