package DisposicionesYusoJTextField;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

public class TamañoLetraRadio2 {//clase principal
 public static void main(String[]args){//metodo main
     MarcoC marco=new MarcoC();
     marco.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
 }   
}
class MarcoC extends JFrame{//clase para crear el marco
    public MarcoC(){
        setBounds(20,20,400,300);
        setTitle("tamaño letra2");
        LaminaC lam=new LaminaC();
        add(lam);
        setVisible(true);
    }
}
class LaminaC extends JPanel{//clase donde creamos la alamina
    public LaminaC(){//constrcutor
        setLayout(new BorderLayout());//colocamos la dispocicion BorderLayout para la lamina principal
        texto=new JLabel("me gusta programar",JLabel.CENTER);//agregamos una etiqueta y laubicamos en elcentro de la lamina
        texto.setFont(new Font("serif",Font.PLAIN,14));//le damos una fuente al texto de ña etiqueta
        add(texto,BorderLayout.CENTER);//agregamos el texto a la lamina y lo coolocamos en la zona central de ella
        grupo=new ButtonGroup();//creamos la variable para unor los botones
        lamina2=new JPanel();//instanciamos la lamina2
        add(lamina2,BorderLayout.SOUTH);//agregamos la lamina 2 en la zona sur de la lamina principal
        cambiarTexto("pequeño",false,10);//llamamos el metodo donde creamos los botones,los agrupamos,los añadimos a la lamina my los ponemos a la escucha de un evento
        cambiarTexto("mediano",true,14);//nos pide pasarle de argumentos un String que es para el nombre del boton
        cambiarTexto("grande",false,20);//un booolean que es para si es marcado o no por defecto el boton
        cambiarTexto("muy grande",false,30);//y un entero que es para el tamaño de letra en el constructor de Font()
        
    }
    public void cambiarTexto(String nom,boolean select,final int n){//metodo para construir botones,AGRUPARLOS,añadorlos a la lamina y ponerlos a la escucha
        JRadioButton boton=new JRadioButton(nom,select);//instanciamos el boton y le pasamos por parametro el nom que sera el nombre del boton y select 
        //que sera siel boton es marcado por defecto ono
        
        grupo.add(boton);//agregamos el boton al grupo
        boton.addActionListener(new ActionListener(){//ponemos a la escucha el boton y creamos dentro la accion
            @Override
            public void actionPerformed(ActionEvent e) {
                texto.setFont(new Font("serif",Font.PLAIN,n));//el cambio se vera reflejado en el tamaño de letra ya que 
                //cada vez que se llama el constructor le pasaremos diferente numero entero
            }
        
    });
        lamina2.add(boton);//por ultimo dentro de eswte metodo agregamos el boton a la lamina
    }
    private JLabel texto;//atributo etiqueta
   
    private JPanel lamina2;//atributo container
    private ButtonGroup grupo;//atributo para agrupar botones
}