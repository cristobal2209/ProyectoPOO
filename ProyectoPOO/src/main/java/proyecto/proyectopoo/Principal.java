
package proyecto.proyectopoo;

import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 * La función de este programa es manejar y seguir la dieta de frutas y verduras de 
 * diferentes usuarios, otorgando herramientas como el cálculo de IMC, cálculo
 * de información nutrucional de vegetales ingeridos, creación de documentos y
 * futuras opciones que se planean implementar, como por ejemplo: mostrar
 * información adicional y curiosa de cada vegetal, como plantar dicho vegetal y alertas
 * de exceso o falta de algún nutriente.
 * 
 * @author Cristóbal Cáceres
 * @author Pablo Araya
 * @author René Araya
 * @version 1.0
 */
public class Principal {
    
    public static int MAX_VERDURAS = 3;
    public static int MAX_FRUTAS = 3;
    
    /**
     * Imprime un menú de opciones para el menú princial, que el usuario debise 
     * digitar la opción por consola.
     */
    public static void textoMenuPrincipal() {
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
     * Imprime un menú de opciones para el menú de un usuario, que este debiese
     * digitar la opción por consola.
     */
    public static void textoMenuUsuario() {
        System.out.println("Seleccione una opción");
        System.out.println("1...Ver IMC");
        System.out.println("2...Anadir vegetal consumido");
        System.out.println("3...Mostrar vegetales consumidos");
        System.out.println("4...Calcular calorias consumidas");
        System.out.println("5...Modificar datos");
        System.out.println("6...Eliminar vegetal Consumido");
        System.out.println("0...Volver atrás");
        System.out.println();
    }
    
    /**
     * Maneja el menú de usuario, aquí se puede acceder a opciones de usuario: calcular
     * IMC, añadir un vegetal consumido, mostrar los vegetales consumidos, 
     * calcular el total de calorías consumidas, modificar los datos del usuario y
     * eliminar un vegetal consumido. Primero se verifica que ListaUsuarios no esté 
     * vacía, para luego verificar que el usuario con el nombre ingresado por teclado
     * existe en la lista.
     * 
     * @param UsuariosRegistrados objeto de tipo Registro que guarda la lista de
     *                            objetos Usuarios registrados
     * @param DatosVegetales objeto de tipo Datos que guarda en dos listas los datos
     *                       de frutas y verduras respectivamente
     */
    public static void menuUsuario(Registro UsuariosRegistrados, Datos DatosVegetales) {
        Scanner input = new Scanner(System.in);
        String nombreVegetal, tipoVegetal;
        Usuario usuario;
        int opcionUsuario, opcionModificar;
        
        if (!UsuariosRegistrados.getIsListaUsuariosEmpty()) {
            System.out.println("¿A que usuario deseas acceder?");
            UsuariosRegistrados.imprimirListaUsuarios();
            usuario = UsuariosRegistrados.getUsuario(input.next());
            if (usuario != null) {
                do{
                    //se imprime texto de menu usuario
                    textoMenuUsuario();
                    
                    //se lee opcion de usuario desde teclado
                    opcionUsuario = input.nextInt();
                    
                    switch(opcionUsuario) {
                        //mostrar IMC
                        case 1:
                            usuario.calcularImc();
                            if (usuario.getImc() == 0)
                                System.out.println("Aún no se ha consumido algún vegetal");
                            else
                                System.out.println("Tu IMC es: "+usuario.getImc());
                            break;
                        
                        //añadir vegetal consumido
                        case 2:
                            System.out.println("¿Que consumiste?");
                            DatosVegetales.mostrarListaFrutas();
                            DatosVegetales.mostrarListaVerduras();
                            nombreVegetal = input.next();
                            if (DatosVegetales.vegetalExiste(nombreVegetal)) {
                                tipoVegetal = DatosVegetales.getTipoVegetal(nombreVegetal);
                                usuario.agregarVegetalConsumido(nombreVegetal, tipoVegetal);
                                System.out.println("Vegetal agregado");
                            }
                            else
                                System.out.println("Ingrese un vegetal valido");
                            break;
                            
                        //mostrar vegetales consumidos
                        case 3:
                            usuario.mostrarVegetalesConsumidos();
                            break;
                        
                        //calcular calorias consumidas
                        case 4:
                            System.out.println("Total calorias consumidas:"+usuario.getCaloriasConsumidas(DatosVegetales)+" gramos");
                            break;
                        
                        //modificar datos de un usuario
                        case 5:
                            System.out.println("¿Qué vas a modificar?");
                            System.out.println("1...Nombre");
                            System.out.println("2...Peso");
                            System.out.println("3...Altura");
                            System.out.println("0...Volver Atrás");
                            opcionModificar = input.nextInt();
                            if (opcionModificar != 0) {
                                if (UsuariosRegistrados.modificarUsuario(usuario, opcionModificar))
                                    System.out.println("Usuario modificado");
                            }
                            break;
                        
                        //eliminar vegetal consumido
                        case 6:
                            nombreVegetal = input.next();
                            if (usuario.eliminarVegetalConsumido(nombreVegetal))
                                System.out.println("Vegetal consumido eliminado");
                            else
                                System.out.println("No se pudo eliminar el vegetal consumido");
                            break;
                        
                        default:
                            if (opcionUsuario != 0)
                                System.out.println("Ingrese opcion valida");
                    }
                }while(opcionUsuario!=0);
            }
            else
                System.out.println("El usuario con ese nombre no existe");
        }
        else
            System.out.println("Aún no hay usuarios");
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
    public static void menuPrincipal(Registro UsuariosRegistrados, Datos DatosVegetales) {
        Scanner input = new Scanner(System.in);
        String nombreEliminar;
        int opcion;
        
        do{
            //se imprime texto de menu principal
            textoMenuPrincipal();
            
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
                    menuUsuario(UsuariosRegistrados, DatosVegetales);
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
    
    /**
     * Método principal del programa, aquí se crean los objetos UsuariosRegistrados
     * y DatosVegetales, en los cuales se encargan de almacenar, manejar y crear 
     * los usuarios y vegetales, respectivamente.
     * 
     * @param args
     * @throws FileNotFoundException 
     */
    public static void main(String[] args) throws FileNotFoundException {
        Registro UsuariosRegistrados = new Registro();
        Datos DatosVegetales = new Datos();
        
        DatosVegetales.leerDesdeArchivo();
        menuPrincipal(UsuariosRegistrados, DatosVegetales);
    }
    
}
