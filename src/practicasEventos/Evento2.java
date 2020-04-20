
package practicasEventos;
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

public class Evento2 {
    public static void main(String []args){
        Marcoboton2 mimarco=new Marcoboton2();
        mimarco.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}
class Marcoboton2 extends JFrame{//creamos nuestro marco que hereda de JFrame para poder crearlo
    public Marcoboton2(){//constructor
        Toolkit miPantalla=Toolkit.getDefaultToolkit();
        Dimension acer=miPantalla.getScreenSize();
        int x=acer.width;
        int y=acer.height;
        
        setBounds(x/4,y/4,x/2,y/2);
        
        Laminaboton lamina=new Laminaboton();
        add(lamina);
        
        setVisible(true);
    }
}
class Laminaboton extends JPanel {//creamos la  lamina donde dibujaremos los botones
    
    JButton azul=new JButton("azul");//creamos boton azul
    JButton amarillo=new JButton("amarillo");//creamos boton amarillo
    JButton rojo=new JButton("rojo");//creamos boton rojo
    
    public Laminaboton(){//constructor para qgregar nuestros botones
        add(azul);//agregamosboton azul
        add(amarillo);//agregamos boton amarillo
        add(rojo);//agregamos boton rojo
        
        ColorFondo blue=new ColorFondo(Color.BLUE);//instanciamos de la clase ColorFondo los objetos que implementan la interfaz ActionListener
        ColorFondo red=new ColorFondo(Color.red);//para asi colocoralos de oyentes que esperan la instruccion
        ColorFondo yellow=new ColorFondo(Color.yellow);//en el cual en el argumento va el color
        
        azul.addActionListener(blue);//objetoFuente/accion/oyente
        amarillo.addActionListener(yellow);
        rojo.addActionListener(red);
    }
    private class ColorFondo implements ActionListener{//en esta clase interna manipularemos los colores que se pondran en la lamina
        
        public ColorFondo(Color c){//constructor donde inicializamos la variable colorFondo de tipo Color
            colorFondo=c;//c es el color que pasamos en el argumento en la clase externa
        }
        
        @Override
        public void actionPerformed(ActionEvent e){//sobreescribimos el metodod de la interfaz
            setBackground(colorFondo);//aqui pintamos la lamina con el color ue haya sido seleccionado
        }
        
        private final Color colorFondo;//atributo
        
    }
}