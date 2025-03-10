package co.edu.uniquindio.poo.gestionhospitalaria.Model;

import java.time.LocalDate;

public class Cita {
    private Paciente paciente;
    private Medico medico;
    private LocalDate fecha;

    public Cita(LocalDate fecha, Paciente paciente, Medico medico) {
        this.fecha = fecha;
        this.paciente = paciente;
        this.medico = medico;
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

    public LocalDate getFecha() {
        return fecha;
    }

    public void setFecha(LocalDate fecha) {
        this.fecha = fecha;
    }
}