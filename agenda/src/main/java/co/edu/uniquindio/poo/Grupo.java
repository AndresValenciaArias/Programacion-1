package co.edu.uniquindio.poo;

import java.util.ArrayList;
import java.util.List;

public class Grupo {
    private String nombre;
    private Categoria categoria;
    private List<Contacto>listaContactos = new ArrayList<>();

    public Grupo(){

    }
    /**
     * @param nombre
     */
    public Grupo(String nombre, Categoria categoria) {
        this.nombre = nombre;
        this.categoria = categoria;
    }

    /**
     * Metodo para verificar la existencia de un contacto
     * @param nombre
     * @param telefono
     * @return true;false
     */
    public boolean verficarContacto(String nombre, String telefono){
        boolean centinela = false;
        for (Contacto contacto : listaContactos) {
            if (contacto.getNombre().equals(nombre) && contacto.getTelefono().equals(telefono)){
                centinela = true;
            }
        }
        return centinela;
    }

    /**
     * Metodo para eliminar un contacto de un grupo
     * @param nombre
     * @param telefono
     */
    public void eliminarContacto(String nombre, String telefono){
        for (Contacto contacto : listaContactos) {
            if (contacto.getNombre().equals(nombre) && contacto.getTelefono().equals(telefono)){
                listaContactos.remove(contacto);
                break;
            }
        }
    }

    /**
     * Metodo para agregar un contacto al grupo
     * @param contacto
     */
    public void agregarContacto(Contacto contacto){
        if(listaContactos.size() < 5){
            if (!verficarContacto(contacto.getNombre(), contacto.getTelefono())){
                listaContactos.add(contacto);
            }
        }
        else{
            System.out.println("No se pueden agregar mas contactos a este grupo.");
        }
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public List<Contacto> getListaContactos() {
        return listaContactos;
    }

    public void setListaContactos(List<Contacto> listaContactos) {
        this.listaContactos = listaContactos;
    }
    public Categoria getCategoria() {
        return categoria;
    }
    public void setCategoria(Categoria categoria) {
        this.categoria = categoria;
    }

    enum Categoria{
        OFICINA,
        FIESTA,
        AMIGOS,
        FAMILIA,
    }
}
