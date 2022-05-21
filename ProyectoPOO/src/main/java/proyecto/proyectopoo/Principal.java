
package proyecto.proyectopoo;

import java.io.FileNotFoundException;

/**
 * **********COMENTARIO ENTREGA**********
 * EP4.1: 1) linea 101, en clase Usuario. 2) linea 226, en clase Registro.
 * EP4.2: las clases MenuPrincipal y MenuUsuario ocupan sobrescritura de metodos.
 * EP4.3: la clase abstracta Vegetal es superclase de Verdura y Fruta.
 * EP4.4: las clases MenuPrincipal Y MenuUsuario implementan a la interfaz Menu.
 * 
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
        MenuPrincipal menuPrincipal = new MenuPrincipal();
        
        DatosVegetales.leerDesdeArchivo();
        menuPrincipal.MenuOpciones(UsuariosRegistrados, DatosVegetales);
    }
    
}
