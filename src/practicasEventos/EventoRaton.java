
package practicasEventos;
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

public class EventoRaton {
    public static void main(String []args){
        MarcoRaton marco=new MarcoRaton();
        marco.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}
class MarcoRaton extends JFrame{//creamos el marco
    
        public MarcoRaton(){//constructor
        Toolkit mipc= Toolkit.getDefaultToolkit();
        Dimension acer=mipc.getScreenSize();

        int x=acer.width;
        int y=acer.height;

        setBounds(x/4,y/4,x/2,y/2);
        addMouseListener(new EventoDeRaton());//la clase marco es el oyente
        setVisible(true);       
    
    }
}
class EventoDeRaton implements MouseListener{//creamos la clase ue implementa MouseListener para los eventos de raton
    //en especifico a los eventops de clic,etc.para los eventos de movimiento de raton es la interfaz MouseMotionListener

    @Override
    public void mouseClicked(MouseEvent e) {//metodo ue detecta cuando damos clik con el raton 
        System.out.println("haz hecho un click");
    }

    @Override
    public void mousePressed(MouseEvent e) {//metpdp que detecta cuando solo mantenemos pulsadon o plusamos el raton
        System.out.println("as pulsado el raton");
    }

    @Override
    public void mouseReleased(MouseEvent e) {//metodo que detecta cuando soltamos el raton
        System.out.println("as soltado el raton");   
    }

    @Override
    public void mouseEntered(MouseEvent e) {//metodo que detecta cuando con el raton pasamos sobre un boton o ventana
        System.out.println("entraste a la ventana");
    }

    @Override
    public void mouseExited(MouseEvent e) {//metodo que detecta cuando con el raton salimos de la ventana o boton
        System.out.println("saliste de la ventana");
    }
    
}