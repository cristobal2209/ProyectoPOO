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
 *
 * @author crist
 */
public class Datos {
    private ArrayList<Fruta> ListaFrutas = new ArrayList<Fruta>();
    private ArrayList<Verdura> ListaVerduras = new ArrayList<Verdura>();

    public ArrayList<Fruta> getListaFrutas() {
        return ListaFrutas;
    }

    public ArrayList<Verdura> getListaVerduras() {
        return ListaVerduras;
    }

    public void setListaFrutas(ArrayList<Fruta> ListaFrutas) {
        this.ListaFrutas = ListaFrutas;
    }

    public void setListaVerduras(ArrayList<Verdura> ListaVerduras) {
        this.ListaVerduras = ListaVerduras;
    }
    
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
    
    public void mostrarDatosFrutas() {
        for (int i = 0; i < ListaFrutas.size(); i++) {
            System.out.println("FRUTA "+(i+1));
            System.out.println("Nombre "+ListaFrutas.get(i).getNombre());
            System.out.println("Tipo "+ListaFrutas.get(i).getTipo());
            System.out.print("¿Tiene semilla? ");
            if (ListaFrutas.get(i).isTieneSemilla()) System.out.println("SI");
            else System.out.println("NO");
            System.out.println("Una porción de "+ListaFrutas.get(i).getPorcion()+" gramos tiene:");
            System.out.println(ListaFrutas.get(i).getCalorias()+" calorias");
            System.out.println(ListaFrutas.get(i).getGrasas()+" grasas");
            System.out.println(ListaFrutas.get(i).getProteinas()+" proteinas");
            System.out.println(ListaFrutas.get(i).getCarbohidratos()+" carbohidratos");
            System.out.println();
        }
    }
    
    public void mostrarListaFrutas() {
        for (int i = 0; i < ListaFrutas.size(); i++) {
            System.out.println("- "+ListaFrutas.get(i).getNombre());
        }
    }
    
    public void mostrarDatosVerduras() {
        for (int i = 0; i < ListaVerduras.size(); i++) {
            System.out.println("VERDURA "+(i+1));
            System.out.println("Nombre "+ListaVerduras.get(i).getNombre());
            System.out.println("Tipo "+ListaVerduras.get(i).getTipo());
            System.out.print("¿Tiene semilla? ");
            if (ListaVerduras.get(i).isTieneSemilla()) 
                System.out.println("SI"); 
            else 
                System.out.println("NO");
            System.out.print("¿Es un cultivo pequeño? ");
            if (ListaVerduras.get(i).isCultivoPequeno()) 
                System.out.println("SI"); 
            else 
                System.out.println("NO");
            System.out.println("Una porción de "+ListaVerduras.get(i).getPorcion()+" gramos tiene:");
            System.out.println(ListaVerduras.get(i).getCalorias()+" calorias");
            System.out.println(ListaVerduras.get(i).getGrasas()+" grasas");
            System.out.println(ListaVerduras.get(i).getProteinas()+" proteinas");
            System.out.println(ListaVerduras.get(i).getCarbohidratos()+" carbohidratos");
            System.out.println();
        }
    }
    
    public void mostrarListaVerduras() {
        for (int i = 0; i < ListaVerduras.size(); i++) {
            System.out.println("- "+ListaVerduras.get(i).getNombre());
        }
    }
}
