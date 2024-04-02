
import java.util.*;
import java.util.Scanner;

public class main {
    public static void main(String[] args) {
        //Problema 3: Realizar un programa que obtenga el valor del digito verificador de una cantidad
        Scanner entrada = new Scanner(System.in);
        System.out.println("Ingresa una cantidad: ");
        String cantidad = entrada.nextLine();
        System.out.println("El digito verificador de la cantidad es: " + digitoVerificador(cantidad));
    }

    public static int digitoVerificador(String cantidad){
        //se asigna un número de peso de derecha a izquierda, los pesos son 2 y 1se re
    
        int suma  = 0;
       //si la cadena es par, entronces empieza 1,2,1,2
        if(cantidad.length()%2 == 0){
          //recorremos el string 
          int peso = 1;
          for(int i = 0; i < cantidad.length(); i++){
              if(peso ==1){
                //multiplicamos el peso por el numero en la posicion i, si da un numero mayor a 9, se suman los digitos
                if(Integer.parseInt(cantidad.substring(i, i+1)) * peso > 9){
                    suma += Integer.parseInt(cantidad.substring(i, i+1)) * peso - 9;
                    peso++;
                }else{
                    suma += Integer.parseInt(cantidad.substring(i, i+1)) * peso;
                    peso++;
                }
              }else{
                //multiplicamos el peso por el numero en la posicion i, si da un numero mayor a 9, se suman los digitos
                if(Integer.parseInt(cantidad.substring(i, i+1)) * peso > 9){
                    suma += Integer.parseInt(cantidad.substring(i, i+1)) * peso - 9;
                    peso--;
                }else{
                    suma += Integer.parseInt(cantidad.substring(i, i+1)) * peso;
                    peso--;
                }
              }
          }
        }else{
           //recorremos el string 
           int peso = 2;
            for(int i = 0; i < cantidad.length(); i++){
                 if(peso ==2){

                    //multiplicamos el peso por el numero en la posicion i, si da un numero mayor a 9, se suman los digitos
                if(Integer.parseInt(cantidad.substring(i, i+1)) * peso > 9){
                        suma += Integer.parseInt(cantidad.substring(i, i+1)) * peso - 9;
                        peso--;
                  }else{
                    suma += Integer.parseInt(cantidad.substring(i, i+1)) * peso;
                    peso--;
                  }

                 }else{
                    //multiplicamos el peso por el numero en la posicion i, si da un numero mayor a 9, se suman los digitos
                    if(Integer.parseInt(cantidad.substring(i, i+1)) * peso > 9){
                        suma += Integer.parseInt(cantidad.substring(i, i+1)) * peso - 9;
                        peso++;
                    }else{
                        suma += Integer.parseInt(cantidad.substring(i, i+1)) * peso;
                        peso++;
                    }
             }
        }
          }
         System.out.println("suma: " + suma);

        //se obtiene el residuo de la suma entre 10, a esto se le resta 10
        return 10 - ((int) suma % 10);
         }
    }
    


