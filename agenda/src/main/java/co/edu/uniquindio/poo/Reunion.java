package co.edu.uniquindio.poo;

import java.util.ArrayList;
import java.util.List;


public class Reunion {
    private String descripcion;
    private String fecha;
    private String hora;
    private List<Contacto> listaAsistentes = new ArrayList<>();

    public Reunion(){

    }

    /**
     * @param descripcion
     * @param fecha
     * @param hora
     */
    public Reunion(String descripcion, String fecha, String hora){
        this.descripcion = descripcion;
        this.fecha = fecha;
        this.hora = hora;
    }

    /**
     * Metodo para verificar la existencia de un contacto
     * @param nombre
     * @param telefono
     * @return true;false
     */
    public boolean verficarContacto(String nombre, String telefono){
        boolean centinela = false;
        for (Contacto contacto : listaAsistentes) {
            if (contacto.getNombre().equals(nombre) && contacto.getTelefono().equals(telefono)){
                centinela = true;
            }
        }
        return centinela;
    }

    /**
     * Metodo para agregar un contacto a la reunion
     * @param contacto
     */
    public void agregarContacto(Contacto contacto){
        if (!verficarContacto(contacto.getNombre(), contacto.getTelefono())){
            listaAsistentes.add(contacto);
        }

    }
    /**
     * Metodo para eliminar un contacto de una reunion
     * @param nombre
     * @param telefono
     */
    public void eliminarContacto(String nombre, String telefono){
        for (Contacto contacto : listaAsistentes) {
            if (contacto.getNombre().equals(nombre) && contacto.getTelefono().equals(telefono)){
                listaAsistentes.remove(contacto);
                break;
            }
        }
    }


    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public String getHora() {
        return hora;
    }

    public void setHora(String hora) {
        this.hora = hora;
    }

    public List<Contacto> getListaAsistentes() {
        return listaAsistentes;
    }

    public void setListaAsistentes(List<Contacto> listaAsistentes) {
        this.listaAsistentes = listaAsistentes;
    }

    @Override
    public String toString() {
        return "Reunion [descripcion=" + descripcion + ", fecha=" + fecha + ", hora=" + hora + ", listaAsistentes="
                + listaAsistentes + "]";
    }

    

}
