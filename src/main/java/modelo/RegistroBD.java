package modelo;

public class RegistroBD {

    private long id;
    private String nombre;
    private String categoria;

    public RegistroBD( String nombre, String categoria) {
        this.nombre = nombre;
        this.categoria = categoria;
    }

    @Override
    public String toString() {
        return "RegistroBD{" +
                "id=" + id +
                ", nombre='" + nombre + '\'' +
                ", categoria='" + categoria + '\'' +
                '}';
    }
}
