package co.edu.uniquindio.poo;

public class DetallePrestamo {
    private int cantidad;
    private double subTotal;
    private Libro libro;


    /**
     * Metodo para crear una doble instancia de la clase
     */
    public DetallePrestamo(){

    }

    /**
     * Metodo constructor de la clase DetallesPrestamo
     * @param cantidad
     * @param libro
     */
    public DetallePrestamo(int cantidad, Libro libro){
        this.cantidad=cantidad;
        this.libro=libro;
        this.subTotal= subtotal();
    }

    /**
     * Metodo para obetener la cantidad de prestamos que esta incluido un libro por su nombre
     * @param nombre
     * @return Cantidad Prestamos Contenido
     */
    public int consultarLibroEnPrestamoNombre(String nombre) {
        int contador = 0;
        if (libro.getTitulo().equals(nombre)){
            contador = cantidad;
        }
        return contador;
    }

    /**
     * Metodo para calcular el subtotal
     * @return subtotal de un prestamo
     */
    public double subtotal() {
        Prestamo prestamo = new Prestamo();
        double costoDelPrestamo = prestamo.getCostoDia();
        double dias = prestamo.calcularDiasPrestamo();
        double costoTotalPrestamo = costoDelPrestamo * dias;
        return costoTotalPrestamo;
    }

    /**
     * Metodo para entregar un prestamo
     * @param libro
     */
    public void EntregarPrestamo(Libro libro) {
        Prestamo prestamo = new Prestamo();
        int imprimir = prestamo.total();
        System.out.println(imprimir);
        int cantidad = libro.getUnidadesDisponibles();
        libro.setUnidadesDisponibles(cantidad + 1);
    }

    /**
     * Metodo para obtener la cantidad de libros del prestamo
     * @return cantidad
     */
    public int getCantidad() {
        return cantidad;
    }

    /**
     * Metodo para cambiar la cantidad
     * @param cantidad
     */
    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    /**
     * metodo para obtener el subtotal
     * @return subtotal
     */
    public double getSubTotal() {
        return subTotal;
    }

    /**
     * metodo para cambiar el subtotal
     * @param subTotal
     */
    public void setSubTotal(double subTotal) {
        this.subTotal = subTotal;
    }

    /**
     * Metodo para obtener el libro
     * @return libro
     */
    public Libro getLibro() {
        return libro;
    }

    /**
     * Metodo para cambiar el libro
     * @param libro
     */
    public void setLibro(Libro libro) {
        this.libro = libro;
    }
    
}