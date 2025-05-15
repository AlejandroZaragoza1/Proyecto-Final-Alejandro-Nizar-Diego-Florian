package dev.alejandrozaragoza.proyectofinal.Equipo.config

import org.lighthousegames.logging.logging
import java.io.InputStream
import java.util.*

private val logger = logging()

private const val CONFIG_FILE_NAME = "config.properties"

object appConfig {

    val databaseUrl: String by lazy {
        readProperty("database.url") ?: "jdbc:h2:mem:test;DB_CLOSE_DELAY=-1"
    }

    val cacheCapacity: Long by lazy {
        readProperty("cache.capacity")?.toLong() ?: 10L
    }

    val cacheExpiration: Long by lazy {
        readProperty("cache.expiration")?.toLong() ?: 60L
    }

    val databaseInitTables: Boolean by lazy {
        readProperty("database.init.tables")?.toBoolean() ?: false
    }

    val databaseInitData: Boolean by lazy {
        readProperty("database.init.data")?.toBoolean() ?: false
    }

    private fun readProperty(propiedad: String): String? {
        return try {
            logger.debug { "Leyendo propiedad: $propiedad" }
            val properties = Properties()
            val inputStream: InputStream = ClassLoader.getSystemResourceAsStream(CONFIG_FILE_NAME)
                ?: throw Exception("No se puede leer el fichero de configuración $CONFIG_FILE_NAME")
            properties.load(inputStream)
            properties.getProperty(propiedad)
        } catch (e: Exception) {
            logger.error { "Error al leer la propiedad $propiedad: ${e.message}" }
            null
        }
    }

}