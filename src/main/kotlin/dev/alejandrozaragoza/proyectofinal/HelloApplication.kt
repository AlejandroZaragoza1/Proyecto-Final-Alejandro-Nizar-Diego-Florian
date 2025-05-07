package dev.alejandrozaragoza.proyectofinal

import dev.alejandrozaragoza.proyectofinal.Equipo.storage.FileFormat
import dev.alejandrozaragoza.proyectofinal.Equipo.storage.PersonasStorageCsv
import javafx.application.Application
import javafx.fxml.FXMLLoader
import javafx.scene.Scene
import javafx.stage.Stage
import java.io.File

class HelloApplication : Application() {
    override fun start(stage: Stage) {
        val fxmlLoader = FXMLLoader(HelloApplication::class.java.getResource("hello-view.fxml"))
        val scene = Scene(fxmlLoader.load(), 320.0, 240.0)
        stage.title = "Hello!"
        stage.scene = scene
        stage.show()
    }
}

fun main() {
   
}



