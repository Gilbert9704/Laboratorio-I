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
    static int accion = 0;
    static int clase = 0;
    static int i = 0;
    static int j = 0;
    static int k = 0;
    static int l = 0;
    static int x = 0;
    static int y = 0;
    static int ventanilla_pasillo = 0;
    static int vent_pasi_cent = 0;
    static int respuesta = 0;
    static byte cuposDispVentEjc = 3;
    static byte cuposDispPassEjc = 3;
    static byte cuposDispVentEco = 13;
    static byte cuposDispCentEco = 13;
    static byte cuposDispPassEco = 13;
    static byte contSillasOcpEjc = 0;
    static byte contSillasDispEco = 0;
    static byte buscarPasajero = 0;
    static byte asignarPasajero = 0;
    static String registroNombre = null;
    static int registroCedula = 0;
    static String pasajeroEjecutivo[][] = new String[2][4];
    static String pasajeroEconomico[][] = new String[7][6];
    static int pasajeroEjecCedula[][] = new int[2][4];
    static int pasajeroEconCedula[][] = new int[7][6];
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
           sistemadeReportes();
        }
        }
    }
       
    public static void inscribirPasajero(){
        
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
                i = 0;
                j = 0;
                while(cuposDispVentEjc >= 0){ //en ventanilla pasillo se prueba
                    
                    if (pasajeroEjecutivo[i][j] == null && pasajeroEjecCedula[i][j] == 0 ){
                        System.out.println("Ingrese el nombre del pasajero");
                        pasajeroEjecutivo[i][j] = pasEjec.nextLine();
                        System.out.println("Ingrese el numero de Cedula del pasajero");
                        pasajeroEjecCedula[i][j] = pasEjecCed.nextInt();
                        //Función para determinar si ya se encuentra algun pasajero inscrito
                        comprobarEjecutivo();

                        if (cuposDispVentEjc == 0){
                            System.out.println("Todos los asientos de esta posicion reservados");
                            break;
                        }
                        System.out.println("¿Desea Agregar otro pasajero a esta clase? (si(1)/no(0))" + " *Cupos Disponibles: " + cuposDispVentEjc);
                        respuesta = pregunta.nextInt(); //Colocar condicional para informar que ya esta lleno los cupos
                        
                        if (respuesta == 1 && pasajeroEjecutivo[i][j+1] == null){
                        }else if (respuesta == 1 && pasajeroEjecutivo[i][j+1] != null){
                            System.out.println("Todos los asientos de esta posicion se encuentran reservados");
                            break;
                        }else if (respuesta == 0){
                            break;
                        }
                    }
                    j += 1;
                    cuposDispVentEjc -= 1;
                }
                
            }
           
            else if (ventanilla_pasillo == 2){
                i = 1;
                j = 0;
                while (cuposDispPassEjc >= 0){
                    
                    if (pasajeroEjecutivo[i][j] == null && pasajeroEjecCedula[i][j] == 0){
                        System.out.println("Ingrese el nombre del pasajero");
                        pasajeroEjecutivo[i][j] = pasEjec.nextLine();
                        System.out.println("Ingrese el numero de Cedula del pasajero");
                        pasajeroEjecCedula[i][j] = pasEjecCed.nextInt();
                       //Función para determinar si ya se encuentra algun pasajero inscrito
                        comprobarEjecutivo();
                        
                        if (cuposDispPassEjc == 0){
                            System.out.println("Todos los asientos de esta posicion reservados");
                            break;
                        }
                        System.out.println("¿Desea Agregar otro pasajero a esta clase? (si(1)/no(0))" + " *Cupos Disponibles: " + cuposDispPassEjc);
                        respuesta = pregunta.nextInt();
                        
                        if (respuesta == 1 && pasajeroEjecutivo[i][j+1] == null){
                        }else if (respuesta == 1 && pasajeroEjecutivo[i][j+1] != null){
                            System.out.println("Todos los asientos de esta posicion se encuentran reservados");
                            break;
                        }else if (respuesta == 0){
                            break;
                        }
                    }
                    j += 1;
                    cuposDispPassEjc -= 1;
                        
                    }
            }
        }
        else if (clase == 2){
            
            System.out.println("Qué posición desea?(Ventanilla(1)/Centro(2)/Pasillo(3))");
            vent_pasi_cent = VenPas.nextInt();
            
            if (vent_pasi_cent == 1){
                i = 0;
                j = 0;
                while (cuposDispVentEco >= 0){
                    if (pasajeroEconomico[i][j] == null && pasajeroEconCedula[i][j] == 0){
                        System.out.println("Ingrese el nombre del pasajero");
                        pasajeroEconomico[i][j] = pasEcon.nextLine();
                        System.out.println("Ingrese el numero de Cedula del pasajero");
                        pasajeroEconCedula[i][j] = pasEconCed.nextInt();
                        //Funcion para determinar si se repite algun pasajero en la clase economica
                        comprobarEconomico();
                        
                        if (cuposDispVentEco == 0){
                            System.out.println("Todos los asientos de esta posicion reservados");
                            break;
                        }
                        System.out.println("¿Desea Agregar otro pasajero a esta clase? (si(1)/no(0))" + " *Cupos Disponibles: " + cuposDispVentEco);
                        respuesta = pregunta.nextInt();
                        
                        if (respuesta == 1 && pasajeroEconomico[i+1][j] == null){   
                        }else if (respuesta == 1 && pasajeroEconomico[i+1][j] != null){
                            System.out.println("Todos los asientos de esta posicion se encuentran reservados");
                            break;
                        }else if (respuesta == 0){
                            break;
                        }
                    }
                    if (i == 6){
                        j += 1;
                        i = 0;
                    }
                    i += 1;
                    cuposDispVentEco -= 1;
                }
            }
            else if (vent_pasi_cent == 2){
                i = 0;
                j = 2;
                while (cuposDispCentEco >= 0){
                        if (pasajeroEconomico[i][j] == null && pasajeroEconCedula[i][j] == 0){
                        System.out.println("Ingrese el nombre del pasajero");
                        pasajeroEconomico[i][j] = pasEcon.nextLine();
                        System.out.println("Ingrese el numero de Cedula del pasajero");
                        pasajeroEconCedula[i][j] = pasEconCed.nextInt();
                        //Funcion para determinar si se repite algun pasajero en la clase economica
                        comprobarEconomico();
                        
                        if (cuposDispCentEco == 0){
                            System.out.println("Todos los asientos de esta posicion reservados");
                            break;
                        }
                        System.out.println("¿Desea Agregar otro pasajero a esta clase? (si(1)/no(0))" + " *Cupos Disponibles: " + cuposDispCentEco);
                        respuesta = pregunta.nextInt();
                        
                        if (respuesta == 1 && pasajeroEconomico[i+1][j] == null){   
                        }else if (respuesta == 1 && pasajeroEconomico[i+1][j] != null){
                            System.out.println("Todos los asientos de esta posicion se encuentran reservados");
                            break;
                        }else if (respuesta == 0){
                            break;
                        }
                    }
                    if (i == 6){
                        j += 1;
                        i = 0;
                    }
                    i += 1;
                    cuposDispCentEco -= 1;
                }
            }
            else if (cuposDispPassEco >= 0){
                i = 0;
                j = 4;
                while (cuposDispPassEco >= 0){
                        if (pasajeroEconomico[i][j] == null && pasajeroEconCedula[i][j] == 0){
                        System.out.println("Ingrese el nombre del pasajero");
                        pasajeroEconomico[i][j] = pasEcon.nextLine();
                        System.out.println("Ingrese el numero de Cedula del pasajero");
                        pasajeroEconCedula[i][j] = pasEconCed.nextInt();
                        //Funcion para determinar si se repite algun pasajero en la clase economica
                        comprobarEconomico();
                        
                        if (cuposDispPassEco == 0){
                            System.out.println("Todos los asientos de esta posicion reservados");
                            break;
                        }
                        System.out.println("¿Desea Agregar otro pasajero a esta clase? (si(1)/no(0))" + " *Cupos Disponibles: " + cuposDispPassEco);
                        respuesta = pregunta.nextInt();
                        
                        if (respuesta == 1 && pasajeroEconomico[i+1][j] == null){   
                        }else if (respuesta == 1 && pasajeroEconomico[i+1][j] != null){
                            System.out.println("Todos los asientos de esta posicion se encuentran reservados");
                            break;
                        }else if (respuesta == 0){
                            break;
                        }
                    }
                    if (i == 6){
                        j += 1;
                        i = 0;
                    }
                    i += 1;
                    cuposDispPassEco -= 1;
                }
            }
            
        }
    } //Cierra el Método InscribirPasajero();
    
    public static void sistemadeReportes(){
        
        java.util.Scanner decision = new java.util.Scanner(System.in);
        java.util.Scanner asigPasaj = new java.util.Scanner(System.in);
        java.util.Scanner regNombre = new java.util.Scanner(System.in);
        java.util.Scanner regCedula = new java.util.Scanner(System.in);
        java.util.Scanner buscarPasaj = new java.util.Scanner(System.in);
        
        System.out.println("¿Qué desea? \n 1-Contar Sillas Ejecutivas Ocupadas \n 2-Localizar silla de un pasajero \n 3-Localizar silla economica disponible \n 4-Anular Reserva \n 5-Contar Numero de puestos disponibles en ventana en la clase economica");
        accion = decision.nextInt();
        
        switch (accion) {
            case 1:
                k = 0;
                l = 0;
                for (i = 0; i <= 7; i++){
                    if (pasajeroEjecutivo[k][l] == null && pasajeroEjecCedula[k][l] == 0 ){
                    }
                    else{
                        contSillasOcpEjc += 1;
                    }
                    if (l == 3) {
                        k += 1;
                        l = 0;
                    }else {
                        l += 1;
                    }
                    
                }   System.out.println("El numero de sillas ocupadas en la clase ejecutiva es: " + contSillasOcpEjc);
                break;
            case 2:
                k = 0;
                l = 0;
                System.out.println("Ingrese el nombre del pasajero a localizar");
                registroNombre = regNombre.nextLine();
                System.out.println("Ingrese el numero de cedula del pasajero");
                registroCedula = regCedula.nextInt();
                System.out.println("Elija la clase en la cual desea buscar al pasajero (Ejecutiva(1)/Economica(2))");
                buscarPasajero = buscarPasaj.nextByte();
                if (buscarPasajero == 1){
                    for (l = 0; l <= 3; l++){
                        if ((pasajeroEjecutivo[k][l] == null ? registroNombre == null : pasajeroEjecutivo[k][l].equals(registroNombre)) && pasajeroEjecCedula[k][l] == registroCedula){
                            System.out.println("La Ubicacion del pasajero es: " + k + l);
                            break;
                        }
                        if (l == 3 && k == 1){
                            System.out.println("No se encontró al pasajero en la Clase Ejecutiva");
                            break;
                        }
                        else if (l == 3){
                            k += 1;
                            l = 0;
                        }
                    }
                }
                else if (buscarPasajero == 2){
                    k = 0;
                    for (l = 0; l <= 5; l++){
                        if ((pasajeroEconomico[k][l] == null ? registroNombre == null : pasajeroEconomico[k][l].equals(registroNombre)) && pasajeroEconCedula[k][l] == registroCedula){
                            System.out.println("La Ubicación del pasajero es: " + k + l);
                            break;
                        }
                        if (l == 5 && k == 6){
                            System.out.println("No se encontró al pasajero en la Clase Económica");
                            break;
                        }
                        else if (l == 5){
                            k += 1;
                            l = 0;
                        }
                    }
                }   break;
            case 3:
                k = 0;
                l = 0;
                for (i = 0; i <= 41; i++){
                    if (pasajeroEconomico[k][l] == null && pasajeroEconCedula[k][l] == 0 ){
                        System.out.println("Se encontró disponible la silla: " + k + l + "  ¿Desea asignar un pasajero a ella? (si(1)/no(0))");
                        asignarPasajero = asigPasaj.nextByte();
                        if (asignarPasajero == 1){
                            System.out.println("Ingrese el nombre del pasajero");
                            registroNombre = regNombre.nextLine();
                            System.out.println("Ingrese el numero de cedula del pasajero");
                            registroCedula = regCedula.nextInt();
                            pasajeroEconomico[k][l] = registroNombre;
                            pasajeroEconCedula[k][l] = registroCedula;
                            break;
                        }
                        else if (asignarPasajero == 0){
                            break;
                        }
                    }
                    if (l == 5) {
                        k += 1;
                        l = 0;
                    }else {
                        l += 1;
                    }
                    
                }   break;
            case 4:
                k = 0;
                l = 0;
                System.out.println("Ingrese el nombre del pasajero a eliminar");
                registroNombre = regNombre.nextLine();
                System.out.println("Ingrese el numero de cedula del pasajero");
                registroCedula = regCedula.nextInt();
                System.out.println("Elija la clase en la cual se encuentra el pasajero (Ejecutiva(1)/Economica(2))");
                buscarPasajero = buscarPasaj.nextByte();
                if (buscarPasajero == 1){
                    k = 0;
                    for (l = 0; l <= 3; l++){
                        if ((pasajeroEjecutivo[k][l] == null ? registroNombre == null : pasajeroEjecutivo[k][l].equals(registroNombre)) && pasajeroEjecCedula[k][l] == registroCedula){
                            System.out.println("El pasajero " + registroNombre + " con Cedula: " + registroCedula + " canceló su reservación.");
                            pasajeroEjecutivo[k][l] = null;
                            pasajeroEjecCedula[k][l] = 0;
                            break;
                        }
                        if (l == 3 && k == 1){
                            System.out.println("No se encontró al pasajero en la Clase Ejecutiva");
                            break;
                        }
                        else if (l == 3){
                            k += 1;
                            l = 0;
                        }
                    }
                }
                else if (buscarPasajero == 2){
                    k = 0;
                    for (l = 0; l <= 5; l++){
                        if ((pasajeroEconomico[k][l] == null ? registroNombre == null : pasajeroEconomico[k][l].equals(registroNombre)) && pasajeroEconCedula[k][l] == registroCedula){
                            System.out.println("El pasajero " + registroNombre + " con Cedula: " + registroCedula + " canceló su reservación.");
                            pasajeroEconomico[k][l] = null;
                            pasajeroEconCedula[k][l] = 0;
                            break;
                        }
                        if (l == 5 && k == 6){
                            System.out.println("No se encontró al pasajero en la Clase Económica");
                            break;
                        }
                        else if (l == 5){
                            k += 1;
                            l = 0;
                        }
                    }
                }   break;
            case 5:
                k = 0;
                l = 0;
                for (i = 0; i <= 13; i++){
                    if (pasajeroEconomico[k][l] == null && pasajeroEconCedula[k][l] == 0 ){
                        contSillasDispEco += 1;
                    }
                    if (k == 6) {
                        l += 1;
                        k = 0;
                    }else {
                        k += 1;
                    }
                    
                }   System.out.println("El numero de sillas disponibles en ventanilla de la Clase Economica es: " + contSillasDispEco);
                break;
            default:
                break;
        }
       
    } //Cierra el Método sistemadeReportes(); 
    
    public static void comprobarEjecutivo(){
        x = i;
        y = j;
        
        //Comprueba que no se repita el mismo usuario en ventanilla
        if (i == 0 && j > 0){
            while (y > 0){
                if (pasajeroEjecutivo[i][j].equals(pasajeroEjecutivo[x][y-1]) && pasajeroEjecCedula[i][j] == pasajeroEjecCedula[x][y-1]){
                System.out.println("Los datos que acaba de ingresar ya se encuentran en el sistema");
                pasajeroEjecutivo[i][j] = null;
                pasajeroEjecCedula[i][j] = 0;
                cuposDispVentEjc += 1;
                }
                y -= 1;
            }     
        }
        // comprueba que no se repita el mismo usuario en el pasillo
        if (i == 1 && j > 0){
            while (y > 0){
                if (pasajeroEjecutivo[i][j].equals(pasajeroEjecutivo[x][y-1]) && pasajeroEjecCedula[i][j] == pasajeroEjecCedula[x][y-1]){
                System.out.println("Los datos que acaba de ingresar ya se encuentran en el sistema");
                pasajeroEjecutivo[i][j] = null;
                pasajeroEjecCedula[i][j] = 0;
                cuposDispPassEjc += 1;
                }
                y -= 1;
            }
        }
        
    }//Cierra el metodo comprobarEjecutivo();
    
    public static void comprobarEconomico(){
        x = i;
        y = j;
        
        if (i > 0 && j == 0){
            while (x > 0){
                if (pasajeroEconomico[i][j].equals(pasajeroEconomico[x-1][y]) && pasajeroEconCedula[i][j] == pasajeroEconCedula[x-1][y]){
                System.out.println("Los datos que acaba de ingresar ya se encuentran en el sistema");
                pasajeroEconomico[i][j] = null;
                pasajeroEconCedula[i][j] = 0;
                cuposDispVentEco += 1;
                }
                x -= 1;
            }     
        }
}//Cierra el metodo comprobarEconomico();
    
}
//pasajeroEconomico[i][j] == null && pasajeroEconCedula[i][j] cuposDispVentEco