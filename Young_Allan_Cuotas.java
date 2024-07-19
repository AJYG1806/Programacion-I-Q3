/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author allan
 */
import java.util.Scanner;
public class Young_Allan_Cuotas {
    public static void main(String[] args) {
        Scanner lea=new Scanner(System.in);
        System.out.println("Ingrese el valor del prestamo: ");
        double prestamo=lea.nextInt();
        System.out.println("Ingrese el plazo a pagar en meses: ");
        int plazo=lea.nextInt();
        System.out.println("Ingrese el interes mensual: ");
        double interes=lea.nextDouble()/100;
        System.out.println("Ingrese la comision: ");
        double comision=lea.nextInt();
        System.out.println("Ingrese el seguro mensual: ");
        double seguro=lea.nextDouble()/100;
        double cuotaMensual=prestamo*interes+comision+(prestamo*seguro);
        double pago= cuotaMensual*plazo;
        System.out.println("*****CUOTAS MENSUALES*****"+
                           "\nCuota de Pago Mensual: Lps."+cuotaMensual+
                           "\nTotal a Pagar: Lps."+pago);
        
    }
    
}
