package proyecto.proyectopoo;


import java.util.ArrayList;

public class Fruta {
    
    //atributos
    
    private String nombre;
    private String tipo;
    private boolean tieneSemilla;
    private double calorias;
    private double proteinas;
    private double grasas;
    private double carbohidratos;
    private double porcion;
    private ArrayList<Fruta> ListaFrutas = new ArrayList<Fruta>();
    
    //constructores

    public Fruta() {
    }

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

    //accesores
    
    public String getNombre() {
        return nombre;
    }

    public String getTipo() {
        return tipo;
    }

    public boolean getTieneSemilla() {
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

    //mutadores

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

    //metodos
    
    public void leerDesdeArchivo(String nombre, String tipo, boolean tieneSemilla, double calorias, double proteinas, double grasas, double carbohidratos, double porcion) {
        ListaFrutas.add(new Fruta(nombre, tipo, tieneSemilla, calorias, proteinas, grasas, carbohidratos, porcion));
    }
    
    public void mostrarDatos() {
        for (int i = 0; i < ListaFrutas.size(); i++) {
            System.out.println("FRUTA "+(i+1));
            System.out.println("Nombre "+ListaFrutas.get(i).nombre);
            System.out.println("Tipo "+ListaFrutas.get(i).tipo);
            System.out.print("¿Tiene semilla? ");
            if (ListaFrutas.get(i).tieneSemilla) System.out.println("SI"); else System.out.println("NO");
            System.out.println("Una porción de "+ListaFrutas.get(i).porcion+" gramos tiene:");
            System.out.println(ListaFrutas.get(i).calorias+" calorias");
            System.out.println(ListaFrutas.get(i).grasas+" grasas");
            System.out.println(ListaFrutas.get(i).proteinas+" proteinas");
            System.out.println(ListaFrutas.get(i).carbohidratos+" carbohidratos");
            System.out.println();
        }
    }
    
    public void mostrarLista() {
        for (int i = 0; i < ListaFrutas.size(); i++) {
            System.out.println("- "+ListaFrutas.get(i).nombre);
        }
    }
    
    public double getCaloriasFruta(String nombreVerdura) {
        int i;
        double caloriasFruta=0;
        
        /*Recorre la lista y si encuentra el nombre deseado, guarda el valors de las calorias en la variable caloriasFruta
        para luego retornar ese valor*/
        for (i=0; i < ListaFrutas.size(); i++) {
            if (nombreVerdura.equalsIgnoreCase(ListaFrutas.get(i).nombre)) {
                caloriasFruta = ListaFrutas.get(i).calorias;
                break;
            }
        }
        
        return caloriasFruta;
    }
}