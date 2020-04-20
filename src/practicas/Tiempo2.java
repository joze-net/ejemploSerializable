
package practicas;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.Timer;
import java.util.Date;
import javax.swing.JOptionPane;
/*este es un ejemplo muy parecido a la clase Tiempo por que nos da los mismos resultados por pantalla la diferencia es
que aqui creamos una clase interna(inner class) la cual llamamos HoraExacta,la cual es una clase privada dentro de la
clase Tiempo2 como si fueran dos clases anidadas
*/
public class Tiempo2 {
    public static void main (String []args){
     Reloj miReloj=new Reloj(3000,true); //instanciamos un objeto apartir de  la clase que creamos Reloj y colocomas los argumentos en el constructor
     miReloj.empezarReloj();//este metod lo que hace es dar inicio al objeto creado
     JOptionPane.showMessageDialog(null,"Aceptar para detener el programa");//al dar aceptar se detiene el programa
     System.exit(0);//aqui paramos el programa
    }
}
class Reloj {//clase
    public  Reloj (int intervalo,boolean sonido){//constructor de Reloj
        this.intervalo=intervalo;//damos vlor a las variables de la clase
        this.sonido=sonido;
    }
    public void empezarReloj(){//metodo que da inicio
        HoraExacta2 oyente = new HoraExacta2();//instanciamos un objeto de HoraExacta donde se encuentra implementado la interfaz ActionListener
        Timer miTiempo=new Timer(intervalo,oyente);//esta clase desencadena un evento
        miTiempo.start();//al llamar a este metodo se da inicio al evento
    }
    private int intervalo;//atributos
    private boolean sonido;//atributos
    
    private class HoraExacta2 implements ActionListener{//clase interna
        
        @Override
        public void actionPerformed (ActionEvent evento){//metodo de la interfaz ActionListener que tiene que ser implementado
            Date hora=new Date ();//creamos un objeto de tipo date
            System.out.println("Hora actula cada 3 seg: "+hora);//el evento es dar la hora cada 3 segs
            
            if(sonido){//si sonido==TRUE
                Toolkit.getDefaultToolkit().beep();//le damos sonido cada vez que aparezca la hora
            }
        }
        
    }
}
