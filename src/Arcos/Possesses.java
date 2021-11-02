package Arcos;

import java.awt.Graphics;
import java.awt.geom.Line2D;

public class Possesses extends Arco {
    //Constructor
    public Possesses(int x1, int y1, int x2, int y2, String valor){
        super(x1, y1, x2, y2);
        setValor(valor);
    }
    
    //Dibujar arco en el lienzo
    @Override
    public void agregarArco(Graphics g) {
        setLinea(new Line2D.Float(getX1(), getY1(), getX2(), getY2()));
        g.drawLine(getX1(), getY1(), getX2(), getY2());
        //Mostrar el valor dependiendo de la posición de los puntos de la línea
        if(getX1() > getX2() && getY1() > getY2()) {
            g.drawString(getValor(), getX1()-Math.abs((getX1()-getX2())/2), getY1()-Math.abs((getY1()-getY2())/2));
        }
        else if(getX1() < getX2() && getY1() < getY2()) {
            g.drawString(getValor(), getX2()-Math.abs((getX1()-getX2())/2), getY2()-Math.abs((getY1()-getY2())/2));
        }
        else if(getX1() > getX2() && getY1() < getY2()) {
            g.drawString(getValor(), getX1()-Math.abs((getX1()-getX2())/2), getY2()-Math.abs((getY1()-getY2())/2));
        }
        else if(getX1() < getX2() && getY1() > getY2()) {
            g.drawString(getValor(), getX2()-Math.abs((getX1()-getX2())/2), getY1()-Math.abs((getY1()-getY2())/2));
        }
    }
    
}