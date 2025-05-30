package com.mycompany.proyectosemana7;

import java.util.Scanner;
import java.util.ArrayList;

public class PROYECTOSEMANA7 {
    private static ArrayList<String> asientosReservados = new ArrayList<>();
    private static ArrayList<String> asientosDisponibles = new ArrayList<>();
    
    private static void completarasientos(){
        for (int i = 1; i < 21; i++) {
            asientosDisponibles.add("A" + i);
            asientosDisponibles.add("B" + i);
            asientosDisponibles.add("C" + i);
            asientosDisponibles.add("D" + i);
        }
    }
    
    private static void mostrarDisponibilidad(){
        System.out.println("... ASIENTOS DISPONIBLES ...");
        
        if(asientosDisponibles.isEmpty()){
            System.out.println("No hay asiento disponibles");
        }else{
            for (int i = 1; i <= 20; i++) {
                String fila = "";
                
                for(char letra = 'A'; letra <= 'D'; letra++){
                    String asiento = letra + String.valueOf(i);
                    
                    if(asientosDisponibles.contains(asiento)){
                        fila += asiento + " - ";
                    }else{
                        fila += "XX - ";
                    }
                }
                
                if (fila.endsWith(" - ")){
                    fila = fila.substring(0, fila.length() - 3);
                }
                System.out.println(fila);
                
            }
        }
    }
    static int valorVip = 30000;
    static int valorCancha = 18000;
    static int valorBalcon = 12000;
    static double valorSinDescuento;
    static double valorFinal;
    static int cantidadEntradas = 0;
    static String terceraEdad;
    static String estudiante;
    static String ubicacionFinal;
    static String tipoDescuento = "Sin descuento";

    public static void main(String[] args) { 
        
        Scanner sc = new Scanner(System.in);
        
        completarasientos();
        
        int variable = -1;
        
        while (variable != 0){
            System.out.println("---------MENÚ---------");
            System.out.println("1.-Reservar entrada");
            System.out.println("2.- Comprar entrada");
            System.out.println("3.- Generar boleta");
            System.out.println("4.- Salir");

            System.out.println("Ingresa el numero de una opcion");
            int opcion = sc.nextInt();
            sc.nextLine();

            if (opcion < 1 || opcion > 4){
                System.out.println("ERROR. INGRESE CORRECTAMENTE EL NUMERO");
                continue;
            }
            switch (opcion) {
                case 1:
                    System.out.println("1.- Vip");
                    System.out.println("2.- Cancha");
                    System.out.println("3.- Balcon");
                    
                    System.out.println("Ingrese el numero de opcion seleccionado:");
                    int ubicacionSel = sc.nextInt();
                    sc.nextLine();
                    
                    if(ubicacionSel < 1 || ubicacionSel > 3){
                        System.out.println("ERROR. Ingrese numero correcto");
                        continue;
                    }
                    
                    switch (ubicacionSel) {
                        case 1:
                            valorSinDescuento += valorVip;
                            ubicacionFinal = "VIP";
                            
                            System.out.println("El valor de la entrada selecionada es " + valorSinDescuento);
                            break;
                        case 2:
                            valorSinDescuento += valorCancha;                           
                            ubicacionFinal = "Cancha";
                            System.out.println("El valor de la entrada selecionada es " + valorSinDescuento);
                            break;
                        case 3:
                            valorSinDescuento += valorBalcon;                           
                            ubicacionFinal = "Balcon";
                            System.out.println("El valor de la entrada selecionada es " + valorSinDescuento);
                            break;
                    }
                    
                    mostrarDisponibilidad();
                    
                    String asientoSel;
                    
                    System.out.println("Ingrese el asiento que quiere seleccionar");
                    asientoSel = sc.nextLine().toUpperCase();                 
                    if (asientosDisponibles.contains(asientoSel)) {
                         asientosReservados.add(asientoSel);
                         asientosDisponibles.remove(asientoSel); 
                         System.out.println("Asiento correctamente reservado: " + asientoSel);
                     } else {
                         System.out.println("Asiento no disponible o inexistente.");
                     }
                    cantidadEntradas++;
                    
                    
                    break;
                    
                case 2:                    
                    tipoDescuento = "";
                    valorFinal = valorSinDescuento;
                    System.out.println("Ingrese su edad:");
                    int edad = sc.nextInt();
                    

                    System.out.println("¿Es estudiante?");
                    System.out.println("1.- Si");
                    System.out.println("2.- No");
                    int estudiante = sc.nextInt();  
                    
                    
                    if(estudiante < 1 || estudiante > 2){
                        System.out.println("ERROR. Opcion incorrecta");
                        continue;
                    }
                    
                    if(edad >60){
                        valorFinal = valorFinal * 0.9;
                        tipoDescuento += "10% por edad";
                        
                    }
                    
                    if (estudiante == 1){
                        valorFinal = valorFinal * 0.85;
                        if (!tipoDescuento.isEmpty()) {
                            tipoDescuento += " + ";
                        }
                        tipoDescuento += "15% por estudiante";
                    }

                    break;
                    
                case 3:
                    
                    System.out.println("-------------------------");
                    System.out.println("   BOLETA TEATRO MORO    ");
                    System.out.println("-------------------------");
                    
                    System.out.println("Ubicación: "+ ubicacionFinal);
                    System.out.println("Asientos seleccionados: ");
                    for (String boleto: asientosReservados){
                        System.out.println(boleto);
                    }
                    System.out.println("Costo base: " + valorSinDescuento);
                    System.out.println("Descuentos aplicados: " + tipoDescuento);
                    System.out.println("Costo final: " + valorFinal);
                           
                    break;
                    
                case 4:
                    System.out.println("¡HASTA LUEGO!");
                    System.exit(0);                    
                    break;                   
                    
            }
            
            
        
        }
                
    }
}
