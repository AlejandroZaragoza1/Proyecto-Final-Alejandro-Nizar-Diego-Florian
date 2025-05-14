module dev.alejandrozaragoza.proyectofinal {
    requires javafx.controls;
    requires javafx.fxml;
    requires net.devrieze.xmlutil.serialization;
    requires kotlin.result.jvm;
    requires logging.jvm;
    requires kotlinx.serialization.json;
    requires java.sql;
    requires org.mybatis;
    requires org.jdbi.v3.sqlobject;


    opens dev.alejandrozaragoza.proyectofinal to javafx.fxml;
    exports dev.alejandrozaragoza.proyectofinal;
}