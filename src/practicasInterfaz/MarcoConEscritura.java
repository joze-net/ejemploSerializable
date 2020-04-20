
package practicasInterfaz;

import java.awt.Color;
import java.awt.Graphics;
import javax.swing.*;



public class MarcoConEscritura {
    public static void main (String []args){
        MarcoTexto miMarco=new MarcoTexto();//istanciamos nuestro marco
        miMarco.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);//decimos que realizara el programa despues de cerra el marco,que aqui lo que hacemos es terminar el programa
    }
    
}
class MarcoTexto extends JFrame{//creamos la clase donde crearemos nuestro marco el cual hereda de JFrame del paquete swing
    public MarcoTexto(){//creamos el constructor de la clase 
        setSize(1366/2,768/2);//damos tamaño al frame(cuadro)
        setLocation(1366/4,768/4);//damos la localizacion del cuadro
        setTitle("mi interfaz con texto");//damos titulo al cuadro
        setVisible(true);//volvemos visible el cuadro
        Lamina lam1=new Lamina();//insatnciamos el objeto de la clase donde creamos el panel o lamina
        add(lam1);//agregamos la lamina
    }
}
class Lamina extends JPanel {//creamos la clase lamina la cual hereda de JPanel el cual contiene lo necesario para crear laminas sobre nuestro frame
    @Override//sobreescribimos
    public void paintComponent (Graphics g){//sobreescribimomo el metodo paintComponent perteneciente a la clase JPanel en el cual podemos dibujar diferentes cosas
        super.paintComponent(g);//llamamos el constructor original para que ejecute su respectivo codigo
        g.drawString("Mi primer JPanel", 100,100);//el metodo drawString pertenece a la clase Graphics,en el cual colocamos texto y la posicion del texto
        g.drawLine(100,100,200,100);//este metodo lo coloque como practica desde la api de java,el cual dibuja una linea dentro del frame(cuadro)
        
        
    }
    
}