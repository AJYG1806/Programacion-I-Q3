
import java.util.Random;
import java.util.Scanner;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author allan
 */
public class Young_Allan_Lab3 {
    public static void main(String[] args) {
        Scanner lea=new Scanner(System.in).useDelimiter("\n");
        Random rnd=new Random();
        boolean menu=true;
        while(menu){
            System.out.println("*****MENU PRINCIPAL*****");
            System.out.println("1. Piedra, Papel o Tijera");
            System.out.println("2. Suma De Numeros");
            System.out.println("3. Piramide De Numeros");
            System.out.println("4. Salir");
            System.out.println("Elija una opcion: ");
            int opcion=lea.nextInt();
            switch(opcion){
                case 1:
                    boolean jugarOtraVez=true;
                    while(jugarOtraVez){
                        System.out.println("*****PIEDRA, PAPEL O TIJERA*****");
                        int seleccionPC=(int)(Math.random()*3)+1;
                        System.out.println("La Computadora ya escogio: ");
                        System.out.println("Elija su opcion 1=Piedra, 2=Papel, 3=Tijera: ");
                        int seleccionPersona=lea.nextInt();
                        System.out.println("La computadora escogio: ");
                        switch(seleccionPC){
                            case 1:
                                System.out.println("Piedra");
                                switch(seleccionPersona){
                                    case 1:
                                        System.out.println("empate");
                                        break;
                                    case 2:
                                        System.out.println("has ganado");
                                        break;
                                    case 3:
                                        System.out.println("has perdido");
                                        break;
                                }
                                break;
                            case 2:
                                System.out.println("Papel");
                                switch(seleccionPersona){
                                    case 1:
                                        System.out.println("has perdido");
                                        break;
                                    case 2:
                                        System.out.println("empate");
                                        break;
                                    case 3:
                                        System.out.println("has ganado");
                                        break;
                        }
                                break;
                            case 3:
                                System.out.println("tijera");
                                switch(seleccionPersona){
                                    case 1:
                                        System.out.println("has ganado");
                                        break;
                                    case 2:
                                        System.out.println("has perdido");
                                        break;
                                    case 3:
                                        System.out.println("empate");
                                        break;
                    }
                                break;
            }
                        System.out.println("Quiere volver a jugar?: (s/n)");
                        char respuesta=lea.next().charAt(0);
                        if(respuesta=='n'|| respuesta=='s'){
                            jugarOtraVez=false;
                        }
        }
                    break;
                case 2:
                    System.out.println("*****SUMA*****");
                    System.out.println("Ingrese un numero: ");
                    int numero=Integer.parseInt(lea.next());
                    int suma=0;
                    String laSuma="";
                    while(numero>0){
                        int digito=numero%10;
                        suma+=digito;
                        laSuma=digito+"+"+laSuma;
                        numero/=10;
                    }
                    System.out.println("La Suma Es: "+laSuma.substring(0,laSuma.length()-3)+"="+suma);
                    break;
                case 3:
                    System.out.println("*****PIRAMIDE*****");
                    System.out.println("Ingrese la cantidad de filas: ");
                    int filas=lea.nextInt();
                    int num=0;
                    for(int i=filas;i>=1;i--){
                        for(int j=1;j<=filas-i;j++){
                            System.out.print(" ");
                        }
                        for(int k=i;k>=1;k--){
                            System.out.print(k);
                        }
                        System.out.println();
                    }
                    break;
                case 4:
                    menu=false;
                    System.out.println("Hasta Pronto");
                    break;
    }
    
}
    }
}
