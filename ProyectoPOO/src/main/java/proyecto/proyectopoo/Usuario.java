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
    
    public void crear() {
        Scanner input = new Scanner(System.in);
        String nombre, sexo;
        double masa, altura;
        
        System.out.println("Ingresa tu nombre");
        nombre = input.next();
        System.out.println("Ingresa tu peso en kilogramos");
        masa = input.nextDouble();
        System.out.println("Ingresa tu altura en metros");
        altura = input.nextDouble();
        System.out.println("¿Tu sexo es femenino (F) o masculino (M)?");
        sexo = input.next();
        
        //se añade a ListaUsuarios un nuevo objeto Usuario
        ListaUsuarios.add(new Usuario(nombre, masa, altura, sexo));
        
        System.out.println("Usuario creado con éxito.");
        System.out.println();
    }
        
    public void modificar(String nombre) {
    	Usuario usuarioModificar;
    	Scanner input = new Scanner(System.in);

    	int opcion;
    	
    	usuarioModificar = buscar(nombre);
    	
        if (usuarioModificar != null) {
            System.out.println("¿Que quieres modificar?");
            System.out.println("1...Nombre");
            System.out.println("2...Peso");
            System.out.println("3...Altura");
            opcion = input.nextInt();
    	
            switch (opcion) {
                case 1:
                    System.out.println("Ingresa un nuevo nombre");
                    usuarioModificar.setNombre(input.next());
                    break;
    			
                case 2:
                    System.out.println("Ingresa el nuevo peso");
                    usuarioModificar.setMasa(input.nextDouble());
                    break;
    			
    		case 3:
                    System.out.println("Ingresa la nueva altura");
                    usuarioModificar.setAltura(input.nextDouble());
                    break;
    			
            	default:
            }
        }
        else 
            System.out.println("Usuario no encontrado");
    }
    
    public void mostrarLista(){
        //si ListaUsuarios no está vacía
        if (!ListaUsuarios.isEmpty()) {
           for (int i=0; i < ListaUsuarios.size(); i++) {
               System.out.println("- "+ListaUsuarios.get(i).nombre);
           }
           System.out.println();
        } 
        else {
           System.out.println("Aún no se ha ingresado un usuario");
           System.out.println();
        }
    }
    
    public void eliminar() {
        Scanner input = new Scanner(System.in);
        String nombreEliminar;
        int i;
       
        if (!ListaUsuarios.isEmpty()){
            mostrarLista();
            System.out.println("¿Que usuario quieres eliminar?");
            nombreEliminar = input.next();
            
            if (buscar(nombreEliminar) != null) {
                for (i=0; i < ListaUsuarios.size(); i++) {
                    if (nombreEliminar.equalsIgnoreCase(ListaUsuarios.get(i).getNombre())) {
                        ListaUsuarios.remove(i);
                        System.out.println("Usuario eliminado");
                    }
                }
            }
            else {
                System.out.println("Usuario ya eliminado");
            }
        }
        else {
            System.out.println("No hay usuarios");
        }
    }
    
    public void mostrarRegistrados() {
        //si ListaUsuarios no está vacía
        if (!ListaUsuarios.isEmpty()) {
            for (int i=0; i < ListaUsuarios.size(); i++) {
                System.out.println("Usuario N"+(i+1));
                System.out.println("Nombre: "+ListaUsuarios.get(i).nombre);
                System.out.println();
            }
        } else {
            System.out.println("No hay usuarios que mostrar");
            System.out.println();
        }
    }
        
    public void mostrarVegetalesConsumidos(String nombre) {
        Usuario usuario;
        
        usuario = buscar(nombre);
        
        if (usuario != null) {
            if (usuario.ListaVegetalesConsumidos.isEmpty())
                    System.out.println("Aun no se agregan vegetales");
            for (int i=0; i < usuario.ListaVegetalesConsumidos.size(); i++) {
                if (i==0)
                    System.out.print(usuario.ListaVegetalesConsumidos.get(i).getNombre());
                else
                    System.out.print(", "+usuario.ListaVegetalesConsumidos.get(i).getNombre());
            }
            System.out.println();
        }
        else 
            System.out.println("Error al mostrar vegetales consumidos");
    }
    
    public double mostrarIMC(String nombre) {
        Usuario usuario;
        
        usuario = buscar(nombre);
        
        if (usuario != null) {
            usuario.calcularIMC();
            return usuario.getImc();
        }
        else 
            return 0;
    }
    
    public void agregarVegetalConsumido(String nombreUsuario, String nombreVegetal) {
        Usuario usuario;
        
        usuario = buscar(nombreUsuario);
        
        if (usuario != null) 
            usuario.ListaVegetalesConsumidos.add(new Vegetal(nombreVegetal));
        else
            System.out.println("El usuario no existe");
    }
    
    public double getCaloriasConsumidas(String nombreUsuario, Verdura datosVerduras, Fruta datosFrutas) {
        Usuario usuario;
        double sumaCalorias=0;
        int j;
        
        usuario = buscar(nombreUsuario);
        if (usuario != null) {
            for (j = 0; j < usuario.ListaVegetalesConsumidos.size(); j++) {
                sumaCalorias += datosVerduras.getCaloriasVerdura(usuario.ListaVegetalesConsumidos.get(j).getNombre());
                sumaCalorias += datosFrutas.getCaloriasFruta(usuario.ListaVegetalesConsumidos.get(j).getNombre());
            }
        }
        
        return sumaCalorias;
    }
}