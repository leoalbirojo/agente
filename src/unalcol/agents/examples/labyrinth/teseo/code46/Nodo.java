/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package unalcol.agents.examples.labyrinth.teseo.code46;

/**
 *
 * @author Andres
 */

import java.util.ArrayList;

public class Nodo {
    
    public ArrayList<Nodo> Conexion=new ArrayList<Nodo>();
    final public ArrayList<Integer> Posicion= new ArrayList<>();
    public int Puntaje=5;
    public ArrayList<Character> Salidas= new ArrayList();
        
    public Nodo(int x,int y){    
        this.Posicion.add(x);
        this.Posicion.add(y);
        
    }

    public ArrayList<Nodo> getConexion() {
        return Conexion;
    }

    public void addConexion(Nodo o){
        Conexion.add(o);
    }
    
    public Nodo getConexion(int x,int y){
        Nodo t=null;
        ArrayList d= new ArrayList();
        d.add(x);d.add(y);
        for(int i=0;i<Conexion.size();i++){
            Nodo c=Conexion.get(i);
            if(c.Posicion==d){
                t=c;
            }
        }
        return t;
    }
}