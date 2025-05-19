package dev.alejandrozaragoza.proyectofinal.Equipo.services

import com.github.benmanes.caffeine.cache.Cache
import com.github.michaelbull.result.Err
import com.github.michaelbull.result.Ok
import com.github.michaelbull.result.Result
import dev.alejandrozaragoza.proyectofinal.Equipo.cache.PersonajeCacheImpl
import dev.alejandrozaragoza.proyectofinal.Equipo.error.PersonasError
import dev.alejandrozaragoza.proyectofinal.Equipo.exception.PersonasException
import dev.alejandrozaragoza.proyectofinal.Equipo.repository.PersonasRepositoryImpl
import dev.alejandrozaragoza.proyectofinal.Equipo.storage.FileFormat
import dev.alejandrozaragoza.proyectofinal.Equipo.storage.PersonasStorage
import dev.alejandrozaragoza.proyectofinal.Equipo.storage.PersonasStorageCsv
import dev.alejandrozaragoza.proyectofinal.Equipo.storage.PersonasStorageJson
import dev.alejandrozaragoza.proyectofinal.Equipo.validator.PersonasValidator
import org.example.proyectojugadores.Equipo.models.Personas
import org.lighthousegames.logging.logging
import java.io.File


class PersonasServiceImpl(
    private val repository: PersonasRepositoryImpl,
    private val storage: PersonasStorage,
    private val storageCSV: PersonasStorageCsv,
    private val storageJSON: PersonasStorageJson,
    private val validator: PersonasValidator,
    private val cache: PersonajeCacheImpl<Long, Personas>,
    private val caches: Cache<Long, Personas>
): PersonasService {
    private val logger = logging()

    override fun findAll(): Result<List<Personas>, PersonasError> {
        logger.debug { "Obteniendo todas las personas" }
        return Ok(repository.findAll())
    }

    override fun deleteAll(): Result<Unit, PersonasError> {
        logger.debug { "Eliminar todas las personas" }
        repository.deleteAll().also {
            caches.invalidateAll()
            return Ok(it)
        }
    }

    override fun saveAll(personas: List<Personas>): Result<List<Personas>, PersonasError> {
        logger.debug { "Guardar todas las personas" }
        repository.saveAll(personas).also {
            caches.invalidateAll()
            return Ok(it)
        }
    }

    override fun save(personas: Personas): Result<Personas, PersonasError> {
        logger.debug { "Guardar persona" }
        repository.save(personas)?. id?.let {
            cache.put(it, personas)
            Ok(it)
        }
        return Ok(repository.save(personas))
    }

    override fun deleteById(id: Long): Result<Unit, PersonasError> {
        logger.debug { "Eliminar persona con id: $id" }
        repository.deleteById(id).also {
            caches.invalidate(id)
            return Ok(Unit)
        }
    }

    override fun update(id: Long, personas: Personas): Personas {
        logger.debug { "Actualizando persona con id: $id" }
        validator.validatorPer(personas)
        val actualizar: Personas? = repository.update(id, personas)
        if (actualizar == null){
            throw PersonasException.PersonasNotFoundException("Persona no encontrada con su id: $id")
        } else {
            cache.remove(id)
        }
        return actualizar
    }

    override fun readToFile(file: String, format: FileFormat): List<Personas> {
        logger.debug { "Leyendo fichero" }
        return storage.readFromFile(File(file), format)
    }

    override fun writeToFile(file: String, format: FileFormat, personas: List<Personas>) {
        logger.debug { "Escribiendo fichero" }
        storage.writeToFile(File(file), format, personas)
    }

    override fun findById(id: Long): Result<Personas, PersonasError> {
        logger.debug { "Obteniendo persona con id: $id" }
        return caches.getIfPresent(id)?.let {
            Ok(it)
        } ?: repository.findById(id)?.also{
            cache.put(id, it)
        }?.let {
            Ok(it)
        } ?: Err(PersonasError.PersonasNotFound("No se ha encontrado la persona con id: $id"))
    }
}