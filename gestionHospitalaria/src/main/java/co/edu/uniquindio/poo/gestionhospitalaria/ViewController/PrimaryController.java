package co.edu.uniquindio.poo.gestionhospitalaria.ViewController;

import java.net.URL;
import java.util.ResourceBundle;
import co.edu.uniquindio.poo.gestionhospitalaria.App;
import javafx.fxml.FXML;
import javafx.scene.control.Button;

public class PrimaryController {
    @FXML
    private ResourceBundle resources;

    App app;
    @FXML
    private URL location;

    @FXML
    private Button primaryButton;

    @FXML
    void onOpenCrudMedico() {
        app.openCrudMedico();
    }

    @FXML
    void onOpenCrudPaciente() {
        app.openCrudPaciente();
    }

    public void setApp(App app) {
        this.app = app;
    }

    @FXML
    void initialize() {

    }
}
