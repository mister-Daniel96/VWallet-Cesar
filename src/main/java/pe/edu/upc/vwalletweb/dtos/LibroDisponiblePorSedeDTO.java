package pe.edu.upc.vwalletweb.dtos;

public class LibroDisponiblePorSedeDTO {
    private String sedeBiblioteca;

    private int cantidad_libros;

    public String getSedeBiblioteca() {
        return sedeBiblioteca;
    }

    public void setSedeBiblioteca(String sedeBiblioteca) {
        this.sedeBiblioteca = sedeBiblioteca;
    }

    public int getCantidad_libros() {
        return cantidad_libros;
    }

    public void setCantidad_libros(int cantidad_libros) {
        this.cantidad_libros = cantidad_libros;
    }
}
