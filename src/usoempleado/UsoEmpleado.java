
package usoempleado;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.Arrays;
import java.util.Date;
import java.util.GregorianCalendar;


public class UsoEmpleado {

    
    public static void main(String[] args) {
    Empleado empleados []= new Empleado[6];
    Jefe jefe1 =new Jefe("Homero ",2000000,23,23,1990);//creamos un objeto apartir de la subclase "Jefe"
    jefe1.setIncentivo(20.20);//llamamos el metodo para dar incentivo al objeto jefe1
    
   
    empleados [0]= new Empleado("Jose Rodriguez",850000,22,01,1994);
    empleados [1]= new Empleado("Yeimi Vasquez",800000,19,02,1997);
    empleados [2]= new Empleado("Angel Rodriguez",32000,10,10,2017);
    empleados [3]= new Empleado("mary");//aqui usamos el segundo constructor de la clase empleado, por eso tiene solo un argumento
    empleados [4]= jefe1 ;//aqui se puede ver el polimorfismo en accion; ya que jefe1 es un objeto de la clase Jefe y se esta
    //guardando en el array empleados que se instancio de la clase Empleado (ya que un jefe siempre"es un" empleado)
    //y cuando se ejecutan los for each y este llega donde esta el objeto de la subclase Jefe actua diferente, es decir
    //actua como Jefe y no como Empleado
    empleados [5]= new Jefe("March",1500000,17,17,1991);//como en una variable objeto Empleado podemos guardar un Jefe ya que Jefe es un Empleado
    Jefe admi = (Jefe)empleados[5];//csating: convertimos la variable objeto empleados¨[5] que es de tipo Empleado en una variable tipo Jefe
    admi.setIncentivo(10.10);//damos incentivo al Jefe admi con el setter setIncentivo
    
    //tipo de variable/nombre asignado : nombre del array
    for(Empleado sueldo : empleados ){
        sueldo.setSueldo(5);//metodo de la clase Empleado y Jefe por que Jefe hereda de Empleado; para subir el sueldo
        
    } 
        System.out.println(jefe1.tomarDecision("todos los empleados deben portar el carnet"));//eneste mensaje que se muestra por pantalla usamos el constructor tomar decision de la subclase Jefe
        //la cual hereda de empleado e implementa la interfaz JefeDecision de ahi este constructor
    
    Arrays.sort(empleados);//mediante el metodo sort de la clase Arrays realizamos el ordenamiento de arreglos en este caso del array empleados
    for(Empleado mostrar : empleados){
        System.out.println("Nombre: "+mostrar.getNombre()+"\nSueldo: "+mostrar.getSueldo()+"\nFecha de nacimiento: "+mostrar.getFecha()
        +"Codigo: "+mostrar.getCode());
        System.out.println("");
    }
        System.out.println("el jefe: "+jefe1.getNombre()+" recibe un bonus de: "+jefe1.bonus(100));//mosteamos resultados ejemplo de las interfaz
        System.out.println("el empleado: "+empleados[0].getNombre()+" recibe un bono de: "+empleados[0].bonus(50));//resulatados ejemplo donde se usa interfaz
        
        System.out.println(Empleado.siguienteCode());//este es un getter estatico
        
         //-- ----------------------------------------nueva practica aqui con serializable --------------------------------------------------
    try{
    
    ObjectOutputStream serializarArchivo=new ObjectOutputStream(new FileOutputStream("C:\\Users\\JOZE RODRIGUEZ\\Documents\\practicaObjectStream\\empleados.dat"));//creamos la ruta donde se guardara el archivo serializado
    serializarArchivo.writeObject(empleados);//con este metodo serializamos los empleado que fueron creados, es decir guardamos los datos serializados
    serializarArchivo.close();
    
    ObjectInputStream recuperarArchivo=new ObjectInputStream(new FileInputStream("C:\\Users\\JOZE RODRIGUEZ\\Documents\\practicaObjectStream\\empleados.dat"));
    //recuperarArchivo.close();//cerramos la conexio con el archivo
    
    Empleado[] empleadosRecuperados=(Empleado[])recuperarArchivo.readObject();//creamos un array de tipo Empleado ya que lo que contiene el archivo de recuperados es de tipoEmpleado
        System.out.println("----------recuperaod de archivo serializado---------");
    for (Empleado e:empleadosRecuperados){
        System.out.println(e.getNombre());
    }
    
    recuperarArchivo.close();
    
    }catch(Exception e){
        System.out.println("error al serializar");
   }
    
    
    
   // ---------------------------------------------------------------------fin practicca----------------------------------------------------
    }
    
    
   
    
}
class Empleado implements Comparable,Trabajador,/*parte practica 2*/Serializable{//esta clase Empleado implementa de la inteerfaz Comparable su unico metodo
    
