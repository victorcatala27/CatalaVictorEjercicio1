import java.util.Scanner;
import java.util.Random;

public class CatalaVictorEjercicio1 {
    public static void main(String[] args) {
        Scanner input= new Scanner(System.in);
        Random random= new Random();
        int columnas=0;
        int filas=0;
        boolean valorValidoFilas=false;
        boolean valorValidoColumnas=false;                              //Declaración e Inicialización de las variables

        System.out.println("Por favor, inserta el número de filas");
        while(!valorValidoFilas){                                       //Bucle para controlar valores compatibles con el programa
            if(input.hasNextInt()){
                filas= input.nextInt();
                valorValidoFilas=true;
            }else {
                System.out.println("Valor incorrecto. Por favor, introduce un número entero");
                input.nextLine();
            }
        }
        System.out.println("Por favor, introduce el número de columnas");
        while(!valorValidoColumnas){
            if(input.hasNextInt(){
                columnas= input.nextInt();
                valorValidoColumnas=true;
            }else{
                System.out.println("Valor incorrecto. Por favor, introduce un número entero");
                input.nextLine();
            }
        }
    }
}