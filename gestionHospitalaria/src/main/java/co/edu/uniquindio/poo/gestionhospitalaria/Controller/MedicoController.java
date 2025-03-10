package co.edu.uniquindio.poo.gestionhospitalaria.Controller;

import co.edu.uniquindio.poo.gestionhospitalaria.Model.Medico;
import co.edu.uniquindio.poo.gestionhospitalaria.Model.Hospital;
import java.util.Collection;

public class MedicoController {

    Hospital hospital;

    public MedicoController(Hospital hospital) {
        this.hospital = hospital;
    }

    public boolean crearMedico(Medico medico) {
        return hospital.agregarMedico(medico);
    }

    public Collection<Medico> obtenerListaMedicos() {
        return hospital.getMedicos();
    }

    public boolean eliminarMedico(String cedula) {
        return hospital.eliminarMedico(cedula);
    }

    public boolean actualizarMedico(String cedula, Medico medico) {
        return hospital.actualizarMedico(cedula, medico);
    }
}
