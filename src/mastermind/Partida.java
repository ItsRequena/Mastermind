/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mastermind;
import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextArea;

public class Partida implements Serializable{
    protected int numero_rondas;
    protected Clave clave;
    protected Usuario jugador1,jugador2;
    protected String fecha_hora;
    protected Ronda[] rondaP1;
    protected Ronda[] rondaP2;
    protected int puntosAnotadosP1=0;
    protected int puntosAnotadosP2=0;
    public Partida(Usuario contrincante,Usuario jugador1){//constructores
        numero_rondas=3;
        clave= new Clave();
        this.jugador1 = jugador1;
        jugador2=contrincante;
        fecha_hora="";
        rondaP1=new Ronda[numero_rondas];
        rondaP2=new Ronda[numero_rondas];
    }
     public Partida(int ron){//constructor usado en la GUI
         numero_rondas=ron;
        clave= new Clave();
        
        fecha_hora="";
        rondaP1=new Ronda[numero_rondas];
        rondaP2=new Ronda[numero_rondas];
        }
     public void setJugador1(Usuario u){//para poner los jugadores desde la GUI
     this.jugador1=u;
     }
     public void setJugador2(Usuario u){
     this.jugador2=u;
     }
     public void setFechaHora(String fecha){
     fecha_hora=fecha;
     }
     public void setRondas(int rondas){
     numero_rondas=rondas;
     }
    //version de jugar de GUI el control de las partidas/rondas se hace desde el invocador
        public void JugarPartidaGUI(JTextArea areaP1,JTextArea areaP2,JLabel fecha,JLabel multiusos,JLabel NPartida,int m){
            Date date = new Date();
            String strDateFormat ="hh:mm:ss a dd-MMM-YYYY";
            SimpleDateFormat SDF = new SimpleDateFormat(strDateFormat);     
            fecha.setText("Fecha:"+SDF.format(date)+"\n");
             setFechaHora(SDF.format(date));
            Clave secreto1=new Clave("");
            Clave secreto2=new Clave("");
            Clave aux1=new Clave("");
            Clave aux2=new Clave("");
           // int puntosMarcadosP1=0;
           // int puntosMarcadosP2=0;
            int indice=(m-1);
            boolean P1Acertado=false;
            boolean P2Acertado=false;
            rondaP1[indice]=new Ronda();
            rondaP2[indice]=new Ronda();
            multiusos.setText("");
            NPartida.setText((m)+"º PARTIDA");
            //Clave para el Jugado 2
            JOptionPane.showMessageDialog(areaP1, ("¿Que clave debe adivinar "+jugador2.getNombre()+"?(debe introducir la clave "+jugador1.getNombre()+")"));
            Clave clave_jugador2=secreto2.pedirClaveGUI();//pide la clave que va a tener que acertar el jugador2
            areaP1.setText("");
             //CLAVE PARA EL JUGADOR 1
            JOptionPane.showMessageDialog(areaP1, ("¿Que clave debe adivinar "+jugador1.getNombre()+"?(debe introducir la clave "+jugador2.getNombre()+")"));
            areaP2.setText("");
            Clave clave_jugador1=secreto1.pedirClaveGUI();        //pide la clave que va a tener que acertar el jugador1
            for (int j=1;j<11;j++){
                Clave intento1 = null;
                Clave intento2 = null;            
                    if(j==1){//el primer intento no debe mostrar los intentos anteriores puesto que es el primer intento
                        areaP1.setText("TURNO "+j+" DE "+jugador1.getNombre()+"\n");
                        intento1 = aux1.pedirClaveGUI();                       
                        rondaP1[indice].agregarRonda(intento1.getClave(),clave_jugador1.compararClavesAciertos(intento1),clave_jugador1.compararClavesColocados(intento1));
                        areaP1.setText("");
                        //jugador 2
                        areaP2.setText("TURNO "+j+" DE "+jugador2.usuario+"\n"); //JUGADOR 2
                        intento2=aux2.pedirClaveGUI();
                        rondaP2[indice].agregarRonda(intento2.getClave(),clave_jugador2.compararClavesAciertos(intento2),clave_jugador2.compararClavesColocados(intento2));
                        areaP1.setText("");
                        if(clave_jugador1.esGanadora(intento1)&&clave_jugador2.esGanadora(intento2)){//si ambos aciertan en el mismo intento
                            P2Acertado=true;
                            P1Acertado=true;
                            puntosAnotadosP1+=11-j;
                            puntosAnotadosP2+=11-j;
                            JOptionPane.showMessageDialog(null,(jugador1.usuario+" HA ACERTADO LA CLAVE EN EL "+(j)+"º INTENTO!\n"+jugador2.usuario+" HA ACERTADO LA CLAVE EN EL "+(j)+"º INTENTO!\n"),"ACIERTOS",1);
                        }
                        else if(clave_jugador1.esGanadora(intento1)) {//si el jugador1 acierta la clave
                            JOptionPane.showMessageDialog(null,jugador1.usuario+" HA ACERTADO LA CLAVE EN EL "+(j)+"º INTENTO!\n","ACIERTOS",1);
                            puntosAnotadosP1+=11-j;
                            P1Acertado=true;
                        }//fin del if ganador jugador 1 perdedor jugador 2 
                        else if(clave_jugador2.esGanadora(intento2)){//si el jugador2 acierta la clave 
                          JOptionPane.showMessageDialog(null,jugador2.usuario+" HA ACERTADO LA CLAVE EN EL "+(j)+"º INTENTO!\n","ACIERTOS",1);
                            puntosAnotadosP2+=11-j;
                            P2Acertado=true;
                        }
                        areaP1.setText("");
                        areaP2.setText("");
                    }//fin del if del primer intento(no muestra leerRondas())
                    else if(j>1&&P1Acertado&&!P2Acertado){// if de si ha acertado el jugador 1 pero no el dos, que siga intentandolo
                        areaP2.setText("TURNO "+j+" DE "+jugador2.usuario+"\n"); 
                         areaP2.append(rondaP2[indice].leerRondas());                   
                        intento2=aux2.pedirClaveGUI();
                        rondaP2[indice].agregarRonda(intento2.getClave(),clave_jugador2.compararClavesAciertos(intento2),clave_jugador2.compararClavesColocados(intento2));
                        if(clave_jugador2.esGanadora(intento2)){//si el jugador2 acierta la clave 
                            JOptionPane.showMessageDialog(null,jugador2.usuario+" HA ACERTADO LA CLAVE EN EL "+(j)+"º INTENTO!\n","ACIERTOS",1);
                            puntosAnotadosP2+=11-j;
                            P2Acertado=true;
                            }
                        areaP2.setText("");
                     }
                    else if(j>1&&!P1Acertado&&P2Acertado){// if de si ha acertado el jugador 2 pero no el uno ,que siga intentandolo
                        areaP1.setText("TURNO "+j+" DE "+jugador1.getNombre()+"\n");
                        areaP1.append(rondaP1[indice].leerRondas());
                        intento1 = aux1.pedirClaveGUI();
                        rondaP1[indice].agregarRonda(intento1.getClave(),clave_jugador1.compararClavesAciertos(intento1),clave_jugador1.compararClavesColocados(intento1));
                        if(clave_jugador1.esGanadora(intento1)) {//si el jugador1 acierta la clave
                            JOptionPane.showMessageDialog(null,jugador1.usuario+" HA ACERTADO LA CLAVE EN EL "+(j)+"º INTENTO!\n","ACIERTOS",1);
                            puntosAnotadosP1+=11-j;
                            P1Acertado=true;
                        }
                        areaP1.setText("");
                    }
                    else if ((j>1&&!P1Acertado&&!P2Acertado)){//ninguno de los dos ha acertado
                         areaP1.setText("TURNO "+j+" DE "+jugador1.getNombre()+"\n");
                        areaP1.append(rondaP1[indice].leerRondas());
                        intento1 = aux1.pedirClaveGUI();//pide el intento
                        rondaP1[indice].agregarRonda(intento1.getClave(),clave_jugador1.compararClavesAciertos(intento1),clave_jugador1.compararClavesColocados(intento1));//agrega el intento a las rondas
                         areaP1.setText("");
                        //jugador 2
                        areaP2.setText("TURNO "+j+" DE "+jugador2.getNombre()+"\n"); //JUGADOR 2
                        areaP2.append(rondaP2[indice].leerRondas());//muestra los intentos pasados
                        intento2=aux2.pedirClaveGUI();
                        rondaP2[indice].agregarRonda(intento2.getClave(),clave_jugador2.compararClavesAciertos(intento2),clave_jugador2.compararClavesColocados(intento2));
                        areaP2.setText("");
                        if((clave_jugador2.esGanadora(intento2)&&P2Acertado==false)&&(clave_jugador1.esGanadora(intento1)&&P1Acertado==false)){//si  aciertan a la vez
                            JOptionPane.showMessageDialog(null,(jugador1.usuario+" HA ACERTADO LA CLAVE EN EL "+(j)+"º INTENTO!\n"+jugador2.usuario+" HA ACERTADO LA CLAVE EN EL "+(j)+"º INTENTO!\n"),"ACIERTOS",1);
                            puntosAnotadosP1+=11-j;//los puntos anotados de uno son los encajados del otro y como si acierta a las primera es 10 y la j empieza en 1, es 11 -j
                            P1Acertado=true;//acertado=verdadero para que no pida mas intentos de ese jugador
                            puntosAnotadosP2+=11-j;
                            P2Acertado=true;
                        }
                        else if(clave_jugador1.esGanadora(intento1)&&P1Acertado==false) {//si el jugador1 acierta la clave
                            JOptionPane.showMessageDialog(null,jugador1.usuario+" HA ACERTADO LA CLAVE EN EL "+(j)+"º INTENTO!\n","ACIERTOS",1);
                            puntosAnotadosP1+=11-j;
                            P1Acertado=true;
                        }//fin del if ganador jugador 1 perdedor jugador 2 
                        else if(clave_jugador2.esGanadora(intento2)&&P2Acertado==false){//si el jugador2 acierta la clave 
                            JOptionPane.showMessageDialog(null,jugador2.usuario+" HA ACERTADO LA CLAVE EN EL "+(j)+"º INTENTO!\n","ACIERTOS",1);
                            puntosAnotadosP2+=11-j;
                            P2Acertado=true;
                        }
                        
                    }//fin del if
                    else if (P1Acertado && P2Acertado){//si ambos aciertan la clave
                            j=11;//para salir del bucle for de los intentos
                        }
                     else if (j==10 && !P1Acertado && !P2Acertado)
                            multiusos.setText("NINGUNO JUGADOR HA ACERTADO. FIN DE LA "+(m)+"º PARTIDA");
                     else if (j==10 && P1Acertado && !P2Acertado)
                            multiusos.setText("EL JUGADOR "+jugador2.getNombre()+" NO HA ACERTADO. FIN DE LA "+(m)+"º PARTIDA");
                     else if (j==10 && !P1Acertado && P2Acertado)
                            multiusos.setText("EL JUGADOR "+jugador1.getNombre()+" MO HA ACERTADO. FIN DE LA "+(m)+"º PARTIDA");
            }// CIERRE FOR DE LOS 10 intentos  
          
    }
    public int getPuntosP1(){
    return puntosAnotadosP1;
    }
    public int getPuntosP2(){
    return puntosAnotadosP2;
    }
    public void JugarPartida(){//version de la interfaz de texto, parecido al anterior pero aqui esta el bucle del numero de partidas/rondas , las explicaciones serian las mismas que antes
        Clave secreto1=new Clave("");
        Clave secreto2=new Clave("");
        Clave aux1=new Clave("");
        Clave aux2=new Clave("");
        int puntosMarcadosP1=0;
        int puntosMarcadosP2=0;
        
        for (int i=0;i<numero_rondas/*3*/;i++){
            //numero_rondas = i;
            
            boolean P1Acertado=false;
            boolean P2Acertado=false;
            rondaP1[i]=new Ronda();
            rondaP2[i]=new Ronda();
            System.out.println("------------ "+(i+1)+"º PARTIDA --------------------");
            System.out.println("\n¿Que clave debe adivinar "+jugador2.getNombre()+" ?(debe introducir la clave "+jugador1.getNombre()+"):"); // CLAVE PARA EL JUGADOR 2
            Clave clave_jugador2=secreto2.pedirClave();
            System.out.println("\n¿Que clave debe adivinar "+jugador1.getNombre()+" ?(debe introducir la clave "+jugador2.getNombre()+"):"); // CLAVE PARA EL JUGADOR 1
            Clave clave_jugador1=secreto1.pedirClave();
            
            for (int j=1;j<11;j++){
                Clave intento1 = null;
                Clave intento2 = null;
                
                    if(j==1){
                        System.out.println("TURNO "+j+" DE "+jugador1.getNombre());
                        intento1 = aux1.pedirClave();
                        System.out.println("\nEl numero de aciertos es: "+clave_jugador1.compararClavesAciertos(intento1));
                        System.out.println("El numero de parejas colocadas en orden es: "+clave_jugador1.compararClavesColocados(intento1)+"\n"); 
                        rondaP1[i].agregarRonda(intento1.getClave(),clave_jugador1.compararClavesAciertos(intento1),clave_jugador1.compararClavesColocados(intento1));
                        //jugador 2
                        System.out.println("TURNO "+j+" DE "+jugador2.usuario); //JUGADOR 2
                        intento2=aux2.pedirClave();
                        System.out.println("\nEl numero de aciertos es: "+clave_jugador2.compararClavesAciertos(intento2));
                        System.out.println("El numero de parejas colocadas en orden es: "+clave_jugador2.compararClavesColocados(intento2)+"\n"); 
                        rondaP2[i].agregarRonda(intento2.getClave(),clave_jugador2.compararClavesAciertos(intento2),clave_jugador2.compararClavesColocados(intento2));
                        if(clave_jugador1.esGanadora(intento1)&&clave_jugador2.esGanadora(intento2)){
                            P2Acertado=true;
                            P1Acertado=true;
                            puntosMarcadosP1+=11-j;
                            puntosMarcadosP2+=11-j;
                            System.out.println(jugador1.usuario+" HA ACERTADO LA CLAVE EN EL "+(j)+"º INTENTO!\n");
                            System.out.println(jugador2.usuario+" HA ACERTADO LA CLAVE EN EL "+(j)+"º INTENTO!\n");
                        }
                        else if(clave_jugador1.esGanadora(intento1)) {//si el jugador1 acierta la clave
                            System.out.println(jugador1.usuario+" HA ACERTADO LA CLAVE EN EL "+(j)+"º INTENTO!\n");
                            puntosMarcadosP1+=11-j;
                            P1Acertado=true;
                        }//fin del if ganador jugador 1 perdedor jugador 2 
                        else if(clave_jugador2.esGanadora(intento2)){//si el jugador2 acierta la clave 
                            System.out.println(jugador2.usuario+" HA ACERTADO LA CLAVE EN EL "+(j)+"º INTENTO!\n");
                            puntosMarcadosP2+=11-j;
                            P2Acertado=true;
                        }
                        
                    }//fin del if del primer intento(no muestra leerRondas())
                    else if(j>1&&P1Acertado&&!P2Acertado){// if de si ha acertado el jugador 1 pero no el dos, que siga intentandolo
                        System.out.println("TURNO "+j+" DE "+jugador2.usuario); 
                         System.out.println(rondaP2[i].leerRondas());                   
                        intento2=aux2.pedirClave();
                        System.out.println("\nEl numero de aciertos es: "+clave_jugador2.compararClavesAciertos(intento2));
                        System.out.println("El numero de parejas colocadas en orden es: "+clave_jugador2.compararClavesColocados(intento2)+"\n"); 
                        rondaP2[i].agregarRonda(intento2.getClave(),clave_jugador2.compararClavesAciertos(intento2),clave_jugador2.compararClavesColocados(intento2));
                        if(clave_jugador2.esGanadora(intento2)){//si el jugador2 acierta la clave 
                            System.out.println(jugador2.usuario+" HA ACERTADO LA CLAVE EN EL "+(j)+"º INTENTO!\n");
                            puntosMarcadosP2+=11-j;
                            P2Acertado=true;
                            }
                        
                     }
                    else if(j>1&&!P1Acertado&&P2Acertado){// if de si ha acertado el jugador 2 pero no el uno ,que siga intentandolo
                         System.out.println("TURNO "+j+" DE "+jugador1.getNombre());
                         System.out.println(rondaP1[i].leerRondas());
                        intento1 = aux1.pedirClave();
                        System.out.println("\nEl numero de aciertos es: "+clave_jugador1.compararClavesAciertos(intento1));
                        System.out.println("El numero de parejas colocadas en orden es: "+clave_jugador1.compararClavesColocados(intento1)+"\n"); 
                        rondaP1[i].agregarRonda(intento1.getClave(),clave_jugador1.compararClavesAciertos(intento1),clave_jugador1.compararClavesColocados(intento1));
                        if(clave_jugador1.esGanadora(intento1)) {//si el jugador1 acierta la clave
                            System.out.println(jugador1.usuario+" HA ACERTADO LA CLAVE EN EL "+(j)+"º INTENTO!\n");
                            puntosMarcadosP1+=11-j;
                            P1Acertado=true;
                        } 
                    }
                    else if ((j>1&&!P1Acertado&&!P2Acertado)){
                        System.out.println("TURNO "+j+" DE "+jugador1.getNombre());
                        System.out.println(rondaP1[i].leerRondas());
                        intento1 = aux1.pedirClave();
                        System.out.println("\nEl numero de aciertos es: "+clave_jugador1.compararClavesAciertos(intento1));
                        System.out.println("El numero de parejas colocadas en orden es: "+clave_jugador1.compararClavesColocados(intento1)+"\n"); 
                        rondaP1[i].agregarRonda(intento1.getClave(),clave_jugador1.compararClavesAciertos(intento1),clave_jugador1.compararClavesColocados(intento1));
                        //jugador 2
                        
                        System.out.println("TURNO "+j+" DE "+jugador2.usuario); //JUGADOR 2
                        System.out.println(rondaP2[i].leerRondas());
                        intento2=aux2.pedirClave();
                        System.out.println("\nEl numero de aciertos es: "+clave_jugador2.compararClavesAciertos(intento2));
                        System.out.println("El numero de parejas colocadas en orden es: "+clave_jugador2.compararClavesColocados(intento2)+"\n"); 
                        rondaP2[i].agregarRonda(intento2.getClave(),clave_jugador2.compararClavesAciertos(intento2),clave_jugador2.compararClavesColocados(intento2));
                        
                        if(clave_jugador1.esGanadora(intento1)&&P1Acertado==false) {//si el jugador1 acierta la clave
                            System.out.println(jugador1.usuario+" HA ACERTADO LA CLAVE EN EL "+(j)+"º INTENTO!\n");
                            puntosMarcadosP1+=11-j;
                            P1Acertado=true;
                        }//fin del if ganador jugador 1 perdedor jugador 2 
                        else if(clave_jugador2.esGanadora(intento2)&&P2Acertado==false){//si el jugador2 acierta la clave 
                            System.out.println(jugador2.usuario+" HA ACERTADO LA CLAVE EN EL "+(j)+"º INTENTO!\n");
                            puntosMarcadosP2+=11-j;
                            P2Acertado=true;
                        }
                        
                        
                    }//fin del if
                   else if (P1Acertado && P2Acertado){//si ambos aciertan la clave
                            j=11;//para salir del bucle for de los intentos
                        }
                     else if (j==10 && !P1Acertado && !P2Acertado)
                            System.out.println("NINGUNO JUGADOR HA ACERTADO. FIN DE LA "+(i+1)+"º PARTIDA");
                     else if (j==10 && P1Acertado && !P2Acertado)
                            System.out.println("EL JUGADOR"+jugador2.getNombre()+" HA ACERTADO. FIN DE LA "+(i+1)+"º PARTIDA");
                     else if (j==10 && !P1Acertado && P2Acertado)
                            System.out.println("EL JUGADOR"+jugador1.getNombre()+" HA ACERTADO. FIN DE LA "+(i+1)+"º PARTIDA");
            }// CIERRE FOR DE LAS 10 RONDAS          
        }// CIERRE FOR DE LAS 3 PARTIDAS2
        puntosAnotadosP1=puntosMarcadosP1;
        puntosAnotadosP2=puntosMarcadosP2;
        System.out.println(jugador1.getNombre()+" ha hecho "+puntosAnotadosP1+" y "+jugador2.getNombre()+" ha hecho "+puntosAnotadosP2);
        jugador1.setPuntos_anotados(jugador1.getPuntos_anotados()+puntosMarcadosP1);
        jugador1.setPuntos_encajados(jugador1.getPuntos_encajados()+puntosMarcadosP2);
        jugador2.setPuntos_anotados(jugador2.getPuntos_anotados()+puntosMarcadosP2);
        jugador2.setPuntos_encajados(jugador2.getPuntos_encajados()+puntosMarcadosP1);
        if(puntosMarcadosP1>puntosMarcadosP2){
            jugador1.setPartidas_ganadas(jugador1.getPartidas_ganadas()+1);
            jugador2.setPartidas_perdidas(jugador2.getPartidas_perdidas()+1);
            System.out.println("EL GANADOR ES "+jugador1.getNombre());
        }
        else if(puntosMarcadosP1<puntosMarcadosP2){
            jugador2.setPartidas_ganadas(jugador2.getPartidas_ganadas()+1);
            jugador1.setPartidas_perdidas(jugador1.getPartidas_perdidas()+1);
            System.out.println("EL GANADOR ES "+jugador2.getNombre());
        }
        else{System.out.println("Habeis quedado empate");}
        double porcentajeP1=(jugador1.getPartidas_ganadas()*100)/jugador1.getPartidas_jugadas();
        double porcentajeP2=(jugador2.getPartidas_ganadas()*100)/jugador2.getPartidas_jugadas();
        jugador1.setPorcentaje_victorias(porcentajeP1);
        jugador2.setPorcentaje_victorias(porcentajeP2);

    }
    
        @Override
        public String toString(){
        return "fecha y hora: "+fecha_hora+" Numero de rondas: "+(numero_rondas+1)+" JUGADOR 1: "+jugador1.getNombre()+" JUGADOR 2: "+jugador2.getNombre();
                }

}
     
