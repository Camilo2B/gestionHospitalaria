package co.edu.uniquindio.poo.gestionhospitalaria.ViewController;

import co.edu.uniquindio.poo.gestionhospitalaria.Controller.MedicoController;
import co.edu.uniquindio.poo.gestionhospitalaria.Model.Medico;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import java.net.URL;
import java.util.ResourceBundle;
import co.edu.uniquindio.poo.gestionhospitalaria.App;
import co.edu.uniquindio.poo.gestionhospitalaria.Model.Medico;
import javafx.beans.property.SimpleStringProperty;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;


public class MedicoViewController {

    MedicoController medicoController;
    ObservableList<Medico> listMedicos = FXCollections.observableArrayList();
    Medico selectedMedico;

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private TextField txtNombre;

    @FXML
    private Button btnLimpiar;

    @FXML
    private TableView<Medico> tblListMedico;

    @FXML
    private Button btnEliminar;

    @FXML
    private Button btnActualizarMedico;

    @FXML
    private TableColumn<Medico, String> tbcNombre;

    @FXML
    private TextField txtEdad;

    @FXML
    private TableColumn<Medico, Integer> tbcEdad;

    @FXML
    private Button btbAgregarMedico;

    @FXML
    private TableColumn<Medico, String> tbcCedula;

    @FXML
    private TableColumn<Medico, Integer> tbcNumMaxPaciente;

    @FXML
    private TextField txtNumMaxPaciente;

    @FXML
    private TableColumn<Medico, String> cargo;

    @FXML
    private TextField txtCargo;

    @FXML
    private TextField txtCedula;
    private App app;

    @FXML
    void onAgregarMedico(){
        agregarMedico();
    }

    @FXML
    void onActualizarMedico(){
        actualizarMedico();
    }

    @FXML
    void onLimpiar() {
        limpiarSeleccion();
    }

    @FXML
    void onEliminar() {
        eliminarMedico();
    }

    @FXML
    void initialize() {
        medicoController = new MedicoController(app.hospital);
        initView();
    }

    private void initView() {
        // Traer los datos del medico a la tabla
        initDataBinding();

        // Obtiene la lista
        obtenerMedicos();

        // Limpiar la tabla
        tblListMedico.getItems().clear();

        // Agregar los elementos a la tabla
        tblListMedico.setItems(listMedicos);

        // Seleccionar elemento de la tabla
        listenerSelection();
    }

    private void initDataBinding() {
        tbcCedula.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getCedula()));
        tbcNombre.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getNombre()));
        tbcEdad.setCellValueFactory(cellData -> new SimpleObjectProperty<>(cellData.getValue().getEdad()));
        tbcNumMaxPaciente.setCellValueFactory(cellData -> new SimpleObjectProperty<>(cellData.getValue().getNumMaxPaciente()));

        // Usamos SimpleObjectProperty para manejar Double y Integer correctamente
    }

    private void obtenerMedicos() {
        listMedicos.addAll(medicoController.obtenerListaMedicos());
    }

    private void listenerSelection() {
        tblListMedico.getSelectionModel().selectedItemProperty().addListener((obs, oldSelection, newSelection) -> {
            selectedMedico = newSelection;
            mostrarInformacionMedico(selectedMedico);
        });
    }

    private void mostrarInformacionMedico(Medico medico) {
        if (medico != null) {
            txtCedula.setText(medico.getCedula());
            txtNombre.setText(medico.getNombre());
            txtEdad.setText(String.valueOf(medico.getEdad()));
            txtNumMaxPaciente.setText(String.valueOf(medico.getNumMaxPaciente()));
            txtCargo.setText(medico.getCargo());
        }
    }

    private void agregarMedico() {
        Medico medico = buildMedico();
        if (medicoController.crearMedico(medico)) {
            listMedicos.add(medico);
            limpiarCamposMedico();
        }
    }

    private Medico buildMedico() {
        Medico medico = new Medico(txtNombre.getText(), Integer.parseInt(txtEdad.getText()), txtCedula.getText(),Integer.parseInt(txtEdad.getText()), txtCargo.getText());
        return medico;
    }

    private void eliminarMedico() {
        if (medicoController.eliminarMedico(txtCedula.getText())) {
            listMedicos.remove(selectedMedico);
            limpiarCamposMedico();
            limpiarSeleccion();
        }
    }

    private void actualizarMedico() {

        if (selectedMedico != null &&
                medicoController.actualizarMedico(selectedMedico.getCedula(), buildMedico())) {

            int index = listMedicos.indexOf(selectedMedico);
            if (index >= 0) {
                listMedicos.set(index, buildMedico());
            }

            tblListMedico.refresh();
            limpiarSeleccion();
            limpiarCamposMedico();
        }
    }

    private void limpiarSeleccion() {
        tblListMedico.getSelectionModel().clearSelection();
        limpiarCamposMedico();
    }

    private void limpiarCamposMedico() {
        txtCedula.clear();
        txtNombre.clear();
        txtEdad.clear();
    }

    public void setApp(App app) {
        this.app = app;
    }
}






