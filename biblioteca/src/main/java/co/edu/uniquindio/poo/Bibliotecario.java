package co.edu.uniquindio.poo;

import java.util.Collection;
import java.util.LinkedList;

public class Bibliotecario extends Persona {
    private double salario;
    private int antiguedad;
    private Collection<Prestamo> prestamos;

    /**
     * Metodo constructor de la clase bibliotecario
     * @param nombre
     * @param cedula
     * @param correo
     * @param telefono
     * @param salario
     * @param antiguedad
     */
    public Bibliotecario(String nombre, String cedula, String correo, int telefono, double salario, int antiguedad) {
        super(nombre, cedula, correo, telefono);
        this.salario = salario;
        this.antiguedad = antiguedad;
        prestamos = new LinkedList<>();
    }

    /**
     * Metodo para agreagar un prestamo al bibliotecario
     * @param prestamo
     */
    public void agregarPrestamo(Prestamo prestamo){
        prestamos.add(prestamo);
    }

    /**
     * Metodo para mostrar la cantidad de prestamos realizados por un bibliotecario
     */
    public void cantidadPrestamos(){
        System.out.println("La cantidad de prestamos realizados son"+prestamos.size());
    }

    /**
     * Metodo para calcular el pago del bibliotecario
     * @return El pago del bibliotecario
     */
    public double calcularPago(){
        DetallePrestamo detallePrestamos = new DetallePrestamo();
        double valorPrestamo = detallePrestamos.subtotal();
        double valorPagoPorPrestamo= valorPrestamo * 0.2;
        double contador = 0;
        for (Prestamo prestamo : prestamos) {
            contador += 1;
        }
        double valorTotalPorPrestamos = valorPagoPorPrestamo * contador;
        double bonificacion = (valorTotalPorPrestamos * 0.02) + antiguedad;
        double pago = valorTotalPorPrestamos + bonificacion;
        return pago;
    }

    /**
     * Metodo para obtener el salario
     * @return Salario
     */
    public double getSalario() {
        return salario;
    }

    /**
     * Metodo para cambiar el valor del salario
     * @param salario
     */
    public void setSalario(double salario) {
        this.salario = salario;
    }

    /**
     * Metodo para obtener los años de antiguedad
     * @return Antiguedad
     */
    public int getAntiguedad() {
        return antiguedad;
    }

    /**
     * Metodo para cabiar el valor de la antiguedad
     * @param antiguedad
     */
    public void setAntiguedad(int antiguedad) {
        this.antiguedad = antiguedad;
    }

    /**
     * Metodo para obtener la coleccion de prestamos
     * @return Prestamos
     */
    public Collection<Prestamo> getPrestamos() {
        return prestamos;
    }

    /**
     * Metodo para cambiar el valor de la coleccion de prestamos
     * @param prestamos
     */
    public void setPrestamos(Collection<Prestamo> prestamos) {
        this.prestamos = prestamos;
    }

    @Override
    public String toString() {
        return "Bibliotecario [salario=" + salario + ", antiguedad=" + antiguedad + "]";
    }

}
