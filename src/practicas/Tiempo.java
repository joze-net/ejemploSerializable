
package practicas;
import java.awt.Toolkit;
import javax.swing.*;
import java.awt.event.*;
import java.util.*;
import javax.swing.Timer;
public class Tiempo {
    /*este es un ejemplo de TEMPORIZADOR el cual usamos la clase Timer del paquete javax.swing.Timer en el cual debemos implementar
    una interfaz llamada ActionListener, por lo tanto obligatoriamente debemos imolemtar los metodos que tenga dicha interfaz el cual es
    actionPerformed(ActionEvent e)que recibe por parametro un ActionEvent;dentro del constructor creamos un objeto de tipo Date
    el cual da la hora actual
    */
   
    public static void main (String args[]){
       HoraExacta oyente= new HoraExacta();//instanciacion de la clase que se creo HoraExacta
       Timer mitiempo=new Timer(5000,oyente) ;//objeto instanciado de la clase de la API de java Timer
       mitiempo.start();//con este constructor inicializamos el objeto miTiempo
       JOptionPane.showMessageDialog(null,"pulse aceptar si quiere detener el programa");//mientras no se de en aceptar el programa no para
       mitiempo.stop();//con este metodo detenemos el programa
       
       
    }
}
class HoraExacta implements ActionListener {//en nuestra clase implementamos la interfaz
    @Override//sobreescriv¡bimos el metodo de la interfaz
    public void actionPerformed (ActionEvent evento){
        Date actualizarHora=new Date();//construimos el objeto actualizarHora apartir de la clase Date
        System.out.println("la hora actual es: "+actualizarHora);//vizualizamos la hora 
        Toolkit.getDefaultToolkit().beep();//Toolkit es una clase abstracta la cual nos ofrece diferentes funcionalidades esta da un sonido
    }
    
}
