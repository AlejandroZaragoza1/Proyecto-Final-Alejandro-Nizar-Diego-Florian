package dev.alejandrozaragoza.proyectofinal.Equipo.services

import com.github.michaelbull.result.Result
import dev.alejandrozaragoza.proyectofinal.Equipo.error.PersonasError
import dev.alejandrozaragoza.proyectofinal.Equipo.storage.FileFormat
import org.example.proyectojugadores.Equipo.models.Personas
import java.io.File

interface PersonasService {
    fun findAll(): Result<List<Personas>, PersonasError>
    fun findById(id: Long): Result<Personas, PersonasError>
    fun deleteAll(): Result<Unit, PersonasError>
    fun saveAll(personas: List<Personas>): Result<List<Personas>, PersonasError>
    fun save(personas: Personas): Result<Personas, PersonasError>
    fun deleteById(id: Long): Result<Unit, PersonasError>
    fun update(id: Long, personas: Personas): Personas
    fun readToFile(file: String, format: FileFormat): List<Personas>
    fun writeToFile(file: String, format: FileFormat, personas: List<Personas>)
}