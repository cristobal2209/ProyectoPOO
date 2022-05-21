/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package proyecto.proyectopoo;

import java.util.Scanner;

/**
 * Esta clase cumple la función de ofrecer las opciones de un menú para usuarios.
 * 
 * @author Cristóbal Cáceres
 * @author Pablo Araya
 * @author René Araya
 * @version 1.0
 */
public class MenuUsuario implements Menu {

    public MenuUsuario() {
    }
    
    /**
     * Imprime un menú de opciones para el menú de un usuario, que este debiese
     * digitar la opción por consola.
     */
    public void MenuTexto() {
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
    public void MenuOpciones(Registro UsuariosRegistrados, Datos DatosVegetales) {
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
                    MenuTexto();
                    
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

}
