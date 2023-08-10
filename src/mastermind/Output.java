/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mastermind;

import java.io.*;

/**
 *
 * @author raulrodriguezlopez-rey
 */
public class Output {
    private FileOutputStream fileAlmacen;
    private ObjectOutputStream outputAlmacen;
    
    
    //abrir el fichero del almacen
    public void abrirAlmacen(String ruta) throws IOException{
        //String so = System.getProperty("os.name");
        //String separador = System.getProperty("file.separator");
        //String sPath = separador + "Temp" + separador +"lista.bin";

        fileAlmacen=new FileOutputStream(ruta);
        outputAlmacen =new ObjectOutputStream(fileAlmacen);
    }
    //cerrar el fichero de almacen
    
    public void cerrarAlmacen() throws IOException{
    if (outputAlmacen!=null)
        outputAlmacen.close();
    
    }
    //escribir el fichero de almacen
    public void escribirAlmacen (Almacen storage) throws IOException{
        if (outputAlmacen!=null)
            outputAlmacen.writeObject(storage);
        
    }
   
}
