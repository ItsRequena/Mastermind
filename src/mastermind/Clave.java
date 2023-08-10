/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mastermind;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.Serializable;
import java.util.Scanner;
import java.util.concurrent.ThreadLocalRandom;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import mastermind.Interfaz.PartidaGUI;


public class Clave implements Serializable {
//Atributos    
private String clave;
    //Constructor de la clave por defecto
    public Clave(){
    clave=GenerarClave();
    }
    //Constructor de la clave dada una combinacion
    public Clave(String combinacion){
    clave=combinacion;
    }
    //Metodo para generar la clave aleatoria    
    public String GenerarClave(){
        String combinacion="";
        String colores=("BNARVM") ;   
        int longitud=4;
        for(int i=0;i<longitud;i++){
            int indiceAleatorio=numeroAleatorioEnRango(0,colores.length()-1);
            char caracterAleatorio = colores.charAt(indiceAleatorio);
        combinacion += caracterAleatorio;
        }
    return combinacion;
    }
    
    public static int numeroAleatorioEnRango(int minimo, int maximo) {
    return ThreadLocalRandom.current().nextInt(minimo, maximo + 1);
    }
    
    //get y set
    public String getClave(){
        return this.clave;
    }
    
    public void setClave(String aux){
    this.clave=aux;
    }
    
    //los valores aceptados
    public boolean Rango(char aux){
        char vectorChar[]={'B','N','A','R','V','M'};
        boolean apto=false;
        for(int i=0;i<vectorChar.length;i++){
            if(vectorChar[i]==aux) {apto=true;}

        }
        return apto;
    }
    //pide la clave para la interfaz de comandos
    public Clave pedirClave(){
        char primero; 
        char segundo;
        char tercero;
        char cuarto;;
        String aux="";
        boolean apto =false;
        Scanner intento=new Scanner(System.in);
        System.out.println("\nLos caracteres validos son B, N ,A ,R ,V ,M ");
        while(apto==false){
            System.out.println("Introduzca el primer caracter");
            primero=intento.next().charAt(0);
            if (Rango(primero)==true){
                apto=true;
                aux+=primero;
            }
            else System.out.println("Introduce un caracter valido");
        }
        apto=false;
            
        while(apto==false){    
        System.out.println("Introduzca el segundo caracter");
        segundo=intento.next().charAt(0);
            if (Rango(segundo)==true){
                apto=true;
                aux+=segundo;
            }
            else System.out.println("Introduce un caracter valido");
        }
        apto =false;
        
        while(apto==false){    
        System.out.println("Introduzca el tercer caracter");
        tercero=intento.next().charAt(0);
            if (Rango(tercero)==true){
                apto=true;aux+=tercero;   
            }
            else System.out.println("Introduce un caracter valido");
        }
        apto =false;
        
        while(apto==false){    
        System.out.println("Introduzca el cuarto caracter");
        cuarto=intento.next().charAt(0);
            if (Rango(cuarto)==true){
                apto=true;aux+=cuarto;
                
            }
            else System.out.println("Introduce un caracter valido");
        }
        
        return new Clave(aux);
    
    }
    //devuelve un entero con el numero de aciertos de color
    public int compararClavesAciertos(Clave intento){
        int contador=0;
        boolean exist=false;  
        String aux=this.clave;  
        for (int i=0;i<4;i++){
            for(int j=0;j<4;j++){
                 if(intento.clave.charAt(i)==clave.charAt(j)&&!exist){
                     this.clave=clave.substring(0,j)+'*'+clave.substring(j+1);
                     contador+=1;
                     exist=true;
                 }
                               }
                exist=false;
                            }
        this.setClave(aux);
        return contador;
    }
    
    //devuelve un entero con el numero de parejas en orden
    public int compararClavesColocados(Clave intento){
        int contador=0;
        int i=0;
        int j=0;
        while(i<4){
            if(intento.clave.charAt(i)==clave.charAt(j)){
                contador+=1;
                    
            }
            i++;
            j++;
                
                    }
        clave.toString();
        return contador;
    }
    //devuelve booleano si el intento es = a la clave
    public boolean esGanadora(Clave intento){
        if (this.clave.equals(intento.clave)){
            return true;
        }
        else return false;
    }
    //para la implementacion dee partida por las GUI
    public Clave pedirClaveGUI(){
        char primero; 
        char segundo;
        char tercero;
        char cuarto;;
        String aux="";
        boolean apto =false; 
        while(apto==false){
            try{
                primero=JOptionPane.showInputDialog("Introduce un caracter,los caracteres validos son B, N ,A ,R ,V ,M ").charAt(0);            
                if (Rango(primero)==true){
                    apto=true;
                    aux+=primero;
                }
                else JOptionPane.showMessageDialog(null,"\nIntroduce un caracter valido");
            }
            catch (StringIndexOutOfBoundsException ex){
                JOptionPane.showMessageDialog(null,"\nIntroduce un caracter ");
             }
        } 
        apto=false;           
        while(apto==false){
            try{
                segundo=JOptionPane.showInputDialog("Introduce un caracter,los caracteres validos son B, N ,A ,R ,V ,M ").charAt(0);
                if (Rango(segundo)==true){
                    apto=true;
                    aux+=segundo;
                }
                else JOptionPane.showMessageDialog(null,"\nIntroduce un caracter valido");
            }
            catch (StringIndexOutOfBoundsException ex){
                JOptionPane.showMessageDialog(null,"\nIntroduce un caracter ");
             }
        }       
        apto =false;       
        while(apto==false){   
            try{
                tercero=JOptionPane.showInputDialog("Introduce un caracter,los caracteres validos son B, N ,A ,R ,V ,M ").charAt(0);
                if (Rango(tercero)==true){
                    apto=true;aux+=tercero;   
                }
                else JOptionPane.showMessageDialog(null,"\nIntroduce un caracter valido");
            }
            catch (StringIndexOutOfBoundsException ex){
                JOptionPane.showMessageDialog(null,"\nIntroduce un caracter ");
             }
        }       
        apto =false;       
        while(apto==false){
            try{
                cuarto=JOptionPane.showInputDialog("Introduce un caracter,los caracteres validos son B, N ,A ,R ,V ,M ").charAt(0);
                if (Rango(cuarto)==true){
                    apto=true;aux+=cuarto;             
                }
                else JOptionPane.showMessageDialog(null,"\nIntroduce un caracter valido");
            }
            catch (StringIndexOutOfBoundsException ex){
                JOptionPane.showMessageDialog(null,"\nIntroduce un caracter ");
             }
        }            
        return new Clave(aux); 
    }
    

@Override
    public String toString(){
        return this.clave;
    }
}

 