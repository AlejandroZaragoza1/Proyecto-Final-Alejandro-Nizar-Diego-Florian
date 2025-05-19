package org.example.proyectojugadores.Equipo.models

import dev.alejandrozaragoza.proyectofinal.Equipo.dao.PersonasEntity
import java.time.LocalDate
import java.time.LocalDateTime


abstract class Personas(
    val id: Long,
    val nombre: String,
    val apellido: String,
    val fechaNacimiento: LocalDate,
    val fechaIncorporacion: LocalDate,
    val salario: Double,
    val pais: String,
    val createdAt: LocalDateTime = LocalDateTime.now(),
    val updatedAt: LocalDateTime = LocalDateTime.now()
) {

    companion object{
        val NEW_ID = 1L
    }
    val isNewPersona: Boolean
        get() = id == NEW_ID


    abstract fun copy(
        id: Long = this.id,
        nombre: String = this.nombre,
        apellido: String = this.apellido,
        fechaNacimiento: LocalDate = this.fechaNacimiento,
        fechaIncorporacion: LocalDate = this.fechaIncorporacion,
        salario: Double = this.salario!!,
        pais: String = this.pais,
        createdAt: LocalDateTime = this.createdAt,
        updatedAt: LocalDateTime = this.updatedAt

    ): Personas
}
