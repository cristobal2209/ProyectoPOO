
package proyecto.proyectopoo;

/**
 * Esta clase indica los atributos y constructores de un objeto vegetal.
 * 
 * @author
 * @author
 * @author
 * @version
 */
public class Vegetal {
    private String nombre, tipo;
    
    //constructores
    /**
     * Constructor de un objeto Vegetal.
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
