
package practicasInterfaz;
import java.awt.*;
import javax.swing.*;
import java.io.*;
import javax.imageio.ImageIO;

public class MarcoImagenMosaico {
   public static void main (String []args){
       
       MarcoMosaico marco=new MarcoMosaico();
       marco.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
       
   } 
}
class MarcoMosaico extends JFrame{
    public MarcoMosaico (){
        
        Toolkit mipc=Toolkit.getDefaultToolkit();//la clase Toolkit es para obtener las propiedades por defecto de nuestro dispositivo
        Dimension pantallaAcer=mipc.getScreenSize();//el pantallaAcer de tipo deimension guardamos el tamaño de la pantalla
        int x=pantallaAcer.width;//x es el ancho
        int y=pantallaAcer.height;//y es el ancho
        
        setBounds(x/4,y/4,x/2,y/2);//posicion luego tamaño
        LaminaMosaico lamina=new LaminaMosaico();//nstanciamos la lamina donde creamos nuestras figuras o dibujos
        add(lamina);//agregamos la lamina en nuestra ventana
        setVisible(true);//volvemos visible nuestra ventana
    } 
}
class LaminaMosaico extends JPanel {//creamos la lamina
    //creamos el constructor para tener una imagen ya cargade en memoria
    public LaminaMosaico (){
        File misArchivos=new File("C:\\Users\\JOZE RODRIGUEZ\\Pictures/descarga.jpg");//en un objetp tipo File guardamos la ubicacion de nuesra imagen
        
        try{//intenta
        imagen = ImageIO.read(misArchivos);//en la variable declarada y usando la clase ImageIO.read() guardamos la imagen
        }
        catch (IOException e) {//sino
            System.out.println("la imagen seleccionada no se encuentra");
        }
    }
    
    @Override//=sobreescribir
    public void paintComponent (Graphics g){//sobreescribimos el constructor de JPanel
        super.paintComponent(g);//llamamos el metodo original de JPanel
        
        int x=imagen.getWidth(this);//el ancho de la imagen
        int y=imagen.getHeight(this);//el alto de la imagen
        g.drawImage(imagen, 0, 0, x, y, this);//dibujamos la imagen(la imagen,la posicion,el tamaño,el observador)
        
        //un ciclo para para copiar la imagen que tenemos en toda la ventana
        for(int i=0;i<300;i++){//aqui contabilizamos las filas
            
            for(int j=0;j<200;j++){//aqui contabilizamos las columnas
                if(i+j !=0){//para no volver a colocar la imagen sobre la que ya tenemos creamos un condicional para que no nos la ponga donde ya la tenemos
                    g.copyArea(0,0, x, y, x*i, y*j);//copiamos el area de la imagen(coordenada donde se encuentra la imagen,tamaño ,distancia
                }
                    }
        }
        
        
    }
    private Image imagen;//variable tipo Image para almacenar la imagen
}