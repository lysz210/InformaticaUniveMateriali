import java.util.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class XShapes 
{

    private static int SQUARE   = 0;
    private static int CIRCLE   = 1;
    private static int TRIANGLE = 2;

    private static int current = -1;


    static class DrawPanel extends JPanel 
    { 

	private ArrayList<Shape> shapes = new ArrayList<Shape>();

	/**
	 * Crea un pannello, con colore di background a bianco, e 
	 * aggiunge al pannello un MouseListener che reagisce ai 
	 * click del mouse creando e disegnando le figure come
	 * descritto nel testo dell'esercitazione
	 *
	 * Il MouseListener utilizza il metodo static createShape() 
	 * della classe  esterna per ottenere le figure. 
	*/
	public DrawPanel() 
	{ 
	    /* implementare */ 
	}
    

	/**
         * Disegna tutte le figure del pannello 
	 */
	public void paintComponent(Graphics g) 
	{
	    super.paintComponent(g); 
	    /* completare  */
	}

	/**
         *  Ordina la lista shapes utilizzando un Comparator<Shape>
	 *  che realizza un ordine basato sul confronto di aree.
         *
	 *  Visualizza l'ordine sul pannello, associando a ciascuna 
	 *  figura il valore che corrisponde alla sua posizione 
	 *  nell'ordine.
         */
	public void sort() 
	{ 
	    /* implementare */ 
	}

    
	/**
         *  Azzera il contenuto del pannello e cancella le
	 *  figure dal pannello stesso. 
         */
	public void clear() 
	{ 
	    /* implementare */ 
	}

    }

    /**
     *  Chiede all'utente di fornire una misura, e crea una 
     *  nuova Shape in posizione (x,y) della misura data 
     *
     *  @return la Shape creata 
     *  @param shape: l'intero che determina il tipo di shape
     *         0 -> Quadrato, 1 -> Cerchio, 2 -> Triangolo
     */

    public static Shape createShape(int shape, int x, int y)
    {
	Shape s = null;
	/* determina implementare */
	return s;
    }

    /**
     *  Crea il frame con tutte le componenti e le dispone 
     *  Associa ai pulsanti i listener corrispondenti
     */
    public static void main(String[] args)  
    { 
	JFrame frame = new JFrame(); 

	JPanel controlButtonPanel = 
	    new JPanel(new GridLayout(1,2));
	JButton sortBtn = new JButton("SORT");
	JButton clearBtn = new JButton("CLEAR");

	controlButtonPanel.add(sortBtn);
	controlButtonPanel.add(clearBtn);

	JPanel shapeButtonPanel = 
	    new JPanel(new GridLayout(1,3));
	JButton squareBtn = new JButton("square");
	JButton circleBtn = new JButton("circle");
	JButton triangleBtn = new JButton("triangle");

	shapeButtonPanel.add(squareBtn);
	shapeButtonPanel.add(circleBtn);
	shapeButtonPanel.add(triangleBtn);

	final DrawPanel drawArea = new DrawPanel(); 

	frame.add(controlButtonPanel,BorderLayout.NORTH);
	frame.add(shapeButtonPanel,BorderLayout.SOUTH);
	frame.add(drawArea,BorderLayout.CENTER);

	/**
	   Aggiungi gli action listener: 

	   - negli shapeBtn, il listener setta la variabile 
	     current alla figura corrispondente
  
           - nei controlBtn, invoca il metodo corrispondente
	     della drawArea
	*/
	  
	frame.setSize(400,400);
	frame.setTitle("XShapes");
	frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	frame.setVisible(true);
    }
}
