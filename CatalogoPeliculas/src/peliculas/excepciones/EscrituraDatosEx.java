//Utilizamos esta clase para reportar problemas del tipo escritura de datos
package peliculas.excepciones;
//Hereda de la clase AccesoDatosEx
public class EscrituraDatosEx extends AccesoDatosEx{
    //Como la clase madre tiene un constructor con un argumento, el constructor debe tener un argumento
    public EscrituraDatosEx(String mensaje) {
        super(mensaje);
    }
    
}
