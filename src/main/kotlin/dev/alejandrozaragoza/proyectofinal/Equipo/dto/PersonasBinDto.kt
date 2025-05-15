package org.example.proyectojugadores.Equipo.dto

import kotlinx.serialization.SerialName

data class PersonasBinDto(
    val id: Long,
    val nombre: String,
    val apellido: String,
    val fechaNacimiento: String,
    val fechaIncorporacion : String,
    val salario : Double,
    val pais: String,
    val rol: String,
    val posicion: String,
    val dorsal: Int? = null,
    val altura: Double? = null,
    val peso: Double? = null,
    val goles: Int? = null,
    val partidos: Int? = null,
    val minutosJugados: Double? = null,
    val especialidad: String? = null
)
