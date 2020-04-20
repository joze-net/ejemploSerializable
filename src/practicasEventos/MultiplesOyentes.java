
package practicasEventos;
import javax.swing.*;
import java.awt.event.*;
/*breve resumen de este ejercicio:1creamos la clase principal con su correspondiente metodo main,en donde instanciamos la clase 
MarcoMo la cual es donde creamos nuestra primera ventana la  cual es la principal.
2.despues lo que hacemos es crear la lamina en la cual creamos los botones que iran en la ventana principal y esta ya ha sic¡do implentada
el la clase MarcoMo; y uno de los botones se a creado a partir de declararlo en la clase como un atributo ese es el boton cerrarTodo
3.en la lamina principal creamos una clase intena private CrearNuevo  y esta es un oyente que uasaremos para el boton de nuevo
que es para crear nuevas ventanas .
4.creamos el JFrame para crear las nuevas ventanas y le creamos tambien una clase interna la cual sera el oyente para el bon¡ton de cerrar
y su metodo lo ue hace es cerrar las ventanas con el metodo dispose()
*/
public class MultiplesOyentes {//CLASE PRINCIPAL
    public static void main(String[]args){
        MarcoMo marco=new MarcoMo();
        marco.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}
class MarcoMo extends JFrame{//clase para crear el marco prinicipal
    public  MarcoMo(){//constructor
        setBounds(550,150,300,300);
        LaminaPrincipal lamina=new LaminaPrincipal();
        add(lamina);
        setVisible(true);
        
    }
}
class LaminaPrincipal extends JPanel{//lamina para agregar los botones
    public LaminaPrincipal(){
        JButton nuevo=new JButton("NUEVO");//creamos un boton nuevo
        cerrarTodo = new JButton("CERRAR TODO");//a apartir de la variable de clase JButton creamos un nuevo boton
        add(nuevo);//agregamos el nuevo boton
        add(cerrarTodo);//y el segundo boton
        nuevo.addActionListener(new CrearNuevo());//creamos el evento,,,,(objetoFuente/accion/oyente)
    }
    private class CrearNuevo implements ActionListener {//clase interna que implementa la accion ,es decir este es el oyente
    @Override
    public void actionPerformed(ActionEvent e){//sobreescribimos el metodo de ActionListener
        MarcoNuevo nuevoMarco=new MarcoNuevo(cerrarTodo);//aqui creamos la nueva ventana,y este metodo nos pide un parametro de tipo JButton
        nuevoMarco.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);//y la cerramos
    }
}
    JButton cerrarTodo;
}
class MarcoNuevo extends JFrame{//clase para crear un marco aparte del marcoPrincipal
    public MarcoNuevo(JButton botonCerrarVentanasEmergentes){//constructor que recibe por parametro una vsriable de tipo JButton
        //la cual sera la del el boton de cerrar que aparece en el marco principal;y como dicah variable pertenerce a otra clase
        //entonces cuando hagamos la instanciacion en ka clase donde se encuentra el boton cerrar entonces se lo pasamos como parametro
        //y asi obtener esa objeto fuente para realizar la accion con el oyente OyenteCerrar
        contador++;//este es un contador ,, se ira incrementyando en 1,y es una variable estatica
        setTitle("lamina"+contador);//tittulo
        setBounds(50*contador,50*contador,300,200);//damos posicion y tamaño
        OyenteCerrar cerrarVentanas =new OyenteCerrar();//hacemos una instanciacion de la clase oyenteCerrar la cual coon su metodo 
        //dispose cerrara la ventanas que abramos con el boton de nuevo
        botonCerrarVentanasEmergentes.addActionListener(cerrarVentanas);//creamos el evento;objetoFuente/accion/objetoOyente
        setVisible(true);//volvemos visible el marco
    }
    private static int contador=0;

private class OyenteCerrar implements ActionListener{//oyente que creamos para el boton de cerrar 
    @Override
    public void actionPerformed(ActionEvent e){//sobreescribimos el metodo de ActionListener
        dispose();//metodo de Window que lo hereda JFrame,el cual lo que hace es obtemer las propiedades de la ventana  y cerrarlas
        contador=0;//inicialiacimos el contador en cero para cuando pulsemos el boton de cerrar se cierren la ventanas y tambien
        //si abrimos nuevemente ventanas empiecen a contar otravez desde 0.
    }
}   
}