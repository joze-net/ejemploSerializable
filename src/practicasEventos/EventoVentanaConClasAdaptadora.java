
package practicasEventos;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
//en esta clase practicamos las clases adaptadoras en especifico WindowAdapter la cual implementa las interfaz de   
public class EventoVentanaConClasAdaptadora {
  public static void main(String []args){
      
      Marcoo mimarco=new Marcoo();//instanciamos nuestro marco que hemos creado
      mimarco.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);//cerramos el programa 
      
  }  
}
class Marcoo extends JFrame{//creamos el marco que hereda de JFrame
    public Marcoo (){
        Toolkit miPantalla=Toolkit.getDefaultToolkit();
        Dimension acer=miPantalla.getScreenSize();
        
        int x= acer.width;
        int y= acer.height;
        
        setBounds(x/4, y/4, x/2, y/2);
        setVisible(true);
        /*Oyente o=new Oyente();//podemos agregar el oyente
        addWindowListener(o);*/
        
        addWindowListener(new Oyente());//podemos agregar el oyente de esta forma o de la que esta comentada,funcionara igual
    }
}
class Oyente extends WindowAdapter{//creamos el oyente e implementamos la clase WindowAdapter la cial implementa la s interfaz para utilizar 
    //solo uno de los metodos que necesitemos y no todos


    @Override
    public void windowIconified(WindowEvent e) {//sobreescribimos el metodo de la interfaz WindowListener
        System.out.println("ventana minimizada");
    }
    
}