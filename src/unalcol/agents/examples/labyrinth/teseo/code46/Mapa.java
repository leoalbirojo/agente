/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package unalcol.agents.examples.labyrinth.teseo.code46;

import java.util.ArrayList;

/**
 *
 * @author Andres
 */
public class Mapa {
    
    public ArrayList<Nodo> Nodos=new ArrayList<>();
    
    public Mapa(){}
    
    public void addNodo(Nodo o){
        Nodos.add(o);
    }
    public Nodo getNodo(int o){
        Nodo a=Nodos.get(o);
        return a;
    }
    public Nodo getNodo(int x,int y){
        ArrayList<Integer> L=new ArrayList<>();
        L.add(x);
        L.add(y);
        for(int i=0;i<Nodos.size();i++){
            Nodo a= Nodos.get(i);
            int p=a.Posicion.get(0);
            int q=a.Posicion.get(1);
            if(p==x&&q==y){
                return Nodos.get(i);
            }
        }
        return null;
    }

    
}