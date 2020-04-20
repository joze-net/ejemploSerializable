
package practicasInterfaz;
import java.awt.*;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Rectangle2D;

import javax.swing.*;

public class MarcoEstiloLetra {
    public static void main (String []args){
        
        MarcoStyle mimarco=new MarcoStyle();//instanciamos la clase donde creamos nuestars figuras y letras
        mimarco.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);//le decimos al programaq se termine cuando cerremos el frame
        mimarco.setVisible(true);//hacemos visible nnuestro objeto
    }
}
class MarcoStyle extends JFrame{//aqui creamos la ventana usando el JFrame
    private LaminaStyle s;
    public MarcoStyle(){//constructor
        Toolkit mipc= Toolkit.getDefaultToolkit();//por medio de Toolkit obtenemos o accedemos a nuestras propiedades de pc
        Dimension acer= mipc.getScreenSize();//en un objeto de tipo Dimension guardamos el tamaño de la pc usando el metodo getScreenSize
        int x=acer.width;//en una variable guardamos el ancho de nuestra pc
        int y=acer.height;//en una variable guardamos el alto de nuestra pc
        setSize(x/2,y/2);//el tamaño sera la mitad del alto y del ancho
        setLocation(x/4, y/4);//y de esta manera lo situamos en la mitad de nuestra pantalla
       
        LaminaFiguras lamina=new LaminaFiguras();//instanciamos un objeto de LaminaFiguras para mostrar lo creado en ella
        setBackground(SystemColor.activeCaptionText);//damos un color de fondo
        add(lamina);//y agragamos la lamina
     
         //cambiamos la imagen por defecto de java y colocamos la nuestra
        Image imagen=mipc.getImage("C:/Users/JOZE RODRIGUEZ/Pictures/descarga.jpg");//Image es una clase abstracta, dentro del metodo colcamos la ruta de la imagen
        setIconImage(imagen);//establecemos la imagen
    }
}
class LaminaStyle extends JPanel {//creamos la lamina esta en especifico es para poner escritura con fuentes
    @Override
    public void paintComponent(Graphics g){//sobreescribimos el metodo perteneciente ala clase Component
      //  super.paintComponent(g);//llamamos el metodo propio de paintComponent para que ejecute su respectivo codigo
        Graphics2D g2d=(Graphics2D)g;//hacemos el Casting ya que Graphics2  D no se puede instanciar directamoente ya que es una clase abstracta
        g2d.setFont(new Font("Arial",Font.ITALIC,20));//con el metodo setFontcambiamos el estilo de letra
        g2d.setPaint(new Color(29,117,120));//damos un color a la letra
        g2d.drawString("MIS FUENTES",100,100);//escribimos uestra cacdena
        Font fuente=new Font ("Century Gothic",Font.ROMAN_BASELINE,15);//
        //setPaint, y SetFont pertenecen a Graphics2D
        g2d.setPaint(Color.LIGHT_GRAY);
        g2d.drawString("Jose Rodriguez",100,140); 
        
        
    }
}
class LaminaFiguras extends LaminaStyle{//creamos otra lamina la cual heredara lo de la anterior lamina
    @Override
    public void paintComponent (Graphics g){//sobreescribios el metodo de JPanel
        super.paintComponent(g);
        Graphics2D g2d=(Graphics2D)g;//casting
        Rectangle2D rectangulo=new Rectangle2D.Double(100,200,100,100);//creamos el rectangulo
        g2d.setPaint(Color.BLUE);//damos color al rectangulo
        g2d.fill(rectangulo);//pintamos el interior de l crectangulo
        Ellipse2D elipse=new Ellipse2D.Double();//creamos una elipse
        g2d.setPaint(Color.BLACK);//damos color  l a elipse
        elipse.setFrame(rectangulo);//la elipse estara dentro de rectangulo
        g2d.fill(elipse);//dibujamos la elipse con color de fondo
        Rectangle2D rec1=new Rectangle2D.Double(300,85,200,217);//creamos un nuevo rectangulo
        g2d.setPaint(Color.YELLOW);//lo pintammos
        g2d.fill(rec1);//lo dibujamos con color de fondo
        int xR=(int)rec1.getX();//medidas del eje x de rec1
        int xY=(int)rec1.getY();//edidads del eje y de rec1
        
        Font fuente=new Font("Arial",Font.BOLD,20);//creamos una fuente
        g2d.setFont(fuente);//al macenamos la fuente
        g2d.setPaint(Color.RED);//damos color al fuente
        g2d.drawString("MI RECTANGULO",xR,xY);//colocamos nuestro escrito
    }
}
