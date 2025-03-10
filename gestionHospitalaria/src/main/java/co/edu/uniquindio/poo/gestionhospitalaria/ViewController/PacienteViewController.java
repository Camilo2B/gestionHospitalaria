package co.edu.uniquindio.poo.gestionhospitalaria.ViewController;

import co.edu.uniquindio.poo.gestionhospitalaria.Controller.PacienteController;
import co.edu.uniquindio.poo.gestionhospitalaria.Model.Paciente;
import javafx.beans.property.SimpleObjectProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import java.net.URL;
import java.util.ResourceBundle;
import co.edu.uniquindio.poo.gestionhospitalaria.App;
import javafx.beans.property.SimpleStringProperty;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;


public class PacienteViewController {

    PacienteController pacienteController;
    ObservableList<Paciente> listPacientes = FXCollections.observableArrayList();
    Paciente selectedPaciente;

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private TextField txtNombre;

    @FXML
    private Button btnLimpiar;

    @FXML
    private TableView<Paciente> tblListPaciente;

    @FXML
    private Button btnEliminar;

    @FXML
    private Button btnActualizarPaciente;

    @FXML
    private TableColumn<Paciente, String> tbcNombre;

    @FXML
    private TextField txtEdad;

    @FXML
    private TableColumn<Paciente, Integer> tbcEdad;

    @FXML
    private Button btbAgregarPaciente;

    @FXML
    private TableColumn<Paciente, String> tbcCedula;

    @FXML
    private TextField txtCedula;
    private App app;

    @FXML
    void onAgregarPaciente(){
        agregarPaciente();
    }

    @FXML
    void onActualizarPaciente(){
        actualizarPaciente();
    }

    @FXML
    void onLimpiar() {
        limpiarSeleccion();
    }

    @FXML
    void onEliminar() {
        eliminarPaciente();
    }

    @FXML
    void initialize() {
        pacienteController = new PacienteController(app.hospital);
        initView();
    }

    private void initView() {
        // Traer los datos del paciente a la tabla
        initDataBinding();

        // Obtiene la lista
        obtenerPacientes();

        // Limpiar la tabla
        tblListPaciente.getItems().clear();

        // Agregar los elementos a la tabla
        tblListPaciente.setItems(listPacientes);

        // Seleccionar elemento de la tabla
        listenerSelection();
    }

    private void initDataBinding() {
        tbcCedula.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getCedula()));
        tbcNombre.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getNombre()));
        tbcEdad.setCellValueFactory(cellData -> new SimpleObjectProperty<>(cellData.getValue().getEdad()));

        // Usamos SimpleObjectProperty para manejar Double y Integer correctamente
    }

    private void obtenerPacientes() {
        listPacientes.addAll(pacienteController.obtenerListaPacientes());
    }

    private void listenerSelection() {
        tblListPaciente.getSelectionModel().selectedItemProperty().addListener((obs, oldSelection, newSelection) -> {
            selectedPaciente = newSelection;
            mostrarInformacionPaciente(selectedPaciente);
        });
    }

    private void mostrarInformacionPaciente(Paciente paciente) {
        if (paciente != null) {
            txtCedula.setText(paciente.getCedula());
            txtNombre.setText(paciente.getNombre());
            txtEdad.setText(String.valueOf(paciente.getEdad()));
        }
    }

    private void agregarPaciente() {
        Paciente paciente = buildPaciente();
        if (pacienteController.crearPaciente(paciente)) {
            listPacientes.add(paciente);
            limpiarCamposPaciente();
        }
    }

    private Paciente buildPaciente() {
        Paciente paciente = new Paciente(txtCedula.getText(), txtNombre.getText(), Integer.parseInt(txtEdad.getText()));
        return paciente;
    }

    private void eliminarPaciente() {
        if (pacienteController.eliminarPaciente(txtCedula.getText())) {
            listPacientes.remove(selectedPaciente);
            limpiarCamposPaciente();
            limpiarSeleccion();
        }
    }

    private void actualizarPaciente() {

        if (selectedPaciente != null &&
                pacienteController.actualizarPaciente(selectedPaciente.getCedula(), buildPaciente())) {

            int index = listPacientes.indexOf(selectedPaciente);
            if (index >= 0) {
                listPacientes.set(index, buildPaciente());
            }

            tblListPaciente.refresh();
            limpiarSeleccion();
            limpiarCamposPaciente();
        }
    }

    private void limpiarSeleccion() {
        tblListPaciente.getSelectionModel().clearSelection();
        limpiarCamposPaciente();
    }

    private void limpiarCamposPaciente() {
        txtCedula.clear();
        txtNombre.clear();
        txtEdad.clear();
    }

    public void setApp(App app) {
        this.app = app;
    }
}





