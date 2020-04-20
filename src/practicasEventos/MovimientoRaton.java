
package practicasEventos;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
        

public class MovimientoRaton {
  public static void main(String[]args){
      
      Marco marco=new Marco();
      marco.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      
  }
}
class  Marco extends JFrame{
    public Marco(){
        Toolkit mipc=Toolkit.getDefaultToolkit();
        Dimension acer=mipc.getScreenSize();
        
        int x=acer.width;
        int y=acer.height;
        
        setBounds(x/4, y/4, x/2, y/2);
        addMouseMotionListener(new DetecMoveRaton());
        setVisible(true);
    }
}
class DetecMoveRaton implements MouseMotionListener{//con esta interfaz detectamos cuando el raton esta en movimiento y cuando esta arrastrando
    @Override//pertenece al paquete java.awt.event
    public void mouseDragged(MouseEvent e){//con este detectamos de cuando se esta arrastrando un objeto
        System.out.println("estas arrastrando");
    }
    @Override
    public void mouseMoved(MouseEvent e){//con este detectamos de cuando esta en movimiento el raton
        System.out.println("te estas moviendo ");
    }
}