
package proyecto.proyectopoo;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 * 
 * @author Pablo Araya, René Araya, Cristóbal Cáceres
 * 
 * Consideración: En la ruta src/test/java/(archivos) se dejan 2 archivos .txt que contienen 
 * los vegetales a guardar, la diferencia es que en uno los datos están separados por "," y
 * en el otro con ".". Dependiendo de la versión de netbeans, puede o no haber un error al
 * intentar interpretar un double con "," o con ".". En el que caso que tenga un error de 
 * lectura del archivo .txt se le pide cambiar la ruta del archivo en la linea 159 de esta clase a
 * "src/test/java/datos2.txt" o "src/test/java/datos.txt".
 */
public class Principal {

    public static Verdura verdura;
    public static Fruta fruta;
    public static Usuario usuario;
    public static int MAX_VERDURAS = 3;
    public static int MAX_FRUTAS = 3;
    
    public static Verdura datosVerduras = new Verdura();
    public static Fruta datosFrutas = new Fruta();
    
    public static void textoMenuPrincipal() {
        System.out.println("Seleccione una opción");
        System.out.println("1...Crear un usuario");
        System.out.println("2...Mostrar los usuarios");
        System.out.println("3...Acceder a un usuario");
        System.out.println("4...Eliminar un usuario");
        System.out.println("0...Salir");
        System.out.println();
    }
    
    public static void textoMenuUsuario() {
        System.out.println("Seleccione una opción");
        System.out.println("1...Ver IMC");
        System.out.println("2...Anadir vegetal consumido");
        System.out.println("3...Mostrar vegetales consumidos");
        System.out.println("4...Calcular calorias consumidas");
        System.out.println("5...Modificar datos");
        System.out.println("0...Volver atrás");
        System.out.println();
    }
    
    public static void menuUsuario(Usuario usuario) {
        Scanner input = new Scanner(System.in);
        int opcionUsuario;
        String nombreUsuario, nombreVegetal;
        
        //si la ListaUsuarios no está vacía
        if (!usuario.getIsListaUsuariosEmpty()) {
            System.out.println("¿A que usuario deseas acceder?");
            usuario.mostrarLista();
            nombreUsuario = input.next();
            if (usuario.buscar(nombreUsuario) != null) {
                do{
                    //se imprime texto de menu usuario
                    textoMenuUsuario();
                    
                    //se lee opcion de usuario desde teclado
                    opcionUsuario = input.nextInt();
                    
                    switch(opcionUsuario) {
                        //mostrar IMC
                        case 1:
                            double imc = usuario.getIMC(nombreUsuario); 
                            
                            if (imc == 0)
                                System.out.println("Aún no se ha consumido algún vegetal");
                            else
                                System.out.println("Tu IMC es: "+imc);
                            break;
                        
                        //añadir vegetal consumido
                        case 2:
                            System.out.println("¿Que consumiste?");
                            datosFrutas.mostrarLista();
                            datosVerduras.mostrarLista();
                            nombreVegetal = input.next();
                            if (usuario.agregarVegetalConsumido(nombreUsuario, nombreVegetal))
                                System.out.println("Vegetal agregado");
                            else
                                System.out.println("No se pudo agregar vegetal");
                            break;
                            
                        //mostrar vegetales consumidos
                        case 3:
                            usuario.mostrarVegetalesConsumidos(nombreUsuario);
                            break;
                        
                        //calcular calorias consumidas
                        case 4:
                            System.out.println("Total calorias consumidas:"+usuario.getCaloriasConsumidas(nombreUsuario, datosVerduras, datosFrutas)+" gramos");
                            break;
                        
                        //modificar datos de un usuario
                        case 5:
                            if (!usuario.modificar(nombreUsuario))
                                System.out.println("No se pudo modificar el usuario");
                            break;
                        
                        //eliminar vegetal consumido
                        case 6:
                            nombreVegetal = input.next();
                            if (usuario.eliminarVegetalConsumido(nombreVegetal, nombreUsuario)) {
                                System.out.println("Vegetal consumido eliminado");
                            }
                            else
                                System.out.println("No se pudo eliminar el vegetal consumido");
                            break;
                        
                        default:
                    }
                }while(opcionUsuario!=0);
            }
            else
                System.out.println("El usuario con ese nombre no existe");
        }
        else
            System.out.println("Aún no hay usuarios");
    }
    
    public static void menuPrincipal(Usuario usuario) {
        Scanner input = new Scanner(System.in);
        int opcion;
        
        do{
            //se imprime texto de menu principal
            textoMenuPrincipal();
            
            //se lee opcion de menu desde teclado
            opcion = input.nextInt();
            
            switch (opcion) {
                
                //crear usuario
                case 1:
                String nombre;
                System.out.println("Ingresa tu nombre");
                nombre = input.next();
                if (usuario.crear(nombre)) {
                    System.out.println("Usuario creado con éxito!");
                }
                else {
                    System.out.println("El usuario ya se encuentra registrado");
                }
                break;
                    
                //ver usuarios
                case 2:
                    usuario.mostrarRegistrados();
                    break;
                
                //ver datos de un usuario
                case 3:
                    menuUsuario(usuario);
                    break;
                	
                //eliminar un usuario
                case 4:
                    String nombreEliminar;
                    
                    System.out.println("¿Que usuario quieres eliminar?");
                    usuario.mostrarLista();
                    nombreEliminar = input.next();
                    if (!usuario.getIsListaUsuariosEmpty()) {
                        if (usuario.eliminar(nombreEliminar))
                            System.out.println("Usuario eliminado");
                        else
                            System.out.println("No se pudo eliminar el usuario");
                    }
                    else
                        System.out.println("No hay usuarios que eliminar");
                    break;
                    
                default: 
            }
        }while(opcion!=0);
    }
    
    public static void leerDesdeArchivo() throws FileNotFoundException {
        String nombre;
        String tipo;
        boolean esCultivoPequeno;
        boolean tieneSemilla;
        double calorias;
        double proteinas;
        double grasas;
        double carbohidratos;
        double porcion;

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
                
                datosVerduras.leerDesdeArchivo(nombre, tipo, esCultivoPequeno, tieneSemilla, calorias, proteinas, grasas, carbohidratos, porcion);
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
                
                datosFrutas.leerDesdeArchivo(nombre, tipo, tieneSemilla, calorias, proteinas, grasas, carbohidratos, porcion);
            }
            
        } catch (FileNotFoundException e) {
            System.out.println("Ha ocurrido un error de lectura del archivo");
        }
    }
    
    public static void main(String[] args) throws FileNotFoundException {
        leerDesdeArchivo();
        
        usuario = new Usuario();
        
        menuPrincipal(usuario);
    }
    
}
