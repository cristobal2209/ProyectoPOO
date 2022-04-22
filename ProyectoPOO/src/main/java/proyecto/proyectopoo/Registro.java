/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package proyecto.proyectopoo;

import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author crist
 */
public class Registro {
    private ArrayList<Usuario> ListaUsuarios = new ArrayList<Usuario>();
    Scanner input = new Scanner(System.in);
    
    public boolean getIsListaUsuariosEmpty() {
        if (ListaUsuarios.isEmpty()) 
            return true;
        return false;
    }
     
    public Usuario getUsuario(String nombre) {
    	for (int i=0; i<ListaUsuarios.size(); i++) {
            if (nombre.equalsIgnoreCase(ListaUsuarios.get(i).getNombre())) {
                return ListaUsuarios.get(i);
            }
    	}
    	return null;
    }
    
    public boolean buscarUsuario1(String nombre) {
    	for (int i=0; i<ListaUsuarios.size(); i++) {
            if (nombre.equalsIgnoreCase(ListaUsuarios.get(i).getNombre())) {
                return true;
            }
    	}
    	return false;
    }
    
    public boolean crearUsuario(String nombre) {
        String sexo;
        double masa, altura;
        
        if (getUsuario(nombre) == null) {
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
    
    public boolean modificarUsuario(Usuario usuarioModificar, int opcion) { 
        switch (opcion) {
            case 1:
                System.out.println("Ingresa nuevo nombre");
                usuarioModificar.setNombre(input.next());
                return true;
    			
            case 2:
                System.out.println("Ingresa nuevo peso");
                usuarioModificar.setMasa(input.nextDouble());
                return true;
    			
            case 3:
                System.out.println("Ingresa nueva altura");
                usuarioModificar.setAltura(input.nextDouble());
                return true;
    			
            default:
        }
        return false;
    }
    
    public boolean eliminarUsuario(String nombreEliminar) {
        if (getUsuario(nombreEliminar) != null) {
            for (int i=0; i < ListaUsuarios.size(); i++) {
                if (nombreEliminar.equalsIgnoreCase(ListaUsuarios.get(i).getNombre())) {
                    ListaUsuarios.remove(i);
                    return true;
                }
            }
        }
        return false;
    }
    
    public void imprimirListaUsuarios(){
        for (int i=0; i < ListaUsuarios.size(); i++) {
            System.out.println("- "+ListaUsuarios.get(i).getNombre());
        }
    }
    
    public void mostrarUsuariosRegistrados() {
        for (int i=0; i < ListaUsuarios.size(); i++) {
            System.out.println("Usuario N"+(i+1));
            System.out.println("Nombre: "+ListaUsuarios.get(i).getNombre());
        }
    }
}
