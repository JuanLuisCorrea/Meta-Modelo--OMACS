
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
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.util.ArrayList;
import javax.swing.JFileChooser;

public class Guardar {
    
    public Guardar (){
        
    }
    public void GuardarArchivo(ArrayList<Nodo> ListaNodos, ArrayList<Arco> ListaArcos){
        JFileChooser guardar = new JFileChooser();
        guardar.setApproveButtonText("Guardar Modelo");
        guardar.showSaveDialog(null);
        File archivo = new File(guardar.getSelectedFile()+".txt");
        try{
            BufferedWriter bw = new BufferedWriter(new FileWriter(archivo));
            bw.append("\tNODOS");
            bw.append("\nAGENTES");
            for(Nodo nodo: ListaNodos){
                if(nodo instanceof Agent){
                    bw.append("\nAgent;"+nodo.getID()+";"+nodo.getCentroX()+";"+nodo.getCentroY()+";"+nodo.getNombre()+";"+nodo.getCosto());
                }
            }
            bw.append("\nCAPABILITIES");
            for(Nodo nodo: ListaNodos){
                if(nodo instanceof Capabilitie){
                    bw.append("\nCapabilitie;"+nodo.getID()+";"+nodo.getCentroX()+";"+nodo.getCentroY()+";"+nodo.getNombre());
                }
            }
            bw.append("\nROLES");
            for(Nodo nodo: ListaNodos){
                if(nodo instanceof Role){
                    bw.append("\nRole;"+nodo.getID()+";"+nodo.getCentroX()+";"+nodo.getCentroY()+";"+nodo.getNombre());
                }
            }
            bw.append("\nGOALS");
            for(Nodo nodo: ListaNodos){
                if(nodo instanceof Goal){
                  bw.append("\nGoal;"+nodo.getID()+";"+nodo.getCentroX()+";"+nodo.getCentroY()+";"+nodo.getNombre());
                }
            }
            bw.append("\n\tARCOS");
            bw.append("\nPOSSESSES");
            for(Arco arco: ListaArcos){
                if(arco instanceof Possesses){
                  bw.append("\nPossesses;"+arco.getID()+";"+arco.getX1()+";"+arco.getY1()+";"+arco.getX2()+";"+arco.getY2()+";"+arco.getValor());
                }
            }
             bw.append("\nREQUIRES");
            for(Arco arco: ListaArcos){
                if(arco instanceof Requires){
                  bw.append("\nRequires;"+arco.getID()+";"+arco.getX1()+";"+arco.getY1()+";"+arco.getX2()+";"+arco.getY2());
                }
            }
             bw.append("\nACHIEVES");
            for(Arco arco: ListaArcos){
                if(arco instanceof Achieves){
                  bw.append("\nAchieves;"+arco.getID()+";"+arco.getX1()+";"+arco.getY1()+";"+arco.getX2()+";"+arco.getY2());
                }
            }
             
                
            bw.close();
        }catch(Exception e){
        };
            
        
    }
}
