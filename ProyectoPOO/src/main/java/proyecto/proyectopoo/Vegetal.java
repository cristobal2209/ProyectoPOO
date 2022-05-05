
package proyecto.proyectopoo;

/**
 * Esta clase indica los atributos y constructores de un objeto vegetal.
 * 
 * @author Cristóbal Cáceres
 * @author Pablo Araya
 * @author René Araya
 * @version 1.0
 */
public class Vegetal {
    
    //atributos
    private String nombre, tipo;
    
    //constructores
    /**
     * Constructor de un objeto Vegetal, recibe 2 parámetros.
     * 
     * @param nombre guarda el nombre de un vegetal
     * @param tipo indica el tipo de vegetal (fruta o verdura)
     */
    public Vegetal(String nombre, String tipo){
        this.nombre = nombre;
        this.tipo = tipo;
    }

    //getters
    
    public String getNombre() {
        return nombre;
    }

    public String getTipo() {
        return tipo;
    }

    //setters
    
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }
}
