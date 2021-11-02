package Nodos;

import java.awt.Color;
import java.awt.Graphics;

public class Goal extends Nodo {
    //Constructor
    public Goal(int x, int y, String nombre) {
        super(nombre, x, y);
        setD(60);
    }
    
    //Dibujar nodo en el lienzo
    @Override
    public void agregarNodo(Graphics g) {
        g.setColor(Color.LIGHT_GRAY);
        g.fillRect(getCentroX(), getCentroY(), getD(), getD());
        g.setColor(java.awt.Color.black);
        g.drawRect(getCentroX(), getCentroY(), getD(), getD());
        g.drawString(this.getNombre(), getCentroX()+25, getCentroY()+30);
    }
}