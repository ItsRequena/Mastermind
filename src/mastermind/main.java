package mastermind;
/**
 *
 * @author raulrodriguezlopez-rey
 */
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Scanner;
public class main {

    public static void main(String[] args) throws IOException, ClassNotFoundException, Exception  {
    //Atributos
    Scanner choose = new Scanner(System.in);
    boolean salir = false;    
    Almacen storage =new Almacen();
    Input entrada = new Input();
    Usuario Admin = new Usuario("admin","0000");
    String ficherot="FicheroNombresClaves.txt";
    Admin.setAdministrador();
    storage.Registrar(Admin);
    //Aseguramos que el Administrador este metido en la lista
    try{
    entrada.abrirAlmacen("lista.bin");
    storage =entrada.leerAlmacen();
    entrada.cerrarAlmacen();
    }
    catch(FileNotFoundException fnfe){
        System.out.println("No existe ese fichero");
    } 
    while(!salir){
    System.out.println("******************************");
    System.out.println("*1.REGISTRARSE               *");
    System.out.println("*2.LOGIN                     *"); 
    System.out.println("*3.SALIR                     *");
    System.out.println("******************************");
    System.out.println("Escribe una de las opciones:");
    int opcion = choose.nextInt();
      Scanner datosReg = new Scanner(System.in);
      Scanner datosLog = new Scanner(System.in);
        switch(opcion){
            //Opcion de registrar un usuario
            case 1: System.out.println("\nHas seleccionado **REGISTRAR**\n ");
                    String nombre = "";
                    String codigo= "";
                    System.out.print("Introduce tu nombre: ");        
                    nombre = datosReg.nextLine();//Guarda el nombre del usuario
                    System.out.print("Introduce la clave: ");       
                    codigo=datosReg.nextLine();//Guarda la clave del usuario
                    if (codigo.isEmpty() || nombre.isEmpty()){ //Si la cadena es vacia no lo registra
                        System.out.println("No se puede introducir el usuario");
                    }else{  //Si la cadena no es vacia si lo registra
                        Usuario player1= new Usuario(nombre,codigo);
                        storage.Registrar(player1);
                    }
                    
                break;
            //Opcion de logearte en el juego    
            case 2: System.out.println("\nHas seleccionado **LOGIN**\n ");
                    String login= "";
                    String id = "";
                    System.out.print("Introduce tu nombre: ");
                    id = datosLog.nextLine();//lee el nombre del usuario
                    System.out.print("Introduce la clave: ");
                    login=datosLog.nextLine();//lee la constraseña del usuario
                    Usuario ini= new Usuario(id,login); //contruimos un nuevo objeto usuario
                    if (storage.ExisteUsuario(ini)==true){ //comprobamos que existe el usuario
                        Usuario jugador1=storage.IdentificarUsuario(ini);
                        boolean menuAdmin=false;
                        if(jugador1.getAdministrador())//si el usuario es administrador le lleva al menu del admin
                            menuAdmin=true;
                        boolean salirMenuUsuario=false;
                        while(!salirMenuUsuario){
                            if(menuAdmin==false){ //si no es administrador le llevamos al menu del jugador           
                                while (!salirMenuUsuario) {
                                    System.out.println("\n**********MENU DE USUARIO***********");
                                    System.out.println("* 1.PARTIDA:                        *");
                                    System.out.println("* 2.ENTRENAMIENTO:                  *"); 
                                    System.out.println("* 3.ESTADISTICAS:                   *");
                                    System.out.println("* 4.SALIR:                          *");
                                    System.out.println("*************************************");                             
                                    int opcionLogin = choose.nextInt();
                                    switch (opcionLogin){
                                        //Opcion para jugar la partida
                                        case 1: System.out.println("CARGANDO PARTIDA...");
                                                String login2= "";
                                                String id2 = "";
                                                System.out.println("Introduce el nombre del rival:");
                                                id2 = datosLog.nextLine(); //lee el nombre del rival
                                                System.out.println("Introduce la clave del rival:");
                                                login2=datosLog.nextLine();//lee la clave del rival
                                                Usuario rival= new Usuario(id2,login2);//construimos el nuevo rival
                                                //miramos que el rival no sea el mismo usuario que el jugador contra el que juega
                                                if (rival.getNombre().equals(jugador1.getNombre()) && (rival.getClave().equals(jugador1.getClave()))){
                                                    System.out.println("No puedes jugar contra ti mismo");
                                                }else{
                                                    if (storage.ExisteNombreClave(rival)==true){ //comprobamos que el rival tenga que estar registrado       
                                                        Usuario jugador2 = storage.IdentificarUsuario(rival);
                                                        Partida partida= new Partida(jugador2,jugador1);
                                                        jugador1.partidas_jugadas+=1;
                                                        jugador2.partidas_jugadas+=1;
                                                        partida.JugarPartida();//metodo para jugar la partida
                                                        storage.addPartida(partida);//añadimos la partida a la lista de partidas
                                                    }
                                                    else{
                                                        System.out.println("El usuario debe estar registrado para poder jugar.");
                                                    }
                                                }
                                            break;
                                        //Opcion del entrenamiento
                                        case 2: System.out.println("\n********ENTRENAMIENTO********\n");
                                                System.out.print("Introduce el numero de rondas:");
                                                int rondas=choose.nextInt();//elegimos las rondas para el entrenamiento
                                                if(rondas>0){
                                                    Entrenamiento entrenamiento=new Entrenamiento(rondas);//Constructor del entrenamiento con las rondas
                                                    entrenamiento.entrenar(jugador1);//juego del entrenamiento    
                                                            }
                                                else System.out.println("Introduce un numero mayor a 0.");  
                                            break;
                                        //Opcion de las estadisticas
                                        case 3: System.out.println("ESTADISTICAS");
                                            //EMPIEZA EL MENU DE LAS ESTADISTICAS
                                            boolean salirEstadisticas = false;
                                            while(!salirEstadisticas){
                                            System.out.println("\n****************************");
                                            System.out.println("*1.MI LISTA DE PARTIDAS:    *");
                                            System.out.println("*2.RANKING:                 *");
                                            System.out.println("*3.SALIR                    *");
                                            System.out.println("*****************************");
                                            int opcionEstadistica = choose.nextInt();
                                            switch(opcionEstadistica){
                                                //Opcion de las partidas del jugador
                                                case 1:
                                                        System.out.println(storage.leerListaPartidas(jugador1,false));
                                                    break;
                                                //Opcion del RANKING
                                                case 2: 
                                                        Scanner elige = new Scanner(System.in);
                                                        System.out.println(storage.clasificacionPartidas(true));
                                                        System.out.println("\nQuiere ordenarlo por partidas ganadas?(S/N)");
                                                        char ranking=elige.next().charAt(0);
                                                        if(ranking=='S'||ranking=='s'){
                                                        System.out.println(storage.clasificacionPartidas(false));}
                                                        else if(ranking=='N'){}
                                                        else  System.out.println("Escribe una opcion correcta la proxima vez.");
                                                    break;
                                                //Opcion salir de este menu
                                                case 3:
                                                        salirEstadisticas = true;
                                                    break;
                                                default:
                                                    System.out.println("Solo números entre 1 y 3");                                            
                                                                    }//FIN DEL SWITCH                            
                                                                }//FIN DEL WHILE
                                            //FIN MENU ESTADISTICAS
                                        break;
                                        case 4: 
                                            salirMenuUsuario = true;
                                        break;
                                        default:
                                            System.out.println("Solo números entre 1 y 3");
                                                    }//FIN DEL SWITCH
                                                }//FIN DEL WHILE del menu de usuario
                                        }//FIN DEL IF 
                                 else if (menuAdmin==true){
                                menuAdmin=true;
                                System.out.println("\n   ***MENU DE ADMINISTRADOR***         ");
                                System.out.println("*************************************");
                                System.out.println("*1.AGREGAR ADMINISTRADOR:           *");
                                System.out.println("*2.BORRAR USUARIO:                  *"); 
                                System.out.println("*3.LISTA DE USUARIOS:               *"); 
                                System.out.println("*4.ESTADISTICAS:                    *");
                                System.out.println("*5.MENU USUARIO:                    *");
                                System.out.println("*6.IMPRIMIR CLASIFICACION.TXT:      *");
                                System.out.println("*7.SALIR:                           *");
                                System.out.println("*************************************");
                                int opcionLogin = choose.nextInt();
                                switch (opcionLogin){
                                    //Opcion agregar administrador
                                    case 1: 
                                            System.out.println("Vas a agregar un nuevo administrador\n");
                                            Scanner nuevoAdmin =new Scanner(System.in);
                                            String nombreAdmin = "";
                                            String codigoAdmin= "";
                                            System.out.println("Introduce el nombre");
                                            nombreAdmin = nuevoAdmin.nextLine();//lee el nombre del usuario admin
                                            System.out.println("Introduzca la clave");
                                            codigoAdmin=nuevoAdmin.nextLine();//lee la contraseña del usuario admin
                                            Usuario adminNuevo= new Usuario(nombreAdmin,codigoAdmin);
                                            adminNuevo.setAdministrador();//se hace administrador
                                            storage.Registrar(adminNuevo);//registramos el nuevo administrador en la lista
                                           break;
                                    //Opcion Borrar usuario
                                    case 2: System.out.println("Has seleccionado la opcion **BORRAR USUARIO**\n:");
                                            System.out.println("A continuacion se muestra la lista de los usuarios que hay registrados.");
                                            System.out.println("Selecciona el indice que aparace a la izquierda del nombre que quieres eliminar\n");
                                            System.out.println(storage.leerLista());//leemos la lista de usuarios
                                            int indice= choose.nextInt();//choose esta declarado al principio del main
                                            storage.eliminarLista(indice);//introducimos la posicion del usuario que queremos borrar
                                        break;
                                    //Opcion mostrar lista usuarios
                                    case 3: System.out.println("*******LISTA USUARIOS*******\n");
                                            System.out.println("La lista de usuarios es: ");
                                            System.out.println("----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------");
                                            System.out.println(storage.leerLista());
                                        break;
                                    //Opcion menu estadisticas
                                    case 4:System.out.println("ESTADISTICAS");
                                            //EMPIEZA EL MENU DE LAS ESTADISTICAS
                                            boolean salirEstadisticas = false;
                                            while(!salirEstadisticas){
                                            System.out.println("\n********************************");
                                            System.out.println("*1.Lista completa de partidas:  *");
                                            System.out.println("*2.RANKING:                     *");
                                            System.out.println("*3.SALIR                        *");
                                            System.out.println("*********************************");
                                            int opcionEstadistica = choose.nextInt();
                                            switch(opcionEstadistica){
                                                //Opcion lista partidas
                                                case 1:
                                                        //El admin ve todas las partidas jugadas
                                                        System.out.println(storage.leerListaPartidas(jugador1,true));
                                                    break;
                                                //Opcion del RANKING
                                                case 2: Scanner elige = new Scanner(System.in);
                                                        System.out.println(storage.clasificacionPartidas(true));
                                                        System.out.println("\nQuiere ordenarlo por partidas ganadas?(S/N)");
                                                        char ranking=elige.next().charAt(0);
                                                        if(ranking=='S'||ranking=='s'){
                                                        System.out.println(storage.clasificacionPartidas(false));}
                                                        else if(ranking=='N'){}
                                                        else  System.out.println("Escribe una opcion correcta la proxima vez");
                                                    break;
                                                case 3:
                                                        salirEstadisticas = true;
                                                    break;
                                                default:
                                                    System.out.println("Solo números entre 1 y 3");                                            
                                                                    }//FIN DEL SWITCH                            
                                                                }//FIN DEL WHILE
                                            //FIN MENU ESTADISTICAS
                                        break;
                                    case 5: 
                                        menuAdmin = false;
                                        break;
                                    case 6:
                                            System.out.println("Intoduce la ruta donde quiere guardar la clasificacion: ");
                                            Scanner ficherotext = new Scanner(System.in);
                                            String ruta = ficherotext.nextLine();
                                            storage.escribirClasificacionTxt(ruta);
                                            System.out.println("Fichero de texto escrito!");
                                        break;
                                    case 7: 
                                        salirMenuUsuario = true;
                                        break;
                                     default:
                                         System.out.println("Solo números entre 1 y 8");  
                                                    }//fin del switch del opcion login
                                                }//end del if administrador          
                        }//del switch salirAdmin
                    }else System.out.println("Comprueba los parametros de incio de sesion."); //si no esta el usario en la lista  
                    break;
            case 3:
                storage.escribirNombreClaveTxt(ficherot);
                salir=true;
                System.out.println("Has cerrado el programa. \nHasta pronto.");
            break;
            default:
                   System.out.println("Solo números entre 1 y 4.");    
        }//del switch
    }//del while
    Output salida = new Output();
    salida.abrirAlmacen("lista.bin");
    salida.escribirAlmacen(storage);
    salida.cerrarAlmacen();
    }
}