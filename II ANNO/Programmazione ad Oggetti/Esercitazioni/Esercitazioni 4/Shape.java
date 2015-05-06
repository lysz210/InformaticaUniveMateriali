import java.util.*;
import java.awt.*;
import java.awt.geom.*;

interface Shape { 

    /**
     * disegna la figura utilizzando il contesto grafico g 
     */
     void draw(Graphics2D g);

    /**
     * restituisce un rettangolo che racchiude interamente la figura 
     */
    Rectangle boundingBox();

    /**
     * restituisce l'area della figura. 
     */
    double area();
} 

