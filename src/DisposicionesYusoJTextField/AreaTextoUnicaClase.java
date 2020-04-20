package DisposicionesYusoJTextField;

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

public class AreaTextoUnicaClase {//clase principal
    public static void main(String[]args){//metodo main
        MarcoClase marco=new MarcoClase();//instanciamos la clase donde creamos el marco
        marco.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);//cerramos elprograma cuando cerremos la ventana
    }
}
class MarcoClase extends JFrame{//en esta clase crearemos el marco y la lamina con sus componentes
    public MarcoClase(){//constructor
        setBounds(200, 200, 400, 300);//damos tamaño a la ventana
        setTitle("area de texto");//damos titulo al marco
        
        
        setLayout(new BorderLayout());//almacenamos una disposicion BorderLayout para ubicar las laminas
        lamina=new JPanel();//creamos la lamina
        texto=new JButton("texto");//creamos el boton que se encargara de poner texto en el area de texto
        texto.addActionListener(new ActionListener(){//agregamos el evento de tipo ActionListener,instanciandolo dentor del constructor de add
            @Override//tambien sobreescrin¿bimos el metodo dentro del constructor de add
            public void actionPerformed(ActionEvent e) {
                area.append("mi hijo es lo mejor...");//el metodo append lo que hace es colocar texto al final del otro,pertenece a la clase JTextComponent
            }
            
        });
        lamina.add(texto);//agregamos el boton tecto a la lamina
        espacio=new JButton("poner espacio");//creamos un boton el cuan¿l se encargara de poner o quitar espacios
        espacio.addActionListener(new ActionListener(){//el boton espacio esera el oyente  e instanciamos la accion de ntro del con¿structor de add
            @Override//sobreesecribimos el metodo de ActionListener
            public void actionPerformed(ActionEvent e) {
                boolean salto=!area.getLineWrap();//el metodo getLineWrap nps devuelve un boolean true=si hay espacio entre lines sino false;si es false
                //con el operador ! invertimos el valor a true y este sera el ´parametro de setLineWrap para colocar espacio con el boton
                area.setLineWrap(salto);//le pasamos la variable boolean salto por argumento
                
                /*if(salto){
                    espacio.setText("quitar espacio");
                }else{
                    espacio.setText("poner espacio");
                }*/
                espacio.setText(salto ? "quitar espacio" : "poner espacio");//OPERADOR TERNARIO: FUNCIONA PARECIDO A COMO LO HACE UN IF
                //CONSISTE EN DENTRO DE LOS PARENTESIS COLOCAR LA CONDICIO A EVALUAR CESPUES COLOCAR UN ? QUE ES DONDE TERMINA LA CONDICION
                //LUEGO VA LA INSTRUCCION QUE SE EJECUTA SI ES TRUE LUEGO PONEMOS : Y DESPUES VA LO QUE SE EJECUTAFRA SI ES FALSE
            }
            
        });
        lamina.add(espacio);//agregamos el boton de espacio a la lamina
        area=new JTextArea(50,50);//creamos un area de texto
        barra=new JScrollPane(area);//creamos unas barras de navegacion al area de texto
        add(barra,BorderLayout.CENTER);//agregamos las barra en el centro de la lamina
        add(lamina,BorderLayout.SOUTH);//agragamos la lamina con los botones en la parte sur de la ventana
        setVisible(true);//vovemos visible el marco
        
}
    private JPanel lamina;//variable para la lamina
    private JButton texto;//boton
    private JButton espacio;//boton
    private JTextArea area;//area de texto
    private JScrollPane barra;//barras de navegacion
}
