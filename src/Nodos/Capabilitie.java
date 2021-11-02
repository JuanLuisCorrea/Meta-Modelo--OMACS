package Nodos;

import java.awt.Color;
import java.awt.Graphics;

public class Capabilitie extends Nodo {
    //Coordenadas
    private int [] puntosX = {0,0,0,0,0};
    private int [] puntosY = {0,0,0,0,0};
    
    //Constructor
    public Capabilitie(int centroX, int centroY, String nombre) {
        super(nombre, centroX, centroY);
        setD(60);
        setPuntosX(new int[]{centroX,centroX+30,centroX+20,centroX-20,centroX-30});
        setPuntosY(new int[]{centroY-30,centroY-10,centroY+20,centroY+20,centroY-10});
    }

    //Getters y setters
    public int[] getPuntosX() {
        return puntosX;
    }

    public void setPuntosX(int[] puntosX) {
        this.puntosX = puntosX;
    }

    public int[] getPuntosY() {
        return puntosY;
    }

    public void setPuntosY(int[] puntosY) {
        this.puntosY = puntosY;
    }
    
    //Dibujar nodo en el lienzo
    @Override
    public void agregarNodo(Graphics g) {
        g.setColor(Color.LIGHT_GRAY);
        g.fillPolygon(getPuntosX(), getPuntosY(), 5);       
        g.setColor(java.awt.Color.black);
        g.drawPolygon(getPuntosX(), getPuntosY(), 5);
        g.drawString(this.getNombre(), getPuntosX()[0]-10, getPuntosY()[0]+30);
    }
    
}