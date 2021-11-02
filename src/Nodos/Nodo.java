package Nodos;

import java.awt.Graphics;

public abstract class Nodo {
    //Atributos
    private int ID;
    private String nombre;
    private String costo;
    private int D; //Altura de la figura
    //Coordenadas del centro del nodo
    private int centroX;
    private int centroY;
    
    //Constructor
    public Nodo(String nombre, int centroX, int centroY){
        this.ID = (int)Math.round(Math.random() * 1000);
        setNombre(nombre);
        setCentroX(centroX);
        setCentroY(centroY);
    }
    
    //Getters y setters
    public int getID() {
        return this.ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    
    public String getCosto() {
        return costo;
    }

    public void setCosto(String costo) {
        this.costo = costo;
    }

    public int getD() {
        return D;
    }

    public void setD(int D) {
        this.D = D;
    }
    
    public int getCentroX() {
        return centroX;
    }

    public void setCentroX(int centroX) {
        this.centroX = centroX;
    }

    public int getCentroY() {
        return centroY;
    }

    public void setCentroY(int centroY) {
        this.centroY = centroY;
    }
    
    //Método abstracto para dibujar el nodo en el lienzo
    public abstract void agregarNodo(Graphics g);
}