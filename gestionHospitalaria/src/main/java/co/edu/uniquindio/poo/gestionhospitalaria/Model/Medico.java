package co.edu.uniquindio.poo.gestionhospitalaria.Model;

public class Medico extends Persona{
    private int numMaxPaciente;
    private String cargo;

    public Medico(String nombre, int edad, String cedula, int numMaxPaciente, String cargo) {
        super(nombre, edad, cedula);
        this.numMaxPaciente = numMaxPaciente;
        this.cargo = cargo;
    }

    public int getNumMaxPaciente() {
        return numMaxPaciente;
    }

    public void setNumMaxPaciente(int numMaxPaciente) {
        this.numMaxPaciente = numMaxPaciente;
    }

    public String getCargo() {
        return cargo;
    }

    public void setCargo(String cargo) {
        this.cargo = cargo;
    }
}