package co.edu.uniquindio.poo.gestordelhospital.ViewController;

import co.edu.uniquindio.poo.gestordelhospital.Model.Paciente;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.TextField;

public class PacienteViewController {

    @FXML
    private TextField txtNombre;

    @FXML
    private TextField txtCedula;

    @FXML
    private TextField txtEdad;

    @FXML
    protected void guardarPaciente() {
        try {
            // Crear un nuevo paciente con los datos ingresados
            Paciente paciente = new Paciente(txtNombre.getText(), txtCedula.getText(), Integer.parseInt(txtEdad.getText()));

            // Obtener el controlador del menú principal
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/co/edu/uniquindio/poo/gestordelhospital/MenuView.fxml"));
            Parent root = loader.load();
            MenuViewController menuController = loader.getController();

            // Agregar el paciente a la lista en el controlador del menú
            menuController.agregarPaciente(paciente);

            // Mostrar mensaje de éxito
            mostrarMensaje("Paciente guardado correctamente.");

            // Limpiar los campos después de guardar
            limpiarCampos();
        } catch (NumberFormatException e) {
            mostrarError("La edad debe ser un número válido.");
        } catch (Exception e) {
            mostrarError("Ocurrió un error al guardar el paciente.");
            e.printStackTrace();
        }
    }

    @FXML
    protected void volverPantalla() {
        try {
            // Cargar la vista del menú principal
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/co/edu/uniquindio/poo/gestordelhospital/MenuView.fxml"));
            Parent root = loader.load();

            // Obtener la escena actual
            Scene scene = txtNombre.getScene();

            // Cambiar la escena actual por la nueva
            scene.setRoot(root);
        } catch (Exception e) {
            mostrarError("No se pudo cargar la pantalla anterior. Por favor, inténtelo de nuevo.");
            e.printStackTrace();
        }
    }

    private void mostrarMensaje(String mensaje) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Éxito");
        alert.setHeaderText(null);
        alert.setContentText(mensaje);
        alert.showAndWait();
    }

    private void mostrarError(String mensaje) {
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle("Error");
        alert.setHeaderText(null);
        alert.setContentText(mensaje);
        alert.showAndWait();
    }

    private void limpiarCampos() {
        txtNombre.clear();
        txtCedula.clear();
        txtEdad.clear();
    }
}