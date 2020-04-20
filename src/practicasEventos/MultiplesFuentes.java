
package practicasEventos;
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import javax.swing.text.StyleConstants;

public class MultiplesFuentes {//clase principal
    public static void main(String []args){//metodo main
        MarcoM m=new MarcoM();//instanciamos el marco que hemos creado
        m.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);//cerramos el programa despuesde cerrar la ventana
    }
}
class MarcoM extends JFrame{//creamos el marco
    
    public MarcoM(){//constructor
    Toolkit mipc =Toolkit.getDefaultToolkit();//obtenemos las propiedades por defecto de nuestro dispositivo
    Dimension acer=mipc.getScreenSize();//obtenemos el tamaño 
    
    int x=acer.width;//obtenemos el ancho del pc
    int y=acer.height;//obtenemos el alto del pc
    
    setBounds(x/4,y/4,x/2,y/2);//damos la localizacion y tamaño de nuestra imagen
    add(new LaminaM());//agregamos la lamina 
    setVisible(true);//volvemos visible el marco
    }
    
}
class LaminaM extends JPanel{//creamos la lamina donde vamos a colocar los botones
    
    public  LaminaM(){//constructor de la lamina
       /* JButton amarillo=new JButton("amarillo");
        JButton azul=new JButton("azul");
        JButton rojo=new JButton("rojo");
        
        add(amarillo);
        add(azul);
        add(rojo);*/
        ImageIcon extraerImagen=new ImageIcon("C:\\Users\\JOZE RODRIGUEZ\\Pictures/descarga.jpg");//en esta parte configuramos la imagen ya que aparecera muy grande
        Image modificarImagen=extraerImagen.getImage().getScaledInstance(15, 15, 45);//al ya obtenerla la convertimaos en Image con el nuevo tamaño
        Icon icono=new ImageIcon(modificarImagen);//y la pasamos a tipo Icon la cual es una clase abstracta
        
        ColorM accionAmarillo=new ColorM("amarillo",new ImageIcon(modificarImagen),Color.YELLOW);//instanciamos la clase que hereda de abstract action
        ColorM accionAzul=new ColorM("azul",new ImageIcon(modificarImagen),Color.blue);//y le pasamos los parametros que hemos pedido
        ColorM accionRojo=new ColorM("rojo",new ImageIcon(modificarImagen),Color.red);//para construir el boton
        
        add(new JButton(accionAmarillo));//creamos el nuevo boton y la pasamos un argumento de tipo Action, la cual es como decir tambien abstractAction
        add(new JButton(accionAzul));
        add(new JButton(accionRojo));
        
        InputMap mapa=getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW);//1creamos el mapa,sera cuando esta la ventana enfocada
       // KeyStroke TeclaAmarilla=KeyStroke.getKeyStroke("ctrl A");//2.creamos la combinacion de teclas
        mapa.put(/*2*/KeyStroke.getKeyStroke("ctrl A"), "objeto_amarillo");//3. se puede crear tambien la combinacion de teclas dentro
        mapa.put(/*2*/KeyStroke.getKeyStroke("ctrl B"), "objeto_azul");//3.del metodo put de InputMap,y se lo asignamos a un objeto 
        mapa.put(/*2*/KeyStroke.getKeyStroke("ctrl R"), "objeto_rojo");//3.el cual nosotros nombramos dentro del metodo
        ActionMap mapaAccion=getActionMap();////4.debemos asiganar el objeto al metodo,usamos a la clase ActionMap para que nos devuelva la accion
        mapaAccion.put("objeto_amarillo", accionAmarillo);//4.con el metodo de ActionMap put(Object,Action)
        mapaAccion.put("objeto_azul", accionAzul);//4.la pasamos el objeto creado a la accion correspondiente
        mapaAccion.put("objeto_rojo", accionRojo);//4
        
        
        
        
    }

private class ColorM extends AbstractAction{//esta es la clase que realiza la accion y ademas es privada
    @Override
    public void actionPerformed(ActionEvent e){//constructor sobreescrito de AbstractAction,esta es la accion que se desencadenara
        Color color=(Color)getValue("color de fondo");//obtenemos el color con getValue el cual pasamos como parametro en el constructor de la presente clase
        setBackground(color);//y cada vez que pulsemos sobre el boton se pndra la lamina de un color u otro
        System.out.println("nombre: "+getValue(Action.NAME)+" descripcion: "+getValue(Action.SHORT_DESCRIPTION));//obtenemos el nombre del color y la descripcion del boton
    }
    public ColorM (String nombre,Icon icono,Color color_boton){//constructor de la clase
        
        putValue(Action.NAME, nombre);//poe medio de putValue guardamos la informacion que qeremos en este caso el nombre del color
        putValue(Action.SMALL_ICON,icono);//con variables de la clase Action las cuales son estaticas
        putValue(Action.SHORT_DESCRIPTION,"poner la lamina de color "+nombre);//descripcion para el boton
        putValue("color de fondo", color_boton);//creamos una variable "color fondo" y guardara lo que se almacene en color_boton
        
    }
}
}