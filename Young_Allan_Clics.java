/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author allan
 */
public class Young_Allan_Clics {
    public static void main(String[] args) {
        double costo60Clics = 0.30;
        double costo100Clics = 0.25;
        double costo20Clics = 0.80;
        int cantidad60Clics = 60;
        int cantidad100Clics = 100;
        int cantidad20Clics = 20;
        double totalCosto = (costo60Clics * cantidad60Clics) + 
                            (costo100Clics * cantidad100Clics) + 
                            (costo20Clics * cantidad20Clics);

        double isv = 0.16;
        double totalConISV = totalCosto * (1 + isv);
        int totalClics = cantidad60Clics + cantidad100Clics + cantidad20Clics;
        double costoPromedio = totalCosto / totalClics;
        System.out.println("Costo promedio por clic: " + String.format("%.2f", costoPromedio));
        System.out.println("Costo total con ISV: " + String.format("%.2f", totalConISV));
    }
}
    
    

