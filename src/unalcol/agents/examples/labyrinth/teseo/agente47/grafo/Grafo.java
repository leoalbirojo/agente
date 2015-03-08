package unalcol.agents.examples.labyrinth.teseo.agente47.grafo;

import java.util.HashSet;

public class Grafo {
    
    private HashSet<Nodo> vertices = new HashSet<Nodo>();
    private Nodo ultimo;

    public Grafo(){}

    public boolean addNode(Nodo n)
    {
        if(vertices.add(n)){
            ultimo=n;
            return true;
        }
        return false;
    }

    public Nodo getUltimo()
    {
        return ultimo;
    }
}