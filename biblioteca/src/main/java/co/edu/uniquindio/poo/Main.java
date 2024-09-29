package co.edu.uniquindio.poo;

public class Main {
    public static void main(String[] args) {
        Biblioteca biblioteca = new Biblioteca("CRAI", 0, 0);
        biblioteca.autoCarga();
        biblioteca.menu();
    }
}
