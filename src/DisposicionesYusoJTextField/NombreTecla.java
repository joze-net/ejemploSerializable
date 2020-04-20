package DisposicionesYusoJTextField;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class NombreTecla {
    public static void main(String[]args){
        Marco1 mimarco=new Marco1();
        mimarco.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}
class Marco1 extends JFrame{
    public Marco1(){
        Toolkit mipc=Toolkit.getDefaultToolkit();
        Dimension hp=mipc.getScreenSize();
        int x=hp.width;
        int y=hp.height;
        setTitle("nombre key");
        setBounds(x/4,y/4,x/2,y/2);
        Lamina1 lamina=new Lamina1();
        add(lamina);
        setVisible(true);
        
    }
}
class Lamina1 extends JPanel{
    public Lamina1(){
        JTextField campo=new JTextField(20);
        add(campo);
        Evento ev=new Evento();
        campo.addKeyListener(ev);
    }
}
class Evento implements KeyListener{

    @Override
    public void keyTyped(KeyEvent e) {
        
    }
        

    @Override
    public void keyPressed(KeyEvent e) {
        System.out.println(e.getKeyChar());
        System.out.println(e.getKeyCode());
    }

    @Override
    public void keyReleased(KeyEvent e) {
        
    }
    
}