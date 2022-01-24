//Aplicamos el concepto de herencia y creamos subclases LecturaDatos y EscrituraDatos
package peliculas.excepciones;

//Con la palabra reservada extends aplicamos la herencia
public class AccesoDatosEx extends Exception{
    //Definimos el constructor de esta clase
    public AccesoDatosEx(String mensaje){
        super(mensaje);
    }
}
