
package usoempleado;

//interfaz que la vamos a usar en la subclas eJefe para la toma de desiciones de lo sjefes
public interface JefeDecision extends Trabajador{//JefeDecision hereda de la interfaz Trabajador
    public abstract String tomarDecision (String desicion) ;//se debe implentar este constructor en la clase que se use obligatoriamente
}
//cuando se usa una interfaz es com un modelo a seguir y se pueden utilizar varias en cada clase
