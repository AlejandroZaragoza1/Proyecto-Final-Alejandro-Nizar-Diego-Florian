package org.example.proyectojugadores.Equipo.models

import kotlinx.serialization.Serializable
import java.time.LocalDate

@Serializable
open class Personas(
    val id: Long,
    var nombre: String,
    var apellido: String,
    var fechaNacimiento: LocalDate,
    var fechaIncorporacion: LocalDate,
    var salario: Double,
    var pais: String,
) {
    companion object{
        val NEW_ID = 1L
    }
}