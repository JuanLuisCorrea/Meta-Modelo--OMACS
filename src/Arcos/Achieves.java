package Arcos;

import java.awt.Graphics;
import java.awt.geom.Line2D;

public class Achieves extends Arco {
    //Constructor
    public Achieves(int x1, int y1, int x2, int y2) {
        super(x1+30, y1+30, x2+30, y2+30);
    }
    
    //Dibujar arco en el lienzo
    @Override
    public void agregarArco(Graphics g) {
        setLinea(new Line2D.Float(getX1(), getY1(), getX2(), getY2()));
        g.drawLine(getX1(), getY1(), getX2(), getY2());
    }
}