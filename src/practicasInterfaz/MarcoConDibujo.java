
package practicasInterfaz;

import javax.swing.*;
import java.awt.*;
import java.awt.geom.*;

public class MarcoConDibujo {
    public static void  main (String []args){
        MarcoDibujo marco=new MarcoDibujo();
        
        marco.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);//cerramos nuestro programa mejor dicho la ventana
    }
}//este es nuestro cuadro
class MarcoDibujo extends JFrame {//creamos nuestar ventana
    public MarcoDibujo(){
        setSize(600,600);//damos tamaño
        setLocation(200,100);//damos localizacion
        LaminaD miLamina=new LaminaD();
        add(miLamina);
        setVisible(true);//lo volvemos visible
    }
}
//esta es nuestra lamina
class LaminaD extends JPanel{
    //para crear una lamina para dibujar debemos sobreescribir el metodo paintComponent perteneciente a la clase Jcomponent y lo hereda JPanel
    @Override//con este podemos dibujar sobre nuestra lamina
    public void paintComponent(Graphics g){//recibe como parametro un objeto de tipo Graphics la cual es una clase
        super.paintComponent(g);//debemos tambien llamar el costructor original para ue este ejecute el codigo ue tiene diseñado mas nuestras instrucciones
        //g.drawRect(150, 100, 300, 300);//con este metodo estamos crendo un rectangulo los dos primeros valores  son para la posicion de la 
        //esquina superior izuierda,y las otras dos para el tamaño es decir el ancho y el alto
        
        Graphics2D g2d=(Graphics2D)g;//la clase Graphics2D es una clase abstracta la acual no puede crear objetos apartir de ella entonces recurrimos a la refundicion de datos
        Rectangle2D rect2d=new Rectangle2D.Double(200, 200,200,200);//la clase Rectangle 2D es una clase abstracta pero Recatangle2D.Double no lo es asi que podemos usar el principio de sustitucion de java
        g2d.draw(rect2d);//llamamos el metodo de la clase Graphiccs2D con el obj instanciado
        Ellipse2D elipse=new Ellipse2D.Double();//principio de sustitucion ya que se cumple la palabra ES UN 
        elipse.setFrame(rect2d);//con este metodo de Ellipse podemos utilizar las mismas medidas de nuestro rectangulo creado
        g2d.draw(elipse);//metodo para dibujar nuestro elipse
        Line2D linea=new Line2D.Double(200, 200, 400, 400);//creamos una linea
        g2d.draw(linea);//dibujamos la linea
        double centrox=rect2d.getCenterX();//variable para guardar el valor del centro de x en el rectangulo ue creamos
        double centroy=rect2d.getCenterY();//variable para guardar el valor del centro de y en el rectangulo ue creamos
        double radio=rect2d.getHeight();//guardamos en radio la altura del rectangulo creado
        Ellipse2D circle=new Ellipse2D.Double();//instanciamos el nuevo objeto
        circle.setFrameFromCenter(centrox,centroy,centrox+radio,centroy+radio);//colocamos las variables correspondientes
        g2d.draw(circle);//dibujamos el circulo
        g2d.drawString("mis figuras",1, 100);
                
    }
    
}
