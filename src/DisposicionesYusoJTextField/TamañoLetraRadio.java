package DisposicionesYusoJTextField;
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
public class TamañoLetraRadio {//clase principal
    public static void main(String[]args){//metodo ,main
    MarcoLe marco=new MarcoLe();//instanciaciond de la clase donde creamos el marco
    marco.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);//cerramos el programa
    
    }
}
class MarcoLe extends JFrame{//clase donde creamos el marco
    public MarcoLe(){//constructor
        
        setBounds(100,100,600,400);//tamaño
        setTitle("cambiar tamaño");//titulo
        LaminaLe lam=new LaminaLe();//instanciacionde la lamina
        add(lam);//agregamos el objeto lamina
        setBackground(Color.yellow);
        setVisible(true);//damos visibilidad a la lamina
    }
}
class LaminaLe extends JPanel{//clase donde creamos la lamina
    public LaminaLe(){//constructor
        
         setLayout(new BorderLayout());//le damos did¿sposicion boreder layout a la lamina en general
    texto=new JLabel("mi hobby es programar",JLabel.CENTER);//agregamos texto en una etiqueta y lo posicionamos en la zon central
    texto.setFont(new Font("serif",Font.PLAIN,14));//le damos una fuente para que sea por defecto del texto
    add(texto,BorderLayout.CENTER);//agregamos el texto a la lamina y lo colocamos en la zona ncentral
    JPanel lamina2=new JPanel();//creamos una lamina dentro de la lamina principal
    ButtonGroup grupo=new ButtonGroup();//creamos la clase para agrupar los botones de radio que vamos a utilizar
    boton1=new JRadioButton("pequeño");//botones de radio
    boton2=new JRadioButton("mediano",true);//a este radioboton le pasamos un true para que este marcado por defecto
    boton3=new JRadioButton("grande");
    boton4=new JRadioButton("muy grande");
    grupo.add(boton1);//agregamos los botones al grupo
    grupo.add(boton2);
    grupo.add(boton3);
    grupo.add(boton4);
    lamina2.add(boton1);//agregamos los botonse a la lamina 2
    lamina2.add(boton2);
    lamina2.add(boton3);
    lamina2.add(boton4);
    CambiarTamaño c=new CambiarTamaño();//instanciamos la clase oyente
    boton1.addActionListener(c);//creamo el evento(obj fuente,accion,obj oyente)
    boton2.addActionListener(c);
    boton3.addActionListener(c);
    boton4.addActionListener(c);
    add(lamina2,BorderLayout.SOUTH);//agregamios la lamina2 a la lamina principal
    }
    private class CambiarTamaño implements ActionListener{//clase oyente
        @Override//sobreescrobimos
        public void actionPerformed(ActionEvent e){//metodo de la interfaz ActionListener
            if(e.getSource()==boton1){//el metodo getSource nos devuelve cual fue el objeto fuente presionado y lo comparamos
               texto.setFont(new Font("serif",Font.PLAIN,10));//con los 4 botone creados para cambiar el tamaño de letra
            }else if(e.getSource()==boton2){
                texto.setFont(new Font("serif",Font.PLAIN,14));
            }else if(e.getSource()==boton3){
                texto.setFont(new Font("serif",Font.PLAIN,18));
            }else if(e.getSource()==boton4){
                texto.setFont(new Font("serif",Font.PLAIN,24));
                setBackground(Color.red);
            }
        }
    }
    private JRadioButton boton1,boton2,boton3,boton4;//variables de clase
    private JLabel texto;
}
