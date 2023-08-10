package mastermind;
import java.util.*;
import java.io.*;
import java.io.BufferedWriter;
import java.util.ArrayList;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class Almacen extends Usuario implements Serializable{
protected ArrayList<Partida> lista_partidas; //lista dinamica para las partidas   
protected ArrayList<Usuario> lista; //lista dinamica para los usuarios
    
    //Constructores del arraylist de almacen
    public Almacen(String usuario, String clave) {
        super(usuario, clave);
        this.lista = new ArrayList();
        this.lista_partidas = new ArrayList();
    }
    
    public Almacen() {
        this.lista = new ArrayList();
        this.lista_partidas = new ArrayList();
        
    }
    
    //Metodo para registrar un usuario
    public  void Registrar(Usuario u) throws IOException{
        boolean esta=ExisteNombreClave(u);
        if(esta==false){ //comprueba si dentro de la lista esta el usuario introducido o no
            boolean add = lista.add(u);
            if(add==true)
                if (!(u.getNombre()== "admin"))
                    System.out.println("El usuario se ha registrado correctamente");
        }
        else
            if (!(u.getNombre()== "admin") || u.getClave() == "0000")
                System.out.println("El usuario ya esta registrado. La ID que quiere utilizar no está disponible.");
    }
    
    //Metodo para identificar el usuario, devuelve el usuario introducido si lo encuentra pero su equivalente de la lista para que tenga todos sus atributos
    public void Identificar(Usuario u){
        if(ExisteNombreClave(u)==false)
            System.out.println("\nEl usuario no esta registrado");
    }

     public Usuario IdentificarUsuario(Usuario u){
        if(ExisteNombreClave(u)==false){
            
            System.out.println("\nEl usuario no esta registrado");
            return u=null;            
        }
        else{ System.out.println("\nBienvenido "+u.getNombre());
            return getUsuario(u);
               }      
        }
    
   
    //Metodo para añadir un usuario a la lista de usuarios
    public void addUsuario(Usuario u) {
        lista.add(u);
    }
    
    //Metodo para añadir una partida a la lista de partidas
    public void addPartida(Partida p){
        lista_partidas.add(p);
    }
    
    //Metodo para saber si el nombre y la clave ya esta introducida
    public boolean ExisteNombreClave(Usuario u){
        for (int i=0;i<=lista.size()-1;i++){   //recorre la lista entera comparando cada posicion con el usuario introducido
            if ( u.getNombre().equals(lista.get(i).usuario)){
                return true; 
            }
        }
        return false;
    }
    public boolean ExisteUsuario(Usuario u){
        for (int i=0;i<=lista.size()-1;i++){   //recorre la lista entera comparando cada posicion con el usuario introducido
            if ( u.getNombre().equals(lista.get(i).usuario) && u.getClave().equals(lista.get(i).clave)){
                return true; 
            }
        }
        return false;
    }
    
    //GETTERS
    public Usuario getUsuario(Usuario u){
        for (int i=0;i<lista.size();i++){
            if (u.clave.equals(lista.get(i).clave) && u.usuario.equals(lista.get(i).usuario))
                return lista.get(i);
                                        }
        return null;
    }
    
    public boolean getAdministrador(Usuario u) {         
       return getUsuario(u).administrador;
    }
    
    //se usar en las GUI para las clasificaciones
    public ArrayList<Usuario> getLista(){
    return lista;
    }
    
    //Metodo para eliminar un usuario de la lista, si el que se desea borrar es el admin no va a dejar porque es imprescindible si queremos agregar mas administradores o acceder al menu
    //es el admin genuino
    public void eliminarLista(int indice){
        if (lista.get(indice).getNombre().equals("admin")) System.out.println("No se puede eliminar el administrador principal"); //si el usuario es igual al admin
                                                                                                   //no se puede eliminar
        else if(indice>=0 && indice<lista.size()){
            lista.remove(indice); //elimina el usuario de la lista
            System.out.println("Se ha eliminado el usuario correctamente");
        }
                                                                                         
        else System.out.println("Introduce un indice valido");
    }
    
    //Metodo para leer la lista de usuarios
    public String leerLista(){
        Iterator it = lista.iterator(); 
        String aux="";
        int i=0;
        while (it.hasNext()){

                aux+=i+" "+it.next().toString()+
                "\n-----------------------------------------------------------------------------------------------------------"
                        + "-------------------------------------------------------------------------------------------------------------------\n";
                i++;    
        }
        return aux;
    }
    
    public String leerListaPartidas(Usuario u,boolean completa){//muestra los resultados de las partidas en las que el usuario con el que se ha iniciado sesion si completa es false
        //si el completa es true muestra las de todos, esta ultima se usa en el menu admin
        //ha jugado
        int k=0;
        String aux="";
        if(completa==false){
            for(int i=0;i<=lista_partidas.size()-1;i++){
                if(u.getNombre().equals(lista_partidas.get(i).jugador1.getNombre())||u.getNombre().equals(lista_partidas.get(i).jugador2.getNombre())){//para que solo les muestre las partidas en las que aparecen ellos
                k++;    
                aux+="Partida "+(k)+" "+lista_partidas.get(i).toString()+"\n";
                aux+="\n****Estas han sido las rondas de "+lista_partidas.get(i).jugador1.getNombre()+"****\n";
                for(int j=0;j<lista_partidas.get(i).rondaP1.length;j++){
                    aux+="\nRonda "+(j+1)+"\n";
                    aux+=lista_partidas.get(i).rondaP1[j].leerRondas()+"\n";
                    
                }
                aux+="\n****Estas han sido las rondas de "+lista_partidas.get(i).jugador2.getNombre()+"****\n";
                for(int j=0;j<lista_partidas.get(i).rondaP2.length;j++){
                    aux+="\nRonda "+(j+1)+"\n";
                    aux+=lista_partidas.get(i).rondaP2[j].leerRondas()+"\n";
                }
                aux+=lista_partidas.get(i).jugador1.getNombre()+" ha hecho "+lista_partidas.get(i).puntosAnotadosP1+" y "+lista_partidas.get(i).jugador2.getNombre()+" ha hecho "+lista_partidas.get(i).puntosAnotadosP2;
                aux+="\n-----------------------------------------------------------------------------------------------------------"
                            + "---------------------------------------------------------------------------------------\n";
                }//fin del if si encuentra al jugador en las partidas(para mostrar solo las partidas en las que he ha estado) 

            }//fin del for que recorre la lista
            if(k==0){
                aux+=u.getNombre()+" no ha jugado ninguna partida aun";
            }
        }//fin del if completa==false
        else if(completa==true){//en el menu del admin hemos agregado la funcionalidad de ver todas las partidas, no solo en las que aparecen x usuarios
            for(int i=0;i<=lista_partidas.size()-1;i++){
                k++;    
                aux+="Partida "+(k)+" "+lista_partidas.get(i).toString()+"\n";
                aux+="\n****Estas han sido las rondas de "+lista_partidas.get(i).jugador1.getNombre()+"****\n";
                for(int j=0;j<lista_partidas.get(i).rondaP1.length;j++){
                    aux+="\nRonda "+(j+1)+"\n";
                    aux+=lista_partidas.get(i).rondaP1[j].leerRondas()+"\n";
                    
                }
                aux+="\n****Estas han sido las rondas de "+lista_partidas.get(i).jugador2.getNombre()+"****\n";
                for(int j=0;j<lista_partidas.get(i).rondaP2.length;j++){
                    aux+="\nRonda "+(j+1)+"\n";
                    aux+=lista_partidas.get(i).rondaP2[j].leerRondas()+"\n";
                }
                aux+=lista_partidas.get(i).jugador1.getNombre()+" ha hecho "+lista_partidas.get(i).puntosAnotadosP1+" y "+lista_partidas.get(i).jugador2.getNombre()+" ha hecho "+lista_partidas.get(i).puntosAnotadosP2;
                aux+="\n-----------------------------------------------------------------------------------------------------------"
                            + "---------------------------------------------------------------------------------------\n";
                

            }//fin del for que recorre la lista
            if(k==0){
                aux+=" No se ha jugado ninguna partida aun";
            }
        }
            
        return aux;
    }//fin de leerListaPartidas
    
    //Metodo para escribir en un fichero de texto los nombre y claves de los usuarios
    public void escribirNombreClaveTxt(String fichero) throws IOException{
        PrintWriter salida= new PrintWriter(new BufferedWriter(new FileWriter(fichero)));
        String espacio =" | ";
        for (Usuario u: lista ){
            salida.print (u.getNombre());//escribe el nombre del usuario
            salida.print(espacio);
            salida.println (u.getClave());//escribe la clave del usuario
        }
    salida.close(); //cierra el fichero
    }
    
    
    //Metodo de la clasificacion de las partidas
    public String clasificacionPartidas(boolean porcentaje){//si el porcentaje es false se ordena segun las partidas ganadas y si es true segun el porcentaje de victorias
            
        String aux="";
        if (porcentaje ==false){
            lista.sort(Comparator.comparing(Usuario::getPartidas_ganadas).reversed());  
            for (int i=0;i<lista.size();i++){

                    aux+=((i+1)+"º "+lista.get(i).Ranking()+"\n-----------------------------------------------------------------------------------------------------------"
                            + "------------------------------------------------------------------------\n");
            }//end del for
        }//end del if
        else if(porcentaje==true){
            lista.sort(Comparator.comparing(Usuario::getPorcentaje_victorias).reversed());  
            for (int i=0;i<lista.size();i++){
                aux+=((i+1)+"º "+lista.get(i).Ranking()+"\n-----------------------------------------------------------------------------------------------------------"
                                        + "------------------------------------------------------------------------\n");            
            }  //end del for     
        }//end del else if
        
        return aux; 
    }
    
    public void escribirClasificacionTxt(String ficherotxt) throws IOException{
        PrintWriter salida = new PrintWriter(new BufferedWriter(new FileWriter(ficherotxt)));
        if (salida !=null){ 
        for (int i=0;i<lista.size();i++){
            lista.sort(Comparator.comparing(Usuario::getPorcentaje_victorias).reversed());
            salida.println((i+1)+"º "+lista.get(i).Ranking());
            salida.println("-----------------------------------------------------------------------------------------------------------"
                            + "------------------------------------------------------------------------\n");
            }
        }else
            System.out.println("No se ha encontrado el fichero");
    salida.close(); //cierra el fichero
    }
    
}