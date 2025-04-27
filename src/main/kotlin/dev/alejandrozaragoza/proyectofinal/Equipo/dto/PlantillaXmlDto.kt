package org.example.proyectojugadores.Equipo.dto

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import nl.adaptivity.xmlutil.serialization.XmlElement

@Serializable
@SerialName("plantilla")
data class PlantillaDtoXml(
    @SerialName("personas")
    @XmlElement(true)
    val equipo: List<PersonasXmlDto>
)
