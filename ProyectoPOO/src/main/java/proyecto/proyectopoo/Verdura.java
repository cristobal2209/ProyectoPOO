package proyecto.proyectopoo;


import java.util.ArrayList;

public class Verdura {
    
    //atributos
    
    private String nombre;
    private String tipo;
    private boolean esCultivoPequeno;
    private boolean tieneSemilla;
    private double calorias;
    private double proteinas;
    private double grasas;
    private double carbohidratos;
    private double porcion;
    private ArrayList<Verdura> ListaVerduras = new ArrayList<Verdura>();
    
    //constructores
    
    public Verdura(){       
    }

    public Verdura(String nombre, String tipo, boolean esCultivoPequeno, boolean tieneSemilla, double calorias, double proteinas, double grasas, double carbohidratos, double porcion) {
        this.nombre = nombre;
        this.tipo = tipo;
        this.esCultivoPequeno = esCultivoPequeno;
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

    public boolean getEsCultivoPequeno() { return esCultivoPequeno; }

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

    public void setEsCultivoPequeno(boolean esCultivoPequeno) {
        this.esCultivoPequeno = esCultivoPequeno;
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
    
    public void leerDesdeArchivo(String nombre, String tipo, boolean esCultivoPequeno, boolean tieneSemilla, double calorias, double proteinas, double grasas, double carbohidratos, double porcion) {
        ListaVerduras.add(new Verdura(nombre, tipo, esCultivoPequeno, tieneSemilla, calorias, proteinas, grasas, carbohidratos, porcion));
    }
    
    public void mostrarDatos() {
        for (int i = 0; i < ListaVerduras.size(); i++) {
            System.out.println("VERDURA "+(i+1));
            System.out.println("Nombre "+ListaVerduras.get(i).nombre);
            System.out.println("Tipo "+ListaVerduras.get(i).tipo);
            System.out.print("¿Tiene semilla? ");
            if (ListaVerduras.get(i).tieneSemilla) System.out.println("SI"); else System.out.println("NO");
            System.out.print("¿Es un cultivo pequeño? ");
            if (ListaVerduras.get(i).esCultivoPequeno) System.out.println("SI"); else System.out.println("NO");
            System.out.println("Una porción de "+ListaVerduras.get(i).porcion+" gramos tiene:");
            System.out.println(ListaVerduras.get(i).calorias+" calorias");
            System.out.println(ListaVerduras.get(i).grasas+" grasas");
            System.out.println(ListaVerduras.get(i).proteinas+" proteinas");
            System.out.println(ListaVerduras.get(i).carbohidratos+" carbohidratos");
            System.out.println();
        }
    }
    
    public void mostrarLista() {
        for (int i = 0; i < ListaVerduras.size(); i++) {
            System.out.println("- "+ListaVerduras.get(i).nombre);
        }
    }
    
    public double getCaloriasVerdura(String nombreVerdura) {
        int i;
        double caloriasVerdura=0;
        
        /*Recorre la lista y si encuentra el nombre deseado, guarda el valors de las calorias en la variable caloriasVerdura
        para luego retornar ese valor*/
        for (i=0; i < ListaVerduras.size(); i++) {
            if (nombreVerdura.equalsIgnoreCase(ListaVerduras.get(i).nombre)) {
                caloriasVerdura = ListaVerduras.get(i).calorias;
                break;
            }
        }
        
        return caloriasVerdura;
    }
}
