
import java.util.Scanner;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author allan
 */
public class Young_Allan_EjerciciosLab2 {
    public static void main(String[] args) {
        Scanner lea=new Scanner(System.in);
        while(true){
            System.out.println("*****MENU PRINCIPAL*****");
            System.out.println("1. Cadena de caracteres");
            System.out.println("2. Notas");
            System.out.println("3. Clases");
            System.out.println("Ingrese una opcion: ");
            int opcion=lea.nextInt();
            
            switch(opcion){
                case 1:
                    System.out.println("*****CADENA DE CARACTERES*****");
                    System.out.print("Ingrese una cadena: ");
                    String cadena=lea.nextLine();
                    char caracterMasRepetido='\0'; 
                    int cantidadMasRepetido=0;
                    int contar=0;
                    while(contar<cadena.length()) {
                        char caracterActual = cadena.charAt(contar);
                        int cantidadActual = 0;
                        int indice=cadena.indexOf(caracterActual);
                        while(indice!=-1) {
                            cantidadActual++;
                            indice=cadena.indexOf(caracterActual, indice+1);
            }
                        if(cantidadActual>cantidadMasRepetido) {
                         caracterMasRepetido=caracterActual;
                         cantidadMasRepetido=cantidadActual;
            }
            contar++;
        }
        System.out.println("El carácter más repetido es '" + caracterMasRepetido + "' con " + cantidadMasRepetido + " repeticiones.");
             break;
                case 2:
                    System.out.println("*****NOTAS*****");
                    System.out.println("Ingrese la cantidad de notas a evaluar: ");
                    int cantNotas=lea.nextInt();
                    int count=0;
                    double sumaNotas=0;
                    double notaMayor=0;
                    double notaMenor=100;
                    double notas;
                    while(count<cantNotas){
                        count++;
                        System.out.println("Nota #"+count+": ");
                        notas=lea.nextDouble();
                        if(notas<0 || notas>100){
                        }
                        sumaNotas+=notas;
                        if(notas>notaMayor){
                            notaMayor=notas;
                        }else if(notas<notaMenor){
                            notaMenor=notas;
                        }
                    }
                    double promedio=sumaNotas/cantNotas;
                    System.out.printf("Promedio: %.2f\n", promedio);
                    System.out.println("Nota mayor: "+notaMayor);
                    System.out.println("Nota Menor: "+notaMenor);
                    
        
    }
            }
        }
        
    }
    

