package laboratorio.i;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author User
 */
public class Aerolinea {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        int comando = 0;
        java.util.Scanner numero = new java.util.Scanner(System.in);
        
        while (comando <= 2){
        do {
            System.out.println("1-Inscribir Pasajero");
            System.out.println("2-Sistema de Reportes");
            comando = numero.nextInt(); 
        }while (comando > 2 && comando != 0);
        
        if (comando == 1){
           inscribirPasajero();
        }else if (comando == 2) {
            
        }
        }
    }
       
    public static void inscribirPasajero(){
        int i = 0; 
        int j1 = 0, j2 = 0, j3 = 0;
        int clase = 0;
        int sillaEjecutiva = 0;
        int ventanilla_pasillo = 0;
        String pasajeroEjecutivoVentanillaIzq[] = new String[2];
        String pasajeroEjecutivoVentanillaDer[] = new String[2];
        String pasajeroEjecutivoPasilloIzq[]    = new String[2];
        String pasajeroEjecutivoPasilloDer[]    = new String[2];
        String pasajeroEconomicoVentanillaIzq[] = new String[7];
        String pasajeroEconomicoVentanillaDer[] = new String[7];
        String pasajeroEconomicoCentroIzq[]     = new String[7];
        String pasajeroEconomicoCentroDer[]     = new String[7];
        String pasajeroEconomicoPasilloIzq[]    = new String[7];
        String pasajeroEconomicoPasilloDer[]    = new String[7];
        int pasajeroEjVenIzqCedula[] = new int[2];
        int pasajeroEjVenDerCedula[] = new int[2];
        int pasajeroEjPasIzqCedula[] = new int[2];
        int pasajeroEjPasDerCedula[] = new int[2];
        int pasajeroEcVenIzqCedula[] = new int[7];
        int pasajeroEcVenDerCedula[] = new int[7];
        int pasajeroEcCenIzqCedula[] = new int[7];
        int pasajeroEcCenDerCedula[] = new int[7];
        int pasajeroEcPasIzqCedula[] = new int[7];
        int pasajeroEcPasDerCedula[] = new int[7];
        final int SillasClaseEjecutiva = 8;
        final int SillasClaseEconomica = 42;
        
        java.util.Scanner elegir = new java.util.Scanner(System.in);
        System.out.println("Que clase desea? (Ejecutiva(1)/Economica(2))");
        clase = elegir.nextInt();
        
        if (clase == 1){
            java.util.Scanner posicion = new java.util.Scanner(System.in);
            java.util.Scanner VenPas = new java.util.Scanner(System.in);
            java.util.Scanner EjVenIzq = new java.util.Scanner(System.in);
            java.util.Scanner EjVenIzqCed = new java.util.Scanner(System.in);
            System.out.println("Qué posición desea? (Ventanilla(1)/Pasillo(2))");
            ventanilla_pasillo = VenPas.nextInt();
                if (ventanilla_pasillo == 1){
                    System.out.println("*Vetanilla Sillas(1,5,4,8)  ");
                    sillaEjecutiva = posicion.nextInt();
            
                    if (sillaEjecutiva == 1 || sillaEjecutiva == 5){
                        for (i = 0; j1 <= 1; i++){
                            if (pasajeroEjecutivoVentanillaIzq[j1] == null && pasajeroEjVenIzqCedula[j1] == 0){
                                System.out.println("Ingrese el nombre del pasajero");
                                pasajeroEjecutivoVentanillaIzq[j1] = EjVenIzq.nextLine();
                                System.out.println("Ingrese el numero de Cedula del Pasajero");
                                pasajeroEjVenIzqCedula[j1] = EjVenIzqCed.nextInt();
                                j1 += 1;
                        }
                    }
                }
                }else if (ventanilla_pasillo == 2){
                    System.out.println("*Pasillo Sillas(2,6,3,7)");
                }
            
             
            
        }
        
    }
    
    
    
}
