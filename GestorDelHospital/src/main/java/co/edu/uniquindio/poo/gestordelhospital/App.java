
package co.edu.uniquindio.poo.gestordelhospital;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;


public class App extends Application {
    @Override
    public void start(Stage stage) throws Exception {
        FXMLLoader fxmlLoader = new FXMLLoader(App.class.getResource("Welcome-view.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 400, 300);
        stage.setTitle("Sistema de Gestion del Hospital");
        stage.setScene(scene);
        stage.show();

    }
    public static void main(String[] args) {
        launch();
    }

    /*

    private Stage primaryStage;
    public static Hospital hospital = new Hospital("San Francisco Hospital");

    @Override
    public void start(Stage primaryStage) throws IOException {
        this.primaryStage = primaryStage;
        this.primaryStage.setTitle("Hospital");
        openViewPrincipal();
    }

    private void openViewPrincipal() {
        ///inicializarData();
        try {
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(App.class.getResource("Paciente-view.fxml"));
            javafx.scene.layout.VBox rootLayout = (javafx.scene.layout.VBox) loader.load();
            PrimaryController primaryController = loader.getController();
            primaryController.setApp(this);

            Scene scene = new Scene(rootLayout);
            primaryStage.setScene(scene);
            primaryStage.show();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        launch();
    }

    /*
    public void openCrudMedico() {
        try {
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(App.class.getResource("crudMedico.fxml"));
            AnchorPane rootLayout = (AnchorPane) loader.load();
            MedicoViewController medicoViewController = loader.getController();
            medicoViewController.setApp(this);

            Scene scene = new Scene(rootLayout);
            primaryStage.setScene(scene);
            primaryStage.show();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    public void openCrudPaciente() {
        try {
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(App.class.getResource("crudPaciente.fxml"));
            AnchorPane rootLayout = (AnchorPane) loader.load();
            MedicoViewController medicoViewController = loader.getController();
            medicoViewController.setApp(this);

            Scene scene = new Scene(rootLayout);
            primaryStage.setScene(scene);
            primaryStage.show();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    //servicios

    public void inicializarData() {
        Hospital hospital = new Hospital("Clínica Central");

        // Agregar pacientes y médicos
        Paciente paciente1 = new Paciente("Ana", "029102910", 90);
        Paciente paciente2 = new Paciente("Otto", "8291829182", 34);
        Paciente paciente3 = new Paciente("Carlos", "029102910", 76);

        Medico medico1 = new Medico("Dra. María Gómez", 45, "1029102901", 3, "Cirujano");
        Medico medico2 = new Medico("Dr. Juan Pérez", 50, "109201901", 4, "Pediatra");

        hospital.agregarPaciente(paciente1);
        hospital.agregarPaciente(paciente2);
        hospital.agregarPaciente(paciente3);

        hospital.agregarMedico(medico1);
        hospital.agregarMedico(medico2);

        // Reservar y cancelar citas
        hospital.reservarCita(LocalDate.of(2025, 3, 1), paciente1, medico1);
        hospital.reservarCita(LocalDate.of(2025, 3, 2), paciente2, medico2);
        hospital.cancelarCita(LocalDate.of(2025, 3, 2), paciente2);

        // Listar citas por fecha
        hospital.listarCitasPorFecha(LocalDate.of(2025, 3, 1));

        // Determinar pacientes con nombres palíndromos
        hospital.determinarPacientesConNombrePalindromo();

        // Determinar pacientes con dos vocales iguales
        hospital.determinarPacientesConDosVocalesIguales();

    }

     */
}