    public Empleado(String nom,double sue,int dia,int mes,int año){//metodo construcutor de la clase Empleado
        nombre = nom;
        sueldo = sue;
        code = NextCode;
        
        GregorianCalendar calendario = new GregorianCalendar(año,mes-1,dia);//este metodo tiene mas constructores
        fecha = calendario.getTime();
        NextCode++;
    }
    public Empleado (String nom){//esta es un sobrecarga de constructor
        this(nom,1000000,01,01,1990);//de esta manera llamamos el constructor que tiene 5 parametros y damos valor por defecto a las variables exepto a lade nom
    }
    public int getCode (){//getter
        return code;
    }
    
    public String getNombre(){//getter
        return nombre;
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
    
    @Override
    public int compareTo (Object objeto){//compareTo es el unico metodo de la interfaz Comparable asi que es obligatorio implementar
        Empleado emple= (Empleado)objeto;//se realiza un casting para convertir la variable Objeto en Empleado
        if(this.sueldo<emple.sueldo){//si el sueldo es menor al sueldo del empleado retornara un menos 1
            return -1;
        }
        else if(this.sueldo>emple.sueldo){//si es mayor retornara un 1
            return 1;
        }
        else{
            return 0;//sino un cero
        }
    }
    @Override
    public double bonus(double gratificacion){//se crea obligatoriamente el metodo de la interfaz Trabajador ya que se implemento a la clase
        return Empleado.bonus+gratificacion;//el empleado solo recibe el bonus + la gratificacion
    }
//atributos de la clase Empleado
private  String nombre;
private double sueldo;
private  Date fecha;
private int code;
private static int NextCode=1;

}
class Jefe extends Empleado implements JefeDecision{//creacion de un subclase

    public Jefe (String nom,double sue,int dia,int mes,int año){//creamos el constructor de la clase jefe con los mismos parametros
        //ue tiene la clase Empleado ya que estos parametros se los pasaremos la constructor de 5 parametros
       
        super(nom,sue,dia,mes,año);//le pasamos los datos que se ingresaron el el constructor de jefe al constructor de Empleado.
      
    }
    public void setIncentivo(double b){//setter para dar calor al incentivo de la clase jefe
        incentivo=b;
    }
    @Override//significa anular es decir estamos anulando el getter getSueldo de la clase padre (Empleado)
    public double  getSueldo(){//getter sobreescrito es decir este getter tambien se encuentra el la clase padre pero aqui le damos un valor diferente
        double sueldoJefe=super.getSueldo();//el sueldoJefe es = al sueldo del empleado con la palabra super.getsueldo llamamos el getter de la clase padre
        sueldoJefe+=incentivo;//el sueldoJefe se le suma el incentinvo
        return sueldoJefe;//y lo retornamos
        
    }
    @Override
    public String tomarDecision (String decision){
        return "uno de los jefes tomo la siguiente deciscion: "+decision;
    }
    
    private double incentivo;//atributo propio de la clase hija Jefe

    @Override
    public double bonus(double gratificacion){//sobreescribimos el metodo de la interfaz Trabajador que se hereda en la interfaz JefeDecision
       double prima=300;//a los jefes se les da una prima de 300
       return Jefe.bonus+prima+gratificacion;//el bonnus es la suma del bonus declarado en la interfaz Trabajador+prima y la gratificacion que se le asigne
    }

}

