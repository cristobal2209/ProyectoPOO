/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package proyecto.proyectopoo;

import java.util.ArrayList;

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
    
    public void leerDesdeArchivoFruta(String nombre, String tipo, boolean tieneSemilla, double calorias, double proteinas, double grasas, double carbohidratos, double porcion) {
        ListaFrutas.add(new Fruta(nombre, tipo, tieneSemilla, calorias, proteinas, grasas, carbohidratos, porcion));
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
    
    public double getCaloriasFruta(String nombreVerdura) {
        double caloriasFruta=0;
        
        /*Recorre la lista y si encuentra el nombre deseado, guarda el valor de las calorias en la variable caloriasFruta
        para luego retornar ese valor*/
        for (int i=0; i < ListaFrutas.size(); i++) {
            if (nombreVerdura.equalsIgnoreCase(ListaFrutas.get(i).getNombre())) {
                caloriasFruta = ListaFrutas.get(i).getCalorias();
                return caloriasFruta;
            }
        }
        return caloriasFruta;
    }
    
    public void leerDesdeArchivoVerdura(String nombre, String tipo, boolean esCultivoPequeno, boolean tieneSemilla, double calorias, double proteinas, double grasas, double carbohidratos, double porcion) {
        ListaVerduras.add(new Verdura(nombre, tipo, esCultivoPequeno, tieneSemilla, calorias, proteinas, grasas, carbohidratos, porcion));
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
    
    public double getCaloriasVerdura(String nombreVerdura) {
        double caloriasVerdura=0;
        
        /*Recorre la lista y si encuentra el nombre deseado, guarda el valors de las calorias en la variable caloriasVerdura
        para luego retornar ese valor*/
        for (int i=0; i < ListaVerduras.size(); i++) {
            if (nombreVerdura.equalsIgnoreCase(ListaVerduras.get(i).getNombre())) {
                caloriasVerdura = ListaVerduras.get(i).getCalorias();
                break;
            }
        }
        return caloriasVerdura;
    }
}
