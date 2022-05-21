package proyecto.proyectopoo;

/**
 * Esta clase proporciona los atributos y constructores que posee un objeto Verdura.
 * 
 * @author Cristóbal Cáceres
 * @author Pablo Araya
 * @author René Araya
 * @version 1.0
 */
public class Verdura extends Vegetal {
    
    private boolean cultivoPequeno;
    
    //constructores
    /**
     * Contructor de un objeto Verdura con 9 parámetros.
     * 
     * @param nombre guarda el nombre de una verdura
     * @param tipo indica el tipo de verdura
     * @param cultivoPequeno indica si la verdura es un cultivo pequeño (true-si, false-no)
     * @param tieneSemilla indica si la verdura posee semillas (true-si, false-no)
     * @param calorias calorías que tiene una porción, en gramos
     * @param proteinas proteinas que tiene una porción, en gramos
     * @param grasas grasas que tiene una porción, en gramos
     * @param carbohidratos carbohidratos que posee una porción, en gramos
     * @param porcion cuantos gramos equivale una porción
     */
    public Verdura(String nombre, String tipo, boolean cultivoPequeno, boolean tieneSemilla, double calorias, double proteinas, double grasas, double carbohidratos, double porcion) {
        this.nombre = nombre;
        this.tipo = tipo;
        this.cultivoPequeno = cultivoPequeno;
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

    public boolean isCultivoPequeno() {
        return cultivoPequeno;
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

    public void setCultivoPequeno(boolean cultivoPequeno) {
        this.cultivoPequeno = cultivoPequeno;
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
