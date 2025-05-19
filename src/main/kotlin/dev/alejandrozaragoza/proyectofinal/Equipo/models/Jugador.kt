package org.example.proyectojugadores.Equipo.models

import dev.alejandrozaragoza.proyectofinal.Equipo.dao.PersonasEntity
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import java.time.LocalDate
import java.time.LocalDateTime

class Jugador(
    id: Long,
    nombre: String,
    apellido: String,
    fechaNacimiento: LocalDate,
    fechaIncorporacion: LocalDate,
    salario: Double,
    pais: String,
    createdAt: LocalDateTime = LocalDateTime.now(),
    updatedAt: LocalDateTime = LocalDateTime.now(),
    var posicion: Posicion?,
    var dorsal: Int?,
    var altura: Double?,
    var peso: Double?,
    var goles: Int?,
    var partidos: Int?,
    var minutosJugados: Double?
): Personas(id, nombre, apellido, fechaNacimiento, fechaIncorporacion, salario, pais, createdAt, updatedAt) {
    @Serializable
    enum class Posicion {
        @SerialName("posicion")
        DEFENSA, CENTROCAMPISTA, DELANTERO, PORTERO, NINGUNO
    }

    override fun copy(
        id: Long,
        nombre: String,
        apellido: String,
        fechaNacimiento: LocalDate,
        fechaIncorporacion: LocalDate,
        salario: Double,
        pais: String,
        createdAt: LocalDateTime,
        updatedAt: LocalDateTime
    ): Personas {
        return this.copy()
    }
}
