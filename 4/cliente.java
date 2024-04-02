import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.nio.ByteBuffer;

public class cliente{

    static void read(DataInputStream f, byte[] b, int posicion, int longitud) throws IOException {
        while(longitud > 0) {
             int n = f.read(b, posicion, longitud);
             posicion += n;
             longitud -= n;
         }
     }
     
    public static void main(String[] args) throws IOException, InterruptedException {
      //Creamos un socket cliente que se conectara al servidor
      Socket conexion = null;
       for(;;){
        try{
            conexion = new Socket("localhost",5000);
            break;
          }catch(Exception e){
            System.out.println("Error al conectar con el servidor, reintentando en 100ms");
            Thread.sleep(100);
          }
       }
       //Creamos un stream de salida y un stream de entrada
       DataOutputStream salida = new DataOutputStream(conexion.getOutputStream());
       DataInputStream entrada = new DataInputStream(conexion.getInputStream());
         
       

       //recibimos la cadena del servidor hola mundo
        byte[] buffer = new byte[11];
        entrada.read(buffer,0,11);
        System.out.println(new String(buffer,"UTF-8"));

       
        //enviamos una cadena al servidor de hola mundo
        salida.write("Hola mundo".getBytes("UTF-8"));

        
            // cerramos la conexión
            Thread.sleep(1000);
            conexion.close();
        
        }

}