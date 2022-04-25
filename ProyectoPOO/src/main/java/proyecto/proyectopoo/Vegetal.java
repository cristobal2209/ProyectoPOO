
package proyecto.proyectopoo;


public class Vegetal {
    private String nombre, tipo;
    
    //constructores
    
    public Vegetal() {
        
    }
    
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
