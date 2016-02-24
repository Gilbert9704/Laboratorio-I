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
        int clase = 0;
        final int SillasClaseEjecutiva = 8;
        final int SillasClaseEconomica = 42;
        
        java.util.Scanner elegir = new java.util.Scanner(System.in);
        System.out.println("Que clase desea? (Economica(1)/Ejecutiva(2))");
        clase = elegir.nextInt();
        
        
    }
    
    
    
}
