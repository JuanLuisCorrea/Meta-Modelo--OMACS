
package manejodearchivos;

import Arcos.Achieves;
import Arcos.Arco;
import Arcos.Possesses;
import Arcos.Requires;
import Nodos.Agent;
import Nodos.Capabilitie;
import Nodos.Goal;
import Nodos.Nodo;
import Nodos.Role;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;
import javax.swing.JFileChooser;

public class Abrir {
    private ArrayList<Nodo> ListaNodos;
    private ArrayList<Arco> ListaArcos;
   
    public Abrir() {
        this.ListaArcos=new ArrayList<>();
        this.ListaNodos=new ArrayList<>();
        this.AbrirArchivo();
    }
    public void AbrirArchivo(){
        JFileChooser abrir = new JFileChooser();
        abrir.setApproveButtonText("Abrir Modelo");
        abrir.showOpenDialog(null);
        File archivo = new File(abrir.getSelectedFile().toString());
        try{
            BufferedReader br = new BufferedReader(new FileReader(archivo));//MANEJO MEMORIA
            String line; //VARIABLE PARA MANIPULAR CADA LINEA DEL ARCHIVO
            while((line=br.readLine())!=null){
                //RECORTAR LA INFORMACIÓN
                String [] str = line.split(";"); //"; discriminador/wildcard"
                if(str[0].compareTo("Agent")==0){
                    Agent agent = new Agent(Integer.parseInt(str[2]),Integer.parseInt(str[3]), str[4], str[5]);
                    agent.setID(Integer.parseInt(str[1]));
                    this.ListaNodos.add(agent);    
                }
                else if(str[0].compareTo("Capabilitie") == 0) {
                    Capabilitie capabilitie = new Capabilitie(Integer.parseInt(str[2]),Integer.parseInt(str[3]), str[4]);
                    capabilitie.setID(Integer.parseInt(str[1]));
                    this.ListaNodos.add(capabilitie);
                }
                else if(str[0].compareTo("Role") == 0) {
                    Role role = new Role(Integer.parseInt(str[2]),Integer.parseInt(str[3]), str[4]);
                    role.setID(Integer.parseInt(str[1]));
                    this.ListaNodos.add(role);
                }
                else if(str[0].compareTo("Goal") == 0) {
                    Goal goal = new Goal(Integer.parseInt(str[2]),Integer.parseInt(str[3]), str[4]);
                    goal.setID(Integer.parseInt(str[1]));
                    this.ListaNodos.add(goal);
                }
                else if(str[0].compareTo("Possesses") == 0) {
                    Possesses p = new Possesses(Integer.parseInt(str[2]),Integer.parseInt(str[3]),Integer.parseInt(str[4]),Integer.parseInt(str[5]),str[6]);
                    p.setID(Integer.parseInt(str[1]));
                    this.ListaArcos.add(p);
                }
                else if(str[0].compareTo("Requires") == 0) {
                    Requires r = new Requires(Integer.parseInt(str[2])-30,Integer.parseInt(str[3])-30,Integer.parseInt(str[4]),Integer.parseInt(str[5]));
                    r.setID(Integer.parseInt(str[1]));
                    this.ListaArcos.add(r);
                }
                   else if(str[0].compareTo("Achieves") == 0) {
                    Achieves a = new Achieves(Integer.parseInt(str[2])-30,Integer.parseInt(str[3])-30,Integer.parseInt(str[4])-30,Integer.parseInt(str[5])-30);
                    a.setID(Integer.parseInt(str[1]));
                    this.ListaArcos.add(a);
                }
            }
            br.close();
            
             
        }catch(Exception e){
        }
    }

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

