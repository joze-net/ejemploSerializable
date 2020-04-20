
package DisposicionesYusoJTextField;
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

public class VerificarCorreo {

    
    public static void main(String[] args) {//clase principal
        
        Marco marco=new Marco();
        marco.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
    
}
class Marco extends JFrame{//creamos el marco
    public Marco(){//constructor
        Toolkit mipc=Toolkit.getDefaultToolkit();
        Dimension hp=mipc.getScreenSize();
        int x=hp.width;
        int y=hp.height;
        
        setBounds(x/4,y/4,x/2,y/2);//damos tamaño
        setTitle("cuadro de texto");//colocamos un tituko
        Lamina lam=new Lamina();//agregamos la lamina
        add(lam);
        setVisible(true);//la volvemos visible
    }
}
class Lamina extends JPanel{
    public Lamina(){//creamos la lamina en el constructor
        setLayout(new BorderLayout());//ingresamos una disposicion para colocar esta lamina en el norte
        JPanel lamina2=new JPanel();//creamos una segunda lamina dentro de la primera
        
        JLabel etiqueta=new JLabel("Email: ");//creamos una etiqueta que su texto sera email
        lamina2.add(etiqueta);//agregamos la etiquta a la segunda lamina
        texto=new JTextField(20);//creamos un campo de texto
        lamina2.add(texto);//lo agragamos a la segunda lamina
        verificacion=new JLabel("",JLabel.CENTER);//creamos otra etiquta donde saldra si el correo es correcto ono
        add(verificacion,BorderLayout.CENTER);//lo colocamos en el cntro
        JButton comprobar=new JButton("comprobar");//creamo un ¡boton de comprobacion
        lamina2.add(comprobar);//lo agregaos a la segunda lamina
        oyenteBoton o=new oyenteBoton();//inste¡anciamos la clase oyente
        
        comprobar.addActionListener(o);//agregamos el evento al boton de comproibar
        add(lamina2,BorderLayout.NORTH);//agreagmos la lmina2 a la lamina principal
        InputMap mapa=getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW);
        KeyStroke teclado=KeyStroke.getKeyStroke("ENTER");
        mapa.put(teclado, "start");
        ActionMap accion=getActionMap();
        accion.put("start", o);
    }

private class oyenteBoton extends AbstractAction{//clase oyente
    @Override
    public void actionPerformed(ActionEvent e){//sobreescribimos el metodo de ActionListener
        String text=texto.getText();//almacenamos lel texto que ingresen el el cuador de texto
        int correcto=0;//una variable para contabilizar las @
        
        for(int i=0;i<text.length();i++){//ciclo for para recorrer la cadena y contar cuantas @ se an infresado
            if(text.charAt(i)=='@'){//si es correcto el contador aumentara en 1
                correcto++;
            }
        }
        if(correcto!=1){//si ay 0 o mas de 1 @ entonces sera incorrecto
           verificacion.setText("incorrecto");
        }else{//sino pps sera valido
            verificacion.setText("correcto");
        }
        
    }
    
}
private JTextField texto;//atributo de clase
private JLabel verificacion;//atributo de clase
}
