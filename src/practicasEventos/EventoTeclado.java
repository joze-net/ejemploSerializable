
package practicasEventos;
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

public class EventoTeclado {//clase principal
    public static void  main (String []args){
        MarcoTeclado marco=new MarcoTeclado();
        marco.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}
class MarcoTeclado extends JFrame{//creamos ela ventana
    public MarcoTeclado(){
        Toolkit mipc=Toolkit.getDefaultToolkit();
        Dimension acer=mipc.getScreenSize();
        
        int x=acer.width;
        int y=acer.height;
        
        setBounds(x/4, y/4, x/2, y/2);
        addKeyListener(new EventoT());//implentammos la clase oyente
        setVisible(true);
    }
}
class EventoT implements KeyListener{//clase donde pracricamos con eventos de teclado
    @Override//sobreescribimos los tres metodos de KeyListener
    public void keyPressed(KeyEvent e){//metodo de tecla presionada
       // int code=e.getKeyCode();
        //System.out.println(code);
    }
    @Override
    public void keyReleased(KeyEvent e){//metodo de cuando se suelta la tecla
        
    }
    @Override
    public void keyTyped(KeyEvent e){//metodo de cuando se presiona y suelta la tecla
        char letter=e.getKeyChar();
        System.out.println(letter);
    }
    
}