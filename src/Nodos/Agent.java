package Nodos;

import java.awt.Color;
import java.awt.Graphics;

public class Agent extends Nodo {
    //Coordenadas
    private int [] puntosX = {};
    private int [] puntosY = {};
    
    //Costructor
    public Agent(int centroX, int centroY, String nombre, String costo) {
        super(nombre, centroX, centroY);
        setCosto(costo);
        setD(60);
        setPuntosX(new int[]{getCentroX(), getCentroX()+30, getCentroX()-30});
        setPuntosY(new int[]{getCentroY()-30, getCentroY()+30, getCentroY()+30});
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
        g.fillPolygon(getPuntosX(), getPuntosY(), 3);
        g.setColor(Color.black);
        g.drawPolygon(getPuntosX(), getPuntosY(), 3);
        g.drawString("$"+getCosto(), getPuntosX()[0]-30, getPuntosY()[0]);
        g.drawString(getNombre(), getPuntosX()[0]-5, getPuntosY()[0]+40);
    }
}