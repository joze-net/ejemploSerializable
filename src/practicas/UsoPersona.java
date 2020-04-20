
package practicas;

import java.util.Date;
import java.util.GregorianCalendar;

//en este archivo esta presente el polimorfismo, enlazado dinamico,clase abstracta
public class UsoPersona {
    public static void main (String  []args ){
        Persona p[]=new Persona[2];//arreglo del tipo variable objeto Persona
        
        p[0]=new Alumno("Ange david","Educacion fisica");//en esta posicion se ejecuta el objeto de la clase alumno
        p[1]=new Empleado2("Jose Rodriguez",200,02,03,2019);//e esta posicion se ejecuta el objeto de la clase Empleado2
        
        for(Persona ver:p){//for  each para ver los datos de los objetos creados
            System.out.println(ver.getNombre()+", "+ver.getDescripcion());//getDescripcion devuelve resultado diferente dependiendo del objeto de la clase
        }
    }
}
abstract class Persona {//clase abstracta
    
    public Persona(String nom){//constructor de Persona
        nombre=nom;
    }
    public String getNombre(){//Getter
        return nombre;
    }
    public abstract String getDescripcion();//metodo abstracto (las clases hijas de esta clase deben de tener obligatoriamente este metodo
    
    
    private String nombre;//atributo de la clase Persona
    

}
class Alumno extends Persona{//clase Alumno hereda de la clase abstracta persona
    public Alumno (String nom,String car){//constructor de la subclase Alumno
        super(nom);//llamamos los metodos de la clase Padre
        carrera=car;//damos valor al atributo de carrera pasandole el argumento de car
    }
    @Override
    public String getDescripcion (){//metodo de la clase abstracta Persona le damos valor en esta clase Alumno
        return "este alumno esta estudiando la carrera de: "+carrera;//retornamos el valor
    }
    private String carrera;//atributo de clase
}
class Empleado2 extends Persona{//Empleado2 hereda de Persona
    
    public Empleado2(String nom,double sue,int dia,int mes,int año){//metodo constructor de la clase Empleado
        super(nom);//llamamos los metodos de la clase padre (Persona)
        sueldo = sue;//damos valor al variable sueldo
        code = NextCode;//damos valor a a variable code con Nexcode que es una variable estatica
        
        GregorianCalendar calendario = new GregorianCalendar(año,mes-1,dia);//este metodo tiene mas constructores
        fecha = calendario.getTime();//damos valor a la fecha que toma el valor del objeto calendario instanciado apartir de la clase GregorianCalendar
        NextCode++;//incrementamos el codigo en uno
    }
    
    @Override
    public String getDescripcion(){//getter de a descripcion que este es metodo abstracto de la clase Persona
        return "este empleado tiene un sueldo de: "+sueldo+" codigo: "+code;//tiene su valor propio en cada clase
    }
   
    public int getCode (){//getter
        return code;
    }
    
    
    public Date getFecha(){//getter
        return fecha;
    }
    public void setSueldo(double porcentaje){//setter de sueldo con parametro para definir el sueldo total
        double aumento;
        aumento = sueldo*(porcentaje/100);//el aumento es el porcentaje que se ingresepor el sueldo
        sueldo+=aumento;//se suma el aumento al sueldo
    }
     public double getSueldo (){//getter para el sueldo
        return sueldo;//el total del sueldo
    }
    public static String siguienteCode(){//getter statico
        return "El siguiente codigo es: "+NextCode;
    }
//atributos de la clase Empleado

private double sueldo;
private  Date fecha;
private int code;
private static int NextCode=1;

}