import java.util.*;
import java.util.Scanner;
public class main{
    public static void main(String[] args) {
     //Problema 1: Realizar un programa en java que identifique si un texto es palíndromo o no. 
     Scanner entrada = new Scanner(System.in);
     System.out.println("Ingresa una cadena a evaluar: ");
     String palabra = entrada.nextLine();
        if(esPalindromo(palabra)){
            System.out.println("La palabra es palindromo");
        }else{
            System.out.println("La palabra no es palindromo");
        }

    }

    public static boolean esPalindromo(String palabra){
       //Primero eliminamos los espacios en blanco
       palabra = palabra.replace(" ", "");
       //Convertimos la palabra a minusculas
       palabra = palabra.toLowerCase();
       //Creamos un vector de caracteres
       char[] letras = palabra.toCharArray();
       //Creamos un vector de caracteres auxiliar
       char[] letrasAux = new char[letras.length];
       //Recorremos el vector de letras y lo invertimos
       for(int i = 0; i < letras.length; i++){
           letrasAux[i] = letras[letras.length - 1 - i];
       }
       //convertimos el vector de letras invertido a un string
       String palabraInvertida = new String(letrasAux);
       //Comparamos si la palabra original es igual a la palabra invertida
         if(!palabra.equals(palabraInvertida)){
              return false;
         }
       return true;
    }
    
}