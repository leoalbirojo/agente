/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package unalcol.agents.examples.labyrinth.teseo.code46;

import java.util.ArrayList;

import unalcol.agents.examples.labyrinth.teseo.simple.SimpleTeseoAgentProgram;
/**
 *
 * @author Andres
 */
public class Code46 extends SimpleTeseoAgentProgram{

    private int Orientacion=0; //orientacion 0=Norte, 1=Este,2=sur,3=Oeste
    private int[] Posicion=new int[]{0,0};
    private Mapa Mapa=new Mapa();
    private int N=1;
    private int X=0,Y=0;
    private Nodo last=new Nodo(100, 100);
    
    public Code46(){
        Nodo h=new Nodo(X,Y);
        this.Mapa.addNodo(h);
    }
    
    @Override    
    public int accion(boolean PF, boolean PD, boolean PA, boolean PI, boolean MT) {
        if (MT) return -1;
        boolean flag = true;
        int k=0;
        
        Nodo actual=Mapa.getNodo(X,Y);        
        
        int pf=1,pa=1,pi=1,pd=1;
        System.out.println("Posicion: "+actual.Posicion);
        System.out.println("puntaje: "+actual.Puntaje);
        if(Orientacion==0){
            System.out.println(1);
            if(!PF&&actual.Puntaje==5){pf=1;actual.Salidas.add('N');}else{pf=0;}
            if(!PD&&actual.Puntaje==5){pd=1;actual.Salidas.add('E');}else{pd=0;}
            if(!PA&&actual.Puntaje==5){pa=1;actual.Salidas.add('S');}else{pa=0;}
            if(!PI&&actual.Puntaje==5){pi=1;actual.Salidas.add('O');}else{pi=0;}        
        }
        if(Orientacion==1){
            System.out.println(2);
            if(!PF&&actual.Puntaje==5){pf=1;actual.Salidas.add('E');}else{pf=0;}
            if(!PD&&actual.Puntaje==5){pd=1;actual.Salidas.add('S');}else{pd=0;}
            if(!PA&&actual.Puntaje==5){pa=1;actual.Salidas.add('O');}else{pa=0;}
            if(!PI&&actual.Puntaje==5){pi=1;actual.Salidas.add('N');}else{pi=0;}        
        }
        if(Orientacion==2){
            System.out.println(3);
            if(!PF&&actual.Puntaje==5){pf=1;actual.Salidas.add('S');}else{pf=0;}
            if(!PD&&actual.Puntaje==5){pd=1;actual.Salidas.add('O');}else{pd=0;}
            if(!PA&&actual.Puntaje==5){pa=1;actual.Salidas.add('N');}else{pa=0;}
            if(!PI&&actual.Puntaje==5){pi=1;actual.Salidas.add('E');}else{pi=0;}        
        }
        if(Orientacion==3){
            System.out.println(4);
            if(!PF&&actual.Puntaje==5){pf=1;actual.Salidas.add('O');}else{pf=0;}
            if(!PD&&actual.Puntaje==5){pd=1;actual.Salidas.add('N');}else{pd=0;}
            if(!PA&&actual.Puntaje==5){pa=1;actual.Salidas.add('E');}else{pa=0;}
            if(!PI&&actual.Puntaje==5){pi=1;actual.Salidas.add('S');}else{pi=0;}        
        }
        System.out.println(actual.Salidas);
        actual.Puntaje=actual.Salidas.size()-1;
        if(actual.Puntaje==5){System.out.println(5);actual.Puntaje=pa+pf+pi+pd;}
        
        while( flag ){          
            System.out.println(6);
            if(actual.Conexion.isEmpty()){
                if((!PF &&Orientacion==0)||(!PI &&Orientacion==1)||(!PA &&Orientacion==2)||(!PD &&Orientacion==3)){
                    System.out.println(7);
                    Nodo b=new Nodo(X,Y-1);
                    if(b==last){actual.Salidas.remove(actual.Salidas.size()) ;break;}
                    if(!Mapa.Nodos.contains(b)){Mapa.addNodo(b);}
                    if(!actual.Conexion.contains(b)){actual.addConexion(b);}
                }
                if((!PD &&Orientacion==0)||(!PF &&Orientacion==1)||(!PI &&Orientacion==2)||(!PA &&Orientacion==3)){                N++;
                    System.out.println(8);    
                    Nodo b=new Nodo(X+1,Y);
                    if(b==last){actual.Salidas.remove(actual.Salidas.size()) ;break;}
                    if(!Mapa.Nodos.contains(b)){Mapa.addNodo(b);}
                    if(!actual.Conexion.contains(b)){actual.addConexion(b);}

                }
                if((!PA &&Orientacion==0)||(!PD &&Orientacion==1)||(!PF &&Orientacion==2)||(!PI &&Orientacion==3)){
                    System.out.println(9);
                    Nodo b=new Nodo(X,Y+1);
                    if(b==last){actual.Salidas.remove(actual.Salidas.size()) ;break;}
                    if(!Mapa.Nodos.contains(b)){Mapa.addNodo(b);}
                    if(!actual.Conexion.contains(b)){actual.addConexion(b);}

                }
                if((!PI &&Orientacion==0)||(!PA &&Orientacion==1)||(!PD &&Orientacion==2)||(!PF &&Orientacion==3)){
                    System.out.println(10);
                    Nodo b=new Nodo(X-1,Y-1);
                    if(b==last){actual.Salidas.remove(actual.Salidas.size()) ;break;}
                    if(!Mapa.Nodos.contains(b)){Mapa.addNodo(b);}
                    if(!actual.Conexion.contains(b)){actual.addConexion(b);}
                }
            }
        
            
            /**
             * El automata solo se movera cuando el numero de giros k
             * lo deje mirando hacia un lado sin pared.
             * PF = 0
             * PD = 1
             * PA = 2
             * PI = 3
             */
            
            
            int r =(int)(Math.random()*actual.Salidas.size());
            System.out.println("R:"+r);
            System.out.println(actual.Salidas);
            char sal = actual.Salidas.get(r);
            System.out.println(sal);
            if(Orientacion==0){System.out.println(11);
                if(sal=='N'){k=0;Y--;}
                if(sal=='E'){k=1;X++;}
                if(sal=='S'){k=2;Y++;}
                if(sal=='O'){k=3;X--;}
            }
            if(Orientacion==1){System.out.println(12);
                if(sal=='N'){k=3;Y--;}
                if(sal=='E'){k=0;X++;}
                if(sal=='S'){k=1;Y++;}
                if(sal=='O'){k=2;X--;}
            }
            if(Orientacion==2){System.out.println(13);
                if(sal=='N'){k=2;Y--;}
                if(sal=='E'){k=3;X++;}
                if(sal=='S'){k=0;Y++;}
                if(sal=='O'){k=1;X--;}
            }
            if(Orientacion==3){System.out.println(14);
                if(sal=='N'){k=1;Y--;}
                if(sal=='E'){k=2;X++;}
                if(sal=='S'){k=3;Y++;}
                if(sal=='O'){k=0;X--;}
            }
            actual.Puntaje--;
            System.out.println("punteje: "+ actual.Puntaje);
            if(actual.Salidas.size()>1){actual.Salidas.remove(r);}
            System.out.println("salidas: "+actual.Salidas);
            Orientacion=(Orientacion+k)%4;
            System.out.println("Orientacion:"+Orientacion);
            System.out.println("k es igual: "+k);
            last=actual;
            switch(k){
                case 0:
                    flag = PF;
                    break;
                case 1:
                    flag = PD;
                    break;
                case 2:
                    flag = PA;
                    break;
                default:
                    flag = PI;
                    break;                    
            }
            
        }
        System.out.println("k es igual: "+k);
        return k;
    }
   
}
