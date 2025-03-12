package co.edu.uniquindio.poo.gestordelhospital.Controller;


import co.edu.uniquindio.poo.gestordelhospital.Model.Hospital;
import co.edu.uniquindio.poo.gestordelhospital.Model.Paciente;
import java.util.Collection;


public class PacienteController {

    Hospital hospital;

    public PacienteController(Hospital hospital) {
        this.hospital = hospital;
    }

    public boolean crearPaciente(Paciente paciente) {
        return hospital.agregarPaciente(paciente);
    }

    public Collection<Paciente> obtenerListaPacientes() {
        return hospital.getPacientes();
    }

    public boolean eliminarPaciente(String cedula) {
        return hospital.eliminarPaciente(cedula);
    }

    public boolean actualizarPaciente(String cedula, Paciente paciente) {
        return hospital.actualizarPaciente(cedula, paciente);
    }
}

