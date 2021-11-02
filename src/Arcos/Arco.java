package Arcos;

import java.awt.Graphics;
import java.awt.geom.Line2D;

public abstract class Arco {
    //Atributos
    private int ID;
    private String valor;
    //Coordenadas de inicio y fin de la línea
    private int x1;
    private int y1;
    private int x2;
    private int y2;
    //Línea para almacenar las coordenadas
    private Line2D linea;
    
    //Constructor
    public Arco(int x1, int y1, int x2, int y2) {
        this.ID = (int)Math.round(Math.random()*10000);
        setX1(x1);
        setY1(y1);
        setX2(x2);
        setY2(y2);
    }
    
    //Getters y setters
    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public int getX1() {
        return x1;
    }
    
    public String getValor() {
        return valor;
        
    }
    
    public void setValor(String valor) {    
        this.valor = valor;
    }

    public void setX1(int x1) {
        this.x1 = x1;
    }

    public int getY1() {
        return y1;
    }

    public void setY1(int y1) {
        this.y1 = y1;
    }

    public int getX2() {
        return x2;
    }

    public void setX2(int x2) {
        this.x2 = x2;
    }

    public int getY2() {
        return y2;
    }

    public void setY2(int y2) {
        this.y2 = y2;
    }

    public Line2D getLinea() {
        return linea;
    }

    public void setLinea(Line2D linea) {
        this.linea = linea;
    }
    
    //Metodo abstracto para dibujar el arco en el lienzo
    public abstract void agregarArco(Graphics g);
}