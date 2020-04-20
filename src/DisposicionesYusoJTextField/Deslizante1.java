package DisposicionesYusoJTextField;
import java.awt.*;
import javax.swing.*;

public class Deslizante1 {

   
    public static void main(String[] args) {
       MarcoDeslizante marco=new MarcoDeslizante();
       marco.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      
    }
    
}
class MarcoDeslizante extends JFrame{
    public MarcoDeslizante(){
        Toolkit mipc=Toolkit.getDefaultToolkit();
        Dimension pc=mipc.getScreenSize();
        int x = pc.width;
        int y =pc.height;
        
        setBounds(x/4,y/4,x/2,y/2);
        setTitle("deslizante");
        LaminaDeslizante lam=new LaminaDeslizante();
        add(lam);
        
        setVisible(true);
    }
}
class LaminaDeslizante extends JPanel{
    public LaminaDeslizante(){
        JSlider des=new JSlider(0,200,30);
        //des.setInverted(true);//,metodo el cual invierte el dezlizante es decir si es 0,100 entonces sera 100,0
        des.setMajorTickSpacing(30);//esto es para colocar las lineas de separacion segun se lo indiquemos en el argumento
       
        des.setMinorTickSpacing(15);//con este metodo establecemos el espacio entre las lineas intermedias
        des.setPaintTicks(true);//con este metodo ponemos las lineas intermedias
        des.setPaintLabels(true);//con este metodo establecemos que coloque o no las etiquetas del deslizante
        des.setOrientation(JSlider.HORIZONTAL);//Con este metodo establecemos si queremos el slider vertical u horizontal
        des.setSnapToTicks(true);//con este metdo logramos un efecto iman,el cual lo que hace es colocar el botonslider en la linea mas cercana de donde se suelte
        //des.setPaintTrack(true);
        des.setFont(new Font("serif",Font.ITALIC,12));//le podemos establecer una fuente al deslizante
        add(des);
    }
}
