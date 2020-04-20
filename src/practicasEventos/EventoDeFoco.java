
package practicasEventos;
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

public class EventoDeFoco {//clase principal
   public static void main(String[]args){//metodo main
       MarcoFoco marco=new MarcoFoco();//instanciamos el marco creado
       marco.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);//cerramos el `programa cuando la ventana es cerrada
   } 
}
class MarcoFoco extends JFrame{//creamos el marco
    public MarcoFoco(){
        Toolkit mipc= Toolkit.getDefaultToolkit();//propiedades por defecto de nuestra pantalla
        Dimension acer=mipc.getScreenSize();//guardamo el tamaño en una variable de clase Dimension
        int x=acer.width;//ancho
        int y=acer.height;//alto
        setBounds(x/4, y/4, x/2, y/2);//damos un tamaño al marco
        add(new LaminaFoco());//agregamos la lamina
        setVisible(true);//volvemos visible el marco
    }
}
class LaminaFoco extends JPanel{//creamos una lamina donde crearemos los cuadros de texto
    @Override//sobreescribimos el metodo de JPanel
    public void paintComponent(Graphics g){//metodo sobreescrito
        super.paintComponent(g);//llamamos al metodo original para qur realize su funcion designada
        setLayout(null);//cambiamos el valor del layout a uno vacio
        boton1=new JTextField();////instanciamos la variable de tipo clase JTexfield
        boton2=new JTextField();//con los dos botones
        boton1.setBounds(120, 10, 150, 20);//damos tamaño y localizacion 
        boton2.setBounds(120, 50, 150, 20);//a los dos botones o campos
        add(boton1);//agregamos los botones a la lamina
        add(boton2);
        boton1.addFocusListener(new Foco());//agregamos el evento,,,con objetofuente/accion/clase que implementa la interfaz
    }
    JTextField boton1;//variable de clase
    JTextField boton2;//variable de clase
    
    private class Foco implements FocusListener{//clase interna la cual implenta la interfaz FocusListener
        @Override//sobreescribimos los metodos de la interfaz
        public void focusGained(FocusEvent e){//este metodo es para cuando el componente a ganado el foco
            
        }
        @Override
        public void focusLost(FocusEvent e){//este metodo es para cuando el componente a perdido el foco
            String email=boton1.getText();//en email guardamos el texto que se digite en el boton1
            boolean verificacion=false;//variable booleana 
            
            
            
            for(int i=0;i<email.length();i++){
                
                if(email.charAt(i)=='@'){//con charAt accedemos a ¡ cada una de las letras del texto y lonpodemos recorrer dentro del ciclo
                    verificacion=true;//si caracter es un @ la verificacion seria valida asi que le pasamos el true
                }
                
            }
                
                if(verificacion==true){//si la verifiacion es verdadera diremos que el correo ingresado es correcto
                    System.out.println("el correo ingresado es correcto");//resultados por consola
                }else{//sino ps el correo no sera valido
                    System.out.println("el correo ingresado no es valido");//resulatados por pantalla 
                
                
            }
            
        }
    }
}