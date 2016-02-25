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
        int j = 0;
        int clase = 0;
        int ventanilla_pasillo = 0;
        int vent_pasi_cent = 0;
        int respuesta = 0;
        String pasajeroEjecutivo[][] = new String[2][4];
        String pasajeroEconomico[][] = new String[7][6];
        int pasajeroEjecCedula[][] = new int[2][4];
        int pasajeroEconCedula[][] = new int[7][6];
        
        java.util.Scanner VenPas = new java.util.Scanner(System.in);
        java.util.Scanner pregunta = new java.util.Scanner(System.in);
        java.util.Scanner pasEjec = new java.util.Scanner(System.in);
        java.util.Scanner pasEcon = new java.util.Scanner(System.in);
        java.util.Scanner pasEjecCed = new java.util.Scanner(System.in);
        java.util.Scanner pasEconCed = new java.util.Scanner(System.in);
        java.util.Scanner elegir = new java.util.Scanner(System.in);
        
        System.out.println("Que clase desea? (Ejecutiva(1)/Economica(2))");
        clase = elegir.nextInt();
        
        if (clase == 1){
            
            System.out.println("Qué posición desea? (Ventanilla(1)/Pasillo(2))");
            ventanilla_pasillo = VenPas.nextInt();
            
            if (ventanilla_pasillo == 1){
                for (i = 0; i <= 1; i++){
                    if (pasajeroEjecutivo[i][j] == null && pasajeroEjecCedula[i][j] == 0 ){
                        System.out.println("Ingrese el nombre del pasajero");
                        pasajeroEjecutivo[i][j] = pasEjec.nextLine();
                        System.out.println("Ingrese el numero de Cedula del pasajero");
                        pasajeroEjecCedula[i][j] = pasEjecCed.nextInt();
                        System.out.println("¿Desea Agregar otro pasajero a esta clase? (si(1)/no(0))");
                        respuesta = pregunta.nextInt(); //Colocar condicional para informar que ya esta lleno los cupos
                        if (respuesta == 1 && pasajeroEjecutivo[i+1][j] == null){
                        }else if (respuesta == 0){
                            break;
                        }
                    }
                }
                if (i > 1){
                    j += 1;
                    i = 0;
                    }
            }
            else if (ventanilla_pasillo == 2){
                j = 1;
                for (i = 0; i <= 1; i++){
                    if (pasajeroEjecutivo[i][j] == null && pasajeroEjecCedula[i][j] == 0){
                        System.out.println("Ingrese el nombre del pasajero");
                        pasajeroEjecutivo[i][j] = pasEjec.nextLine();
                        System.out.println("Ingrese el numero de Cedula del pasajero");
                        pasajeroEjecCedula[i][j] = pasEjecCed.nextInt();
                    }
                }
                if (i > 1){
                        j += 1;
                }
                
            }
        }
        else if (clase == 2){
            
            System.out.println("Qué posición desea?(Ventanilla(1)/Centro(2)/Pasillo(3))");
            vent_pasi_cent = VenPas.nextInt();
            
        }
    } 
    
}
