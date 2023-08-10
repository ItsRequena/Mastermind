/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mastermind;
import java.util.Scanner;
import javax.swing.JButton;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import mastermind.Interfaz.Entrenar;
public class Entrenamiento {
    private int numero_rondas;
    private Clave clave;
    private Ronda[]ronda=new Ronda[1];
    public Entrenamiento(int rondas){//constructor pasandole rondas
        numero_rondas=rondas;
        clave=new Clave();
    
    }
    public Entrenamiento(){//constructor por defecto para la GUI
    
        ronda[0]=new Ronda();//en los entrenamientos solo hay una partida con varios intentos
    }
    
    public void entrenar(Usuario u){//Esta es la version de entrenar para el main (interfaz de comandos)
        Scanner elige = new Scanner(System.in);
        Clave aux=new Clave("");
        Ronda[]ronda=new Ronda[1];
        ronda[0]=new Ronda();
        for (int i=1;i<=this.numero_rondas;i++){
            if(u.administrador==true){
                System.out.println("Quiere conocer la clave oculta?");
                char opcion=elige.next().charAt(0);
                 if(opcion=='S'||opcion=='s'){
                     System.out.println("La clave oculta es: "+clave.toString()+"\n");
                 }
            }
                if(i==1){
                    Clave intento=aux.pedirClave();
                    if(!this.clave.esGanadora(intento)){
                        System.out.println("\nEl numero de aciertos es: "+this.clave.compararClavesAciertos(intento));
                        System.out.println("El numero de parejas colocadas en orden es: "+this.clave.compararClavesColocados(intento)+"\n");
                        ronda[0].agregarRonda(intento.getClave(),clave.compararClavesAciertos(intento),clave.compararClavesColocados(intento));
                    }
                    else if(this.clave.esGanadora(intento)){
                        System.out.println("\nHAS ACERTADO, ENHORABUENA");
                        System.out.println("Has necesitado: "+i+ " intento(s)\n");
                        i=this.numero_rondas;
                    }
                }
                else if(i<=this.numero_rondas){
                    System.out.println(ronda[0].leerRondas());
                    Clave intento=aux.pedirClave();
                    if(!this.clave.esGanadora(intento)){
                        System.out.println("\nEl numero de aciertos es: "+this.clave.compararClavesAciertos(intento));
                        System.out.println("El numero de parejas colocadas en orden es: "+this.clave.compararClavesColocados(intento)+"\n");
                        ronda[0].agregarRonda(intento.getClave(),clave.compararClavesAciertos(intento),clave.compararClavesColocados(intento));
                    }
                    else if(this.clave.esGanadora(intento)){
                        System.out.println("\nHAS ACERTADO, ENHORABUENA");
                        System.out.println("Has necesitado: "+i+ " intento(s)\n");
                        i=this.numero_rondas;
                    }
                }
            }
        System.out.println("La clave era "+clave.toString());
        System.out.println("Finalizando entrenamiento...\n");  
    }
    public Clave entrenarGUI(JTextArea area,Clave comb,int rondas,boolean primeraRonda){  //version de la interfaz grafica la clave y las rondas se pasan desde el invocador  
        area.setText("Empezando entrenamiento");
        String str="";
        String s="";
        boolean fin=false;
        this.setClave(comb);
        boolean acertado=false;
        Clave aux=new Clave("");
        
            area.setText("Intento "+rondas+"\n"+str);
            str="";
                if(primeraRonda){//para que no muestre los intentos anteriores puesto que es el primero
                Clave intento=aux.pedirClaveGUI(); //pide la clave
                if(!this.clave.esGanadora(intento)){ 
                        ronda[0].agregarRonda(intento.getClave(),clave.compararClavesAciertos(intento),clave.compararClavesColocados(intento));
                    }
                else if(this.clave.esGanadora(intento)){
                        acertado=true; 
                    }
                area.append("\nPulsa  siguiente ronda");
                return intento;
                }
                else {
                  s=ronda[0].leerRondas();   
                  area.setText("Intento"+rondas+" "+"\n"+s);
                  Clave intento=aux.pedirClaveGUI();      
                       if(!this.clave.esGanadora(intento)){ 
                        ronda[0].agregarRonda(intento.getClave(),clave.compararClavesAciertos(intento),clave.compararClavesColocados(intento));//agrega el intento a la ronda
                        }
                       else if(this.clave.esGanadora(intento)){
                           acertado=true; 
                        }
                       area.append("\nPulsa  siguiente ronda");
                       return intento;
                }
        
        
        
        
        
    }
    public void setClave(Clave aux){
        this.clave=aux;
    }
        
        
    }
    

