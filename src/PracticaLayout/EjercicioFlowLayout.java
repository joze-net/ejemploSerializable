
package PracticaLayout;
import javax.swing.*;
import java.awt.*;

//Ejercicio de practica de FlowLayout solo comentare donde usemos lo nesesario para esto

public class EjercicioFlowLayout {//clase principal
    public static void main(String []args){
        MarcoLayout marco=new MarcoLayout();
        marco.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}
class MarcoLayout extends JFrame{//marco
    public MarcoLayout(){
        Toolkit mipc = Toolkit.getDefaultToolkit();
        Dimension acer=mipc.getScreenSize();
        
        int x=acer.width;
        int y=acer.height;
        
        setBounds(x/4, y/4, x/2, y/2);
        LaminaLayout lamina=new LaminaLayout();
        add(lamina);
        //FlowLayout c=new FlowLayout(FlowLayout.LEFT);//podemos hacer una instanciacion de FlowLayout y le podemos pasar por parametro una
        //constante de clase 
        lamina.setLayout(new FlowLayout(FlowLayout.LEFT,30,20));//o tambien podemos dentro del parametro del metodo setLayout perteneciente ala
        //clase container hacer directamente la instanciacion,EN EL METODO DE 3 PARAMETROS VA(ALINEACION,ESPACIO ENTRE COMPONENTES/ESPACIO DEL CONTAINER)
        //y esto lo hacenos dentro del marco usando el objeto creado apartir de la lamina donde se encuentran los botones
        setVisible(true);
    }
}
class LaminaLayout extends JPanel{//lamina
    public LaminaLayout(){
        JButton rojo=new JButton("rojo");
        JButton amarillo=new JButton("amarillo");
        JButton azul=new JButton("azul");
       
        
        add(rojo);
        add(amarillo);
        add(azul);
    }
}