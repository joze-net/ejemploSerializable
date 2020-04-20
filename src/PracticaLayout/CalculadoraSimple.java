
package PracticaLayout;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class CalculadoraSimple {//clase principal
    public static  void main(String[]args){//metodo main
         MarcoCalculadora marco=new  MarcoCalculadora();//instanciamos el marco donde creamos sus propoedades
         marco.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);//cuando cerremos la ventana entonces cerramos la aplicacion 
    }
}
class MarcoCalculadora extends JFrame{//clase para construir el marco
    public MarcoCalculadora(){//constructor
        Toolkit mipc=Toolkit.getDefaultToolkit();
        Image imagenHomer=mipc.getImage("C:\\Users\\JOZE RODRIGUEZ\\Pictures/descarga.jpg");
        setIconImage(imagenHomer);
        setTitle("calculadora JR");
        setBounds(200,200,300,300);
        
        LaminaCalculadora lamina=new LaminaCalculadora();//instanciamos la lamina donde creamos la pantalla de la calculadora,y
        //donde tambien construimos la segunda lamina
        add(lamina);//agregamos la lamina
      //  pack();//=metodo perteneciente a la clase Window el cual hace que el marco se adapte a los compponentes que tenga dentro o layouts
        setVisible(true);//la volvemos visible
    }
}
class LaminaCalculadora extends JPanel{//clase donde construimos la lamina que tiene los botones
    public LaminaCalculadora(){//constructor
        borrarCero=true;//ya que esto se ejecutara solo una vez aqui le damos el valor de true a borrarCero para que entre en el if creado en la clase oyente
        setLayout(new BorderLayout());//almacenamos un nuevo border layout
        boton=new JButton("0");//creamos el boton que hara la funcion de pantalla
        add(boton,BorderLayout.NORTH);//este boton lpo colocamos en la zona norte de la lamina
        boton.setEnabled(false);//desactivamos el boton para qur no podamos pulsar en el y tenga la apariencias¡ de una pantalla 
        lamina2=new JPanel();//instanciamos la lamina 2
       
        add(lamina2,BorderLayout.CENTER);//agregamos la lamina2
        lamina2.setLayout(new GridLayout(4,5));//aqui agregamos la clase GridLayout y en el constructor le damos el nuemro de filas y columnas
        LeerBoton accionA=new LeerBoton();
        OperacionMat op=new OperacionMat();
        agregarBoton("1",accionA);//usamos el metodo creado para hacer los botones
        agregarBoton("2",accionA);//estos botones se pondran en la lamina ya que asi le indicamos enn el metodo agregarBoton(nombreTecla) 
        agregarBoton("3",accionA);
        agregarBoton("√",op);
        agregarBoton("CE",op);
        agregarBoton("4",accionA);  
        agregarBoton("5",accionA);
        agregarBoton("6",accionA);
        agregarBoton("+",op);
        agregarBoton("-",op);
        agregarBoton("7",accionA);
        agregarBoton("8",accionA);       
        agregarBoton("9",accionA);
        agregarBoton("/",op);
        agregarBoton("*",op);
        agregarBoton(".",accionA);
        agregarBoton("0",accionA);
        agregarBoton("%",op);
        agregarBoton("round",op);
        agregarBoton("=",op);
        Nentrada="=";//aqui inicialocamos la variable ci un =
        InputMap mapa=getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW);
        KeyStroke comand=KeyStroke.getKeyStroke("1");
        KeyStroke comand2=KeyStroke.getKeyStroke("2");
        KeyStroke comand3=KeyStroke.getKeyStroke("3");
        KeyStroke comand4=KeyStroke.getKeyStroke("4");
        KeyStroke comand5=KeyStroke.getKeyStroke("5");
        KeyStroke comand6=KeyStroke.getKeyStroke("6");
        KeyStroke comand7=KeyStroke.getKeyStroke("7");
        KeyStroke comand8=KeyStroke.getKeyStroke("8");
        KeyStroke comand9=KeyStroke.getKeyStroke("9");
        KeyStroke comand0=KeyStroke.getKeyStroke("0");
        KeyStroke comand00=KeyStroke.getKeyStroke(".");
        mapa.put(comand, "numero");
        mapa.put(comand2, "numero");
        mapa.put(comand3, "numero");
        mapa.put(comand4, "numero");
        mapa.put(comand5, "numero");
        mapa.put(comand6, "numero");
        mapa.put(comand7, "numero");
        mapa.put(comand8, "numero");
        mapa.put(comand9, "numero");
        mapa.put(comand0, "numero");
        mapa.put(comand00, "numero");
        ActionMap accion=getActionMap();
        accion.put("numero", accionA);
        /* KeyStroke comandMenos=KeyStroke .getKeyStroke("M");
        KeyStroke comandMas=KeyStroke .getKeyStroke("N");
        KeyStroke comandDividir=KeyStroke .getKeyStroke("D");
        KeyStroke comandMult=KeyStroke .getKeyStroke("P");
        KeyStroke comandporc=KeyStroke .getKeyStroke("C");
        KeyStroke comandIgual=KeyStroke .getKeyStroke("ENTER");
        mapa.put(comandMenos, "operador");
        mapa.put(comandMas, "operador");
        mapa.put(comandDividir, "operador"); 
        mapa.put(comandMult, "operador");
        mapa.put(comandporc, "operador");
        mapa.put(comandIgual, "operador");
        ActionMap acc=getActionMap();
        acc.put("operador", op);*/
        
    }
    private void agregarBoton(String nombreTecla,ActionListener oyente){//metodo el cual crea los objetos de tipo JButton y los agrega en la lamina2
        //y el parametro que recibe es para el nombre que le pongamos al boton cuando llamemos al metodo ej:agregarBoton("5");
       
        JButton boton=new JButton(nombreTecla);//INSTANCIAMOS EL OBJETO DE TIPO JButton
        boton.addActionListener(oyente);
        lamina2.add(boton);//agreagamos el boton a la lamina2
    }
    private class LeerBoton extends AbstractAction{
      @Override
      public void actionPerformed(ActionEvent e){
          if (borrarCero){//condicional para cambiar el valor de bpoton aeu funciona de pantalla
              boton.setText("");//cuando sea verdadero entonces se cambia el cero por una cadena vacia
              borrarCero=false;//y cambiamos el valor de borrarCero para que no se vuelva a entrar en el if
          }
          String entrada=e.getActionCommand();//esta accion nos permite retorner el valor de la cadena de comando,es decir el nombre de los botones
          boton.setText(boton.getText()+entrada);//setText es para almacenar el texto dentro de la variable boton
                                                 //getText es para que nos retorne el texto del boton pulsado
          
      }
}
    private class OperacionMat extends AbstractAction{//clase para los botones con operador
        @Override
        public void actionPerformed(ActionEvent e){//sobreescribimos el metpodo de la interfaz ActioListener
            
            borrarCero=true;//resetiamos el boton de pantalla
            calcular(Double.parseDouble(boton.getText()));//le pasamos como argumenot a este metodo un Double,asi que para ello 
           //obtenemos con botonGettext el String que se pulse y lo convertimos con DoubleParseDouble a Double 
            Nentrada=e.getActionCommand();//obtenemos mediante este metodo el boton de operador que se haya pulsado
            
           
        }
        public void calcular(Double n){ //dentro de este metodo realizamos todas la operaciones que hemos creado
            switch (Nentrada) {
                case "CE":
                    resultado=0;
                    break;
                case "+":
                    //si Nentrada es un + sumamos
                    resultado+=n;
                    break;
                case "-":
                    //restamos
                    resultado-=n;
                    break;
                case "*":
                    //multiplicamos
                    resultado*=n;
                    break;
                case "/":
                    //dividimos
                    resultado/=n;
                    break;
                case "=":
                    //y cuando sea igual entionces el resultado sera lo que se haya calculado
                    resultado=n;
                    break;
                case "&":
                    resultado%=n;
                    break;
                case "√":
                    resultado=Math.sqrt(n);//operador math para sacar la raiz cuadrada de un numero
                    break;
                case "round":
                    resultado=Math.round(n);//operador amth para sacar el entero mas cercano
                    break;
                default:
                    break;
            }
            
            boton.setText(""+resultado);//despues de ¡l condicional mostramos los resultados en boton el cual hace la funcion de pantalla
        }
    }
    private final JPanel lamina2;//variable para crear la lamina 2;
    private final JButton boton;//VARIABLE PRIVADA PARA LA CRECIONDEL BOTON QUE FUNCIONARA COMO PANTALLA
    private boolean borrarCero;//variable para que solo en la lamina tome un valor de true y cuado estp sea cierto se cambiara el 
    //valor de boton a cero y dentro de este if la valriable borrarCero sera False
    private double resultado;//variable para almacenar el resultado de ñlas operaciones
    private String Nentrada;//para almacenar el boton que hayamos pulsado
}