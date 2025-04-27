module dev.alejandrozaragoza.proyectofinal {
    requires javafx.controls;
    requires javafx.fxml;
    requires kotlinx.serialization.core;
    requires net.devrieze.xmlutil.serialization;


    opens dev.alejandrozaragoza.proyectofinal to javafx.fxml;
    exports dev.alejandrozaragoza.proyectofinal;
}