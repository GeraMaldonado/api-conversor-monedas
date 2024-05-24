package modelos;

public class Moneda {
    private Double cambio;
    private String nombre;

    public Moneda() {
        // Constructor vacío para Gson
    }

    public Moneda(String nombre, Double cambio){
        this.nombre = nombre;
        this.cambio = cambio;
    }

    public Double getCambio() {
        return cambio;
    }

    public void setCambio(Double cambio) {
        this.cambio = cambio;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    @Override
    public String toString() {
        return "Moneda{" +
                "cambio=" + cambio +
                ", nombre='" + nombre + '\'' +
                '}';
    }
}
