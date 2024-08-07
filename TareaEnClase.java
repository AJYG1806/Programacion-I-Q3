
import java.util.Scanner;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author allan
 */
public class TareaEnClase {
    public static void main(String[] args) {
        Scanner lea=new Scanner(System.in);
        boolean menu=true;
        while(menu){
            System.out.println("*****MENU PRINCIPAL*****");
            System.out.println("1. Area De Triangulo");
            System.out.println("2. MCM y MCD");
            System.out.println("3. Numero Perfecto");
            System.out.println("4. Salir");
            System.out.println("Elija una oopcion: ");
            int opcion=lea.nextInt();
            switch(opcion){
                case 1:
                    System.out.println("*****AREA TRIANGULO****");
                    double areaMayor=0;
                    double area=0;
                    for(int i=1;i<=8;i++){
                        System.out.println("Altura de triangulo#"+i+": ");
                        int altura=lea.nextInt();
                        System.out.println("Base de tringulo#"+i+": ");
                        int base=lea.nextInt();
                        area=(altura*base)/2;
                        System.out.println("El area del tringulo#"+i+": "+area);
                        
                        }
                    break;
                case 2:
                    System.out.println("*****MCM Y MCD*****");
                    System.out.println("Ingrese el primer numero: ");
                    int num1=lea.nextInt();
                    System.out.println("Ingrese el segundo numero: ");
                    int num2=lea.nextInt();
                    int mcd=0;
                    int mcm=0;
                    for(int i=1;i<num1;i++){
                        if(num1%i==0 && num2%i==0){
                         mcd=i;   
                        }
                    }
                    System.out.println("MDC de "+num1+" y "+num2+" es: "+mcd);
                    for(int j=num1*num2;j>=num1;j--){
                        if(j%num1==0 && j%num2==0){
                            mcm=j;
                        }
                    }
                    System.out.println("MCM de "+num1+" y "+num2+" es: "+mcm);
                    break;
                case 3:
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
                        System.out.println("Es Perfecto");
                    }else{
                        System.out.println("No es Perfecto");
                    }
                    break;
                case 4:
                    menu=false;
                    System.out.println("hasta pronto");
                    break;
                    
                    }
            }
        }
        
    }
    

