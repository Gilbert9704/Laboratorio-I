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
public class Registraduria {
    static  String candidato[][]= new String[21][21];/**Donde se guarda el hombre de los candidatos de los diferentes municipios**/
    
    static  String losMunicipios[]= {"tolima","Alpujarra","Alvarado","Ambalema","Anzoategui","Chaparral","Armero (Guayabal)","Carmen de Apicalá","Cajamarca"," Ataco","Coello","Coyaima ","Cunday","Dolores","Espinal","Falán","Flandes","Fresno","Guamo","Libano"};
    /**Listado de municipios**/
    static  int voto[][]= new int[20][20]; /**donde se guardan los votos de los candidatos  **/
    static  int sumaVotos[]=new int[20];/**donde se guardanla suma de  los votos  de los municipios**/
    static  int porcentaje [][]=new int[20][20];/**donde se guardan  los porcentajes de cada candidato**/
    /*la lista de los municiios *
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
            int comando = 0;
        java.util.Scanner numero = new java.util.Scanner(System.in);
/**Se crea un menú principal donde se agregan para las diferestes  aplicaciones  **/        
        while (comando <= 3){
        do {
            System.out.println("                   SISTEMA DE CONTROL  DE ELECCIONES  \n"+
                             "                                                          \n"+ 
                             "                    ¿ Escoja que operación quiere  realizar ? \n"+
                             "                                                            \n"+  
                             "                     1 Inscribir Candidatos\n"+ 
                             "                                                          \n"+ 
                             "                     2 Ingresar votos de Candidatos\n"+
                              "                                                          \n"+ 
                             "                     3 Informacìon");
            
            comando = numero.nextInt(); 
            
        }while (comando > 3 && comando != 0);
        
        if (comando == 1){
            inscribirCandidatos( ); /**Invocación de función  guardar los candidatos **/
        }else if (comando == 2) {
            sumadevotos();/**Invocación  una función registra votos  **/
        }else if (comando == 3){
            sistemaInformacion();/**este lo traslada un nuevo menú con más aplicaciones  **/
            
        }
            
        }
       
    }
    
    /**esta función te da elegir el municipio donde escribirás el candidato y lo guarda  **/
    
     public static void inscribirCandidatos(){
        
         int municipio ;
         int j = 0;
         boolean g =true;
         boolean t=true;
         int k=0;
        
        
         
         System.out.println("                        \n"+
"                           Elija el Municipio que desea inscribir el candidato\n" +
"                                                                                                 \n" +
   "1   Alpujarra                     6.  Ataco                   11. Coello          16. Falán\n" +
   "2.  Alvarado                      7.  Cajamarca               12. Coyaima         17. Flandes\n" +
   "3.  Ambalema                      8.  Carmen de Apicalá       13. Cunday          18. Fresno\n" +
   "4.  Anzoategui                    9.  Casabianca              14. Dolores         19. Guamo\n" +
   "5.  Armero (Guayabal)             10. Chaparral               15. Espinal         20. Libano\n"

             

                 

              );
                             
                 
         java.util.Scanner elegir  = new java.util.Scanner(System.in);
          municipio = elegir.nextInt();
         
        
              
                   
             int i;
            
                 System.out.println( "           Los candidatos inscritos en "+ losMunicipios[municipio]+"\n" 
                                                +"                 \n "                                                       );
                   for (i = 0; i <= 20; i++ ){
                       if(!(candidato[municipio][i]==null)&&g){
                           System.out.println( (i+1)+ candidato[municipio][i]);
                       }
                       if( (candidato[municipio][i]==null)&&g){
                           System.out.println("             Escriba el nombre del candidato ");
                           java.util.Scanner inscribir  = new java.util.Scanner(System.in);
                           candidato[municipio][i] = inscribir.nextLine();
                           g=false;
                            }    
                   }
                  
                   System.out.println( "           Los candidatos inscritos en "+ losMunicipios[municipio]+"\n" 
                                                +"                 \n "                                                       );
                   for (i = 0; i <= 20; i++ ){
                       if(!(candidato[municipio][i]==null)&&t){
                           System.out.println( (i+1)+ candidato[municipio][i]+"\n "
                                                +"                 \n ");
                       }
                       if( (candidato[municipio][i]==null)&&t){
                          
                           t=false;
                            }    
                   };
                   System.out.println( "presione  cualquier numero  para volver menu principal \n ");
                   java.util.Scanner uno  = new java.util.Scanner(System.in);
                        k = uno.nextInt();
                       
                   
     }
     
     
     public static void sumadevotos(){
         int municipio2 ;
         int i;
         int j;
         int numerocadi=0;
       
         
         
          System.out.println("                        \n"+
         "                           Elija el Municipio para  agregar los  votos a los candidatos\n" +
         "                                                                                                 \n" +
         "1   Alpujarra                     6.  Ataco                   11. Coello          16. Falán\n" +
         "2.  Alvarado                      7.  Cajamarca               12. Coyaima         17. Flandes\n" +
         "3.  Ambalema                      8.  Carmen de Apicalá       13. Cunday          18. Fresno\n" +
         "4.  Anzoategui                    9.  Casabianca              14. Dolores         19. Guamo\n" +
         "5.  Armero (Guayabal)             10. Chaparral               15. Espinal         20. Libano\n"

      );
         java.util.Scanner oto  = new java.util.Scanner(System.in);
          municipio2 = oto.nextInt();
          
          System.out.println( " escoja el candidato  al que le va a  sumara los votos   del municipio de  "+ losMunicipios[municipio2]);
                          for (i = 0; i <= 20; i++ ){
                         if(!(candidato[municipio2][i]==null)){
                         System.out.println(candidato[municipio2][i]+"\n " );
                            }
                          }
                         java.util.Scanner tatun  = new java.util.Scanner(System.in);
                           numerocadi  = tatun.nextInt();
         
                         System.out.println( "el candidato que escogio  "+ candidato[municipio2][(numerocadi-1)]);
        
                         java.util.Scanner loco  = new java.util.Scanner(System.in);
                           voto [(municipio2)][(numerocadi-1)] = voto [(municipio2)][(numerocadi-1)]+loco.nextInt();
                           
         System.out.println( "los votos que llevan los candidatos del   "+ losMunicipios[municipio2]);
                          for (j = 0; j <= 20; j++ ){
                         if(!(candidato[municipio2][j]==null)){
                         System.out.println((candidato[municipio2][j])+ (voto [municipio2][(j)]  )+ "\n " );
                            }
                          }                 
                    
     
     
      
     
}
 public static void sistemaInformacion(){
     
     int comando2=0;
         do {
            System.out.println("                   SISTEMA INFORMACION  DE ELECCIONES   \n"+
                             "                                                          \n"+ 
                             "                    ¿ Escoja que operación quiere  realizar ? \n"+
                             "                                                            \n"+  
                             "                     1 tabla con resultado de elecione "+ 
                             "                                                          \n"+ 
                             "                     2    ganadores de cada municipio         \n"+
                              "                                                          \n"+ 
                             "                     3 candidatos me mayor votacion a menor votacion");
            
           java.util.Scanner numero1 = new java.util.Scanner(System.in);
            comando2 = numero1.nextInt(); 
            
        }while (comando2 > 3 && comando2 != 0);
        
        if (comando2 == 1){
          tablaConLosresultados ();
        }else if (comando2 == 2) {
             ganadores ();
        }else if (comando2 == 3){
             
        };
        
       
        
    }
 
 
 
 public static void tablaConLosresultados (){
     int ñ;
     int q;
     int k;
     int y;
     int e;
     int u;
     int l;
     
     for(e=0;e<=19;e++){
           for(u=0;u<=19;u++){
               for(l=0;l<=19;l++){
               sumaVotos[e]=sumaVotos[e]+voto[u][l];
 }
     }
     }
       
     for(k = 0; k<=19 ;k++){
         for(y=0;y<=19;y++){
           
             if(!(sumaVotos[k]==0) )
             porcentaje[k][y]=(((voto[k][y]*100)/ sumaVotos[k]));   
                                            
         }
     }  
     
             
     
     System.out.println("Listado candidatoS  con su votación y porcentaje ");
     
     for(ñ=0;ñ<=20;ñ++ ){
      for(q=0;q<=20;q++){
          
          if(!(candidato[q][ñ]==null)){
             System.out.println( losMunicipios[q]+"  candidato  "+candidato[q][ñ]+"  sus votos son  "+ voto [q][(ñ)]+"su porcentaje "+ porcentaje[q][ñ]                                          ); 
          }
          
         
         
         
     }
     
     
     
     
     
 }
 
 
    
     
 }
 public static void ganadores (){
int aa;
int bb;
int cc=0;
int dd;


System.out.println("los ganadores de los municipios \n");
 for(aa=0;aa<=20;aa++){
     for(bb=0;bb<=20;bb++){
         if(!(candidato[aa][bb]==null)){
             
          for(cc=0;cc<=17;cc++){
              dd=voto[aa][cc];
            if(voto[aa][cc+1]>dd){
             dd =voto[aa][cc+1];
             System.out.println(   losMunicipios[aa]+"    "+candidato[aa][(cc+1)]) ;
            }
              
           
                      
     }
       ;   
     }
         
         
 }       
         
     } 
}
    
    
}
