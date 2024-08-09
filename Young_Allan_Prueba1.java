
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
public class Young_Allan_Prueba1 {
    public static void main(String[] args) {
        Scanner lea=new Scanner(System.in).useDelimiter("\n");
        Random rnd=new Random();
        boolean menu=true;
        while(menu){
            System.out.println("*****MENU PRINCIPAL*****");
            System.out.println("1. Palabra Alreves");
            System.out.println("2. Numero Perfecto");
            System.out.println("3. Numero Primos");
            System.out.println("4. Votaciones");
            System.out.println("5. salir");
            System.out.println("Elija una opcion: ");
            int opcion=lea.nextInt();
            switch(opcion){
                case 1:
                    System.out.println("*****PALABRA ALREVES*****");
                    System.out.println("Ingrese una palabra: ");
                    String palabra=lea.next();
                    String palabraAlreves="";
                    for(int i=palabra.length()-1;i>=0;i--){
                        palabraAlreves+=palabra.charAt(i);
                    }
                    System.out.println("Palabra alreves: "+palabraAlreves);
                    break;
                    
                case 2:
                    System.out.println("*****NUMERO PERFECTO*****");
                    System.out.println("Ingrese un numero: ");
                    int numero=lea.nextInt();
                    int suma=0;
                    for(int i=1;i<numero;i++){
                        if(numero%i==0){
                            suma=suma+i;
                        }
                }
                    if(suma==numero){
                        System.out.println("Es perfecto");
                    }else{
                        System.out.println("No es perfecto");
                    }
                    break;
                    
                case 3:
                    System.out.println("*****NUMEROS PRIMOS*****");
                    int num=rnd.nextInt(100)+1;
                    int cantDivisores=0;
                    String divisores="";
                    for(int i=1;i<=num;i++){
                        if(num%i==0){
                            cantDivisores++;
                            if(divisores.equals("")){
                                divisores+=i;
                            }else{
                                divisores+=" y "+i;
                            }
                        }
                    }
                    boolean primo=cantDivisores==2;
                    if(primo){
                        System.out.println("Es primo: "+num);
                    }else{
                        System.out.println("No es primo: "+num);
                    }
                    System.out.println("Divisores de "+num+" son: "+divisores);
                    break;  
                    
                case 4:
                    System.out.println("*****VOTACIONES*****");
                     System.out.println("++++Votaciones++++");
                    System.out.println("Ingrese la cantidad de votantes: ");
                    int cantidadVotantes=lea.nextInt();
                    int votosAmarillo=0;
                    int votosAzul=0;
                    int votosRojo=0;
                    int votosNegro=0;
                    int votosNulos=0;
                    int totalVotos=0;
                    for(int i=1;i<=cantidadVotantes;i++){
                        System.out.println("Ingrese el voto del votante "+ i+ " (AMARILLO/AZUL/ROJO/NEGRO): ");
                        String voto=lea.next();
                        if(voto.equalsIgnoreCase("AMARILLO")){
                            votosAmarillo++;
                            totalVotos++;
                        }else if(voto.equalsIgnoreCase("AZUL")){
                            votosAzul++;
                            totalVotos++;
                        }else if(voto.equalsIgnoreCase("ROJO")){
                            votosRojo++;
                            totalVotos++;
                        }else if(voto.equalsIgnoreCase("NEGRO")){
                            votosNegro++;
                            totalVotos++;
                        }else{
                            votosNulos++;
                            totalVotos++;
                        }
                    }
                    int votosValidos=votosAmarillo+votosAzul+votosRojo+votosNegro;
                    double porcentajeValidos=(double)votosValidos/totalVotos;
                    if(porcentajeValidos<0.6){
                        System.out.println("VOTACION CANCELADA");
                    }else{
                        String ganador;
                        if(votosAzul>votosRojo && votosAzul>votosNegro && votosAzul>votosAmarillo){
                            ganador="AZUL";
                        }else if(votosRojo>votosAzul && votosRojo>votosNegro && votosRojo>votosAmarillo){
                            ganador = "ROJO";
                        }else if(votosNegro>votosAzul && votosNegro>votosRojo && votosNegro>votosAmarillo){
                            ganador="NEGRO";
                        }else{
                            ganador="AMARILLO";
                        }
                        System.out.println("La planilla ganadora es: " + ganador);
                        System.out.println("++++Votos Por Planilla++++");
                        System.out.println("La cantidad de votantes fueron: "+cantidadVotantes);
                        System.out.println("La cantidad de votos por AMARILLO es: " + votosAmarillo);
                        System.out.println("La cantidad de votos por AZUl es: " + votosAzul);
                        System.out.println("La cantidad de votos por ROJO es: " + votosRojo);
                        System.out.println("La cantidad de votos por NEGRO es: " + votosNegro);
                    }
                    break;
                    
                case 5:
                    menu=false;
                    System.out.println("Hasta pronto");
                    break;
            }
            
            
        }
    }
    
}
