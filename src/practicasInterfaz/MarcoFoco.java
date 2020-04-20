
package practicasInterfaz;
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

public class MarcoFoco {
    public static void main(String[]args){
        
    }
}
class MarcoFoc extends JFrame{
    public MarcoFoc(){
        Toolkit mipc=Toolkit.getDefaultToolkit();
        Dimension acer=mipc.getScreenSize();
        
        int x=acer.width;
        int y=acer.height;
        
        setBounds(x/4, y/4, x/2, y/2);
        setVisible(true);
        
    }
}
/*class EventoFoco implements FocusListener{
    
}*/
