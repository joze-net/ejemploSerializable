/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DisposicionesYusoJTextField;
import javax.swing.*;


public class CreacionMenu {//clase principal

 
    public static void main(String[] args) {//metodo main
        MarcoMenu marco = new MarcoMenu();//instanciacion de la clase donde creamos el marco
        marco.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);//cerrramos la aplicacion cuando cerremos la ventana
    }
    
}
class MarcoMenu extends JFrame{//clase donde creamo el marco
   public MarcoMenu(){//constructor
      setBounds(100,100,600,400);//damos tamaño al marco
      setTitle("mi primer menu");//damos un titulo al marco
      LaminaMenu lam=new LaminaMenu();//instanciacion de la clase donde creamos la lamina
      add(lam);//agregamos la lamina al marco principal
       setVisible(true);//le damos visibilidad a la lamina
}   
}
class LaminaMenu extends JPanel{//clase donde creamos la lamina y colocamos el menu
    public LaminaMenu(){//cinstructor
        JMenuBar barraMenu=new JMenuBar();//JMenuBar: es la base para colocar el menu
        JMenu archivo=new JMenu("Archivo");//JMenu: son las opciones que saldran en la barra de menu
        JMenu edicion=new JMenu("Edicion");//es decir en el JMenuBar
        JMenu configuraciones=new JMenu("Configuraciones");
        JMenu opciones=new JMenu("Opciones");
        
        JMenuItem nuevo=new JMenuItem("Nuevo");//JMenuItem: es lo que contendra los JMenu
        JMenuItem abrir=new JMenuItem("Abrir");
        JMenuItem cortar=new JMenuItem("Cortar");
        JMenuItem copiar=new JMenuItem("Copiar");
        JMenuItem pegar=new JMenuItem("Pegar");
        JMenuItem opcion1=new JMenuItem("Opcion1");
        JMenuItem opcion2=new JMenuItem("Opcion2");
        
        archivo.add(abrir);//a los JMenu les agregamos los JMenuItem
        archivo.add(nuevo);//a los JMenu les agregamos los JMenuItem
        edicion.add(cortar);//a los JMenu les agregamos los JMenuItem;
        edicion.add(copiar);//a los JMenu les agregamos los JMenuItem;
        edicion.add(pegar);//a los JMenu les agregamos los JMenuItem
        opciones.add(opcion1);//a los JMenu les agregamos los JMenuItem
        opciones.add(opcion2);//a los JMenu les agregamos los JMenuItem
        edicion.add(opciones);//a los JMenu les agregamos los JMenuItem
        barraMenu.add(archivo);//A LOS JMENUBAR LES AGREGAMOS LOS JMENU
        barraMenu.add(edicion);//A LOS JMENUBAR LES AGREGAMOS LOS JMENU
        barraMenu.add(configuraciones);//A LOS JMENUBAR LES AGREGAMOS LOS JMENU
        
        add(barraMenu);//LOS JMENUBAR los agregamos a la lamina ya con los menu creados
    }
}