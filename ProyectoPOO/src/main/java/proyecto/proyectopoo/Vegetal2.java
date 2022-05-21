/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package proyecto.proyectopoo;

/**
 * Esta clase permite crear objetos en comun entre frutas y verduras, para
 * almanecenarlas en una sola lista.
 * 
 * @author Cristóbal Cáceres
 * @author Pablo Araya
 * @author René Araya
 * @version 1.0
 */
public class Vegetal2 extends Vegetal{

    public Vegetal2() {
    }

    public Vegetal2(String nombre, String tipo) {
        this.nombre = nombre;
        this.tipo = tipo;
    }
    
    public String getNombre() {
        return nombre;
    }

    public String getTipo() {
        return tipo;
    }

    public boolean isTieneSemilla() {
        return tieneSemilla;
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
