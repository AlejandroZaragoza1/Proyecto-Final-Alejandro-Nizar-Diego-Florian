package dev.alejandrozaragoza.proyectofinal.Equipo.storage

import dev.alejandrozaragoza.proyectofinal.Equipo.error.PersonasError
import dev.alejandrozaragoza.proyectofinal.Equipo.mapers.toEntrenador
import dev.alejandrozaragoza.proyectofinal.Equipo.mapers.toJsonDto
import dev.alejandrozaragoza.proyectofinal.Equipo.mapers.toJugador
import kotlinx.serialization.encodeToString
import kotlinx.serialization.json.Json
import org.example.proyectojugadores.Equipo.dto.PersonasJsonDto
import org.example.proyectojugadores.Equipo.models.Entrenador
import org.example.proyectojugadores.Equipo.models.Jugador
import org.example.proyectojugadores.Equipo.models.Personas
import org.lighthousegames.logging.logging
import java.io.File

class PersonasStorageJson: PersonasStorage {
    private val logger = logging()

    init {
        logger.debug { "Iniciando almacenamientos JSON" }
    }

    override fun readFromFile(file: File, format: FileFormat): List<Personas> {
        logger.debug { "Leyendo personal de fichero JSON: $file" }
        if (!file.exists() || !file.isFile || !file.canRead() || file.length() == 0L || !file.name.endsWith(".json")) {
            logger.error { "El fichero no existe, o no es un fichero o no se puede leer: $file" }
            PersonasError.PersonasStorageException("El directorio padre del fichero no existe: ${file.parentFile.absolutePath}")
        }
        val json = Json { ignoreUnknownKeys = true }
        return json.decodeFromString<List<PersonasJsonDto>>(file.readText()).map {
            when(it.rol) {
                "Entrenador" -> it.toEntrenador()
                "Jugador" -> it.toJugador()
                else -> throw IllegalArgumentException("Tipo de persona erroneo: ${it.rol}")
            }
        }
    }
    override fun writeToFile(file: File, format: FileFormat, personasList: List<Personas>) {
        logger.debug { "Escribiendo personas en fichero JSON" }

        val file = File("buckup/personas.json")

        if (!file.parentFile.exists()) {
            file.parentFile.mkdirs()
        }

        val personasLista: List<PersonasJsonDto> = personasList.mapNotNull {
            when (it) {
                is Jugador -> it.toJsonDto()
                is Entrenador -> it.toJsonDto()
                else -> null
            }
        }
        val jsonToString: String = Json.encodeToString(personasLista)
        file.writeText(jsonToString)
    }
}