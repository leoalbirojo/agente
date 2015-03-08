package unalcol.agents.examples.labyrinth.teseo.agente47.grafo;

import java.util.Arrays;

public class Nodo {
    private int[] xy=new int[1];
    private Nodo[] child;
    public boolean[] haveChild;
    private boolean visited;

    public Nodo(int[] xy)
    {
        this.xy = xy;
        child = new Nodo[4];
        haveChild = new boolean[4]; // 0 hijo al frente, 1 a la derecha, etc.
        visited = false;
    }
    public void setVisited(boolean v){
    	visited = v;
    }
    public boolean getVisited(){
    	return visited;
    }
    public void addChildNode(Nodo adj,int pos)
    {
        this.child[pos] = adj;
    }
    
    public void setChildlen(boolean[] childlen){
        haveChild[0] = !childlen[0];
        haveChild[1] = !childlen[1];
        haveChild[2] = !childlen[2];
        haveChild[3] = !childlen[3];
        /*for (int i=0;i<4;i++){
        	if (!haveChild[i]){
        		addChildNode(adj, i);
        	}
        }*/
    }

    public Nodo[] getChild()
    {
        return child;
    }

    public int[] getCoord()
    {
        return xy;
    }
    
    @Override
    public boolean equals(Object o){
        if (o instanceof Nodo) {
            Nodo p = (Nodo)o;
            if(this.xy[0]==p.xy[0] && this.xy[1]==p.xy[1])return true;          
            return true;
            }
        return false;
        } 

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 97 * hash + Arrays.hashCode(this.xy);
        return hash;
    }
    @Override
    public String toString() {
    	String sChild = new String("");
    	for (int i=0;i<child.length;i++){
	    	if(child[i]!=null){
	    		sChild = (sChild +" "+ child[i].getCoord().toString());
	    	} else
	    		sChild = sChild + " pared ";
    	}
    	
    	return ("mis hijos son: " + sChild);
    }

}