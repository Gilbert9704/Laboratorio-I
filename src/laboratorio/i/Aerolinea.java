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
    static byte sillaEjecutiva = 0;
    static byte sillaEconomica = 0;
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
            
            if (ventanilla_pasillo == 1){ //Se le asigna al pasajero un asiento
                i = 0;
                j = 0;
                while(cuposDispVentEjc >= 0){ //Este contador me limita el cupo de las sillas en ventanilla
                    
                    if (pasajeroEjecutivo[i][j] == null && pasajeroEjecCedula[i][j] == 0 ){
                        System.out.println("Ingrese el nombre del pasajero");
                        pasajeroEjecutivo[i][j] = pasEjec.nextLine();
                        System.out.println("Ingrese el numero de Cedula del pasajero");
                        pasajeroEjecCedula[i][j] = pasEjecCed.nextInt();
                        //Función para determinar si ya se encuentra algun pasajero inscrito con los mismos datos
                        comprobarEjecutivo();

                        if (cuposDispVentEjc == 0){//Si la condicion se cumple termina el ciclo
                            System.out.println("Todos los asientos de esta posicion reservados");
                            break;
                        }
                        System.out.println("¿Desea Agregar otro pasajero a esta clase y posición? (si(1)/no(0))" + " *Cupos Disponibles: " + cuposDispVentEjc);
                        respuesta = pregunta.nextInt(); 
                        
                        if (respuesta == 1 && pasajeroEjecutivo[i][j+1] == null){//Primero se verifica si la silla siguiente está vacía
                        }else if (respuesta == 1 && pasajeroEjecutivo[i][j+1] != null){//De estar vacias se finalizará el ciclo
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
                       //Función para determinar si ya se encuentra algun pasajero inscrito en esta clase
                        comprobarEjecutivo();
                        
                        if (cuposDispPassEjc == 0){//Si la condicion se cumple termina el ciclo
                            System.out.println("Todos los asientos de esta posicion reservados");
                            break;
                        }
                        System.out.println("¿Desea Agregar otro pasajero a esta clase y posición? (si(1)/no(0))" + " *Cupos Disponibles: " + cuposDispPassEjc);
                        respuesta = pregunta.nextInt();
                        
                        if (respuesta == 1 && pasajeroEjecutivo[i][j+1] == null){//Primero se verifica si la silla siguiente está vacía
                        }else if (respuesta == 1 && pasajeroEjecutivo[i][j+1] != null){//De estar vacias se finalizará el ciclo
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
            /*
            Tanto en la ventanilla como en el centro y el pasillo para el ingreso de los datos 
            es la misma estructura, se solicitan, se comprueba si ya existe, de no existir
            se asignan, se pregunta si se desea agregar otro pasajero a esta clase y posición
            de ser positiva la respuesta, se verifica la siguiente silla si está o no vacía
            si esta vacia se asigna el siguiente pasajero allí de lo contrario se finaliza el ciclo.
            */
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
                        System.out.println("¿Desea Agregar otro pasajero a esta clase y posición y posición? (si(1)/no(0))" + " *Cupos Disponibles: " + cuposDispVentEco);
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
                        System.out.println("¿Desea Agregar otro pasajero a esta clase y posición? (si(1)/no(0))" + " *Cupos Disponibles: " + cuposDispCentEco);
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
                        System.out.println("¿Desea Agregar otro pasajero a esta clase y posición? (si(1)/no(0))" + " *Cupos Disponibles: " + cuposDispPassEco);
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
        
        System.out.println("¿Qué desea? \n 1-Contar Sillas Ejecutivas Ocupadas \n 2-Localizar silla de un pasajero \n 3-Localizar silla economica disponible \n 4-Anular Reserva \n 5-Contar Numero de puestos disponibles en ventana en la clase economica \n 6-Regresar");
        accion = decision.nextInt();
        
        switch (accion) {
            case 1://Contar sillas Ejecutivas Ocupadas
                k = 0;
                l = 0;
                for (i = 0; i <= 7; i++){//verifico cada coordenada de la matriz para ver cuantas estan vacias en ambas matrices
                    if (pasajeroEjecutivo[k][l] == null && pasajeroEjecCedula[k][l] == 0 ){
                    }
                    else{
                        contSillasOcpEjc += 1;
                    }
                    if (l == 3) {//me permite avanzar a la siguiente columna
                        k += 1;
                        l = 0;
                    }else {
                        l += 1;
                    }
                    
                }   System.out.println("El numero de sillas ocupadas en la clase ejecutiva es: " + contSillasOcpEjc);
                break;
            case 2://Localizar silla de un pasajero
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
                            //Este condicional compara datos 
                            numerodeSilla();//Este metodo me permite convertir cada coordenada en un numero de silla
                            System.out.println("La Ubicacion del pasajero es la silla: " + sillaEjecutiva);
                            break;
                        }
                        if (l == 3 && k == 1){//Ejecutiva
                            System.out.println("No se encontró al pasajero en la Clase Ejecutiva");
                            break;
                        }
                        else if (l == 3){
                            k += 1;
                            l = 0;
                        }
                    }
                }
                else if (buscarPasajero == 2){//Economica
                    k = 0;
                    for (l = 0; l <= 5; l++){
                        if ((pasajeroEconomico[k][l] == null ? registroNombre == null : pasajeroEconomico[k][l].equals(registroNombre)) && pasajeroEconCedula[k][l] == registroCedula){
                            numerodeSilla();
                            System.out.println("La Ubicación del pasajero es la silla: " + sillaEconomica);
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
            case 3://Localizar silla economica disponible
                k = 0;
                l = 0;
                for (i = 0; i <= 41; i++){
                    if (pasajeroEconomico[k][l] == null && pasajeroEconCedula[k][l] == 0 ){
                        System.out.println("Se encontró disponible la silla: " + sillaEconomica + "  ¿Desea asignar un pasajero a ella? (si(1)/no(0))");
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
            case 4://Anular Reserva
                k = 0;
                l = 0;
                System.out.println("Ingrese el nombre del pasajero a eliminar");
                registroNombre = regNombre.nextLine();
                System.out.println("Ingrese el numero de cedula del pasajero");
                registroCedula = regCedula.nextInt();
                System.out.println("Elija la clase en la cual se encuentra el pasajero (Ejecutiva(1)/Economica(2))");
                buscarPasajero = buscarPasaj.nextByte();
                if (buscarPasajero == 1){//Ejecutiva
                    k = 0;
                    for (l = 0; l <= 3; l++){//Identifica la ubicacion del pasajero y elimina sus datos
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
                else if (buscarPasajero == 2){//Economica
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
            case 5://Contar Numero de puestos disponibles en ventana en la clase economica
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
            case 6://regresar
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
        else if (i >= 0 && j == 1) {
            while (x > 0){
                if (pasajeroEconomico[i][j].equals(pasajeroEconomico[x-1][y]) && pasajeroEconCedula[i][j] == pasajeroEconCedula[x-1][y]){
                System.out.println("Los datos que acaba de ingresar ya se encuentran en el sistema");
                pasajeroEconomico[i][j] = null;
                pasajeroEconCedula[i][j] = 0;
                cuposDispVentEco += 1;
                }
                x -= 1;
            }
        }//Ambos de los condicionales anteriores impiden que en ventanilla inscriba el mismo pasajero
        
        else if (i >= 0 && j == 2){
            while (x > 0){
                if (pasajeroEconomico[i][j].equals(pasajeroEconomico[x-1][y]) && pasajeroEconCedula[i][j] == pasajeroEconCedula[x-1][y]){
                System.out.println("Los datos que acaba de ingresar ya se encuentran en el sistema");
                pasajeroEconomico[i][j] = null;
                pasajeroEconCedula[i][j] = 0;
                cuposDispCentEco += 1;
                }
                x -= 1;
            }
        }
        else if (i >= 0 && j == 3){
            while (x > 0){
                if (pasajeroEconomico[i][j].equals(pasajeroEconomico[x-1][y]) && pasajeroEconCedula[i][j] == pasajeroEconCedula[x-1][y]){
                System.out.println("Los datos que acaba de ingresar ya se encuentran en el sistema");
                pasajeroEconomico[i][j] = null;
                pasajeroEconCedula[i][j] = 0;
                cuposDispCentEco += 1;
                }
                x -= 1;
            }
        } //Ambos de los condicionales anteriores impiden que en el centro se inscriba el msmo pasajero
        
        else if (i >= 0 && j == 4){
            while (x > 0){
                if (pasajeroEconomico[i][j].equals(pasajeroEconomico[x-1][y]) && pasajeroEconCedula[i][j] == pasajeroEconCedula[x-1][y]){
                System.out.println("Los datos que acaba de ingresar ya se encuentran en el sistema");
                pasajeroEconomico[i][j] = null;
                pasajeroEconCedula[i][j] = 0;
                cuposDispPassEco += 1;
                }
                x -= 1;
            }
        }
        else if (i >= 0 && j == 5){
            while (x > 0){
                if (pasajeroEconomico[i][j].equals(pasajeroEconomico[x-1][y]) && pasajeroEconCedula[i][j] == pasajeroEconCedula[x-1][y]){
                System.out.println("Los datos que acaba de ingresar ya se encuentran en el sistema");
                pasajeroEconomico[i][j] = null;
                pasajeroEconCedula[i][j] = 0;
                cuposDispPassEco += 1;
                }
                x -= 1;
            }
        }
    }//Cierra el metodo comprobarEconomico();
    
    public static void numerodeSilla(){
        if (buscarPasajero == 1){
            if (k == 0 && l == 0){
                sillaEjecutiva = 1;
            }
            else if (k == 0 && l == 1){
                sillaEjecutiva = 2;
            }
            else if (k == 0 && l == 2){
                sillaEjecutiva = 3;
            }
            else if (k == 0 && l == 3){
                sillaEjecutiva = 4;
            }
            else if (k == 1 && l == 0){
                sillaEjecutiva = 5;
            }
            else if (k == 1 && l == 1){
                sillaEjecutiva = 6;
            }
            else if (k == 1 && l == 2){
                sillaEjecutiva = 7;
            }
            else if (k == 1 && l == 3){
                sillaEjecutiva = 8;
            }
        }
        else if (buscarPasajero == 2){
            if (k == 0 && l == 0){
                sillaEconomica = 9;
            }
            else if (k == 0 && l == 1){
                sillaEconomica = 10;
            }
            else if (k == 0 && l == 2){
                sillaEconomica = 11;
            }
            else if (k == 0 && l == 3){
                sillaEconomica = 12;
            }
            else if (k == 0 && l == 4){
                sillaEconomica = 13;
            }
            else if (k == 0 && l == 5){
                sillaEconomica = 14;
            }
            else if (k == 1 && l == 0){
                sillaEconomica = 15;
            }
            else if (k == 1 && l == 1){
                sillaEconomica = 16;
            }
            else if (k == 1 && l == 2){
                sillaEconomica = 17;
            }
            else if (k == 1 && l == 3){
                sillaEconomica = 18;
            }
            else if (k == 1 && l == 4){
                sillaEconomica = 19;
            }
            else if (k == 1 && l == 5){
                sillaEconomica = 20;
            }
            else if (k == 2 && l == 0){
                sillaEconomica = 21;
            }
            else if (k == 2 && l == 1){
                sillaEconomica = 22;
            }
            else if (k == 2 && l == 2){
                sillaEconomica = 23;
            }
            else if (k == 2 && l == 3){
                sillaEconomica = 24;
            }
            else if (k == 2 && l == 4){
                sillaEconomica = 25;
            }
            else if (k == 2 && l == 5){
                sillaEconomica = 26;
            }
            else if (k == 3 && l == 0){
                sillaEconomica = 27;
            }
            else if (k == 3 && l == 1){
                sillaEconomica = 28;
            }
            else if (k == 3 && l == 2){
                sillaEconomica = 29;
            }
            else if (k == 3 && l == 3){
                sillaEconomica = 30;
            }
            else if (k == 3 && l == 4){
                sillaEconomica = 31;
            }
            else if (k == 3 && l == 5){
                sillaEconomica = 32;
            }
            else if (k == 4 && l == 0){
                sillaEconomica = 33;
            }
            else if (k == 4 && l == 1){
                sillaEconomica = 34;
            }
            else if (k == 4 && l == 2){
                sillaEconomica = 35;
            }
            else if (k == 4 && l == 3){
                sillaEconomica = 36;
            }
            else if (k == 4 && l == 4){
                sillaEconomica = 37;
            }
            else if (k == 4 && l == 5){
                sillaEconomica = 38;
            }
            else if (k == 5 && l == 0){
                sillaEconomica = 39;
            }
            else if (k == 5 && l == 1){
                sillaEconomica = 40;
            }
            else if (k == 5 && l == 2){
                sillaEconomica = 41;
            }
            else if (k == 5 && l == 3){
                sillaEconomica = 42;
            }
            else if (k == 5 && l == 4){
                sillaEconomica = 43;
            }
            else if (k == 5 && l == 5){
                sillaEconomica = 44;
            }
            else if (k == 6 && l == 0){
                sillaEconomica = 45;
            }
            else if (k == 6 && l == 1){
                sillaEconomica = 46;
            }
            else if (k == 6 && l == 2){
                sillaEconomica = 47;
            }
            else if (k == 6 && l == 3){
                sillaEconomica = 48;
            }
            else if (k == 6 && l == 4){
                sillaEconomica = 49;
            }
            else if (k == 6 && l == 5){
                sillaEconomica = 50;
            }
        }
    }//Cierra el método numerodeSilla();
    
}
