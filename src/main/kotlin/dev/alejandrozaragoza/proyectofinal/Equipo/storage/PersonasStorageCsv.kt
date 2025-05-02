package dev.alejandrozaragoza.proyectofinal.Equipo.storage

import dev.alejandrozaragoza.proyectofinal.Equipo.error.PersonasError
import dev.alejandrozaragoza.proyectofinal.Equipo.mapers.toEntrenador
import dev.alejandrozaragoza.proyectofinal.Equipo.mapers.toJugador
import org.example.proyectojugadores.Equipo.dto.PersonasCsvDto
import org.example.proyectojugadores.Equipo.models.Entrenador
import org.example.proyectojugadores.Equipo.models.Jugador
import org.example.proyectojugadores.Equipo.models.Personas
import org.lighthousegames.logging.logging
import java.io.File

class PersonasStorageCsv: PersonasStorage {
    private val logger = logging()

    init {
        logger.debug { "Iniciando almacenamiento Csv" }
    }

    override fun readFromFile(file: File, format: FileFormat): List<Personas> {
        logger.debug { "Leyendo personas de Fichero csv: $file" }
        if (!file.exists() || !file.isFile || !file.canRead() || file.length() == 0L || !file.name.endsWith(
        ".csv",
        true
        )
        ) {
            logger.error { "El fichero no existe, o no es un fichero o no se puede leer: $file" }
            PersonasError.PersonasStorageException("El directorio padre del fichero no existe: ${file.parentFile.absolutePath}")
        }
        return file.readLines()
            .drop(1)
            .map { it.split(",") }
            .map { it.map { it.trim() } }
            .map {
                val dto = PersonasCsvDto(
                    id = it[0].toLong(),
                    nombre = it[1],
                    apellido = it[2],
                    fechaNacimiento = it[3],
                    fechaIncorporacion = it[4],
                    salario = it[5].toDouble(),
                    pais = it[6],
                    rol = it[7],
                    posicion = it[8],
                    dorsal = it[9].toIntOrNull(),
                    altura = it[10].toDoubleOrNull(),
                    peso = it[11].toDoubleOrNull(),
                    goles = it[12].toIntOrNull(),
                    partidos = it[13].toIntOrNull(),
                    minutosJugados = it[14].toDoubleOrNull(),
                    especialidad = it[15],
                )
                when (dto.rol) {
                    "Entrenador" -> dto.toEntrenador()
                    "Jugador" -> dto.toJugador()
                    else -> throw IllegalArgumentException("Rol desconocido: ${dto.rol}")
                }
            }
    }

    override fun writeToFile(file: File, format: FileFormat, personas: List<Personas>) {
        logger.debug { "Escribiendo CSV" }

        if (!file.exists() || !file.canWrite() || !file.isFile) {
            logger.error { "El fichero no existe o no se puede escribir" }
            throw IllegalArgumentException("El fichero no existe o no se puede escribir")
        }

        file.bufferedWriter().use { writer ->
            writer.write("id,nombre,apellido,fechaNacimiento,fechaIncorporacion,salario,pais,rol,especialidad,posicion,dorsal,altura,peso,goles,partidos\n")
            personas.forEach { persona ->
                when (persona) {
                    is Entrenador -> {
                        writer.write("${persona.id},${persona.nombre},${persona.apellido},${persona.fechaNacimiento},${persona.fechaIncorporacion},${persona.salario},${persona.pais},Entrenador,${persona.especialidad},,,,\n")
                    }
                    is Jugador -> {
                        writer.write("${persona.id},${persona.nombre},${persona.apellido},${persona.fechaNacimiento},${persona.fechaIncorporacion},${persona.salario},${persona.pais},Jugador,${persona.posicion},${persona.dorsal},${persona.altura},${persona.peso},${persona.goles},${persona.partidos}, ${persona.minutosJugados}\n")
                    }
                }
            }
        }
    }
}