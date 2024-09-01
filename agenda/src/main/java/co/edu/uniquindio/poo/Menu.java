package co.edu.uniquindio.poo;

import java.util.List;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;
import java.util.Scanner;

import co.edu.uniquindio.poo.Grupo.Categoria;

public class Menu {
    public Contacto contacto;
    public Grupo grupo;
    public Reunion reunion;
    private Set<Contacto> contactos = new HashSet<>();
    private List<Grupo> grupos = new ArrayList<>();
    private List<Reunion> reuniones = new ArrayList<>();

    
    /**
     * Metodo para mostrar el menu principal
     */
    public void mostrarMenu(){
        @SuppressWarnings("resource")
        Scanner scanner = new Scanner(System.in);
        int opcion;

        do{
            System.out.println("----Agenda de Contactos----");
            System.out.println("1.Contactos");
            System.out.println("2.Grupos");
            System.out.println("3.Reuniones");
            System.out.println("4.Salir");
            System.out.println("Seleccion una opcion : ");
            opcion = scanner.nextInt();

            ejecutarOpcion(opcion);

        }while (opcion!=6);
    }

    /**
     * Metodo para acceder a todas las opciones del sistema
     * @param opcion
     */
    private void ejecutarOpcion(int opcion){
        @SuppressWarnings("resource")
        Scanner scanner = new Scanner(System.in);
        boolean gestionContactos = true;
        boolean gestionGrupos = true;
        boolean gestionReuniones = true;
        switch (opcion) {
            case 1:
                while(gestionContactos) {
                    System.out.println("----Contactos----");
                    System.out.println("1.Crear contactos");
                    System.out.println("2.Mostrar contactos");
                    System.out.println("3.Volver al menu");
                    int opcionContactos = scanner.nextInt();
                    switch (opcionContactos) {
                        case 1:
                            crearContacto(contacto);
                            break;
                        case 2:
                            mostrarContactos(contactos);
                            break;
                        case 3:
                            gestionContactos = false;
                        default:
                            break;
                    } 
                }
                gestionContactos = true;
                break;
            case 2:
            while(gestionGrupos) {
                System.out.println("----Grupos----");
                System.out.println("1.Crear grupo");
                System.out.println("2.Añadir contactos");
                System.out.println("3.Eliminar contactos");
                System.out.println("4.Mostrar grupos");
                System.out.println("5.Volver al menu");
                int opcionGrupos = scanner.nextInt();
                switch (opcionGrupos) {
                    case 1:
                        crearGrupo();
                        break;
                    case 2:
                        agregarContactoGrupos(contactos);
                        break;
                    case 3:
                        eliminarContactoGrupos();
                        break;
                    case 4:
                        mostrarGrupos(grupos, grupo.getListaContactos());
                        break;
                    case 5:
                        gestionGrupos = false;
                    default:
                        break;
                }
            }
            gestionGrupos = true;   
            break;
            case 3:
            while(gestionReuniones) {
                System.out.println("----Reuniones----");
                System.out.println("1.Crear reunion");
                System.out.println("2.Añadir contactos");
                System.out.println("3.Eliminar contactos");
                System.out.println("4.Mostrar reuniones");
                System.out.println("5.Volver al menu");
                int opcionReuniones = scanner.nextInt();
                switch (opcionReuniones) {
                    case 1:
                        crearReunion();
                        break;
                    case 2:
                        agregarContactoReuniones(contactos);
                        break;
                    case 3:
                        eliminarContactoReuniones();
                        break;
                    case 4:
                        mostrarReuniones(reuniones, grupo.getListaContactos());
                        break;
                    case 5:
                        gestionReuniones = false;
                    default:
                        break;
                }
            }
            gestionReuniones = true;
            break;
            case 4:
                System.out.println("Saliendo...");
                System.exit(0);
                break;
            default:
                System.out.println("Opcion no valida");
                break;
        }
    
}

    /**
     * Metodo para crear un contacto
     * @param contacto
     */
    private void crearContacto(Contacto contacto){
        @SuppressWarnings("resource")
        Scanner scanner = new Scanner(System.in);
        System.out.println("Nombre:");
        String nombre = scanner.nextLine();
        System.out.println("Alias:");
        String alias = scanner.nextLine();
        System.out.println("Direccion:");
        String direccion = scanner.nextLine();
        System.out.println("Telefono:");
        String telefono = scanner.nextLine();
        System.out.println("Email:");
        String email = scanner.nextLine();
        contacto = new Contacto(nombre,alias, direccion, telefono, email);
        contactos.add(contacto);
    }

    /**
     * Metodo para agregar un contacto a un grupo
     * @param contactos
     */
    private void agregarContactoGrupos(Set<Contacto> contactos){
        for (Contacto contacto : contactos) {
            grupo.agregarContacto(contacto);
        }
    }

