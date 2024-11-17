import java.util.Scanner;
import java.util.Random;

class CatalaVictorEjercicio1 {
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

                if(filas>0){
                    valorValidoFilas=true;
                }else{
                    System.out.println("Error. Por favor, introduce un número entero positivo");
                }
            }else {
                System.out.println("Valor incorrecto. Por favor, introduce un número entero positivo");
                input.nextLine();
            }
        }
        System.out.println("Por favor, introduce el número de columnas");
        while(!valorValidoColumnas){
            if(input.hasNextInt()){
                columnas= input.nextInt();
                if(columnas>0){
                    valorValidoColumnas=true;
                }else{
                    System.out.println("Error. Por favor, introduce un número entero positivo");
                }
            }else{
                System.out.println("Valor incorrecto. Por favor, introduce un número entero poisitivo");
                input.nextLine();
            }
        }
        System.out.println("Número de columnas:" +columnas+" "+ "y filas:" +filas+" " +"fueron ingresados correctamente.\n");

        int[][] matriz= new int[filas][columnas];                       //Sentencia para crear la matriz con los datos introducidos

        for(int i=0;i<filas;i++){
            for(int j=0;j<filas;j++ ){
                matriz[i][j]= random.nextInt(9)+1;
            }
        }
        boolean salirDelPrograma=false;
        while(!salirDelPrograma){
            System.out.println("A continuación, selecciona una opción\n");
            System.out.println("Pulsa (1) para ver la Matriz generada a partir de los valores introducidos");
            System.out.println("Pulsa (2) para colocar una bomba");
            System.out.println("Pulsa (0) para salir del programa");

            while(!input.hasNextInt()){
                System.out.println("Opción no válida. Por favor, introduce una de las opciones en pantalla");
                input.next();
            }
            int opcion= input.nextInt();

            switch(opcion){                                           //Sentencia para ejecutar las acciones del menu
                case 1:
                    System.out.println("La matriz generada es:");
                    for(int i=0;i<filas;i++){
                        for(int j=0; j<columnas;j++){
                            System.out.print(matriz [i][j]+ "\t");
                        }
                        System.out.println();
                    }
                    break;
                case 2:

                    int indiceFila;
                    System.out.println("Introduce el índice de la fila (de 0 a "+(filas-1)+"):");
                    while (true) {
                        if (input.hasNextInt()) { // Verifica si el valor ingresado es un entero
                            indiceFila = input.nextInt();
                            if (indiceFila >= 0 && indiceFila < filas) { // Verifica si el valor está en el rango permitido
                                break; // Sal del bucle si el valor es válido
                            }
                        }else{
                                input.next(); // Limpiar la entrada no válida
                        }
                            System.out.println("Índice de fila erróneo. Por favor, introduce un valor entre 0 y " + (filas - 1) + ":");

                    }
                    int indiceColumna;
                    System.out.println("Introduce el índice de la columna (de 0 a "+(columnas-1)+"):");

                    while (true) {
                        if (input.hasNextInt()) { // Verifica si el valor ingresado es un entero
                            indiceColumna = input.nextInt();
                            if (indiceColumna >= 0 && indiceColumna < columnas) { // Verifica si el valor está en el rango permitido
                                break;
                            }
                        }else{
                            input.next(); // Limpiar la entrada no válida
                        }
                        System.out.println("Índice de fila erróneo. Por favor, introduce un valor entre 0 y " + (filas - 1) + ":");
                    }

                    if(indiceFila>=0 && indiceFila<filas && indiceColumna>=0 && indiceColumna<columnas){
                        int sumaBomba=0;
                        for (int j=0;j<columnas;j++){
                            sumaBomba+= matriz[indiceFila][j];
                            matriz[indiceFila][j]=0;
                        }
                        for(int i=0; i<filas; i++) {                           //Sentencia para igualar valores de la matriz a 0
                            sumaBomba+=matriz[i][indiceColumna];
                            matriz [i][indiceColumna]=0;
                        }
                        sumaBomba-=matriz[indiceFila][indiceColumna];

                        System.out.println(("El valor de la explosión es:" +sumaBomba));
                        System.out.println();

                        boolean matrizVacia=true;
                        for(int i=0; i<filas;i++){
                            for(int j=0;j<columnas;j++){
                                if(matriz [i][j]!=0){
                                    matrizVacia=false;
                                    break;
                                }
                            }
                            if(!matrizVacia) break;
                        }

                        if(matrizVacia){
                            System.out.println("La matriz está completamente vacía. Saliendo del programa...");
                            salirDelPrograma=true;
                        }
                    }else{
                        System.out.println("Índice de columna erróneo. Por favor, introduce un valor entre 0 y " + (columnas - 1) + ":\n");
                    }
                    break;

                case 0:
                    salirDelPrograma=true;
                    System.out.println("Saliendo del programa...");




            }
        }
    }
}