package org.example.proyectojugadores.Equipo.models

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import java.time.LocalDate


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
    @Serializable
    enum class Especialidad {
        @SerialName("especialidad")
        ENTRENADOR_ASISTENTE, ENTRENADOR_PORTEROS, ENTRENADOR_PRINCIPAL
    }
    override fun toString(): String {
        return "Entrenador(id=$id, nombre='$nombre', apellido='$apellido', fechaNacimiento=$fechaNacimiento, fechaIncorporacion=$fechaIncorporacion, salario=$salario, paisOrigen='$pais', especialedad=$especialidad)"
    }
}