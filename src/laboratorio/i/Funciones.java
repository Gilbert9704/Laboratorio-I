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
public class Funciones {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // Este programa me ejecuta 2 metodos distintos y me imprime el mensaje que contiene cada uno.
        System.out.println("Primera Funcion en Main");
        func1();
        func2();
        System.out.println("Se termina la función");
    }
    
    public static void func1(){
        System.out.println("Segunda Función");
    }
    public static void func2(){
        System.out.println("Tercera Función");
    } 
    
}
