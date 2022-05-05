/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package proyecto.proyectopoo;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;
import static proyecto.proyectopoo.Principal.MAX_FRUTAS;
import static proyecto.proyectopoo.Principal.MAX_VERDURAS;

/**
 * Esta clase se encarga de almacenar y controlar los datos de frutas y verduras,
 * guardando sus datos en dos listas de objetos: ListaFrutas para los objetos Fruta
 * y ListaVerduras para los objetos Verdura.
 * 
 * @author Cristóbal Cáceres
 * @author Pablo Araya
 * @author René Araya
 * @version 1.0
 */
public class Datos {
    
    private ArrayList<Fruta> ListaFrutas = new ArrayList<Fruta>();
    private ArrayList<Verdura> ListaVerduras = new ArrayList<Verdura>();

    //getters
    
    public ArrayList<Fruta> getListaFrutas() {
        return ListaFrutas;
    }

    public ArrayList<Verdura> getListaVerduras() {
        return ListaVerduras;
    }

    //setters
    
    public void setListaFrutas(ArrayList<Fruta> ListaFrutas) {
        this.ListaFrutas = ListaFrutas;
    }

    public void setListaVerduras(ArrayList<Verdura> ListaVerduras) {
        this.ListaVerduras = ListaVerduras;
    }
    
    //métodos
    /**
     * IMPORTANTE: Si aparece el mensaje "Ha ocurrido un error de lectura del archivo"
     * es posible que sea un error de lectura desde el archivo. Para esto se pide
     * que cambie la ruta en la linea 69 a "src/test/java/datos.txt"
     * 
     * Lee los datos de verduras y frutas guardados en un archivo .txt con ruta
     * src/test/java/(archivo).txt, para luego añadirlos a una lista. Para leer
     * se emplea un ciclo for que dura según la cantidad definida por MAX_VERDURAS
     * y MAX_FRUTAS, estos valores se pueden cambiar en la clase Principal. En 
     * cada ciclo for se leen todos los datos de una fruta o verdura, para luego
     * crear y añadir un nuevo objeto Fruta o Verdura a su respectiva lista 
     * (ListaFrutas o ListaVerduras).
     */
    public void leerDesdeArchivo() {
        String nombre, tipo;
        boolean esCultivoPequeno, tieneSemilla;
        double calorias, proteinas, grasas, carbohidratos, porcion;

        //definiendo archivo
        File archivo = new File("src/test/java/datos2.txt");
            
        try (Scanner reader = new Scanner(archivo)) {
            //leyendo datos de verduras
            for (int i=0; i < MAX_VERDURAS; i++) {
                nombre = reader.next();
                tipo = reader.next();
                esCultivoPequeno = reader.nextBoolean();
                tieneSemilla = reader.nextBoolean();
                calorias = reader.nextDouble();
                proteinas = reader.nextDouble();
                grasas = reader.nextDouble();
                carbohidratos = reader.nextDouble();
                porcion = reader.nextDouble();
                
                ListaVerduras.add(new Verdura(nombre, tipo, esCultivoPequeno, tieneSemilla, calorias, proteinas, grasas, carbohidratos, porcion));
            }
            
            //leyendo datos de frutas
            for (int i=0; i < MAX_FRUTAS; i++) {
                nombre = reader.next();
                tipo = reader.next();
                tieneSemilla = reader.nextBoolean();
                calorias = reader.nextDouble();
                proteinas = reader.nextDouble();
                grasas = reader.nextDouble();
                carbohidratos = reader.nextDouble();
                porcion = reader.nextDouble();
                
                ListaFrutas.add(new Fruta(nombre, tipo, tieneSemilla, calorias, proteinas, grasas, carbohidratos, porcion));
            }
            reader.close();
        } catch (FileNotFoundException e) {
            System.out.println("Ha ocurrido un error de lectura del archivo");
        }
    }
    
    /**
     * Obtiene el tipo (fruta o verdura) de un vegetal a través de su nombre.
     * Para esto se ingresa por parámetro el nombre de un vegetal y se recorren
     * las dos listas (ListaFrutas o ListaVerduras). Si encuentra igualdad de nombre
     * del vegetal ingresado con el atributo nombre de algún objeto en las listas, se retorna
     * un String con el tipo que corresponda, "fruta" o "verdura". En cualquier 
     * otro caso retorna null.
     * 
     * @param nombreVegetal String que guarda el nombre de un vegetal que se desea
     *                      saber su tipo
     * @return String "fruta" si el vegetal está en ListaFrutas, String "verdura"
     *         si el vegetal está en ListaVerduras o null en cualquier otro caso
     */
    public String getTipoVegetal(String nombreVegetal) {
        String fruta = "fruta";
        String verdura = "verdura";
        for (int i = 0; i < ListaFrutas.size(); i++) {
            if (ListaFrutas.get(i).getNombre().equalsIgnoreCase(nombreVegetal))
                return fruta;
        }
        for (int i = 0; i < ListaVerduras.size(); i++) {
            if (ListaVerduras.get(i).getNombre().equalsIgnoreCase(nombreVegetal))
                return verdura;
        }
        return null;
    }
    
    /**
     * Verifica si un vegetal existe en las listas ListaFrutas o ListaVerduras.
     * Se recorren ambas listas por separado y si el atributo nombre de algún
     * objeto es igual al nombre ingresado por parámetro, retorna 'true' diciendo
     * que existe tal vegetal. En cualquier otro caso retorna 'false'.
     * 
     * @param nombreVegetal String que guarda el nombre de vegetal a verificar
     *                      su existencia en las listas
     * @return 'true' si el vegetal ingresado existe, 'false' en cualquier otro caso
     */
    public boolean vegetalExiste(String nombreVegetal) {
        for (int i = 0; i < ListaFrutas.size(); i++) {
            if (ListaFrutas.get(i).getNombre().equalsIgnoreCase(nombreVegetal))
                return true;
        }
        for (int i = 0; i < ListaVerduras.size(); i++) {
            if (ListaVerduras.get(i).getNombre().equalsIgnoreCase(nombreVegetal))
                return true;
        }
        return false;
    }
    
    /**
     * Imprime el contenido de ListaFrutas en formato "- nombreFruta/n". Este método 
     * se ocupa para mostrar sólo el nombre de las frutas guardadas como dato, así 
     * el usuario ingresa por consola el nombre de la fruta que ha consumido.
     */
    public void mostrarListaFrutas() {
        for (int i = 0; i < ListaFrutas.size(); i++) {
            System.out.println("- "+ListaFrutas.get(i).getNombre());
        }
    }
    
    /**
     * Imprime el contenido de ListaVerduras en formato "- nombreVerdura/n". Este método 
     * se ocupa para mostrar sólo el nombre de las Verduras guardadas como dato, 
     * así el usuario ingresa por consola el nombre de la verdura que ha consumido.
     */
    public void mostrarListaVerduras() {
        for (int i = 0; i < ListaVerduras.size(); i++) {
            System.out.println("- "+ListaVerduras.get(i).getNombre());
        }
    }
}
