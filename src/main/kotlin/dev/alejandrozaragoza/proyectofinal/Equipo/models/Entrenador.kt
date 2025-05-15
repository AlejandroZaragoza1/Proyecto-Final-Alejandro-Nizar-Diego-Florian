package org.example.proyectojugadores.Equipo.models

import kotlinx.serialization.SerialName
import java.time.LocalDate
import java.time.LocalDateTime


class Entrenador(
    id: Long,
    nombre: String,
    apellido: String,
    fechaNacimiento:LocalDate,
    fechaIncorporacion: LocalDate,
    salario: Double,
    pais: String,
    val especialidad: Especialidad?
): Personas(id, nombre, apellido, fechaNacimiento, fechaIncorporacion, salario, pais) {

    enum class Especialidad {
        @SerialName("especialidad")
        ENTRENADOR_ASISTENTE, ENTRENADOR_PORTEROS, ENTRENADOR_PRINCIPAL
    }

    override fun toString(): String {
        return "Entrenador(id=$id, nombre='$nombre', apellido='$apellido', fechaNacimiento=$fechaNacimiento, fechaIncorporacion=$fechaIncorporacion, salario=$salario, paisOrigen='$pais', especialedad=$especialidad)"
    }
}