package proyecto.proyectopoo;

import java.util.ArrayList;

/**
 * IMPORTANTE: no se incluyó la opción de modificar vegetal consumido ya que 
 * no tendría sentido modificar algo de un vegetal consumido, porque sus
 * atributos (nombre o tipo) son predeterminados. En caso de querer cambiar un
 * vegetal consumido es mejor eliminar el vegetal añadido y nuevamente añadir otro.
 * 
 * Esta clase define los atributos y constructores de un objeto Usuario.
 * Posee una lista de objetos Vegetal ListaVegetalesConsumidos que guarda los 
 * vegetales consumidos de un usuario.
 * 
 * @author Cristóbal Cáceres
 * @author Pablo Araya
 * @author René Araya
 * @version 1.0
 */
public class Usuario {
    
    private String nombre, sexo;
    private double masa, altura, imc=0;
    private ArrayList<Vegetal2> ListaVegetalesConsumidos = new ArrayList<Vegetal2>();
    
    //constructores
    /**
     * Constructor de Usuario con 4 parámetros.
     * 
     * @param nombre guarda el nombre o apodo de un usuario
     * @param masa define el peso o masa de un usuario, en kilogramos
     * @param altura define la altura de un usuario, en metros
     * @param sexo indica el sexo de un usuario
     */
    public Usuario(String nombre, double masa, double altura, String sexo) {
        this.nombre = nombre;
        this.masa = masa;
        this.altura = altura;
        this.sexo = sexo;
    }

    public Usuario() {
    }

    //getters
    
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

    public ArrayList<Vegetal2> getListaVegetalesConsumidos() {
        return ListaVegetalesConsumidos;
    }
    
    //setters

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

    public void setListaVegetalesConsumidos(ArrayList<Vegetal2> ListaVegetalesConsumidos) {
        this.ListaVegetalesConsumidos = ListaVegetalesConsumidos;
    }
    
    //metodos
    /**
     * Calcula el IMC de un usuario y lo guarda en su atributo 'imc'.
     */
    public void calcularImc()   {
        imc = masa/(Math.pow(altura, 2));
    }
    
    /**
     * Crea y añade un nuevo objeto Vegetal consumido a la lista ListaVegetalesConsumidos 
     * de un usuario.
     * 
     * @param nombreVegetal String que contiene el nombre del vegetal a añadir
     * @param tipoVegetal String que contiene el tipo de vegetal a añadir
     */
    public void agregarVegetalConsumido(String nombreVegetal, String tipoVegetal) {
        ListaVegetalesConsumidos.add(new Vegetal2(nombreVegetal, tipoVegetal));
    }
    
    /**
     * Elimina un vegetal consumido de ListaVegetalesConsumidos de un usuario, 
     * para esto recorre ListaVegetalesConsumidos y compara el atributo nombre
     * de cada vegetal con el String nombreVegetal ingresado por parámetro. Si 
     * existe igualdad entonces se elimina dicho objeto de la lista.
     * 
     * @param nombreVegetal String que contiene el nombre del vegetal a eliminar
     * @return 'true' si el vegetal fue eliminado, 'false' en cualquier otro caso
     */
    public boolean eliminarVegetalConsumido(String nombreVegetal) {
        for (int i = 0; i < ListaVegetalesConsumidos.size(); i++) {
            if (nombreVegetal.equalsIgnoreCase(ListaVegetalesConsumidos.get(i).getNombre())) {
                ListaVegetalesConsumidos.remove(i);
                return true;
            }  
        }
        return false;
    }
    
    /**
     * Suma las calorias de todos los vegetales en ListaVegetalesConsumidos.
     * Para esto se ocupa un for que recorre la lista. En cada ciclo for
     * obtiene el tipo del vegetal i de la lista y dependiendo el tipo (fruta o 
     * vegetal) va a recorrer con otro for ListaFrutas o ListaVerduras, para 
     * buscar en dicha lista el vegetal con el mismo nombre que posee el vegetal 
     * i. Una vez encontrado, se obtienen y suman las calorias a una sumatoria de 
     * las calorias del vegetal j encontrado en ListaFrutas o ListaVerduras.
     * 
     * @param DatosVegetales objeto de tipo Datos que contiene ambas listas, ListaFrutas
     *                       y ListaVerduras
     * @return un double que es la suma de las calorías de todos los vegetales
     *         en ListaVegetalesConsumidos de un usuario, en caso que no existan 
     *         vegetales en la lista, retorna 0
     */
    public double getCaloriasConsumidas(Datos DatosVegetales) {
        double sumaCalorias = 0;
        
        for (int i = 0; i < ListaVegetalesConsumidos.size(); i++) {
            if (ListaVegetalesConsumidos.get(i).getTipo().equalsIgnoreCase("fruta")) {
                for (int j = 0; j < DatosVegetales.getListaFrutas().size(); j++) {
                    if (ListaVegetalesConsumidos.get(i).getNombre().equalsIgnoreCase(DatosVegetales.getListaFrutas().get(j).getNombre()))
                        sumaCalorias += DatosVegetales.getListaFrutas().get(j).getCalorias();
                }
            }
            else {
                for (int j = 0; j < DatosVegetales.getListaVerduras().size(); j++) {
                    if (ListaVegetalesConsumidos.get(i).getNombre().equalsIgnoreCase(DatosVegetales.getListaVerduras().get(j).getNombre()))
                        sumaCalorias += DatosVegetales.getListaVerduras().get(j).getCalorias();
                }
            }
        }
        return sumaCalorias;
    }
    
    /**
     * Imprime los vegetales consumidos por un usuario en formato (nombre, nombre2).
     */
    public void mostrarVegetalesConsumidos() {
        for (int i = 0; i < ListaVegetalesConsumidos.size(); i++) {
            if (i==0)
                System.out.print(ListaVegetalesConsumidos.get(i).getNombre());
            else
                System.out.print(", "+ListaVegetalesConsumidos.get(i).getNombre());
        }
        System.out.println("");
    }
}