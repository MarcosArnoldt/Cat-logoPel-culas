
package peliculas.domain;

public class Pelicula {
    //La clase puede tener cualquier cantidad de atributos; para simplificarlo, lleva uno.
    private String nombre;
    
    //Constructor vacío
    public Pelicula(){
       
    }
    //Los atributos privados deben tener sus métodos get y set asociados debiendo ser públicos
    public Pelicula(String nombre){
       this.nombre = nombre;
    }
    
    public String getNombre(){
       return nombre;
    }
    
    public void setNombre(String nombre){
       this.nombre = nombre;
    }

    @Override
    public String toString() {
        return this.nombre;
    }
   
}
