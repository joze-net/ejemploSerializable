package DisposicionesYusoJTextField;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;



public class Desplegable {

  
    public static void main(String[] args) {//clase principal
        MarcoDesplegable marco=new MarcoDesplegable();//instanciacionde la clase del marco
        marco.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);//cerramos el programa cuando cerremos la ventana
    }
    
}
class MarcoDesplegable extends JFrame{//clase donde construimos el marco
    public MarcoDesplegable(){//constructor
        Toolkit mipc=Toolkit.getDefaultToolkit();
        Dimension pc=mipc.getScreenSize();
        int x=pc.width;
        int y=pc.height;
        
        setBounds(x/4,y/4,x/2,y/2);//posicion,tamaño
        setTitle("DESPLEGABLE");//titulo
        LaminaDesplegable lamina=new LaminaDesplegable();//instanciacion de la clase donde se creo la lamina
        add(lamina);//agregamos la lamina
        setVisible(true);//volvemos visible la lamina
    }
}
class LaminaDesplegable extends JPanel{//clase donde construimos la lamina
    public LaminaDesplegable(){//constructor
        setLayout(new BorderLayout());//establee¿cmos una disposicion
        JPanel lamina2=new JPanel();//creamos una segunda lamina debtro de la primera
        text=new JLabel("mi primer desplegable",JLabel.CENTER);//creamos una etiqueta
       
        JComboBox combo=new JComboBox();//creamos un menu o desplegable
        combo.addItem("serif");//agregamos items al combo
        combo.addItem("BOLD");//este metodo recibe por parametro un String
        combo.addItem("monospaced");
        combo.addItem("DIALOG");
        combo.setEditable(true);//con este metodo podemos hacer editable la casilla del comboBox,est ees un construcotr de JComboBox
        add(text,BorderLayout.CENTER);//agregamos el texto el la zona central de la lamina principal
        lamina2.add(combo);//agregamos el combo a la lamina2
        add(lamina2,BorderLayout.NORTH);//agregamos la lamina2 a la lamina principal y ademas la ponemos en la zona norte
        metodo(combo);//llamamos el metodo
    }
    private void metodo (JComboBox combo){//metodo que recibi¿e por parametro un JComboBox
        combo.addActionListener((ActionEvent e) -> {//ponemos el copmbo a la escucha,e implemtamos la interfaz ActionListener de esta forma
            //poniendo el objeto de tipo ActionEvent y la flecha , despues de ella colocamos la accion a desarrollar
            text.setFont(new Font((String)combo.getSelectedItem(),Font.PLAIN,14));//le cambiamos la fuente al texto de la etiqueta
            //el metodo getSelectedItem nos devuelve el Object SEeleccionado y le hacemos Un casting a String el cual sera el nombre de la fuente del texto
        });
    }
    private final JLabel text;//atributo etiqueta
}