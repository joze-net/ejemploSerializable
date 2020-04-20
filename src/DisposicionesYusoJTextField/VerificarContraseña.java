package DisposicionesYusoJTextField;
import java.awt.*;
import javax.swing.*;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.text.Document;

public class VerificarContraseña {//clase principal
    public static void main(String[]args){//metodo main
        MarcoContraseña marco=new MarcoContraseña();//instanciamos la clase que contiene el marco creado
        marco.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);//al cerrar la ventana se termia el programa
    }
}
class MarcoContraseña extends JFrame{//clase donde creamos el marco
    public MarcoContraseña(){//metodo
        Toolkit mipc=Toolkit.getDefaultToolkit();
        Dimension hp=mipc.getScreenSize();
        int x=hp.width;
        int y=hp.height;
        
        setBounds(x/4,y/4, x/2, y/2);//damos tamaño
        setTitle("caracteres de contraseña");//damos titulo
        LaminaContraseña lam=new LaminaContraseña();//instanciamos la clase donde se a creafo la lamina
        add(lam);//agrega,os la lamina
        setVisible(true);//volvemos visible el marco
    }
}
class LaminaContraseña extends JPanel{//clase donde creamos la ,amina
    public LaminaContraseña(){//constructor
        setLayout(new BorderLayout());//agrgamos la disposicion BorderLayout a ña ñamina principal
        JPanel lamina2=new JPanel();//creamos una segub¿nda lamina dentro de la primer lamina
        lamina2.setLayout(new GridLayout(2,2));//a la segunda lamina le damos la dispisicion de GridLayout de 2*2
        JLabel usuario=new JLabel("usuario");//creamos la etiqueta para usuario
        lamina2.add(usuario);//agregamos la etiqueta de usuario
     
        JTextField c_usuario=new JTextField(20);//agregamos el campo de texto para ingresar el usuario
        lamina2.add(c_usuario);//agregamos el capmo de texto de uduario
        JLabel contraseña=new JLabel("Password");//creanos la etiqueta de contraseña
        lamina2.add(contraseña);//agegamos la etiqueta contraseña
         c_contraseña=new JPasswordField(20);//agregamos el campo para ingresar conraseña
         OyentePassword o=new OyentePassword();//instanciamos la clase oyente
         Document d=c_contraseña.getDocument();//obtenemos el documento del campo de texto de la contraseña
         d.addDocumentListener(o);//creamos el evento DocumentListener
        lamina2.add(c_contraseña);//agregamos el campo de la contraseña
        JButton enviar=new JButton("ENVIAR");//agregamos un boton de enviar
        add(enviar,BorderLayout.SOUTH);//este boton lo pondremos en la lamina principal es la parte sur
        add(lamina2,BorderLayout.NORTH);//la segunda la lamina la agregamos a la lamina principal y la colocamos aen la zona norte
    }

private class OyentePassword implements DocumentListener{//creamos la clase oyente

    @Override
    public void insertUpdate(DocumentEvent e) {//cuando se inserta texto
       char [] con;//variable de tipo array char
       con=c_contraseña.getPassword();//getPasworrd devuelve un array char asi que lo guardamos en con
       
       if(con.length<8 || con.length>12){//si su longitud es menor a 8 o mayor a 12 el texto aparecera en rojo
           c_contraseña.setBackground(Color.red);
       }else{//ce lo contrario sera blanco
           c_contraseña.setBackground(Color.WHITE);
       }
    }

    @Override
    public void removeUpdate(DocumentEvent e) {//cuando borramos tambien analizara la cantidad de caracteres del texto
       char [] con;
       con=c_contraseña.getPassword();
       
       if(con.length<8 || con.length>12){
           c_contraseña.setBackground(Color.red);
       }else{
           c_contraseña.setBackground(Color.WHITE);
       }
    }

    @Override
    public void changedUpdate(DocumentEvent e) {
        
    }
    
}
private final JPasswordField c_contraseña;//atributo de clase LaminaContraseña
} 
