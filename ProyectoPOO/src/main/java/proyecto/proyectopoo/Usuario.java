package proyecto.proyectopoo;

import java.util.ArrayList;
import java.util.Scanner;

public class Usuario {
    
    //atributos
    
    private String nombre, sexo;
    private double masa, altura, imc=0;
    private ArrayList<Vegetal> ListaVegetalesConsumidos = new ArrayList<Vegetal>();
    Scanner input = new Scanner(System.in);
    
    //constructores
    
    public Usuario() {
        
    }
    
    public Usuario(String nombre, double masa, double altura, String sexo) {
        this.nombre = nombre;
        this.masa = masa;
        this.altura = altura;
        this.sexo = sexo;
    }

    //accesores
    
    public String getNombre() {
        return nombre;
    }
    
    public double getMasa() {
        return masa;
    }
    
    public double getAltura() {
        return altura;
    }
    
    public double getImc() { 
        return imc; 
    }
    
    public String getSexo() {
        return sexo;
    }

    public ArrayList<Vegetal> getListaVegetalesConsumidos() {
        return ListaVegetalesConsumidos;
    }
    
    //mutadores

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setMasa(double masa) {
        this.masa = masa;
    }

    public void setAltura(double altura) {
        this.altura = altura;
    }

    public void setImc(double imc) {
        this.imc = imc;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
    }

    public void setListaVegetalesConsumidos(ArrayList<Vegetal> ListaVegetalesConsumidos) {
        this.ListaVegetalesConsumidos = ListaVegetalesConsumidos;
    }
    
    //metodos
    
    public void calcularImc()   {
        imc = masa/(Math.pow(altura, 2));
    }

    public void agregarVegetalConsumido(String nombreVegetal) {
        ListaVegetalesConsumidos.add(new Vegetal(nombreVegetal));
    }
    
    public boolean eliminarVegetalConsumido(String nombreVegetal) {
        for (int i = 0; i < ListaVegetalesConsumidos.size(); i++) {
            if (nombreVegetal.equalsIgnoreCase(ListaVegetalesConsumidos.get(i).getNombre())) {
                ListaVegetalesConsumidos.remove(i);
                return true;
            }  
        }
        return false;
    }
    
    public double getCaloriasConsumidas(Datos DatosVegetales) {
        double sumaCalorias = 0;
        
        for (int i = 0; i < ListaVegetalesConsumidos.size(); i++) {
            for (int j = 0; j < DatosVegetales.getListaFrutas().size(); j++) {
                if (ListaVegetalesConsumidos.get(i).getNombre().equalsIgnoreCase(DatosVegetales.getListaFrutas().get(j).getNombre()))
                    sumaCalorias += DatosVegetales.getListaFrutas().get(j).getCalorias();
            }
            for (int j = 0; j < DatosVegetales.getListaVerduras().size(); j++) {
                if (ListaVegetalesConsumidos.get(i).getNombre().equalsIgnoreCase(DatosVegetales.getListaVerduras().get(j).getNombre()))
                    sumaCalorias += DatosVegetales.getListaVerduras().get(j).getCalorias();
            }
        }
        return sumaCalorias;
    }
        
    public void mostrarVegetalesConsumidos() {
        for (int i = 0; i < ListaVegetalesConsumidos.size(); i++) {
            if (i==0)
                System.out.print(ListaVegetalesConsumidos.get(i).getNombre());
            else
                System.out.print(", "+ListaVegetalesConsumidos.get(i).getNombre());
        }
    }
}