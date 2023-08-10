/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mastermind;

import java.io.*;
import java.lang.Object;
/**
 *
 * @author raulrodriguezlopez-rey
 */
public class Input {
    private FileInputStream fileAlmacen;
    private ObjectInputStream inputAlmacen;
    
    //abrir el fichero
    public void abrirAlmacen(String ruta) throws IOException{
        fileAlmacen=new FileInputStream(ruta);
        inputAlmacen =new ObjectInputStream(fileAlmacen);
    }
    public void abrirAlmacenPrima(File ruta) throws IOException{
        fileAlmacen=new FileInputStream(ruta);
        inputAlmacen =new ObjectInputStream(fileAlmacen);
    }
    //cerrar el fichero de almacen
    
    public void cerrarAlmacen() throws IOException{
    if (inputAlmacen!=null)
        inputAlmacen.close();
    
    }
    public Almacen leerAlmacen() throws IOException, ClassNotFoundException{
      Almacen storage=null;
      if (inputAlmacen!=null){
      try{
          storage=(Almacen)
         inputAlmacen.readObject();
      }
       catch (EOFException eof){
      //fin del fichero}
      }
      }
      return storage;
    }
}
