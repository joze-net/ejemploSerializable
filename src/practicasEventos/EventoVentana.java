
package practicasEventos;
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

public class EventoVentana {
   public static void main (String []args){
       
       MarcoVentana miMarco=new MarcoVentana();
       miMarco.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
       MarcoVentana mimarco2=new MarcoVentana();
       mimarco2.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);//de sta manera cerramos esta ventana y la otra seguira en uso hasta que la cerremos
   } 
}
class MarcoVentana extends JFrame{
    
    public MarcoVentana(){
        
    Toolkit mipc=Toolkit.getDefaultToolkit();
    Dimension acer=mipc.getScreenSize();
    
    int x=acer.width;
    int y=acer.height;

    setTitle("mi ventana");
    setBounds(x/4, y/4, x/2, y/2);
    
    AccionVentana accion=new AccionVentana();
    addWindowListener(accion);
    setVisible(true);
    
    }
    
}
class AccionVentana implements WindowListener{
    @Override
    public void windowActivated(WindowEvent e){//este metodo es para que se ejecute el codigo cuando la ventana este cerrada y la abramos
        //o cuando este minimizada y la abramos
        //Se invoca cuando la ventana está configurada para ser la ventana activa.
        System.out.println("ventana activada");
    
    }
    @Override
    public void windowClosed(WindowEvent e){//se invoca cuano la ventana a sido cerrada
        
        System.out.println("ventana cerrada");
    
    }
    @Override
    public void windowClosing(WindowEvent e){//este metodo se ejecuta cuando damos clic en cerrar,es decir cuando la venta se esta cerrando
    
        System.out.println("ventana cerrandose");
    
    }
    @Override 
    public void windowDeactivated(WindowEvent e){//este codigo se ejecuta cuando la vetana esta abierta pero no la estamos usando
        //es decir cuando la minimizamos la ventana esta desactivada
    
        System.out.println("ventana desactivada");
    
    }
    @Override
    public void windowDeiconified(WindowEvent e){//este metodo se invoca cuando la ventana esta minimizada y la ponemos otrvez normal
    
        System.out.println("ventana en estado normal");
        
    }
    @Override
    public void windowIconified(WindowEvent e){
    
        System.out.println("ventana minimizada");
        
    }
    @Override
    public void windowOpened(WindowEvent e){//evento de cuando la ventana se abre, se ejecuta el codigo de adentro del metodo
    
        System.out.println("ventana abierta");
    
    }
    
}