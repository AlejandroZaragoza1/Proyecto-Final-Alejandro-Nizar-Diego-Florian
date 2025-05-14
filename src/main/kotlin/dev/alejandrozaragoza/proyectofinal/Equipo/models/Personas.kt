package org.example.proyectojugadores.Equipo.models

import kotlinx.serialization.Serializable
import java.time.LocalDate
import java.time.LocalDateTime


open class Personas(
    val id: Long,
    var nombre: String,
    var apellido: String,
    var fechaNacimiento: LocalDate,
    var fechaIncorporacion: LocalDate,
    var salario: Double,
    var pais: String,
    val createdAt: LocalDateTime = LocalDateTime.now(),
    val updatedAt: LocalDateTime = LocalDateTime.now()
) {
    companion object{
        val NEW_ID = 1L
    }
}