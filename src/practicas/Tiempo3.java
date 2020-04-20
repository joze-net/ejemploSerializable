
package practicas;
import java.awt.Toolkit;
import javax.swing.*;
import java.awt.event.*;
import java.util.*;
import javax.swing.Timer;
/*este ejemplo es tambien parecido a las clases tiempo y tiempo2 la diferencia es que aqui no colocamos un clase interna sino que
colocamos una clase local la cual no lleva modificador de acceso y reduce el codigo lo simplifica;y esta clase esta creada dentro de 
unmetodo la cual puede acceder a los campos de la clase externa y no al contrario,ademas la clase queda mas encapsulada
ni la externa tiene acceso directo a ella.
*/
public class Tiempo3 {
    public static void main (String []args){
        Reloj3 miReloj=new Reloj3();
        miReloj.iniciarReloj(3000,true);
        JOptionPane.showMessageDialog(null,"aceptar para detener el programa");
        System.exit(0);
    }
}
    class Reloj3{
      
    public void iniciarReloj(int intervalo,final boolean sonido){
        
        class HoraActual implements ActionListener{
        @Override
        public void actionPerformed (ActionEvent evento){
            Date HoraActualizada=new Date();
            System.out.println("Hora cada 3 seg: "+HoraActualizada);
            
            if(sonido){
                Toolkit.getDefaultToolkit().beep();
            }
            
        }
        
    }
         HoraActual oyente=new HoraActual();
         Timer laHora=new Timer(intervalo,oyente);
         laHora.start();
    }
    private int intervalo;
    private boolean sonido;
    
   
    
  
}
