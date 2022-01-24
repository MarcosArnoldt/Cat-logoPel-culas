
package peliculas.datos;

//En la interfaz vamos a definir los métodos que interactuán con el archivo
//Importamos  la clase AccesoDatosEx, la clase list y la clase Pelicula;
import java.util.List;
import peliculas.domain.Pelicula;
import peliculas.excepciones.*;

public interface IAccesoDatos {
    //definimos el método para saber si ya existe un archivo. Puede arrojar la excepción.
    boolean existe(String nombreRecurso) throws AccesoDatosEx;
    
    //método de listar; indicando el nombre del recurso. Regresa lista de objetos del tipo película 
    List<Pelicula> listar(String nombreRecurso) throws LecturaDatosEx;
    
    //Recibe un objeto de tipo película; definimos el nombre del recurso; 
    //indicamos si se anexa la información o sobreescribe e indicamos el tipo de excepción
    void escribir(Pelicula pelicula, String nombreRecurso, boolean anexar) throws EscrituraDatosEx;
    
    //Método para buscar una película
    String buscar(String nombreRecurso, String buscar) throws LecturaDatosEx;
    
    //Método crear archivo o recurso
    void crear(String nombreRecurso)throws AccesoDatosEx;
    
    //Método borrar archivo o recurso
    void borrar(String nombreRecurso) throws AccesoDatosEx;
    
}
