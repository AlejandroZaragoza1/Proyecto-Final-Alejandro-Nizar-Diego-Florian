package org.example.proyectojugadores.Equipo.dto

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import org.example.proyectojugadores.Equipo.models.Personas

@Serializable
@SerialName("plantilla")
data class PlantillaCsvDto(
    @SerialName("Personas")
    val plantilla: List<PersonasCsvDto>
)
