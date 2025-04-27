package org.example.proyectojugadores.Equipo.models

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import java.time.LocalDate

@Serializable
class Entrenador(
    id: Long,
    nombre: String,
    apellido: String,
    fechaNacimiento:LocalDate,
    fechaIncorporacion: LocalDate,
    salario: Double,
    pais: String,
    var especialedad: Especialidad?
): Personas(id, nombre, apellido, fechaNacimiento, fechaIncorporacion, salario, pais) {
    @Serializable
    enum class Especialidad {
        @SerialName("especialidad")
        ENTRENADOR_ASISTENTE, ENTRENADOR_PORTEROS, ENTRENADOR_PRINCIPAL
    }
}