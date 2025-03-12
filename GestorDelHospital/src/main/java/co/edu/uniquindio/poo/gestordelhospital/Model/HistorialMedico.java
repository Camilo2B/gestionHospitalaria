package co.edu.uniquindio.poo.gestordelhospital.Model;


import java.util.LinkedList;

public class HistorialMedico implements ClonableHistorial{
    private Paciente paciente;
    private Medico medico;
    private LinkedList<Medicamento> historialMedicamentos;
    private LinkedList<Enfermedad> historialEnfermedades;

    public HistorialMedico(LinkedList<Enfermedad> historialEnfermedades, Paciente paciente, Medico medico, LinkedList<Medicamento> historialMedicamentos) {
        this.historialEnfermedades = historialEnfermedades;
        this.paciente = paciente;
        this.medico = medico;
        this.historialMedicamentos = historialMedicamentos;
    }

    public Paciente getPaciente() {
        return paciente;
    }

    public void setPaciente(Paciente paciente) {
        this.paciente = paciente;
    }

    public Medico getMedico() {
        return medico;
    }

    public void setMedico(Medico medico) {
        this.medico = medico;
    }

    public LinkedList<Medicamento> getHistorialMedicamentos() {
        return historialMedicamentos;
    }

    public void setHistorialMedicamentos(LinkedList<Medicamento> historialMedicamentos) {
        this.historialMedicamentos = historialMedicamentos;
    }

    public LinkedList<Enfermedad> getHistorialEnfermedades() {
        return historialEnfermedades;
    }

    public void setHistorialEnfermedades(LinkedList<Enfermedad> historialEnfermedades) {
        this.historialEnfermedades = historialEnfermedades;
    }

    public HistorialMedico Clone(){
        try{
            return (HistorialMedico) super.clone();
        }catch (CloneNotSupportedException e) {
            throw new RuntimeException("El historial del medico no puede ser clonado");
        }
    }

    @java.lang.Override
    public java.lang.String toString() {
        return "HistorialMedico{" +
                "paciente=" + paciente +
                ", medico=" + medico +
                ", historialMedicamentos=" + historialMedicamentos +
                ", historialEnfermedades=" + historialEnfermedades +
                '}';
    }
}