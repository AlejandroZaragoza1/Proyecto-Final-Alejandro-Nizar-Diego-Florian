package dev.alejandrozaragoza.proyectofinal.Equipo.storage

import dev.alejandrozaragoza.proyectofinal.Equipo.error.PersonasError
import dev.alejandrozaragoza.proyectofinal.Equipo.mapers.toEntrenador
import dev.alejandrozaragoza.proyectofinal.Equipo.mapers.toJugador
import dev.alejandrozaragoza.proyectofinal.Equipo.mapers.toXmlDto
import nl.adaptivity.xmlutil.serialization.XML
import org.example.proyectojugadores.Equipo.dto.PersonasXmlDto
import org.example.proyectojugadores.Equipo.dto.PlantillaDtoXml
import org.example.proyectojugadores.Equipo.models.Entrenador
import org.example.proyectojugadores.Equipo.models.Jugador
import org.example.proyectojugadores.Equipo.models.Personas
import org.lighthousegames.logging.logging
import java.io.File


class PersonasStorageXml: PersonasStorage {
    private val logger = logging()

    init {
        logger.debug { "Iniciando almacenamiento xml" }
    }

    override fun readFromFile(file: File, format: FileFormat): List<Personas> {
        if (!file.exists() || !file.isFile || !file.canRead() || file.length() == 0L || !file.name.endsWith(
                ".xml",
                true
            )
        ) {
            logger.error { "El fichero no existe, o no es un fichero o no se puede leer: $file" }
            PersonasError.PersonasStorageException("El directorio padre del fichero no existe: ${file.parentFile.absolutePath}")
        }
        val xml = XML {}
        val xmlToString = file.readText()
        val personasXmlDto: PlantillaDtoXml = xml.decodeFromString(PlantillaDtoXml.serializer(), xmlToString)
        val personasList = personasXmlDto.equipo
        return personasList.map {
            when(it.tipo) {
                "Entrenador" -> it.toEntrenador()
                "Jugadore" -> it.toJugador()
                else -> throw IllegalArgumentException("Tipo de persona no coincide -> ${it.tipo}")
            }
        }
    }

    override fun writeToFile(file: File, format: FileFormat, personasList: List<Personas>) {
        logger.debug { "Escribiendo a xml..." }
        val file = File("buckup/personas.xml")
        file.parentFile.mkdirs()
        if (!file.parentFile.isDirectory || !file.name.endsWith(".xml", true)) {
            logger.error { "El directorio padre del fichero no es un directorio o el fichero no tiene extensión XML: ${file.parentFile.absolutePath}" }
            PersonasError.PersonasStorageException("El directorio padre del fichero no es un directorio o el fichero no tiene extensión XML: ${file.parentFile.absolutePath}")
        }
        val xml = XML { indent = 4 }
        val personasListDto: List<PersonasXmlDto> = personasList.map {
            when (it) {
                is Entrenador -> it.toXmlDto()
                is Jugador -> it.toXmlDto()
                else -> throw IllegalArgumentException("Tipo de Personal desconocido")
            }
        }
        val personalDto = PlantillaDtoXml(equipo = personasListDto)
        file.writeText(xml.encodeToString(PlantillaDtoXml.serializer(), personalDto))
    }
}