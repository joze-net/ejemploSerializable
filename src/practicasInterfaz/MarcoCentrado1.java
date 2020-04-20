package practicasInterfaz;
import java.awt.Toolkit;
import javax.swing.*;
import java.awt.*;
    public class MarcoCentrado1 {
 public static void main (String []args){
     marcoCentrado miAcer = new marcoCentrado();
     miAcer.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
     
 }   
}

class marcoCentrado extends JFrame {
    
    public marcoCentrado(){
        Toolkit miPantalla=  Toolkit.getDefaultToolkit();//la clase Toolkit es una clase abstracta y usamos el metod getFefaultToolkit el cual nos da los pixeles de nuestro laptop
        //en si almacanamos en la variable miPantalla nnuestro sistema nativo de ventanas
        Dimension deMiPantalla = miPantalla.getScreenSize();//en la variable miPantalla de tipoi Dimension se almacna la resolucion de nuestro monitor
        //ya que en miPantalla de tipo toolkit se almaceno nuestro sistema nativo de ventanas
        int alto=deMiPantalla.height;//height es el alto de mi pantalla y es una variable declarada en la clase Dimension
        int ancho=deMiPantalla.width;//width se refiere al ancho de mi pantalla tambien declarada en la clase Dimension
        setSize(ancho/2,alto/2);//usamos el metodo setSize de la subclase JFrame para dar el tamaño de nuestra ventana
        setLocation(ancho/4,alto/4);//el metodo setLocation es heredado de JFrame el cual da la localizacion de la ventana que se ha creado
        setVisible(true);//co este  metodo lo que hacemos es hacer visible la ventana que creamos
        Image imagen= miPantalla.getImage("C:/Users/JOZE RODRIGUEZ/Pictures/descarga.jpg");//imagen es una variable de tipo Imagen la cual es una clase abstracta, aa la cual le damos
        //por valor el contenido de miPantalla de tipo Toolkit para con el metod getImage cambiar la imagen de la ventana
        setIconImage(imagen);//con este metodo establecemos el icono que esta almacenado en  la variable imagen
        setTitle("mi interfaz");//con este metodo cambiamos o ponemos titulo a nuestra interfaz
    }
    
}
