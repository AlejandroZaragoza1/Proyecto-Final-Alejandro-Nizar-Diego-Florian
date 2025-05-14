package dev.alejandrozaragoza.proyectofinal.Equipo.storage

import dev.alejandrozaragoza.proyectofinal.Equipo.mapers.toBinDto
import dev.alejandrozaragoza.proyectofinal.Equipo.mapers.toEntrenador
import dev.alejandrozaragoza.proyectofinal.Equipo.mapers.toJugador
import org.example.proyectojugadores.Equipo.models.Personas



import org.example.proyectojugadores.Equipo.dto.PersonasBinDto
import org.example.proyectojugadores.Equipo.models.Entrenador
import org.example.proyectojugadores.Equipo.models.Jugador
import org.lighthousegames.logging.logging
import java.io.File
import java.io.RandomAccessFile
import java.lang.IllegalArgumentException

/**
 * Almacenamiento de personas en Bin
 * Esta clase implementa la interfaz [PersonasStorageFile] para almacenar y leer personas (Entrenador o Jugador) en un fichero Bin.
 */
class PersonasStorageBin : PersonasStorage {
    private val logger = logging()

    init {
        logger.debug { "Inicializando almacenamiento de personas en Bin" }
    }

    /**
     * Lee las personas (Entrenador o Jugador) de un fichero Bin
     * @param file Fichero Bin
     * @return Lista de personas
     * @throws IllegalArgumentException Si el fichero no es accesible o tiene un formato incorrecto
     */
    override fun readFromFile(file: File): List<Any> {
        logger.debug { "Leyendo personas de fichero Bin: $file" }

        if (!file.exists() || !file.isFile || !file.canRead() || file.length() == 0L || !file.name.endsWith(".bin", true)) {
            logger.error { "El fichero no existe, o no es un fichero o no se puede leer: $file" }
            throw IllegalArgumentException("El fichero no existe, o no es un fichero o no se puede leer: $file")
        }

        val personas = mutableListOf<PersonasBinDto>()

        RandomAccessFile(file, "r").use { raf ->
            while (raf.filePointer < raf.length()) {
                val id = raf.readLong()  // Lee el id, que es un Long en 8 bytes
                val nombre = raf.readUTF()
                val apellido = raf.readUTF()
                val fechaNacimiento = raf.readUTF()
                val fechaIncorporacion = raf.readUTF()
                val salario = raf.readDouble()
                val pais = raf.readUTF()
                val rol = raf.readUTF()
                val posicion = raf.readUTF()
                val dorsal = raf.readInt()
                val altura = raf.readDouble()
                val peso = raf.readDouble()
                val goles = raf.readInt()
                val partidos = raf.readInt()
                val minutosJugados = raf.readDouble()
                val especialidad = raf.readUTF()

                val persona = PersonasBinDto(
                    id, nombre, apellido, fechaNacimiento, fechaIncorporacion,
                    salario, pais, rol, posicion, dorsal, altura, peso,
                    goles, partidos, minutosJugados, especialidad
                )

                personas.add(persona)
            }
        }

        // Convertir a Entrenador o Jugador según el rol
        return personas.map {
            when (it.rol.lowercase()) {
                "entrenador" -> it.toEntrenador()
                "jugador" -> it.toJugador()
                else -> throw IllegalArgumentException("Rol no reconocido: ${it.rol}")
            }
        }
    }

    /**
     * Escribe las personas (Entrenador o Jugador) en un fichero Bin
     * @param personas Lista de personas (Entrenadores y Jugadores)
     * @param file Fichero bin
     * @throws IllegalArgumentException Si el directorio del fichero no existe o no es un fichero bin
     */
    override fun writeToFile(personas: List<Personas>, file: File) {
        logger.debug { "Escribiendo personas en fichero Bin: $file" }

        if (!file.parentFile.exists() || !file.parentFile.isDirectory || !file.name.endsWith(".bin", true)) {
            logger.error { "El directorio padre del fichero no existe: ${file.parentFile.absolutePath}" }
            throw IllegalArgumentException("El directorio padre del fichero no existe: ${file.parentFile.absolutePath}")
        }

        RandomAccessFile(file, "rw").use { raf ->
            raf.setLength(0) // Limpiar el archivo antes de escribir

            for (persona in personas) {
                val personaDto = when (persona) {
                    is Entrenador -> persona.toBinDto()
                    is Jugador -> persona.toBinDto()
                    else -> throw IllegalArgumentException("Tipo de persona no reconocido: $persona")
                }

                // Escribir datos binarios en el archivo
                raf.writeLong(personaDto.id)
                raf.writeUTF(personaDto.nombre)
                raf.writeUTF(personaDto.apellido)
                raf.writeUTF(personaDto.fechaNacimiento)
                raf.writeUTF(personaDto.fechaIncorporacion)
                raf.writeDouble(personaDto.salario)
                raf.writeUTF(personaDto.pais)
                raf.writeUTF(personaDto.rol)
                raf.writeUTF(personaDto.posicion)
                raf.writeInt(personaDto.dorsal ?: 0)
                raf.writeDouble(personaDto.altura ?: 0.0)
                raf.writeDouble(personaDto.peso ?: 0.0)
                raf.writeInt(personaDto.goles ?: 0)
                raf.writeInt(personaDto.partidos ?: 0)
                raf.writeDouble(personaDto.minutosJugados ?: 0.0)
                raf.writeUTF(personaDto.especialidad ?: "")
            }
        }
    }
}
