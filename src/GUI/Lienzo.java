package GUI;

import Arcos.Achieves;
import Arcos.Arco;
import Arcos.Possesses;
import Arcos.Requires;
import Nodos.Agent;
import Nodos.Capabilitie;
import Nodos.Goal;
import Nodos.Nodo;
import Nodos.Role;
import java.awt.Graphics;
import java.awt.Point;
import java.awt.Rectangle;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class Lienzo extends JPanel implements MouseListener, MouseMotionListener {
    //Array con la información de los nodos
    private ArrayList<Nodo> ListaNodos = new ArrayList<>();
    //Array con la información de los arcos
    private ArrayList<Arco> ListaArcos = new ArrayList<>();
    
    private Point p1, p2;
    private Nodo nodoSeleccionado;
    private int indiceNodoSeleccionado;
    
    public Lienzo() {
        addMouseListener(this);
        addMouseMotionListener(this);
    }
    
    //Metodo para limpiar el lienzo (Menu de Nuevo modelo Ctrl+N)
    public void limpiarLienzo() {
        ListaNodos = new ArrayList<>();
        ListaArcos = new ArrayList<>();
        repaint();
    }
    
    //Metodo para pintar los elementos de los arrays en el lienzo
    @Override
    public void paint(Graphics g) {
        super.paint(g);
        //Dibujar arcos
        for(Arco arco: ListaArcos) {
            arco.agregarArco(g);
        }
        //Dibujar nodos
        for(Nodo nodo: ListaNodos) {
            nodo.agregarNodo(g);
        }
    }
    
    //Listener para cuando haga click en el lienzo
    @Override
    public void mouseClicked(MouseEvent e) {
        //EVENTOS CON EL CLICK IZQUIERDO EN EL LIENZO
        if(e.getButton() == 1) {
            //Coordenadas del click
            int x = e.getX();
            int y = e.getY();
            
            //Agregar Agents al array de nodos
            if(MainWindow.botonSeleccionado.compareTo("Agent") == 0) {
                String nombre = JOptionPane.showInputDialog("Nombre del elemento");
                String costo = JOptionPane.showInputDialog("Costo del agente");
                getListaNodos().add(new Agent(x, y, nombre, costo));
                repaint();//Llama el método paint() para dibujar el array con el nuevo elemento
            }
            //Agregar Capabilities al array de nodos
            else if(MainWindow.botonSeleccionado.compareTo("Capabilitie") == 0) {
                String nombre = JOptionPane.showInputDialog("Nombre del elemento");
                getListaNodos().add(new Capabilitie(x, y, nombre));
                repaint();
            }
            //Agregar Roles al array de nodos
            else if(MainWindow.botonSeleccionado.compareTo("Role") == 0) {
                String nombre = JOptionPane.showInputDialog("Nombre del elemento");
                getListaNodos().add(new Role(x-30, y-30, nombre));
                repaint();
            }
            //Agregar Goals al array de nodos
            else if(MainWindow.botonSeleccionado.compareTo("Goal") == 0) {
                String nombre = JOptionPane.showInputDialog("Nombre del elemento");
                getListaNodos().add(new Goal(x-30, y-30, nombre));
                repaint();
            }
            //Agregar Possesses al array de Arcos
            else if(MainWindow.botonSeleccionado.compareTo("Possesses") == 0) {
                for(Nodo nodo: ListaNodos) {
                    if(new Rectangle(nodo.getCentroX()-(nodo.getD()/2),nodo.getCentroY()-(nodo.getD()/2),nodo.getD(),nodo.getD()).contains(e.getPoint())) {
                        if(p1 == null) {
                            if(!(nodo instanceof Agent)) {
                                JOptionPane.showMessageDialog(this, "La relación Possesses solo es permitida en la dirección Agent-Capabilitie");
                                break;
                            }
                            p1 = new Point(nodo.getCentroX(),nodo.getCentroY());
                        }
                        else {
                            if(!(nodo instanceof Capabilitie)) {
                                JOptionPane.showMessageDialog(this, "La relación Possesses solo es permitida en la dirección Agent-Capabilitie");
                                p1 = null;
                                break;
                            }
                            p2 = new Point(nodo.getCentroX(),nodo.getCentroY());
                            String valor = JOptionPane.showInputDialog("Valor del Possess");
                            if(Float.parseFloat(valor) < 0.0 || Float.parseFloat(valor) > 1.0) {
                                JOptionPane.showMessageDialog(this, "El valor debe ser un número entre 0.0 y 1.0");
                                p1 = null; 
                                break;
                            }
                            getListaArcos().add(new Possesses(p1.x,p1.y,p2.x,p2.y, valor));
                            repaint();
                            p1 = null; 
                            p2 = null;
                        }
                    }
                }
            }
            //Agregar Requires al array de Arcos
            else if(MainWindow.botonSeleccionado.compareTo("Requires") == 0) {
                for(Nodo nodo: ListaNodos) {
                    if(new Rectangle(nodo.getCentroX()-(nodo.getD()/2),nodo.getCentroY()-(nodo.getD()/2),90,90).contains(e.getPoint())) {
                        if(p1 == null) {
                            if(!(nodo instanceof Role)) {
                                JOptionPane.showMessageDialog(this, "La relación Requires solo es permitida en la dirección Role-Capabilitie");
                                break;
                            }
                            p1 = new Point(nodo.getCentroX(),nodo.getCentroY());
                        }
                        else {
                            if(!(nodo instanceof Capabilitie)) {
                                JOptionPane.showMessageDialog(this, "La relación Requires solo es permitida en la dirección Role-Capabilitie");
                                p1 = null;
                                break;
                            }
                            p2 = new Point(nodo.getCentroX(),nodo.getCentroY());
                            getListaArcos().add(new Requires(p1.x,p1.y,p2.x,p2.y));
                            repaint();
                            p1 = null; 
                            p2 = null;
                        }
                    }
                }
            }
            //Agregar Achieves al array de Arcos
            else if(MainWindow.botonSeleccionado.compareTo("Achieves") == 0) {
                for(Nodo nodo: ListaNodos) {
                    if(new Rectangle(nodo.getCentroX()-(nodo.getD()/2),nodo.getCentroY()-(nodo.getD()/2),120,120).contains(e.getPoint())) {
                        if(p1 == null) {
                            if(!(nodo instanceof Role)) {
                                JOptionPane.showMessageDialog(this, "La relación Achieves solo es permitida en la dirección Role-Goal");
                                break;
                            }
                            p1 = new Point(nodo.getCentroX(),nodo.getCentroY());
                        }
                        else {
                            if(!(nodo instanceof Goal)) {
                                JOptionPane.showMessageDialog(this, "La relación Achieves solo es permitida en la dirección Role-Goal");
                                p1 = null;
                                break;
                            }
                            p2 = new Point(nodo.getCentroX(),nodo.getCentroY());
                            getListaArcos().add(new Achieves(p1.x,p1.y,p2.x,p2.y));
                            repaint();
                            p1 = null; 
                            p2 = null;
                        }
                    }
                }
            }
            //Eliminar elementos
            else if(MainWindow.botonSeleccionado.compareTo("Eliminar") == 0) {
                //Eliminar nodo del array de nodos
                for(Nodo nodo: ListaNodos) {
                    if(new Rectangle(nodo.getCentroX()-(nodo.getD()/2),nodo.getCentroY()-(nodo.getD()/2),90,90).contains(e.getPoint())) {
                        getListaNodos().remove(nodo);
                        break;
                    }
                }
                //Eliminar arco del array de arcos
                for(Arco arco: ListaArcos) {
                    if(arco.getLinea().intersects(e.getX()-2, e.getY()-2, 4, 4)) {
                        getListaArcos().remove(arco);
                        break;
                    }
                }
                repaint();//Dibujar los elementos de los arrays con los cambios hechos
            }
        }
        
        //EVENTOS CON EL CLICK DERECHO EN EL LIENZO
        if(e.getButton() == 3) {
            //Seleccionar elementos en el lienzo para modificar sus atributos
            if(MainWindow.botonSeleccionado.compareTo("Seleccionar") == 0) {
                //Seleccionar y modificar nodo
                for(Nodo nodo: ListaNodos) {
                    if(new Rectangle(nodo.getCentroX()-(nodo.getD()/2),nodo.getCentroY()-(nodo.getD()/2),90,90).contains(e.getPoint())){
                        nodo.setNombre(JOptionPane.showInputDialog("Cambiar nombre del nodo", nodo.getNombre()));
                        if(nodo instanceof Agent) {
                            nodo.setCosto(JOptionPane.showInputDialog("Cambiar costo del Agente", nodo.getCosto()));
                        }
                        break;
                    }
                }
                //Seleccionar y modificar arco de tipo Possesses
                for(Arco arco: ListaArcos) {
                    if(arco.getLinea().intersects(e.getX()-2, e.getY()-2, 4, 4)) {
                        if(arco instanceof Possesses) {
                            ((Possesses) arco).setValor(JOptionPane.showInputDialog("Cambiar valor del Possess", ((Possesses) arco).getValor()));
                        }
                        break;
                    }
                }
                repaint();//Dibujar los elementos de los arrays con los cambios hechos
            }
        }
    }
    
    /*
        Los listeners MousePressed, MouseDragged y MouseReleased 
        se utilizan para la opción de mover un nodo arrastrándolo
        con el click izquierdo.
    */
    @Override
    public void mousePressed(MouseEvent e) { 
        //Verificar que está presionando el click izquierdo y tiene habilitada la opción de seleccionar
        if(e.getButton() == 1 && MainWindow.botonSeleccionado.compareTo("Seleccionar") == 0) {
            int i = 0;
            for(Nodo nodo: ListaNodos) {
                //Identificar el nodo seleccionado
                if(new Rectangle(nodo.getCentroX()-nodo.getD()/2,nodo.getCentroY()-nodo.getD()/2,90,90).contains(e.getPoint())) {
                    nodoSeleccionado = nodo;
                    indiceNodoSeleccionado = i;
                }
                i += 1;
            }
        }
    }
    
    @Override
    public void mouseDragged(MouseEvent e) {
        //Actualizar la posición del nodo mientras arrastre el mouse con el click izquierdo presionado
        if(nodoSeleccionado != null) {
            if(ListaNodos.get(indiceNodoSeleccionado) instanceof Agent) {
                ListaNodos.set(indiceNodoSeleccionado, new Agent(e.getX(),e.getY(),nodoSeleccionado.getNombre(),nodoSeleccionado.getCosto()));
            }
            else if(ListaNodos.get(indiceNodoSeleccionado) instanceof Capabilitie) {
                ListaNodos.set(indiceNodoSeleccionado, new Capabilitie(e.getX(),e.getY(),nodoSeleccionado.getNombre()));
            }
            else if(ListaNodos.get(indiceNodoSeleccionado) instanceof Role) {
                ListaNodos.set(indiceNodoSeleccionado, new Role(e.getX()-30,e.getY()-30,nodoSeleccionado.getNombre()));
            }
            else if(ListaNodos.get(indiceNodoSeleccionado) instanceof Goal) {
                ListaNodos.set(indiceNodoSeleccionado, new Goal(e.getX()-30,e.getY()-30,nodoSeleccionado.getNombre()));
            }
            //Actualizar la posición de los arcos que tenga relacionados
            for(Arco arco: ListaArcos) {
                //Si el arco se mueve desde su punto inicial (x1,y1)
                if(new Rectangle(arco.getX1()-30, arco.getY1()-30, 90, 90).contains(e.getPoint())) {
                    arco.setX1(e.getX());
                    arco.setY1(e.getY());
                }
                //Si el arco se mueve desde su punto final (x2,y2)
                else if(new Rectangle(arco.getX2()-30, arco.getY2()-30, 90, 90).contains(e.getPoint())) {
                    arco.setX2(e.getX());
                    arco.setY2(e.getY());
                }
            }
        }
        repaint();//Pintar el nodo en su nueva posición
    }

    @Override
    public void mouseReleased(MouseEvent e) {
        //Reiniciar variables al soltar el mouse
        nodoSeleccionado = null;
        indiceNodoSeleccionado = 0;
    }

    @Override
    public void mouseEntered(MouseEvent e) { }

    @Override
    public void mouseExited(MouseEvent e) { }

    @Override
    public void mouseMoved(MouseEvent e) { }
    
    //Getters y setters
    public ArrayList<Nodo> getListaNodos() {
        return ListaNodos;
    }

    public void setListaNodos(ArrayList<Nodo> ListaNodos) {
        this.ListaNodos = ListaNodos;
    }

    public ArrayList<Arco> getListaArcos() {
        return ListaArcos;
    }

    public void setListaArcos(ArrayList<Arco> ListaArcos) {
        this.ListaArcos = ListaArcos;
    }

}