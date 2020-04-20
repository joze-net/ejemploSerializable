package DisposicionesYusoJTextField;
import javax.swing.*;
import java.awt.*;
import javax.swing.event.*;

public class EventoconJSlider {//clase principal

    
    public static void main(String[] args) {//metodo main
      MarcoDeslizanteEvento marco=new MarcoDeslizanteEvento();
      marco.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
    
}
class MarcoDeslizanteEvento extends JFrame{//creamos un marco
    public MarcoDeslizanteEvento(){
        setBounds(40, 40, 600, 400);
        setTitle("aumentar tamaño con deslizante");
        LaminaDeslizanteEvento lam=new LaminaDeslizanteEvento();//instanciamoas la lamina
        add(lam);//agregamos la lamina
        setVisible(true);//ponemos visible la lamina
    }
}
class LaminaDeslizanteEvento extends JPanel{//clase de la lamina
    public LaminaDeslizanteEvento(){//constructor
        setLayout(new BorderLayout());//establecemos una disposicion layout
        texto=new JLabel("cambiando tamaño de letra",JLabel.CENTER);//creamos una etiqueta con texto
        texto.setFont(new Font("serif",Font.ITALIC,12));//le damos una fuente al texto
        JPanel lam2=new JPanel();//creamos una segunada lamina dentro de la primera
        add(texto,BorderLayout.CENTER);//agregamos el texto en la zona central de la lamina principal
        
        deslizante=new JSlider(8,50,12);//creamos el JSlider,(punto de inicio,punto de fin,posicion del marcadpor)
        deslizante.setMajorTickSpacing(20);//espacio entre las lineas mayores
        deslizante.setMinorTickSpacing(5);//espacio entre las lineas menores
        deslizante.setPaintLabels(true);//agregamos los numeros de las lineas mayores
        deslizante.setPaintTicks(true);//establecemos o pintamos las lineas menores y mayores
        EventoDeslizante evento=new EventoDeslizante();//instanciamos la clase oyente
        deslizante.addChangeListener(evento);//ponemos a la escucha es deslizante
        lam2.add(deslizante);//agregamos el deslizante a la lamina2
        add(lam2,BorderLayout.NORTH);//la lamina 2 la ponemos en la zona norte de la lamina principal
    }
    private JLabel texto;//variable para una etiqueta con texto
    private JSlider deslizante;//variable para un deslizante

private class EventoDeslizante implements ChangeListener{//creamos la clase oyente
    @Override//sobreescribimos
    public void stateChanged(ChangeEvent e){//cambipo de estado
        texto.setFont(new Font("serif",Font.ITALIC,deslizante.getValue()));//establecmos la fuente y aqui lo que va a variar
        //es el tamño de la letra, para ello con el metodo getValue de la clase JSlider obtenemos la ubicacion
        //de donde esta el marcador del deslizante co¿uando se mueve y asli ese valor se convertira en el tamaño de la letra
    }
}
}
