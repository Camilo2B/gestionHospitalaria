package co.edu.uniquindio.poo.gestordelhospital.Model;


import java.time.LocalDate;
import java.util.LinkedList;

public class Hospital {
    private String nombre;
    private LinkedList<Paciente> pacientes;
    private LinkedList<Medico> medicos;
    private LinkedList<Cita> citas;

    public Hospital(String nombre) {
        this.nombre = nombre;
        pacientes = new LinkedList<>();
        medicos = new LinkedList<>();
        citas = new LinkedList<>();
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public LinkedList<Paciente> getPacientes() {
        return pacientes;
    }

    public void setPacientes(LinkedList<Paciente> pacientes) {
        this.pacientes = pacientes;
    }

    public LinkedList<Medico> getMedicos() {
        return medicos;
    }

    public void setMedicos(LinkedList<Medico> medicos) {
        this.medicos = medicos;
    }

    public LinkedList<Cita> getCitas() {
        return citas;
    }

    public void setCitas(LinkedList<Cita> citas) {
        this.citas = citas;
    }

    public boolean agregarPaciente(Paciente paciente) {
        boolean centinela = false;
        if (!verificarPaciente(paciente.getCedula())) {
            pacientes.add(paciente);
            centinela = true;
        }
        return centinela;
    }

    public void agregarCita(Cita cita){
        this.citas.add(cita);
    }

    public boolean agregarMedico(Medico medico) {
        boolean centinela = false;
        if (!verificarMedico(medico.getCedula())) {
            medicos.add(medico);
            centinela = true;
        }
        return centinela;
    }


    public boolean verificarPaciente(String cedula) {
        boolean centinela = false;
        for (Paciente paciente : pacientes) {
            if (paciente.getCedula().equals(cedula)) {
                centinela = true;
            }
        }
        return centinela;
    }

    public boolean verificarMedico(String cedula) {
        boolean centinela = false;
        for (Medico medico : medicos) {
            if (medico.getCedula().equals(cedula)) {
                centinela = true;
            }
        }
        return centinela;
    }

    public boolean eliminarMedico(String cedula) {
        boolean centinela = false;
        for (Medico cliente : medicos) {
            if (cliente.getCedula().equals(cedula)) {
                medicos.remove(cliente);
                centinela = true;
                break;
            }
        }
        return centinela;
    }

    public boolean eliminarPaciente(String cedula) {
        boolean centinela = false;
        for (Paciente paciente : pacientes) {
            if (paciente.getCedula().equals(cedula)) {
                pacientes.remove(paciente);
                centinela = true;
                break;
            }
        }
        return centinela;
    }

    public boolean actualizarMedico(String cedula, Medico actualizado) {
        boolean centinela = false;
        for (Medico medico : medicos) {
            if (medico.getCedula().equals(cedula)) {
                medico.setCedula(actualizado.getCedula());
                medico.setNombre(actualizado.getNombre());
                medico.setEdad(actualizado.getEdad());
                medico.setNumMaxPaciente(actualizado.getNumMaxPaciente());
                medico.setCargo(actualizado.getCargo());
                centinela = true;
                break;
            }
        }
        return centinela;
    }

    public boolean actualizarPaciente(String cedula, Paciente actualizado) {
        boolean centinela = false;
        for (Paciente paciente : pacientes) {
            if (paciente.getCedula().equals(cedula)) {
                paciente.setCedula(actualizado.getCedula());
                paciente.setNombre(actualizado.getNombre());
                paciente.setEdad(actualizado.getEdad());
                centinela = true;
                break;
            }
        }
        return centinela;
    }

    // Método para reservar una cita
    public void reservarCita(LocalDate fecha, Paciente paciente, Medico medico) {
        citas.add(new Cita(fecha, paciente, medico));
        System.out.println("Cita reservada para " + paciente.getNombre() + " con " + medico.getNombre());
    }

    // Método para cancelar una cita
    public void cancelarCita(LocalDate fecha, Paciente paciente) {
        citas.removeIf(cita -> cita.getFecha().equals(fecha) && cita.getPaciente().equals(paciente));
        System.out.println("Cita cancelada para " + paciente.getNombre() + " el " + fecha);
    }

    // Método para listar citas por fecha
    public void listarCitasPorFecha(LocalDate fecha) {
        System.out.println("Citas para la fecha: " + fecha);
        for (Cita c : citas) {
            if (c.getFecha().equals(fecha)) {
                System.out.println("- " + c.getPaciente().getNombre() + " con " + c.getMedico().getNombre());
            }
        }
    }

    // Método para determinar pacientes con nombres palíndromos
    public void determinarPacientesConNombrePalindromo() {
        System.out.println("Pacientes con nombres palíndromos:");
        for (Paciente p : pacientes) {
            String nombre = p.getNombre().replace(" ", "").toLowerCase();
            String nombreReverso = new StringBuilder(nombre).reverse().toString();
            if (nombre.equals(nombreReverso)) {
                System.out.println("- " + p.getNombre());
            }
        }
    }

    // Método para determinar pacientes con dos vocales iguales
    public void determinarPacientesConDosVocalesIguales() {
        System.out.println("Pacientes con dos vocales iguales:");
        for (Paciente p : pacientes) {
            String nombre = p.getNombre().toLowerCase();
            if (tieneDosVocalesIguales(nombre)) {
                System.out.println("- " + p.getNombre());
            }
        }
    }

    // Método auxiliar para verificar si un nombre tiene dos vocales iguales
    private boolean tieneDosVocalesIguales(String nombre) {
        for (int i = 0; i < nombre.length() - 1; i++) {
            char actual = nombre.charAt(i);
            char siguiente = nombre.charAt(i + 1);
            if (esVocal(actual) && esVocal(siguiente) && actual == siguiente) {
                return true;
            }
        }
        return false;
    }

    // Método auxiliar para verificar si un carácter es una vocal
    private boolean esVocal(char c) {
        return c == 'a' || c == 'e' || c == 'i' || c == 'o' ||c=='u';
    }

}
