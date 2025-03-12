package co.edu.uniquindio.poo.gestordelhospital.ViewController;

import co.edu.uniquindio.poo.gestordelhospital.Model.Hospital;
import co.edu.uniquindio.poo.gestordelhospital.Model.Medico;
import co.edu.uniquindio.poo.gestordelhospital.Model.Paciente;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;

public class CitaViewController {

    @FXML
    private Label txtNombreLista;

    @FXML
    private Label txtCedulaLista;

    @FXML
    private Label txtEdadLista;

    @FXML
    private Label txtMedicoLista;

    @FXML
    private ListView<Paciente> listaPacientes;

    @FXML
    private ComboBox<Paciente> comboPacientes;

    @FXML
    private ComboBox<Medico> comboMedicos;

    @FXML
    private Hospital hospital;

    // Listas de pacientes y médicos
    private ObservableList<Paciente> pacientes;
    private ObservableList<Medico> medicos;


    @FXML
    public void initialize() {
        // Inicializar las listas observables
        pacientes = FXCollections.observableArrayList();
        medicos = FXCollections.observableArrayList();

        // Vincular la lista observable con el ListView
        listaPacientes.setItems(pacientes);

        // Llenar los ComboBox con las listas de pacientes y médicos
        comboPacientes.setItems(pacientes);
        comboMedicos.setItems(medicos);
    }

    // Método para recibir las listas de pacientes y médicos
    public void setListaPacientes(ObservableList<Paciente> pacientes) {
        System.out.println("Lista de pacientes recibida: " + pacientes);
        if (pacientes == null) {
            System.out.println("Advertencia: La lista de pacientes es nula. Se inicializará una lista vacía.");
            pacientes = FXCollections.observableArrayList();
        }
        this.pacientes = listaPacientes.getItems();
        listaPacientes.setItems(this.pacientes);
        comboPacientes.setItems(this.pacientes);
    }

    public void setListaMedicos(ObservableList<Medico> medicos) {
        System.out.println("Lista de médicos recibida: " + medicos);
        if (medicos == null) {
            System.out.println("Advertencia: La lista de médicos es nula. Se inicializará una lista vacía.");
            medicos = FXCollections.observableArrayList();
        }
        this.medicos = medicos;
        comboMedicos.setItems(this.medicos);
    }





    // Método para agregar un paciente a la lista
    public void agregarPaciente(Paciente paciente) {
        if (paciente != null) {
            pacientes.add(paciente); // Agregar a la lista observable
            listaPacientes.setItems(pacientes); // Actualizar el ListView
            comboPacientes.setItems(pacientes); // Actualizar el ComboBox
            System.out.println("Paciente agregado: " + paciente.getNombre());
        } else {
            System.out.println("Error: El paciente es nulo.");
        }
    }

    // Método para agregar un médico a la lista
    public void agregarMedico(Medico medico) {
        if (medico != null) {
            medicos.add(medico); // Agregar a la lista observable
            comboMedicos.setItems(medicos); // Actualizar el ComboBox
            System.out.println("Médico agregado: " + medico.getNombre());
        } else {
            System.out.println("Error: El médico es nulo.");
        }
    }

    @FXML
    protected void volverPantalla() {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/co/edu/uniquindio/poo/gestordelhospital/Menu-View.fxml"));
            Parent root = loader.load();
            Scene scene = txtNombreLista.getScene();
            scene.setRoot(root);
        } catch (Exception e) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Error");
            alert.setHeaderText(null);
            alert.setContentText("No se pudo cargar la pantalla anterior. Por favor, inténtelo de nuevo.");
            alert.showAndWait();
            e.printStackTrace();
        }
    }

    public Label getTxtCedulaLista() {
        return txtCedulaLista;
    }

    public void setTxtCedulaLista(Label txtCedulaLista) {
        this.txtCedulaLista = txtCedulaLista;
    }

    public Label getTxtEdadLista() {
        return txtEdadLista;
    }

    public void setTxtEdadLista(Label txtEdadLista) {
        this.txtEdadLista = txtEdadLista;
    }

    public Label getTxtMedicoLista() {
        return txtMedicoLista;
    }

    public void setTxtMedicoLista(Label txtMedicoLista) {
        this.txtMedicoLista = txtMedicoLista;
    }
}