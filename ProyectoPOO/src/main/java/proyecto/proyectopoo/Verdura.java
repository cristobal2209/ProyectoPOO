package proyecto.proyectopoo;


import java.util.ArrayList;

public class Verdura {
    
    //atributos
    
    private String nombre, tipo;
    private boolean cultivoPequeno, tieneSemilla;
    private double calorias, proteinas, grasas, carbohidratos, porcion;
    
    //constructores
    
    public Verdura(){       
    }

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

    //accesores
    
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

    //mutadores

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
