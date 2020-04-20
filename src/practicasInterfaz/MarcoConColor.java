
package practicasInterfaz;
import javax.swing.*;
import java.awt.*;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Rectangle2D;

public class MarcoConColor {
   public static void main (String [] args) {
    VentanaColor ventana=new VentanaColor(); 
    ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
   }
}
class VentanaColor extends JFrame {
    public  VentanaColor (){
        setSize(600,300);
        setLocation(200,200);
        Laminas lamina=new Laminas();
        add(lamina);
        setVisible(true);
        setBackground(SystemColor.window);
        Toolkit archivos= Toolkit.getDefaultToolkit();
        
        Image imagen=archivos.getImage("C:/Users/JOZE RODRIGUEZ/Pictures/descarga.jpg");
        setIconImage(imagen);
    }
}
class Laminas extends JPanel{
    @Override
    public void paintComponent(Graphics g){
        Graphics2D g2d=(Graphics2D)g;
        Rectangle2D rectangulo=new Rectangle2D.Double(200,40,200,200);
        g2d.setPaint(Color.BLUE);
        g2d.fill(rectangulo);
        g2d.setPaint(Color.YELLOW);
        g2d.draw(rectangulo);
        
        Ellipse2D elipse=new Ellipse2D.Double();
        g2d.setPaint(Color.RED);
        elipse.setFrame(rectangulo);
        g2d.fill(elipse);
        g2d.setPaint(Color.WHITE);
        g2d.draw(elipse);
                
    }
}