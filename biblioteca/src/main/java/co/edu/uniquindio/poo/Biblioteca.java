package co.edu.uniquindio.poo;

import java.time.LocalDate;
import java.util.LinkedList;

public class Biblioteca {
    private String nombre;
    private LinkedList<Estudiante> estudiantes;
    private LinkedList<Bibliotecario> bibliotecarios;
    private LinkedList<Prestamo> prestamos;
    private LinkedList<Libro> libros;
    private double ganancia;
    private int cantidadLibros;

    /**
     * @param nombre
     * @param ganancia
     * @param cantidadLibros
     */
    public Biblioteca(String nombre, double ganancia, int cantidadLibros) {
        this.nombre = nombre;
        this.ganancia = ganancia;
        this.cantidadLibros = cantidadLibros;
        estudiantes = new LinkedList<>();
        bibliotecarios = new LinkedList<>();
        prestamos = new LinkedList<>();
        libros = new LinkedList<>();
    }

     /**
     * Metodo para crear un estudiante
     * @param nombre
     * @param cedula
     * @param telefono
     * @param correo
     * @return Estudiante Nuevo
     */
    public static Estudiante crearEstudiante(String nombre, String cedula, String correo,int telefono, int edad) {
        Estudiante estudiante = new Estudiante(nombre, cedula, correo, telefono, edad);
        return estudiante;
    }

    /**
     * Metodo para crear un bibliotecario
     * @param nombre
     * @param cedula
     * @param telefono
     * @param correo
     * @param salario
     * @param antiguedad
     * @return Bibliotecario Nuevo
     */
    public static Bibliotecario crearBibliotecario(String nombre, String cedula, String correo, int telefono,
            int salario, int antiguedad) {
        Bibliotecario bibliotecario = new Bibliotecario(nombre, cedula, correo, telefono, salario, antiguedad);
        return bibliotecario;
    }

    /**
     * Metodo para crear un prestamo
     * @param codigo
     * @param fechaPrestamo
     * @param fechaEntrega
     * @return Prestamo Nuevo
     */
    public static Prestamo crearPrestamoPrestamo(LocalDate fechaPrestamo, LocalDate fechaEntrega, double costoDia, String codigo,
    Estudiante estudiante, Bibliotecario bibliotecario) {
        Prestamo prestamo = new Prestamo(fechaPrestamo, fechaEntrega, costoDia, codigo, estudiante, bibliotecario);
        return prestamo;
    }

    /**
     * Metodo para buscar un estudiante
     * @param cedula
     * @return Un estudiante
     */
    public Estudiante buscarEstudiante(String cedula){
        Estudiante estudianteBuscado = null;
        for (Estudiante estudiante: estudiantes) {
            if(estudiante.getCedula().equals(cedula)){
                estudianteBuscado=estudiante;
            }
        }
        return estudianteBuscado;
    }

    /**
     * Metodo para buscar un bibliotecario
     * @param cedula
     * @return Un bibliotecario
     */
    public Bibliotecario buscarBibliotecario(String cedula){
        Bibliotecario bibliotecarioBuscado = null;
        for (Bibliotecario bibliotecario: bibliotecarios) {
            if(bibliotecario.getCedula().equals(cedula)){
                bibliotecarioBuscado= bibliotecario;
            }
        }
        return bibliotecarioBuscado;
    }

    /**
     * Metodo para agregar un estudiante a la biblioteca
     * @param estudiante
     */
    public void agregarEstudiante(Estudiante estudiante) {
        estudiantes.add(estudiante);
    }

    /**
     * Metodo para agregar un bibliotecario a la biblioteca
     * @param bibliotecario
     */
    public void agregarBibliotecario(Bibliotecario bibliotecario) {
        bibliotecarios.add(bibliotecario);
    }

    /**
     * Metodo para agregar un libro a la biblioteca
     * @param libro
     */
    public void agregarLibro(Libro libro) {
        libros.add(libro);
        int cantidad = libro.getUnidadesDisponibles();
        libro.setUnidadesDisponibles(cantidad - 1);
    }


    /**
     * Metodo para consultar un libro con su codigo
     * @param codigo
     */
    public void consultarLibro(String codigo) {
        for (Libro libro : libros) {
            if (libro.getCodigo().equals(codigo)) {
                libro.toString();
            }
        }
    }

    /**
     * Metodo para reemplazar un libro con su codigo a un libro nuevo
     * @param codigo
     * @param libroNuevo
     */
    public void reemplazarLibro(String codigo, Libro libroNuevo) {
        for (Libro libro : libros) {
            if (libro.getCodigo().equals(codigo)) {
                libros.remove(libro);
            }
        }
        libros.add(libroNuevo);
    }

    /**
     * Metodo para consultar un prestamo con su codigo
     * @param codigo
     */
    public void consultarPrestamo(String codigo) {
        for (Prestamo prestamo : prestamos) {
            if (prestamo.getCodigo().equals(codigo)) {
                prestamo.toString();
            }
        }
    }

    /**
     * Metodo que obtiene el estudiante con mayor numero de prestamos
     */
    public void EstudianteMasPrestamos() {
        int mayor = 0;
        int indiceMayor = 0;
        for (int i = 0; i < estudiantes.size(); i++) {
            Estudiante estudiante = estudiantes.get(i);
            int contador = 0;
            for (@SuppressWarnings("unused")
            Prestamo prestamo : estudiante.getPrestamos()) {
                contador += 1;
            }
            if (contador > mayor) {
                mayor = contador;
                indiceMayor = i;
            }
        }
        Estudiante estudianteMayor = estudiantes.get(indiceMayor);
        estudianteMayor.toString();
    }

    /**
     * Metodo para calcular el dinero obtenido en total por medio de los prestamos
     * @return Dinero Total
     */
    public int dineroRecaudado() {
        int dineroTotalRecaudado = 0;
        for (Prestamo prestamo : prestamos) {
            int dinero = prestamo.total();
            dineroTotalRecaudado += dinero;
        }
        return dineroTotalRecaudado;
    }


    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public LinkedList<Estudiante> getEstudiantes() {
        return estudiantes;
    }

    public void setEstudiantes(LinkedList<Estudiante> estudiantes) {
        this.estudiantes = estudiantes;
    }

    public LinkedList<Bibliotecario> getBibliotecarios() {
        return bibliotecarios;
    }

    public void setBibliotecarios (LinkedList<Bibliotecario> bibliotecarios) {
        this.bibliotecarios = bibliotecarios;
    }

    public LinkedList<Prestamo> getPrestamos() {
        return prestamos;
    }

    public void setPrestamos(LinkedList<Prestamo> prestamos) {
        this.prestamos = prestamos;
    }

    public LinkedList<Libro> getLibros() {
        return libros;
    }

    public void setLibros (LinkedList<Libro> libros) {
        this.libros = libros;
    }

    public double getGanancia() {
        return ganancia;
    }

    public void setGanancia(double ganancia) {
        this.ganancia = ganancia;
    }

    public int getCantidadLibros() {
        return cantidadLibros;
    }

    public void setCantidadLibros(int cantidadLibros) {
        this.cantidadLibros = cantidadLibros;
    }

    @Override
    public String toString() {
        return "Biblioteca [nombre=" + nombre + ", estudiantes=" + estudiantes + ", bibliotecarios=" + bibliotecarios
                + ", prestamos=" + prestamos + ", libros=" + libros + ", ganancia=" + ganancia + ", cantidadLibros="
                + cantidadLibros + "]";
    }

}
