package co.edu.uniquindio.poo.gestordelhospital.ViewController;
import co.edu.uniquindio.poo.gestordelhospital.Controller.PacienteController;
import co.edu.uniquindio.poo.gestordelhospital.Model.Paciente;
import javafx.beans.property.SimpleObjectProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;
import co.edu.uniquindio.poo.gestordelhospital.App;
import javafx.beans.property.SimpleStringProperty;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;


public class PacienteViewController {

    @FXML
    private TextField txtNombre;

    @FXML
    private TextField txtCedula;

    @FXML
    private TextField txtEdad;



    private ObservableList<Paciente> listaPacientes = FXCollections.observableArrayList();

    @FXML
    protected void guardar(){
        Paciente paciente = new Paciente(txtNombre.getText(), txtCedula.getText(), Integer.parseInt(txtEdad.getText()));
        System.out.println(paciente.toString());

        listaPacientes.add(paciente);

        txtNombre.clear();
        txtCedula.clear();
        txtEdad.clear();

        System.out.println("Paciente Guardado: "+paciente.toString());

    }

    @FXML
    protected void irACitas() {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/co/edu/uniquindio/poo/gestordelhospital/Cita-View.fxml"));
            Parent root = loader.load();

            // Obtener el controlador de la nueva vista
            CitaViewController citaController = loader.getController();
            citaController.setListaPacientes(listaPacientes); // Pasar la lista de pacientes

            // Cambiar la escena actual
            Scene scene = txtNombre.getScene();
            scene.setRoot(root);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    @FXML
    protected void volverPantalla(){
        try {
            // Cargar la vista del menú principal
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/co/edu/uniquindio/poo/gestordelhospital/Menu-View.fxml"));
            Parent root = loader.load();

            // Obtener la escena actual
            Scene scene = txtNombre.getScene();

            // Cambiar la escena actual por la nueva
            scene.setRoot(root);
        } catch (Exception e) {
            // Mostrar mensaje de error al usuario

        }

    }

    // Método para obtener la lista de pacientes
    public ObservableList<Paciente> getListaPacientes() {
        return listaPacientes;
    }


}
