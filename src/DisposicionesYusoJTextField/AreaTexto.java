package DisposicionesYusoJTextField;
import java.awt.*;
import javax.swing.*;
import javax.swing.text.*;
import java.awt.event.*;

public class AreaTexto {//clase principal
    public static void main(String[]args){//metodo main
        Marcotexto marco=new Marcotexto();//instanciamos la clase que crea el marco
        marco.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);//accion para cerrar el progtama
    }
}
class Marcotexto extends JFrame{//clase donde creamos el marco
    public Marcotexto(){//constructor
         Toolkit mipc=Toolkit.getDefaultToolkit();
        Dimension hp=mipc.getScreenSize();
        int x=hp.width;
        int y=hp.height;
        
        setBounds(x/4,y/4, x/2, y/2);//damos tamaño
        setTitle("area de texto");//damos titulo
        Laminatexto lamina=new Laminatexto();//instanciamos la clase que contiene la lamina donde se a creado componentes
        add(lamina);//agregamos la lamina
        setVisible(true);// volvemos visible el marco
    }
} 
class Laminatexto extends JPanel{//clase donde creamos la lamina
    public Laminatexto(){//cionstructor
        areaTexto=new JTextArea(3,20);//creamos el area de texto de 3 filas y 20 columnas
        //add(areaTexto);
        areaTexto.setLineWrap(true);//con esto conseguimios que al acabar el numero de columns que le pasamos en el constructor debe de pasar a la next line
        JScrollPane barraNav=new JScrollPane(areaTexto);//con esta clase podemos implemtar barras de navegacion al componente que deseamos en este caso areaTexto
        add(barraNav);//agregamos el objeto que nos implementa las barras de navegacion
        JButton aceptar=new JButton("Aceptar");//creamos un boton de aCEPTAR para que cuando clokiemos nos arroje el texto por consola
        add(aceptar);//agregamos el boton a la lamina
        OyenteTexto o=new OyenteTexto();//instanciamos la clase oyente que lpo que hace es poner el texto por consola
        aceptar.addActionListener(o);//creamos el evento
        InputMap mapa=getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW);
        KeyStroke teclaEnter=KeyStroke.getKeyStroke("");//aun no tiene funcionalidad;
        mapa.put(teclaEnter, "acep");
        ActionMap accion=getActionMap();
        accion.put("acep", o);
    }

class OyenteTexto extends AbstractAction{//clase Oyente
    @Override
    public void actionPerformed(ActionEvent e){//sobreescribimos el metodo de actionListener
        System.out.println(areaTexto.getText());//mostramos el texto de areaTexto por consola
    }
}
private JTextArea areaTexto;//aributo de clase LaminaTexto
}
