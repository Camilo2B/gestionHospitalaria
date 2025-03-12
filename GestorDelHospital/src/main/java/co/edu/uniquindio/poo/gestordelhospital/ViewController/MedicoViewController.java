package co.edu.uniquindio.poo.gestordelhospital.ViewController;

import co.edu.uniquindio.poo.gestordelhospital.Model.Medico;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.TextField;

public class MedicoViewController {

    @FXML
    private TextField txtNombreMedico;

    @FXML
    private TextField txtCedulaMedico;

    @FXML
    private TextField txtEdadMedico;

    @FXML
    private TextField txtCargoMedico;

    private MenuViewController menuController;

    public void setMenuController(MenuViewController menuController) {
        this.menuController = menuController;
    }

    @FXML
    protected void guardarMedico() {
        try {
            // Crear un nuevo médico con los datos ingresados
            Medico medico = new Medico(txtNombreMedico.getText(), Integer.parseInt(txtEdadMedico.getText()), txtCedulaMedico.getText(), Integer.parseInt(txt));

            // Verificar que el controlador del menú no sea nulo
            if (menuController != null) {
                // Agregar el médico a la lista en el controlador del menú
                menuController.agregarMedico(medico);

                // Mostrar mensaje de éxito
                mostrarMensaje("Médico guardado correctamente.");

                // Limpiar los campos después de guardar
                limpiarCampos();
            } else {
                mostrarError("No se pudo acceder al menú principal.");
            }
        } catch (NumberFormatException e) {
            mostrarError("La edad debe ser un número válido.");
        } catch (Exception e) {
            mostrarError("Ocurrió un error al guardar el médico.");
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
            Scene scene = txtNombreMedico.getScene();

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
        txtNombreMedico.clear();
        txtCedulaMedico.clear();
        txtEdadMedico.clear();
        txtCargoMedico.clear();
    }
}