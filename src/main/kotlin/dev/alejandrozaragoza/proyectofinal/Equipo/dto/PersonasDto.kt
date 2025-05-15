package dev.alejandrozaragoza.proyectofinal.Equipo.dto

import java.time.LocalDate

class PersonasDto(
    val id: Long,
    val nombre: String,
    val apellido: String,
    val fechaNacimiento: LocalDate,
    val fechaIncorporacion: LocalDate,
    val salario: Double,
    val pais: String
)