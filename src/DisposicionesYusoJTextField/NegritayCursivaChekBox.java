package DisposicionesYusoJTextField;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;


public class NegritayCursivaChekBox {//clase principal
    public static void main(String[]args){//metodo Main
        MarcoCheck marco=new MarcoCheck();
        marco.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}
class MarcoCheck extends JFrame{//clase donde creamos el marco
    public MarcoCheck(){//constructor
        setBounds(200,200,500,400);
        Laminac lam=new Laminac();
        add(lam);
        setTitle("chekBox");
        setVisible(true);
    }
}
class Laminac extends JPanel{//creamos lalamna dentro de ella se han creado dos lamians mas
    public Laminac(){//constructor
        setLayout(new BorderLayout());//agregamos unadisposicion layout
         Font fuente=new Font("Arial",Font.PLAIN,24);//establecemos una fuente de letra(tipo de letra,negrita o cursiva,tamaño)
         
        texto =new JLabel("My family is the best");//creamos una etiqueta
        texto.setFont(fuente);//le agregamos la fuente a ala etiqueta
        
        JPanel lam2=new JPanel();//creamos la segunda lamina
        lam2.add(texto);//a esta lamina2 le agregamos la etiqueta con el texto
        add(lam2,BorderLayout.CENTER);//la lamina2 la posicionamos en la parte central de la lamina principal
        
        JPanel lam3=new JPanel();//creamos la terecra lamina
        ver1=new JCheckBox("NEGRITA");//agregamos las casillas de marcado
        ver2=new JCheckBox("CURSIVA");
        lam3.add(ver1);//agragamos las casillas a la lamina 3
        lam3.add(ver2);
        ActionListener a=new MarcarCasilla();//instanciamos objeto oyente
        ver1.addActionListener(a);//creamos el evento a los dos campos de marcado
        ver2.addActionListener(a);
        add(lam3,BorderLayout.SOUTH);//la lamina 3 la posicionamos en la zona sur dentro de la lamina principal
    }
    private class MarcarCasilla implements ActionListener{//clase oyente

        @Override
        public void actionPerformed(ActionEvent e) {//sobreescribimos el metodo de ActionListener
            int tipo=0;//variable local
            //la constante bond de la clase Font vale 1 y la Italic vale 2,por eso si se aumenta en uno la variable tipo entonces
            //cuando le pasemos por parametro al constructor de Font,en el medio establecera bien e¿sea BOND O ITALIC
            if(ver1.isSelected())tipo+=Font.BOLD;//si la csilla ver1 es seleccionada entonces isSelected devolvera un true y tipo aumentara vldra 1 ya que la variable estatica BOND vale 1
            if(ver2.isSelected())tipo+=Font.ITALIC;//si la csilla ver2 es seleccionada entonces isSelected devolvera un true y tipo aumentara vldra 2 ya que la variable estatica ITALIC vale 2
            texto.setFont(new Font("Arial",tipo,24));//cuando tipo vale 3 sera la fusion de las dos constantes y se pondra en cursiva y negrita
        }
        
    }
    private JLabel texto;//variabl para crear una lamina
    private JCheckBox ver1,ver2;//vriables para crear casillase de verificacion
}
