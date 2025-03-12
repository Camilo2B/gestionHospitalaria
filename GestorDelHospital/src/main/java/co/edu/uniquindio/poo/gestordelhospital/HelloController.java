package co.edu.uniquindio.poo.gestordelhospital;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Alert.AlertType;

public class HelloController {

    @FXML
    private Button ingresarButton; // Botón de ingreso

    @FXML
    private void ingresarAlSistema() {
        // Lógica para ingresar al sistema
        Alert alert = new Alert(AlertType.INFORMATION);
        alert.setTitle("Ingreso al Sistema");
        alert.setHeaderText(null);
        alert.setContentText("¡Bienvenido al Sistema de Gestión Hospitalaria!");
        alert.showAndWait();
    }
}