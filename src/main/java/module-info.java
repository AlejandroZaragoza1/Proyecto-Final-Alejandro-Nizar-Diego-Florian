module dev.alejandrozaragoza.proyectofinal {
    requires javafx.controls;
    requires javafx.fxml;
    requires kotlin.stdlib;


    opens dev.alejandrozaragoza.proyectofinal to javafx.fxml;
    exports dev.alejandrozaragoza.proyectofinal;
}