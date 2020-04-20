
package PracticaLayout;
import javax.swing.*;
import java.awt.*;

public class FlowYborderLayout {//clase principal
    public static void main(String[]args){//metodo main
        MarcoDisposiciones marco=new MarcoDisposiciones();
        marco.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}
class MarcoDisposiciones extends JFrame{//clase para crear el marco
    public MarcoDisposiciones(){//constructor
        setTitle("2 disposiciones");//agregamos un titulo
        setBounds(200, 200, 600,300);//damos posicion  y tamaño
        
        LaminaDisposiciones lamina=new LaminaDisposiciones ();//instanciamos la primera lamina
        LaminaDisposiciones2 lamina2=new LaminaDisposiciones2 ();//instanciamos la segunda lamina
        //NOTA: ya que hemos agregado dos laminas,la primera tiene la clase FlowLayout y la segunda BorderLayout;al agregar los objetos
        //instanciados de estas laminas la segunda que agregaguemo machacara la primera y no aparecera.
        //asi que por ese motivo en el metodo add(agregamos la lamina,y posicionamos cada lamina en una lado del container con 
        //las variables estaticas de BorderLayout
        add(lamina,BorderLayout.NORTH);//una en la zona norte
        add(lamina2,BorderLayout.SOUTH);//otra en la zona sur
        setVisible(true);//volvevmos visible el marco
    }
}
class LaminaDisposiciones extends JPanel {//primera lamina donde ubicamos los botones con FlowLayout
      public LaminaDisposiciones(){//constructor
          setLayout(new FlowLayout(FlowLayout.LEFT));//colocamos los botones enn zona izq
          JButton amarillo=new JButton("Amarillo");//instanciamos lpos botones
          JButton azul=new JButton("azul");
          add(amarillo);//agregamos los botones
          add(azul);
      }
}
class LaminaDisposiciones2 extends JPanel{//lamina donde un'bicamos lpos botones por medip de BorderLayout
    public LaminaDisposiciones2(){//constructor
        setLayout(new BorderLayout());//agregamos el BorderLayout
        JButton rojo=new JButton("rojo");//creamos los botones
        JButton verde=new JButton("verde");
        JButton negro=new JButton("negro");
        add(rojo,BorderLayout.EAST);//agregamos los botones y le damos posicion a cada uno usando las variables estaticas
        add(verde,BorderLayout.NORTH);
        add(negro,BorderLayout.WEST);
        
    }
}