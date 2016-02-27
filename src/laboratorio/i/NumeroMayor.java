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
public class NumeroMayor {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        //Este programa a partir de tres numeros suministrados, escoge el mayor y lo imprime.
        java.util.Scanner ingrese_a = new java.util.Scanner(System.in);
        java.util.Scanner ingrese_b = new java.util.Scanner(System.in);
        java.util.Scanner ingrese_c = new java.util.Scanner(System.in);
        int mayor = 0;
        int a = 0;
        int b = 0;
        int c = 0;
        System.out.println("Ingrese a");
        a = ingrese_a.nextInt();
        System.out.println("Ingrese b");
        b = ingrese_b.nextInt();
        System.out.println("Ingrese c");
        c = ingrese_c.nextInt();
        
        if (a > b){
            if (a > c){
                mayor = a;
            }else{
                mayor = c;
            }
        }else{
            if (b > c){
                mayor = b;
            }else{
                mayor = c;
            }
        }
        System.out.println("El mayor es: " + mayor);
    }
    
}
