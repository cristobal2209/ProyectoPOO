package proyecto.proyectopoo;

import java.util.ArrayList;
import java.util.Scanner;

public class Usuario {
    
    //atributos
    
    private String nombre;
    private String sexo;
    private double masa;
    private double altura;
    private double imc;
    private ArrayList<Usuario> ListaUsuarios = new ArrayList<Usuario>();
    private ArrayList<Vegetal> ListaVegetalesConsumidos = new ArrayList<Vegetal>();
    
    //constructores
    
    public Usuario() {
        
    }
    
    public Usuario(String nombre, double masa, double altura, String sexo) {
        this.nombre = nombre;
        this.masa = masa;
        this.altura = altura;
        this.sexo = sexo;
    }

    //accesores
    
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
    
    //mutadores

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
    
    //metodos
    
    public void calcularIMC()   {
        imc = masa/(Math.pow(altura, 2));
    }
    
    public double getIMC(String nombre) {
        Usuario usuario;
        
        usuario = buscar(nombre);
        
        if (usuario != null) {
            usuario.calcularIMC();
            return usuario.getImc();
        }
        else 
            return 0;
    }
    
    public boolean getIsListaUsuariosEmpty() {
        if (ListaUsuarios.isEmpty()) 
            return true;
        else
            return false;
    }
        
    public Usuario buscar(String nombre) {
    	int i;
    	
    	for (i=0; i<ListaUsuarios.size(); i++) {
            if (nombre.equalsIgnoreCase(ListaUsuarios.get(i).getNombre())) {
                return ListaUsuarios.get(i);
            }
    	}
    	return null;
    }
    
    public boolean crear(String nombre) {
        Scanner input = new Scanner(System.in);
        String sexo1;
        double masa1, altura1;
        
        /*busca a un usuario con el nombre ingresado, si no encuentra usuario con ese nombre, lo crea*/
        if (buscar(nombre) == null) {
            System.out.println("Ingresa tu peso en kilogramos");
            masa1 = input.nextDouble();
            System.out.println("Ingresa tu altura en metros");
            altura1 = input.nextDouble();
            System.out.println("¿Tu sexo es femenino (F) o masculino (M)?");
            sexo1 = input.next();
        
            //se añade a ListaUsuarios un nuevo objeto Usuario
            ListaUsuarios.add(new Usuario(nombre, masa1, altura1, sexo1));
            return true;
        }
        else 
            return false;
    }
        
    public boolean modificar(String nombre) {
    	Scanner input = new Scanner(System.in);
        Usuario usuarioModificar = buscar(nombre);
        int opcion;
        
        if (usuarioModificar != null) {
            System.out.println("¿Que quieres modificar?");
            do {
                System.out.println("1...Nombre");
                System.out.println("2...Peso");
                System.out.println("3...Altura");
                System.out.println("0..Atras");
                opcion = input.nextInt();
                switch (opcion) {
                    case 1:
                        System.out.println("Ingresa un nuevo nombre");
                        usuarioModificar.setNombre(input.next());
                        System.out.println("Nombre cambiado!");
                        break;
    			
                    case 2:
                        System.out.println("Ingresa el nuevo peso");
                        usuarioModificar.setMasa(input.nextDouble());
                        System.out.println("Peso cambiado!");
                        break;
    			
                    case 3:
                        System.out.println("Ingresa la nueva altura");
                        usuarioModificar.setAltura(input.nextDouble());
                        System.out.println("Altura cambiada!");
                        break;
    			
                    default:
                }
                if (opcion != 0){
                    System.out.println("¿Quieres modificar algo mas?");
                    System.out.println("1..SI");
                    System.out.println("2..NO");
                    if (input.nextInt() == 2)
                        opcion = 0;
                }
            }while(opcion!=0);
            return true;
        }
        else 
            return false;
    }
    
    public boolean eliminar(String nombreEliminar) {
        int i;
        
        if (buscar(nombreEliminar) != null) {
            for (i=0; i < ListaUsuarios.size(); i++) {
                if (nombreEliminar.equalsIgnoreCase(ListaUsuarios.get(i).getNombre())) {
                    ListaUsuarios.remove(i);
                    return true;
                }
            }
        }
        return false;
    }
    
    public boolean eliminarVegetalConsumido(String nombreVegetal, String nombreUsuario) {
        Usuario usuario = buscar(nombreUsuario);
        int i;
        
        for (i = 0; i < usuario.ListaVegetalesConsumidos.size(); i++) {
            if (nombreVegetal.equalsIgnoreCase(usuario.ListaVegetalesConsumidos.get(i).getNombre())) {
                usuario.ListaVegetalesConsumidos.remove(i);
                return true;
            }  
        }
        return false;
    }
    
    public boolean agregarVegetalConsumido(String nombreUsuario, String nombreVegetal) {
        Usuario usuario = buscar(nombreUsuario);
        
        if (usuario != null) {
            usuario.ListaVegetalesConsumidos.add(new Vegetal(nombreVegetal));
            return true;
        }
        else 
            return false;
    }
    
    public double getCaloriasConsumidas(String nombreUsuario, Verdura datosVerduras, Fruta datosFrutas) {
        Usuario usuario = buscar(nombreUsuario);
        double sumaCalorias=0;
        int j;
        
        if (usuario != null) {
            for (j = 0; j < usuario.ListaVegetalesConsumidos.size(); j++) {
                sumaCalorias += datosVerduras.getCaloriasVerdura(usuario.ListaVegetalesConsumidos.get(j).getNombre());
                sumaCalorias += datosFrutas.getCaloriasFruta(usuario.ListaVegetalesConsumidos.get(j).getNombre());
            }
        }
        return sumaCalorias;
    }

    public void mostrarLista(){
        //si ListaUsuarios no está vacía
        if (!ListaUsuarios.isEmpty()) {
           for (int i=0; i < ListaUsuarios.size(); i++) {
               System.out.println("- "+ListaUsuarios.get(i).nombre);
           }
        } 
        else {
           System.out.println("Aún no se ha ingresado un usuario");
        }
    }
        
    public void mostrarVegetalesConsumidos(String nombre) {
        Usuario usuario = buscar(nombre);
        
        if (usuario != null) {
            if (usuario.ListaVegetalesConsumidos.isEmpty())
                    System.out.println("Aun no se agregan vegetales");
            for (int i=0; i < usuario.ListaVegetalesConsumidos.size(); i++) {
                if (i==0)
                    System.out.print(usuario.ListaVegetalesConsumidos.get(i).getNombre());
                else
                    System.out.print(", "+usuario.ListaVegetalesConsumidos.get(i).getNombre());
            }
        }
        else 
            System.out.println("Error al mostrar vegetales consumidos");
    }
    
    public void mostrarRegistrados() {
        //si ListaUsuarios no está vacía
        if (!ListaUsuarios.isEmpty()) {
            for (int i=0; i < ListaUsuarios.size(); i++) {
                System.out.println("Usuario N"+(i+1));
                System.out.println("Nombre: "+ListaUsuarios.get(i).nombre);
            }
        } else {
            System.out.println("No hay usuarios que mostrar");
        }
    }
}