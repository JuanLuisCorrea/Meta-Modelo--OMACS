package Nodos;

import java.awt.Color;
import java.awt.Graphics;

public class Role extends Nodo{
    //Constructor
    public Role(int x, int y, String nombre) {
        super(nombre, x, y);
        setD(60);
    }
    
    //Dibujar nodo en el lienzo
    @Override
    public void agregarNodo(Graphics g) {
        g.setColor(Color.LIGHT_GRAY);
        g.fillOval(getCentroX(), getCentroY(), getD(), getD());
        g.setColor(java.awt.Color.black);
        g.drawOval(getCentroX(), getCentroY(), getD(), getD());
        g.drawString(this.getNombre(), getCentroX()+25, getCentroY()+30);
    }
}