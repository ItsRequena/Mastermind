/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mastermind;

import java.awt.event.ActionListener;
import java.io.Serializable;
import javax.swing.JFrame;


public class Usuario extends JFrame implements Serializable{
protected String usuario;
protected String clave;
public boolean administrador;
protected int partidas_jugadas,partidas_ganadas,partidas_perdidas,puntos_anotados,puntos_encajados;
double porcentaje_victorias;
    //Constructor de Usuario con dos parametros, el nombre y su clave
    public Usuario(String usuario,String clave){
        this.usuario=usuario;
        this.clave=clave;
        partidas_jugadas=0;
        partidas_ganadas=0;
        partidas_perdidas=0;
        puntos_anotados=0;
        puntos_encajados=0;
        porcentaje_victorias=0;
        administrador=false;
        }
    //Constructor de Usuario por defecto
    public Usuario(){
        this.usuario=" ";
        this.clave=" ";
        partidas_jugadas=0;
        partidas_ganadas=0;
        partidas_perdidas=0;
        puntos_anotados=0;
        puntos_encajados=0;
        porcentaje_victorias=0;
        administrador=false;
        }
    //GETTERS 
    public String getNombre() {
        return this.usuario;
    }
    public String getClave() {
        return this.clave;
    }
    public int getPartidas_jugadas (){
        return this.partidas_jugadas;
    }
    public int getPartidas_ganadas(){
        return this.partidas_ganadas;
    }
    public int getPartidas_perdidas(){
        return this.partidas_perdidas;
    }
    public int getPuntos_anotados (){
        return this.puntos_anotados;
    }
    public int getPuntos_encajados(){
        return this.puntos_encajados;
    }
    public double getPorcentaje_victorias(){
        return this.porcentaje_victorias;
    }
    public boolean getAdministrador(){
        return this.administrador;
    }
    //SETTERS
    public void setNombre(String n) {
       this.usuario=n;
    }
    public void setClave(String n) {
       this.clave=n;
    }
    public void setPartidas_jugadas(int n){
        this.partidas_jugadas=n;
    }
    public void setPartidas_ganadas(int n){
        this.partidas_ganadas=n;
    }
    public void setPartidas_perdidas(int n){
        this.partidas_perdidas=n;
    }
    public void setPuntos_anotados(int n){
        this.puntos_anotados=n;
    }
    public void setPuntos_encajados (int n){
        this.puntos_encajados=n;
    }
    public void setPorcentaje_victorias (double n){
        this.porcentaje_victorias = n;
    }
    public void setAdministrador() {
       this.administrador=true;
    }
    //toString para obtener todos los datos del usuario
   public String toString(){
        String admin="";
        if(this.administrador){
             admin="Es administrador";
        }
        else  admin="No es administrador";
        return "Nombre: "+getNombre()+ " , clave: "+getClave()+ " , partidas jugadas: "+partidas_jugadas+ " , partidas ganadas: "+partidas_ganadas+ 
                " , partidas perdidas: "+partidas_perdidas+ " , puntos anotados: "+puntos_anotados+" , puntos encajados: "+puntos_encajados+
                " , porcentaje de victorias: "+porcentaje_victorias+"%. "+admin+"\n";
       
    }
   //toString del ranking para obtener los datos de la clasificacion
   public String Ranking(){
       return "Nombre: "+getNombre()+ " PORCENTAJE DE VICTORIAS: "+porcentaje_victorias+"% PARTIDAS GANADAS: "+partidas_ganadas+" partidas jugadas: "+partidas_jugadas+
                " , partidas perdidas: "+partidas_perdidas+ " , puntos anotados: "+puntos_anotados+" , puntos encajados: "+puntos_encajados+
                "\n";
   }
    
     
}
 
