
package PracticaLayout;
import java.awt.BorderLayout;
import java.awt.FlowLayout;
import javax.swing.*;

public class EjercicioBorderLayout {
     public static void main(String[]args){
         MarcoBorderLayout marco=new MarcoBorderLayout();
         marco.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
     }
}
class MarcoBorderLayout extends JFrame{
    public MarcoBorderLayout(){
        setTitle("Disposicones");
        setBounds(300,200,600,300);
        LaminaBorderLayout lamina=new LaminaBorderLayout();
        add(lamina);
       
        setVisible(true);
    }
}
class LaminaBorderLayout extends JPanel{
    public LaminaBorderLayout(){
          
       // BorderLayout bord=new BorderLayout();
       // setLayout(bord);
        setLayout(new BorderLayout());//para esta clase la instanciamas dentro de la lamina donde estan los objetos que vamos
        //a ubicar dentro del container,ase que por medio de setLayout almacenamos el nuevo objeto de tipo borderLayout
        //lluego cuando agregamos los botones con el metodo add() perteneciente a la clase Container usamos las variables
        //estaticas de BorderLayout ya que este metodo nos permite ubicar el m¡boton donde deseamos
        
         JButton amarillo=new JButton("amarillo");
         JButton azul=new JButton("azul");
         JButton rojo=new JButton("rojo");
         JButton verde=new JButton("verde");
         JButton negro=new JButton("negro");
         add(azul,BorderLayout.NORTH);
         add(amarillo,BorderLayout.SOUTH);
         add(rojo,BorderLayout.EAST);
         add(verde,BorderLayout.WEST);
         add(negro,BorderLayout.CENTER);
    }
}