
package practicasEventos;
import javax.swing.*;
import java.awt.event.*;

public class EventoFocoVentana extends JFrame implements WindowFocusListener {//crearemos el marco y el evento dentro de una misma clase
    //usando los metodos
    public static void main(String[]args){//clase main
        
        EventoFocoVentana foco=new EventoFocoVentana();//instnacian¡mos un objeto de nustra clase
        foco.iniciar();//metodo que construye los marcos y agrega el evento
        
        
    }
    public void iniciar(){//metodo para crear dos ventanas
        marco1=new EventoFocoVentana() ;//ceamos el nuevo marco
        marco2=new EventoFocoVentana() ;//creamos un segindo marco
        marco1.setBounds(200, 400, 300, 300);//damos tamaño i locaclizacion
        marco2.setBounds(500, 400, 300, 300);
        marco1.setVisible(true);//volvemos visible los dos marcos
        marco2.setVisible(true);
        marco1.addWindowFocusListener(this);//agregamos el evento,,,,objetoFuente/tipoEvento/objetoOyente
        marco2.addWindowFocusListener(this);
        marco1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);//cuando se cierren las dos ventanas se termine el programa
        marco2.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
    }
    @Override
    public void windowGainedFocus(WindowEvent e){//metodo que se ejecuta cuando se ha ganado el foco
        
        
        if (e.getSource()==marco1){//con e.getSource obtenemos el origen del objeto fuente
            marco1.setTitle("yo tengo el foco");
        }else{
            marco2.setTitle("yo tengo el foco");
        }
        
    }
    @Override
    public void windowLostFocus(WindowEvent e){//metodo que se ejecuta cuando se a perdido el foco
        
        if (e.getSource()==marco1){
            marco1.setTitle("");
        }else{
            marco2.setTitle("");
        }
        
    }
    EventoFocoVentana marco1;//atributo de tipo clase EventoFocoVentana 
    EventoFocoVentana marco2;
}
