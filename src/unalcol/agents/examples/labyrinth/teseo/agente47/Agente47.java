package unalcol.agents.examples.labyrinth.teseo.agente47;

import java.util.Arrays;
import unalcol.agents.examples.labyrinth.teseo.agente47.grafo.Nodo;
import unalcol.agents.examples.labyrinth.teseo.agente47.grafo.Grafo;
import unalcol.agents.examples.labyrinth.teseo.simple.SimpleTeseoAgentProgram;

public class Agente47 extends SimpleTeseoAgentProgram {
	Grafo grafo = new Grafo();
    //Node inicial = new Node(new int[]{0,0});
    int x,y,giro;
    
    public void SimpleTeseoAgentProgram(){
        //grafo.addNode(inicial);
        x=y=giro=0; // Ultima coordenada de la posicion del agente.
    }
    //retorno de acciones: 0 adelante, 1 derecha, 2 atras, 3 izquierda
    @Override
    public int accion(boolean PF, boolean PD, boolean PA, boolean PI, boolean MT) {
        if (MT)return -1;
        //modifica la orientaci�n por una absoluta.
        boolean[] paredes=modificarDir(new boolean[]{PF,PD,PA,PI});
        Nodo actual = new Nodo(new int[]{x,y});
        actual.setChildlen(paredes); //A�ada qu� hijos tiene.
        //comprueba antes de a�adir parentesco entre nodos que no se haya a�adido.
        if(grafo.getUltimo()!=null && actual.haveChild[(giro+2)%4]&&actual.getChild()[(giro+2)%4]==null){
            grafo.getUltimo().addChildNode(actual, giro); // relaciona anterior con actual
            actual.addChildNode(grafo.getUltimo(), (giro+2)%4); // relaciona actual con anterior
        }
        
        if(grafo.addNode(actual)){ // si el nodo es visitado por 1ra vez se a�ade al grafo.
            int giroViejo=giro;
            // Devuelve la acci�n en t�rminos de las coordenadas relativas que maneja el laberinto.
            /*if (!paredes[3]&&!paredes[2]&&!paredes[1]&&!paredes[0]&&actual.getChild()[0]==null){
            	int ne = nodoEscogido(0);
            	System.out.println("voy a la izquierda");
            	if(ne>=giroViejo){
            		return ne-giroViejo;
            	}else 
            		return ne+giroViejo;
            }*/
            System.out.println( actual);
            if (!paredes[0]&&actual.getChild()[0]==null){
            		int ne = nodoEscogido(0);
            		System.out.println("voy al frente");
            		if(ne==giroViejo){
            			return ne-giroViejo;
            		} else
            			return ne+giroViejo;
            }
            if (!paredes[1]&&actual.getChild()[1]==null){ 
            		int ne = nodoEscogido(1);
            		System.out.println("voy a la derecha");
            		if(ne>=giroViejo){
            			return ne-giroViejo;
            		}else
            			return ne+giroViejo;
            }
            if (!paredes[2]&&actual.getChild()[2]==null){
            		int ne = nodoEscogido(2);
            		System.out.println("voy a atras");
            		if(ne>=giroViejo){
            			return ne-giroViejo;
            		}else
            			return ne+giroViejo;
            }
            if (!paredes[3]&&actual.getChild()[3]==null){
            	int ne = nodoEscogido(3);
            	System.out.println("voy a la izquierda");
            	if(ne>=giroViejo){
            		return ne-giroViejo;
            	}else 
            		return ne+giroViejo;
            }
            
            
        }
        
        return -1; // implementar que hacer en caso de no tener nodos sin explorar
    }
    
    private int nodoEscogido(int o){
        giro=o;
        switch(o){
            case 0: 
                y++;
                break;
            case 1:
                x++;
                break;
            case 2:
                y--;
                break;
            default:
                x--;
                break;
        }
        return o;
    }
    
    private boolean[] modificarDir(boolean[] paredes){
        boolean[] temp=Arrays.copyOf(paredes,paredes.length);
        paredes[giro]=temp[0];
        paredes[(giro+1)%4]=temp[1];
        paredes[(giro+2)%4]=temp[2];
        paredes[(giro+3)%4]=temp[3];
        System.out.println("Estoy en: " + x + " " + y + " con giro "+ giro);
        for (int i=0; i<4;i++)
        	System.out.print("-.- " + paredes[i]);
        System.out.println("");
        return paredes;
    }
}

