package org.example.proyectojugadores.Equipo.dto

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class PersonasCsvDto(

    @SerialName("id")
    val id: Long,

    @SerialName("nombre")
    val nombre: String,

    @SerialName("apellido")
    val apellido: String,

    @SerialName("fecha_nacimiento")
    val fechaNacimiento: String, // Normalmente fechas en CSV se ponen como String (luego parseas a LocalDate)

    @SerialName("fecha_incorporacion")
    val fechaIncorporacion: String,

    @SerialName("salario")
    val salario: Double,

    @SerialName("pais")
    val pais: String,

    @SerialName("rol")
    val rol: String,

    @SerialName("createAt")
    val createAt: String,

    @SerialName("updatedAt")
    val updatedAt: String,

    @SerialName("posicion")
    val posicion: String? = null, // Solo si es Jugador, nullable

    @SerialName("dorsal")
    val dorsal: Int? = null,

    @SerialName("altura")
    val altura: Double? = null,

    @SerialName("peso")
    val peso: Double? = null,

    @SerialName("goles")
    val goles: Int? = null,

    @SerialName("partidos")
    val partidos: Int? = null,

    @SerialName("minutosJugados")
    val minutosJugados: Double? = null,

    @SerialName("especialidad")
    val especialidad: String? = null
)
