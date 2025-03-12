package co.edu.uniquindio.poo.gestordelhospital;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception {
        // Cargar el archivo FXML
        Parent root = FXMLLoader.load(getClass().getResource(""));

        // Configurar la escena
        Scene scene = new Scene(root, 600, 400);

        // Configurar la ventana principal
        primaryStage.setTitle("Sistema de Gestión Hospitalaria");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}