package proyecto.proyectopoo;

/**
 * Esta clase define los atributos y constructores que tiene un objeto Fruta
 * 
 * @author Cristóbal Cáceres
 * @author Pablo Araya
 * @author René Araya
 * @version 1.0
 */
public class Fruta extends Vegetal{
    

    //constructores
    /**
     * Contructor de la clase Fruta con 8 parámetros.
     * 
     * @param nombre nombre de una fruta
     * @param tipo tipo al que pertenece una fruta
     * @param tieneSemilla indica si la fruta tiene semilla (true-si, false-no)
     * @param calorias calorias que tiene una porción, en gramos
     * @param proteinas proteinas que tiene una porción, en gramos
     * @param grasas grasas que tiene una porción, en gramos
     * @param carbohidratos carbohidratos que posee una porción, en gramos
     * @param porcion cuantos gramos equivale una porción
     */
    public Fruta(String nombre, String tipo, boolean tieneSemilla, double calorias, double proteinas, double grasas, double carbohidratos, double porcion) {
        
        this.nombre = nombre;
        this.tipo = tipo;
        this.tieneSemilla = tieneSemilla;
        this.calorias = calorias;
        this.proteinas = proteinas;
        this.grasas = grasas;
        this.carbohidratos = carbohidratos;
        this.porcion = porcion;
    }

    //getters
    
    public String getNombre() {
        return nombre;
    }

    public String getTipo() {
        return tipo;
    }

    public double getCalorias() {
        return calorias;
    }

    public double getProteinas() {
        return proteinas;
    }

    public double getGrasas() {
        return grasas;
    }

    public double getCarbohidratos() {
        return carbohidratos;
    }
    
    public double getPorcion() {
        return porcion;
    }

    public boolean isTieneSemilla() {
        return tieneSemilla;
    }

    //setters

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public void setTieneSemilla(boolean tieneSemilla) {
        this.tieneSemilla = tieneSemilla;
    }

    public void setCalorias(double calorias) {
        this.calorias = calorias;
    }

    public void setProteinas(double proteinas) {
        this.proteinas = proteinas;
    }

    public void setGrasas(double grasas) {
        this.grasas = grasas;
    }

    public void setCarbohidratos(double carbohidratos) {
        this.carbohidratos = carbohidratos;
    }
    
    public void setPorcion(double porcion) {
        this.porcion = porcion;
    }
}