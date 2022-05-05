/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package proyecto.proyectopoo;

import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * Esta clase se encarga de controlar una lista de objetos Usuario mediante las 
 * funciones de crear, buscar, eliminar, modificar e imprimir los usuarios. Además posee
 * opciones administrativas de generar un archivo .txt de los usuarios.
 * 
 * @author Cristóbal Cáceres
 * @author Pablo Araya
 * @author René Araya
 * @version 1.0
 */
public class Registro {
    
    private ArrayList<Usuario> ListaUsuarios = new ArrayList<Usuario>();

    //getters
    public ArrayList<Usuario> getListaUsuarios() {
        return ListaUsuarios;
    } 
    
    //metodos
    /**
     * Comprueba si ListaUsuarios está vacía o no, retornando un boolean.
     * 
     * @return 'true' si la lista está vacía, 'false' si la lista no está vacía
     */
    public boolean getIsListaUsuariosEmpty() {
        return ListaUsuarios.isEmpty();
    }
    
    /**
     * Busca y retorna un objeto Usuario dentro de ListaUsuarios, con el
     * atributo 'nombre' del objeto se compara con el parámetro "nombre" 
     * ingresado mientras se recorre la lista. Si el usuario existe lo retorna, 
     * en cualquier otro caso retorna null.
     * 
     * @param nombre un string que guarda un nombre de un usuario, con esto se
     *               compara dentro de la lista
     * @return el objecto Usuario que coincidió con el parámetro nombre, null 
     *         en cualquier otro caso
     */
    public Usuario getUsuario(String nombre) {
    	for (int i=0; i<ListaUsuarios.size(); i++) {
            if (nombre.equalsIgnoreCase(ListaUsuarios.get(i).getNombre())) {
                return ListaUsuarios.get(i);
            }
    	}
    	return null;
    }
    
    /**
     * Busca si existe un objeto Usuario dentro de ListaUsuarios, comparando el
     * atributo 'nombre' del objeto con el parámetro "nombre" ingresado, mientras 
     * se recorre ListaUsuarios. Si el usuario existe retorna 'true', en 
     * cualquier otro caso retorna 'false'.
     * 
     * @param nombre un string que guarda un nombre de un usuario, con esto se
     *               compara dentro de la lista
     * @return 'true' si existe un usuario con el nombre ingresado por parámetro,
     *         'false' si no existe
     */
    public boolean buscarUsuario(String nombre) {
    	for (int i=0; i<ListaUsuarios.size(); i++) {
            if (nombre.equalsIgnoreCase(ListaUsuarios.get(i).getNombre()))
                return true;
    	}
    	return false;
    }
    
    /**
     * Crea y añade un nuevo objeto Usuario a ListaUsuarios, para esto pide un 
     * nuevo nombre por teclado y verifica con el método buscarUsuario() que no 
     * exista un usuario con tal nombre, luego se preguntan los demás datos, se 
     * crea y añade el nuevo usuario a la lista.
     * 
     * @return 'true' si se creó y añadió correctamente el usuario, 'false' si
     *         ya existía un usuario con el nombre ingresado
     */
    public boolean crearUsuario() {
        String sexo, nombre;
        double masa, altura;
        Scanner input = new Scanner(System.in);
        
        System.out.println("Ingresa tu nombre");
        nombre = input.next();
        if (!buscarUsuario(nombre)) {
            System.out.println("Ingresa tu peso en kilogramos");
            masa = input.nextDouble();
            System.out.println("Ingresa tu altura en metros");
            altura = input.nextDouble();
            System.out.println("¿Tu sexo es femenino (F) o masculino (M)?");
            sexo = input.next();
        
            //se añade a ListaUsuarios un nuevo objeto Usuario
            ListaUsuarios.add(new Usuario(nombre, masa, altura, sexo));
            return true;
        }
        return false;
    }
    
