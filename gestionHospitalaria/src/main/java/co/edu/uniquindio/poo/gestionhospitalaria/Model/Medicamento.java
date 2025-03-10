package co.edu.uniquindio.poo.gestionhospitalaria.Model;

public class Medicamento {
    private String nombre;
    private String dosis;
    private Intruccion instruccion;
    private String composicion;

    public Medicamento(String nombre, String dosis, Intruccion instruccion, String composicion) {
        this.nombre = nombre;
        this.dosis = dosis;
        this.instruccion = instruccion;
        this.composicion = composicion;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDosis() {
        return dosis;
    }

    public void setDosis(String dosis) {
        this.dosis = dosis;
    }

    public String getComposicion() {
        return composicion;
    }

    public void setComposicion(String composicion) {
        this.composicion = composicion;
    }

    public Intruccion getInstruccion() {
        return instruccion;
    }

    public void setInstruccion(Intruccion instruccion) {
        this.instruccion = instruccion;
    }
}