package DisposicionesYusoJTextField;


import java.awt.*;
import javax.swing.*;
import javax.swing.event.*;

import javax.swing.text.Document;




public class CambiosJTexfield {//clase principal
    public static void main(String[]args){//metodo main
        Marco2 marco=new Marco2();//instanciamos el marco creado
        marco.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);//instruccion para cuando se cierre la ventana entonces acabar el programa
    }
}
class Marco2 extends JFrame{//clase para construir ael marco
    public Marco2(){//constructor
        Toolkit mipc = Toolkit.getDefaultToolkit();//obtenemos las propiedades poir defecto de nuestro pc
        Dimension hp=mipc.getScreenSize();//guardamos el tamaño de ña pantalla
        Image im=mipc.getImage("C:\\Users\\mary rodriguez .LAPTOP-AOMI5KS8\\OneDrive\\Imágenes\\fotos/llorando.jpg");//obtenemos una imagen de nuestros arc
        setIconImage(im);//establecemos la imagen
        int x=hp.width;//ancho de la pantalla
        int y=hp.height;//alto de la pantalla
        
        setBounds(x/4,y/4,x/2,y/2);//damos la posicion y tamaño de nuestra ventana
        setTitle("detectar cambio de texto");//damos un titulo a la ventana
        Lamina2 lam=new Lamina2();//instanciamos un pobjeto de la lamina creada
        add(lam);//agregamos la lamina
        setVisible(true);//damos visibilidad a la ventana
    }
}
class Lamina2 extends JPanel{//clase de donde creamos la lamina donde pondremos el campo de texto
    public Lamina2(){
        Oyente2 o=new Oyente2();//instanciacion de la clase oyente
        
        JTextField campo= new JTextField(20);//creamos el campo de texto
        add(campo);//agregamos el capmpo de texto
        Document doc=campo.getDocument();//obtenemos un documento a partir de lo que se escriba en el campo de texto y lo guardamos en la variable de 
        //tipo interfaz Document
        doc.addDocumentListener(o);//agregamos el evento(objetoFuente/accion/objetoOyente);
        
       
    }
}
class Oyente2 implements DocumentListener{//creamos la clase que sra la clase oyente
     //implementampos los metodos de la innterfaz
    @Override
    public void insertUpdate(DocumentEvent e) {//metodo para cuando se inserta texto
        System.out.println("has insertado texto");
    }

    @Override
    public void removeUpdate(DocumentEvent e) {//metodo para cuando de borra texto
        System.out.println("has borrado texto");
    }

    @Override
    public void changedUpdate(DocumentEvent e) {//metodo para cuando se le cambian las propiedades al texto
        
    }
    
}
