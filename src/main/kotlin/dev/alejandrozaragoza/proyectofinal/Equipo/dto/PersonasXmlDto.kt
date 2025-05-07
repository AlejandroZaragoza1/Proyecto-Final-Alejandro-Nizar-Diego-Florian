package org.example.proyectojugadores.Equipo.dto


import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import nl.adaptivity.xmlutil.serialization.XmlElement

@Serializable
@SerialName("personal")
data class PersonasXmlDto(
    @SerialName("id")
    @XmlElement(true)
    val id: Long,

    @SerialName("nombre")
    @XmlElement(true)
    val nombre: String,

    @SerialName("apellido")
    @XmlElement(true)
    val apellido: String,

    @SerialName("fecha_nacimiento")
    @XmlElement(true)
    val fechaNacimiento: String,

    @SerialName("fecha_incorporacion")
    @XmlElement(true)
    val fechaIncorporacion: String,

    @SerialName("salario")
    @XmlElement(true)
    val salario: Double = 0.0,

    @SerialName("pais")
    @XmlElement(true)
    val pais: String,

    @SerialName("tipo")
    @XmlElement(true)
    val tipo: String,

    @SerialName("posicion")
    @XmlElement(true)
    val posicion: String = "",

    @SerialName("dorsal")
    @XmlElement(true)
    val dorsal: String = "",

    @SerialName("altura")
    @XmlElement(true)
    val altura: String = "",

    @SerialName("peso")
    @XmlElement(true)
    val peso: String = "",

    @SerialName("goles")
    @XmlElement(true)
    val goles: String = "",

    @SerialName("partidos")
    @XmlElement(true)
    val partidos: String = "",

    @SerialName("minutos_jugados")
    @XmlElement(true)
    val minutosJugados: String = "",

    @SerialName("especialidad")
    @XmlElement(true)
    val especialidad: String = ""
)

