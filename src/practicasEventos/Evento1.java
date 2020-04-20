
package practicasEventos;
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
//aqui empiezo mis practicas con eventos
public class Evento1 {
    public static void main(String []args){
        MarcoConBoton mimarco=new MarcoConBoton();
        mimarco.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}
//implementamos el marco como se a venido haciendo
class MarcoConBoton extends JFrame{
        public MarcoConBoton(){
            
            Toolkit mipc=Toolkit.getDefaultToolkit();
            Dimension pantallaAcer=mipc.getScreenSize();
            int ancho=pantallaAcer.width;
            int alto=pantallaAcer.height;
            
            setBounds(ancho/4,alto/4,ancho/2,alto/2);//posicion luego tamaño
            
            LaminaBoton lamina=new LaminaBoton();
            add(lamina);
            
            setVisible(true);
            
            
        }
}
//creamos la lamina que hereda de JPanel e implementa la interfaz ActionEvent
/*un evento es cuando se desencdena una accion,para ello necesitamos 3 cosas que son: objeto fuente,el oyente

*/
class LaminaBoton extends JPanel implements ActionListener{
        
   
        JButton botonAzul=new JButton("azul");//creamos el boton con la clase JButton
        JButton botonAmarillo=new JButton("amarillo");
        JButton botonverde=new JButton("verde");
        
         public LaminaBoton(){//constructor, en donde agregamos los botones que hemos agregado
        
        add(botonAzul);//agregamos
        add(botonAmarillo);
        add(botonverde);
        
        botonAzul.addActionListener(this);//AQUI COLOCAMOS EL OBJETO FUENTE/el metodo addActionListener  que en si el eventoy luego(el oyente)
        botonAmarillo.addActionListener(this);
        botonverde.addActionListener(this);
        
     
    }
    @Override//implementaamos el metodo de la interfaz ActionListener
    public void actionPerformed(ActionEvent e){//el cual recibe de parametro un evento e
       Object ob=e.getSource();//este metodo nos devuelve cual es el objeto desencadenante de la accion
       //para poder crear el condicional y segun el boton que se cliquie lo convertimos en object
       //y se realizara la accion que le corresponde a cada boton
       if(ob==botonAzul){
            setBackground(Color.BLUE);
       }
       else if(ob==botonAmarillo){
           setBackground(Color.yellow);
       }else{
           setBackground(Color.GREEN);
       }
    }     
    
}
