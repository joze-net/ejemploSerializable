
package practicas;

import java.awt.GraphicsEnvironment;
import javax.swing.JOptionPane;
import sun.security.util.Length;


public class TipoLetra {
    public static void main(String []args){
        boolean confirmarFuente=false;
        String fuentes []= GraphicsEnvironment.getLocalGraphicsEnvironment().getAvailableFontFamilyNames();
        String nuevaFuente= JOptionPane.showInputDialog("Ingrese nombre de la fuente");
        for (int i = 0;i<fuentes.length;i++){
            
            System.out.println(fuentes[i]);
        
    }
        for (String fuentesDevice: fuentes){
            if(fuentesDevice.equals(nuevaFuente)){
                confirmarFuente=true;
            }
        }
        if(confirmarFuente){
            System.out.println("el dispositivo tiene la fuente "+nuevaFuente);
        }else{
            System.out.println("el dispositivo no tiene la fuente "+nuevaFuente);  
        }
    }
}
