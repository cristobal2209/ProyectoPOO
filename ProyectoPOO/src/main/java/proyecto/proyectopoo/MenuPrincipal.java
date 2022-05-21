/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package proyecto.proyectopoo;

import java.util.Scanner;

/**
 * Esta clase cumple la función de ofrecer las opciones de un menú principal.
 * 
 * @author Cristóbal Cáceres
 * @author Pablo Araya
 * @author René Araya
 * @version 1.0
 */
public class MenuPrincipal implements Menu{

    public MenuPrincipal() {
    }
    
    /**
     * Imprime un menú de opciones para el menú princial, que el usuario debise 
     * digitar la opción por consola.
     */
    public void MenuTexto() {
        System.out.println("Seleccione una opción");
        System.out.println("1...Crear un usuario");
        System.out.println("2...Mostrar los usuarios");
        System.out.println("3...Acceder a un usuario");
        System.out.println("4...Eliminar un usuario");
        System.out.println("5...Generar reporte de usuarios registrados");
        System.out.println("0...Salir");
        System.out.println();
    }
    
    /**
     * Maneja el menú principal del programa, con opciones: crear usuario, ver 
     * usuarios registrados, ver datos de un usuario, eliminar un usuario y crear
     * un archivo .txt con los datos de los usuarios registrados.
     * 
     * @param UsuariosRegistrados objeto de tipo Registro que guarda la lista de
     *                            objetos Usuarios registrados
     * @param DatosVegetales objeto de tipo Datos que guarda en dos listas los datos
     *                       de frutas y verduras respectivamente
     */
    public void MenuOpciones(Registro UsuariosRegistrados, Datos DatosVegetales) {
        Scanner input = new Scanner(System.in);
        MenuUsuario menuUsuario = new MenuUsuario();
        String nombreEliminar;
        int opcion;
        
        do{
            //se imprime texto de menu principal
            MenuTexto();
            
            //se lee opcion de menu desde teclado
            opcion = input.nextInt();
            
            switch (opcion) {
                
                //crear usuario
                case 1:
                    if (UsuariosRegistrados.crearUsuario())
                        System.out.println("Usuario creado con éxito!");
                    else
                        System.out.println("El usuario ya se encuentra registrado");
                    break;
                    
                //ver usuarios
                case 2:
                    UsuariosRegistrados.mostrarUsuariosRegistrados();
                    break;
                
                //ver datos de un usuario
                case 3:
                    menuUsuario.MenuOpciones(UsuariosRegistrados, DatosVegetales);
                    break;
                	
                //eliminar un usuario
                case 4:
                    System.out.println("¿Que usuario quieres eliminar?");
                    UsuariosRegistrados.imprimirListaUsuarios();
                    nombreEliminar = input.next();
                    if (!UsuariosRegistrados.getIsListaUsuariosEmpty()) {
                        if (UsuariosRegistrados.eliminarUsuario(nombreEliminar))
                            System.out.println("Usuario eliminado");
                        else
                            System.out.println("No se pudo eliminar el usuario");
                    }
                    else
                        System.out.println("No hay usuarios que eliminar");
                    break;
                
                //crear un archivo que contiene datos de los usuarios
                case 5:
                    if (UsuariosRegistrados.crearArchivoUsuarios())
                        System.out.println("Archivo generado con exito");
                    else
                        System.out.println("Error al generar archivo");
                    break;
                    
                default:
                    if (opcion != 0)
                        System.out.println("Ingrese opcion valida");
            }
        }while(opcion!=0);
    }
}
