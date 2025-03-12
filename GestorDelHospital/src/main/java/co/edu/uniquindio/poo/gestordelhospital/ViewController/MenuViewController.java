package co.edu.uniquindio.poo.gestordelhospital.ViewController;

import co.edu.uniquindio.poo.gestordelhospital.Model.Medico;
import co.edu.uniquindio.poo.gestordelhospital.Model.Paciente;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;

public class MenuViewController {

    @FXML
    private Label txtMenuMensaje;

    // Listas de pacientes y médicos
    private ObservableList<Paciente> listaPacientes;
    private ObservableList<Medico> listaMedicos;

    @FXML
    public void initialize() {
        // Inicializar las listas observables
        listaPacientes = FXCollections.observableArrayList();
        listaMedicos = FXCollections.observableArrayList();

    }

    @FXML
    protected void cambiarVistaPacientes() {
        try {
            // Cargar la vista de pacientes
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/co/edu/uniquindio/poo/gestordelhospital/Paciente-view.fxml"));
            Parent root = loader.load();

            // Obtener la escena actual
            Scene scene = txtMenuMensaje.getScene();

            // Cambiar la escena actual por la nueva
            scene.setRoot(root);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @FXML
    protected void cambiarVistaMedicos() {
        try {
            // Cargar la vista de médicos
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/co/edu/uniquindio/poo/gestordelhospital/Medico-view.fxml"));
            Parent root = loader.load();

            // Obtener la escena actual
            Scene scene = txtMenuMensaje.getScene();

            // Cambiar la escena actual por la nueva
            scene.setRoot(root);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @FXML
    protected void cambiarVistaCitas() {
        try {
            // Cargar la vista de citas
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/co/edu/uniquindio/poo/gestordelhospital/Cita-view.fxml"));
            Parent root = loader.load();

            // Obtener el controlador de citas
            CitaViewController citaController = loader.getController();

            // Pasar las listas de pacientes y médicos al controlador de citas
            citaController.setListaPacientes(listaPacientes);
            citaController.setListaMedicos(listaMedicos);

            // Obtener la escena actual
            Scene scene = txtMenuMensaje.getScene();

            // Cambiar la escena actual por la nueva
            scene.setRoot(root);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // Método para agregar un paciente a la lista
    public void agregarPaciente(Paciente paciente) {
        if (paciente != null) {
            listaPacientes.add(paciente);
            System.out.println("Paciente agregado: " + paciente.getNombre());
        } else {
            System.out.println("Error: El paciente es nulo.");
        }
    }

    // Método para agregar un médico a la lista
    public void agregarMedico(Medico medico) {
        if (medico != null) {
            listaMedicos.add(medico);
            System.out.println("Médico agregado: " + medico.getNombre());
        } else {
            System.out.println("Error: El médico es nulo.");
        }
    }

    // Métodos para recibir las listas de pacientes y médicos
    public void setListaPacientes(ObservableList<Paciente> listaPacientes) {
        this.listaPacientes = listaPacientes;
    }

    public void setListaMedicos(ObservableList<Medico> listaMedicos) {
        this.listaMedicos = listaMedicos;
    }
}