
package practicasInterfaz;

import javax.swing.*;//importamos todas las clase del paquete javax.swing ya que contiene lo necesario para crear marcos

public class MiMarco {
    public static void main(String []args){
       
        Marco marco1=new Marco();//aqui instanciamos un objeto de la clase marco
        
        marco1.setVisible(true);//e/ metodo setVisible lo que es hacer visible la ventana creada dicho metodo es de la clase JFrame
        
        marco1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);//la instruccion set defaultCloseOperation pide un argumento que en este caso colocamos ExitONCLOSE que lo que hace es cerrar la ventana
       
    }
}
class Marco extends JFrame {//la clase Marco hereeda de JFrame todos sus metodos
    public Marco(){//constructor de la clase Marco
    //setSize(800,500);//podemos usar setSise perteneciente a la clase JFrame ya que sus metodos fueron heredados
    //setLocation(500,300);//con este metodo setter podemos cambiar la ubicacion de nuestra ventana,dichi metodo pertenece a la clase window
    setBounds(500,300,250,250);
    //setResizable(false);//este metodo nos sirve para decidir si se puede mover la ventana ono,ecibe un parametro booleano, y este es dl clase Frame del paquete awt
    setExtendedState(JFrame.MAXIMIZED_BOTH);//este metodo nos permite mostar la ventana maximizada, o de otra manera; y pertenece ala clase Frame del pauete awt
    }
}

