package dev.alejandrozaragoza.proyectofinal.Equipo.config

import org.lighthousegames.logging.logging
import java.util.*


private val logger = logging()
object Config {
    var databaseUrl: String = "jdbc:sqlite:persona.db"
        private set
    var databaseInitTables: Boolean = false
        private set
    var databaseInitData: Boolean = false
        private set
    var storageData: String = "Data"
        private set
    var locale: String = Locale.getDefault().language

    init {
        try {
            logger.debug { "Cargando configuración" }
            val properties = Properties()
            properties.load(ClassLoader.getSystemResourceAsStream("config.properties"))
            databaseUrl = properties.getProperty("databaseUrl", this.databaseUrl)
            databaseInitTables = properties.getProperty("database.init.tables", this.databaseInitTables.toString()).toBoolean()
            databaseInitData = properties.getProperty("database.init.data", this.databaseInitData.toString()).toBoolean()
            storageData = properties.getProperty("storage.data", this.storageData)
            locale = properties.getProperty("locale", this.locale)
            logger.debug { "Configuración cargada correctamente" }
        } catch (e: Exception) {
            logger.error { "Error cargando configuración: ${e.message}" }
            logger.error { "Usando valores por defecto" }
        }
    }
}