    /**
     * Metodo para agregar un contacto a una reunion
     * @param contactos
     */
    private void agregarContactoReuniones(Set<Contacto> contactos){
        for (Contacto contacto : contactos) {
            reunion.agregarContacto(contacto);
            break;
        }
    }

    /**
     * Metodo para mostrar los contactos
     * @param contactos
     */
    private void mostrarContactos(Set<Contacto> contactos){
        System.out.println("----Lista de Contactos----");
        for (Contacto contacto : contactos) {
            System.out.println("Nombre: "+ contacto.getNombre());
            System.out.println("Alias: "+ contacto.getAlias());
            System.out.println("Direccion: "+ contacto.getDireccion());
            System.out.println("Telefono: "+ contacto.getTelefono());
            System.out.println("Email: "+ contacto.getEmail());
            System.out.println();
        }
    }

    /**
     * Metodo para mostrar los grupos y sus integrantes
     * @param grupos
     * @param contactos
     */
    private void mostrarGrupos(List<Grupo> grupos,List<Contacto> listaContactos){
        System.out.println("----Lista de Grupos----");
        for (Grupo grupo : grupos) {
            System.out.println("----Grupo----");
            System.out.println("Nombre: "+ grupo.getNombre());
            System.out.println("Categoria: "+ grupo.getCategoria());
            System.out.println("----Integrantes----");
            for (Contacto contacto : listaContactos) {
                System.out.println("Nombre: "+ contacto.getNombre());
                System.out.println("Alias: "+ contacto.getAlias());
                System.out.println("Direccion: "+ contacto.getDireccion());
                System.out.println("Telefono: "+ contacto.getTelefono());
                System.out.println("Email: "+ contacto.getEmail());
                System.out.println();
            }
        }
    }

    /**
     * Metodo para mostrar las reuniones y sus participantes
     * @param reuniones
     * @param contactos
     */
    private void mostrarReuniones(List<Reunion> reuniones,List<Contacto> listaContactos ){
        System.out.println("----Lista de Reuniones----");
        for (Reunion reunion : reuniones) {
            System.out.println("Descripcion: "+ reunion.getDescripcion());
            System.out.println("Fecha: "+ reunion.getFecha());
            System.out.println("Hora: "+ reunion.getHora());
        }
            System.out.println("----Participantes----");
        
        for (Contacto contacto : contactos) {
            System.out.println("Nombre: "+ contacto.getNombre());
            System.out.println("Alias: "+ contacto.getAlias());
            System.out.println("Direccion: "+ contacto.getDireccion());
            System.out.println("Telefono: "+ contacto.getTelefono());
            System.out.println("Email: "+ contacto.getEmail());
            System.out.println();
        }
    }

    /**
     * Metodo para eliminar un contacto de un grupo
     */
    private void eliminarContactoGrupos(){
        @SuppressWarnings("resource")
        Scanner scanner = new Scanner(System.in);
        System.out.println("Ingrese el nombre del contacto que desea eliminar: ");
        String nombre = scanner.nextLine();
        System.out.println("Ingrese el telefono a eliminar: ");
        String telefono = scanner.nextLine();
        grupo.eliminarContacto(nombre, telefono);
    }

    /**
     * Metodo para eliminar un contacto de una reunion
     */
    private void eliminarContactoReuniones(){
        @SuppressWarnings("resource")
        Scanner scanner = new Scanner(System.in);
        System.out.println("Ingrese el nombre del contacto que desea eliminar: ");
        String nombre = scanner.nextLine();
        System.out.println("Ingrese el telefono a eliminar: ");
        String telefono = scanner.nextLine();
        reunion.eliminarContacto(nombre, telefono);
    }

    /**
     * Metodo para crear un grupo
     */
    public void crearGrupo(){
        @SuppressWarnings("resource")
        Scanner scanner = new Scanner(System.in);
        System.out.println("Nombre del grupo: ");
        String nombre = scanner.nextLine();
        System.out.println("Ingrese la categoria(OFICINA,FIESTA,AMIGOS,FAMILIA):");
        String categorias = scanner.next().toUpperCase();
        Categoria categoria = Categoria.valueOf(categorias);
        grupo = new Grupo(nombre, categoria);
        grupos.add(grupo);
    }

    /**
     * Metodo para crear una reunion
     */
    private void crearReunion(){
        @SuppressWarnings("resource")
        Scanner scanner = new Scanner(System.in);
        System.out.println("Ingrese la descripcion de la reunion: ");
        String descripcion = scanner.nextLine();
        System.out.println("Ingrese la fecha de la reunion: ");
        String fecha = scanner.nextLine();
        System.out.println("Ingrese la hora de la reunion: ");
        String hora = scanner.nextLine();
        reunion = new Reunion(descripcion, fecha, hora);
        reuniones.add(reunion);
        System.out.println("Reunion creada exitosamente");
    }
}









 

