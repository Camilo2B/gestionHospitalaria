package co.edu.uniquindio.poo.gestordelhospital.ViewController;


import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;

public class WelcomeViewController {

    @FXML
    private Label txtTextoBienvenida;

    @FXML
    protected void cambiarVista2(){
        try {
            // Cargar la segunda vista
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/co/edu/uniquindio/poo/gestordelhospital/Menu-View.fxml"));
            Parent root = loader.load();

            // Obtener la escena actual
            Scene scene = txtTextoBienvenida.getScene();

            // Cambiar la escena actual por la nueva
            scene.setRoot(root);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    }






/*
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
        ///app.openCrudMedico();
    }

    @FXML
    void onOpenCrudPaciente() {
        ///app.openCrudPaciente();
    }

    public void setApp(App app) {
        this.app = app;
    }

    @FXML
    void initialize() {

    }

 */

