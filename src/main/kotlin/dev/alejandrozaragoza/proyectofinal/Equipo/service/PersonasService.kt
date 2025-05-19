package dev.alejandrozaragoza.proyectofinal.Equipo.service

import dev.alejandrozaragoza.proyectofinal.Equipo.error.PersonasError
import org.example.proyectojugadores.Equipo.models.Personas
import com.github.michaelbull.result.Result

interface PersonasService {
    fun findAll(): Result<List<Personas>, PersonasError>
    fun deleteAll(): Result<Unit, PersonasError>

    fun save(persona: Personas): Result<Personas, PersonasError>
    fun deleteById(id: Long): Result<Unit, PersonasError>
    fun findById(id: Long): Result<Personas, PersonasError>
}
