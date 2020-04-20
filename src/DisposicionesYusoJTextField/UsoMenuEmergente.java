
package DisposicionesYusoJTextField;
import javax.swing.*;

public class UsoMenuEmergente {

   
    public static void main(String[] args) {
        MarcoEmergente marco=new MarcoEmergente();
        marco.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
    
}
class MarcoEmergente extends JFrame{
    public MarcoEmergente(){
        setBounds(10, 10, 600, 300);
        setTitle("MENU EMERGENTE");
        add(new LaminaEmergente());
        setVisible(true);
    }
}
class LaminaEmergente extends JPanel{
    public LaminaEmergente(){
        JPopupMenu menuEmergente=new JPopupMenu();
        JMenu configuracion=new JMenu ("configuracion");
        JMenuItem opcion1=new JMenuItem("opcion1");
        configuracion.add(opcion1);
        menuEmergente.add(configuracion);
        setComponentPopupMenu(menuEmergente);
        add(menuEmergente);
        
    }
}