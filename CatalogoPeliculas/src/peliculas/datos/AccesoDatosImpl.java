package peliculas.datos;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import peliculas.domain.Pelicula;
import peliculas.excepciones.AccesoDatosEx;
import peliculas.excepciones.EscrituraDatosEx;
import peliculas.excepciones.LecturaDatosEx;

//Debemos utilizar necesariamente los mismos métodos
public class AccesoDatosImpl implements IAccesoDatos {

    @Override
    public boolean existe(String nombreRecurso) {
        var archivo = new File(nombreRecurso);
        return archivo.exists();
    }

    @Override
    public List<Pelicula> listar(String nombreRecurso) throws LecturaDatosEx {
        var archivo = new File(nombreRecurso);
        List<Pelicula> peliculas = new ArrayList<>();
        try {
            var entrada = new BufferedReader(new FileReader(archivo));
            //Definimos variable para leer entrada de datos
            String linea = null;
            //Definimos método readLine
            linea = entrada.readLine();
            //
            while (linea != null) {
                var pelicula = new Pelicula(linea);
                peliculas.add(pelicula);
                linea = entrada.readLine();
            }
            entrada.close();
        } catch (FileNotFoundException ex) {
            ex.printStackTrace();
            //Utilizamos nuestras excepciones con un mensaje personalizado al usuario
            throw new LecturaDatosEx("Error al listar película: " + ex.getMessage());
        } catch (IOException ex) {
            ex.printStackTrace();
            //Utilizamos nuestras excepciones con un mensaje personalizado al usuario
            throw new LecturaDatosEx("Error al listar película: " + ex.getMessage());
        }
        return peliculas;
    }

    @Override
    public void escribir(Pelicula pelicula, String nombreRecurso, boolean anexar) throws EscrituraDatosEx {
        var archivo = new File(nombreRecurso);
        try {
            var salida = new PrintWriter(new FileWriter(archivo, anexar));
            salida.println(pelicula.toString());
            salida.close();
            System.out.println("Se ha escrito el nombre de la pelicula correctamente: " + pelicula);
        } catch (IOException ex) {
            ex.printStackTrace();
            //Utilizamos nuestras excepciones con un mensaje personalizado al usuario
            throw new EscrituraDatosEx("Error al escribir película: " + ex.getMessage());
        }
    }

    @Override
    public String buscar(String nombreRecurso, String buscar) throws LecturaDatosEx {
        var archivo = new File(nombreRecurso);
        String resultado = null;
        String error = "Error en la búsqueda. Película no encontrada";
        try {
            try (java.io.BufferedReader entrada = new BufferedReader(new FileReader(archivo))) {
                String linea = null;
                linea = entrada.readLine();
                //Para saber la linea que estamos leyendo necesitamos un índice que nos indica
                //la línea donde se encuentra la película que estamos buscando
                int indice = 1;
                while (linea != null){
                    if(buscar != null && buscar.equals(linea)){
                        resultado = "Pelicula " + linea + "encontrada en el índice " + indice;
                        break;
                    }
                    linea = entrada.readLine();
                    indice++;
                    
                   
                }
            }
        } catch (FileNotFoundException ex){
            //Utilizamos nuestras excepciones con un mensaje personalizado al usuario
            throw new LecturaDatosEx("Error al buscar la película: " + ex.getMessage());
        } catch (IOException ex) {
            //Utilizamos nuestras excepciones con un mensaje personalizado al usuario
            throw new LecturaDatosEx("Error al buscar la película: " + ex.getMessage());
        }
        return error;
    }

    @Override
    public void crear(String nombreRecurso) throws AccesoDatosEx {
        var archivo = new File(nombreRecurso);
        try {
            var salida = new PrintWriter(new FileWriter(archivo));
            salida.close();
            System.out.println("Se ha creado el archivo");
        } catch (IOException ex) {
            ex.printStackTrace();
            //Utilizamos nuestras excepciones con un mensaje personalizado al usuario
            throw new AccesoDatosEx("Error al crear archivo: " + ex.getMessage());
        }
    }

    @Override
    public void borrar(String nombreRecurso) {
        var archivo = new File(nombreRecurso);
        if(archivo.exists()){
        archivo.delete();
        System.out.println("Se ha borrado el archivo");
        }
    }

}
