package dev.alejandrozaragoza.proyectofinal.Equipo.service

import com.github.michaelbull.result.Ok
import com.github.michaelbull.result.Result
import dev.alejandrozaragoza.proyectofinal.Equipo.Repository.PersonasRepository
import dev.alejandrozaragoza.proyectofinal.Equipo.error.PersonasError
import org.example.proyectojugadores.Equipo.models.Personas
import org.lighthousegames.logging.logging
import com.github.benmanes.caffeine.cache.Cache
import com.github.michaelbull.result.Err

class PersonasServiceImpl(
    private val repository: PersonasRepository,
    private val cache: Cache<Long, Personas>
): PersonasService {
    private val logger = logging()

    override fun findAll(): Result<List<Personas>, PersonasError> {
        logger.debug { "findAll" }
        return Ok(repository.getAll())
    }

    override fun deleteAll(): Result<Unit, PersonasError> {
        logger.debug { "deleteAll" }
        repository.deleteAll().also {
            cache.invalidateAll()
            return Ok(Unit)
        }
    }

    override fun save(persona: Personas): Result<Personas, PersonasError> {
        logger.debug { "save" }
        val nuevaPersona = repository.save(persona)
        cache.put(nuevaPersona.id, nuevaPersona)
        logger.debug { "Persona salvada/actualizada: $nuevaPersona" }
        return Ok(nuevaPersona)
    }

    override fun deleteById(id: Long): Result<Unit, PersonasError> {
        logger.debug { "deleteById" }
        repository.deleteById(id)
        cache.invalidate(id)
        return Ok(Unit)
    }

    override fun findById(id: Long): Result<Personas, PersonasError> {
        logger.debug { "findById" }
        return cache.getIfPresent(id)?.let {
            Ok(it)
        } ?: repository.getById(id)?.also {
            cache.put(id, it)
        }?.let {
            Ok(it)
        } ?: Err(PersonasError.NotFound("Persona con ID $id no encontrada"))
    }



}