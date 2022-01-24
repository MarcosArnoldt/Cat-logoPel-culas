package peliculas.presentacion;
import java.util.Scanner;
import peliculas.servicio.CatalogoPeliculasImpl;
import peliculas.servicio.ICatalogoPeliculas;

public class CatalogoPeliculasPresentacion {
    public static void main(String[] args){
        var opcion = -1;
        var Scanner = new Scanner(System.in);
        ICatalogoPeliculas catalogo = new CatalogoPeliculasImpl();
        
        //1. damos la opción de que el usuario incie nuevamente el catálogo de películas
        //pudiendo borrar y crear nuevamente el archivo de texto donde se almacena el listado creado
        while(opcion != 0){
            System.out.println("Elige una opción: \n"
               + "1. Iniciar catálogo de películas\n"
               + "2. Agregar película\n"
               + "3. Listar películas\n"
               + "4. Buscar película\n"
               + "0. Salir del programa");
            //var opción al ser integer debemos castear y convertirlo a String para evitar problemas
            opcion = Integer.parseInt(Scanner.nextLine());
            
            switch(opcion){
                case 1:
                    catalogo.iniciarCatalogoPeliculas();
                    break;
                case 2:
                    System.out.println("Introduce el nombre de la película");
                    var nombrePelicula = Scanner.nextLine();
                    catalogo.agregarPelicula(nombrePelicula);
                    break;
                case 3:
                    catalogo.listarPeliculas();
                    break;
                case 4:
                    System.out.println("Introduce el nombre de la película a buscar: ");
                    var buscare = Scanner.nextLine();
                    catalogo.buscarPelicula(buscare);
                    break;
                case 0:
                    System.out.println("¡Hasta luego!");
                    break;
                default:
                    System.out.println("Opción inválida");
                    break;
            }
        }
    }    
 }
