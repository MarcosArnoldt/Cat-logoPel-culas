//Utilizamos esta clase para reportar problemas del tipo lectura de datos
package peliculas.excepciones;

//Hereda de la clase AccesoDatosEx
public class LecturaDatosEx extends AccesoDatosEx{
    //Como la clase madre tiene un constructor con un argumento, el constructor debe tener un argumento
    public LecturaDatosEx(String mensaje) {
        super(mensaje);
    }
    
    
}
