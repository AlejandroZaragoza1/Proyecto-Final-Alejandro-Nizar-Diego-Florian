package dev.alejandrozaragoza.proyectofinal.Equipo.dao

import java.time.LocalDate
import java.time.LocalDateTime

data class PersonasEntity(
    val id: Long,
    val nombre: String,
    val apellido: String,
    val fechaNacimiento: LocalDate,
    val fechaIncorporacion: LocalDate,
    val salario: Double,
    val pais: String,
    val rol: String,
    val posicion: String?,
    val dorsal: Int?,
    val peso: Double?,
    val goles: Int?,
    val partidos: Int?,
    val minutosJugados: Double?,
    val especialidad: String?,
    val createdAt: LocalDateTime,
    val updatedAt: LocalDateTime
)
