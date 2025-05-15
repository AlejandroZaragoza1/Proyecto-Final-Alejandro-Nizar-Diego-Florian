package dev.alejandrozaragoza.proyectofinal.Equipo.storage

import org.example.proyectojugadores.Equipo.models.Personas
import org.lighthousegames.logging.logging
import java.io.File

class PersonasStorageImpl(
    private val storageCsv: PersonasStorageCsv = PersonasStorageCsv(),
    private val storageJson: PersonasStorageJson = PersonasStorageJson(),
    private val storageXml: PersonasStorageXml = PersonasStorageXml(),
    private val storageBin: PersonasStorageBin = PersonasStorageBin()
    ): PersonasStorage {

        private val logger = logging()

    override fun readFromFile(file: File, format: FileFormat): List<Personas> {
        logger.debug { "Leyendo personal de fichero: $file" }
        return when (format) {
            format.JSON -> storageJson.readFromFile(file)
            format.CSV -> storageCsv.readFromFile(file)
            format.XML -> storageXml.readFromFile(file)
            format.DEFAULT -> storageJson.readFromFile(file) // Por defecto se asume JSON
        }
    }

    override fun writeToFile(file: File, format: FileFormat, personasList: List<Personas>) {
        logger.debug { "Escribiendo personal en fichero: $file" }
        when (format) {
            format.JSON -> storageJson.writeToFile(personasList)
            format.CSV -> storageCsv.writeToFile(personasList)
            format.XML -> storageXml.writeToFile(personasList)
            format.DEFAULT -> storageJson.writeToFile(personasList) // Por defecto se asume JSON
        }
    }
        }

