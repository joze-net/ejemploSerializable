package DisposicionesYusoJTextField;
import java.awt.*;
import javax.swing.*;

public class CirculoRadioButton {//clase principal
    public static void main(String []args){//metodo main
        MarcoRadio marco=new MarcoRadio();//instanciamos la clase donde creamos el marco
        marco.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);//cerramos el programa cuando cerremos la ventana
    }
}
class MarcoRadio extends JFrame{//clase donde creamos el marco
    public MarcoRadio(){//constructor
        Toolkit mipc=Toolkit.getDefaultToolkit();//obtenemos las propiedades por defecto del dispositivo
        Dimension port=mipc.getScreenSize();//obtenemos el tamaño de la pantalla
        int x=port.width;//ancho
        int y=port.height;//alto
        setBounds(x/4,y/4,x/2,y/2);//damos posicion y tamaño añ marco
        setTitle("opciones");//titulo del marco
        Image i=mipc.getImage("C:\\Users\\mary rodriguez .LAPTOP-AOMI5KS8\\OneDrive\\Imágenes\\fotos/llorando.jpg");//on¿btenemos una imagen de nuestro ordenador
        setIconImage(i);//establecemos la imagen al icono de la ventana
        LaminaRadio lam=new LaminaRadio();//agregamos la lamina contenedora de las dos laminas mas
        add(lam);//agregamos lalamina
        setVisible(true);//volovemos visible la lamina
                
    }
}
class LaminaRadio extends JPanel{//clase donde agregamos dos laminas y establecemos una dispocicion layout
    public LaminaRadio(){//constructor
       setLayout(new BorderLayout());//agregamos una disposicion layout
        LaminaRadio2 lam1=new LaminaRadio2();//agregamos la lamina 2
        add(lam1,BorderLayout.NORTH);//en la zona norte de la lamina prncipal
        LaminaRadio3 lam2=new LaminaRadio3();//agregamos la lamina3
        add(lam2,BorderLayout.CENTER);//en la zona central de la lamina principal
    }
}
class LaminaRadio2 extends JPanel{//clase donde creamos 3 botones de radio
    public LaminaRadio2(){
         ButtonGroup grupo=new ButtonGroup();//coon esta clase podemos agrupar los radioButton
        JRadioButton uno=new JRadioButton("uno",false);//uno de los constructore de JRadioButton es dar un nombre al boton y una boolean para marcar el radiobutton
        JRadioButton dos=new JRadioButton("dos",true);
        JRadioButton tres=new JRadioButton("tres",false);
        grupo.add(dos);//para agrupar debemos usar el objet instanciado de ButtonGroup y agregar uno por uno los radioButoton que necesitamos
        grupo.add(uno);
        grupo.add(tres);
        add(uno);//y tambien debemos con el metodo add agregar los radioButton
        add(dos);
        add(tres);
}
}
class LaminaRadio3 extends JPanel{//clase lamina donde creamos 2 radio botones y los agrupamos
    public LaminaRadio3(){
     
       
        ButtonGroup grupo2=new ButtonGroup();
       
        JRadioButton mas=new JRadioButton("Masculino",true);
        JRadioButton fem=new JRadioButton("Femenino",false);
        
        grupo2.add(mas);
        grupo2.add(fem);
        add(mas);
        add(fem);
}
}