package co.edu.uniquindio.poo.gestordelhospital.ViewController;

import co.edu.uniquindio.poo.gestordelhospital.Model.Medico;
import co.edu.uniquindio.poo.gestordelhospital.Model.Paciente;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
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
    TextField txtNumMaxPacMedico;

    @FXML
    private TextField txtCargoMedico;

    private ObservableList<Medico> listaMedicos = FXCollections.observableArrayList();

    @FXML
    protected void guardarMedico() {

        Medico medico = new Medico(txtNombreMedico.getText(), Integer.parseInt(txtEdadMedico.getText()), txtCedulaMedico.getText(), Integer.parseInt(txtNumMaxPacMedico.getText()), txtCargoMedico.getText());
        System.out.println(medico.toString());

        listaMedicos.add(medico);


        System.out.println("Medico Guardado: " + medico.toString());

    }

    @FXML
    protected void irACitas() {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/co/edu/uniquindio/poo/gestordelhospital/Cita-View.fxml"));
            Parent root = loader.load();

            // Obtener el controlador de la nueva vista
            CitaViewController citaController = loader.getController();
            citaController.setListaMedicos(listaMedicos); // Pasar la lista de médicos

            // Cambiar la escena actual
            Scene scene = txtNombreMedico.getScene();
            scene.setRoot(root);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }




    @FXML
    protected void volverPantalla() {
        try {
            // Cargar la vista del menú principal
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/co/edu/uniquindio/poo/gestordelhospital/Menu-View.fxml"));
            Parent root = loader.load();

            // Obtener la escena actual
            Scene scene = txtNombreMedico.getScene();

            // Cambiar la escena actual por la nueva
            scene.setRoot(root);
        } catch (Exception e) {
            // Mostrar mensaje de error al usuario

        }

    }

    // Método para obtener la lista de medicos
    public ObservableList<Medico> getListaMedicos() {
        return listaMedicos;
    }

}



