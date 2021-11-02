package Arcos;

import java.awt.BasicStroke;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Stroke;
import java.awt.geom.Line2D;

public class Requires extends Arco {
    //Constructor
    public Requires(int x1, int y1, int x2, int y2) {
        super(x1+30, y1+30, x2, y2);
    }
    
    //Dibujar arco en el lienzo
    @Override
    public void agregarArco(Graphics g) {
        setLinea(new Line2D.Float(getX1(), getY1(), getX2(), getY2()));
        //Atribución: Kevin Workman, StackOverflow(CC BY-SA 4.0) https://stackoverflow.com/a/21989406/16596228  
        Graphics2D g2d = (Graphics2D) g.create();
        Stroke dashed = new BasicStroke(3, BasicStroke.CAP_BUTT, BasicStroke.JOIN_BEVEL, 0, new float[]{9}, 0);
        g2d.setStroke(dashed);
        g2d.drawLine(getX1(), getY1(), getX2(), getY2());
        g2d.dispose();
    }
}