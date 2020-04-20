
package practicas;

import java.util.Scanner;


public class Enum {
    
    enum Talla {
        MINI("S"),MEDIANA("M"),GRANDE("L"),EXTRA_GRANDE("XL");
        private Talla(String abreviatura){
            this.abreviatura=abreviatura;
        }
        public String getTalla(){
           return abreviatura;
        }
       private String abreviatura; 
    }
    public static void main (String args[]){
        Scanner s=new Scanner(System.in);
        String entrada;
        
        
        System.out.println("ingrese la talla (mini/mediana/grande/extra grande");
        entrada= s.nextLine().toUpperCase();
        Talla miTalla=Talla.valueOf(Talla.class, entrada);
        System.out.println(miTalla);
        System.out.println(miTalla.getTalla());
    }
}
