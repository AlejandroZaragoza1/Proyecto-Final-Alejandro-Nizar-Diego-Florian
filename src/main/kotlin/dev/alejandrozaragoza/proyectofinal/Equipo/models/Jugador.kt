package org.example.proyectojugadores.Equipo.models

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import java.time.LocalDate

class Jugador(
    id: Long,
    nombre: String,
    apellido: String,
    fechaNacimiento: LocalDate,
    fechaIncorporacion: LocalDate,
    salario: Double,
    pais: String,
    val posicion: Posicion?,
    val dorsal: Int?,
    var altura: Double?,
    var peso: Double?,
    var goles: Int?,
    var partidos: Int?,
    var minutosJugados: Double?
): Personas(id, nombre, apellido, fechaNacimiento, fechaIncorporacion, salario, pais) {
    @Serializable
    enum class Posicion {
        @SerialName("posicion")
        DEFENSA, CENTROCAMPISTA, DELANTERO, PORTERO, NINGUNO
    }
}