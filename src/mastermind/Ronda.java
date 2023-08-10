/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mastermind;

import java.io.Serializable;


public class Ronda implements Serializable {
//Atributos
private int[] aciertos=new int[10];
private int[]colocados=new int[10];
private int siguiente;
private String[] combinacion=new String[10];
    //Constructor de la ronda
    public Ronda(){
        siguiente=0;
    }
    public void agregarRonda(String comb,int aciert, int coloc){//agrega el intento que se le pase a las rondas
        combinacion[siguiente]=""+comb;
        aciertos[siguiente]=aciert;
        colocados[siguiente]=coloc;
        siguiente++;
    }
    public String leerRondas(){//devuleve string con los intentos de esa ronda
        String aux="";
        for(int i=0;i<siguiente;i++){
            aux+=(i+1)+".- "+combinacion[i]+" "+aciertos[i]+" aciertos(-s) con "+ colocados[i]+" colocados(-s)\n";
            if(colocados[i]==4){
                aux+="Enhorabuena, has acertado la clave oculta\n";
                }
        }
        return aux;
    }
}