    /**
     * Modifica un atributo de un objeto Usuario que es ingresado por parámetro 
     * y dependiendo la opción es lo que se modificará. El nuevo dato es ingresado 
     * por teclado. Si la modificación fue exitosa retorna 'true', en caso contrario 
     * retorna 'false'.
     * 
     * @param usuarioModificar un objecto Usuario que se encuentra en ListaUsuarios
     * @param opcion un número que representa el atributo que se modificará
     * @return 'true' si hubo modificación del atributo, 'false' en cualquier otro caso
     */
    public boolean modificarUsuario(Usuario usuarioModificar, int opcion) { 
        Scanner input = new Scanner(System.in);
        switch (opcion) {
            //modifica el nombre
            case 1:
                System.out.println("Ingresa nuevo nombre");
                usuarioModificar.setNombre(input.next());
                return true;
    			
            //modifica la masa
            case 2:
                System.out.println("Ingresa nuevo peso");
                usuarioModificar.setMasa(input.nextDouble());
                return true;
    			
            //modifica la altura
            case 3:
                System.out.println("Ingresa nueva altura");
                usuarioModificar.setAltura(input.nextDouble());
                return true;
    			
            default:
                System.out.println("Opcion no valida");
        }
        return false;
    }
    
    /**
     * Busca y elimina de ListaUsuarios un objeto Usuario. Ingresa por parámetro
     * el nombre de un usuario a eliminar y con buscarUsuario() se revisa si aquel
     * usuario existe, en tal caso se recorre ListaUsuarios para saber su posición
     * y una vez encontrado se elimina. En caso que no encuentre un usuario por
     * nombre termina el método.
     * 
     * @param nombreEliminar string que contiene el nombre del usuario a eliminar,
     *                       se ocupa para verificar la existencia del usuario y luego
     *                       para comparar con el nombre de los usuarios en la lista
     * @return 'true' si se eliminó un usuario, 'false' en cualquier otro caso.
     */
    public boolean eliminarUsuario(String nombreEliminar) {
        if (buscarUsuario(nombreEliminar)) {
            for (int i=0; i < ListaUsuarios.size(); i++) {
                if (nombreEliminar.equalsIgnoreCase(ListaUsuarios.get(i).getNombre())) {
                    ListaUsuarios.remove(i);
                    return true;
                }
            }
        }
        return false;
    }
    
    /**
     * Imprime los usuarios en formato "- Nombre". Esto se ocupa para mostrar
     * la lista de usuarios registrados y que el usuario ingrese por consola a 
     * que usuario quiere acceder, escribiendo su nombre.
     */
    public void imprimirListaUsuarios(){
        for (int i=0; i < ListaUsuarios.size(); i++) {
            System.out.println("- "+ListaUsuarios.get(i).getNombre());
        }
    }
    
    /**
     * Imprime los usuarios en formato "Usuario N1:/n Nombre". Esto se ocupa
     * para mostrar de mejor forma la cantidad y nombre de usuarios registrados.
     */
    public void mostrarUsuariosRegistrados() {
        for (int i=0; i < ListaUsuarios.size(); i++) {
            System.out.println("Usuario N"+(i+1));
            System.out.println("Nombre: "+ListaUsuarios.get(i).getNombre());
        }
    }
    
    /**
     * Crea un archivo .txt en la ruta src/test/java/usuarios.txt con todos los
     * usuarios registrados y los vegetales consumidos por cada uno.
     * 
     * @return 'true' si el archivo fue creado correctamente y 'false' cuando 
     *         ocurra alguna eventualidad en la creación del archivo.
     */
    public boolean crearArchivoUsuarios() {
        try {
            PrintWriter writer = new PrintWriter("src/test/java/usuarios.txt", "UTF-8");
            for (int i = 0; i < ListaUsuarios.size(); i++) {
                writer.println("Usuario "+(i+1)+(": ")+ListaUsuarios.get(i).getNombre() );
                writer.print("Vegetales consumidos de "+ListaUsuarios.get(i).getNombre()+": ");
                for (int j = 0; j < ListaUsuarios.get(i).getListaVegetalesConsumidos().size(); j++) {
                    writer.print(ListaUsuarios.get(i).getListaVegetalesConsumidos().get(j).getNombre()+" ");
                }
                writer.println();
            }
            writer.close();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }
}
