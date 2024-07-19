/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author allan
 */
import java.util.Scanner;
public class Young_Allan_PlanillaDeEmpleados {
    public static void main(String[] args) {
        Scanner lea=new Scanner(System.in).useDelimiter("\n");
        System.out.println("Ingrese el nombre del Empleado: ");
        String nombreEmpleado=lea.next();
        System.out.println("Ingrese las horas trabajdas: ");
        int horasMensuales=lea.nextInt();
        System.out.println("Ingrese la tarifa por hora: ");
        double tarifaHora=lea.nextDouble();
        double salarioSemanal=(horasMensuales/4)*tarifaHora;
        System.out.println("****BOLETA DEL EMPLEADO*****"+
                           "\nNombre del Empleado: "+nombreEmpleado+
                           "\nHora de Trabajo Mensual: "+horasMensuales+
                           "\nTarifa por Hora: Lps."+tarifaHora+
                           "\nSalario del Empleado Semanal: Lps."+salarioSemanal);
        
        
        
    }
    
}
