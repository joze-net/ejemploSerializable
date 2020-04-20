package DisposicionesYusoJTextField;
import javax.swing.*;
import java.awt.*;

public class ManejoSpinner {

   
    public static void main(String[] args) {
       MarcoSpinner marco=new MarcoSpinner();
       marco.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
    
}
class MarcoSpinner extends JFrame {
    public MarcoSpinner(){
        Toolkit mipc=Toolkit.getDefaultToolkit();
        Dimension pc=mipc.getScreenSize();
        Image imagen=mipc.getImage("C:\\Users\\mary rodriguez .LAPTOP-AOMI5KS8\\OneDrive\\Imágenes\\fotos\\llorando.jpg");
        setIconImage(imagen);
        int x=pc.width;
        int y=pc.height;
        
        setBounds(x/4, y/4, x/2, y/2);
        setTitle("mi spinner");
        LaminaSpinner lam=new LaminaSpinner();
        add(lam);
        setVisible(true);
    }
}
class LaminaSpinner extends JPanel{
    public LaminaSpinner(){
        
        //JSpinner opcion=new JSpinner(new SpinnerDateModel());//asi colocamos un Jspiner con opcion de seleccio  de fecha con SpinnerDateModel()
        String lista[]=GraphicsEnvironment.getLocalGraphicsEnvironment().getAvailableFontFamilyNames();
        /*en el array lista usamos la interface GraphicsEnviroment.un metodo de la interface getLocalGraphicsEnvironment().y getAvailableFontFamilyNames
        la cual devuelve un String las fuentes del pc*/
        JSpinner opcion=new JSpinner(new SpinnerListModel(lista));//asi colocamos con seleccion de una lista que hayamos creado con un array
        //esto lo hacemos con la clase SpinnerListModel
       // JSpinner opcion=new JSpinner(new SpinnerNumberModel(2, 0, 10, 1));//asi podemos colocar nueros reales o enteros colocando el¡n el constructor
        //de la clase SpinnerNumberModel(numero que saldra de promero,numero minimo limite,numero maximo limite,forma de contar ej: de 1 en 1 o 2 en 2 etc.
       Dimension size=new Dimension(150,20);//creamos el tamaño con la clase Dimension para pasarselo al constructor del metodo setPreferredSize(Dimnesion)
       //                            ancho/alto
        opcion.setPreferredSize(size);//le damos un tamaño nosotros al JSpinner con el metodo setPreferredSize(Dimension size);
        add(opcion);//agregamos el JSpinner a la lamina
    }
}
