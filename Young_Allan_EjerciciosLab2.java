
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
            System.out.println("4. Salir");
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
                    break;
                case 3:
                    System.out.println("*****CLASES*****");
                    System.out.println("Ingrese la fecha actual en formato \"día, DD/MM\":");
                    String fecha=lea.nextLine();
                    fecha=fecha.trim();
                    int commaIndex=fecha.indexOf(',');
                    if(commaIndex==-1 || fecha.length()<commaIndex+6){
                        System.out.println("Error: formato de fecha incorrecto");
                    return;
                    }
                    String diaSemana=fecha.substring(0, commaIndex).toLowerCase();
                    String fechaNumerica=fecha.substring(commaIndex + 2); 
                    int slashIndex=fechaNumerica.indexOf('/');
                    if(slashIndex==-1 || fechaNumerica.length()<slashIndex+3){
                        System.out.println("Error: formato de fecha incorrecto");
                    return;
                    }
                    String diaStr=fechaNumerica.substring(0, slashIndex);
                    String mesStr=fechaNumerica.substring(slashIndex + 1);
                    int dia, mes;
                    try{
                        dia=Integer.parseInt(diaStr);
                        mes=Integer.parseInt(mesStr);
                    }catch(NumberFormatException e){
                    System.out.println("Error: formato de fecha incorrecto");
                    return;
                    }
                    if(dia<1 || dia>31 || mes<1 || mes>12){
                        System.out.println("Error: formato de fecha incorrecto");
                    return;
                    }
                    if(diaSemana.equals("lunes")){
                        System.out.println("¿Se tomaron exámenes? (si/no)");
                        String respuesta=lea.nextLine().trim().toLowerCase();
                    if(respuesta.equals("si")){
                        System.out.println("Ingrese la cantidad de alumnos que aprobaron:");
                        int aprobados=lea.nextInt();
                        System.out.println("Ingrese la cantidad de alumnos que no aprobaron:");
                        int noAprobados=lea.nextInt();
                        int total=aprobados+noAprobados;
                        if (total==0){
                    System.out.println("No se ingresaron datos válidos.");
                }else{
                    double porcentajeAprobados=(aprobados/(double)total)*100;
                    System.out.println("Porcentaje de aprobados: "+porcentajeAprobados+"%");
                }
            }
                }else if(diaSemana.equals("martes")){
                    System.out.println("¿Se tomaron exámenes? (si/no)");
                    String respuesta=lea.nextLine().trim().toLowerCase();
                if(respuesta.equals("si")) {
                    System.out.println("Ingrese la cantidad de alumnos que aprobaron:");
                    int aprobados=lea.nextInt();
                    System.out.println("Ingrese la cantidad de alumnos que no aprobaron:");
                    int noAprobados=lea.nextInt();
                    int total=aprobados+noAprobados;
                    if(total==0){
                    System.out.println("No se ingresaron datos válidos.");
                }else{
                    double porcentajeAprobados=(aprobados/(double)total)*100;
                    System.out.println("Porcentaje de aprobados: "+porcentajeAprobados+"%");
                }
            }
        }else if(diaSemana.equals("miércoles")){
            System.out.println("¿Se tomaron exámenes? (si/no)");
            String respuesta=lea.nextLine().trim().toLowerCase();
            if(respuesta.equals("si")){
                System.out.println("Ingrese la cantidad de alumnos que aprobaron:");
                int aprobados=lea.nextInt();
                System.out.println("Ingrese la cantidad de alumnos que no aprobaron:");
                int noAprobados=lea.nextInt();
                int total=aprobados+noAprobados;
                if(total==0){
                    System.out.println("No se ingresaron datos válidos.");
                }else{
                    double porcentajeAprobados=(aprobados/(double)total)*100;
                    System.out.println("Porcentaje de aprobados: "+ porcentajeAprobados+"%");
                }
            }
        }else if(diaSemana.equals("jueves")){
            System.out.println("Ingrese el porcentaje de asistencia a clase:");
            double porcentajeAsistencia=lea.nextDouble();
            if(porcentajeAsistencia>50){
                System.out.println("Asistió la mayoría");
            }else{
                System.out.println("No asistió la mayoría");
            }
        }else if(diaSemana.equals("viernes")){
            if(dia == 1 && (mes==1 || mes==7)){
                System.out.println("Comienzo de nuevo ciclo");
                System.out.println("Ingrese la cantidad de alumnos del nuevo ciclo:");
                int cantidadAlumnos=lea.nextInt();
                System.out.println("Ingrese el precio en $ por cada alumno:");
                double precioPorAlumno=lea.nextDouble();
                double ingresoTotal=cantidadAlumnos*precioPorAlumno;
                System.out.println("Ingreso total en $: "+ingresoTotal);
            }
        }else{
            System.out.println("Error: día de la semana incorrecto");
        }
        
    }
}
                    
                    
        
    }
            }
        
        
    
    

