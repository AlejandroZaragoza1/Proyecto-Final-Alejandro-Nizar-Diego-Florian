package dev.alejandrozaragoza.proyectofinal.Equipo.storage

import org.example.proyectojugadores.Equipo.models.Personas
import java.io.File

interface PersonasStorageFile {
    fun readFromFile(file: File): List<Personas>


    fun writeToFile(personalList: List<Personas>)
}