
package proyecto.proyectopoo;


public class Vegetal {
    private String nombre;
    private String tipo;
    
    //constructores
    
    public Vegetal() {
        
    }
    
    public Vegetal(String nombre){
        this.nombre = nombre;
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
