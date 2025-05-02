package dev.alejandrozaragoza.proyectofinal.Equipo.storage

import dev.alejandrozaragoza.proyectofinal.Equipo.error.PersonasError
import org.example.proyectojugadores.Equipo.models.Personas
import java.io.File
import com.github.michaelbull.result.Result

interface PersonasStorage {

    fun readFromFile(file: File, format: FileFormat): List<Personas>
    fun writeToFile(file: File, format: FileFormat, personasList: List<Personas>)
}
