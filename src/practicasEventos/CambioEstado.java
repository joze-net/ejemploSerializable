
package practicasEventos;
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

public class CambioEstado {//clase principal
   public static void main(String []args){
       
       MarcoEstado marco=new MarcoEstado();//instanciamos la clase
       marco.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);//cerramos el programa cuando se cierre la ventana
       
       
   } 
}
class MarcoEstado extends JFrame{//creamos nuestro marco
    
    public MarcoEstado(){
    Toolkit mipc=Toolkit.getDefaultToolkit();
    Dimension acer=mipc.getScreenSize();
    
    int x=acer.width;
    int y=acer.height;
    
    setBounds(x/4,y/4,x/2,y/2);
    setVisible(true);
    addWindowStateListener(new Estado());//implentemos la clase que detecta el cambio de estado
    
    }
}
class Estado implements WindowStateListener{//esta implementacion nos ayuda a detectar de cuando la ventana a cambiado su estado
    
    @Override
    public void windowStateChanged(WindowEvent e){//esto se ejecutara cuando la ventana sea minimizada/maximizada estado normal
       // System.out.println("la ventana a cambiado de estado");
       if(e.getNewState()==Frame.ICONIFIED){//usamos el metodo perteneciente a la clase WindowEvent, el cual nos devuelve el estado nuevp de la ventana
           System.out.println("la ventana a sido minimizada");
       }else if(e.getNewState()==Frame.MAXIMIZED_BOTH){////y tambien usando las constantes de Frame la cual tiene registrado los cambios de ventana
           System.out.println("la ventana a sido maximizada");
       }else if(e.getNewState()==Frame.NORMAL){
           System.out.println("la ventana esta en estado normal");//
       }
    }
    
}