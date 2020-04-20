package DisposicionesYusoJTextField;

import javax.swing.*;
import java.awt.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

public class SpinnerPersonalizado {//clase principal

    public static void main(String[] args) {//metodo main
        MarcoMiSpinner marco = new MarcoMiSpinner();
        marco.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

}

class MarcoMiSpinner extends JFrame {//clase donde creamos el marco

    public MarcoMiSpinner() {//constructor
        setBounds(100, 100, 600, 400);//damos tamaño añ marco
        setTitle("spinner personalizado");//damos titulo al marco
        LaminaMiSpinner lam = new LaminaMiSpinner();//instanciacion de la lamina
        add(lam);//agregamos la lamina al marco
        setVisible(true);//ponemos visible la lamina
    }
}

class LaminaMiSpinner extends JPanel {//clase deonde creamos la lamina

    public LaminaMiSpinner() {//constructor de la lamina
        /*aqui observamos un ejem´plo de una clase interna anonima, la cual usamos para crear un spinner para que funcione a nuestro mmodo
        lo mprimero que hacemos es construir el JSpinner llamado control luego en su constructor cremos un nuevo SpinnerNumberModel y en el constructor
        de este le pasamos(numero inicial,limite menor,limite mayor,de cuanto en cuanto aumentara) despues de este y dentro del constructor
        del JSpinner abrimos una llave{y aqui ponemos el codigo como si fuera una clase normal}
         */
        setLayout(new BorderLayout());
        texto=new JLabel("evento de mi spinner",JLabel.CENTER);
        
        add(texto,BorderLayout.CENTER);
        
        control = new JSpinner(new SpinnerNumberModel(2, 0, 10, 1) {
            @Override
            public Object getNextValue() {//aqui l0 que se hizo fue sobreescribir este metodo y retornar no el prox numero si no el anterior
                return super.getPreviousValue();//aqui lo que retorna es el nimero anterior
            }

            @Override
            public Object getPreviousValue() {//aqui pasa lpo contrrio en vez de que retorne el numero anterior retornara el numero proximo;es decir invertimos lpos dos metodos
                return super.getNextValue();
            }
        });
        control.addChangeListener(new ChangeListener(){
            @Override
            public void stateChanged(ChangeEvent ce) {
                texto.setFont(new Font("serif",Font.ITALIC, (int) control.getValue()));
            }
            
        });
        add(control,BorderLayout.NORTH);
    }
    //esta clase interna hace lo mismo que la clase interna anonima creada en el constructor del JSpinner
    /* private class CreandoSpinner extends SpinnerNumberModel{
        public CreandoSpinner(){
            super(2,0,10,1);
        }
        @Override
        public Object getNextValue(){
            return super.getPreviousValue();
        }
         @Override
        public Object getPreviousValue(){
            return super.getNextValue();
        }
    }*?*/
    private JSpinner control;
    private JLabel texto;
}
