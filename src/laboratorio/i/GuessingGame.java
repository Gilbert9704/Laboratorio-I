/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package laboratorio.i;
/**
 *
 * @author User
 */
public class GuessingGame {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        String playAgain = "y";
        
        while (playAgain != "y"){
           GuessingGame();
           
           java.util.Scanner play = new java.util.Scanner(System.in);
           System.out.println("¿Desea jugar nuevamente?(y/n):");
           playAgain = play.next(); 
        }  
    }
    
    public static void GuessingGame(){
        int answer = (int) Math.floor((Math.random()*100)+1);
        System.out.println(answer);
        int guess = 0;
        int numGuesses = 1;
        
        while (numGuesses > 7 || (guess == answer)){
            System.out.println("Imagina un numero");
            java.util.Scanner number = new java.util.Scanner(System.in);
            guess = number.nextInt();
                
                if (guess < answer){
                    System.out.println("Elevado");
                } 
                else if (guess > answer){
                    System.out.println("Muy Bajo");
                }
                else {
                    System.out.println("Ganaste!");
                }
                numGuesses = numGuesses + 1;
        }
        if (numGuesses > 7){
            System.out.println("Perdiste :(");
        }
                
    }       
    
}
