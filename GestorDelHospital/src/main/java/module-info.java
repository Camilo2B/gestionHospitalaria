module co.edu.uniquindio.poo.gestordelhospital {
    requires javafx.controls;
    requires javafx.fxml;


    opens co.edu.uniquindio.poo.gestordelhospital to javafx.fxml;
    exports co.edu.uniquindio.poo.gestordelhospital;

    // Exporta el paquete que contiene el controlador
    exports co.edu.uniquindio.poo.gestordelhospital.ViewController to javafx.fxml;

    // Abre el paquete si usas inyección de dependencias con @FXML
    opens co.edu.uniquindio.poo.gestordelhospital.ViewController to javafx.fxml;
}