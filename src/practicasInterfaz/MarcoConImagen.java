 
package practicasInterfaz;
import java.awt.*;
import javax.swing.*;
import java.io.*;
import javax.imageio.*;

public class MarcoConImagen {//case principal
    public static void main (String []args){//metodo main
        Ventana vent=new Ventana();//instanciamos la ventana creada
        vent.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);//cerramos el programa despues de cerrar  la ventana
    }
    
}
class Ventana extends JFrame{//creamos la Clase Ventana pra crearla
    public Ventana(){//constructor
        Toolkit mipc=Toolkit.getDefaultToolkit();//obtenemos los defectos de fabrica de nuestra pc
        Dimension acer=mipc.getScreenSize();//obtenemos el tamaño de nuestara pantalla y lo guardamos en una variable tipo dIMENSION
        int x=acer.width;//ALMACENAMOS EL ANCHO
        int y=acer.height;//almacenamos el alto
        setBounds(x/4,y/4,x/2,y/2);//reducimos setSize y setLocation en un solo metodo
        
        Image img=mipc.getImage("C:/Users/JOZE RODRIGUEZ/Pictures/descarga.jpg");//cambiamos el icono 
        setIconImage(img);//lo colocamos
        
        LaminaImagen inputImage=new LaminaImagen();//instanciamos la lamina de imagen
        add(inputImage);//la agregamos
        
        setVisible(true);//la volvemos visible
    }
}
class LaminaImagen extends JPanel{//creamos la lamina de pintura o domde vamos a dibujar
    @Override//sobreescribimos
    public  void paintComponent(Graphics g){
        
        super.paintComponent(g);//llamamos el constructor original de JPanel
        //con la clase File y su metodo colocamos la ruta de donde se encuentra nuestra imagen
        File misImagenes=new File("C:\\Users\\JOZE RODRIGUEZ\\Pictures/descarga.jpg");
        
        //aqui almacenamos en nuestra variable imagen la imagen de File,por medio de ImageIO.read() la lee y almacena
        //qui se reuiere el uso de exepciones
        try{//=intenta
        imagen=ImageIO.read(misImagenes);
        }catch(IOException e){//se ejecutara este codigo si no se encuentra la imagen
            System.out.println("la imagen no se encuentra");
        }
        
        g.drawImage(imagen, 10,10,640,320,null);//con el objeto creado apartir de Graphics usamos el metodo drawImage para colocar nuestra imagen
        Font fuente = new Font("Agency FB", Font.ITALIC,20);
        g.setFont(fuente);
        g.drawString("HOMER.J SIMPSON",500,50);
    }
    private Image imagen;//variable de clase
}
