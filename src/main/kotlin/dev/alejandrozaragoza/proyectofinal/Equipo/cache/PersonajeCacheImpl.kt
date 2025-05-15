package dev.alejandrozaragoza.proyectofinal.Equipo.cache

import com.github.benmanes.caffeine.cache.Cache
import com.github.benmanes.caffeine.cache.Caffeine
import dev.alejandrozaragoza.proyectofinal.Equipo.config.appConfig
import org.example.proyectojugadores.Equipo.models.Personas
import org.lighthousegames.logging.logging
import java.util.concurrent.TimeUnit

fun providePersonasCache(config: appConfig): Cache<Long, Personas> {
    val logger = logging()
    logger.debug { "Iniciando cache con capacidad ${config.cacheCapacity} y duracion ${config.cacheExpiration}" }
    return Caffeine.newBuilder()
        .maximumSize(config.cacheCapacity)
        .expireAfterWrite(
            config.cacheExpiration,
            TimeUnit.SECONDS
        )
        .build()
}































