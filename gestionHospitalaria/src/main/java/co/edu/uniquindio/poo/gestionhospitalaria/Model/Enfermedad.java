package co.edu.uniquindio.poo.gestionhospitalaria.Model;

public class Enfermedad {
    private String nombre;
    private String duracion;
    private String areaCuerpoAfectada;

    public Enfermedad(String nombre, String duracion, String areaCuerpoAfectada) {
        this.nombre = nombre;
        this.duracion = duracion;
        this.areaCuerpoAfectada = areaCuerpoAfectada;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDuracion() {
        return duracion;
    }

    public void setDuracion(String duracion) {
        this.duracion = duracion;
    }

    public String getAreaCuerpoAfectada() {
        return areaCuerpoAfectada;
    }

    public void setAreaCuerpoAfectada(String areaCuerpoAfectada) {
        this.areaCuerpoAfectada = areaCuerpoAfectada;
    }
}
