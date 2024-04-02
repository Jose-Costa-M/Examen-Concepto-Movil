import java.net.Socket;
import java.nio.ByteBuffer;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;

public class servidor {

    static void read(DataInputStream f, byte[] b, int posicion, int longitud) throws IOException {
        while(longitud > 0) {
             int n = f.read(b, posicion, longitud);
             posicion += n;
             longitud -= n;
         }
     }
    public static void main(String[] args) throws IOException {
       //Creamos un socket servidor que abrira el puerto 5000 del cliente
       ServerSocket servidor = new ServerSocket(5000);
       //Creamos un socket cliente que se conectara al servidor   
       Socket conexion = servidor.accept();

       //Creamos un stream de salida y un stream de entrada
       DataOutputStream salida = new DataOutputStream(conexion.getOutputStream());
       DataInputStream entrada = new DataInputStream(conexion.getInputStream());
    
    
        //Envia una cadena Hola Mundo
        salida.write("Hola mundo".getBytes("UTF-8"));
        
        //recibimos la cadena del cliente
        byte[] buffer = new byte[11];
        entrada.read(buffer,0,11);
        System.out.println(new String(buffer,"UTF-8"));
         // cerramos la conexión
        conexion.close();   
   
     }

}
